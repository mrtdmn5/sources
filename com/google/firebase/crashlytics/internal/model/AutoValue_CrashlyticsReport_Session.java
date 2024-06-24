package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: app, reason: collision with root package name */
    public final CrashlyticsReport.Session.Application f138app;
    public final boolean crashed;
    public final CrashlyticsReport.Session.Device device;
    public final Long endedAt;
    public final ImmutableList<CrashlyticsReport.Session.Event> events;
    public final String generator;
    public final int generatorType;
    public final String identifier;
    public final CrashlyticsReport.Session.OperatingSystem os;
    public final long startedAt;
    public final CrashlyticsReport.Session.User user;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: app, reason: collision with root package name */
        public CrashlyticsReport.Session.Application f139app;
        public Boolean crashed;
        public CrashlyticsReport.Session.Device device;
        public Long endedAt;
        public ImmutableList<CrashlyticsReport.Session.Event> events;
        public String generator;
        public Integer generatorType;
        public String identifier;
        public CrashlyticsReport.Session.OperatingSystem os;
        public Long startedAt;
        public CrashlyticsReport.Session.User user;

        public Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.f139app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }

        public final AutoValue_CrashlyticsReport_Session build() {
            String str;
            if (this.generator == null) {
                str = " generator";
            } else {
                str = "";
            }
            if (this.identifier == null) {
                str = str.concat(" identifier");
            }
            if (this.startedAt == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " startedAt");
            }
            if (this.crashed == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " crashed");
            }
            if (this.f139app == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " app");
            }
            if (this.generatorType == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " generatorType");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.f139app, this.user, this.os, this.device, this.events, this.generatorType.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_Session(String str, String str2, long j, Long l, boolean z, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, ImmutableList immutableList, int r12) {
        this.generator = str;
        this.identifier = str2;
        this.startedAt = j;
        this.endedAt = l;
        this.crashed = z;
        this.f138app = application;
        this.user = user;
        this.os = operatingSystem;
        this.device = device;
        this.events = immutableList;
        this.generatorType = r12;
    }

    public final boolean equals(Object obj) {
        Long l;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (this.generator.equals(session.getGenerator()) && this.identifier.equals(session.getIdentifier()) && this.startedAt == session.getStartedAt() && ((l = this.endedAt) != null ? l.equals(session.getEndedAt()) : session.getEndedAt() == null) && this.crashed == session.isCrashed() && this.f138app.equals(session.getApp()) && ((user = this.user) != null ? user.equals(session.getUser()) : session.getUser() == null) && ((operatingSystem = this.os) != null ? operatingSystem.equals(session.getOs()) : session.getOs() == null) && ((device = this.device) != null ? device.equals(session.getDevice()) : session.getDevice() == null) && ((immutableList = this.events) != null ? immutableList.equals(session.getEvents()) : session.getEvents() == null) && this.generatorType == session.getGeneratorType()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.Application getApp() {
        return this.f138app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final Long getEndedAt() {
        return this.endedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final String getGenerator() {
        return this.generator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final int getGeneratorType() {
        return this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final long getStartedAt() {
        return this.startedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public final int hashCode() {
        int hashCode;
        int r3;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = (((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003;
        long j = this.startedAt;
        int r0 = (hashCode5 ^ ((int) ((j >>> 32) ^ j))) * 1000003;
        int r2 = 0;
        Long l = this.endedAt;
        if (l == null) {
            hashCode = 0;
        } else {
            hashCode = l.hashCode();
        }
        int r02 = (r0 ^ hashCode) * 1000003;
        if (this.crashed) {
            r3 = 1231;
        } else {
            r3 = 1237;
        }
        int hashCode6 = (((r02 ^ r3) * 1000003) ^ this.f138app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.user;
        if (user == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = user.hashCode();
        }
        int r03 = (hashCode6 ^ hashCode2) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        if (operatingSystem == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = operatingSystem.hashCode();
        }
        int r04 = (r03 ^ hashCode3) * 1000003;
        CrashlyticsReport.Session.Device device = this.device;
        if (device == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = device.hashCode();
        }
        int r05 = (r04 ^ hashCode4) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.events;
        if (immutableList != null) {
            r2 = immutableList.hashCode();
        }
        return ((r05 ^ r2) * 1000003) ^ this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final boolean isCrashed() {
        return this.crashed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public final Builder toBuilder() {
        return new Builder(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Session{generator=");
        sb.append(this.generator);
        sb.append(", identifier=");
        sb.append(this.identifier);
        sb.append(", startedAt=");
        sb.append(this.startedAt);
        sb.append(", endedAt=");
        sb.append(this.endedAt);
        sb.append(", crashed=");
        sb.append(this.crashed);
        sb.append(", app=");
        sb.append(this.f138app);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", os=");
        sb.append(this.os);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", events=");
        sb.append(this.events);
        sb.append(", generatorType=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.generatorType, "}");
    }
}
