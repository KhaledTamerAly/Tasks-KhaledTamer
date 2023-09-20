import java.util.ArrayList;
public class RentalSystem
{
    private ArrayList<Vehicle> rentedVehicles;
    private ArrayList<Vehicle> availableVehicles;
    private int totalRevnue;

    public RentalSystem()
    {
        this.rentedVehicles = new ArrayList<Vehicle>();
        this.availableVehicles = new ArrayList<Vehicle>();
        this.totalRevnue = 0;
    }

    //Not needed to create 3 different methods
    //Just trying method overloading
    public void addVehicle(String registrationNumber, String brand, int year, String fuelType)
    {
        Vehicle vehicle = new Car(registrationNumber, brand, year, fuelType);
        this.availableVehicles.add(vehicle);
    }
    public void addVehicle(String registrationNumber, String brand, int year, int engineCapacity)
    {
        Vehicle vehicle = new Motorcycle(registrationNumber, brand, year, engineCapacity);
        this.availableVehicles.add(vehicle);
    }
    public void addVehicle(String registrationNumber, String brand, int year)
    {
        Vehicle vehicle = new Bicycle(registrationNumber, brand, year);
        this.availableVehicles.add(vehicle);
    }
    public void rentVehicle(String registrationNumber, int rentalPeriod)
    {
        Vehicle removedVehicle = null;
        for(Vehicle vehicle : this.availableVehicles)
        {
            if(registrationNumber.equals(vehicle.getRegNumber()))
            {
                this.totalRevnue += vehicle.calculateRentalCost(rentalPeriod);
                this.rentedVehicles.add(vehicle);
                removedVehicle = vehicle;
                if(vehicle instanceof Car)
                    System.out.println("Fuel Type of Car with Reg Number " + vehicle.getRegNumber()+ " is: "+ ((Car) vehicle).getFuelType());
                else if(vehicle instanceof Motorcycle)
                    System.out.println("Engine Capacity of Motorcyle with Reg Number " + vehicle.getRegNumber()+ " is: "+ ((Motorcycle) vehicle).getEngineCapacity());
                break;
            }
        }
        if(removedVehicle != null)
            this.availableVehicles.remove(removedVehicle);
    }

    public void returnVehicle(String registrationNumber)
    {
        Vehicle removedVehicle = null;
        for(Vehicle vehicle : this.rentedVehicles)
        {
            if(registrationNumber.equals(vehicle.getRegNumber()))
            {
                this.availableVehicles.add(vehicle);
                removedVehicle = vehicle;
                break;
            }
        }
        if(removedVehicle != null)
            this.rentedVehicles.remove(removedVehicle);
    }
    public int getTotalRentalRevenue()
    {
       return this.totalRevnue;
    }

    public ArrayList<Vehicle> getRentedVehicles()
    {
        return this.rentedVehicles;
    }
    public ArrayList<Vehicle> getAvailableVehicles()
    {
        return this.availableVehicles;
    }
}
