package com.google.firebase.encoders;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class FieldDescriptor {
    public final String name;
    public final Map<Class<?>, Object> properties;

    public FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }
}
