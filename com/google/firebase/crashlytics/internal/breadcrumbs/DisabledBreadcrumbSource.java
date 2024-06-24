package com.google.firebase.crashlytics.internal.breadcrumbs;

import android.util.Log;

/* loaded from: classes3.dex */
public final class DisabledBreadcrumbSource implements BreadcrumbSource {
    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        boolean z;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.d("FirebaseCrashlytics", "Could not register handler for breadcrumbs events.", null);
        }
    }
}
