package com.amplifyframework.geo.models;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class SearchArea {
    private final Coordinates biasPosition;
    private final BoundingBox boundingBox;

    private SearchArea(BoundingBox boundingBox, Coordinates coordinates) {
        this.boundingBox = boundingBox;
        this.biasPosition = coordinates;
    }

    public static SearchArea near(Coordinates coordinates) {
        Objects.requireNonNull(coordinates);
        return new SearchArea(null, coordinates);
    }

    public static SearchArea within(BoundingBox boundingBox) {
        Objects.requireNonNull(boundingBox);
        return new SearchArea(boundingBox, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SearchArea.class != obj.getClass()) {
            return false;
        }
        SearchArea searchArea = (SearchArea) obj;
        if (ObjectsCompat$Api19Impl.equals(this.boundingBox, searchArea.boundingBox) && ObjectsCompat$Api19Impl.equals(this.biasPosition, searchArea.biasPosition)) {
            return true;
        }
        return false;
    }

    public Coordinates getBiasPosition() {
        return this.biasPosition;
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.boundingBox, this.biasPosition);
    }

    public String toString() {
        return "SearchArea{boundingBox=" + this.boundingBox + ", biasPosition=" + this.biasPosition + '}';
    }
}
