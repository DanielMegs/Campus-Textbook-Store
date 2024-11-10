package daniel;

import java.io.Serializable;

public class Textbook implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int sku;
    public String title;
    public double price;
    public int quantity;

    public Textbook(int sku, String title, double price, int quantity) {
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Title: " + title + ", Price: $" + price + ", Quantity: " + quantity;
    }
}