package com.example.barang.fyp;

public class Wanderer {
    String wandererId;
    String wandererUser;
    String wandererPass;
    String wandererFirstName;
    String wandererLastName;
    String wandererEmail;
    String wandererPhone;

    public Wanderer()
    {


    }

    public Wanderer(String wandererId, String wandererUser, String wandererPass, String wandererFirstName, String wandererLastName, String wandererEmail, String wandererPhone) {
        this.wandererId = wandererId;
        this.wandererUser = wandererUser;
        this.wandererPass = wandererPass;
        this.wandererFirstName = wandererFirstName;
        this.wandererLastName = wandererLastName;
        this.wandererEmail = wandererEmail;
        this.wandererPhone = wandererPhone;
    }

    public String getWandererId() {
        return wandererId;
    }

    public void setWandererId(String wandererId) {
        this.wandererId = wandererId;
    }

    public String getWandererUser() {
        return wandererUser;
    }

    public void setWandererUser(String wandererUser) {
        this.wandererUser = wandererUser;
    }

    public String getWandererPass() {
        return wandererPass;
    }

    public void setWandererPass(String wandererPass) {
        this.wandererPass = wandererPass;
    }

    public String getWandererFirstName() {
        return wandererFirstName;
    }

    public void setWandererFirstName(String wandererFirstName) {
        this.wandererFirstName = wandererFirstName;
    }

    public String getWandererLastName() {
        return wandererLastName;
    }

    public void setWandererLastName(String wandererLastName) {
        this.wandererLastName = wandererLastName;
    }

    public String getWandererEmail() {
        return wandererEmail;
    }

    public void setWandererEmail(String wandererEmail) {
        this.wandererEmail = wandererEmail;
    }

    public String getWandererPhone() {
        return wandererPhone;
    }

    public void setWandererPhone(String wandererPhone) {
        this.wandererPhone = wandererPhone;
    }
}
