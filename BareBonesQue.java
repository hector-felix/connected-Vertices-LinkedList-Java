/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CSC-Student
 */
public interface BareBonesQue <E> // Basic que methods
{
    public void offer(E object); // Adding data
    public E poll(); // removing data
    public boolean isEmpty(); // Check if empty
    public boolean isFull(); // Check if full
    public E peek(); // Returns first element w/o delete
   
}
