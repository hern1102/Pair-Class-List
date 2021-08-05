/*
Description: This Pair class is a simple generic class that will take two values
and will store them within the object. This class can be used in many situations
(e.g. storing a grid coordinates). 
 */  

package project.pkg2;

public class Pair<T> {
    
    private T first;
    private T second;
    
    public Pair (T fData, T sData){
        
        this.first = fData;
        this.second = sData;
        
    }
    
    /*
    Function: getFirst
    Description: This accessor method will return the first value in the pair
    Inputs: No input required
    Outputs: This method will return which ever data type you stored in the value
    remember, it is a generic.
    */
    
    public T getFirst(){
        return this.first;
    }
    
    /*
    Function: getSecond
    Description: This accessor method will return the second value in the pair
    Inputs: No input required
    Outputs: This method will return which ever data type you stored in the value
    remember, it is a generic.
    */
    
    public T getSecond(){
        return this.second;
    }
    
    /*
    Function: setFirst
    Description: This mutator method will set the value of the first variable in 
    pair
    Inputs: the value you would like to set the first variable too
    Outputs: None
    */
    
    public void setFirst(T fData){
        this.first = fData;
    }
    
    /*
    Function: setSecond 
    Description: This mutator method will set the value of the second variable in
    the pair
    Inputs: the value you would like to set the second variable too
    Outputs: None
    */
    
    public void setSecond(T sData){
        this.second = sData;
    }
    

}
