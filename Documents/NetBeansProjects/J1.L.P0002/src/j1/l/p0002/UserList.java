/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0002;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class UserList {
    ArrayList<User> userlist;
    Scanner sc=new Scanner(System.in);
    
    public UserList() {
        userlist=new ArrayList<>();
    }
    
    public int searchUserName(String name)
    {
        int i=0;
        for (User user : userlist) {
            if(name.equals(user.getUserName()))
                return i;
            i++;
        }
        return -1;
    }
    
    public void create()
    {
        String userName=" ", firstName=" ", lastName=" ";
        String email=" ", phone=" ";
        String password=" ", confirm=" ";
        int check=0;
        String conf=" ";
        do{
            do{
                try
                {
                    check=0;
                    System.out.println("Input user name (>5 characters, no space): ");
                    userName=sc.nextLine();
                    if(userName.isEmpty()) throw new Exception("Empty Input");
                    if(userName.length()<5) throw new Exception("Short Input");
                    if(userName.contains(" ")) throw new Exception("Contain Space");
                    if(searchUserName(userName)>-1) throw new Exception("Already Use");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
   
            do{
                try
                {
                    check=0;
                    System.out.println("Input first name: ");
                    firstName=sc.nextLine();
                    if(firstName.isEmpty()) throw new Exception("Empty Input");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
            
            do{
                try
                {
                    check=0;
                    System.out.println("Input last name: ");
                    lastName=sc.nextLine();
                    if(lastName.isEmpty()) throw new Exception("Empty Input");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
            
            do{
                try
                {
                    check=0;
                    System.out.println("Input password (>6 characters, no space): ");
                    password=sc.nextLine();
                    if(password.isEmpty()) throw new Exception("Empty Input");
                    if(password.length()<6) throw new Exception("Short Input");
                    if(password.contains(" ")) throw new Exception("Contain Space");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
            
            do{
                try
                {
                    check=0;
                    System.out.println("Input confirm password (match password): ");
                    confirm=sc.nextLine();
                    if(!confirm.matches(password)) throw new Exception("Not Match");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
            
            do{
                try
                {
                    check=0;
                    System.out.println("Input phone number (10 only): ");
                    phone=sc.nextLine();
                    if(phone.isEmpty()) throw new Exception("Empty Input");
                    if(phone.length()!=10) throw new Exception("Wrong Length");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }while(check!=0);
            
            do
            {
                try
                {
                    check=0;
                    System.out.println("Input email: ");
                    email=sc.nextLine();
                    if(!email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z]+){1,2}")) throw new Exception("Wrong Standard");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    check=1;
                }
            }
            while(check!=0);
            
            User user=new User(userName, firstName, lastName, email, phone, password);
            userlist.add(user);
            System.out.println("Done!");
            
            System.out.println("Do you want to continue? (Y to continue)");
            conf=sc.nextLine();
            conf=conf.trim().toUpperCase();
        }while(conf.startsWith("Y"));
    }
    
    public void AddFromFile(String fName)
    {
        try
        {
            File f=new File(fName);
            if(!f.exists()) return;
            FileReader fr=new FileReader(f);
            BufferedReader bf=new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null)
            {
                StringTokenizer stk=new StringTokenizer(details, ",");
                String userName= stk.nextToken().trim().toUpperCase();
                String firstName= stk.nextToken().trim().toUpperCase();
                String lastName= stk.nextToken().trim().toUpperCase();
                String phone= stk.nextToken().trim().toUpperCase();
                String email= stk.nextToken().trim().toUpperCase();
                String password= stk.nextToken().trim().toUpperCase();
                
                User user=new User(userName, firstName, lastName, email, phone, password);
                userlist.add(user);
            }
            bf.close(); fr.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName)
    {
        if(userlist.size()==0)
        {
            System.out.println("Empty Líst");
            return ;
        }
        try
        {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (User user : userlist) {
                pw.println(user.getUserName()+", "+user.getFirstName()+", "+user.getLastName()+", "+user.getPhone()+", "+user.getEmail()+", "+user.getPassword());
            }
            pw.close(); fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void remove()
    {
        String password, username;
        String conf, delconf;
        int pos=0, flag=0;
        do
        {
            do
            {    
            try
            {
            flag=0;
            System.out.println("Input user name: ");
            username=sc.nextLine();
            username=username.toUpperCase().trim();
            System.out.println("Input password: ");
            sc=new Scanner(System.in);
            password=sc.nextLine();
            password=password.toUpperCase().trim();
            pos=searchUserName(username);
            User check=userlist.get(pos);
            if(pos<0) throw new Exception("Wrong User Name");
            if(!check.getPassword().equals(password)) throw new Exception("Wrong Password");
            if(password.isEmpty() || username.isEmpty()) throw new Exception("Empty Input");
            }
            catch(Exception e)
            {
                System.out.println(e);
                flag=1;
            }
            }while(flag!=0);
            
            System.out.println("Do you want to delete this user? (Y to confirm)");
            delconf=sc.nextLine();
            delconf=delconf.trim().toUpperCase();
            if(delconf.startsWith("Y")) 
            {
                userlist.remove(pos);
                System.out.println("Done!");
            }
            else System.out.println("You didn't remove this user!");
            
            System.out.println("Do you want to continue? (Y to continue)");
            conf=sc.nextLine();
            conf=conf.trim().toUpperCase();
            
        }while(conf.startsWith("Y"));    
    }
    
    public void update()
    {
        String logpass, logname;
        String conf, delconf;
        
        String userName=" ", firstName=" ", lastName=" ";
        String email=" ", phone=" ";
        String password=" ", confirm=" ";
        User check=null;
        
        int pos=0, flag=0;
        do
        {
            do
            {    
            try
            {
            flag=0;
            System.out.println("Input user name: ");
            logname=sc.nextLine();
            logname=logname.toUpperCase().trim();
            System.out.println("Input password: ");
            logpass=sc.nextLine();
            logpass=logpass.toUpperCase().trim();
            pos=searchUserName(logname);
            check=userlist.get(pos);
            if(logpass.isEmpty() || logname.isEmpty()) throw new Exception("Empty Input");
            if(pos<0) throw new Exception("Wrong User Name");
            if(!check.getPassword().equals(logpass)) throw new Exception("Wrong Password");
            }
            catch(Exception e)
            {
                System.out.println(e);
                flag=1;
            }
            }while(flag!=0);
            
            do{
                try
                {
                    flag=0;
                    System.out.println("Input first name (empty for no change): ");
                    firstName=sc.nextLine();
                    if(!firstName.isEmpty()) 
                    {
                        check.setFirstName(firstName);
                        System.out.println("Changed!");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    flag=1;
                }
            }while(flag!=0);
            
            do{
                try
                {
                    flag=0;
                    System.out.println("Input last name (empty for no change): ");
                    lastName=sc.nextLine();
                    if(!lastName.isEmpty()) 
                    {
                        check.setLastName(lastName);
                        System.out.println("Changed!");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    flag=1;
                }
            }while(flag!=0);
            
            do{
                try
                {
                    flag=0;
                    System.out.println("Input password (empty for no change): ");
                    password=sc.nextLine();
                    if(!password.isEmpty()) 
                    {
                        if(password.length()<6) throw new Exception("Short Input");
                        if(password.contains(" ")) throw new Exception("Contain Space");
                        check.setPassword(password);
                        System.out.println("Changed!");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    flag=1;
                }
            }while(flag!=0);
            
            if(!password.isEmpty())
            {
                do{
                    try
                    {
                        flag=0;
                        System.out.println("Input confirm password (match password): ");
                        confirm=sc.nextLine();
                        if(!confirm.matches(password)) throw new Exception("Not Match");
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                        flag=1;
                    }
                }while(flag!=0);
            }
            
            do{
                try
                {
                    flag=0;
                    System.out.println("Input phone number (empty for no change)): ");
                    phone=sc.nextLine();
                    if(!phone.isEmpty())
                    {
                        if(phone.length()!=10) throw new Exception("Wrong Length");
                        check.setPhone(phone);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    flag=1;
                }
            }while(flag!=0);
            
            do
            {
                try
                {
                    flag=0;
                    System.out.println("Input email: (empty for no change)");
                    email=sc.nextLine();
                    if(!email.isEmpty())
                    {
                        if(!email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z]+){1,2}")) throw new Exception("Wrong Standard");
                        else check.setEmail(email);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    flag=1;
                }
            }
            while(flag!=0);
            
            System.out.println("Do you want to continue? (Y to continue)");
            conf=sc.nextLine();
            conf=conf.trim().toUpperCase();
            
        }while(conf.startsWith("Y"));    
    }
    
    public void checkexist()
    {
        String searchName=" ";
        String conf=" ";
        do
        {
        System.out.println("Input search username: ");
        searchName=sc.nextLine();
        int pos=searchUserName(searchName);
        if(pos<0) System.out.println("No User Found!");
        else System.out.println("Exist User");
        
        System.out.println("Do you want to continue? (Y to continue)");
        conf=sc.nextLine();
        conf=conf.trim().toUpperCase();
            
        }while(conf.startsWith("Y"));
    }
    
    public void checkname()
    {
        String searchName=" ";
        String conf=" ";
        int check=1;
        do
        {
        System.out.println("Input search string: ");
        searchName=sc.nextLine();
        searchName=searchName.toUpperCase().trim();
        Collections.sort(userlist);
        for (User user : userlist) {
            if(user.getFirstName().contains(searchName) || user.getLastName().contains(searchName))
            {
                System.out.println(user);
                check=0;
            }        
        }
        if(check!=0) System.out.println("None user match String");
        
        System.out.println("Do you want to continue? (Y to continue)");
        conf=sc.nextLine();
        conf=conf.trim().toUpperCase();
        
        }while(conf.startsWith("Y"));
    }
    
    public void print()
    {
        if(userlist.size()==0)
        {
            System.out.println("Empty List.");
            return;
        }
        Collections.sort(userlist);
        System.out.println("\nUSER LIST");
        System.out.println("--------------------------");
        for (User user : userlist) 
            System.out.println(user);
    }
}
