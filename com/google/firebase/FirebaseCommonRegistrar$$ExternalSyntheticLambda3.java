package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar$$ExternalSyntheticLambda3 implements LibraryVersionComponent.VersionExtractor {
    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName != null) {
            return FirebaseCommonRegistrar.safeValue(installerPackageName);
        }
        return "";
    }
}
