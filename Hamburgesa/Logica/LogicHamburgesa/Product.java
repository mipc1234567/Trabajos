package LogicHamburgesa;

public abstract class Product {

	private String name;
	

	public Product(String name) {
		this.name=name;
	}
	public Product() {
		this.name="";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
