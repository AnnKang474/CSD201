/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL19_20_BSTWithObj;

/**
 *
 * @author Khang
 */
public class Node {
    Student info;
    Node left;
    Node right;

    public Node() {
        this.info=info;
        this.left=null;
        this.right=null;
    }

    public Node(Student info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(Student info) {
        this.info=info;
        this.left=null;
        this.right=null;
    
    
    }   

    
}
