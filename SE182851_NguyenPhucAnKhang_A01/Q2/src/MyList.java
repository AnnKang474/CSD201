
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

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
         Phone newPhone = new Phone(id,name,price);
        Node newNode = new Node(newPhone);
        if (price>0) {
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
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        for (int i = 0; i < 2; i++) {
    if (head != null) {
        head = head.next;
        if (head != null) {
            head.pre = null;
        }
        size--;
    }
}

       
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: remove the all Phone 'I'
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Node p = head;
while (p != null) {
    if (p.info.name.equals("I")) {
        Node toDelete = p;
        if (toDelete.pre != null) {
            toDelete.pre.next = toDelete.next;
        } else {
            head = toDelete.next;
        }

        if (toDelete.next != null) {
            toDelete.next.pre = toDelete.pre;
        } else {
            tail = toDelete.pre;
        }

        size--;
    }
    p = p.next;
}

        
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f4: add a new Phone to the possition "after the head node"
    // (only add if the list does not contain the ID of the new Phone).
    // This also means that: 
    // (1) you should check the ID of the new Phone exist in the list or not; 
    // (2) if it does not exist, you write your code to add it to the list.
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
		Phone t = new Phone(999, "FPT", 25);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
		
		boolean exists = false;
Node p = head;
while (p != null) {
    if (p.info.ID == t.ID) {
        exists = true;
        break;
    }
    p = p.next;
}

if (!exists) {
    Node newNode = new Node(t);
    if (head == null) {
        head = tail = newNode;
    } else {
        newNode.next = head.next;
        newNode.pre = head;
        if (head.next != null) {
            head.next.pre = newNode;
        } else {
            tail = newNode;
        }
        head.next = newNode;
    }
    size++;
}


        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f5: swap min and max 
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (head == null || head.next == null) return;

Node minNode = head, maxNode = head;
Node p = head.next;

while (p != null) {
    if (p.info.price < minNode.info.price) {
        minNode = p;
    }
    if (p.info.price > maxNode.info.price) {
        maxNode = p;
    }
    p = p.next;
}

// Hoán đổi info của 2 node
Phone temp = minNode.info;
minNode.info = maxNode.info;
maxNode.info = temp;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
