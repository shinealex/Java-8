package shine.java8.java8;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author shine
 * 
 * This class shows how the Java stream helpful when we deal with collection of data.
 * Iteration, utility interfaces like Predicate, Optional, Consumer, Supplier,  etc..(java.util.function)
 *
 */
public class ShineShop {
	
	Map<Integer, List<Prodcut>> productsMap;
	Optional<Prodcut> productCheck = Optional.empty();
	Cart cart = new Cart();
    
    /**
     *This method reading data from CSV files and storing into List.
     *How easy to complete a business case.
     *Thanks to Java stream!! :-)
     * <b>Writing the below code in Java 7 requires more boilerplate codes </b>
     * 
     */
    public void loadProducts() {
    	try {
			
			productsMap = Files
					.lines(Paths.get("src/main/resources/product-data.csv"))
					.skip(1).map(mapToProduct)
					.collect(Collectors.groupingBy(Prodcut::getId));
    		
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }

    /**
     * List available products
     * Another wonderful feature in Stream - flatMap ( Aggregating all nested lists here...) 
     */
	public List<Prodcut> getProducts() {

		return productsMap.values().stream().flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

    /**
     * Display available products on Console 
     * 
     */
	public void displayProducts() {
		
		getProducts().forEach(
				e -> {
					System.out.println("Product Name : " + e.getName()
							+ " Product Price : " + e.getPrice());
				});
	}
	
    /**
     * Add a product to the Basket
     */
    public void addProductToBasket(Integer productId) {
      cart.addProduct(productsMap.get(productId).get(0));
    }

    /**
     * Get the items in the basket
     */
    public List<Prodcut> getBasketItems(){
        return cart.getProduct();
    }

    /**
     * Remove a product from the Basket
     */
    public void removeProductFromBasket(Integer productId) {
    	cart.remove(productsMap.get(productId).get(0));
    }

    /**
     * Return the total value of the products in the basket
     * 
     */
    public double getTotal() {
        return cart.getProduct().stream().mapToDouble(e -> e.getPrice()).sum();
    }
	
	private static Function<String, Prodcut> mapToProduct = (line) -> {
		  String[] p = line.split(",");
		  return new Prodcut(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2]));
	};

}
