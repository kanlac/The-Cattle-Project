package model;

import java.io.Serializable;

public class Cattle implements Serializable {

    private String c_id;
    private String number;
    private Sex sex;

    /** Getters and Setters */

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

}

enum Sex {
    Male, Female;
}