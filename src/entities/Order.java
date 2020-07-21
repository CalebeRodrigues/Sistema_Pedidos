package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private List<OrdemItem> items = new ArrayList<>();
	
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
	
	public Double Total() {
		Double total = 0.0;
		for(OrdemItem x : items) {
			total += x.subTotal();
		}
		return total;
	}
}
