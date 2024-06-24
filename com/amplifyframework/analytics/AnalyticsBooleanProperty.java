package com.amplifyframework.analytics;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnalyticsBooleanProperty implements AnalyticsPropertyBehavior<Boolean> {
    private final Boolean value;

    private AnalyticsBooleanProperty(Boolean bool) {
        this.value = bool;
    }

    public static AnalyticsBooleanProperty from(Boolean bool) {
        Objects.requireNonNull(bool);
        return new AnalyticsBooleanProperty(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnalyticsBooleanProperty.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getValue(), ((AnalyticsBooleanProperty) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "AnalyticsBooleanProperty{value=" + this.value + '}';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amplifyframework.analytics.AnalyticsPropertyBehavior
    public Boolean getValue() {
        return this.value;
    }
}
