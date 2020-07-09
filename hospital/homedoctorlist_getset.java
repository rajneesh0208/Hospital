package com.example.hospital;

public class homedoctorlist_getset {
private String doctorname;
private String doctorimage;
private String departmentnme;
private String description;

    public homedoctorlist_getset() {
        this.doctorname = doctorname;
        this.doctorimage = doctorimage;
        this.departmentnme = departmentnme;
        this.description = description;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctorimage() {
        return doctorimage;
    }

    public void setDoctorimage(String doctorimage) {
        this.doctorimage = doctorimage;
    }

    public String getDepartmentnme() {
        return departmentnme;
    }

    public void setDepartmentnme(String departmentnme) {
        this.departmentnme = departmentnme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
