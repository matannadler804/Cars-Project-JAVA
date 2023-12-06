package Core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TransportCompany {

	private String companyNumber;

	private String companyName;

	private Set<Delivery> deliveries;

	public TransportCompany(String companyNumber, String companyName) {
		this.companyNumber = companyNumber;
		this.companyName = companyName;
		this.deliveries = new HashSet<Delivery>();
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}


	public boolean addDelivery(Delivery d) {
		if(d!=null) 
			return this.deliveries.add(d);
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportCompany other = (TransportCompany) obj;
		return Objects.equals(companyName, other.companyName);
	}
	
	public double calcAllDeliveries() {
		double sum = 0;
		for(Delivery d : this.deliveries) {
			sum+=d.calcCost();
		}
		return sum;
	}


	
}
