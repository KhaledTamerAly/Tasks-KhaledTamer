public class Main
{
    public static void main(String[] args)
    {
        RentalSystem rentalSystem = new RentalSystem();

        rentalSystem.addVehicle("1000", "Audi", 2001, "Diesel");
        rentalSystem.addVehicle("100", "Harley", 2002, 1000);
        rentalSystem.addVehicle("10", "Bike", 2003);

        System.out.println("Before any renting");

        System.out.println("Available Cars: ");
        for(Vehicle vehicle: rentalSystem.getAvailableVehicles())
            System.out.println(vehicle.printType());

        System.out.println("---------------------------------");

        rentalSystem.rentVehicle("1000", 2);
        rentalSystem.rentVehicle("100", 2);
        rentalSystem.rentVehicle("100", 2);
        rentalSystem.rentVehicle("999", 2);

        System.out.println("After renting 2 cars");

        System.out.println("Available Cars: ");
        for(Vehicle vehicle: rentalSystem.getAvailableVehicles())
            System.out.println(vehicle.printType());

        System.out.println();
        System.out.println("Rented Cars: ");
        for(Vehicle vehicle: rentalSystem.getRentedVehicles())
            System.out.println(vehicle.printType());

        System.out.println("---------------------------------");

        rentalSystem.returnVehicle("100");
        rentalSystem.returnVehicle("100");
        rentalSystem.returnVehicle("999");

        System.out.println("After returning 1 car");

        System.out.println("Available Cars: ");
        for(Vehicle vehicle: rentalSystem.getAvailableVehicles())
            System.out.println(vehicle.printType());

        System.out.println();
        System.out.println("Rented Cars: ");
        for(Vehicle vehicle: rentalSystem.getRentedVehicles())
            System.out.println(vehicle.printType());

        System.out.println("---------------------------------");
        System.out.println("Total: " + rentalSystem.getTotalRentalRevenue());
    }
}
