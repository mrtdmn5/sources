package com.amplifyframework.geo.models;

import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class Coordinates implements Geometry {
    private double latitude;
    private double longitude;

    public Coordinates() {
        this(0.0d, 0.0d);
    }

    public double centralAngle(Coordinates coordinates) {
        double radians = Math.toRadians(this.latitude - coordinates.latitude);
        double radians2 = Math.toRadians(this.longitude - coordinates.longitude);
        double d = radians / 2.0d;
        double d2 = radians2 / 2.0d;
        double cos = (Math.cos(Math.toRadians(coordinates.latitude)) * Math.cos(Math.toRadians(this.latitude)) * Math.sin(d2) * Math.sin(d2)) + (Math.sin(d) * Math.sin(d));
        return Math.atan2(Math.sqrt(cos), Math.sqrt(1.0d - cos)) * 2.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Coordinates.class != obj.getClass()) {
            return false;
        }
        Coordinates coordinates = (Coordinates) obj;
        if (ObjectsCompat$Api19Impl.equals(Double.valueOf(this.latitude), Double.valueOf(coordinates.latitude)) && ObjectsCompat$Api19Impl.equals(Double.valueOf(this.longitude), Double.valueOf(coordinates.longitude))) {
            return true;
        }
        return false;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Double.valueOf(this.latitude), Double.valueOf(this.longitude));
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public String toString() {
        return "Coordinates{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }

    public Coordinates(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }
}
