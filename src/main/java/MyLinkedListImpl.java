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
	if(size == 0) return null;
	
	if(index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException("Index = " + index + ", List size = " + size);
	}
	Node<T> temp = first;
	if(index < size / 2) {
	    for(int i = index; i != 0; i--) {
		temp = temp.next;
	    }	     
	} else {
	    temp = last;
	    for(int i = size - 1; i != index; i--) {
		temp = temp.prev;
	    }	
	}
	return temp.data;
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
        return last.data;
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
	if(first == null) return false;
	Node<T> temp = first;
	if(o == null) {
	    while(temp != null) {
		if(temp.data == null) {
		    return true;
		}
		temp = temp.next;
	    }
	}
	else {
	    while(temp != null) {	
		if(temp.data != null && o.getClass() != temp.data.getClass()) return false;
		if(o.equals(temp.data)) {
		    return true;
		}
		temp = temp.next;
	    }
	}
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
	if(size == 0) return false;
	Node<T> temp = first;
	if(o == null) {
	    if(first.data == null) {
		first = first.next;
		first.prev = null;
		size--;
		return true;
	    }
	    while(temp.next != null) {
		if(temp.data == null) {
		    temp.next.prev = temp.prev;		    
		    temp.prev.next = temp.next;
		    size--;
		    return true;
		}
		temp = temp.next;
	    }
	    if(temp.data == null) {
		last = temp.prev;
		last.next = null;
		size--;
		return true;
	    }
	} else {
	    if(o.equals(first.data)) {
		first = first.next;
		first.prev = null;
		size--;
		return true;
	    }
	    temp = temp.next;
	    while(temp.next != null) {
		if(temp.data != null && o.getClass() != temp.data.getClass()) {
		    return false; 
		} 
		if(o.equals(temp.data)) {
		    temp.next.prev = temp.prev;		    
		    temp.prev.next = temp.next;
		    size--;
		    return true;
		}
		temp = temp.next;
	    }
	    if(o.equals(temp.data)) {
		last = temp.prev;
		last.next = null;
		size--;
		return true;
	    }
	}
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
	int index = 0;
	if(first == null) return -1;
	if(o == null) {
	    for(Node<T> temp = first; temp != null; temp = temp.next) {
		if(temp.data == null) return index;
		index++;
	    }
	}
	else {
	    for(Node<T> temp = first; temp != null; temp = temp.next) {
	    if(temp.data != null && o.getClass() != temp.data.getClass()) return -1;
		if(o.equals(temp.data)) return index;
		index++;
	    }
	}
	return -1;
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
	if(size == 0) return null;
	Node<T> temp = first;
	if(size == 1) {
	    first = null;
	} else {
	first = temp.next;
	first.prev = null;
	}
	size--;
	return temp.data;
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
	MyLinkedListImpl<T> temp = new MyLinkedListImpl<>();
	Node<T> tNode = this.first;
	for(int i = 0; i < fromIndex; i++) {
	    tNode = tNode.next;
	}
	for(int i = fromIndex; i < toIndex; i++) {
	    temp.add(tNode.data);
	    tNode = tNode.next;
	}
	return temp;
    }
    
    @Override
    public MyLinkedList<T> reverse() {
	Node<T> begin = first;
	Node<T> end = last;
//	Node<T> temp = begin;
//	T begin = first.data;
//	T end = last.data;
	
	for(int i = 0; i < size / 2; i++) {
	    T temp = begin.data;
	    begin.data = end.data;
	    end.data = temp;
	    begin = begin.next;
	    end = end.prev;
	}
	return this;
    }


}
