
package SaraFinalProject;

import java.util.Date;


public class Node {

    String ID;
    String patientName;
    String patientAddress;
    int patientAge;
    String patientGender;
    String diseaseDescription;
    String type;
    Date date;
    String department;
    Node next;

    
    public Node(String id,String name, String address, int age, String gender,
            String disease, String type, Date dat, String department){
        next = null;
        ID= id;
        patientName = name;
        patientAddress = address;
        patientAge = age;
        patientGender = gender;
        diseaseDescription = disease;
        this.type = type;
        date = dat;
        this.department = department;
    }
    
    @Override
    public String toString(){
       return String.format("ID:%s | Name:%s | Address:%s | Age:%d | Gender:%s | "
               + "Disease Description:%s | Type(O.P.D./Emergency:%s) | Date:%s | "
               + "Department:%s)"+"\n", ID,patientName,patientAddress,patientAge,
               patientGender,diseaseDescription,type,date, department);
    }
 
   
}
