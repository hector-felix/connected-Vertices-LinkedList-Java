/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CSC-Student
 */
// que class using circular array
public class CircularQue <E> implements BareBonesQue <E>
{
    //Data
    private E[] Q; // Array ref for que
    private int front; // Front of que
    private int rear; // Rear of que
    private int size; // # elem of que
    private int capacity; // total number of spots in que
    private final int DEFAULT_CAPACITY = 5; // Default capacity

    public CircularQue()
    {
        Q = (E[]) new Object[this.DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = 0; // Front and rear 0, no element to begin with (Q "empty")
                       // Any time both point to same thing index the Q is "empty
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }
   
    // User defines size
    public CircularQue(int capacity)
    {
        Q = (E[]) new Object[capacity]; // Q created
        this.front = 0;
        this.rear = 0;
        this.size = 0; // Front/rear 0 que "empty"
        this.capacity = capacity;
    }
   
    @Override
    public void offer(E object) // Adds elements to the rear of the Q
    {
        if(isFull()) // If Q is full
        {
            //System.out.println("Q overflow!");
            reallocate();
            this.offer(object);
            return;
        }
       
        this.Q[this.rear] = object; // Add element
        this.rear = (this.rear + 1) % this.capacity; // Update rear
        size++; // Update number of elements

    }

    @Override
    public E poll() // Remove element at front
    {
        if(isEmpty()) // If empty return underflow
        {
            System.out.println("Que underflow.");
            return null;
        }
       
        // If Q is not empty we delete from front
        E temp = Q[front]; // Store data to be returned;
        front = (front + 1) % this.capacity;
        size--;
           
        return temp;
    }

    @Override
    public boolean isEmpty() // If size 0 Q empety. Front == Rear would also work.
    {
        return (size == 0);
    }

    @Override
    public boolean isFull() // Q is full when size = capacity
    {
        return (this.size == this.capacity);
    }

    @Override
    public E peek()
    {
    	if(isEmpty())
    	{
    		System.out.println("Empty list.");
    		return null;
    	}
    	
        return this.Q[front];
    }

    @Override
    public String toString() // Returns Q as String
    {
        String s = "Q: ";
        // Loop over elements i the Q from front to rear

        for(int i = front; i < front + size; i++)
        {
            s += Q[i % this.capacity] + " | ";
        }
       
       
        return s;
    }
   
    private void reallocate()
    {
        E[] temp = (E[]) new Object[this.capacity*2];
    
        for(int i = 0; i < size; i++) // Iterates through the size of Q
        {
        	temp[i] = Q[(front + i) % capacity]; // Assigns value to the new array
        }									     // based on front mod by capacity
        										 // similar to how we iterate through toString
        this.Q = temp; // Assignes Q to the newly resized array
        front = 0; // Assigning front to 0 since all the new elements begin at 0 now
        rear = size; // Putting rear to size since rear would be at (n - 1)
        this.capacity = capacity * 2; // Reassigning capacity
    }
   
   
   
}