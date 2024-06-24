package com.amplifyframework.geo.models;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class MapStyleDescriptor {
    private final String json;

    public MapStyleDescriptor(String str) {
        Objects.requireNonNull(str);
        this.json = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MapStyleDescriptor.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.json, ((MapStyleDescriptor) obj).json);
        }
        return false;
    }

    public String getJson() {
        return this.json;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.json);
    }

    public String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("MapStyleDescriptor{json='"), this.json, "'}");
    }
}
