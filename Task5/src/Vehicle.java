abstract public class Vehicle
{
    private String registrationNumber;
    private String brand;
    private int year;

    public Vehicle(String registrationNumber, String brand, int year)
    {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.year = year;
    }
    abstract public int calculateRentalCost(int rentalPeriod);
    abstract public String printType();

    public String getRegNumber()
    {
        return this.registrationNumber;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public int getYear()
    {
        return this.year;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public String getBrand()
    {
        return this.brand;
    }
}
