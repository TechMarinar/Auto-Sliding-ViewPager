package com.techmarinar.modernviewpagerapp.tabdata;

public class TabClass {
    private int pic;
    private String tabName;

    public TabClass(int pic, String tabName) {
        this.pic = pic;
        this.tabName = tabName;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
}
