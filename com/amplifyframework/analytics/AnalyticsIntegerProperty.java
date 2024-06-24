package com.amplifyframework.analytics;

import androidx.core.util.ObjectsCompat$Api19Impl;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnalyticsIntegerProperty implements AnalyticsPropertyBehavior<Integer> {
    private final Integer value;

    private AnalyticsIntegerProperty(Integer num) {
        this.value = num;
    }

    public static AnalyticsIntegerProperty from(Integer num) {
        Objects.requireNonNull(num);
        return new AnalyticsIntegerProperty(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnalyticsIntegerProperty.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getValue(), ((AnalyticsIntegerProperty) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return NoProxyHost$$ExternalSyntheticOutline0.m(new StringBuilder("AnalyticsIntegerProperty{value="), this.value, '}');
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amplifyframework.analytics.AnalyticsPropertyBehavior
    public Integer getValue() {
        return this.value;
    }
}
