package com.demo.dao;

import java.util.List;

import com.demo.beans.Car;

public interface CarDao {

	boolean addNewCar(Car c);

	List<Car> displayAllCars();

	void writeInFile();

	void readFile();

	boolean deleteCarById(int id);

	List<Car> searchByPlace(String place);

	List<Car> searchByPrice(float price);

	List<Car> sortByName();

	

}
