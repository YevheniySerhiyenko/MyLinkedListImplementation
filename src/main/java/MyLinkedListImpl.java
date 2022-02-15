import static java.util.Collections.addAll;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;


public class MyLinkedListImpl<T> implements MyLinkedList<T> {


    private Node<T> first;
    private Node<T> last;
    private int size;

    //    конструктор по умолчанию
    public MyLinkedListImpl() {
    }

    //    конструктор для преобразования коллекции в LinkedList
//    думаю что можно реализовать как то по другому
    public MyLinkedListImpl(Collection<? extends T> c) {
        this();
        addAll(c);
    }
    private class Node<T> {
        private Node<T> prev;
        private T data;
        private Node<T> next;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(Object o) {
        Node node = this.last;
        Node newNode = new Node(node,o,null);
        this.last = newNode;
        if (first == null){ this.first = newNode; }
        else{ node.next = newNode; }
        size++;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("[");
	Node<T> temp = first;
	if(temp != null) {
	    while(temp.next != null) {
		sb.append(temp.data + ", ");
		temp = temp.next;
	    }
	    sb.append(temp.data);
	}
	return sb.append("]").toString();
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public <T extends Comparable<T>> void sort() {
	
	int s = this.size();
	Node temp = this.first;
	Object[] arr = new Object[s];
	
	for(int i = 0; i < s; i++) {
	    arr[i] = temp.data;
	    temp = temp.next;
	}
	Arrays.sort(arr);
	temp = this.first;
	for(int i = 0; i < s; i++) {
	    temp.data = arr[i];
	    temp = temp.next;
	}
    }

    @Override
    public MyLinkedList<T> concat(MyLinkedList newLinkedList) {
        return null;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T deleteFirst() {
        return null;
    }

    @Override
    public T deleteLast() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void addFirst(Object o) {

    }

    @Override
    public void addLast(Object o) {

    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public T extract() {
        return null;
    }

    @Override
    public T extractAndDelete() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

//    @Override
//    public int previousIndex() {
//        return 0;
//    }

//    @Override
//    public void set(Object o) {
//
//    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void sort(Comparator c) {
	int s = this.size();
	Node temp = this.first;
	Object[] arr = new Object[s];
	
	for(int i = 0; i < s; i++) {
	    arr[i] = temp.data;
	    temp = temp.next;
	}
	Arrays.sort(arr, c);
	temp = this.first;
	for(int i = 0; i < s; i++) {
	    temp.data = arr[i];
	    temp = temp.next;
	}
    }

    @Override
    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public MyLinkedList<T> reverse() {
	// TODO Auto-generated method stub
	return null;
    }


}
