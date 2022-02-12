import javax.xml.soap.Node;
import java.util.Collection;
import java.util.ListIterator;
import java.util.stream.Collectors;

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
    public void add(Object o) {

    }

    @Override
    public void add(int index, Object element) {

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
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
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
        return new Object[0];
    }
}
