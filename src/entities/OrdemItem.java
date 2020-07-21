package entities;

import java.util.ArrayList;
import java.util.List;

public class OrdemItem {
	
	private Integer quantity;
	private Double price;
	private List<Product> product = new ArrayList<>();
	
	public OrdemItem() {
		
	}

	public OrdemItem(Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void addProduct(Product product) {
		this.product.add(product);
	}
	
	public void removeProduct(Product product) {
		this.product.remove(product);
	}
	
	public Double subTotal() {
		Double total = 0.0;
		for (Product x : product) {
			total += x.getPrice();
		}
		return total;
	}
}
