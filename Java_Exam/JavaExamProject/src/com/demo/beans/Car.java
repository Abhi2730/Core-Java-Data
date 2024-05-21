package com.demo.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Car implements Serializable,Comparable<Car>{

	private int car_id;
	private String owner_name;
	private LocalDate dopur;
	private String salesman_name;
	private String manu_place;
	private String car_model;
	private float car_price;
	
	public Car() {
		super();
	}

	//Parameterized Constructor
	public Car(int car_id, String owner_name, LocalDate dopur, String salesman_name, String manu_place,
			String car_model, float car_price) {
		super();
		this.car_id = car_id;
		this.owner_name = owner_name;
		this.dopur = dopur;
		this.salesman_name = salesman_name;
		this.manu_place = manu_place;
		this.car_model = car_model;
		this.car_price = car_price;
	}

	//Paramaterized Constructor For ID only
	public Car(int car_id) {
		super();
		this.car_id = car_id;
	}

	//Getter Setter Methods
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public LocalDate getDopur() {
		return dopur;
	}

	public void setDopur(LocalDate dopur) {
		this.dopur = dopur;
	}

	public String getSalesman_name() {
		return salesman_name;
	}

	public void setSalesman_name(String salesman_name) {
		this.salesman_name = salesman_name;
	}

	public String getManu_place() {
		return manu_place;
	}

	public void setManu_place(String manu_place) {
		this.manu_place = manu_place;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public float getCar_price() {
		return car_price;
	}

	public void setCar_price(float car_price) {
		this.car_price = car_price;
	}

	//ToString 
	@Override
	public String toString() {
		return "Car [Car Id= " + car_id + ", Owner Name = " + owner_name + ", Date Of Purchase = " + dopur + ", SalesMan Name= "
				+ salesman_name + ", Manufacturing Place= " + manu_place + ", Car Model= " + car_model + ", Car Price=" + car_price
				+ "]";
	}

	//Equals Method for id
	@Override
	public boolean equals(Object obj) {
		
		Car other = (Car) obj;
		return other.getCar_id()==other.getCar_id();
	}

	//For Sorting of Owner Name
	@Override
	public int compareTo(Car o) {
		
		return this.owner_name.compareTo(o.owner_name);
	}
	
	
}
