/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL9_10;

/**
 *
 * @author Khang
 */
public class MyStack {
    Node top;

    public MyStack(Node top) {
        this.top = top;
    }

    MyStack() {
       
    }
    
    //insert an elemnet at the top position
    public void push(int x){
        //create new node with given data
        Node newNode = new Node(x);
        
        // make the new node point to the current top
        newNode.next=top;
        
        //update top to point to the new node
        top=newNode;
        
    }
    
    public  void  load(){
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
        
    }
    
    // Utility function to check if the stack is empty or not
   public boolean isEmpty(){
       return top==null;
   }
   
   // functon to return value of top element in a stack
   // -1 return a default value if stack is empty
   public  int peek(){
       if(!isEmpty()){
           return top.info;
       }else{
           System.out.println("Stack is empty");
           return -1;
       }
   }
   
    // functon to return value of top element and remove top element in a stack
   // -1 return a default value if stack is empty
     public  int pop(){
       if(!isEmpty()){
           int value = top.info;  // lưu trữ giá trị top
           top=top.next;  // dời top sang phần tử tiếp theo
           return value;  // trả về giá trị top
       }else{
           System.out.println("Stack is empty");
           return -1;
       }
   }
     
     // display all
     public  void  display(){
         if (!isEmpty()) {
             Node current= top;
             System.out.print("Stack element: ");
             while (current!=null) {
                 System.out.println(current.info+" ");
                 current=current.next;
   
             }
             System.out.println("");
         }else{
             System.out.println("Stack is empty");
         }
     }
}
