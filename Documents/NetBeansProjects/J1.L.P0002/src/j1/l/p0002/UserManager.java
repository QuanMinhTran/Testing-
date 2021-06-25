/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0002;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class UserManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String filename="User.txt";
        boolean changed=false;
        Menu menu=new Menu(9);
        menu.add("Create new user");
        menu.add("Update user");
        menu.add("Remove user");
        menu.add("Check exist user");
        menu.add("Search user");
        menu.add("Print");
        menu.add("Save into file");
        menu.add("Quit");
        int choice;
        UserList userlist=new UserList();
        userlist.AddFromFile(filename); 
        do{
            System.out.println("                            ");
            System.out.println("--------USER MANAGER--------");
            choice=menu.getChoice();
            switch(choice)
            {
                case 1: userlist.create(); changed=true; break;
                case 2: userlist.update(); changed=true; break;
                case 3: userlist.remove(); changed=true; break;
                case 4: userlist.checkexist(); break;
                case 5: userlist.checkname(); break;
                case 6: userlist.print(); break;
                case 7: userlist.saveToFile(filename); changed=false; break;
                default: if(changed)
                {
                    System.out.println("Save changes? (Y to confirm)");
                    String response=sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        userlist.saveToFile(filename);
                }
                System.out.println("Goodbye!"); break;
            }
        }
        while(choice>=1 &&choice<8);
    }
}
