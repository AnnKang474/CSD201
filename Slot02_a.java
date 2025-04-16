package SL2;


import java.util.ArrayList;
import java.util.List;
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
public class Slot02_a {
    public static void main(String[] args) {
        List<Integer> list1= new ArrayList<Integer>();
        
        list1.add(5);
        list1.add(10);
        for (int i = 0; i < 1000; i++) {
            list1.add(i);
            
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list1.get(i));
            
        }
        //list1.remove(0);
        //list1.remove(list1.size()-1);
        list1.indexOf(5);// vi tri so 5
        list1.get(list1.indexOf(5));
        System.out.println("so:"+list1.get(5));
        
       
        
        
        System.out.println("So Luong : "+list1.size());
    }
}
