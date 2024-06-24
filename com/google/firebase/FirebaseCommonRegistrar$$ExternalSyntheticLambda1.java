package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar$$ExternalSyntheticLambda1 implements LibraryVersionComponent.VersionExtractor {
    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return String.valueOf(applicationInfo.minSdkVersion);
        }
        return "";
    }
}
