import java.util.ListIterator;

public interface MyLinkedList<T> {

    void add(T t);

    void add(int index, T element);

    void sort();

    MyLinkedList<T> concat(MyLinkedList<T> newLinkedList); // вместо метода addAll();

    boolean delete(int index);

    T get(int index);

    int size();

    T getFirst();

    T getLast();

    T deleteFirst();

    T deleteLast();

    boolean contains(Object o);

    void addFirst(T t);

    void addLast(T t);

    boolean delete(Object o);

    T set(int index, T element);

    void clear();

    int indexOf(Object o);

    int lastIndexOf(Object o);

    T extract(); // peek();

    T extractAndDelete(); //poll();

    ListIterator<T> listIterator(int index);

    boolean hasNext();

    boolean hasPrevious();

    int nextIndex();

    int previousIndex();

    void set(T t);

    Object[] toArray();

    boolean equals(Object o);

    String toString();

    int hashCode();




}
