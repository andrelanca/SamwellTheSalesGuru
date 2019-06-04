package co.goinside.samwell.service;

import co.goinside.samwell.model.ClientOrder;

public interface ClientOrderServiceContract {

	void addOrder(ClientOrder clientOrder);
	ClientOrder getClient(int id);
	void removeOrder(int orderId);
	void submitOrderList();
	
}
