package com.example.admin.demo.Model;

/**
 * Created by ADMIN on 12/7/2019.
 */

public class Xe {
    private  String Name;
    private  String Image;
    private String  MoTa;
    private String  Gia;
    private String  MenuId;
    public Xe(){}
    public Xe(String name, String image, String moTa, String gia, String menuId) {
        Name = name;
        Image = image;
        MoTa = moTa;
        Gia = gia;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public String getMoTa() {
        return MoTa;
    }

    public String getGia() {
        return Gia;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
