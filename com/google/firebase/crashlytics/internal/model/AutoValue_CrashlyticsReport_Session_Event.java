package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: app, reason: collision with root package name */
    public final CrashlyticsReport.Session.Event.Application f140app;
    public final CrashlyticsReport.Session.Event.Device device;
    public final CrashlyticsReport.Session.Event.Log log;
    public final long timestamp;
    public final String type;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: app, reason: collision with root package name */
        public CrashlyticsReport.Session.Event.Application f141app;
        public CrashlyticsReport.Session.Event.Device device;
        public CrashlyticsReport.Session.Event.Log log;
        public Long timestamp;
        public String type;

        public Builder(CrashlyticsReport.Session.Event event) {
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.f141app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }

        public final AutoValue_CrashlyticsReport_Session_Event build() {
            String str;
            if (this.timestamp == null) {
                str = " timestamp";
            } else {
                str = "";
            }
            if (this.type == null) {
                str = str.concat(" type");
            }
            if (this.f141app == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " app");
            }
            if (this.device == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " device");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.f141app, this.device, this.log);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, CrashlyticsReport.Session.Event.Log log) {
        this.timestamp = j;
        this.type = str;
        this.f140app = application;
        this.device = device;
        this.log = log;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.timestamp == event.getTimestamp() && this.type.equals(event.getType()) && this.f140app.equals(event.getApp()) && this.device.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log = this.log;
            if (log == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Application getApp() {
        return this.f140app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        int hashCode;
        long j = this.timestamp;
        int hashCode2 = (((((((((int) ((j >>> 32) ^ j)) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.f140app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.log;
        if (log == null) {
            hashCode = 0;
        } else {
            hashCode = log.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        return "Event{timestamp=" + this.timestamp + ", type=" + this.type + ", app=" + this.f140app + ", device=" + this.device + ", log=" + this.log + "}";
    }
}
