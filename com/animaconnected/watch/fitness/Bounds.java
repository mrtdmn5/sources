package com.animaconnected.watch.fitness;

import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: LocationUtils.kt */
/* loaded from: classes3.dex */
public final class Bounds {
    private final double northEastLat;
    private final double northEastLong;
    private final double southWestLat;
    private final double southWestLong;

    public Bounds(double d, double d2, double d3, double d4) {
        this.northEastLat = d;
        this.northEastLong = d2;
        this.southWestLat = d3;
        this.southWestLong = d4;
    }

    public static /* synthetic */ Bounds copy$default(Bounds bounds, double d, double d2, double d3, double d4, int r18, Object obj) {
        double d5;
        double d6;
        double d7;
        double d8;
        if ((r18 & 1) != 0) {
            d5 = bounds.northEastLat;
        } else {
            d5 = d;
        }
        if ((r18 & 2) != 0) {
            d6 = bounds.northEastLong;
        } else {
            d6 = d2;
        }
        if ((r18 & 4) != 0) {
            d7 = bounds.southWestLat;
        } else {
            d7 = d3;
        }
        if ((r18 & 8) != 0) {
            d8 = bounds.southWestLong;
        } else {
            d8 = d4;
        }
        return bounds.copy(d5, d6, d7, d8);
    }

    public final double component1() {
        return this.northEastLat;
    }

    public final double component2() {
        return this.northEastLong;
    }

    public final double component3() {
        return this.southWestLat;
    }

    public final double component4() {
        return this.southWestLong;
    }

    public final Bounds copy(double d, double d2, double d3, double d4) {
        return new Bounds(d, d2, d3, d4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bounds)) {
            return false;
        }
        Bounds bounds = (Bounds) obj;
        if (Double.compare(this.northEastLat, bounds.northEastLat) == 0 && Double.compare(this.northEastLong, bounds.northEastLong) == 0 && Double.compare(this.southWestLat, bounds.southWestLat) == 0 && Double.compare(this.southWestLong, bounds.southWestLong) == 0) {
            return true;
        }
        return false;
    }

    public final double getNorthEastLat() {
        return this.northEastLat;
    }

    public final double getNorthEastLong() {
        return this.northEastLong;
    }

    public final double getSouthWestLat() {
        return this.southWestLat;
    }

    public final double getSouthWestLong() {
        return this.southWestLong;
    }

    public int hashCode() {
        return Double.hashCode(this.southWestLong) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.southWestLat, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.northEastLong, Double.hashCode(this.northEastLat) * 31, 31), 31);
    }

    public String toString() {
        return "Bounds(northEastLat=" + this.northEastLat + ", northEastLong=" + this.northEastLong + ", southWestLat=" + this.southWestLat + ", southWestLong=" + this.southWestLong + ')';
    }
}
