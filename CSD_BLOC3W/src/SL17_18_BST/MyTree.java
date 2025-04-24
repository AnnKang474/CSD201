/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL17_18_BST;

/**
 *
 * @author Khang
 */
public class MyTree {
    Node root;

    public MyTree() {
        this.root= null;
    }
    
      public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }
    public void  insert(int value){
        root= insertRec(root, value);
        
    }

    private Node insertRec(Node p, int value) {
        if (p==null) {
            p= new Node(value);
        } else if (value< p.info) {
            p.left=insertRec(p.left, value);
        }else if (value > p.info) {
            p.right=insertRec(p.right, value);
        }
        return  p;
 
    }
    
    public void  visit(Node p){
        System.out.println(p.info+" ");
    }
    
    void  preOder(Node p){
        if (p==null) {
            return;
        } else {
            visit(p);
            preOder(p.left);
            preOder(p.right);
        }
    }
    
    void  inOder(Node p){
        if (p==null) {
            return;
        } else {
            inOder(p.left);
            visit(p);
            
            inOder(p.right);
        }
    }
    
    void  postOder(Node p){
        if (p==null) {
            return;
        } else {
            postOder(p.left);
            postOder(p.right);
            visit(p);
            
            
        }
    }
    
    int search(Node p , int  x){
        if (p==null) {
            return 0; // k tìm thấy
        }
        if(p.info==x) {
            
                return 1; // tìm thấy
        }
        if(x < p.info){
               return  search(p.left, x);
            }else{
               return search(p.right, x);
        }
        
   }
    
     private int maxLevel(Node p) {
        if (p == null) {
            return 0;
        }
        int maxLeftLevel = maxLevel(p.left);
        int maxRightLevel = maxLevel(p.right);

        return Math.max(maxLeftLevel, maxRightLevel) + 1;
    }
    
     private int countNodes(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countNodes(p.left) + countNodes(p.right);
        
          //Chỉ đếm > 5;
        //int x = ((p.info>5)?1:0);
        //return x + countNodes(p.left) + countNodes(p.right);
     }
    
    private int countLeafNodes(Node p) {
        if (p == null) {
            return 0;
        }
        int x = (p.left==null && p.right==null)?1:0;
        return x + countLeafNodes(p.left) + countLeafNodes(p.right);
    }
    
    
     private int sumNode(Node p){
        if(p==null){
            return 0;
        }
        return p.info + sumNode(p.left) + sumNode(p.right);
        // Tinh tong > 5
        // int x = (p.info>5)?p.info:0;
        // return x + sum(p.left) + sum(p.right);
    }
     
    //1. Test f1 - Height
    public int f1(){
        
        
        return maxLevel(root)-1;
    }
    
    //2. Test f2 - count nodes
    public int f2(){
        
        return countNodes(root);
    }
    
    // 3. Test f3 - count leaf nodes
    public int f3(){
        
        return countLeafNodes(root);
    }
    
    // 4. Test f4 - compute sum of nodes
    public int f4(){
        return sumNode(root);
    }
    
    // 5. Test f5 - PreOder
    public void f5(){
        preOder(root);
    }
    
    // 6. Test f6 - InOder
    public void f6(){
        inOder(root);
    }
    
    
    // 7. Test f7 - PostOder
    public void f7(){
        postOder(root);
    }
    
    // 8. Test f8 - Search
     public int f8(int n){
        return search(root, n);
    }
}

