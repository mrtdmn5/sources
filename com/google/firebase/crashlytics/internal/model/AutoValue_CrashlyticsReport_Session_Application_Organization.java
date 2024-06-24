package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Application_Organization extends CrashlyticsReport.Session.Application.Organization {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application.Organization)) {
            return false;
        }
        ((CrashlyticsReport.Session.Application.Organization) obj).getClsId();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Organization{clsId=null}";
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization
    public final void getClsId() {
    }
}
