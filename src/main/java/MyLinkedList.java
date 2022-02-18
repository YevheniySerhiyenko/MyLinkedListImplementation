import java.util.Comparator;
import java.util.ListIterator;


public interface MyLinkedList<T> {

    void add(T t);

    void add(int index, T element);

    <T extends Comparable<T>> void sort();
    
    void sort(Comparator c);

    void concat(MyLinkedList<T> newLinkedList);

    boolean delete(int index);

    T get(int index);

    int size();

    T getFirst();

    T getLast();

    void deleteFirst();

    T deleteLast();

    boolean contains(Object o);

    void addFirst(T t);

    void addLast(T t);

    boolean delete(Object o);

    void set(int index, T element);

    T extractAndDelete();

    void clear(); //17

    int indexOf(Object o);

    T extract();

    int previousIndex();

    int nextIndex();

    boolean hasNext();

    Object[] toArray();

    boolean equals(Object o);

    String toString();

    int hashCode();
    
    MyLinkedList<T> subList(int fromIndex, int toIndex);
    
    MyLinkedList<T> reverse();

    void print();
}
