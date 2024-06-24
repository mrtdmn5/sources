package com.google.firebase.crashlytics.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public final class DevelopmentPlatformProvider {
    public final Context context;
    public DevelopmentPlatform developmentPlatform = null;

    /* loaded from: classes3.dex */
    public class DevelopmentPlatform {
        public final String developmentPlatform;
        public final String developmentPlatformVersion;

        /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DevelopmentPlatform(com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider r6) {
            /*
                r5 = this;
                r5.<init>()
                android.content.Context r0 = r6.context
                java.lang.String r1 = "com.google.firebase.crashlytics.unity_version"
                java.lang.String r2 = "string"
                int r0 = com.google.firebase.crashlytics.internal.common.CommonUtils.getResourcesIdentifier(r0, r1, r2)
                r1 = 2
                java.lang.String r2 = "FirebaseCrashlytics"
                r3 = 0
                android.content.Context r6 = r6.context
                if (r0 == 0) goto L33
                java.lang.String r4 = "Unity"
                r5.developmentPlatform = r4
                android.content.res.Resources r6 = r6.getResources()
                java.lang.String r6 = r6.getString(r0)
                r5.developmentPlatformVersion = r6
                java.lang.String r0 = "Unity Editor version is: "
                java.lang.String r6 = androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0.m(r0, r6)
                boolean r0 = android.util.Log.isLoggable(r2, r1)
                if (r0 == 0) goto L64
                android.util.Log.v(r2, r6, r3)
                goto L64
            L33:
                java.lang.String r0 = "flutter_assets/NOTICES.Z"
                android.content.res.AssetManager r4 = r6.getAssets()
                if (r4 != 0) goto L3c
                goto L4b
            L3c:
                android.content.res.AssetManager r6 = r6.getAssets()     // Catch: java.io.IOException -> L4b
                java.io.InputStream r6 = r6.open(r0)     // Catch: java.io.IOException -> L4b
                if (r6 == 0) goto L49
                r6.close()     // Catch: java.io.IOException -> L4b
            L49:
                r6 = 1
                goto L4c
            L4b:
                r6 = 0
            L4c:
                if (r6 == 0) goto L60
                java.lang.String r6 = "Flutter"
                r5.developmentPlatform = r6
                r5.developmentPlatformVersion = r3
                boolean r6 = android.util.Log.isLoggable(r2, r1)
                if (r6 == 0) goto L64
                java.lang.String r6 = "Development platform is: Flutter"
                android.util.Log.v(r2, r6, r3)
                goto L64
            L60:
                r5.developmentPlatform = r3
                r5.developmentPlatformVersion = r3
            L64:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.DevelopmentPlatform.<init>(com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider):void");
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.context = context;
    }
}
