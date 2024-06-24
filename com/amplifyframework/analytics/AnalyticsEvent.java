package com.amplifyframework.analytics;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.analytics.AnalyticsProperties;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AnalyticsEvent implements AnalyticsEventBehavior {
    private final String name;
    private final AnalyticsProperties properties;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String name;
        private AnalyticsProperties.Builder propertiesBuilder;

        public Builder addProperty(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            this.propertiesBuilder.add(str, str2);
            return this;
        }

        public AnalyticsEvent build() {
            return new AnalyticsEvent(this.name, this.propertiesBuilder.build());
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        private Builder() {
            this.propertiesBuilder = AnalyticsProperties.builder();
        }

        public Builder addProperty(String str, Double d) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(d);
            this.propertiesBuilder.add(str, d);
            return this;
        }

        public Builder addProperty(String str, Boolean bool) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(bool);
            this.propertiesBuilder.add(str, bool);
            return this;
        }

        public Builder addProperty(String str, Integer num) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(num);
            this.propertiesBuilder.add(str, num);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsEvent.class != obj.getClass()) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        if (!ObjectsCompat$Api19Impl.equals(getName(), analyticsEvent.getName())) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(getProperties(), analyticsEvent.getProperties());
    }

    @Override // com.amplifyframework.analytics.AnalyticsEventBehavior
    public String getName() {
        return this.name;
    }

    @Override // com.amplifyframework.analytics.AnalyticsEventBehavior
    public AnalyticsProperties getProperties() {
        return this.properties;
    }

    public int hashCode() {
        return getProperties().hashCode() + (getName().hashCode() * 31);
    }

    public String toString() {
        return "AnalyticsEvent{name='" + this.name + "', properties=" + this.properties + '}';
    }

    private AnalyticsEvent(String str, AnalyticsProperties analyticsProperties) {
        this.name = str;
        this.properties = analyticsProperties;
    }
}
