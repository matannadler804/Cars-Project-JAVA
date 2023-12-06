package Core;

import java.util.Date;
import java.util.Objects;

public class Worker {

	private int workerNum;
	
	private String fullName;
	
	private Date startWorkingDate;
	
	private String city;
	
	private String email;


	public Worker(int workerNum, String fullName, Date startWorkingDate, String city, String email) {
		this.workerNum = workerNum;
		this.fullName = fullName;
		this.startWorkingDate = startWorkingDate;
		this.city = city;
		this.email = email;
	}

	public int getWorkerNum() {
		return workerNum;
	}

	public void setWorkerNum(int workerNum) {
		this.workerNum = workerNum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getStartWorkingDate() {
		return startWorkingDate;
	}

	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(workerNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return workerNum == other.workerNum;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Worker [workerNum=" + workerNum + ", fullName=" + fullName + ", startWorkingDate=" + startWorkingDate
				+ ", city=" + city + ", email=" + email + "]";
	}
	
	
	
	
}
