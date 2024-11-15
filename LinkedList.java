import java.util.NoSuchElementException;

public class LinkedList {
    // we make node as a internal class
    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }

    }
    private Node first;
    private Node last;
    private int size = 0;


    //functions in my linkedlist
    public void addlast(int item){
        var node = new Node(item);
        if (isEmpty())first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }
    public void addfirst(int item){
        var node = new Node(item);
        if (isEmpty()) first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    private boolean isEmpty(){
        return first == null;
    }
    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(first != null){
            if (item == current.value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
    public boolean contains(int item){

        var current =  first;
        while(current != null){
            if (current.value == item )return true;
            current = current.next;
        }
        return false;
    }
    public void removefirst(){
        // second referenses
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }
    public void removelast(){
        if (first == null) throw new NoSuchElementException();
        if (first == last){
            first = last = null;
            size--;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;
    }
    private Node getPrevious(Node node){
        var current = first;
        while(current != null){
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }
    public int size(){
        return size;
    }
    public int[] toArray(LinkedList linkedList){
        int[] arr = new int[size];
        var current = first;
        int index = 0;
        /*mekath hari habai meka godk hari
        for (int i=0;i<size;i++){
            arr[i] = current.value;
            current = current.next;
        }*/
        while  (current!= null){
            arr[index] = current.value;
            index++;
            current = current.next;
        }
        return arr;
    }
    public void reverse(){
        if (isEmpty()) return;
        //  f               l
        // 10->20->30->40->50
        //                  p   c   n
        var current = first.next;
        var previous = first;

        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;


    }
    public int getKthFromTheEnd(int k){
        if (isEmpty()) throw new NoSuchElementException();
        if (k >size || k < 1 ) throw new IllegalArgumentException();
        var a = first;
        var b = first;
        for(int i = 0; i < k-1; i++ ) b = b.next;

        while(b != last) {
            a = a.next;
            b = b.next;
        }
        return  a.value;
    }
}
