/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nable_exam4;

import java.util.Scanner;

/**
 *
 * @author Jake Marson Nable
 */
public class Nable_Exam4 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Nable_Exam4 stack = new Nable_Exam4();
                
        while (true) {            
            System.out.println("Welcome to Zak's Store");
            System.out.println("1. Add Product\n2. Sell Product\n3. Display Product");
            int choice = scan.nextInt();
            String product;
            int quantity;
            
            switch (choice) {
                case 1:
                    System.out.println("Enter Product Name");
                    scan.nextLine();//To consume white line.
                    product = scan.nextLine();
                    System.out.println("Enter Product Quantity");
                    quantity = scan.nextInt();
                    stack.push(product,quantity);
                    break;
                case 2:
                    System.out.println("Enter Product You want to sell");
                    scan.nextLine();//To consume white line.
                    product = scan.nextLine();
                    System.out.println("Enter The Quantity");
                    quantity = scan.nextInt();
                    
                    stack.pop(product, quantity);
                    break;
                case 3:
                    stack.display();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    //constractor
    public class Node{
        int quantity;
        String data;
        Node next;
    }
    
    private static Node top;
    private int size;
    
    //Overflow for memory/storage for insertion(push0
    private Node newNode(String element,int quantity)throws Exception{
        Node node = new Node();
        if(node == null){
            throw new Exception("Storage is full");
        } else{
            node.data = element;
            node.quantity = quantity;
            node.next = null;
            return node;
        }
    }
    
    private void push(String element,int quantity)throws Exception{
        //overflow indicator
        Node node = newNode(element,quantity);
        if(size == 0){
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }
    private Node pop(String element,int quantity)throws Exception{
        Node node = new Node();
        Node temporary = top;
        int quan = top.quantity;
        while(temporary != null){
            if(temporary.data == element){
                return temporary;
                
            } 
            temporary = temporary.next;
        }           
        node.quantity = quantity;
    return null;
    }
    
    private void display()throws Exception{
        //overflow indicator
        if(size == 0){
            throw new Exception("Stacks is Empty");
        }
        Node temporary = top;
        
         System.out.println("Product \t\t Quantity");
        while(temporary != null){
            System.out.println(temporary.data +"\t\t\t "+temporary.quantity);
            temporary = temporary.next;
        }
        System.out.println("\n");
    }

    
}
