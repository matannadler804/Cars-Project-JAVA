package Core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Order implements ICalc{

	private int orderId;

	private Date orderDate;

	private Customer customer;

	private Map<Vehicle,Integer> vehiclesInOrder;

	private Delivery delivery;
	
	public Order(int orderId, Date orderDate, Customer customer,Delivery delivery) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		this.vehiclesInOrder = new HashMap<Vehicle, Integer>();
		this.delivery = delivery;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderId == other.orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer.getIdNumber() + "]";
	}

	@Override
	public double calcCost() {
		double price=0;
		for(Entry<Vehicle,Integer> entry : this.vehiclesInOrder.entrySet()) {
			price += entry.getKey().calcCost()*entry.getValue();
		}
		return price;
		
	}

	public Map<Vehicle, Integer> getVehiclesInOrder() {
		return vehiclesInOrder;
	}

	public void setVehiclesInOrder(Map<Vehicle, Integer> vehiclesInOrder) {
		this.vehiclesInOrder = vehiclesInOrder;
	}

	
	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public boolean addVehicle(Vehicle v,int amount) {
		if(v!=null) {
			if(this.vehiclesInOrder.containsKey(v)) {
				this.vehiclesInOrder.replace(v,amount);
				return true;
			}
			else {
				this.vehiclesInOrder.put(v,amount);
				return true;
			}
		}
		return false;
	}
}


