package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.internal.zan;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy$$ExternalSyntheticLambda0;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy$$ExternalSyntheticLambda1;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class CrashlyticsCore {
    public final AnalyticsEventLogger analyticsEventLogger;
    public final CrashlyticsBackgroundWorker backgroundWorker;
    public final BreadcrumbSource breadcrumbSource;
    public final Context context;
    public CrashlyticsController controller;
    public final ExecutorService crashHandlerExecutor;
    public zan crashMarker;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final FileStore fileStore;
    public final IdManager idManager;
    public zan initializationMarker;
    public final CrashlyticsNativeComponent nativeComponent;
    public final OnDemandCounter onDemandCounter;
    public final long startTime;

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Callable<Task<Void>> {
        public final /* synthetic */ SettingsProvider val$settingsProvider;

        public AnonymousClass1(SettingsController settingsController) {
            r2 = settingsController;
        }

        @Override // java.util.concurrent.Callable
        public final Task<Void> call() throws Exception {
            return CrashlyticsCore.access$000(CrashlyticsCore.this, r2);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ SettingsProvider val$settingsProvider;

        public AnonymousClass2(SettingsController settingsController) {
            r2 = settingsController;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CrashlyticsCore.access$000(CrashlyticsCore.this, r2);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$3 */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements Callable<Boolean> {
        public AnonymousClass3() {
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() throws Exception {
            try {
                zan zanVar = CrashlyticsCore.this.initializationMarker;
                FileStore fileStore = (FileStore) zanVar.zab;
                String str = (String) zanVar.zaa;
                fileStore.getClass();
                boolean delete = new File(fileStore.crashlyticsDir, str).delete();
                if (!delete) {
                    Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
                }
                return Boolean.valueOf(delete);
            } catch (Exception e) {
                Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.FALSE;
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$4 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements Callable<Boolean> {
        public AnonymousClass4() {
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() throws Exception {
            boolean z;
            CrashlyticsController crashlyticsController = CrashlyticsCore.this.controller;
            zan zanVar = crashlyticsController.crashMarker;
            FileStore fileStore = (FileStore) zanVar.zab;
            String str = (String) zanVar.zaa;
            fileStore.getClass();
            if (!new File(fileStore.crashlyticsDir, str).exists()) {
                String currentSessionId = crashlyticsController.getCurrentSessionId();
                if (currentSessionId == null || !crashlyticsController.nativeComponent.hasCrashDataForSession(currentSessionId)) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Found previous crash marker.", null);
                }
                FileStore fileStore2 = (FileStore) zanVar.zab;
                String str2 = (String) zanVar.zaa;
                fileStore2.getClass();
                new File(fileStore2.crashlyticsDir, str2).delete();
            }
            z = true;
            return Boolean.valueOf(z);
        }
    }

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy, DataCollectionArbiter dataCollectionArbiter, AnalyticsDeferredProxy$$ExternalSyntheticLambda0 analyticsDeferredProxy$$ExternalSyntheticLambda0, AnalyticsDeferredProxy$$ExternalSyntheticLambda1 analyticsDeferredProxy$$ExternalSyntheticLambda1, FileStore fileStore, ExecutorService executorService) {
        this.dataCollectionArbiter = dataCollectionArbiter;
        firebaseApp.checkNotDeleted();
        this.context = firebaseApp.applicationContext;
        this.idManager = idManager;
        this.nativeComponent = crashlyticsNativeComponentDeferredProxy;
        this.breadcrumbSource = analyticsDeferredProxy$$ExternalSyntheticLambda0;
        this.analyticsEventLogger = analyticsDeferredProxy$$ExternalSyntheticLambda1;
        this.crashHandlerExecutor = executorService;
        this.fileStore = fileStore;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.startTime = System.currentTimeMillis();
        this.onDemandCounter = new OnDemandCounter();
    }

    public static Task access$000(final CrashlyticsCore crashlyticsCore, SettingsProvider settingsProvider) {
        Task forException;
        if (Boolean.TRUE.equals(crashlyticsCore.backgroundWorker.isExecutorThread.get())) {
            crashlyticsCore.initializationMarker.create();
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Initialization marker file was created.", null);
            }
            try {
                try {
                    crashlyticsCore.breadcrumbSource.registerBreadcrumbHandler(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda0
                        @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                        public final void handleBreadcrumb(String str) {
                            CrashlyticsCore crashlyticsCore2 = CrashlyticsCore.this;
                            crashlyticsCore2.getClass();
                            long currentTimeMillis = System.currentTimeMillis() - crashlyticsCore2.startTime;
                            CrashlyticsController crashlyticsController = crashlyticsCore2.controller;
                            crashlyticsController.getClass();
                            crashlyticsController.backgroundWorker.submit(new CrashlyticsController.AnonymousClass5(currentTimeMillis, str));
                        }
                    });
                    SettingsController settingsController = (SettingsController) settingsProvider;
                    if (!settingsController.getSettingsSync().featureFlagData.collectReports) {
                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                            Log.d("FirebaseCrashlytics", "Collection of crash reports disabled in Crashlytics settings.", null);
                        }
                        forException = Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                    } else {
                        if (!crashlyticsCore.controller.finalizeSessions(settingsController)) {
                            Log.w("FirebaseCrashlytics", "Previous sessions could not be finalized.", null);
                        }
                        forException = crashlyticsCore.controller.submitAllReports(settingsController.settingsTask.get().zza);
                    }
                } catch (Exception e) {
                    Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                    forException = Tasks.forException(e);
                }
                return forException;
            } finally {
                crashlyticsCore.markInitializationComplete();
            }
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }

    public final void finishInitSynchronously(SettingsController settingsController) {
        Future<?> submit = this.crashHandlerExecutor.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.2
            public final /* synthetic */ SettingsProvider val$settingsProvider;

            public AnonymousClass2(SettingsController settingsController2) {
                r2 = settingsController2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore.access$000(CrashlyticsCore.this, r2);
            }
        });
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        }
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during initialization.", e2);
        } catch (TimeoutException e3) {
            Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e3);
        }
    }

    public final void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.3
            public AnonymousClass3() {
            }

            @Override // java.util.concurrent.Callable
            public final Boolean call() throws Exception {
                try {
                    zan zanVar = CrashlyticsCore.this.initializationMarker;
                    FileStore fileStore = (FileStore) zanVar.zab;
                    String str = (String) zanVar.zaa;
                    fileStore.getClass();
                    boolean delete = new File(fileStore.crashlyticsDir, str).delete();
                    if (!delete) {
                        Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
                    }
                    return Boolean.valueOf(delete);
                } catch (Exception e) {
                    Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return Boolean.FALSE;
                }
            }
        });
    }
}
