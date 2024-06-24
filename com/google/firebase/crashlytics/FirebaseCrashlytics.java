package com.google.firebase.crashlytics;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.metadata.KeysMap;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class FirebaseCrashlytics {
    public final CrashlyticsCore core;

    /* renamed from: com.google.firebase.crashlytics.FirebaseCrashlytics$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Continuation<Void, Object> {
        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task<Void> task) throws Exception {
            if (!task.isSuccessful()) {
                Log.e("FirebaseCrashlytics", "Error fetching settings.", task.getException());
                return null;
            }
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.FirebaseCrashlytics$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 implements Callable<Void> {
        public final /* synthetic */ CrashlyticsCore val$core;
        public final /* synthetic */ boolean val$finishCoreInBackground;
        public final /* synthetic */ SettingsController val$settingsController;

        public AnonymousClass2(boolean z, CrashlyticsCore crashlyticsCore, SettingsController settingsController) {
            r1 = z;
            r2 = crashlyticsCore;
            r3 = settingsController;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.firebase.crashlytics.internal.common.Utils.1.<init>(com.google.firebase.crashlytics.internal.common.CrashlyticsCore$1, com.google.android.gms.tasks.TaskCompletionSource):void, class status: NOT_LOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        @Override // java.util.concurrent.Callable
        public final java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                boolean r0 = r1
                if (r0 == 0) goto L21
                com.google.firebase.crashlytics.internal.common.CrashlyticsCore r0 = r2
                r0.getClass()
                com.google.firebase.crashlytics.internal.common.CrashlyticsCore$1 r1 = new com.google.firebase.crashlytics.internal.common.CrashlyticsCore$1
                com.google.firebase.crashlytics.internal.settings.SettingsController r2 = r3
                r1.<init>()
                java.util.concurrent.ExecutorService r2 = com.google.firebase.crashlytics.internal.common.Utils.TASK_CONTINUATION_EXECUTOR_SERVICE
                com.google.android.gms.tasks.TaskCompletionSource r2 = new com.google.android.gms.tasks.TaskCompletionSource
                r2.<init>()
                com.google.firebase.crashlytics.internal.common.Utils$1 r3 = new com.google.firebase.crashlytics.internal.common.Utils$1
                r3.<init>()
                java.util.concurrent.ExecutorService r0 = r0.crashHandlerExecutor
                r0.execute(r3)
            L21:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.FirebaseCrashlytics.AnonymousClass2.call():java.lang.Object");
        }
    }

    public FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.2.<init>(com.google.firebase.crashlytics.internal.common.CrashlyticsController$6):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.firebase.crashlytics.internal.common.CrashlyticsController$6] */
    public final void recordException(final java.lang.Throwable r9) {
        /*
            r8 = this;
            if (r9 != 0) goto Lb
            java.lang.String r9 = "A null value was passed to recordException. Ignoring."
            r0 = 0
            java.lang.String r1 = "FirebaseCrashlytics"
            android.util.Log.w(r1, r9, r0)
            return
        Lb:
            com.google.firebase.crashlytics.internal.common.CrashlyticsCore r0 = r8.core
            com.google.firebase.crashlytics.internal.common.CrashlyticsController r0 = r0.controller
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r0.getClass()
            long r3 = java.lang.System.currentTimeMillis()
            com.google.firebase.crashlytics.internal.common.CrashlyticsController$6 r7 = new com.google.firebase.crashlytics.internal.common.CrashlyticsController$6
            r1 = r7
            r2 = r0
            r5 = r9
            r1.<init>()
            com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker r9 = r0.backgroundWorker
            r9.getClass()
            com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$2 r0 = new com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$2
            r0.<init>()
            r9.submit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.FirebaseCrashlytics.recordException(java.lang.Throwable):void");
    }

    public final void setUserId(String str) {
        boolean equals;
        final UserMetadata userMetadata = this.core.controller.userMetadata;
        userMetadata.getClass();
        String sanitizeString = KeysMap.sanitizeString(1024, str);
        synchronized (userMetadata.userId) {
            String reference = userMetadata.userId.getReference();
            if (sanitizeString == null) {
                if (reference == null) {
                    equals = true;
                } else {
                    equals = false;
                }
            } else {
                equals = sanitizeString.equals(reference);
            }
            if (!equals) {
                userMetadata.userId.set(sanitizeString, true);
                userMetadata.backgroundWorker.submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.metadata.UserMetadata$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        BufferedWriter bufferedWriter;
                        boolean z;
                        String str2;
                        BufferedWriter bufferedWriter2;
                        String obj;
                        UserMetadata userMetadata2 = UserMetadata.this;
                        synchronized (userMetadata2.userId) {
                            bufferedWriter = null;
                            z = false;
                            if (userMetadata2.userId.isMarked()) {
                                str2 = userMetadata2.userId.getReference();
                                userMetadata2.userId.set(str2, false);
                                z = true;
                            } else {
                                str2 = null;
                            }
                        }
                        if (z) {
                            File sessionFile = userMetadata2.metaDataStore.fileStore.getSessionFile(userMetadata2.sessionIdentifier, "user-data");
                            try {
                                obj = new JSONObject(str2) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1
                                    public AnonymousClass1(String str22) throws JSONException {
                                        put("userId", str22);
                                    }
                                }.toString();
                                bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sessionFile), MetaDataStore.UTF_8));
                            } catch (Exception e) {
                                e = e;
                                bufferedWriter2 = null;
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter2 = bufferedWriter;
                                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                                throw th;
                            }
                            try {
                                bufferedWriter2.write(obj);
                                bufferedWriter2.flush();
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    Log.w("FirebaseCrashlytics", "Error serializing user metadata.", e);
                                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedWriter = bufferedWriter2;
                                    bufferedWriter2 = bufferedWriter;
                                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                                throw th;
                            }
                            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                        }
                        return null;
                    }
                });
            }
        }
    }
}
