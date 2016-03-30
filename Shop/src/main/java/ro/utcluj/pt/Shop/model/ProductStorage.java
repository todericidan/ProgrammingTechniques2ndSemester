package ro.utcluj.pt.Shop.model;

public class ProductStorage {
	
	private int idProduct;
	private int quantity;
	
	public ProductStorage(int idProduct, int quantity)
	{
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	
	
	public int getIdProduct() {
		return idProduct;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	

	
}
