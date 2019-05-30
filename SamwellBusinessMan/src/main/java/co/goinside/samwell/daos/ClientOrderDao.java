package co.goinside.samwell.daos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.goinside.samwell.models.ClientOrder;

@Repository
public class ClientOrderDao {
	
	private Map<Integer, ClientOrder> samwellOrdersList = new HashMap<>();
	private Map suplierOrdersList = new HashMap();
	
	
	public void add(int id, ClientOrder clientOrder) {
		samwellOrdersList.put(id, clientOrder);
	}
	
	public ClientOrder getClientById(int id) {
		ClientOrder clientOrder = samwellOrdersList.get(id);
		return clientOrder;
	}
	
	public void remove(int orderId) {
		samwellOrdersList.remove(orderId);
	}
	
	//Storing the list of Orders from Samwell, into the List of Orders of that company who sells the books to Samwell
	//First send the list of orders, than clear Samwell list to be able to populate a new order list
	public void submit(Map<Integer, ClientOrder> map) {
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

	public void setSamwellOrdersList(Map<Integer, ClientOrder> samwellOrdersList) {
		this.samwellOrdersList = samwellOrdersList;
	}

	public void setSuplierOrdersList(Map suplierOrdersList) {
		this.suplierOrdersList = suplierOrdersList;
	}

	
	
}
