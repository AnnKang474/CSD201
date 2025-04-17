package SL3_4;


import SL3_4.Node;
import com.sun.xml.internal.stream.Entity;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khang
 */
public class MyList {
    Node head;

    public MyList() {
        this.head=null;
    }
    
   public  boolean isEmpty(){
       //if (this.head== null) {
          // return true;
           
      // } else {
          // return  false;
      // }
      return this.head== null;
      
   }
   public void clear(){
       this.head = null;
   }
   
   public void traverse(){
       Node p = head;
       while (p!=null) {         
           System.out.println(p.info);
           System.out.println(" ");
           p = p.next;
           
       }
              
   }
   void loadData(int k){
       Random generator = new Random();
           for (int i = 0; i < k; i++) {
               int number = generator.nextInt(1000)+1;
           
               
               addFirst(number);
       }
       }
   public void addFirst(int n){
       Node newNode= new Node (n);
       
       //addFirst
       newNode.next=head;
       head=newNode;
   }
   
   public void addLast(int n){
       Node newNode= new Node (n);
       
       //addLast
       //if list is empty, make the new node as head
     if(head==null){
         head= newNode;
         return;
     }
     // if list is not empty
      Node last = head;
       while (last.next != null) {           
           last= last.next;
           
       }
       //add the new node at the end
       last.next= newNode;
       
   }
   
   void f1(){
       System.out.println("Linked List: ");
       this.traverse();
   }
   
   // f2 nhap du lieu mot con so tu ban phím => addLast
   void f2(){
       System.out.println("Before: ");
       this.traverse();
       
       Scanner sc= new Scanner(System.in);
       int n = sc.nextInt();
       
       addLast(n);
       
       
       System.out.println("After: ");
       this.traverse();
   }
   
   // f3 addPos them node vao vi tri thu k
   // trong do node moi va chi so k dc nhap từ bàn phím
   void f3(){
       System.out.println("Before: ");
       this.traverse();
       
       Scanner sc= new Scanner(System.in);
       System.out.println("số bn muốn add");
       int e = sc.nextInt();
       System.err.println("vị trí bn muốn add :");
       int k = sc.nextInt();
        if (k==0){
            addFirst(e);
            
        }
        
        // Find the node at k-1
        Node curent = head;
        int currentIndex=0;
        while(currentIndex < k-1 && curent!= null){
            curent=curent.next;
            currentIndex++;
        }
        // insert new node
        
        Node newNode = new Node (e);
        newNode.next = curent.next;
        curent.next= newNode;
      
       
       
       
       System.out.println("After: ");
       this.traverse();
   }
   
   //f4 removeFirst
   
    void f4(){
       System.out.println("Before: ");
       this.traverse();
       
        if (head != null) {
            head= head.next;
        } 
      
      
       
     
      
       
       
       System.out.println("After: ");
       this.traverse();
   }
    
    void f5(){
       System.out.println("Before: ");
       this.traverse();
       
        if (head!=null) {
            // if there is only 1 element
            if (head.next== null) {
                head= null;
            } else {
                // find the second last node
                Node secondLast= head;
                while (secondLast.next.next!=null) {    
                    secondLast= secondLast.next;
                    
                }
                //remove Last node
                secondLast.next= null;
            }
        } 
       
       
       System.out.println("After: ");
       this.traverse();
   }
}


