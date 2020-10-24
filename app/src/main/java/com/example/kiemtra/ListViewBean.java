package com.example.kiemtra;


public class ListViewBean {
    int image;
    String langName;
    String tittle;


    public ListViewBean() {
    }

    public ListViewBean(int image, String langName, String tittle) {
        this.image = image;
        this.langName = langName;
        this.tittle = tittle;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

}