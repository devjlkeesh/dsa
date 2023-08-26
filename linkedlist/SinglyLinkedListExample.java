import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class SinglyLinkedListExample {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(0, 123);
        list.add(34);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(-12);
        // list.remove( Integer.valueOf(0));
        list.remove(0);
        list.remove(2);
        list.remove(3);
        System.out.println(list.containsR(123));
        System.out.println(list.containsR(34));
    }
}

class SinglyLinkedList<T> implements Iterable<T> {
    Node<T> head;
    private int size;


    public T remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> prev = null;
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }
        T element;
        if (prev == null) {
            element = head.element;
            head = head.next;
            return element;
        } else {
            element = curr.element;
            prev.next = curr.next;
        }
        size--;
        return element;
    }

    public boolean remove(T o) {
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur != null) {
            if (Objects.equals(o, cur.element)) {
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<>(element);
        }
        size++;
    }
    public void add(int index, T element) {

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        } else {
            Objects.checkIndex(index, size);

            Node<T> prev = null;
            Node<T> curr = head;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                prev.next = newNode;
                newNode.next = curr;
            }
        }
        size++;
    }

    public boolean contains(T o) {
        Node<T> curr = head;
        while (curr != null) {
            if (Objects.equals(curr.element, o))
                return true;
            curr = curr.next;
        }
        return false;
    }

    public boolean containsR(T o) {
        return contains(head, o);
    }

    public int size() {
        return size;
    }
    private boolean contains(Node<T> node, T o) {
        if (node == null)
            return false;
        if (Objects.equals(node.element, o))
            return true;
        return contains(node.next, o);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T t = cur.element;
                cur = cur.next;
                return t;
            }
        };
    }

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }


}
