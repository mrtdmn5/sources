package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes3.dex */
public final class BuildIdInfo {
    public final String arch;
    public final String buildId;
    public final String libraryName;

    public BuildIdInfo(String str, String str2, String str3) {
        this.libraryName = str;
        this.arch = str2;
        this.buildId = str3;
    }
}
