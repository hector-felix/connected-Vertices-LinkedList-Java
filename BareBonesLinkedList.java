

/**
 *
 * @author CSC-Student
 */
public interface BareBonesLinkedList<E>
{
    // Add an element to linked list at specifc index
    public void add(int index, E item);
   
    //remove index at given index
    public E remove(int index);
   
    // Return data from node at index
    public E get(int index);
   
    // Sets data from node at index
    public void set(int index, E data);
   
    // Get nodes of numbers in list
    public int size();
}
