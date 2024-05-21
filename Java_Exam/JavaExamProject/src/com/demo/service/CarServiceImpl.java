package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Car;
import com.demo.dao.CarDao;
import com.demo.dao.CarDaoImpl;

public class CarServiceImpl implements CarService{
	
	CarDao cdao;
	public CarServiceImpl()
	{
		cdao = new CarDaoImpl();
	}
	
	//Adding new Car Details
	@Override
	public boolean addNewCar() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Car Id");
		int id=sc.nextInt();
		
		System.out.println("Enter Owner Name");
		String name=sc.next();
		
		System.out.println("Enter Date of Purchase");
		String date=sc.next();

		LocalDate dt=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Enter SalesMan Name");
		String sname=sc.next();
		
		System.out.println("Enter Place of Manufacturing");
		String mplace=sc.next();
		
		System.out.println("Enter Model");
		String model=sc.next();
		
		System.out.println("Enter Car price");
		float price=sc.nextFloat();
		
		
		Car c = new Car(id,name,dt,sname,mplace,model,price);
		
		return cdao.addNewCar(c);
	}
	
	//Display All Cars
	@Override
	public List<Car> displayAllCars() {
		return cdao.displayAllCars();
	}
	
	//Writeing in File
	@Override
	public void writeInFile() {
		
		cdao.writeInFile();
		
	}
	
	//Reading From File
	@Override
	public void readFromFile() {
		
		cdao.readFile();
		
	}
	
	//Delete a car
	@Override
	public boolean deleteCarById(int id) {
		
		return cdao.deleteCarById(id);
	}
	
	//Searching a Car
	@Override
	public List<Car> searchByPlace(String place) {
		
		return cdao.searchByPlace(place);
	}
	
	//Searching a Car
	@Override
	public List<Car> searchByPrice(float price) {
		
		return cdao.searchByPrice(price);
	}
	
	//Sorting Cars
	@Override
	public List<Car> sortByName() {
		
		return cdao.sortByName();
	}

}
