package com.amplifyframework.auth;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthDevice {
    private final String id;
    private final String name;

    private AuthDevice(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public static AuthDevice fromId(String str) {
        return fromId(str, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthDevice.class != obj.getClass()) {
            return false;
        }
        AuthDevice authDevice = (AuthDevice) obj;
        if (ObjectsCompat$Api19Impl.equals(getId(), authDevice.getId()) && ObjectsCompat$Api19Impl.equals(getName(), authDevice.getName())) {
            return true;
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getId(), getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthDevice{id='");
        sb.append(this.id);
        sb.append("', name='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.name, "'}");
    }

    public static AuthDevice fromId(String str, String str2) {
        Objects.requireNonNull(str);
        return new AuthDevice(str, str2);
    }
}
