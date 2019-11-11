package shine.java8.java8;

import java.util.LinkedList;
import java.util.List;

public class Cart {
	
	private List<Prodcut> product = new LinkedList<Prodcut>();

	public List<Prodcut> getProduct() {
		return product;
	}

	public void addProduct(Prodcut product) {
		this.product.add(product);
	}
	
	public void remove(Prodcut product) {
		this.product.remove(product);
	}
	
}
