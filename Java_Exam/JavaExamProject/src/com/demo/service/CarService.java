package com.demo.service;

import java.util.List;

import com.demo.beans.Car;

public interface CarService {

	boolean addNewCar();

	List<Car> displayAllCars();

	void writeInFile();

	void readFromFile();

	boolean deleteCarById(int id);

	List<Car> searchByPlace(String place);

	List<Car> searchByPrice(float price);

	List<Car> sortByName();

}
