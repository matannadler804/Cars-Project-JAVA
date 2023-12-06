package Init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import Core.Car;
import Core.Customer;
import Core.Delivery;
import Core.MotorCycle;
import Core.Order;
import Core.TransportCompany;
import Core.Vehicle;
import Utilities.E_Color;
import Utilities.E_Model;

public class Store {

	private String storeName;

	private Map<Vehicle,Integer> vehicles;

	private Map<String,TransportCompany> compenies;

	private Map<String ,Customer> customers;

	public Store(String storeName) {
		this.storeName=storeName;
		this.compenies = new HashMap<>();
		this.vehicles = new HashMap<Vehicle, Integer>();
		this.customers = new HashMap<String, Customer>();
	}

	public Map<Vehicle, Integer> getVehicles() {
		return vehicles;
	}


	public String getStoreName() {
		return storeName;
	}



	public Map<String, TransportCompany> getCompenies() {
		return compenies;
	}


	public Map<String, Customer> getCustomers() {
		return customers;
	}



	public <K,V> boolean addItemsWithAmountToStore(K item,Map<K,V> items,V amount) {
		if(items!=null && item!=null && !items.containsKey(item)) {
			items.put(item, amount);
			return true;
		}
		return false;	
	}


	public <K,V> boolean addItemsWithQniqueIdToStore(K id,Map<K,V> items,V Obj) {
		if(items!=null && Obj!=null && !items.containsKey(id)) {
			items.put(id, Obj);
			return true;
		}
		return false;	
	}


	public boolean createOrder(String orderNum,String company ,String  custId,HashMap<Vehicle,Integer> vehicles,int tructNumber,Date deliveryDate) {
		TransportCompany tc = this.compenies.get(company);
		Customer cust = this.customers.get(custId);
		Order o = null;
		Delivery delivery = null;
		if(tc!=null && cust!=null) {
			delivery=new Delivery(o, tc,deliveryDate, tructNumber);
			o = new Order(Integer.parseInt(orderNum), deliveryDate, cust, delivery);
			delivery.setOrder(o);
		}
		if(o!=null && tc!=null && cust!=null && vehicles!=null && vehicles.size()>0) {
			if(this.customers.containsKey(cust.getIdNumber()) && this.compenies.containsKey(tc.getCompanyName())) {
				o.setCustomer(cust);
				for(Map.Entry<Vehicle,Integer> entry : vehicles.entrySet()) {
					if(this.vehicles.containsKey(entry.getKey()) && this.vehicles.get(entry.getKey())>entry.getValue()) {
						o.addVehicle(entry.getKey(),entry.getValue());
						int numOfCurrVehicles = this.vehicles.get(entry.getKey())-entry.getValue();
						if(numOfCurrVehicles>0)
							this.vehicles.replace(entry.getKey(), numOfCurrVehicles);
					}
				}
				if(o.getVehiclesInOrder().size()>0) {
					this.customers.get(cust.getIdNumber()).addOrder(o);

					this.compenies.get(tc.getCompanyName()).addDelivery(delivery);
					return true;
				}
				return false;
			}
			return false;
		}
		return false;

	}



/**
 * checks if a vehicle already exists in the system by iterating through the keys of a map and returning true if any key is equal to the given vehicle.
 * @param v
 * @return
 */
	public boolean checkIfVehicleExistInSystem(Vehicle v)
	{
		 return vehicles.keySet().stream()
			        .anyMatch(vehicle -> vehicle.equals(v));
	}

/**
 *  adds a customer to the store by first checking if a customer with the same ID number already exists in the store's customer collection.
 * @param c
 * @return
 */
	public boolean addCustomerToStore(Customer c) {
		Customer cust = this.customers.get(c.getIdNumber());
		if (cust!=null)
			return false;
		this.customers.put(c.getIdNumber(),c);
		return true;
	}
/**
 * calculates and prints the information of the vehicle with the lowest price among all the vehicles in the collection
 */
	public void PrintMostLowPriceVehicle()
	{
		Vehicle cheapestVehicle = vehicles.keySet().stream()
	            .min((v1, v2) -> Double.compare(v1.calcCost(), v2.calcCost()))
	            .orElse(null);

	    System.out.println("Most Low Price Car:");
	    System.out.println(cheapestVehicle);
	}
/**
 * counts the number of motorcycles of a specific color (color) in the collection of vehicles
 * @param color
 */
	public void QryNumOfXMotorCycleColor(E_Color color)
	{
		long count = vehicles.keySet().stream()
		        .filter(vehicle -> vehicle instanceof MotorCycle) 
		        .filter(vehicle -> vehicle.getColor() == color)
		        .count();

		    System.out.println("Number Of " + color + " Motorcycles In Map OF vehicles: " + count);
	}

/**
 * sorts the cars in the collection of vehicles by their price in ascending order and returns a collection of the sorted cars
 * @return
 */
	public Collection<Vehicle> sortCarsByPrice()
	{
		return vehicles.keySet().stream()
	            .filter(vehicle -> vehicle instanceof Car)
	            .sorted((v1, v2) -> Double.compare(v1.calcCost(), v2.calcCost()))
	            .collect(Collectors.toList());
	}
/**
 * retrieves a summary of vehicles based on a selected model
 * @param e
 */
	public void getVehicleSummaryOfSelectedModel(E_Model e) 
	{
		List<Vehicle> vehiclesOfModel = vehicles.keySet().stream()
		        .filter(vehicle -> vehicle.getModel() == e)
		        .collect(Collectors.toList());

		    int quantity = vehiclesOfModel.size();

		    if (quantity > 0) {
		        double averagePrice = vehiclesOfModel.stream()
		            .mapToDouble(vehicle -> vehicle.calcCost())
		            .average()
		            .orElse(0.0);

		        double maxPrice = vehiclesOfModel.stream()
		            .mapToDouble(vehicle -> vehicle.calcCost())
		            .max()
		            .orElse(0.0);

		        System.out.println("Summary of " + e + " vehicles:");
		        System.out.println("Average price: " + averagePrice);
		        System.out.println("Quantity: " + quantity);
		        System.out.println("Most expensive price: " + maxPrice);
		    } else {
		        System.out.println("No vehicles of model " + e + " found in the system.");
		    }
		
	}

/**
 *  returns a sorted collection of customers based on the number of orders they have, in ascending order.
 * @return
 */
	public Collection<Customer>  qryCustomersWithNumberOfOrdersOrderedByNumberOfOrdersAsc()
	{
		return customers.values().stream()
	            .sorted((c1, c2) -> Integer.compare(c1.getOrders().size(), c2.getOrders().size()))
	            .collect(Collectors.toList());
	
	}


	/**
	 * validates whether a given phone number string matches the format "05X-XXXX-XXX", where X represents a digit
	 * @param phone
	 * @return
	 */
	public boolean validatePhoneNumber( String phone )
	{
		String regex = "^05\\d{1}-\\d{4}-\\d{3}$";
	    return phone.matches(regex);
	} 


	/**
	 * validates whether a given car number plate string matches either the format "XXX-XX-XXX" where X represents a digit or the format "[1-4]XXXX" where X represents a lowercase letter.
	 * @param s
	 * @return
	 */
	public boolean validateCarNumberPlate(String s)
	{
		String regex = "^(\\d{3}-[a-z]{2}-\\d{3}|[1-4][a-z]{4})$";
	    return s.matches(regex);
	}

	/**
	 * checks whether a given string follows the pattern of starting with 1 to 3 lowercase letters, followed by 1 to 4 digits, and ends with either '$', '#', or '%'.
	 * @param s
	 * @return
	 */
	public boolean checkModelInput(String s)
	{
		String regex = "^[a-z]{1,3}\\d{1,4}[$#%]$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(s);
	    return matcher.matches();
		
	}
/**
 * takes a string as input, splits it into individual words using comma as the delimiter, removes duplicates, and returns a string containing all the unique words separated by hyphens ("-").
 * @param s
 * @return
 */
	public String allUniqueWords (String s)
	{
		String[] words = s.split(",");
	    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
	    StringBuilder result = new StringBuilder();

	    for (String word : uniqueWords) {
	    	result.append(word).append("-");
	    }
	    return result.toString();
		
	}
/**
 * takes an ArrayList of strings as input, iterates over each string in the list, appends it to a StringBuilder object, and adds a "*" if the length of the string is even or a "-" if the length is odd, and finally returns the resulting string.
 * @param list
 * @return
 */
	public String stringList(ArrayList<String> list)
	{
		StringBuilder result = new StringBuilder();

	    list.stream()
	        .forEach(str -> {
	            result.append(str);
	            result.append(str.length() % 2 == 0 ? "*" : "-");
	        });

	    return result.toString();
	
	}


}
