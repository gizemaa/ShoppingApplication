package shop.Products;

/*
Decorator Pattern
 */
public class ColorChanger extends ProductChanger {

    //Variables
    private String color;

    //Constructor
    public ColorChanger(Product changedProduct, String color) {
        super(changedProduct);
        this.color = color;
    }

    @Override
    public void getAttributes() {
        this.setColor(changedProduct);
        changedProduct.getAttributes();
    }

    private void setColor(Product changedProduct) {
        //Change the product color for the specified color
        changedProduct.setColor(color);
        //Gets old image text        
        String text = changedProduct.getProductImage();
        //Find index of '-'
        int i = text.indexOf("-");
        //Delete color text from image text
        text = text.substring(i, text.length());
        //Add the new color text to the image text
        text = color.toLowerCase().replace("ı", "i") + text;
        //Change the product image text for the specified color
        changedProduct.setProductImage(text);
    }

}
