package opgave02.models;

import java.util.Iterator;

public class SortedLinkedList<E extends Comparable<E>> implements SortedListEaaa<E> {
    private Node<E> head;
    private Node<E> tail;
    private class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
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

    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public void removeLast() {

    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
