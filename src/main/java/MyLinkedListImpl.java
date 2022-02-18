import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
        concat((MyLinkedList<T>) c);
    }

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;


        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node(T element) {
            this.item = element;
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
    public boolean equals(Object o) {
        return (this == o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = first;
        if (temp != null) {
            while (temp.next != null) {
                sb.append(temp.item + ", ");
                temp = temp.next;
            }
            sb.append(temp.item);
        }
        return sb.append("]").toString();
    }

    // метод для добавления элемента
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
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

    // метод для сортировки
    @Override
    public <T extends Comparable<T>> void sort() {

        int s = this.size();
        Node<T> temp = (Node<T>) this.first;
        Object[] arr = new Object[s];

        for (int i = 0; i < s; i++) {
            arr[i] = temp.item;
            temp = temp.next;
        }
        Arrays.sort(arr);
        temp = (Node<T>) this.first;
        for (int i = 0; i < s; i++) {
            temp.item = (T) arr[i];
            temp = temp.next;
        }
    }

    // метод для склейки двух LinkedList
    @Override
    public void concat(MyLinkedList<T> newLinkedList) {
        Node<T> current = first;
        Object[] array = newLinkedList.toArray();
        size += array.length;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        for (int i = 0; i < array.length; i++) {
            current.setNext(new Node<>((T) array[i]));
            current = current.getNext();
        }

    }

    //   метод для удаления объекта из списка по индексу
    @Override
    public boolean delete(int index) {
        if (index < 0 || index > size) {
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

    // метод для получения объекта из списка по индексу
    @Override
    public T get(int index) {

        if (size == 0) return null;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index + ", List size = " + size);
        }
        Node<T> temp = first;
        if (index < size / 2) {
            for (int i = index; i != 0; i--) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i != index; i--) {
                temp = temp.prev;
            }
        }
        return temp.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return first.item;
    }

    @Override
    public T getLast() {
        return last.item;
    }

    @Override
    public void deleteFirst() {

        if (first.next == null) {
            last = null;
        } else {
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

    // метод для проверки наличия объекта в списке
    @Override
    public boolean contains(Object o) {
        if (first == null) return false;
        Node<T> temp = first;
        if (o == null) {
            while (temp != null) {
                if (temp.item == null) {
                    return true;
                }
                temp = temp.next;
            }
        } else {
            while (temp != null) {
                if (temp.item != null && o.getClass() != temp.item.getClass()) return false;
                if (o.equals(temp.item)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void addFirst(T o) {
        Node<T> f = first;
        Node<T> newNode = new Node(o);
        newNode.prev = null;
        newNode.next = f;
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        add(element);
    }

    /* метод для удаления объекта из списка по значению,
       удаляет только первое совпадение */
    @Override
    public boolean delete(Object o) {
        if (size == 0) return false;
        Node<T> temp = first;
        if (o == null) {
            if (first.item == null) {
                first = first.next;
                first.prev = null;
                size--;
                return true;
            }
            while (temp.next != null) {
                if (temp.item == null) {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    size--;
                    return true;
                }
                temp = temp.next;
            }
            if (temp.item == null) {
                last = temp.prev;
                last.next = null;
                size--;
                return true;
            }
        } else {
            if (o.equals(first.item)) {
                first = first.next;
                first.prev = null;
                size--;
                return true;
            }
            temp = temp.next;
            while (temp.next != null) {
                if (temp.item != null && o.getClass() != temp.item.getClass()) {
                    return false;
                }
                if (o.equals(temp.item)) {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    size--;
                    return true;
                }
                temp = temp.next;
            }
            if (o.equals(temp.item)) {
                last = temp.prev;
                last.next = null;
                size--;
                return true;
            }
        }
        return false;
    }

    // метод для замены объекта по индексу
    @Override
    public void set(int index, T o) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> current = first;
        for (int i = 0; i <= (index - 1); i++) {
            current = current.next;
        }
        current.item = o;

    }

    // метод для получения индекса объекта по значению
    @Override
    public int indexOf(Object o) {
        int i = 0;
        if (first == null) return -1;
        if (o == null) {
            for (Node<T> temp = first; temp != null; temp = temp.next) {
                if (temp.item == null) return i;
                i++;
            }
        } else {
            for (Node<T> temp = first; temp != null; temp = temp.next) {
                if (temp.item != null && o.getClass() != temp.item.getClass()) return -1;
                if (o.equals(temp.item)) return i;
                i++;
            }
        }
        return -1;
    }

    /* метод для получения и удаления первого объекта из списка,
    если список пустой, возвращает значение null*/
    @Override
    public T extractAndDelete() {
        if (size == 0) return null;
        Node<T> temp = first;
        if (size == 1) {
            first = null;
        } else {
            first = temp.next;
            first.prev = null;
        }
        size--;
        return temp.item;
    }

    // метод для очистки списка
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

    /* метод для получения первого объекта из списка
    если список пустой, возвращает значение null */
    @Override
    public T extract() {
        Node<T> firstNode = first;

        return (firstNode == null) ? null : firstNode.item;
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
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    // метод для сортировки коллекции
    @Override
    public void sort(Comparator c) {
        int s = this.size();
        Node temp = this.first;
        Object[] arr = new Object[s];

        for (int i = 0; i < s; i++) {
            arr[i] = temp.item;
            temp = temp.next;
        }
        Arrays.sort(arr, c);
        temp = this.first;
        for (int i = 0; i < s; i++) {
            temp.item = arr[i];
            temp = temp.next;
        }
    }

    // метод для получения подлиста начиная с fromIndex заканчивая toIndex
    @Override
    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
        MyLinkedListImpl<T> temp = new MyLinkedListImpl<>();
        Node<T> tNode = this.first;
        for (int i = 0; i < fromIndex; i++) {
            tNode = tNode.next;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            temp.add(tNode.item);
            tNode = tNode.next;
        }
        return temp;
    }

    // метод возвращает коллекцию в обратном порядке
    @Override
    public MyLinkedList<T> reverse() {
        Node<T> begin = first;
        Node<T> end = last;

        for (int i = 0; i < size / 2; i++) {
            T temp = begin.item;
            begin.item = end.item;
            end.item = temp;
            begin = begin.next;
            end = end.prev;
        }
        return this;
    }

    // метод для преобразования коллекции в массив
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @Override
    public void print() {
        Node<T> node = first;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }
}

