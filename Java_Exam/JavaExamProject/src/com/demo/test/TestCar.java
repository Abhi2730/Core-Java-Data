package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Car;
import com.demo.service.CarService;
import com.demo.service.CarServiceImpl;

public class TestCar {

	public static void main(String[] args) {
		
		
		CarService cservice = new CarServiceImpl();
		//To read Object From File
		cservice.readFromFile();
		
		Scanner scn = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			//Main Menu
			System.out.println("Car Management System");
			System.out.println("1.Add new Car");
			System.out.println("2.Display All Car");
			System.out.println("3.Delete a Car by Car ID");
			System.out.println("4.Search Car Based on Manufacturing place");
			System.out.println("5.Search car based on Price");
			System.out.println("6.Sort cars based on Owner name");
			System.out.println("7.Exit");
			System.out.println("Enter Your Choice");
			choice = scn.nextInt();
			
			switch(choice)
			{
				//To add Car Details
				case 1:
					boolean status = cservice.addNewCar();
					if(status)
					{
						System.out.println("Car Added Successfully");
					}
					else
					{
						System.out.println("Error Ocurred");
					}
					break;
				
				//To display All Car Details
				case 2:
					List<Car> clst = cservice.displayAllCars();
					if(clst!=null)
					{
						clst.forEach(System.out::println);
					}
					break;
				
				//To delete a Car By its ID
				case 3:
					System.out.println("Enter Car Id to be Deleted");
					int id = scn.nextInt();
					
					status= cservice.deleteCarById(id);
					if(status)
					{
						System.out.println("Car Deleted Successfully");
					}
					else
					{
						System.out.println("Not Found");
					}
					break;
				
				//To search a Car by its Manufacturing Place
				case 4:
					System.out.println("Enter Manufacturing place for which you want to Search");
					String place=scn.next();
					
					List<Car> clist = cservice.searchByPlace(place);
					if(clist!=null) {
						clist.forEach(System.out::println);
					}
					else
					{
						System.out.println("Not Found");
					}
					
					break;
				
				//To search a Car by its Price
				case 5:
					System.out.println("Enter The Price to be Searched");
					float price=scn.nextFloat();
					
					clist=cservice.searchByPrice(price);
					if(clist!=null) {
						clist.forEach(System.out::println);
					}
					else
					{
						System.out.println("Not Found");
					}
					break;
				
				//Sort Cars Based on Owners Name
				case 6:
					clist=cservice.sortByName();
					clist.stream().forEach(System.out::println);
					break;
				
				//Exit And To write in File Method
				case 7:
					cservice.writeInFile();
					scn.close();
					System.out.println("Thank You!");
					break;
					
				default:
					System.out.println("Wrong choice");
					break;
			}
			
			
		}while(choice!=7);

	}

}
