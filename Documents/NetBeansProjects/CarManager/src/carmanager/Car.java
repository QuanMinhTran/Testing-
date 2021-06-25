package carmanager;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Car implements Comparable<Car> {
    private int id;
    private String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Car t) {
        //id va t.id la dai dien cho xe 1 va xe 2
        if(id > t.getId())
            return 1;
        else if(id < t.getId())
            return -1;
        return 0;
    }
    
    //tao 1 class cai dat interface comparator
    //dung class này de so sanh 2 xe dua vao ten
    public static Comparator<Car> byName=new Comparator<Car>()
    {
        @Override
        public int compare(Car c1, Car c2) {
            if(c1.getName().compareTo(c2.getName())>0)
                return 1;
            else if(c1.getName().compareTo(c2.getName())<0)
                return -1;
            return 0;
        }        
    };
    
    
}
    

