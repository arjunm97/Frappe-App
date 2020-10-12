package com.endlessbay.arjun.frappe.Model;

public class Food {
    private String Name, Image, Price, Discount, Description, MenuId;

    public Food() {

    }

    public Food(String name, String image, String price, String discount, String description, String menuId) {
        Name = name;
        Image = image;
        Price = price;
        Discount = discount;
        Description = description;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
