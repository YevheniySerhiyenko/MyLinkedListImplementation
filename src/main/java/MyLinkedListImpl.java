import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static java.util.Collections.addAll;


public class MyLinkedListImpl<T> implements MyLinkedList<T> {

    // head
    private Node<T> first;

    // tail
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

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(T o) {
        Node<T> node = this.last;
        Node<T> newNode = new Node(node, o, null);
        this.last = newNode;
        if (first == null) {
            this.first = newNode;
        } else {
            node.next = newNode;
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
    public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index");
        }

        if (index == size)
            add(element);
        else {
            Node<T> pred = getNode(index).prev;
            Node<T> newNode = new Node<T>(pred, element, getNode(index));
            getNode(index).prev = newNode;
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            size++;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> node;
        if (index < (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
        }
        return node;
    }

    @Override
    public void sort() {

    }

    @Override
    public MyLinkedList<T> concat(MyLinkedList newLinkedList) {
        return null;
    }

    @Override
    public boolean delete(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index");
        }

        Node<T> node = getNode(index);
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;

        return true;
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
        Node<T> firstNode = first;
        if (firstNode == null) {
            throw new NoSuchElementException();
        }

        return firstNode.item;
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
        Node<T> lastNode = last;
        if (lastNode == null) {
            throw new NoSuchElementException();
        }

        T element = lastNode.item;
        Node<T> prev = lastNode.prev;
        lastNode.item = null;
        lastNode.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return element;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void addFirst(T o) {

    }

    @Override
    public void addLast(T element) {
        add(element);
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public T set(int index, T element) {
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

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void set(T o) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
