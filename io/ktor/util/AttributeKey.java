package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attributes.kt */
/* loaded from: classes3.dex */
public final class AttributeKey<T> {
    public final String name;

    public AttributeKey(String name) {
        boolean z;
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        if (name.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
        } else {
            throw new IllegalStateException("Name can't be blank");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AttributeKey.class == obj.getClass() && Intrinsics.areEqual(this.name, ((AttributeKey) obj).name)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return "AttributeKey: " + this.name;
    }
}
