package shine.java8.java8;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
	        assertThat("All products have been loaded.", shineshop.getProducts().size(), is(equalTo(7)));
	    }

}
