package com.example.contextintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name;
    private String surname;

    // Constructor
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    // Parcelling part
    public Person(Parcel in){
        String[] data = new String[2];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.name = data[0];
        this.surname = data[1];
    }

    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.name,
                this.surname});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
}