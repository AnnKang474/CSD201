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
public class Node {
    int info;
    Node next;

    public Node(int info) {
        this.info = info;
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    
}
