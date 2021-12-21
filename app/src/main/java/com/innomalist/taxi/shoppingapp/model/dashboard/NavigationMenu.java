package com.innomalist.taxi.shoppingapp.model.dashboard;

public class NavigationMenu {
    int menuId;
    String menuName;
    int resourceId;

    public int getMenuId() {
        return this.menuId;
    }

    public void setMenuId(int i) {
        this.menuId = i;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(int i) {
        this.resourceId = i;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public NavigationMenu(int i, int i2, String str) {
        this.menuId = i;
        this.resourceId = i2;
        this.menuName = str;
    }
}
