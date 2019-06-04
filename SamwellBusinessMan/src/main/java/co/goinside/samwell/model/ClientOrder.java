package co.goinside.samwell.model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientOrder {
	
	
	private static final AtomicInteger count = new AtomicInteger();
	private Integer orderID;
	
	//Book Details
	private String bookTitle;
	private int bookQuantity;
	private double bookPrice;
	
	//Client Details
	private String clientName;
	private int clientPhoneNum;
	private String clientAddress;
	
	public ClientOrder(){}
	public ClientOrder(String bookTitle, int bookQuantity, double bookPrice, String clientName, int clientPhoneNum, String clientAddress) {
		
		orderID = count.incrementAndGet();
		
		this.bookTitle = bookTitle;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		
		this.clientName = clientName;
		this.clientPhoneNum = clientPhoneNum;
		this.clientAddress = clientAddress;
		
	}


	
	//Getters & Setters
	
	public Integer getOrderID() {
		return orderID;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public int getBookQuantity() {
		return bookQuantity;
	}


	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}


	public double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public int getClientPhoneNum() {
		return clientPhoneNum;
	}


	public void setClientPhoneNum(int clientPhoneNum) {
		this.clientPhoneNum = clientPhoneNum;
	}


	public String getClientAddress() {
		return clientAddress;
	}


	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}


	public static AtomicInteger getCount() {
		return count;
	}


	//toString
	
	@Override
	public String toString() {
		return "ClientOrder [orderID=" + orderID + ", bookTitle=" + bookTitle + ", bookQuantity=" + bookQuantity
				+ ", bookPrice=" + bookPrice + ", clientName=" + clientName + ", clientPhoneNum=" + clientPhoneNum
				+ ", clientAddress=" + clientAddress + "]";
	}
	
	
	
	
	
	
	
		
	
}
