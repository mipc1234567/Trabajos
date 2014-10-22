package LogicHamburgesa;

public class Hamburger {
	
	public static final byte DEFAULT_SIZE=50;
	private Product[] products;
	private byte size;
	
	

	public Hamburger(Product[] products) {
		this.products=products;
		this.size=DEFAULT_SIZE;
		
	}
	public Hamburger(byte size,Product[] product ) {
		super();
		this.products = product;
		this.size= size;
		
	}
	
	
	public Hamburger(byte size) {
		super();
		this.size = size;
		this.products=null;
	}
	public void addProducts(Product product){
		
		Product[] auxProduct = new Product[products.length+1];
		for (int i = 0; i < products.length; i++) {
			auxProduct[i] = products[i];
		}
		auxProduct[products.length] = product; 
		products = auxProduct;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public byte getSize() {
		return size;
	}

	public void setSize(byte size) {
		this.size = size;
	}
	

}
