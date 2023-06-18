
public class Item {
	private String name;
	private int bulkQty;
	private double price, bulkPrice;
	public Item(String name, double price, int bulkQty, double bulkPrice)
	{
		if(price<0||bulkQty<0||bulkPrice<0)
			throw new IllegalArgumentException("error");
		this.name = name;
		this.bulkQty = bulkQty;
		this.price = price;
		this.bulkPrice = bulkPrice;
	}
	public Item(String name, double price)
	{
		this(name, price, 0,price);
	}
	public double priceFor(int quantity)
	{
		if(quantity<0)
		{
			throw new IllegalArgumentException();
		}
		if(quantity>=bulkQty)
		{
			return bulkPrice*quantity;
		}
		if(quantity<bulkQty||bulkQty==0)
			return price*quantity;
		else
			return 0;
	}
	@Override
	public boolean equals(Object obj)
	{
		return this.name.equals(((Item)obj).name);
	}
	public String toString()
	{
		if(this.bulkQty==0)
			return this.name+", "+price;
		else if(this.bulkPrice>0)
			return this.name+", "+price+" "+this.bulkQty+" for "+this.bulkPrice;
		else
			return this.name+", "+price;
			
	}

}
