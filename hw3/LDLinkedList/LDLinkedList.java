package LDLinkedList;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LDLinkedList<E> extends AbstractList<E> implements List<E>{

    //javadoc yazilacak 
    //rapor yazilacak

    private Node<E> head = null; 
    private Node<E> tail = null; 
    LDIterator<E> iterator = iterator();
    private int size = 0; 

    public LDLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size; 
    }

    @Override
    public boolean add(E data)
    {
        Node<E> temp = new Node<>(data); 
        // LDIterator<E> iterator = iterator();
        int i = 0;
        while(iterator.hasNext()){
            System.out.println(i++);
            iterator.next();
        }
        if(size == 0){
            head = temp;
            tail = head;
        }
        else
        {
        //    tail = temp; 
            tail.next = temp; 
            tail = temp;
            // iterator.next();
        }
        
        size++;
        // head = new Node<>(data, head);
        return true;
    }

    @Override
    public void add(int index, E data)
    {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        LDIterator<E> iteratorNew = iterator();

        if(index == size)
        {
            add(data);
            return;
        }
        
        for(int i = 0; i < index; i++)
        {
            iteratorNew.next();
        }

        Node<E> newNode = new Node<>(data);        

        if(index == 0){
            newNode.next = head;
            head = newNode; 
        }
        else
        {
            Node<E> previousNode = iteratorNew.getPrev();
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size++;
    }


    @Override
    public E get(int index) {

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        LDIterator<E> iteratorNew = iterator();
        for(int i = 0; i < index; i++)
        {
            iteratorNew.next();
        }
        
        return iteratorNew.next();
    }

    @Override
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        LDIterator<E> iteratorNew = iterator();
        int tmarked = scanMarked(index);
        if(tmarked != index){
            if(tmarked < index){
                int temp1 = tmarked; 
                tmarked = index; 
                index = temp1;
            }
            remove(tmarked, index);
            E tempData = head.data;
            if(index == 0)
            {
                // iterator.next();
                head = head.next;
            }
            // else{
            //     for(int i = 0; i < index; i++)
            //     {
            //         iteratorNew.next();
            //     }
                
            //     tempData = iteratorNew.current.data;
            //     iteratorNew.getPrev().next =  iteratorNew.current.next;
            //     iteratorNew.current.next = null;
            // }
            // size--;
            remove(index, tmarked);
            return tempData;
                
        }
        return null;

        // else{
        //     return null;
        // }
        
        // E tempData = head.data;
        // if(index == 0)
        // {
        //     // iterator.next();
        //     head = head.next;
        // }
        // else{
        //     for(int i = 0; i < index; i++)
        //     {
        //         iteratorNew.next();
        //     }
            
        //     tempData = iteratorNew.current.data;
        //     iteratorNew.getPrev().next =  iteratorNew.current.next;
        //     iteratorNew.current.next = null;
        // }
        // size--;
        // return tempData;
    }

    public E remove(int index, int marked){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        
        E tempData = head.data;
        if(index == 0)
        {
            // iterator.next();
            head = head.next;
        }
        else{
            LDIterator<E> iteratorNew = iterator();
            for(int i = 0; i < index; i++)
            {
                iteratorNew.next();
            }
            
            tempData = iteratorNew.current.data;
            iteratorNew.getPrev().next =  iteratorNew.current.next;
            iteratorNew.current.next = null;
        }
        size--;
        return tempData;
    }
    public boolean remove(Object obj) { 
        
        LDIterator<E> iteratorNew = iterator();
        // E tempData;
        while (iteratorNew.hasNext()) {
            Node<E> currNode = iteratorNew.current;
            if (obj.equals(currNode)) {
                iteratorNew.getPrev().next =  iteratorNew.current.next;
                iteratorNew.current.next = null;
                return true;
            }
            iteratorNew.next();
        }
        throw new NoSuchElementException();
    }


    public int scanMarked(int index){
        LDIterator<E> iteratorNew = iterator();
        int i = 0;
        while(iteratorNew.hasNext()){
            
            if(i != index && iteratorNew.current.marked == true) 
                return i;
            i++;
            iteratorNew.next();
        }
        iteratorNew = iterator();
        
        for(int j = 0; j < index; j++ ){
            iteratorNew.next();
        }
        iteratorNew.current.marked = true;
        return index;
    }

    public LDIterator<E> iterator()
    {
        return new LDIterator<>(head);
    }


    // public E remove(int index)
    // {

    // }

    private static class Node<E>
    {
        private E data; 
        private Node<E> next; 
        private boolean marked; 

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
    private static class LDIterator<E> implements Iterator<E> {

        private Node<E> current; 
        private Node<E> prev;

        public LDIterator(Node<E> head){
            current = head; 
            prev = null; 
        }

        @Override
        public boolean hasNext() {
            return current != null; 
        }

        @Override
        public E next() {

            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E data = current.data;
            
            prev = current; 
            current = current.next;
            
            return data; 
            
        }
        public Node<E> getPrev(){
        
            return prev; 
        }
        
    }
}