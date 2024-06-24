package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {
    public final CrashlyticsReport.ApplicationExitInfo appExitInfo;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
    public final CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ImmutableList immutableList2) {
        this.threads = immutableList;
        this.exception = exception;
        this.appExitInfo = applicationExitInfo;
        this.signal = signal;
        this.binaries = immutableList2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.threads;
        if (immutableList != null ? immutableList.equals(execution.getThreads()) : execution.getThreads() == null) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.exception;
            if (exception != null ? exception.equals(execution.getException()) : execution.getException() == null) {
                CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.appExitInfo;
                if (applicationExitInfo != null ? applicationExitInfo.equals(execution.getAppExitInfo()) : execution.getAppExitInfo() == null) {
                    if (this.signal.equals(execution.getSignal()) && this.binaries.equals(execution.getBinaries())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.appExitInfo;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.binaries;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.exception;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.signal;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.threads;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int r0 = 0;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.threads;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int r1 = (hashCode ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.exception;
        if (exception == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = exception.hashCode();
        }
        int r12 = (r1 ^ hashCode2) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.appExitInfo;
        if (applicationExitInfo != null) {
            r0 = applicationExitInfo.hashCode();
        }
        return ((((r0 ^ r12) * 1000003) ^ this.signal.hashCode()) * 1000003) ^ this.binaries.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.threads + ", exception=" + this.exception + ", appExitInfo=" + this.appExitInfo + ", signal=" + this.signal + ", binaries=" + this.binaries + "}";
    }
}
