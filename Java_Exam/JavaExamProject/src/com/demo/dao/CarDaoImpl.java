package com.demo.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.beans.Car;

public class CarDaoImpl implements CarDao{
	
	//List of Car using ArrayList
	static List<Car> clist;
	static {
		clist= new ArrayList<>();
	}
	
	//Adding Cars into list
	@Override
	public boolean addNewCar(Car c) {
		
		return clist.add(c);
	}
	
	//Displaying all cars by returning list
	@Override
	public List<Car> displayAllCars() {
		return clist;
	}
	
	//Writing into File By using ObjectOutputStream and binding it with FileOutputStream
	@Override
	public void writeInFile() {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cardetails.txt"));){
			
			for(Car c:clist)
			{
				oos.writeObject(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Reading from a file using ObjectInputStream
	@Override
	public void readFile() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardetails.txt"));){
			
			while(true) {
				
				Car car = (Car)ois.readObject();
				clist.add(car);
			}
				
			
		} catch(EOFException e) {
			System.out.println("End OF File");
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Deleting a car by its Id
	@Override
	public boolean deleteCarById(int id) {
		
		return clist.remove(new Car(id));
	}
	
	//Searching based on Manufacturing Place.Equals to given place By user
	@Override
	public List<Car> searchByPlace(String place) {
		
		List<Car> lst = clist.stream()
				.filter(ob->ob.getManu_place().equals(place))
				.collect(Collectors.toList());
		if(lst.isEmpty()) {
			return null;
		}
		return lst;
		
	}
	
	//Searching cars based on its Price . Cars which are below or equal to the given Price
	@Override
	public List<Car> searchByPrice(float price) {
		List<Car> lst = clist.stream()
				.filter(ob->ob.getCar_price()<=price)
				.collect(Collectors.toList());
		if(lst.isEmpty()) {
			return null;
		}
		return lst;
	}
	
	//Sorting cars based on Owner Name By using Comparable and CompareTo method
	@Override
	public List<Car> sortByName() {
		List<Car> lst=new ArrayList<>();
		for(Car p:clist) {
			lst.add(p);
		}
		
		lst.sort(null);
		return lst;
	}
	
	

}
