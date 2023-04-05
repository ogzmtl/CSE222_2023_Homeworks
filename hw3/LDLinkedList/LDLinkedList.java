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
/**
 * setting the constructor tail and head to the null
 */
    public LDLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
/**
 * @return size of the linkedlist
 */
    public int size(){
        int i = 0; 
        LDIterator<E> iteratorNew = iterator();
        while(iteratorNew.hasNext()){
            i++;
            iteratorNew.next();
        }
        return i;
    }
/**
 * takes generic data and add to the end of the linkedlist 
 * with the help of iterator, global iterator holds en of the list
 * @param data 
 * @return if adding successfull returns true 
 */
    @Override
    public boolean add(E data)
    {
        Node<E> temp = new Node<>(data); 
        // LDIterator<E> iterator = iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        if(size == 0){
            head = temp;
            tail = head;
        }
        else
        {
            // iterator.current.next = temp;
            tail.next = temp; 
            tail = temp;
            // iterator.next();
        }
        
        size++;
        // head = new Node<>(data, head);
        return true;
    }
/**
 * add method with index 
 * Iterator class used
 */
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

/**
 * @return gets the given index otherwise returns null
 */
    @Override
    public E get(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        LDIterator<E> iteratorNew = iterator();
        // while(iteratorNew.hasNext()){
        //     System.out.println("AAAAAAA:");
        //     iteratorNew.next();
        // }
        // iteratorNew = iterator();
        for(int i = 0; i < index; i++)
        {   
            iteratorNew.next();
        }
        
        return iteratorNew.current.data;
    }
/**
 * First check marked nodes if any index be marked 
 * then takes this marked value and send to the override remove function 
 * @param index takes the index 
 * @return removed value
 */
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
/**
 * takes the both old and new marked indexes and first remove higher index value 
 * then remove lower index value
 * @param index takes the index 
 * @return removed value
 */
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
/**
 * removes the object of Account, post or etc
 */
    public boolean remove(Object obj) { 
        
        LDIterator<E> iteratorNew = iterator();
        // E tempData;
        if(obj.equals(head.data)){
            if(head.next != null )
                head = head.next;
            else head = null;
            return true;
        }
        while (iteratorNew.hasNext()) {
            E currNode = iteratorNew.current.data;
            System.out.println(obj);
            System.out.println(currNode);
            if (obj.equals(currNode)) {
                if(iteratorNew.getPrev() == null)
                    System.out.print( iteratorNew.getPrev().data);
                iteratorNew.getPrev().next =  iteratorNew.current.next;    
                iteratorNew.current = iteratorNew.getPrev().next;
                // iteratorNew.getPrev()  = iteratorNew;
                // iteratorNew.current.next = null;
                return true;
            }
            iteratorNew.next();
        }


        throw new NoSuchElementException();
    }

/**
 * Scannes the all nodes of linkedlist 
 * marked value is not equal to the new index then returns that founded value 
 * @param index newindex value 
 * @return if index is not equal oldMarked value returns old marked value otherwise return index
 */
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