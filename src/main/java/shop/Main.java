package shop;

import shop.Products.*;
import Database.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import shop.Categories.Category;

public class Main {

    //Variables
    private static DatabaseSelect databaseSelect;
    private static MainGUI gui = new MainGUI();
    DefaultTableModel model;
    private static ArrayList<Product> tshirts = new ArrayList<>();
    private static ArrayList<Product> trousers = new ArrayList<>();
    private static ArrayList<Product> jackets = new ArrayList<>();
    private static ArrayList<Product> dresses = new ArrayList<>();
    private static ArrayList<Product> wtrousers = new ArrayList<>();
    private static ArrayList<Product> skirts = new ArrayList<>();
    private static ArrayList<Product> headsets = new ArrayList<>();
    private static ArrayList<Product> phones = new ArrayList<>();
    private static ArrayList<Product> televisions = new ArrayList<>();
    private static ArrayList<Product> makeup = new ArrayList<>();
    private static ArrayList<Product> skincare = new ArrayList<>();
    private static ArrayList<Product> haircare = new ArrayList<>();
    public ArrayList<Product> cart = new ArrayList<Product>();

    public static void main(String[] args) {
        /*
        Show the main form gui
         */
        gui.setVisible(true);
        /*
        Creating product table and add products
         */
        //T-Shirt
        ProductFactory factory = new ProductFactory();
        Product t1 = factory.getType("TSHIRT", "Pierre Cardin T-Shirt", "white-tshirt", "WHITE", 56.21);
        Product t2 = new ColorChanger(t1, "BLUE");
        Product t3 = new ColorChanger(t1, "BLACK");
        //Trousers
        Product ts1 = factory.getType("TROUSERS", "Pierre Cardin Trousers", "black-trousers", "BLACK", 159.95);
        Product ts2 = new ColorChanger(ts1, "GREY");
        Product ts3 = new ColorChanger(ts1, "BLUE");
        //Jacket
        Product j1 = factory.getType("JACKET", "Brown Jacket", "brown-jacket", "BROWN", 543.99);
        Product j2 = factory.getType("JACKET", "Black Jacket", "black-jacket", "BLACK", 597);
        Product j3 = factory.getType("JACKET", "Camel Jacket", "camel-jacket", "CAMEL", 399);
        //Dress
        Product d1 = factory.getType("DRESS", "Green Dress", "green-dress", "GREEN", 495);
        Product d2 = factory.getType("DRESS", "Beige Dress", "beige-dress", "BEIGE", 669.99);
        Product d3 = factory.getType("DRESS", "Black Dress", "black-dress", "BLACK", 189);
        //Trousers
        Product ts4 = factory.getType("KTROUSERS", "White Trousers", "white-trousers", "WHITE", 187.99);
        Product ts5 = factory.getType("KTROUSERS", "Salmon Trousers", "salmon-trousers", "SALMON", 194.99);
        Product ts6 = factory.getType("KTROUSERS", "Ecru Trousers", "ecru-trousers", "ECRU", 259.99);
        //Skirt
        Product s1 = factory.getType("SKIRT", "Blue Skirt", "blue-skirt", "BLUE", 79.99);
        Product s2 = factory.getType("SKIRT", "Green Skirt", "green-skirt", "GREEN", 199);
        Product s3 = factory.getType("SKIRT", "Beige Skirt", "beige-skirt", "BEIGE", 299.99);
        //headset
        Product hs1 = factory.getType("HEADSET", "JBL Headset", "pink-headset", "PINK", 383.99);
        Product hs2 = new ColorChanger(hs1, "BLUE");
        Product hs3 = new ColorChanger(hs1, "WHITE");
        //Phone
        Product p1 = factory.getType("PHONE", "Samsung Smart Phone", "black-phone", "BLACK", 12999);
        Product p2 = factory.getType("PHONE", "Huawei Smart Phone", "silver-phone", "SILVER", 10799.90);
        Product p3 = factory.getType("PHONE", "Xiaomi Smart Phonet", "purple-phone", "PURPLE", 3599.90);
        //Television
        Product tl1 = factory.getType("TELEVISION", "LG TV", "Lblack-television", "BLACK", 4999);
        Product tl2 = factory.getType("TELEVISION", "Vestel TV", "Vblack-television", "BLACK", 3299);
        Product tl3 = factory.getType("TELEVISION", "Philips TV", "white-television", "WHITE", 4399);
        //Makeup
        Product m1 = factory.getType("MAKEUP", "Rimmel Maskara", "rimmel-makeup", "", 27.49);
        Product m2 = factory.getType("MAKEUP", "Maybelline Eraser", "kapatici-makeup", "", 48.90);
        Product m3 = factory.getType("MAKEUP", "Avon Lipstick", "ruj-makeup", "", 23.85);
        //Skin Care
        Product sc1 = factory.getType("SKINCARE", "Skin Cleaning Brush", "firca-skincare", "", 12.23);
        Product sc2 = factory.getType("SKINCARE", "Skin Care Cream", "ciltkrem-skincare", "", 49.95);
        Product sc3 = factory.getType("SKINCARE", "Cleansing Gel", "akne-skincare", "", 89.01);
        //Hair Care
        Product hc1 = factory.getType("HAIRCARE", "Bed Head Waver", "masa-haircare", "", 193);
        Product hc2 = factory.getType("HAIRCARE", "Remington Hair Dryer", "dryer-haircare", "", 137.78);
        Product hc3 = factory.getType("HAIRCARE", "Hair Dryer And Volumizer", "brush-haircare", "", 324.21);
        //Database create and add queries with builder pattern
        databaseSelect = new DatabaseSelect.Builder().createTable("products").addToTable("products", t1).addToTable("products", t2).addToTable("products", t3).addToTable("products", ts1).addToTable("products", ts2).addToTable("products", ts3)
                .addToTable("products", j1).addToTable("products", j2).addToTable("products", j3).addToTable("products", d1).addToTable("products", d2).addToTable("products", d3)
                .addToTable("products", ts4).addToTable("products", ts5).addToTable("products", ts6).addToTable("products", s1).addToTable("products", s2).addToTable("products", s3)
                .addToTable("products", hs1).addToTable("products", hs2).addToTable("products", hs3).addToTable("products", p1).addToTable("products", p2).addToTable("products", p3)
                .addToTable("products", tl1).addToTable("products", tl2).addToTable("products", tl3).addToTable("products", m1).addToTable("products", m2).addToTable("products", m3)
                .addToTable("products", sc1).addToTable("products", sc2).addToTable("products", sc3).addToTable("products", hc1).addToTable("products", hc2).addToTable("products", hc3).build();
        //Select products from 'products' table
        databaseSelect = new DatabaseSelect.Builder().selectFromTable("products").build();

        try {
            //Get results from database
            ResultSet rs = databaseSelect.getResult();
            ProductFactory productFactory = new ProductFactory();
            while (rs.next()) {
                //Create variables with read values from database
                String productName = rs.getString("ProductName");
                String productImage = rs.getString("ProductImage");
                String color = rs.getString("Color");
                double price = rs.getDouble("Price");
                int categoryID = rs.getInt("CategoryID");
                //Add products to suitable list according to category id
                Product p;
                if (categoryID == 4) {
                    p = productFactory.getType("TSHIRT", productName, productImage, color, price);
                    tshirts.add(p);
                } else if (categoryID == 5) {
                    p = productFactory.getType("TROUSERS", productName, productImage, color, price);
                    trousers.add(p);
                } else if (categoryID == 6) {
                    p = productFactory.getType("JACKET", productName, productImage, color, price);
                    jackets.add(p);
                } else if (categoryID == 7) {
                    p = productFactory.getType("DRESS", productName, productImage, color, price);
                    dresses.add(p);
                } else if (categoryID == 8) {
                    p = productFactory.getType("KTROUSERS", productName, productImage, color, price);
                    wtrousers.add(p);
                } else if (categoryID == 9) {
                    p = productFactory.getType("SKIRT", productName, productImage, color, price);
                    skirts.add(p);
                } else if (categoryID == 11) {
                    p = productFactory.getType("HEADSET", productName, productImage, color, price);
                    headsets.add(p);
                } else if (categoryID == 12) {
                    p = productFactory.getType("PHONE", productName, productImage, color, price);
                    phones.add(p);
                } else if (categoryID == 13) {
                    p = productFactory.getType("TELEVISION", productName, productImage, color, price);
                    televisions.add(p);
                } else if (categoryID == 15) {
                    p = productFactory.getType("MAKEUP", productName, productImage, color, price);
                    makeup.add(p);
                } else if (categoryID == 16) {
                    p = productFactory.getType("SKINCARE", productName, productImage, color, price);
                    skincare.add(p);
                } else if (categoryID == 17) {
                    p = productFactory.getType("HAIRCARE", productName, productImage, color, price);
                    haircare.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //Categroies
        Category all = new Category(0, "All");
        //Main categories
        Category fashion = new Category(1, "Fashion");
        Category electronics = new Category(10, "Electronics");
        Category beautyAndPersonalCare = new Category(14, "Beauty and Personal Care");
        //Sub categories of first main category
        Category men = new Category(2, "Men");
        Category women = new Category(3, "Women");
        //Sub categories of first main category's sub category
        Category tshirt = new Category(4, "T-Shirt");
        Category trousers = new Category(5, "Trousers");
        Category jacket = new Category(6, "Jacket");
        Category dress = new Category(7, "Dress");
        Category ktrousers = new Category(8, "W-Trousers");
        Category skirt = new Category(9, "Skirt");
        //Sub categories of second main category
        Category headset = new Category(11, "Headset");
        Category phone = new Category(12, "Phone");
        Category television = new Category(13, "Television");
        //Sub categories of third main category
        Category makeup = new Category(15, "Makeup");
        Category skinCare = new Category(16, "Skin Care");
        Category hairCare = new Category(17, "Hair Care");
        //Adding categroies with specified hierarchy
        all.add(fashion);
        all.add(electronics);
        all.add(beautyAndPersonalCare);
        fashion.add(men);
        fashion.add(women);
        men.add(tshirt);
        men.add(trousers);
        men.add(jacket);
        women.add(dress);
        women.add(ktrousers);
        women.add(skirt);
        electronics.add(headset);
        electronics.add(phone);
        electronics.add(television);
        beautyAndPersonalCare.add(makeup);
        beautyAndPersonalCare.add(skinCare);
        beautyAndPersonalCare.add(hairCare);
        //Adding all categories to list accordingto hierarchy
        ArrayList<String> categories = new ArrayList<String>();
        for (Category category : all.getSubCategories()) {
            categories.add(category.getCategoryName());
            for (Category subCategory : category.getSubCategories()) {
                categories.add(subCategory.getCategoryName());
                for (Category subSubCategory : subCategory.getSubCategories()) {
                    categories.add(subSubCategory.getCategoryName());
                }
            }
        }
        //Set categories text
        gui.setSideButtonText(categories);
    }

    //Handle side menu button click events
    //And change product info
    public void sideButtonClick(String buttonName) {
        if (buttonName.equalsIgnoreCase("T-SHIRT")) {
            gui.setProductText(tshirts);
        } else if (buttonName.equalsIgnoreCase("TROUSERS")) {
            gui.setProductText(trousers);
        } else if (buttonName.equalsIgnoreCase("JACKET")) {
            gui.setProductText(jackets);
        } else if (buttonName.equalsIgnoreCase("DRESS")) {
            gui.setProductText(dresses);
        } else if (buttonName.equalsIgnoreCase("W-TROUSERS")) {
            gui.setProductText(wtrousers);
        } else if (buttonName.equalsIgnoreCase("SKIRT")) {
            gui.setProductText(skirts);
        } else if (buttonName.equalsIgnoreCase("HEADSET")) {
            gui.setProductText(headsets);
        } else if (buttonName.equalsIgnoreCase("PHONE")) {
            gui.setProductText(phones);
        } else if (buttonName.equalsIgnoreCase("TELEVISION")) {
            gui.setProductText(televisions);
        } else if (buttonName.equalsIgnoreCase("MAKEUP")) {
            gui.setProductText(makeup);
        } else if (buttonName.equalsIgnoreCase("SKIN CARE")) {
            gui.setProductText(skincare);
        } else if (buttonName.equalsIgnoreCase("HAIR CARE")) {
            gui.setProductText(haircare);
        }
        //Show product panel
        gui.card.show(gui.getMainCardPanel(), "cardProduct");
    }

    //Add to Cart button click event
    //Add the product to the cart lisr
    public void addToCartClick(Product p) {
        cart.add(p);
        gui.getShoppingCartButtonCount().setText(cart.size() + "");
    }

    //Show shopping cart and fill the table with added products
    public void cartListShow() {
        //Find occurrences of products
        Map<Product, Long> counts = cart.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        //Values
        String result[][] = new String[counts.size()][4];
        int index = 0;
        double totalPrice = 0;
        for (Map.Entry<Product, Long> entry : counts.entrySet()) {
            double price = entry.getKey().getPrice();
            result[index][0] = entry.getKey().getProductName();
            result[index][1] = entry.getKey().getColor();
            result[index][2] = price + "₺";
            result[index][3] = entry.getValue().toString();
            totalPrice += price;
            index++;
        }
        // Column Names 
        String[] columnNames = {"ProductName", "Color", "Price", "Count"};
        // Initializing the JTable 
        model = new DefaultTableModel(result, columnNames);
        JTable j = new JTable(model);
        //Set model of shopping cart to the JTable
        gui.getShopCartTable().setModel(j.getModel());
        //Set total price of products
        gui.getShoppingCartTotalPriceText().setText("Total Price: " + totalPrice + "₺");
        //Show shopping cart panel
        gui.card.show(gui.getMainCardPanel(), "cardShop");
    }

    //Remove selected row
    public void cartListDeleteRow() {
        if (gui.getShopCartTable().getSelectedRow() != -1) {
            //Remove selected row from the model
            int row = gui.getShopCartTable().getSelectedRow();
            String productName = gui.getShopCartTable().getValueAt(row, 0).toString();
            //Remove product from cart list and refresh
            deleteFromCartList(productName);
            cartListShow();
            //Refresh shopping cart counter
            gui.getShoppingCartButtonCount().setText(cart.size() + "");
        }
    }

    //Remove element from cat list by name
    private void deleteFromCartList(String name) {
        int find = 0;
        for (Product product : cart) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                find = cart.indexOf(product);
            }
        }
        cart.remove(find);
    }

}
