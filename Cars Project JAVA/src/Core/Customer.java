package Core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer{

	private String idNumber;

	private String fName;

	private String lName;

	private String city;

	private String email;

	private Map<Order,Double> orders;

	public Customer(String idNumber, String fName, String lName, String city, String email) {
		this.idNumber = idNumber;
		this.fName = fName;
		this.lName = lName;
		this.city = city;
		this.email = email;
		this.orders = new HashMap<Order, Double>();
	}


	public Customer(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Map<Order, Double> getOrders() {
		return orders;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(idNumber, other.idNumber);
	}

	@Override
	public String toString() {
		return "Customer [id=" + idNumber + ", fName=" + fName + ", lName=" + lName + ", city=" + city + ", email=" + email
				+ "]";
	}


	public boolean addOrder(Order o) {
		if(o!=null) {
			if(!this.orders.containsKey(o)) {
				if(o.calcCost()>0) {
					this.orders.put(o, o.calcCost());
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}

}
