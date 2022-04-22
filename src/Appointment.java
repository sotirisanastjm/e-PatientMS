import java.sql.Date;

public class Appointment {
	
	private String fullname;
	private	double time;
	private int priority;
	private Date date;
	private int amka;
	public Appointment(String fullname,double time,int priority,Date date,int amka) {
		
		this.fullname=fullname;
		this.time=time;
		this.priority=priority;
		this.date=date;
		this.amka=amka;
		
	}

	
	
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getAmka() {
		return amka;
	}

	public void setAmka(int amka) {
		this.amka = amka;
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
