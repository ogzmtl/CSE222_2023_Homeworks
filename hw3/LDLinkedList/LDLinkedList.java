package LDLinkedList;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LDLinkedList<E> extends AbstractList<E> implements List<E>{


    private Node<E> head = null; 
    private int size; 
    @Override 
    public void add(int index, E item)
    {
        if(index < 0 || index > size)
        {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0)
        {
            addFirst(item);
        }
        else {
            // Node<E> node = getNode(index‐1);
            // addAfter(node, item);
        }

    }

    @Override
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public void addFirst(E item)
    {
        head = new Node<>(item, head);
    }

    @Override
    public int size() 
    {
        return this.size();
    }

    @Override
    public E get(int index) 
    {
        if(index < 0 || index > size)
        {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }

        return new LDIter(index).next();
    }

    // public E remove(int index)
    // {

    // }

    private static class Node<E>
    {

        private E data; 
        private Node<E> next; 

        private Node(E value)
        {
            this.data = value;
            this.next = null; 
        }

        private Node(E value, Node<E> next)
        {
            this.data = value; 
            this.next = next;
        }

        private E getValue()
        {
            return data;
        }

        private Node<E> getNext()
        {
            return next; 
        }
    }

    private class LDIter implements Iterator<E>
    {   
        private Node<E> next;
        
        private LDIter(){
            this(head);
        }
        private LDIter(int index){
            this();
            while(index-- > 0) next();
        }

        private LDIter(Node<E> head) {
            next = head; 
        }

        @Override
        public boolean hasNext() {
            if(next != null)return true;
            return false;
        }

        @Override
        public E next() {
            if(next == null)
                throw new NoSuchElementException();

            Node<E> temp = next; 
            next = next.getNext();
            return temp.getValue();
        }
    }

}