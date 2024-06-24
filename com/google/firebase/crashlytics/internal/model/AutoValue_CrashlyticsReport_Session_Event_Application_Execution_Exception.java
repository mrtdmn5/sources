package com.google.firebase.crashlytics.internal.model;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    public final int overflowCount;
    public final String reason;
    public final String type;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int r5) {
        this.type = str;
        this.reason = str2;
        this.frames = immutableList;
        this.causedBy = exception;
        this.overflowCount = r5;
    }

    public final boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (this.type.equals(exception2.getType()) && ((str = this.reason) != null ? str.equals(exception2.getReason()) : exception2.getReason() == null) && this.frames.equals(exception2.getFrames()) && ((exception = this.causedBy) != null ? exception.equals(exception2.getCausedBy()) : exception2.getCausedBy() == null) && this.overflowCount == exception2.getOverflowCount()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy() {
        return this.causedBy;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.frames;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final int getOverflowCount() {
        return this.overflowCount;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final String getReason() {
        return this.reason;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.type.hashCode() ^ 1000003) * 1000003;
        int r2 = 0;
        String str = this.reason;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((hashCode2 ^ hashCode) * 1000003) ^ this.frames.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.causedBy;
        if (exception != null) {
            r2 = exception.hashCode();
        }
        return ((hashCode3 ^ r2) * 1000003) ^ this.overflowCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Exception{type=");
        sb.append(this.type);
        sb.append(", reason=");
        sb.append(this.reason);
        sb.append(", frames=");
        sb.append(this.frames);
        sb.append(", causedBy=");
        sb.append(this.causedBy);
        sb.append(", overflowCount=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.overflowCount, "}");
    }
}
