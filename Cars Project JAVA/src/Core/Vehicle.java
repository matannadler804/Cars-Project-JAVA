package Core;

import java.util.Objects;
import Utilities.E_Model;
import Utilities.E_Color;

public abstract class Vehicle implements ICalc{

	protected E_Model model;

	protected String subModel;

	protected  E_Color color;

	protected String manufactureCountry;
	
	protected int manufactureYear;

	protected double length;

	protected double weight;

	protected int maxSeats;
	
	protected double price;

	public Vehicle(E_Model model, String subModel, E_Color color, String manufactureCountry, double length,
			double weight, int maxSeats,int manufactureYear,double price) {
		this.model = model;
		this.subModel = subModel;
		this.color = color;
		this.manufactureCountry = manufactureCountry;
		this.length = length;
		this.weight = weight;
		this.maxSeats = maxSeats;
		this.manufactureYear = manufactureYear;
		this.price=price;
	}

	public E_Model getModel() {
		return model;
	}

	public void setModel(E_Model model) {
		this.model = model;
	}

	
	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getSubModel() {
		return subModel;
	}

	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}

	public E_Color getColor() {
		return color;
	}

	public void setColor(E_Color color) {
		this.color = color;
	}

	public String getManufactureCountry() {
		return manufactureCountry;
	}

	public void setManufactureCountry(String manufactureCountry) {
		this.manufactureCountry = manufactureCountry;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	

	

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", subModel=" + subModel + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, subModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return model == other.model && Objects.equals(subModel, other.subModel);
	}

		
	

}
