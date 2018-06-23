public class Stationery {

	private double price;
	private String location = "Malaysia";
	
	public Stationery() {
		
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double PricetoSet) {
		price = PricetoSet;
		
	}
	public void setLocation(String location) {
		this.location = location;
		
	}
	public String getLocation() {
		return location;
	}
}
