package com.google.firebase.crashlytics.internal.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

@AutoValue
/* loaded from: classes3.dex */
public abstract class StaticSessionData {

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class AppData {
        public abstract String appIdentifier();

        public abstract int deliveryMechanism();

        public abstract DevelopmentPlatformProvider developmentPlatformProvider();

        public abstract String installUuid();

        public abstract String versionCode();

        public abstract String versionName();
    }

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class DeviceData {
        public abstract int arch();

        public abstract int availableProcessors();

        public abstract long diskSpace();

        public abstract boolean isEmulator();

        public abstract String manufacturer();

        public abstract String model();

        public abstract String modelClass();

        public abstract int state();

        public abstract long totalRam();
    }

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class OsData {
        public abstract boolean isRooted();

        public abstract String osCodeName();

        public abstract String osRelease();
    }

    public abstract AppData appData();

    public abstract DeviceData deviceData();

    public abstract OsData osData();
}
