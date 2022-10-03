package shop.Products;

/*
Factory Pattern
 */
public class ProductFactory {

    //Get product by specified type
    public Product getType(String productType, String productName, String ProductImage, String color, double price) {
        //Create object according to specified type
        if (productType == null) {
            return null;
        }
        if (productType.equalsIgnoreCase("TSHIRT")) {
            return new TShirt(productName, ProductImage, color, price);

        } else if (productType.equalsIgnoreCase("TROUSERS")) {
            return new Trousers(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("JACKET")) {
            return new Jacket(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("DRESS")) {
            return new Dress(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("KTROUSERS")) {
            return new KTrousers(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("SKIRT")) {
            return new Skirt(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("HEADSET")) {
            return new Headset(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("PHONE")) {
            return new Phone(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("TELEVISION")) {
            return new Television(productName, ProductImage, color, price);
        }
        else if (productType.equalsIgnoreCase("MAKEUP")) {
            return new Makeup(productName, ProductImage,color, price);
        }
        else if (productType.equalsIgnoreCase("SKINCARE")) {
            return new SkinCare(productName, ProductImage,color, price);
        }
        else if (productType.equalsIgnoreCase("HAIRCARE")) {
            return new HairCare(productName, ProductImage,color, price);
        }
        return null;
    }
}
