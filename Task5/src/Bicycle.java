public class Bicycle extends Vehicle{

    public Bicycle(String registrationNumber, String brand, int year)
    {
        super(registrationNumber, brand, year);
    }

    public int calculateRentalCost(int rentalPeriod)
    {
        return  rentalPeriod * 10;
    }
    public String printType()
    {
        return "Bicyle: " + this.getBrand();
    }
}
