public class Car extends Vehicle
{
    private String fuelType;

    public Car(String registrationNumber, String brand, int year, String fuelType) {
        super(registrationNumber, brand, year);
        this.fuelType = fuelType;
    }

    public int calculateRentalCost(int rentalPeriod)
    {
        return  rentalPeriod * 1000;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
    public String getFuelType()
    {
        return this.fuelType;
    }
    public String printType()
    {
        return "Car: " + this.getBrand();
    }
}
