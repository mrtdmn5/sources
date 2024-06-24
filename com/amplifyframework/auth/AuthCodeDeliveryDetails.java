package com.amplifyframework.auth;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthCodeDeliveryDetails {
    private String attributeName;
    private DeliveryMedium deliveryMedium;
    private String destination;

    /* loaded from: classes.dex */
    public enum DeliveryMedium {
        EMAIL("email"),
        SMS("sms"),
        PHONE("phone"),
        UNKNOWN("unknown");

        private String value;

        DeliveryMedium(String str) {
            Objects.requireNonNull(str);
            this.value = str;
        }

        public static DeliveryMedium fromString(String str) {
            for (DeliveryMedium deliveryMedium : values()) {
                if (deliveryMedium.getValue().equalsIgnoreCase(str)) {
                    return deliveryMedium;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.value;
        }
    }

    public AuthCodeDeliveryDetails(String str, DeliveryMedium deliveryMedium) {
        this(str, deliveryMedium, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthCodeDeliveryDetails.class != obj.getClass()) {
            return false;
        }
        AuthCodeDeliveryDetails authCodeDeliveryDetails = (AuthCodeDeliveryDetails) obj;
        if (ObjectsCompat$Api19Impl.equals(getDestination(), authCodeDeliveryDetails.getDestination()) && ObjectsCompat$Api19Impl.equals(getDeliveryMedium(), authCodeDeliveryDetails.getDeliveryMedium()) && ObjectsCompat$Api19Impl.equals(getAttributeName(), authCodeDeliveryDetails.getAttributeName())) {
            return true;
        }
        return false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public DeliveryMedium getDeliveryMedium() {
        return this.deliveryMedium;
    }

    public String getDestination() {
        return this.destination;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getDestination(), getDeliveryMedium(), getAttributeName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthCodeDeliveryDetails{destination='");
        sb.append(this.destination);
        sb.append("', deliveryMedium=");
        sb.append(this.deliveryMedium);
        sb.append(", attributeName='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.attributeName, "'}");
    }

    public AuthCodeDeliveryDetails(String str, DeliveryMedium deliveryMedium, String str2) {
        Objects.requireNonNull(str);
        this.destination = str;
        Objects.requireNonNull(deliveryMedium);
        this.deliveryMedium = deliveryMedium;
        this.attributeName = str2;
    }
}
