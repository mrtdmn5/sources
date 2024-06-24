package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {
    public final String content;

    public AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.content = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.content.equals(((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    public final String getContent() {
        return this.content;
    }

    public final int hashCode() {
        return this.content.hashCode() ^ 1000003;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Log{content="), this.content, "}");
    }
}
