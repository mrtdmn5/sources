package com.google.firebase.messaging;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda2(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            int r0 = r7.$r8$classId
            java.lang.Object r1 = r7.f$0
            switch(r0) {
                case 0: goto L8;
                default: goto L7;
            }
        L7:
            goto L6a
        L8:
            com.google.firebase.messaging.FirebaseMessaging r1 = (com.google.firebase.messaging.FirebaseMessaging) r1
            android.content.Context r0 = r1.context
            android.content.Context r1 = r0.getApplicationContext()
            if (r1 != 0) goto L13
            r1 = r0
        L13:
            java.lang.String r2 = "com.google.firebase.messaging"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            java.lang.String r2 = "proxy_notification_initialized"
            boolean r1 = r1.getBoolean(r2, r3)
            if (r1 == 0) goto L23
            goto L69
        L23:
            java.lang.String r1 = "firebase_messaging_notification_delegation_enabled"
            r2 = 1
            android.content.Context r4 = r0.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            if (r5 == 0) goto L4d
            java.lang.String r4 = r4.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            r6 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r4 = r5.getApplicationInfo(r4, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            if (r4 == 0) goto L4d
            android.os.Bundle r5 = r4.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            if (r5 == 0) goto L4d
            boolean r5 = r5.containsKey(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            if (r5 == 0) goto L4d
            android.os.Bundle r4 = r4.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            boolean r1 = r4.getBoolean(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4d
            goto L4e
        L4d:
            r1 = r2
        L4e:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r4 < r5) goto L55
            r3 = r2
        L55:
            if (r3 != 0) goto L5c
            r0 = 0
            com.google.android.gms.tasks.Tasks.forResult(r0)
            goto L69
        L5c:
            com.google.android.gms.tasks.TaskCompletionSource r2 = new com.google.android.gms.tasks.TaskCompletionSource
            r2.<init>()
            com.google.firebase.messaging.ProxyNotificationInitializer$$ExternalSyntheticLambda3 r3 = new com.google.firebase.messaging.ProxyNotificationInitializer$$ExternalSyntheticLambda3
            r3.<init>()
            r3.run()
        L69:
            return
        L6a:
            com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment r1 = (com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment) r1
            com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment.$r8$lambda$ZUm3C6FgXOJQQnlLgTv0p7lAqfI(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda2.run():void");
    }
}
