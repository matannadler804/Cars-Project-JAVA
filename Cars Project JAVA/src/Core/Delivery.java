package Core;

import java.util.Date;

public class Delivery implements ICalc{

	private Order order;
	
	private TransportCompany  transportCompany;
	
	private Date deliveryDate;
	
	private int truckNumber;

	@Override
	public double calcCost() {
		return this.order.calcCost()/(this.truckNumber*100);
	}

	public Delivery(Order order, TransportCompany transportCompany, Date deliveryDate, int truckNumber) {
		this.order = order;
		this.transportCompany = transportCompany;
		this.deliveryDate = deliveryDate;
		this.truckNumber = truckNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public TransportCompany getTransportCompany() {
		return transportCompany;
	}

	public void setTransportCompany(TransportCompany transportCompany) {
		this.transportCompany = transportCompany;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(int truckNumber) {
		this.truckNumber = truckNumber;
	}

	
	
	
	
	
}
