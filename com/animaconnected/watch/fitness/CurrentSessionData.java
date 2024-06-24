package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class CurrentSessionData {
    private final Distance distance;
    private final GpsQuality gpsQuality;
    private final Integer identifier;
    private final SessionState sessionState;
    private final Float speed;
    private final Boolean useConnectedGps;

    public CurrentSessionData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CurrentSessionData copy$default(CurrentSessionData currentSessionData, Integer num, Boolean bool, SessionState sessionState, GpsQuality gpsQuality, Distance distance, Float f, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            num = currentSessionData.identifier;
        }
        if ((r11 & 2) != 0) {
            bool = currentSessionData.useConnectedGps;
        }
        Boolean bool2 = bool;
        if ((r11 & 4) != 0) {
            sessionState = currentSessionData.sessionState;
        }
        SessionState sessionState2 = sessionState;
        if ((r11 & 8) != 0) {
            gpsQuality = currentSessionData.gpsQuality;
        }
        GpsQuality gpsQuality2 = gpsQuality;
        if ((r11 & 16) != 0) {
            distance = currentSessionData.distance;
        }
        Distance distance2 = distance;
        if ((r11 & 32) != 0) {
            f = currentSessionData.speed;
        }
        return currentSessionData.copy(num, bool2, sessionState2, gpsQuality2, distance2, f);
    }

    public final Integer component1() {
        return this.identifier;
    }

    public final Boolean component2() {
        return this.useConnectedGps;
    }

    public final SessionState component3() {
        return this.sessionState;
    }

    public final GpsQuality component4() {
        return this.gpsQuality;
    }

    public final Distance component5() {
        return this.distance;
    }

    public final Float component6() {
        return this.speed;
    }

    public final CurrentSessionData copy(Integer num, Boolean bool, SessionState sessionState, GpsQuality gpsQuality, Distance distance, Float f) {
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(gpsQuality, "gpsQuality");
        Intrinsics.checkNotNullParameter(distance, "distance");
        return new CurrentSessionData(num, bool, sessionState, gpsQuality, distance, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentSessionData)) {
            return false;
        }
        CurrentSessionData currentSessionData = (CurrentSessionData) obj;
        if (Intrinsics.areEqual(this.identifier, currentSessionData.identifier) && Intrinsics.areEqual(this.useConnectedGps, currentSessionData.useConnectedGps) && this.sessionState == currentSessionData.sessionState && this.gpsQuality == currentSessionData.gpsQuality && Intrinsics.areEqual(this.distance, currentSessionData.distance) && Intrinsics.areEqual(this.speed, currentSessionData.speed)) {
            return true;
        }
        return false;
    }

    public final Distance getDistance() {
        return this.distance;
    }

    public final GpsQuality getGpsQuality() {
        return this.gpsQuality;
    }

    public final Integer getIdentifier() {
        return this.identifier;
    }

    public final SessionState getSessionState() {
        return this.sessionState;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final Boolean getUseConnectedGps() {
        return this.useConnectedGps;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Integer num = this.identifier;
        int r1 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = hashCode * 31;
        Boolean bool = this.useConnectedGps;
        if (bool == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool.hashCode();
        }
        int hashCode3 = (this.distance.hashCode() + ((this.gpsQuality.hashCode() + ((this.sessionState.hashCode() + ((r0 + hashCode2) * 31)) * 31)) * 31)) * 31;
        Float f = this.speed;
        if (f != null) {
            r1 = f.hashCode();
        }
        return hashCode3 + r1;
    }

    public String toString() {
        return "CurrentSessionData(identifier=" + this.identifier + ", useConnectedGps=" + this.useConnectedGps + ", sessionState=" + this.sessionState + ", gpsQuality=" + this.gpsQuality + ", distance=" + this.distance + ", speed=" + this.speed + ')';
    }

    public CurrentSessionData(Integer num, Boolean bool, SessionState sessionState, GpsQuality gpsQuality, Distance distance, Float f) {
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(gpsQuality, "gpsQuality");
        Intrinsics.checkNotNullParameter(distance, "distance");
        this.identifier = num;
        this.useConnectedGps = bool;
        this.sessionState = sessionState;
        this.gpsQuality = gpsQuality;
        this.distance = distance;
        this.speed = f;
    }

    public /* synthetic */ CurrentSessionData(Integer num, Boolean bool, SessionState sessionState, GpsQuality gpsQuality, Distance distance, Float f, int r12, DefaultConstructorMarker defaultConstructorMarker) {
        this((r12 & 1) != 0 ? null : num, (r12 & 2) != 0 ? null : bool, (r12 & 4) != 0 ? SessionState.Off : sessionState, (r12 & 8) != 0 ? GpsQuality.None : gpsQuality, (r12 & 16) != 0 ? UnknownDistance.INSTANCE : distance, (r12 & 32) != 0 ? null : f);
    }
}
