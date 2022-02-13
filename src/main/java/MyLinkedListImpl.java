import java.util.Collection;
import java.util.ListIterator;

import static java.util.Collections.addAll;


public class MyLinkedListImpl<T> implements MyLinkedList {


    private Node first;
    private Node last;
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
    private class Node {
        private Object element;
        private Node prev;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }



        public Node(Object element) {
            this.element = element;
        }
    }

    @Override
    public void add(Object o) {
        if(first == null) {
            this.first = new Node(o);
        } else {
            Node node = first;
            while (node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(new Node(o));
        }
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
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void concat(MyLinkedList newLinkedList) {
        Node current = first;
        Object[] array = newLinkedList.toArray();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        for(Object t : array) {
            current.setNext(new Node(t));
            current = current.getNext();
        }
        size += array.length;
    }
    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object deleteFirst() {
        Node node = first;

        if (first.next == null){
            last = null;
        }else{
            first.next.prev = null;
        }
        first = first.next;
        return null;
    }

    @Override
    public Object deleteLast() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void addFirst(Object o) {
        Node node = new Node(o);
        if (isEmpty())
            last = node;
        else
            first.prev = node;

        node.next = first;
        first = node;
        size++;
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
        Node node = first;
        Node setNode = new Node(element);
        int i = 0;
        while (i <= index){
            node = node.getNext();
            i++;
        }
            delete(node);
            Node temp = node.next;
            node.next = setNode;
            setNode.next = temp;

        return setNode.element;

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
    public Object extract() {
        return null;
    }

    @Override
    public Object extractAndDelete() {
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

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void set(Object o) {

    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkedListImpl.Node x = first; x != null; x = x.next)
            result[i++] = x.element;
        return result;
    }

    private boolean isEmpty(){
        return first == null;
    }

    @Override
    public void print(){
        Node node = first;
        while (node != null){
            System.out.print(node.element + " ");
            node = node.next;
        }
    }

    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

}
