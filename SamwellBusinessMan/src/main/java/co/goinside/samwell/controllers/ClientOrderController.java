package co.goinside.samwell.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.goinside.samwell.models.ClientOrder;
import co.goinside.samwell.services.ClientOrderService;

@RestController
public class ClientOrderController {

	@Autowired
	private ClientOrderService clientOrderService;

	@RequestMapping(value = "/clients")
	public Map<Integer, ClientOrder> showClients() {
		return clientOrderService.showClients();
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public void addClient(@RequestParam(required = true) String bookTitle,
			@RequestParam(required = true) int bookQuantity, @RequestParam(required = true) double bookPrice,
			@RequestParam(required = true) String clientName, @RequestParam(required = true) int clientPhoneNum,
			@RequestParam(required = true) String clientAddress) {

		clientOrderService.addOrder(
				new ClientOrder(bookTitle, bookQuantity, bookPrice, clientName, clientPhoneNum, clientAddress)
		);

	}
	
	@RequestMapping(value = "/removeClient/{orderId}", method = RequestMethod.DELETE)
	public void removeClient(@PathVariable(required = true) int orderId) {
		clientOrderService.removeOrder(orderId);
	}
	
	@RequestMapping(value = "/findClientById/{id}")
	public ClientOrder findClientById(@PathVariable(required = true) int id ) {
		return clientOrderService.getClient(id);
	}
	
	@RequestMapping(value = "/submitOrderList")
	public void submitOrderList(HttpServletResponse httpResponse) {
		try {
			clientOrderService.submitOrderList();
			httpResponse.sendRedirect("/checkOrder");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/checkOrder")
	public Map<Integer, ClientOrder> checkOrder(HttpServletResponse httpResponse){
		return clientOrderService.getSuplierOrdersList();
		
	}
	
	
	
	
	
	
	
	
	
	
	// This method is just to populate my list with some clients
	@RequestMapping(value = "/populateListForTests")
	public void populateListForTests(HttpServletResponse httpResponse) {

		try {
			clientOrderService.addOrder(new ClientOrder("As Crônicas de Gelo e Fogo", 32, 24.99, "João", 961966990,
					"Rua João da Serra 7645-065 Vila Nova de Milfontes, Odemira"));
			clientOrderService.addOrder(new ClientOrder("Dom Quixote", 17, 15.99, "João", 923844777,
					"Rua Joaquim Almeida 7605-065 Sonega, Sines"));
			clientOrderService.addOrder(new ClientOrder("Guerra e Paz", 12, 4.99, "João", 935912546,
					"Rua Francisco José Vitorino 2765-065 Linda-a-Velha, Lisboa"));
			clientOrderService.addOrder(new ClientOrder("A Montanha Mágica", 5, 54.99, "João", 914878666,
					"Rua Arco do Cégo 8233-025 Saldanha, Lisboa"));

			httpResponse.sendRedirect("/clients");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// GETTERS & SETTERS

	public ClientOrderService getClientOrderService() {
		return clientOrderService;
	}
	
	
	public void setClientOrderService(ClientOrderService clientOrderService) {
		this.clientOrderService = clientOrderService;
	}

	
	
	
	
	
	

}
