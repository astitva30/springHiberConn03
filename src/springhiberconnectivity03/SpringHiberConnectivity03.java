/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package springhiberconnectivity03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spr.dao.Logic;
import static java.lang.System.out;
import java.util.Scanner;
import spr.beans.Student;

/**
 *
 * @author deshp
 */
public class SpringHiberConnectivity03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/SpringXMLConfig.xml");
        
        Logic logic = (Logic)context.getBean("technosoft");
        
        out.println("---------------SELECT----------------");
        out.println("1.Register New Student Record");
        out.println("2.Delete Student Record");
        out.println("3.Update Student Record");
        out.println("4.Search a Student Record");
        out.println("5.Get all Student Records");
        
        Scanner sc = new Scanner(System.in);
        out.println();
        out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch(choice){
            case 1:
                out.println("Enter the details--------->");
                out.print("Enter your Roll Number: ");
                int rollNo = sc.nextInt();
                out.print("Enter your Name: ");
                String name = sc.next();
                out.print("Enter your age: ");
                int age = sc.nextInt();
                out.print("Enter your Phone No: ");
                String phoneNo = sc.next();
                out.print("Enter your Marks: ");
                int marks = sc.nextInt();
                out.print("Enter your Subject: ");
                String subject = sc.next();
                
                Student stu = new Student(rollNo,name,age,phoneNo,marks,subject);
                
                logic.insertRecord(stu);
                break;
            case 2:
                logic.deleteRecord();                
                break;
            case 3:
                out.print("Enter your Roll Number to update the details: ");
                int rRollNo = sc.nextInt();
                out.println("1.Update Name");
                out.println("2.Update Age");
                out.println("3.Update Phone No.");
                out.println("---------------ENTER YOUR CHOICE TO UPDATE----------------");
                int updateChoice = sc.nextInt();
                switch(updateChoice){
                    case 1:
                        out.print("Enter New Name: ");
                        String uName = sc.next();
                        logic.updateName(rRollNo,uName);
                        break;
                    case 2:
                        out.print("Enter New Age: ");
                        int uAge = sc.nextInt();
                        logic.updateAge(rRollNo, uAge);
                        break;
                    case 3:
                        out.print("Enter New Phone No: ");
                        String uPhoneNo = sc.next();
                        logic.updatePhoneNo(rRollNo, uPhoneNo);
                        break;
                }
                break;
                
            case 4:
                logic.searchRecord();
                break;
            
            case 5:
                out.println("----------- ALL RECORDS ------------");
                logic.showAllRecords();
                break;                
        }   
                
        
    }
    
}
