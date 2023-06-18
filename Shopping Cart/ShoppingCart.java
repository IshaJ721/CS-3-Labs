import java.util.ArrayList;

public class ShoppingCart {
	ArrayList <ItemOrder> itemOrders; 
	public ShoppingCart()
	{
		itemOrders = new ArrayList<ItemOrder>();
	}
	public void add(ItemOrder newOrder)
	{
		if(itemOrders.contains(newOrder))
			itemOrders.remove(itemOrders.indexOf(newOrder));
		itemOrders.add(newOrder);
	}
	public double getTotal()
	{
		double total = 0;
		for(ItemOrder i : itemOrders)
		{
			total+=i.getPrice();
		}
		return total;
	}
}
