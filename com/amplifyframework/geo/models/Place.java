package com.amplifyframework.geo.models;

import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public class Place {
    private final Geometry geometry;

    public Place(Geometry geometry) {
        this.geometry = geometry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.geometry, ((Place) obj).geometry);
        }
        return false;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.geometry);
    }

    public String toString() {
        return "Place{geometry=" + this.geometry + '}';
    }
}
