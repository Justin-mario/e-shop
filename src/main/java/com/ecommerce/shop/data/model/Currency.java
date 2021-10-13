package com.ecommerce.shop.data.model;

public enum Currency {

    NGN("Naira"), USD("Dollars"), SRC("Singapore Dollar"), GBP("British Pounds"), FRC("Franc"), GHC("Ghana Cedis");

    private String name;
    Currency(String s){

    }

    public String getName(){
       return name;
    }

}
