
public class Appointment {
	
	private String fullname;
	private	double time;
	private int priority;
	private int day;
	private int month;
	private int year;
	
	public Appointment(String fullname,double time,int priority) {
		
		this.fullname=fullname;
		this.time=time;
		this.priority=priority;
		this.day=day;
		this.month=month;
		this.year=year;
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
