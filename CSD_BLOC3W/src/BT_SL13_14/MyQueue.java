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

   public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String id, String name, int age, double gpa) {
        Student st = new Student(id, name, age, gpa);
        Node newNode = new Node(st);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Student dequeue() {
        if (!isEmpty()) {
            Student value = head.info;

            head = head.next;
            if (head == null) {
                tail = null;
            }

            return value;
        } else {
            return null;
        }
    }

    public Student front() {
        if (!isEmpty()) {
            Student value = head.info;
            return value;
        } else {
            return null;
        }
    }

    public void display() {
        Node current = head;
        while(current!=null){
            System.out.println(current.info);
            current = current.next;
        }
    }
    
    public Student findHighestGPAStudent() {
    if (isEmpty()) {
        return null;
    }

    Node current = head;
    Student maxStudent = current.info;
    
    while (current != null) {
        if (current.info.getGpa() > maxStudent.getGpa()) {
            maxStudent = current.info;
        }
        current = current.next;
    }

    return maxStudent;
}
   }