package com.sanislo.soft.usastatesapp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class StateModel implements Parcelable {
    private final String area;
    private final String country;
    private final String capital;
    private final String name;
    private final int id;
    private final String abbr;
    private final String largestCity;

    public StateModel(String area, String country, String capital, String name, int id, String abbr, String largestCity) {
        this.area = area;
        this.country = country;
        this.capital = capital;
        this.name = name;
        this.id = id;
        this.abbr = abbr;
        this.largestCity = largestCity;
    }

    protected StateModel(Parcel in) {
        area = in.readString();
        country = in.readString();
        capital = in.readString();
        name = in.readString();
        id = in.readInt();
        abbr = in.readString();
        largestCity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(area);
        dest.writeString(country);
        dest.writeString(capital);
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(abbr);
        dest.writeString(largestCity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StateModel> CREATOR = new Creator<StateModel>() {
        @Override
        public StateModel createFromParcel(Parcel in) {
            return new StateModel(in);
        }

        @Override
        public StateModel[] newArray(int size) {
            return new StateModel[size];
        }
    };

    public String getArea() {
        return area;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getLargestCity() {
        return largestCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateModel that = (StateModel) o;
        return id == that.id &&
                Objects.equals(area, that.area) &&
                Objects.equals(country, that.country) &&
                Objects.equals(capital, that.capital) &&
                Objects.equals(name, that.name) &&
                Objects.equals(abbr, that.abbr) &&
                Objects.equals(largestCity, that.largestCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, country, capital, name, id, abbr, largestCity);
    }

    @Override
    public String toString() {
        return "StateModel{" +
                "area='" + area + '\'' +
                ", country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", abbr='" + abbr + '\'' +
                ", largestCity='" + largestCity + '\'' +
                '}';
    }
}
