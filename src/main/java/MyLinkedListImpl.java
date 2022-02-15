
import static java.util.Collections.addAll;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Collection;
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

    private class Node<T> {
        private Node<T> prev;
        private T data;
        private Node<T> next;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
          
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
    @Override
        public void sort() {
            //метод для сортировки
    >>>>>>> main
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

    public void set(int index, Object element) {
          if (index < 0 || index > size) throw new IndexOutOfBoundsException();
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
      
              Node current = first;
              for (int i = 0; i <= (index - 1); i++) {
                  current = current.next;
              }
              current.element = element;
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

