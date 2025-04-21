
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Phone newPhone = new Phone(n, p);
        Node newNode = new Node(newPhone);
        if (p>0) {
            if (isEmpty()) {
            
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=tail.next;
            
           }
      } else {
            
        }
        
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

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
// add phone t vào sau dt mắc nhất
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (!isEmpty()) {
        Node maxPrice = head;
        Node p = head;
        while (p != null) {
            if (p.info.price > maxPrice.info.price) {
                maxPrice = p;
            }
            p = p.next;
        }
         Node newNode = new Node(t);
        newNode.next = maxPrice.next;
        maxPrice.next = newNode;

        if (maxPrice == tail) tail = newNode;
        size++;
    }
        
            
             
             
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
// tính trung bình cộng các phone có "S" 
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
         float sum = 0;
    float count = 0;
    Node p = head;

    while (p != null) {
        if (p.info.name.contains("S")) {
            sum += p.info.price;
            count++;
        }
        p = p.next;
    }

    avg_S = sum / count;
                 
        

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();
    
        
    }
    //xóa 3 nốt đầu tiên
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

        for (int i = 0; i < 3; i++) {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    if (head == null) tail = null; // Nếu list rỗng sau khi xoá
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    //Đảo vị trí của phone đắt nhất và node rẻ nhất
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

         if (size <= 2) return;

    Node maxPrice = head;
    Node minPrice = head;
    Node p = head;

    while (p != null) {
        if (p.info.price > maxPrice.info.price) {
            maxPrice = p;
        }
        if (p.info.price < minPrice.info.price) {
            minPrice = p;
        }
        p = p.next;
    }

    // Đổi thông tin của 2 node
    Phone tmp = maxPrice.info;
    maxPrice.info = minPrice.info;
    minPrice.info = tmp;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
