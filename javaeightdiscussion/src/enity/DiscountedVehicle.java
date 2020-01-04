package enity;

public class DiscountedVehicle {

	private int vehicleId;
	private String vehicleName;
	private int discount;
	private int finalPrice;

	public DiscountedVehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiscountedVehicle(int vehicleId, String vehicleName, int discount, int finalPrice) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.discount = discount;
		this.finalPrice = finalPrice;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "DiscountedVehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", discount=" + discount
				+ ", finalPrice=" + finalPrice + "]";
	}

}
