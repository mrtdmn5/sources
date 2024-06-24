package com.amplifyframework.analytics;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnalyticsProperties implements Iterable<Map.Entry<String, AnalyticsPropertyBehavior<?>>> {
    private final Map<String, AnalyticsPropertyBehavior<?>> properties;

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnalyticsProperties.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.properties, ((AnalyticsProperties) obj).properties);
        }
        return false;
    }

    public AnalyticsPropertyBehavior<?> get(String str) throws NoSuchElementException {
        if (this.properties.get(str) != null) {
            return this.properties.get(str);
        }
        throw new NoSuchElementException(ConstraintSet$$ExternalSyntheticOutline0.m("AnalyticsPropertyBehavior not found ", str));
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<String, AnalyticsPropertyBehavior<?>>> iterator() {
        return this.properties.entrySet().iterator();
    }

    public int size() {
        return this.properties.size();
    }

    public String toString() {
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AnalyticsProperties{properties="), this.properties, '}');
    }

    private AnalyticsProperties(Map<String, AnalyticsPropertyBehavior<?>> map) {
        this.properties = map;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Map<String, AnalyticsPropertyBehavior<?>> properties = new HashMap();

        public Builder add(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            this.properties.put(str, AnalyticsStringProperty.from(str2));
            return this;
        }

        public AnalyticsProperties build() {
            return new AnalyticsProperties(this.properties);
        }

        public Builder add(String str, Double d) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(d);
            this.properties.put(str, AnalyticsDoubleProperty.from(d));
            return this;
        }

        public Builder add(String str, Boolean bool) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(bool);
            this.properties.put(str, AnalyticsBooleanProperty.from(bool));
            return this;
        }

        public Builder add(String str, Integer num) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(num);
            this.properties.put(str, AnalyticsIntegerProperty.from(num));
            return this;
        }

        public <T, P extends AnalyticsPropertyBehavior<T>> Builder add(String str, P p) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(p);
            this.properties.put(str, p);
            return this;
        }
    }
}
