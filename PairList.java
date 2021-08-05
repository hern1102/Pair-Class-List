/*
Description: THIS IS THE MAIN FILE. This file is a class that is derived from 
the generic class LinkedList and is specialized to handle Pairs. For that reason
there is code that is created that allows for the manipulation or access of data
that it special to a Pair.
 */  

package project.pkg2;

/**
 * @author antho
 */
public class PairList <T> extends LinkedList{
    
    //default constructor
    public PairList(){
        
    }
    
    //overloaded constructor
    public PairList(T first, T second){
        addPair(first, second);
    }
    
    /*
    An instance of Pair is created in order to access all of the functionality 
    of Pair like adding Pairs, accessing or setting the data of pairs. This, along
    with deriving from LinkedList is what allows for PairList to be a linked list
    of Pairs.
    */
    
    private Pair pair;
    
    /*
    Function: addPair(T first, T second)
    Description: This method will take two values, create a pair object from those
    two values, and append them to the PairList
    Inputs: The two value you wish to add to PairList as a Pair
    Outputs: None
    */
    
    
    public void addPair(T first, T second){
        pair = new Pair(first, second);
        append(pair);
    }
    
    /*
    Function: T getFirst(T second)
    Description: This method will find the first value in a pair by searching 
    a pair using its second value. 
    Inputs: The second or y value of the pair.
    Outputs: The first value in the pair.
    */
    
    public T getFirst(T second){
        
        Node current = head;
        while(current != null){
            if(((Pair)current.data).getSecond().equals(second)){
                return (T)((Pair)current.data).getFirst();
            }
            current = current.next;
        }
        return null;
    }
    
    /*
    Function: T getSecond(T first) 
    Description: This method will find the second value in a pair by searching
    a pair using its first value
    Inputs: The first value or x value of the pair
    Outputs: The second value in the pair
    */
    
    public T getSecond(T first){
        
        Node current = head;
        while(current != null){
            if(((Pair)current.data).getFirst().equals(first)){
                return (T)((Pair)current.data).getSecond();
            }
            current = current.next;
        }
        return null;
    }
    
    /*
    Function: deletePair(T first, T second)
    Description: This method takes a pair value in as a parameter and then finds
    that pair if it exists in the PairList, and then deletes that Pair from the 
    PairList
    Inputs: The first and second value in the pair you wish to delete
    Outputs: None
    */
    
    public void deletePair(T first, T second){
        if(head == null){
            return;
        }
        int indexToDelete = find(first, second);
        if(indexToDelete == -1){
            return;
        }
        if(0 == find(first, second)){
            head = head.next;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            if(current.next.data.equals(at(indexToDelete))){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    /*
    Function: printList()
    Description: This method is an overridden method from LinkedList. Since 
    the data that you are printing is a little different, we had to tweek it a bit.
    This method traverses through the entire LinkedList, and then in a formatted
    manner accessed the data of the Pair, using the Pair accessor methods. 
    Inputs: None
    Outputs: This method will print out the contents of the PairList.
    */
    
    @Override
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println("(" + ((Pair)current.data).getFirst() + 
                     ", " + ((Pair)current.data).getSecond() + ")");
            current = current.next;
        }
    }
    
    /*
    Function: find(T first, T second)
    Description: This method works similar to the find(T data) method located in
    LinkedList. Since the PairList class however does not deal with the same 
    type of data as the generic LinkedList method does, it requires a different
    approach. This method will take a pair value that you wish to search for, and 
    traverse the LinkedList until it finds the pair value (if it exists), then 
    return the index (an int) at which it found the match.
    Inputs: The pair value you wish to find
    Outputs: an int which represents the index in the PairList that the pair 
    value was found.
    */
    
    public int find(T first, T second){
        
        int counter = 0;
        Node current = head;
        
        while(current != null){
            if(((Pair)current.data).getFirst() == first && 
                    ((Pair)current.data).getSecond() == second){
                return counter;
            }
            counter++;
            current = current.next;
        }
        counter = -1;
        return counter;
    }
    
    public static void main(String[] args) {
        
        /*
        
                    ******** PairList test code ***********
        
        1) The PairList test code below creates a PairList of <Integers> and 
        then adds 6 Pairs.
        
        2) It then uses the getFirst and getSecond methods to access the respective
        data
        
        3) Then we delete a pair from the PairList that we added previously (30,3)
        
        4) We then print out the entire PairList using the overridden method 
        printList()
        
        */
        
        System.out.println("PairList test code:");
        
        PairList<Integer> pl = new PairList<>();
        
        pl.addPair(10, 1);
        pl.addPair(20, 2);
        pl.addPair(30, 3);
        pl.addPair(40, 4);
        pl.addPair(50, 5);
        pl.addPair(60, 6);
        
        
        System.out.println("Getting the first value associated with 2: " + pl.getFirst(2));
        System.out.println("Getting the second value associated with 40: " + pl.getSecond(40));
        pl.deletePair(30, 3);
        pl.printList();
        System.out.println("Index of pair (50, 5): " + pl.find(50,5));
        
        /*
        
                    ******** LinkedList test code ***********
        
        1) Append: first we add 5 Nodes to a LinkedList of String that we created
        
        2) prepend: Then we add a new node to the front of the list call Input 0
        
        3) Insert: Then we search for Input 5, and add a new node with 4 and a half 
        to the front of the node with Input 5
        
        4) delete: Then we delete the Node with the String value of Input 1 from
        the LinkedList
        
        5) printList: We then print the list as it stands now
        
        6) find: And find the index of the node with Input 4 as the data
        
        */
        
        System.out.println("LinkedList test code:");
        
        LinkedList<String> list = new LinkedList<>();
        
        
        list.append("Input 1");
        list.append("Input 2");
        list.append("Input 3");
        list.append("Input 4");
        list.append("Input 5");
        
        
        list.prepend("Input 0");
        
        list.insert("Input 5", "Input 4 and a half");
        
        list.delete("Input 1");
        
        list.printList();
        
        System.out.println("We are finding the index of Input 4: " +
                list.find("Input 4"));
        
    }
    
}
