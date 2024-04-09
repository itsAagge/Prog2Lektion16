package opgave01.models;

import java.util.Iterator;

public class LinkedList<E> implements ListEaaa<E> {

    private Node<E> head;
    private Node<E> tail;

    //Inner class
    private class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (tail != null) {
            tail.setNext(node);
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    @Override
    public boolean remove(E e) {
        boolean removed = false;
        if (head.getElement().equals(e)) {
            removeFirst();
            removed = true;
        }
        Node<E> current = head.getNext();
        Node<E> last = head;
        while (current != null && !removed) {
            if (current.getElement().equals(e)) {
                if (current == tail) {
                    last.setNext(null);
                    tail = last;
                } else {
                    last.setNext(current.getNext());
                }
                removed = true;
            }
            last = current;
            current = current.getNext();
        }
        return removed;
    }

    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        node.setNext(head);
        head = node;
    }

    @Override
    public E getFirst() {
        return head.getElement();
    }

    @Override
    public void removeFirst() {
        head = head.getNext();
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        boolean found = false;
        while (current != null) {
            if (current.getElement().equals(e)) {
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        Node<E> current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //Without recursion
    /*
    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }
    */

    //With recursion
    @Override
    public E get(int index) {
        Node<E> current = head;
        return getHelper(current,0, index).getElement();
    }

    public Node<E> getHelper(Node<E> current, int index, int finalIndex) {
        if (index == finalIndex) {
            return current;
        } else {
            return getHelper(current.getNext(), index + 1, finalIndex);
        }
    }

    @Override
    public void add(int index, E e) {
        Node<E> nodeToAdd = new Node<>(e);
        if (index == 0) {
            nodeToAdd.setNext(head);
            head = nodeToAdd;
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            nodeToAdd.setNext(current.getNext());
            current.setNext(nodeToAdd);
        }
    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            E element = head.getElement();
            removeFirst();
            return element;
        } else {
            Node<E> toBeRemoved = head.getNext();
            Node<E> last = head;
            for (int i = 1; i < index; i++) {
                toBeRemoved = toBeRemoved.getNext();
            }
            if (toBeRemoved.equals(tail)) {
                last.setNext(null);
                tail = last;
            } else {
                last.setNext(toBeRemoved.getNext());
            }
            return toBeRemoved.getElement();
        }
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        boolean found = false;
        Node<E> current = head;
        while (current != null && !found) {
            if (current.getElement().equals(e)) {
                found = true;
            } else {
                index++;
            }
            current = current.getNext();
        }
        return index;
    }

    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<>() {
            Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E item = current.getElement();
                current = current.getNext();
                return item;
            }
        };
        return iterator;
    }
}
