package carmanager;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CarList {
    List<Car> list;
    
    public CarList()
    {
        list=new ArrayList();
    }
    
    public void AddCar(Car x)
    {
        list.add(x);
    }
    
    public void displayAll()
    {
        //cach 1
        for (int i=0;i<list.size(); i++)
            System.out.println(list.get(i));
        //cach 2
        for(Car car: list)
        {
            System.out.println(car);
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
    
    public void sortById()
    {
        Collections.sort(list);
    }
    
    //ham nay de sap xep tang theo ten xe
    public void sortByName()
    {
        Collections.sort(list, Car.byName);
    }
    
    
 }
