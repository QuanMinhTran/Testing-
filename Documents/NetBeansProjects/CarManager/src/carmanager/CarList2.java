/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmanager;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class CarList2 {
    TreeSet<Car> list;
    
    public CarList2()
    {
        list = new TreeSet<>();
    }
    
    public void addCar(Car x)
    {
        list.add(x);
    }
    
    public void DisplayAll()
    {
        //LNR C1
        for (Car car : list){
            System.out.println(car);
        }
        
        //LNR C2
        Iterator<Car> tmp=list.iterator();
        while(tmp.hasNext())
        {
            Car x=tmp.next();
            System.out.println(x);
        }
        //RNL
        Iterator<Car> tmp2=list.descendingIterator();
        while(tmp2.hasNext())
        {
            Car x=tmp2.next();
            System.out.println(x);
        }
    }
    
     public Car findCar(int id)
    {
        for (Car car : list) {
            if(car.getId()==id)
                return car;
        }
        return null;
    }
    
    public void deleteCar(int id)
    {
        Car c=findCar(id);
        list.remove(c);
    }
    
    public void setCar(int id)
    {
        Car c=findCar(id);
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap new name: ");
        c.setName(sc.nextLine());
    }
    
}
