// ArrayList interface
public interface ArrayList_Interface <E>
{
    // List needed methods
   
    public void add(E a); // This method to add at the end of ArrayList
   
    public void add(E a, int i); // This method add at index i
   
    public E remove(int i); // This method remove element at index i
   
    public E get(int i); // Retreive element at index i
   
    public void set(E a, int i); // Modifies element at index i
   
    public int getSize(); // Returns number of elements in ArrayList
   
    public int indexOf(E a); // Returns index of element a
   
}