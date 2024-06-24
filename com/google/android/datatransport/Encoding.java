package com.google.android.datatransport;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class Encoding {
    public final String name;

    public Encoding(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Encoding{name=\""), this.name, "\"}");
    }
}
