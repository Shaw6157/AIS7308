package com.ais.testhomemade;

public class ShawMenu {
    private int menuID;
    private String name;
    private int price;
    private String type;

    public ShawMenu(int pMenuID, String pName, int pPrice, String pDesc) {
        menuID = pMenuID;
        name = pName;
        price = pPrice;
        type = pDesc;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int pMenuID) {
        menuID = pMenuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int pPrice) {
        price = pPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String pDesc) {
        type = pDesc;
    }
}
