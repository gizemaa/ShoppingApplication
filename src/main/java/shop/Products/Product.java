package shop.Products;

public interface Product {    
    String getProductName();
    String getProductImage();
    String getColor();
    double getPrice();
    int getCategoryID();    
    void setColor(String color);
    void setProductImage(String color);
    void getAttributes();
}
