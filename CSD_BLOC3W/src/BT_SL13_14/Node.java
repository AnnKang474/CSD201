/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT_SL13_14;

/**
 *
 * @author Khang
 */
public class Node {
    Student info;
    Node next;

    public Node(Student info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Student info) {
        this.info = info;
    }
    
    
}