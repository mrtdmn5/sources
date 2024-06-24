package com.amplifyframework.geo.models;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class MapStyle {
    private final String mapName;
    private final String style;

    public MapStyle(String str, String str2) {
        Objects.requireNonNull(str);
        this.mapName = str;
        Objects.requireNonNull(str2);
        this.style = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MapStyle.class != obj.getClass()) {
            return false;
        }
        MapStyle mapStyle = (MapStyle) obj;
        if (ObjectsCompat$Api19Impl.equals(this.mapName, mapStyle.mapName) && ObjectsCompat$Api19Impl.equals(this.style, mapStyle.style)) {
            return true;
        }
        return false;
    }

    public String getMapName() {
        return this.mapName;
    }

    public String getStyle() {
        return this.style;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.mapName, this.style);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MapStyle{mapName='");
        sb.append(this.mapName);
        sb.append("', style='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.style, "'}");
    }
}
