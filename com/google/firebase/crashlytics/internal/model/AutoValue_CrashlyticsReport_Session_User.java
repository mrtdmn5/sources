package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {
    public final String identifier;

    public AutoValue_CrashlyticsReport_Session_User(String str) {
        this.identifier = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.identifier.equals(((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    public final String getIdentifier() {
        return this.identifier;
    }

    public final int hashCode() {
        return this.identifier.hashCode() ^ 1000003;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("User{identifier="), this.identifier, "}");
    }
}
