package com.animaconnected.secondo.behaviour.distress.api.request;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class FollowMeLocation {
    public static final int $stable = 8;
    private float accuracy;
    private double lat;

    /* renamed from: long, reason: not valid java name */
    private double f22long;

    public FollowMeLocation() {
        this(0.0d, 0.0d, 0.0f, 7, null);
    }

    public static /* synthetic */ FollowMeLocation copy$default(FollowMeLocation followMeLocation, double d, double d2, float f, int r12, Object obj) {
        if ((r12 & 1) != 0) {
            d = followMeLocation.lat;
        }
        double d3 = d;
        if ((r12 & 2) != 0) {
            d2 = followMeLocation.f22long;
        }
        double d4 = d2;
        if ((r12 & 4) != 0) {
            f = followMeLocation.accuracy;
        }
        return followMeLocation.copy(d3, d4, f);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.f22long;
    }

    public final float component3() {
        return this.accuracy;
    }

    public final FollowMeLocation copy(double d, double d2, float f) {
        return new FollowMeLocation(d, d2, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowMeLocation)) {
            return false;
        }
        FollowMeLocation followMeLocation = (FollowMeLocation) obj;
        if (Double.compare(this.lat, followMeLocation.lat) == 0 && Double.compare(this.f22long, followMeLocation.f22long) == 0 && Float.compare(this.accuracy, followMeLocation.accuracy) == 0) {
            return true;
        }
        return false;
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f22long;
    }

    public int hashCode() {
        return Float.hashCode(this.accuracy) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.f22long, Double.hashCode(this.lat) * 31, 31);
    }

    public final void setAccuracy(float f) {
        this.accuracy = f;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final void setLong(double d) {
        this.f22long = d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FollowMeLocation(lat=");
        sb.append(this.lat);
        sb.append(", long=");
        sb.append(this.f22long);
        sb.append(", accuracy=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.accuracy, ')');
    }

    public FollowMeLocation(double d, double d2, float f) {
        this.lat = d;
        this.f22long = d2;
        this.accuracy = f;
    }

    public /* synthetic */ FollowMeLocation(double d, double d2, float f, int r10, DefaultConstructorMarker defaultConstructorMarker) {
        this((r10 & 1) != 0 ? 0.0d : d, (r10 & 2) == 0 ? d2 : 0.0d, (r10 & 4) != 0 ? 0.0f : f);
    }
}
