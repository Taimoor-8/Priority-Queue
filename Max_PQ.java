package com.Priority_Queue_Or_Heap;

public class Max_PQ {
    int[]heap;
    int n; // size of maximum heap
    Max_PQ(int capacity){
        heap = new int[capacity + 1]; // index 0 is kept empty so capacity+1 is taken
        n =0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void display(){
        for (int i=1; i<n+1; i++){
            System.out.print(heap[i] + " ");
        }
    }

    public void insert(int x){
        if (n == heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }
    
    private void resize(int capacity){
        int[] temp = new int[capacity];
//        for coping one array to another by pre-defined methode
//        if (heap.length - 1 >= 0) System.arraycopy(heap, 0, temp, 0, heap.length - 1);
        for (int i=0; i<heap.length-1; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swim(int k) {
        while(k>1 && heap[k/2] < heap[k]){
            swap(k ,k/2);
            k = k/2;
        }
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        if (n<(heap.length-1)/4){
            resize(heap.length/2);
        }
        return max;
    }

    private void sink(int a) {
        while (2*a < n){
            int j = 2*a;
            if (j<n && heap[j] < heap[j+1]){
                j++;
            }
            if (heap[a]>=heap[j]){
                break;
            }
            swap(a,j);
            a = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        Max_PQ m = new Max_PQ(6);
//        System.out.println(m.isEmpty());
//        System.out.println(m.size());

        m.insert(4);
        m.insert(6);
        m.insert(8);
        m.insert(9);
        m.insert(3);
        m.insert(1);

        System.out.println(m.size());
        m.display();
        System.out.println();

        System.out.println(m.deleteMax());
        System.out.println(m.size());
        m.display();
    }
}
