package com.google.firebase.crashlytics.internal.common;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

@AutoValue
/* loaded from: classes3.dex */
public abstract class CrashlyticsReportWithSessionId {
    public abstract CrashlyticsReport getReport();

    public abstract File getReportFile();

    public abstract String getSessionId();
}
