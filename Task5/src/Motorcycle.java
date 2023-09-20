public class Motorcycle extends Vehicle{
    private int engineCapacity;

    public Motorcycle(String registrationNumber, String brand, int year, int engineCapacity)
    {
        super(registrationNumber, brand, year);
        this.engineCapacity = engineCapacity;
    }

    public int calculateRentalCost(int rentalPeriod)
    {
        return  rentalPeriod * 100;
    }

    public void setEngineCapacity(int engineCapacity)
    {
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }
    public String printType()
    {
        return "Motorcycle: " + this.getBrand();
    }
}
