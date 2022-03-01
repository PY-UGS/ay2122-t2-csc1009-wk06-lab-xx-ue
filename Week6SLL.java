package com.company;
import java.util.*;


public class Week6SLL {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        LinkedList ll =new LinkedList();
        ll.push(1);
        ll.push(3);
        ll.push(5);
        ll.push(7);
        ll.push(9);
        ll.push(11);
        System.out.println("Pt1: Linked List Before :");
        ll.printList();
        System.out.println("Part 1 input: ");
        int Part1= input.nextInt();
        ll.addAndSort(Part1);
        System.out.println("Pt1: Linked List After :");
        ll.printList();

        System.out.println("Part 2 inputs: indexOne and indexTwo");
        int i1= input.nextInt();
        int i2=input.nextInt();
        System.out.println("Pt2: Linked List Before :");
        ll.printList();
        ll.swapValues(i1,i2);
        System.out.println("Pt2: Linked List After :");
        ll.printList();

        LinkedList l2 =new LinkedList();
        Random randnumber = new Random();
        for (int i=0;i<500;i++){

            int number = (randnumber.nextInt(8999))+1000;
            l2.push(number);
        }
        System.out.println("Pt3: Linked List generated :");
        l2.printList();
        int check =(int) (Math.random()*9999+1000);
        System.out.println("Pt3 Find "+ check);
        System.out.println("result "+ l2.findValue(check));
    }}
class Node {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
class LinkedList {
    Node head;
    public void swapValues (int indexOne, int indexTwo)
    {
        if (indexOne == indexTwo)
            return;
        Node prevX = null, currX = head;
        int i1=0;
        while (i1!=indexOne) {
            prevX = currX;
            currX = currX.next;
            i1+=1;
        }
        int i2=0;
        Node prevY = null, currY = head;
        while (i2!=indexTwo) {
            prevY = currY;
            currY = currY.next;
            i2+=1;
        }
        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }
    public void addAndSort(int value) {
        if (value > head.data) {
            Node new_N = new Node(value);
            new_N.next = head;
            head = new_N;
        } else {
            Node new_N = new Node(value);
            Node temp = head;
            Node prev=null;
            while (temp.data > value) {
                prev=temp;
                temp = temp.next;
            }

            prev.next=new_N;
            prev.next.next=temp;
        }
    }
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }
    public int  findValue(int searchVal){
        int position=0;
        while(head.next !=null){
            if(head.data !=searchVal){
                head=head.next;
                position+=1;
            }
            if(head.data==searchVal){
                return position;
            }
            else if(position==499){
                if (head.data!=searchVal){
                    position=-1;
                }
            }
            }
        return position;
    }



    }
