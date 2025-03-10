public class Country {
    private String countryName;
    private int year;
    private double ArableLandPercentage;
    private double ForestPercentage;
    private double CropPercentage;

    //Constructor for the objects of each country
    public Country(String countryName, int year, double ArableLandPercentage,
                   double ForestPercentage, double CropPercentage) {
        this.countryName = countryName;
        this.year = year;
        this.ArableLandPercentage = ArableLandPercentage;
        this.ForestPercentage = ForestPercentage;
        this.CropPercentage = CropPercentage;
    }

    //Getters for the objects items
    public String getCountryName() {
        return countryName;
    }

    public int getYear() {
        return year;
    }

    public double getArableLandPercentage() {
        return ArableLandPercentage;
    }

    public double getForestPercentage() {
        return ForestPercentage;
    }

    public double getCropPercentage() {
        return CropPercentage;
    }

    //Output when the string of an object is called.
    public String toString() {
        return  "Name: " + countryName +
                ", Year: " + year +
                ", Arable Land Percentage: " + ArableLandPercentage +
                ", Forests Percentage: " + ForestPercentage +
                ", Crop Percentage: " + CropPercentage;
    }
}