public class ArrayList <E> implements ArrayList_Interface <E>
{
    // Data elements
    private int size; // Elements in array
    private int capacity; // Size of ArrayList
    private E[] myArray; // Array referance to store teh actual data
    private static final int INITIAL_CAPACITY = 10;
   
    // Constructors
    public ArrayList()
    {
        // Default constructor
        this.capacity = this.INITIAL_CAPACITY; // Default is 10 spaces
        this.size = 0; // No elements to begin
        this.myArray = (E[]) new Object[this.capacity]; // After this we have ArrayList
    }
   
    public ArrayList(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.myArray = (E[]) new Object[this.capacity];
    }
   
    // Adds element at end of ArrayList
    @Override
    public void add(E a)
    {
        if(this.size < this.capacity) // This means there is space in array
        {
            this.myArray[size] = a; // Size gives index of the first free location
            size++;
        }
        else
        {
            // We dont have space!
            System.out.println("No more space! Need to reallocate!");
            this.reallocate();
            this.add(a);
        }
           
    }

    @Override
    public void add(E a, int index)
    {
        // This method adds element at specified index
        // Needs to validate index first
        if(index < 0 || index > size)
        {
            System.out.println("Invalid index, no data inserted");
            return;
        }
        else if(index == size)
        {
            // This means the element is added at the end
            // So jsut call add method
            this.add(a);
            size++;
        }
        else
        {
            // This is when shifting of elements is required
            // First make sure tehre is space to shift elements
            if(this.size == this.capacity)
            {
                this.reallocate(); // If no more space call reallocate and double capacity
            }
            // Move the data one index to the right starting from the end
            for(int i = size; i > index; i--)
            {
                myArray[i] = myArray[i - 1]; // Shifting to the right
            }
            // once shifting is done, we can insert data
            myArray[index] = a;
            size++;
        }
               
    }

    @Override
    public E remove(int index)
    {
        if(index < 0 || index >= size)
        {
            System.out.println("Invalid index");
            return null;
        }
        // Store value to be deleted
        E temp = myArray[index];
        // We can use a loop to move all elements after index one left
        for(int i = index; i < size - 1; i++)
        {
            myArray[i] = myArray[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public E get(int index)
    {
        if(index < 0 || index >= size)
        {
            System.out.println("Invalid index");
            return null;
        }
       
        return myArray[index];
    }

    @Override
    public void set(E a, int index)
    {
        if(index < 0 || index >= size)
        {
            System.out.println("Invalid index");
            return;
        }
        myArray[index] = a;
    }

    @Override
    public int getSize()
    {
        return this.size;
    }

    @Override
    public int indexOf(E a)
    {  	
    	for (int i = 0; i < size; i++)
    	{
    		if(myArray[i] == a)
    			return i;
    	}
    	
    	return -1;
    }

    private void reallocate()
    {
        // This method is called when there is no more space in the array
        // so we create a new array with double the size,
        // copy the elements over, and change the reference of the array.
       
        this.capacity *= 2;
       
        E[] temp = (E[]) new Object[this.capacity]; // This is the temp array
       
        // Need to coppy old array elements into the new one
        for(int i = 0; i < myArray.length; i++)
        {
            temp[i] = myArray[i];
        }
       
        myArray = temp; // Update the reference to the new array
    }

    @Override
    public String toString()
    {
        // This method returns the data of the object as a String
        String s = "";
       
        for(int i = 0; i < size - 1; i++) // Go over each element
        {
            s += myArray[i] + ",";
        }

       s += myArray[size - 1];
       return s;
    }
}