import java.sql.Date;

public class Patient {

	
	private String name;
	private String surname;
	private String fathername;
	private String mothername;
	private double weight;
	private double height;
	private String sex;
	private String email;
	private int amka;
	private Date birth_date;
	private String blood;
	
	public Patient(String name,String surname,String fathername,String mothername,Date birth_date,double weight,double height,String sex,String email,int amka,String blood) {
		
		
		this.name=name;
		this.surname=surname;
		this.fathername=fathername;
		this.mothername=mothername;
		this.birth_date=birth_date;
		this.weight=weight;
		this.height=height;
		this.sex=sex;
		this.email=email;
		this.amka=amka;
		this.blood=blood;
		//1.12
		//6.7
		
		
		
	}

	

	public String getBloodType() {
		return blood;
	}



	public void setBloodType(String blood) {
		this.blood = blood;
	}



	public Date getBirth_date() {
		return birth_date;
	}



	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}



	public int getAmka() {
		return amka;
	}



	public void setAmka(int amka) {
		this.amka = amka;
	}



	public String getFathername() {
		return fathername;
	}


	public void setFathername(String fathername) {
		this.fathername = fathername;
	}


	public String getMothername() {
		return mothername;
	}


	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}
	
}
