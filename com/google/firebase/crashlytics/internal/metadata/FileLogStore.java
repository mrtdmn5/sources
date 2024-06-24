package com.google.firebase.crashlytics.internal.metadata;

/* loaded from: classes3.dex */
public interface FileLogStore {
    void closeLogFile();

    String getLogAsString();

    void writeToLog(long j, String str);
}
