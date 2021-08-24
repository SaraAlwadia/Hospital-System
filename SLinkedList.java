
package SaraFinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class SLinkedList {
    
     private Node head;
     private Node tail;
     private int size;
     Scanner in = new Scanner(System.in);
     public SLinkedList()
     {
         head = null;
         tail = null;
         size = 0;
     }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty()
    {
        if (head == null && tail == null )  // size == 0
            return true;
        else return false;
    }
    
     public void addFirst(Node e){
        if (isEmpty()) {
            head = e;
            tail = e;
            size++;
        }
        else e.next = head;
        head = e;
        size++;
    }
     
     public void addLast(Node e){
        if (isEmpty()) {
            head = e;
            tail = e;
            size++;
        }
        else{
            tail.next = e;
            tail = tail.next;
            size++;
        }
    }
     
     public void addMiddle(int valueBefore,Node e){
        if (isEmpty()){
            System.out.println("The value is NOT exist!");
        }
        else{
            Node i = null;
            Node t = null;
            i = head;
            while(!i.ID.equals(valueBefore)){
                i = i.next;
            }
            if (i.ID.equals(valueBefore) && i != tail) {
                t = i.next;
                e.next = t;
                i.next = e;
                size++;
            }
            if (i.ID.equals(valueBefore) && i == tail) {
                addLast(e);
            }
        }
    }
     
     public Node RemoveFirst(){
        if(isEmpty())
            return null;
        else if(size == 1){
            Node temp = null;
            temp = head; // or tail مش رح تفرق;
            tail= null;
            head = null;
            size --;
            return temp;
        }else {
            Node temp = null;
            temp = head;
            head = head.next;
            temp.next = null;
            size--;
            return temp;
        }
    }
     
     public Node RemoveLast(){
        if(isEmpty())
            return null;
        else if(size == 1){
            Node temp = null;
            temp = tail; // or head;
            tail= null;
            head = null;
            size --;
            return temp;
        }else{
            Node temp = null;
            Node i = null;
            temp = tail;
            i= head;
            while(i.next != tail){
                i= i.next;
            }
            tail=i;
            tail.next = null;
            size--;
            return temp;
        }
    }
     
     public Node RemoveMiddle(String valueDeleted){
        if (isEmpty()) {
            return null;
        }
        else{
            Node temp = null;
            Node i = null;
            Node t = null;
            temp = head;
            while(!temp.ID.equals(valueDeleted)){
                temp = temp.next;
            }
            if (temp.ID.equals(valueDeleted) && temp == head) { 
               temp = RemoveFirst();
            }
            else if (temp.ID.equals(valueDeleted) && temp == tail) {
                temp = RemoveLast();
            }
            else if (temp.ID.equals(valueDeleted)) {
                i = head;
                while(i.next != temp){
                    i = i.next;
                }
                
                 t = temp.next;
                 i.next = t;
                 temp.next = null;
                 size--;
                 System.out.println(temp);
            }
            else{
                return null; 
            }
            return null;
        }
    }
     
     
     int m;
     public void Search(String value){
        if (isEmpty()) {
            System.out.println("The list is empty!");
           m=0;
        }
        else{
            Node temp = null;
            temp = head;
            while(!temp.ID.equals(value)&& temp.next != null){
                temp = temp.next;
            }
            if (temp.ID.equals(value) || temp.patientName.equals(value)) {
               m=1;
            }
            else{
               m=0;
            }
            if (m==1) {
                System.out.println("The value EXIST");
                System.out.println(temp);
            }else{
                 System.out.println("The value is not EXIST");
            }
        }
    }
     
     public void printList(){
            if (isEmpty()) {
                System.out.println("No elements to print!");
            }
            else{
                Node temp = null;
                temp = head;
                while(temp != null){
                    System.out.println(temp);
                    temp = temp.next;
                }
            }
    }
     
     public void SortAlpha(){
        Node temp = null;
        temp = head;
        ArrayList<Node> Names = new ArrayList<>();
        ArrayList<Node> SortNames = new ArrayList<>();
        String alpha="123456789abcdefghijklmnopqrstuvwxyz"; 
                while(temp!=null){
                    Names.add(temp);
                    System.out.println();
                    temp = temp.next;
                }

                for (int j = 0; j < alpha.length(); j++) {
                    for (int l = 0; l < Names.size(); l++) {
                    for (int k = 0; k < Names.size(); k++) {

                        if ((alpha.charAt(j)+"").equalsIgnoreCase(Names.get(k).patientName.charAt(0)+"") ) {
                            SortNames.add(Names.get(k));
                            System.out.println();
                            Names.remove(k);
                        }
                    }
                }}
                System.out.println(SortNames+"\n");
     
     }
     
     public void SortEmergency(){
      if (isEmpty()) {
                System.out.println("No elements to print!");
            }else{
                Node temp = null;
                temp = head;
                while(temp != null){
                    if (temp.type.equals("Emergency Service")) {
                        System.out.println(temp);
                    }
                        temp = temp.next;
                        }
                }
     }
     
     public void SortOPD(){
    if (isEmpty()) {
                System.out.println("No elements to print!");
            }else{
                Node temp = null;
                temp = head;
                while(temp != null){
                    if (temp.type.equals("O.P.D. Service")) {
                        System.out.println(temp);
                    }
                        temp = temp.next;
                    }
                   
                }
            }
    
     public void SortDate(){
        if (isEmpty()) {
                System.out.println("No elements to print!");
            }else{
                Node temp = null;
                temp = head;
                System.out.println("Enter Date: Day(EEE) Month(MMM) dd HH:mm:ss zzz(GMT+) Year(yyyy)");
                String dat = in.next();
                while(temp != null){
                    if (temp.date.equals(dat)) {
                        System.out.println(temp);
                    }else{
                        System.out.println("No Elements!");
                    }
                        temp = temp.next;
                        }
                   
                }
     }
}


                            

