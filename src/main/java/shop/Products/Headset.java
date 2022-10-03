package shop.Products;

public class Headset implements Product {

    //Variables
    private String productName;
    private String productImage;
    private String color;
    private double price;
    private int categoryID = 11;

    //Constructor
    public Headset(String productName, String productImage, String color, double price) {
        this.productName = productName;
        this.productImage = productImage;
        this.color = color;
        this.price = price;
    }

    //Getters
    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductImage() {
        return productImage;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCategoryID() {
        return categoryID;
    }

    //Setters    
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public void getAttributes() {
        System.out.println("Headset:{ProductName: " + getProductName() + ", ProductImage: " + getProductImage() + ", ProductColor: " + getColor() + ", ProductPrice: " + getPrice() + ", CategoryID: " + getCategoryID() + "}");
    }

}
