/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL5_6;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Khang
 */
public class MyList {
    Node head,tail;
    int size;

    public MyList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
      public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    void  traverse(){
        Node p = head;
        while (p!=null) {            
            System.out.println(p.info);
            p = p.next;
        }
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p =head;
        while (p!=null) {            
            f.writeBytes(p.info + " ");
            p = p.next;
        }
        f.writeBytes("\r\n");
        
    }
    
    
    void loadData(int k){ // k la dong thu k trong file
        String[] a =Lib.readLineToStrArray("data1.txt", k);
        int n= a.length;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(a[i]);
            //addLast
            addLast(number);
        }
        
    }
    
    void addFirst(int v){
       Node newNode= new Node(v);
       
       if(head==null){
           head= newNode;
           tail=newNode;
           //head=tail=newNode;
       }else{
           newNode.next=head;
           head=newNode;
       }
        size++;
    }
    
    void addLast(int v){
        Node newNode= new Node(v);
       
       if(head==null){
           head= newNode;
           tail=newNode;
           //head=tail=newNode;
       }else{
          tail.next=newNode;
          tail=tail.next;
       }
       size++;
    }
    
    // f1: ham nay se goi ham addLast nhieu lan
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: ham addFirst ==> du lieu nhap tu ban phim
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số bạn muốn:");
        int n=sc.nextInt();
        addFirst(n);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: ham addPos ==> them node vao vi tri thu k, trong do node moi va chi so k duoc nhap tu ban phim
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sd = new Scanner(System.in);
        System.out.println("Nhập số bạn muốn add:");
        int v= sd.nextInt();
        System.out.println("Nhập vị trí k mà bạn muốn add:");
        int k=sd.nextInt();
        if (k==0) {
            addFirst(v);
        }
        Node hientai= head;
        int vthientai=0;
        while (vthientai < k-1 && hientai!=null) {            
            hientai=hientai.next;
            vthientai++;
        }
        //for (int i = 0; i < k-1; i++) {
        //    hientai=hientai.next;
        //}
        Node newNode=new Node(v);
        newNode.next=hientai.next;
        hientai.next=newNode;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f4: removeFirst
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        //if (head != null) {
        //    head= head.next;
        //} 
        if (!isEmpty()){
            
            head = head.next;
            if(head==null){
                tail=null;
            }
            size--;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: removeLast
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
         if (!isEmpty()){
            
           
            if(size ==1){
               head= tail=null;
               size=0;
            }else{
                // find the node before the tail
                Node p = head;
                for (int i = 0; i < size-2; i++) {
                    p=p.next;
                }
                p.next=null;
                tail=p;
                size--;
            }
            
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
