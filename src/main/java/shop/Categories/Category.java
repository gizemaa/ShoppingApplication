package shop.Categories;

import java.util.ArrayList;
import java.util.List;
/*
Composite Pattern
*/
public class Category {

    //Variables
    private int categoryID;
    private String categoryName;
    private List<Category> subCategories;

    //Constructor
    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.subCategories = new ArrayList<Category>();
    }

    //Add category to subcategory list
    public void add(Category c) {
        this.subCategories.add(c);
    }

    //Remove category from subcategory list
    public void remove(Category c) {
        this.subCategories.remove(c);
    }

    //Return list of sub categories
    public List<Category> getSubCategories() {
        return this.subCategories;
    }

    //Get categroy name
    public String getCategoryName() {
        return categoryName;
    }    
    
    //To string method
    public String toString() {
        return ("Category :[ ID : " + this.categoryID + ", Name : " + this.categoryName + "]");
    }

}
