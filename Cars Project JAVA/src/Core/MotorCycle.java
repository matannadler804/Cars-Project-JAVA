package Core;


import Utilities.E_Color;
import Utilities.E_Model;

public class MotorCycle extends Vehicle{
	
	private boolean isDirtBike;

	public MotorCycle(E_Model model, String subModel, E_Color color, String manufactureCountry, double length,
			double weight, int maxSeats, boolean isDirtBike,int manufactureYear,double price) {
		super(model, subModel, color, manufactureCountry, length, weight, maxSeats, manufactureYear,price);
		this.isDirtBike = isDirtBike;
	}

	public boolean isDirtBike() {
		return isDirtBike;
	}

	public void setDirtBike(boolean isDirtBike) {
		this.isDirtBike = isDirtBike;
	}

	@Override
	public double calcCost() {
		return price;
	}

	@Override
	public String toString() {
		return "MotorCycle [getModel()=" + getModel() + ", getSubModel()=" + getSubModel() + "]";
	}
	
	

	
}
