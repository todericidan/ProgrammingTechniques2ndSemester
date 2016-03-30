package ro.utcluj.pt.Shop.model;

import java.util.Date;

public class Order {
	
	private int idPerson;
	private int idProduct;
	private int quantity;
	private String submissionDate;
	private String deliveryDate;
	
	public Order(int idPerson,int idProduct,int quantity,String date,String delivery)
	{
		this.idPerson = idPerson;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.submissionDate = date;
		this.deliveryDate = delivery;
		
	}
	
	
	public int getIdPerson() {
		return idPerson;
	}
	
	public int getIdProduct() {
		return idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}
	
	public String getDeliveryDate(){
		return deliveryDate;
	}
	
}

