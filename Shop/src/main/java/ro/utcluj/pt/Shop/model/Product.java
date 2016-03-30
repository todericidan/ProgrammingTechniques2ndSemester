package ro.utcluj.pt.Shop.model;

public class Product {
	private int idProduct;
	private String productName;
	private float price;
	
	public Product(int idProduct,String productName,float price)
	{
		this.idProduct = idProduct;
		this.productName = productName;
		this.price = price;
		
	}
	
	
	public int getIdProduct() {
		return idProduct;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public float getPrice() {
		return price;
	}
	

}
