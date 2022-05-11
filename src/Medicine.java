
public class Medicine {

	private String name;
	private String company;
	private int quantity;
	private int id;
	
	public Medicine(String name,String company,int quantity) {
		
		this.name=name;
		this.company=company;
		this.quantity=quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
