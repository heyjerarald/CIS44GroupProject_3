/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis44groupproject;

/**
 *
 * @author chuongtruong
 */
public final class Queue<T> implements QueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int initialCapacity) {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        this.frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    } // end constructor

    @Override
    public void enqueue(T newEntry) {
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T getFront() {
        checkInitialization();
        T qData = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");

        } else {
            qData =  queue[frontIndex];
        }
        return qData;
    } // end getFront

    @Override
    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public T dequeue()
    {
        checkInitialization();
        T removedItem = null;
        if (isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            removedItem = front;
        }
        return removedItem;
    }

    @Override
    public void clear()
    {
        checkInitialization();
        if (!isEmpty())
        { // deallocates only the used portion
            for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length)
            {
                queue[index] = null;
            }
            
            queue[backIndex] = null;
        }
        
        frontIndex = 0;
        backIndex = queue.length - 1;
    }
    
    public void display()
    {
           for(int index = frontIndex; index <= backIndex; index++)
           {
                System.out.println(queue[index]);
           }
    }
    
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a queue " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
        }
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException(
                "ArrayQueue object is not initialized properly.");
        }
    }
    
    private void ensureCapacity()
    {
        if (frontIndex == ((backIndex + 2) % queue.length)) // If array is full,
        {                                                   // double size of array
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++)
            {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
         
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }
}
