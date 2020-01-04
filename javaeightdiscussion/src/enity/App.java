package enity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		Set<Vehicle> vehicles = new HashSet<Vehicle>();
		Set<DiscountedVehicle> discountedVehicles = new HashSet<DiscountedVehicle>();
		vehicles.add(new Vehicle(1, "Pulsar", 5, 10000));
		vehicles.add(new Vehicle(2, "KTM", 6, 10000));
		vehicles.add(new Vehicle(3, "Royal Enfield", 7, 10000));
		vehicles.add(new Vehicle(5, "Honda", 6, 10000));
		vehicles.add(new Vehicle(4, "Hero", 4, 10000));
		System.err.println("In Normal Vehicle");
		System.out.println(vehicles);
		System.out.println();
		System.out.println();
		discountedVehicles = vehicles.stream().map(m -> vehicleToDiscountedVehicle(m)).collect(Collectors.toSet());
		System.out.println("In discounted vehicle");
		System.err.println(discountedVehicles);
		int sum = discountedVehicles.stream().filter(a -> a.getDiscount() > 5).reduce(0,
				(total, us) -> total + us.getFinalPrice(), Integer::sum);
		System.err.println(sum);
	}

	public static DiscountedVehicle vehicleToDiscountedVehicle(Vehicle vehicle) {
		DiscountedVehicle discountedVehicle = new DiscountedVehicle();
		discountedVehicle.setVehicleId(vehicle.getVehicleId());
		discountedVehicle.setVehicleName(vehicle.getVehicleName());
		int age = vehicle.getRating();
		int discount = 0;
		if (age > 5) {
			discountedVehicle.setDiscount(10);
			discount = 10;
		} else {
			discountedVehicle.setDiscount(5);
			discount = 5;
		}
		int price = vehicle.getPrice();
		int finalPrice = price - (price * discount / 100);
		discountedVehicle.setFinalPrice(finalPrice);
		return discountedVehicle;
	}

}
