package co.goinside.samwell.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.goinside.samwell.model.ClientOrder;
import co.goinside.samwell.service.ClientOrderService;

@RestController
public class ClientOrderController {

	private ClientOrderService clientOrderService;

	@CrossOrigin
	@RequestMapping(value = "/clients")
	public Map<Integer, ClientOrder> showClients() {
		return clientOrderService.showClients();
	}

	@CrossOrigin
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public void addClient(@RequestParam(required = true) String bookTitle,
			@RequestParam(required = true) int bookQuantity, @RequestParam(required = true) double bookPrice,
			@RequestParam(required = true) String clientName, @RequestParam(required = true) int clientPhoneNum,
			@RequestParam(required = true) String clientAddress) {

		clientOrderService.addOrder(
				new ClientOrder(bookTitle, bookQuantity, bookPrice, clientName, clientPhoneNum, clientAddress));

	}

	@CrossOrigin
	@RequestMapping(value = "/removeClient/{orderId}", method = RequestMethod.DELETE)
	public void removeClient(@PathVariable(required = true) int orderId) {
		clientOrderService.removeOrder(orderId);
	}

	@CrossOrigin
	@RequestMapping(value = "/findClientById/{id}")
	public ClientOrder findClientById(@PathVariable(required = true) int id) {
		return clientOrderService.getClient(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/submitOrderList")
	public void submitOrderList(HttpServletResponse httpResponse) {
		clientOrderService.submitOrderList();

	}

	@CrossOrigin
	@RequestMapping(value = "/checkOrder")
	public Map<Integer, ClientOrder> checkOrder() {
		return clientOrderService.getSuplierOrdersList();
	}

	// This method is just to populate my list with some clients
	@CrossOrigin
	@RequestMapping(value = "/populateListForTests")
	public void populateListForTests() {
		clientOrderService.addOrder(new ClientOrder("As Crônicas de Gelo e Fogo", 32, 24.99, "João", 961966990,
				"Rua João da Serra 7645-065 Vila Nova de Milfontes, Odemira"));
		clientOrderService.addOrder(new ClientOrder("Dom Quixote", 17, 15.99, "João", 923844777,
				"Rua Joaquim Almeida 7605-065 Sonega, Sines"));
		clientOrderService.addOrder(new ClientOrder("Guerra e Paz", 12, 4.99, "João", 935912546,
				"Rua Francisco José Vitorino 2765-065 Linda-a-Velha, Lisboa"));
		clientOrderService.addOrder(new ClientOrder("A Montanha Mágica", 5, 54.99, "João", 914878666,
				"Rua Arco do Cégo 8233-025 Saldanha, Lisboa"));
	}

	// Getters & Setters
	public ClientOrderService getClientOrderService() {
		return clientOrderService;
	}

	@Autowired
	public void setClientOrderService(ClientOrderService clientOrderService) {
		this.clientOrderService = clientOrderService;
	}

}
