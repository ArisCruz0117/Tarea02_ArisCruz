package com.iteso.test.beans;

import android.os.Parcelable;
import android.os.Parcel;

public class User implements Parcelable {
    private String name;
    private String password;
    private boolean isLogged;

    public User() {
        setName("");
        setPassword("");
        setLogged(false);
    }

    @Override
    public String toString() {
        return "User{" +
                "\nName=" + name + '\'' +
                ", \nPassword='" + password + '\'' +
                ", \nisLogged='" + isLogged +
                '}';
    }

    public User(String name, String password, boolean isLogged) {
        setName(name);
        setPassword(password);
        setLogged(isLogged);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;}
    public boolean isLogged() {
        return isLogged;
    }
    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;}

    public User(Parcel in){
        name = in.readString();
        password = in.readString();
        isLogged  = (in.readInt() == 0) ? false : true;//taken from stackOverflow

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
        dest.writeValue(isLogged);//taken from stackOverflow
    }
    public static final Parcelable.Creator<User> CREATOR = new
            Parcelable.Creator<User>() {
                @Override
                public User createFromParcel(Parcel source) {
                    // using parcelable constructor
                    return new User (source);
                }
                @Override
                public User [] newArray(int size) {
                    return new User [size];
                }
            };
}