package co.goinside.samwell.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import co.goinside.samwell.models.ClientOrder;

@Service
public class ClientOrderService {
	
	
	private Map<Integer, ClientOrder> samwellOrdersList = new HashMap<>();
	private Map suplierOrdersList = new HashMap();
	
	public void addOrder(ClientOrder clientOrder) {
		samwellOrdersList.put(clientOrder.getOrderID(), clientOrder);
	}
	
	public ClientOrder getClientNameById(int id) {
		ClientOrder clientOrder = samwellOrdersList.get(id);
		return clientOrder;
	}

	public void removeOrder(int orderId) {
		samwellOrdersList.remove(orderId);
	}
	
	
	

	//Storing the list of Orders from Samwell, into the List of Orders of that company who sells the books to Samwell
	//First send the list of orders, than clear Samwell list to be able to create a new one
	public void submitOrderList(Map<Integer, ClientOrder> map) {
		suplierOrdersList.putAll(map);
		map.clear();
	}

	
	
	
	
	//GETTERS & SETTERS
	public Map getSuplierOrdersList() {
		return suplierOrdersList;
	}

	public Map<Integer, ClientOrder> getSamwellOrdersList() {
		return samwellOrdersList;
	}
	
	
	
	
}
