package com.example.findmyretailer;

public class Details {
    private String RetailerName;
    private String RetailerId;
    private String Address;
    private String ContactNumb;
    private String LAtitude;
    private String Longitude;
    private String Pincode;
    private String defult;

    public Details(String retailerName, String retailerId, String address, String contactNumb, String LAtitude, String longitude, String phno,String defult) {
        RetailerName = retailerName;
        RetailerId = retailerId;
        Address = address;
        ContactNumb = contactNumb;
        this.LAtitude = LAtitude;
        Longitude = longitude;
        Pincode = phno;
        this.defult=defult;
    }

    public String getRetailerName() {
        return RetailerName;
    }

    public String getRetailerId() {
        return RetailerId;
    }

    public String getAddress() {
        return Address;
    }

    public String getContactNumb() {
        return ContactNumb;
    }

    public String getLAtitude() {
        return LAtitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getPhno() {
        return Pincode;
    }

    public String getDefult() {
        return defult;
    }
}
