import java.util.Comparator;
import java.util.ListIterator;


public interface MyLinkedList<T> {

    void add(T t); //1 +

    void add(int index, T element); //2

    public <T extends Comparable<T>> void sort(); //3
    
    public void sort(Comparator c);

    void concat(MyLinkedList<T> newLinkedList); // вместо метода addAll(); //4

    boolean delete(int index); //5

    T get(int index); //6

    int size(); //7 +

    T getFirst(); //8

    T getLast(); //9

    void deleteFirst();//10

    T deleteLast();//11

    boolean contains(Object o); //12

    void addFirst(T t); //13

    void addLast(T t); //14

    boolean delete(Object o); //15

    void set(int index, T element); //16

    void clear(); //17

    int indexOf(Object o); //18

    T extract(); // peek(); 20

    T extractAndDelete(); //poll(); //21

    boolean hasNext(); //23

    boolean hasPrevious(); //24

  int nextIndex(); //25

//    int previousIndex(); //26

//    void set(T t); //27

    int previousIndex(); //26

    Object[] toArray(); //28

    @Override
    boolean equals(Object o); //29

    @Override
    String toString(); //30

    @Override
    int hashCode(); //31
    
    public MyLinkedList<T> subList(int fromIndex, int toIndex);
    
    public MyLinkedList<T> reverse();

    void print();
}
