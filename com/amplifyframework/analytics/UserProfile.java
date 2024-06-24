package com.amplifyframework.analytics;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public class UserProfile {
    private final AnalyticsProperties customProperties;
    private final String email;
    private final Location location;
    private final String name;
    private final String plan;

    /* loaded from: classes.dex */
    public static class Builder<B extends Builder<?, ?>, O extends UserProfile> {
        private AnalyticsProperties customProperties;
        private String email;
        private Location location;
        private String name;
        private String plan;

        public O build() {
            return (O) new UserProfile(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B customProperties(AnalyticsProperties analyticsProperties) {
            Objects.requireNonNull(analyticsProperties);
            this.customProperties = analyticsProperties;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B email(String str) {
            Objects.requireNonNull(str);
            this.email = str;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B location(Location location) {
            Objects.requireNonNull(location);
            this.location = location;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B plan(String str) {
            Objects.requireNonNull(str);
            this.plan = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class Location {
        private final String city;
        private final String country;
        private final Double latitude;
        private final Double longitude;
        private final String postalCode;
        private final String region;

        /* loaded from: classes.dex */
        public static final class Builder {
            private String city;
            private String country;
            private Double latitude;
            private Double longitude;
            private String postalCode;
            private String region;

            public Location build() {
                return new Location(this);
            }

            public Builder city(String str) {
                Objects.requireNonNull(str);
                this.city = str;
                return this;
            }

            public Builder country(String str) {
                Objects.requireNonNull(str);
                this.country = str;
                return this;
            }

            public Builder latitude(Double d) {
                Objects.requireNonNull(d);
                this.latitude = d;
                return this;
            }

            public Builder longitude(Double d) {
                Objects.requireNonNull(d);
                this.longitude = d;
                return this;
            }

            public Builder postalCode(String str) {
                Objects.requireNonNull(str);
                this.postalCode = str;
                return this;
            }

            public Builder region(String str) {
                Objects.requireNonNull(str);
                this.region = str;
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
            if (obj == null || Location.class != obj.getClass()) {
                return false;
            }
            Location location = (Location) obj;
            if (!ObjectsCompat$Api19Impl.equals(this.latitude, location.latitude) || !ObjectsCompat$Api19Impl.equals(this.longitude, location.longitude) || !ObjectsCompat$Api19Impl.equals(this.postalCode, location.postalCode) || !ObjectsCompat$Api19Impl.equals(this.city, location.city) || !ObjectsCompat$Api19Impl.equals(this.region, location.region)) {
                return false;
            }
            return ObjectsCompat$Api19Impl.equals(this.country, location.country);
        }

        public String getCity() {
            return this.city;
        }

        public String getCountry() {
            return this.country;
        }

        public Double getLatitude() {
            return this.latitude;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public String getPostalCode() {
            return this.postalCode;
        }

        public String getRegion() {
            return this.region;
        }

        public int hashCode() {
            int r0;
            int r2;
            int r22;
            int r23;
            int r24;
            Double d = this.latitude;
            int r1 = 0;
            if (d != null) {
                r0 = d.hashCode();
            } else {
                r0 = 0;
            }
            int r02 = r0 * 31;
            Double d2 = this.longitude;
            if (d2 != null) {
                r2 = d2.hashCode();
            } else {
                r2 = 0;
            }
            int r03 = (r02 + r2) * 31;
            String str = this.postalCode;
            if (str != null) {
                r22 = str.hashCode();
            } else {
                r22 = 0;
            }
            int r04 = (r03 + r22) * 31;
            String str2 = this.city;
            if (str2 != null) {
                r23 = str2.hashCode();
            } else {
                r23 = 0;
            }
            int r05 = (r04 + r23) * 31;
            String str3 = this.region;
            if (str3 != null) {
                r24 = str3.hashCode();
            } else {
                r24 = 0;
            }
            int r06 = (r05 + r24) * 31;
            String str4 = this.country;
            if (str4 != null) {
                r1 = str4.hashCode();
            }
            return r06 + r1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Location{latitude=");
            sb.append(this.latitude);
            sb.append(", longitude=");
            sb.append(this.longitude);
            sb.append(", postalCode='");
            sb.append(this.postalCode);
            sb.append("', city='");
            sb.append(this.city);
            sb.append("', region='");
            sb.append(this.region);
            sb.append("', country='");
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.country, "'}");
        }

        private Location(Builder builder) {
            this.latitude = builder.latitude;
            this.longitude = builder.longitude;
            this.postalCode = builder.postalCode;
            this.city = builder.city;
            this.region = builder.region;
            this.country = builder.country;
        }
    }

    public UserProfile(Builder<?, ?> builder) {
        this.name = ((Builder) builder).name;
        this.email = ((Builder) builder).email;
        this.plan = ((Builder) builder).plan;
        this.location = ((Builder) builder).location;
        this.customProperties = ((Builder) builder).customProperties;
    }

    public static Builder<?, ?> builder() {
        return new Builder<>();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserProfile userProfile = (UserProfile) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.name, userProfile.name) || !ObjectsCompat$Api19Impl.equals(this.email, userProfile.email) || !ObjectsCompat$Api19Impl.equals(this.plan, userProfile.plan) || !ObjectsCompat$Api19Impl.equals(this.location, userProfile.location)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.customProperties, userProfile.customProperties);
    }

    public AnalyticsProperties getCustomProperties() {
        return this.customProperties;
    }

    public String getEmail() {
        return this.email;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getPlan() {
        return this.plan;
    }

    public int hashCode() {
        int r0;
        int r2;
        int r22;
        int r23;
        String str = this.name;
        int r1 = 0;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        String str2 = this.email;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r03 = (r02 + r2) * 31;
        String str3 = this.plan;
        if (str3 != null) {
            r22 = str3.hashCode();
        } else {
            r22 = 0;
        }
        int r04 = (r03 + r22) * 31;
        Location location = this.location;
        if (location != null) {
            r23 = location.hashCode();
        } else {
            r23 = 0;
        }
        int r05 = (r04 + r23) * 31;
        AnalyticsProperties analyticsProperties = this.customProperties;
        if (analyticsProperties != null) {
            r1 = analyticsProperties.hashCode();
        }
        return r05 + r1;
    }

    public String toString() {
        return "UserProfile{name='" + this.name + "', email='" + this.email + "', plan='" + this.plan + "', location=" + this.location + ", customProperties=" + this.customProperties + '}';
    }
}
