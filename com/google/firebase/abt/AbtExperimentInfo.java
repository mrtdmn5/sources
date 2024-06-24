package com.google.firebase.abt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class AbtExperimentInfo {
    public static final String[] ALL_REQUIRED_KEYS = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
    public static final SimpleDateFormat protoTimestampStringParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    public final String experimentId;
    public final Date experimentStartTime;
    public final long timeToLiveInMillis;
    public final String triggerEventName;
    public final long triggerTimeoutInMillis;
    public final String variantId;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j, long j2) {
        this.experimentId = str;
        this.variantId = str2;
        this.triggerEventName = str3;
        this.experimentStartTime = date;
        this.triggerTimeoutInMillis = j;
        this.timeToLiveInMillis = j2;
    }
}
