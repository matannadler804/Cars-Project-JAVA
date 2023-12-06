package Core;

import Utilities.E_Color;
import Utilities.E_Model;

public class Car extends Vehicle{

	private int wheelsAirVolume;

	public Car(E_Model model, String subModel, E_Color color, String manufactureCountry, double length, double weight,
			int maxSeats, int manufactureYear, int wheelsAirVolume,double price) {
		super(model, subModel, color, manufactureCountry, length, weight, maxSeats, manufactureYear,price);
		this.wheelsAirVolume = wheelsAirVolume;
	}

	@Override
	public double calcCost() {
		return price;
	}

	public int getWheelsAirVolume() {
		return wheelsAirVolume;
	}

	public void setWheelsAirVolume(int wheelsAirVolume) {
		this.wheelsAirVolume = wheelsAirVolume;
	}


	

}
