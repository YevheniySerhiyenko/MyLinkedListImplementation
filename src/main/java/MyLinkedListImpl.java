import java.util.Collection;

import static java.util.Collections.addAll;

// no package declaration
public class MyLinkedListImpl<T> implements MyLinkedList {

    private Node first;
    private Node last;
    private int size;


    public MyLinkedListImpl() {
        //    конструктор по умолчанию
    }

    //    конструктор для преобразования коллекции в LinkedList
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
        Node newNode = new Node(o);
        if (size == 0){
            first = last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
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
        //метод для добавления элемента по индексу
    }

    @Override
    public void sort() {
        //метод для сортировки
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
    public void deleteFirst() {
        Node node = first;

        if (first.next == null){
            last = null;
        }else{
            first.next.prev = null;
        }
        first = first.next;
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
        Node f = first;
        Node newNode = new Node(o);
        newNode.prev = null;
        newNode.next = f;
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    @Override
    public void addLast(Object o) {
    //метод для добавления элемента в конец
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public void set(int index, Object element) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node newNode = new Node(element);
        Node current = first;
        for (int i = 0; i <= (index - 1); i++) {
            current = current.next;
        }
        current.element = element;

    }

    @Override
    public void clear() {
        //метод для очистки списка
    }

    @Override
    public int indexOf(Object o) {
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
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public int previousIndex() {
        return 0;
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
