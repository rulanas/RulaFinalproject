package com.example.hp1.finalproject;

/**
 * Created by Hp1 on 23/01/2018.
 */

public class DailyMeal {

     private long id;
     private String day;
     private int cal1;
     private int cal2;
     private int cal3;
     private int total;

    public DailyMeal(long id, String day, int cal1, int cal2, int cal3, int total) {
        this.id = id;
        this.day = day;
        this.cal1 = cal1;
        this.cal2 = cal2;
        this.cal3 = cal3;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public int getCal1() {
        return cal1;
    }

    public int getCal2() {
        return cal2;
    }

    public int getCal3() {
        return cal3;
    }

    public int getTotal() {
        return total;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCal1(int cal1) {
        this.cal1 = cal1;
    }

    public void setCal2(int cal2) {
        this.cal2 = cal2;
    }

    public void setCal3(int cal3) {
        this.cal3 = cal3;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

