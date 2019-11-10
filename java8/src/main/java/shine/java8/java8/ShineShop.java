package shine.java8.java8;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
					.skip(1)
					.map(mapToProduct)
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
    	
        return productsMap
        		.values()
        		.stream()
        		.flatMap(l -> l.stream())
        		.collect(Collectors.toList());
    }

    /**
     * Display available products
     */
    public String displayProducts() {
        return "";  
    }
    /**
     * Add a product to the Basket
     */
    public void addProductToBasket(String productId) {
        // TODO Exercise 2a - Add products to the basket
        System.out.println("Add Product Not Implemented");
    }

    /**
     * Get the items in the basket
     */
    public List getBasketItems(){
        // TODO Exercise 2a - Add products to the basket
        System.out.println("Get Basket Items Not Implemented");
        return Collections.emptyList();
    }

    /**
     * Remove a product from the Basket
     */
    public void removeProductFromBasket(String productId) {
        // TODO Exercise 2b - Remove products from the basket
        System.out.println("Remove Product Not Implemented");
    }

    /**
     * Return the total value of the products in the basket
     */
    public BigDecimal getTotal() {
        // TODO Exercise 2c - Show the total value of products in the basket
        System.out.println("Get Total Not Implemented");
        return BigDecimal.ZERO;
    }


	public static void main(String[] args) {
		new ShineShop().loadProducts();
	}
	
	private static Function<String, Prodcut> mapToProduct = (line) -> {
		  String[] p = line.split(",");
		  return new Prodcut(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2]));
	};

}
