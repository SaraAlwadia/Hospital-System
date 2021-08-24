
package SaraFinalProject;

import java.util.Scanner;
import java.util.Date;

public class Users {
    
     Scanner in = new Scanner(System.in);
     SLinkedList sll = new SLinkedList();
     QueuePatient qp = new QueuePatient();
     Date date = new Date();
  
     public void Menu(){
        System.out.println("Choose from the MENU:\n 1.Admin\n 2.Doctor\n 3.Exit");
        int i= in.nextInt();
        if (i == 1) {
            Admin();
            Menu();
        }
        if (i == 2) {
            Doctor();
            Menu();
        }
        if (i ==3) {
            System.out.println("Exit");
            Menu();
        }
        else{
            System.out.println("No choice");
        }
    }
     
     public void Admin(){
         System.out.println("Choose from the List:\n 1.Add new patient record\n"
                    + " 2.Search or edit patient record\n 3.List record of patients\n "
                    + "4.Delete patient records\n 5.Register patient\n 6.Exit");
         
         int a = in.nextInt();
         if (a==1) {
             AddPatient();
             Admin();
         }
         if (a==2) {
             SearchorEdit();
             Admin();
         }
         if (a==3) {
             PrintList();
             Admin();
         }
         if (a==4) {
             DeletePatient();
             Admin();
         }
         if (a==5) {
             RegisterPatient();
             Admin();
         }
         if (a==6) {
            Menu();
         }
     }
     String PatientID, name, address, gender,description,depart;
     int age;
     private void AddPatient(){
         System.out.println(" 1.O.P.D.\n 2.Emergency");
         int i=in.nextInt();
         
         if (i==1) {
            System.out.println("Add new patient record:");
            System.out.println("Enter: ID | Name | Address | Age | Gender | "
                       + "Disease Description | Department");

            PatientID =in.next();
            name = in.next();
            address= in.next();
            age =in.nextInt();
            gender = in.next();
            description =in.next();
            depart = in.next();
        
            sll.addLast(new Node(PatientID,name, address, 
                        age,gender,description,"O.P.D. Service", date,depart));
            System.out.println();
            qp.enqueue(new Node(PatientID,name, address, 
                        age,gender,description,"O.P.D. Service", date,depart));
         }
         
         if (i==2) {
             System.out.println("Add new patient record:");
             System.out.println("Enter: ID | Name | Address | Age | Gender | "
                    + "Disease Description | Department");
            sll.addLast(new Node(in.next(),in.next(), in.next(), 
                        in.nextInt(),in.next(),in.next(),"Emergency Service",date,in.next()));
            qp.enqueue(new Node(PatientID,name, address, 
                        age,gender,description,"Emergency Service", date,depart));
            System.out.println();
         }
            }
     
     private void SearchorEdit(){
         System.out.print("Enter patient ID or Name: ");
         String id =in.next();
         sll.Search(id);
         if (sll.m == 1) {
             System.out.println("Edit?\n 1.Yes\n 2.No");
             int a= in.nextInt();
             if (a==1) {
                 AddPatient();
                 System.out.println();
                 sll.RemoveMiddle(id);
                 Admin();
         }
         if (a==2) {
             System.out.println("Go to the List\n");
             Admin();
         }
         }
     }
     
     
     private void PrintList(){
         System.out.println(" 1.Records all patients\n 2.Records of patients in alphabetical order\n "
                 + "3.Records of Emergency patients\n 4.Records of O.P.D. patients\n "
                 + "5.Records of patients in a particular date");
         int i = in.nextInt();
         if (i==1) {
             sll.printList();
             Admin();
         }
         if (i==2) {
             sll.SortAlpha();
             Admin();
         }
         if (i==3) {
             sll.SortEmergency();
             Admin();
         }
         if (i==4) {
             sll.SortOPD();
             Admin();
         }
         if (i==5) {
             sll.SortDate();
             Admin();
         }
         }
        
     
     private void DeletePatient(){
         System.out.print("Enter ID to delete:");
         String id = in.next();
         sll.Search(id);
         if (sll.m ==1) {
             sll.RemoveMiddle(id);
             System.out.println("Deleted!\n");
         }else{
             System.out.println("Not found!");
         }
     }
     
     
     int drid[]={000,001,002,003,004,005};
     private void RegisterPatient(){
        System.out.println("Enter patient ID or Name: ");
        String id=in.next();
        sll.Search(id);
         if (sll.m==1) {
             System.out.println("Already Register!");
             System.out.print("Send To Doctor: ");
             int x = in.nextInt();
             System.out.println(drid[x]);            
         }else{
             AddPatient();
         } 
     }
    
     
     public void Doctor(){
         System.out.println("Choose from the List:\n 1.Show the next Patient\n 2.Exit");
         int i = in.nextInt();
         if (i==1) {
             while(!qp.isEmpty()){
                NextPatient(); 
             }
           Doctor();  
         }
         if (i==2) {
             Menu();
         }
     }
     
     
     public void NextPatient(){
         System.out.println("Log In: ");
         
         int drID = in.nextInt();
         int m =0;
         for (int i = 0; i < drid.length; i++) {
             if (drID == drid[i]) {
                 m=1;
                 if (m==1) {
                     if (!qp.isEmpty()) {
                         System.out.println(qp.dequeue());
                     }else{
                         System.out.println("No Patient!");
                     }
                 }else{
                 System.out.println("Error Password!");
          }
         }
         }
     }
}
     
           

