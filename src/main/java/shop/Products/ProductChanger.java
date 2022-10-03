package shop.Products;

/*
Abstract Class
 */
public abstract class ProductChanger implements Product {

    protected Product changedProduct;

    public ProductChanger(Product changedProduct) {
        this.changedProduct = changedProduct;
    }

    public void getAttributes() {
        changedProduct.getAttributes();
    }

    //Getters
    public String getProductName() {
        return changedProduct.getProductName();
    }

    public String getProductImage() {
        return changedProduct.getProductImage();
    }

    public String getColor() {
        return changedProduct.getColor();
    }

    public double getPrice() {
        return changedProduct.getPrice();
    }

    public int getCategoryID() {
        return changedProduct.getCategoryID();
    }

    //Setters
    public void setProductImage(String productImage) {
        changedProduct.setProductImage(productImage);
    }

    public void setColor(String color) {
        changedProduct.setColor(color);
    }

}
