package Init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import Core.Car;
import Core.Customer;
import Core.MotorCycle;
import Core.TransportCompany;
import Core.Vehicle;
import Utilities.E_Color;
import Utilities.E_Model;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Store store = new Store("store");
		Car c1 = new Car(E_Model.BMW,"1",E_Color.Black, "GERMANY", 4.2, 3, 2, 2020, 35,100000);
		Car c2 = new Car(E_Model.BMW,"2",E_Color.Black, "GERMANY", 2, 3, 2, 2021, 32,80000);
		Car c3 = new Car(E_Model.BMW,"3",E_Color.Red, "GERMANY", 3, 3, 2, 2022, 30,200000);
		Car c4 = new Car(E_Model.Honda,"Civic",E_Color.Black, "JAPAN", 4.2, 3, 2, 2018, 32,120000);
		Car c5 = new Car(E_Model.Honda,"Jazz",E_Color.Blue, "JAPAN", 2.2, 3, 2, 2017, 35,110000);
		Car c6 = new Car(E_Model.Mazda,"3",E_Color.Black, "JAPAN", 3.2, 3, 2, 2018, 28,10000);
		Car c7 = new Car(E_Model.Mazda,"6",E_Color.Red, "JAPAN", 5.2, 3, 2, 2019, 33,400000);
		Car c8 = new Car(E_Model.Mazda,"cx-5",E_Color.Pink, "JAPAN", 3.2, 3, 2, 2020, 35,300000);
		Car c9 = new Car(E_Model.Kia,"Forte",E_Color.Green, "South-Korea", 4.3, 3, 2, 2020, 38,103000);
		Car c10 = new Car(E_Model.Kia,"Picanto",E_Color.Gold, "South-Korea", 4, 3, 2, 2022, 28,125000);
		
		MotorCycle mc1 = new MotorCycle(E_Model.HondaBike,"a1",E_Color.Black, "JAPAN", 1.2, 0.5,2, true, 2022,125000);
		MotorCycle mc2 = new MotorCycle(E_Model.HondaBike,"a2",E_Color.Blue, "JAPAN", 1.2, 0.5,2, true, 2022,120000);
		MotorCycle mc3 = new MotorCycle(E_Model.Kawasaki,"b1",E_Color.Green, "JAPAN", 1.2, 0.5,2, false, 2022,135000);
		MotorCycle mc4 = new MotorCycle(E_Model.Kawasaki,"b2",E_Color.Purple, "JAPAN", 1.2, 0.5,2,false, 2022,145000);
		
		store.addItemsWithAmountToStore(c1, store.getVehicles(), 5);
		store.addItemsWithAmountToStore(c2, store.getVehicles(), 4);
		store.addItemsWithAmountToStore(c3, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(c4, store.getVehicles(), 3);
		store.addItemsWithAmountToStore(c5, store.getVehicles(), 4);
		store.addItemsWithAmountToStore(c6, store.getVehicles(), 5);
		store.addItemsWithAmountToStore(c7, store.getVehicles(), 1);
		store.addItemsWithAmountToStore(c8, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(mc1, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(mc2, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(mc3, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(mc4, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(c9, store.getVehicles(), 2);
		store.addItemsWithAmountToStore(c10, store.getVehicles(), 2);
		
		store.addItemsWithQniqueIdToStore("Company1",store.getCompenies(), new TransportCompany("1", "Company1"));
		store.addItemsWithQniqueIdToStore("Company2",store.getCompenies(), new TransportCompany("2", "Company2"));
		store.addItemsWithQniqueIdToStore("Company3",store.getCompenies(), new TransportCompany("3", "Company3"));
		
		store.addItemsWithAmountToStore("111111111",store.getCustomers(), new Customer("111111111","roni", "g", "Haifa", "mail.gmail.com"));
		store.addItemsWithAmountToStore("222222222",store.getCustomers(), new Customer("222222222","adi", "a", "Haifa", "mail.gmail.com"));
		store.addItemsWithAmountToStore("333333333",store.getCustomers(), new Customer("333333333","oren", "b", "Haifa", "mail.gmail.com"));
		store.addItemsWithAmountToStore("444444444",store.getCustomers(), new Customer("444444444","omri", "c", "tel-aviv", "mail.gmail.com"));
		store.addItemsWithAmountToStore("555555555",store.getCustomers(), new Customer("555555555","lior", "d", "tel-aviv", "mail.gmail.com"));
		store.addItemsWithAmountToStore("666666666",store.getCustomers(), new Customer("666666666","daniel", "e", "ashdod", "mail.gmail.com"));
		store.addItemsWithAmountToStore("777777777",store.getCustomers(), new Customer("777777777","aviv", "f", "ashdod", "mail.gmail.com"));
		
		HashMap<Vehicle,Integer> vehiclesInOrder=new HashMap<Vehicle,Integer>();
		vehiclesInOrder.put(c1,1);
		vehiclesInOrder.put(c2,1);
		vehiclesInOrder.put(c3,1);
		store.createOrder("111","Company1","111111111",vehiclesInOrder, 1,new Date("10/10/2020"));
		
		vehiclesInOrder.put(c1,2);
		vehiclesInOrder.put(c2,2);
		vehiclesInOrder.put(c3,3);
		store.createOrder("222","Company2","222222222",vehiclesInOrder, 2,new Date("11/11/2020"));

		vehiclesInOrder.clear();
		vehiclesInOrder.put(c4,1);
		vehiclesInOrder.put(c5,2);
		vehiclesInOrder.put(c6,3);
		store.createOrder("333","Company3","333333333",vehiclesInOrder, 2,new Date("12/12/2020"));

		vehiclesInOrder.clear();
		vehiclesInOrder.put(c6,1);
		vehiclesInOrder.put(c7,2);
		vehiclesInOrder.put(c8,3);
		store.createOrder("444","Company2","444444444",vehiclesInOrder, 2,new Date("01/01/2020"));
		
		vehiclesInOrder.clear();

		vehiclesInOrder.put(mc2,3);
		store.createOrder("555","Company2","444444444",vehiclesInOrder, 2,new Date("02/02/2020"));

		//methods And queries
		boolean b=false;
		System.out.println("check If Vehicle "+mc4+" Exist In System");
		b=store.checkIfVehicleExistInSystem(mc4);
		System.out.println("Result:"+b);
		store.PrintMostLowPriceVehicle();
		store.QryNumOfXMotorCycleColor(E_Color.Black);
		Collection<Vehicle> sortedCarsByPrice = store.sortCarsByPrice();
		System.out.println("Sorted Vehicles => By Prices");
		sortedCarsByPrice.forEach(System.out::println);
		
		ArrayList<Customer> sortedNewMap = (ArrayList<Customer>) store.qryCustomersWithNumberOfOrdersOrderedByNumberOfOrdersAsc();
		sortedNewMap.forEach((k) -> System.out.println("Customer : "+k.getIdNumber()+" ,"+k.getEmail()+" ,# of orders : "+k.getOrders().size()));	
		
		boolean c =store.validateCarNumberPlate("111-ab-123");
		System.out.println("validate Car Number Plate 111-ab-123: "+c);
		c =store.validateCarNumberPlate("111-aaa-123");
		System.out.println("validate Car Number Plate 111-aaa-123: "+c);
		c =store.validateCarNumberPlate("1abc");
		System.out.println("validate Car Number Plate 1abc: "+c);
		c =store.validateCarNumberPlate("1abcd");
		System.out.println("validate Car Number Plate 1abcd: "+c);
		c=store.checkModelInput("ab123$");
		System.out.println("Validate Model Input : "+c);
		c=store.checkModelInput("ab123!$$$");
		System.out.println("Validate Model Input : "+c);
		c=store.validatePhoneNumber("0520520521");
		System.out.println("Validate Phone Number : "+c);
		c=store.validatePhoneNumber("052-0524-052");
		System.out.println("Validate Phone Number : "+c);
		store.getVehicleSummaryOfSelectedModel(E_Model.BMW);

		System.out.println("Check allUniqueWords method");
		String s = store.allUniqueWords("1,2,3,roni,roni,hi,hello,world,java,c#,check,result");
		System.out.println(s);
		ArrayList<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		
		String  res = store.stringList(list);
		System.out.println(res);

	}
	
	
	
}
