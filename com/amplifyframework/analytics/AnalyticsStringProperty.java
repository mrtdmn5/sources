package com.amplifyframework.analytics;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnalyticsStringProperty implements AnalyticsPropertyBehavior<String> {
    private final String value;

    private AnalyticsStringProperty(String str) {
        this.value = str;
    }

    public static AnalyticsStringProperty from(String str) {
        Objects.requireNonNull(str);
        return new AnalyticsStringProperty(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnalyticsStringProperty.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getValue(), ((AnalyticsStringProperty) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("AnalyticsStringProperty{value='"), this.value, "'}");
    }

    @Override // com.amplifyframework.analytics.AnalyticsPropertyBehavior
    public String getValue() {
        return this.value;
    }
}
