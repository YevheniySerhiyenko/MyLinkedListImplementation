import java.util.Collection;


import static java.util.Collections.addAll;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
=======
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
    private int index;


    public MyLinkedListImpl() {
        //    конструктор по умолчанию
    }

    //    конструктор для преобразования коллекции в LinkedList
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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node(T element) {
            this.element = element;
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
    public boolean equals(Object o) {
        return (this == o);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
     public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index");
        } else if (index == size) {
            add(element);
        } else {
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
    public void deleteFirst() {

        if (first.next == null){
            last = null;
        }else{
            first.next.prev = null;
        }
        first = first.next;
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
    public void addFirst(Object o) {
        Node f = first;
        Node newNode = new Node(o);
        newNode.prev = null;
        newNode.next = f;
        first = newNode;
        if (f == null){
            last = newNode;
        }
        else{
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object o) {
    }

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

    public void set(int index, Object element) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node current = first;
        for (int i = 0; i <= (index - 1); i++) {
            current = current.next;
        }
        current.element = element;
    }


    @Override
    public void clear() {
        for (Node<T> node = first; node != null; ) {
            Node<T> next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }
  @Override
      public int indexOf(Object o) {
        return 0;
    }

    @Override
   public T extract() {
        Node<T> firstNode = first;

        return (firstNode == null) ? null : firstNode.item;
    }

    @Override
   public T extractAndDelete() {
   }
   @Override
    public boolean hasNext() {
        index = size;
        for (Node<T> node = last; node != null; node = node.prev) {
            index--;
            if (node.item == null) {
                break;
            }
        }
        return index < size;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkedListImpl.Node x = first; x != null; x = x.next)
        { result[i++] = x.element;}
        return result;
    }

    public void set(T o) {
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

}

