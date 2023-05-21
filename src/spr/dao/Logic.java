/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spr.dao;

import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import spr.beans.Student;

/**
 *
 * @author deshp
 */
public class Logic {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    Scanner sc = new Scanner(System.in);
    //to insert student record
    public void insertRecord(Student student)throws Exception
    {
        template.save(student);
        //OR
//        template.execute(new HibernateCallback<Object>(){
//            @Override
//            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
//            {
//                session.save(student);
//                return null;
//            }
//        });
    }
    
    //to delete record
    public void deleteRecord()throws Exception
    {
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                out.print("Enter roll no to delete the record: ");
                int rollNo = sc.nextInt();
                Student stu = (Student)session.get(Student.class, rollNo);
                if(stu!=null){
                    session.delete(stu);
                    out.println("Record Deleted Successfully!");
                }else{
                    out.println("No Such Record Found!");
                }
                    
                return null;
            }
        });
    }
    
    //to search record
    public void searchRecord()throws Exception
    {
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                out.print("Enter roll no to search the record: ");
                int rollNo = sc.nextInt();
                Student stu = (Student)session.get(Student.class, rollNo);
                if(stu!=null){
                    out.println(stu.toString());
                }else{
                    out.println("No Such Record Found!");
                }
                    
                return null;
            }
        });
    }
    
    //show all records
    public void showAllRecords()throws Exception{
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                Query q = session.createQuery("from Student");
                List<Student> list = q.list();
                for(Student stu: list){
                    out.println(stu.toString());
                }
                    
                return null;
            }
        });
    }
    
    //update name
    public void updateName(int rollNo,String name)throws Exception{
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                
                Student stu = (Student)session.get(Student.class, rollNo);
                
                if(stu!=null){
                    Query q = session.createQuery("update Student set name=:n where rollNo=:r");
                    q.setParameter("n",name);
                    q.setParameter("r",rollNo);
                    q.executeUpdate();
                    out.println("Name updated successfully");
                }else{
                    out.println("No Such Record Found!");
                }
                    
                return null;
            }
        });
    }
    
    //update age
    public void updateAge(int rollNo,int age)throws Exception{
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                
                Student stu = (Student)session.get(Student.class, rollNo);
                
                if(stu!=null){
                    Query q = session.createQuery("update Student set age=:n where rollNo=:r");
                    q.setParameter("n",age);
                    q.setParameter("r",rollNo);
                    q.executeUpdate();
                    out.println("Age updated successfully");
                }else{
                    out.println("No Such Record Found!");
                }
                    
                return null;
            }
        });
    }
    
    //update phoneNo
    public void updatePhoneNo(int rollNo,String phoneNo)throws Exception{
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                
                Student stu = (Student)session.get(Student.class, rollNo);
                
                if(stu!=null){
                    Query q = session.createQuery("update Student set phoneNo=:n where rollNo=:r");
                    q.setParameter("n",phoneNo);
                    q.setParameter("r",rollNo);
                    q.executeUpdate();
                    out.println("PhoneNo updated successfully");
                }else{
                    out.println("No Such Record Found!");
                }
                    
                return null;
            }
        });
    }
}
