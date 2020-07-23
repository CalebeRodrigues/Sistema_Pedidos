package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private List<OrdemItem> items = new ArrayList<>();
	private List<Cliente> cliente = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrdemItem> getItems() {
		return items;
	}

	public void addItems(OrdemItem items) {
		this.items.add(items);
	}
	
	public void removeItems(OrdemItem items) {
		this.items.remove(items);
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void addCliente(Cliente cliente) {
		this.cliente.add(cliente);
	}
	
	public void removeCliente(Cliente cliente) {
		this.cliente.remove(cliente);
	}
	
	public String toString() {
		
		StringBuilder resumo = new StringBuilder();
		resumo.append("Momento pedido: " + formato.format(getMoment()));
		resumo.append("\nStatus pedido: " + getStatus());
		resumo.append("\nCliente: " + getCliente().toString());
		resumo.append("\nItem(s) pedido(s): ");
		resumo.append("\n" + getItems().toString());
		
		Double total = 0.0;
		
		for (OrdemItem x : items) {
			total += x.subTotal();
		}
		
		resumo.append("\nPreço total: R$" + String.format("%.2f", total));
		
		return resumo.toString();
	}
	
	public Double Total() {
		Double total = 0.0;
		for(OrdemItem x : items) {
			total += x.subTotal();
		}
		return total;
	}
}
