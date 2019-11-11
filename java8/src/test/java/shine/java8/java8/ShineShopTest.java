package shine.java8.java8;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShineShopTest {
	
	private ShineShop shineshop;
	
	 @Before
	    public void setup() {
	        this.shineshop = new ShineShop();
	        this.shineshop.loadProducts();
	    }
	 
	   @Test
	    public void getProducts() {
	        assertThat("All products have been loaded.", shineshop.getProducts().size(), is(equalTo(8)));
	    }
	   
	   @Test
	    public void addProductToBasket() {
		   shineshop.addProductToBasket(1);
		   shineshop.addProductToBasket(5);
	       assertThat("Products have been added to a basket.", shineshop.getBasketItems().size(), is(equalTo(2)));
	    }
	   
	   @Test
	    public void removeProductFromBasket() {
		   shineshop.addProductToBasket(1);
		   shineshop.addProductToBasket(5);
		   shineshop.removeProductFromBasket(1);
		   shineshop.addProductToBasket(7);
	      assertThat("Products have been removed from a basket.", shineshop.getBasketItems().size(), is(equalTo(2)));
	    }
	   
	   @Test
	    public void getTotal() {
	        shineshop.addProductToBasket(1);
	        shineshop.addProductToBasket(2);
	        shineshop.addProductToBasket(3);
	        shineshop.addProductToBasket(4);
	        shineshop.addProductToBasket(5);
	        shineshop.addProductToBasket(6);
	        shineshop.addProductToBasket(7);
	        assertThat("Total value of basket has been calculated.", shineshop.getTotal(), is(equalTo(1406.02)));
	    } 
}
