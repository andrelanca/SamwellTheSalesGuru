package co.goinside.samwell.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.goinside.samwell.dao.ClientOrderDao;
import co.goinside.samwell.model.ClientOrder;

@Service
public class ClientOrderService implements ClientOrderServiceContract{

	private ClientOrderDao clientOrderDao;

	public void addOrder(ClientOrder clientOrder) {
		clientOrderDao.add(clientOrder.getOrderID(), clientOrder);
	}

	public ClientOrder getClient(int id) {
		return clientOrderDao.getClientById(id);
	}

	public void removeOrder(int orderId) {
		clientOrderDao.remove(orderId);
	}

	public Map<Integer, ClientOrder> showClients() {
		return clientOrderDao.getSamwellOrdersList();
	}

	// Storing the list of Orders from Samwell, into the List of Orders of that
	// company who sells the books to Samwell
	// First send the list of orders, than clear Samwell list to be able to create a
	// new one
	public void submitOrderList() {
		clientOrderDao.submit(clientOrderDao.getSamwellOrdersList());
	}

	public Map<Integer, ClientOrder> getSuplierOrdersList() {
		return clientOrderDao.getSuplierOrdersList();
	}

	// Getters & Setters

	public ClientOrderDao getClientOrderDao() {
		return clientOrderDao;
	}

	@Autowired
	public void setClientOrderDao(ClientOrderDao clientOrderDao) {
		this.clientOrderDao = clientOrderDao;
	}

	
	
}
