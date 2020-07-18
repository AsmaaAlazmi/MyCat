package com.example.mycat;

import java.io.Serializable;

public class Cats2 implements Serializable {

    private String name2;
    private String gender;
    private String age;
    private String number2;
    private String details2;
    private String rules;
    private String reason;
    private String health;
    private String check1;
    private String breed2;
    private String check2;
    private int image2;

    public Cats2(String name2, String gender, String age, String number2, String details2, String rules, String reason, String health, String check1, String breed2, String check2, int image2) {
        this.name2 = name2;
        this.gender = gender;
        this.age = age;
        this.number2 = number2;
        this.details2 = details2;
        this.rules = rules;
        this.reason = reason;
        this.health = health;
        this.check1 = check1;
        this.breed2 = breed2;
        this.check2 = check2;
        this.image2 = image2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getBreed2() {
        return breed2;
    }

    public void setBreed2(String breed2) {
        this.breed2 = breed2;
    }

    public String getCheck2() {
        return check2;
    }

    public void setCheck2(String check2) {
        this.check2 = check2;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
}