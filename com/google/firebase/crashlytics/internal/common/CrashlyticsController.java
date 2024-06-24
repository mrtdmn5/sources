package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.device.Command;
import com.google.android.gms.common.api.internal.zan;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_StaticSessionData;
import com.google.firebase.crashlytics.internal.model.AutoValue_StaticSessionData_AppData;
import com.google.firebase.crashlytics.internal.model.AutoValue_StaticSessionData_DeviceData;
import com.google.firebase.crashlytics.internal.model.AutoValue_StaticSessionData_OsData;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import io.ktor.http.UrlKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class CrashlyticsController {
    public static final CrashlyticsController$$ExternalSyntheticLambda0 APP_EXCEPTION_MARKER_FILTER = new CrashlyticsController$$ExternalSyntheticLambda0();
    public final AnalyticsEventLogger analyticsEventLogger;
    public final AppData appData;
    public final CrashlyticsBackgroundWorker backgroundWorker;
    public final Context context;
    public CrashlyticsUncaughtExceptionHandler crashHandler;
    public final zan crashMarker;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final FileStore fileStore;
    public final IdManager idManager;
    public final LogFileManager logFileManager;
    public final CrashlyticsNativeComponent nativeComponent;
    public final SessionReportingCoordinator reportingCoordinator;
    public final UserMetadata userMetadata;
    public final TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource<>();
    public final TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource<>();
    public final TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource<>();

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements CrashlyticsUncaughtExceptionHandler.CrashListener {
        public AnonymousClass1() {
        }

        public final void onUncaughtException(final SettingsProvider settingsProvider, final Thread thread, final Throwable th) {
            Task<TContinuationResult> continueWithTask;
            final CrashlyticsController crashlyticsController = CrashlyticsController.this;
            synchronized (crashlyticsController) {
                String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str, null);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = crashlyticsController.backgroundWorker;
                Callable<Task<Void>> callable = new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                    public final /* synthetic */ boolean val$isOnDemand = false;

                    @Override // java.util.concurrent.Callable
                    public final Task<Void> call() throws Exception {
                        FileStore fileStore;
                        String str2;
                        long j = currentTimeMillis;
                        long j2 = j / 1000;
                        CrashlyticsController crashlyticsController2 = CrashlyticsController.this;
                        final String currentSessionId = crashlyticsController2.getCurrentSessionId();
                        if (currentSessionId == null) {
                            Log.e("FirebaseCrashlytics", "Tried to write a fatal exception while no session was open.", null);
                            return Tasks.forResult(null);
                        }
                        crashlyticsController2.crashMarker.create();
                        Throwable th2 = th;
                        Thread thread2 = thread;
                        SessionReportingCoordinator sessionReportingCoordinator = crashlyticsController2.reportingCoordinator;
                        sessionReportingCoordinator.getClass();
                        String concat = "Persisting fatal event for session ".concat(currentSessionId);
                        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                            Log.v("FirebaseCrashlytics", concat, null);
                        }
                        sessionReportingCoordinator.persistEvent(th2, thread2, currentSessionId, Command.CRASH, j2, true);
                        try {
                            fileStore = crashlyticsController2.fileStore;
                            str2 = ".ae" + j;
                            fileStore.getClass();
                        } catch (IOException e) {
                            Log.w("FirebaseCrashlytics", "Could not create app exception marker file.", e);
                        }
                        if (!new File(fileStore.crashlyticsDir, str2).createNewFile()) {
                            throw new IOException("Create new file failed.");
                        }
                        SettingsProvider settingsProvider2 = settingsProvider;
                        crashlyticsController2.doCloseSessions(false, settingsProvider2);
                        new CLSUUID(crashlyticsController2.idManager);
                        CrashlyticsController.access$600(crashlyticsController2, CLSUUID._clsId);
                        if (!crashlyticsController2.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                            return Tasks.forResult(null);
                        }
                        final Executor executor = crashlyticsController2.backgroundWorker.executor;
                        return ((SettingsController) settingsProvider2).settingsTask.get().zza.onSuccessTask(executor, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                            @Override // com.google.android.gms.tasks.SuccessContinuation
                            public final Task<Void> then(Settings settings) throws Exception {
                                String str3 = null;
                                if (settings == null) {
                                    Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
                                    return Tasks.forResult(null);
                                }
                                Task[] taskArr = new Task[2];
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                taskArr[0] = CrashlyticsController.access$900(CrashlyticsController.this);
                                SessionReportingCoordinator sessionReportingCoordinator2 = CrashlyticsController.this.reportingCoordinator;
                                if (anonymousClass2.val$isOnDemand) {
                                    str3 = currentSessionId;
                                }
                                taskArr[1] = sessionReportingCoordinator2.sendReports(str3, executor);
                                return Tasks.whenAll(Arrays.asList(taskArr));
                            }
                        });
                    }
                };
                synchronized (crashlyticsBackgroundWorker.tailLock) {
                    continueWithTask = crashlyticsBackgroundWorker.tail.continueWithTask(crashlyticsBackgroundWorker.executor, new CrashlyticsBackgroundWorker.AnonymousClass3(callable));
                    crashlyticsBackgroundWorker.tail = continueWithTask.continueWith(crashlyticsBackgroundWorker.executor, new CrashlyticsBackgroundWorker.AnonymousClass4());
                }
                try {
                    Utils.awaitEvenIfOnMainThread(continueWithTask);
                } catch (TimeoutException unused) {
                    Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
                } catch (Exception e) {
                    Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e);
                }
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 implements SuccessContinuation<Void, Boolean> {
        @Override // com.google.android.gms.tasks.SuccessContinuation
        public final Task<Boolean> then(Void r1) throws Exception {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements SuccessContinuation<Boolean, Void> {
        public final /* synthetic */ Task val$settingsDataTask;

        public AnonymousClass4(zzw zzwVar) {
            this.val$settingsDataTask = zzwVar;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public final Task<Void> then(Boolean bool) throws Exception {
            Task continueWithTask;
            final Boolean bool2 = bool;
            CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = CrashlyticsController.this.backgroundWorker;
            Callable<Task<Void>> callable = new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                @Override // java.util.concurrent.Callable
                public final Task<Void> call() throws Exception {
                    Boolean bool3 = bool2;
                    boolean booleanValue = bool3.booleanValue();
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    if (!booleanValue) {
                        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
                        }
                        CrashlyticsController crashlyticsController = CrashlyticsController.this;
                        Iterator it = FileStore.safeArrayToList(crashlyticsController.fileStore.crashlyticsDir.listFiles(CrashlyticsController.APP_EXCEPTION_MARKER_FILTER)).iterator();
                        while (it.hasNext()) {
                            ((File) it.next()).delete();
                        }
                        CrashlyticsController crashlyticsController2 = CrashlyticsController.this;
                        FileStore fileStore = crashlyticsController2.reportingCoordinator.reportPersistence.fileStore;
                        CrashlyticsReportPersistence.deleteFiles(FileStore.safeArrayToList(fileStore.reportsDir.listFiles()));
                        CrashlyticsReportPersistence.deleteFiles(FileStore.safeArrayToList(fileStore.priorityReportsDir.listFiles()));
                        CrashlyticsReportPersistence.deleteFiles(FileStore.safeArrayToList(fileStore.nativeReportsDir.listFiles()));
                        crashlyticsController2.unsentReportsHandled.trySetResult(null);
                        return Tasks.forResult(null);
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
                    }
                    boolean booleanValue2 = bool3.booleanValue();
                    DataCollectionArbiter dataCollectionArbiter = CrashlyticsController.this.dataCollectionArbiter;
                    if (booleanValue2) {
                        dataCollectionArbiter.dataCollectionExplicitlyApproved.trySetResult(null);
                        final Executor executor = CrashlyticsController.this.backgroundWorker.executor;
                        return anonymousClass4.val$settingsDataTask.onSuccessTask(executor, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1.1
                            @Override // com.google.android.gms.tasks.SuccessContinuation
                            public final Task<Void> then(Settings settings) throws Exception {
                                if (settings == null) {
                                    Log.w("FirebaseCrashlytics", "Received null app settings at app startup. Cannot send cached reports", null);
                                    return Tasks.forResult(null);
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                CrashlyticsController.access$900(CrashlyticsController.this);
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                CrashlyticsController.this.reportingCoordinator.sendReports(null, executor);
                                CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                        });
                    }
                    dataCollectionArbiter.getClass();
                    throw new IllegalStateException("An invalid data collection token was used.");
                }
            };
            synchronized (crashlyticsBackgroundWorker.tailLock) {
                continueWithTask = crashlyticsBackgroundWorker.tail.continueWithTask(crashlyticsBackgroundWorker.executor, new CrashlyticsBackgroundWorker.AnonymousClass3(callable));
                crashlyticsBackgroundWorker.tail = continueWithTask.continueWith(crashlyticsBackgroundWorker.executor, new CrashlyticsBackgroundWorker.AnonymousClass4());
            }
            return continueWithTask;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 implements Callable<Void> {
        public final /* synthetic */ String val$msg;
        public final /* synthetic */ long val$timestamp;

        public AnonymousClass5(long j, String str) {
            this.val$timestamp = j;
            this.val$msg = str;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            boolean z;
            CrashlyticsController crashlyticsController = CrashlyticsController.this;
            CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = crashlyticsController.crashHandler;
            if (crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException.get()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                crashlyticsController.logFileManager.currentLog.writeToLog(this.val$timestamp, this.val$msg);
                return null;
            }
            return null;
        }
    }

    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, zan zanVar, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger) {
        new AtomicBoolean(false);
        this.context = context;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.fileStore = fileStore;
        this.crashMarker = zanVar;
        this.appData = appData;
        this.userMetadata = userMetadata;
        this.logFileManager = logFileManager;
        this.nativeComponent = crashlyticsNativeComponent;
        this.analyticsEventLogger = analyticsEventLogger;
        this.reportingCoordinator = sessionReportingCoordinator;
    }

    public static void access$600(CrashlyticsController crashlyticsController, String str) {
        int r4;
        Integer num;
        crashlyticsController.getClass();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("Opening a new session with ID ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", m, null);
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "Crashlytics Android SDK/%s", "18.3.5");
        IdManager idManager = crashlyticsController.idManager;
        String str2 = idManager.appIdentifier;
        AppData appData = crashlyticsController.appData;
        AutoValue_StaticSessionData_AppData autoValue_StaticSessionData_AppData = new AutoValue_StaticSessionData_AppData(str2, appData.versionCode, appData.versionName, idManager.getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(appData.installerPackageName).getId(), appData.developmentPlatformProvider);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.VERSION.CODENAME;
        AutoValue_StaticSessionData_OsData autoValue_StaticSessionData_OsData = new AutoValue_StaticSessionData_OsData(str3, str4, CommonUtils.isRooted());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int ordinal = CommonUtils.Architecture.getValue().ordinal();
        String str5 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        boolean isEmulator = CommonUtils.isEmulator();
        int deviceState = CommonUtils.getDeviceState();
        String str6 = Build.MANUFACTURER;
        String str7 = Build.PRODUCT;
        crashlyticsController.nativeComponent.prepareNativeSession(str, format, currentTimeMillis, new AutoValue_StaticSessionData(autoValue_StaticSessionData_AppData, autoValue_StaticSessionData_OsData, new AutoValue_StaticSessionData_DeviceData(ordinal, str5, availableProcessors, totalRamInBytes, statFs.getBlockCount() * statFs.getBlockSize(), isEmulator, deviceState, str6, str7)));
        crashlyticsController.logFileManager.setCurrentSession(str);
        SessionReportingCoordinator sessionReportingCoordinator = crashlyticsController.reportingCoordinator;
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = sessionReportingCoordinator.dataCapture;
        crashlyticsReportDataCapture.getClass();
        Charset charset = CrashlyticsReport.UTF_8;
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder();
        builder.sdkVersion = "18.3.5";
        AppData appData2 = crashlyticsReportDataCapture.appData;
        String str8 = appData2.googleAppId;
        if (str8 != null) {
            builder.gmpAppId = str8;
            IdManager idManager2 = crashlyticsReportDataCapture.idManager;
            String crashlyticsInstallId = idManager2.getCrashlyticsInstallId();
            if (crashlyticsInstallId != null) {
                builder.installationUuid = crashlyticsInstallId;
                String str9 = appData2.versionCode;
                if (str9 != null) {
                    builder.buildVersion = str9;
                    String str10 = appData2.versionName;
                    if (str10 != null) {
                        builder.displayVersion = str10;
                        builder.platform = 4;
                        AutoValue_CrashlyticsReport_Session.Builder builder2 = new AutoValue_CrashlyticsReport_Session.Builder();
                        builder2.crashed = Boolean.FALSE;
                        builder2.startedAt = Long.valueOf(currentTimeMillis);
                        if (str != null) {
                            builder2.identifier = str;
                            String str11 = CrashlyticsReportDataCapture.GENERATOR;
                            if (str11 != null) {
                                builder2.generator = str11;
                                String str12 = idManager2.appIdentifier;
                                if (str12 != null) {
                                    String crashlyticsInstallId2 = idManager2.getCrashlyticsInstallId();
                                    DevelopmentPlatformProvider developmentPlatformProvider = appData2.developmentPlatformProvider;
                                    if (developmentPlatformProvider.developmentPlatform == null) {
                                        developmentPlatformProvider.developmentPlatform = new DevelopmentPlatformProvider.DevelopmentPlatform(developmentPlatformProvider);
                                    }
                                    DevelopmentPlatformProvider.DevelopmentPlatform developmentPlatform = developmentPlatformProvider.developmentPlatform;
                                    String str13 = developmentPlatform.developmentPlatform;
                                    if (developmentPlatform == null) {
                                        developmentPlatformProvider.developmentPlatform = new DevelopmentPlatformProvider.DevelopmentPlatform(developmentPlatformProvider);
                                    }
                                    builder2.f139app = new AutoValue_CrashlyticsReport_Session_Application(str12, str9, str10, crashlyticsInstallId2, str13, developmentPlatformProvider.developmentPlatform.developmentPlatformVersion);
                                    AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder builder3 = new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
                                    builder3.platform = 3;
                                    builder3.version = str3;
                                    builder3.buildVersion = str4;
                                    builder3.jailbroken = Boolean.valueOf(CommonUtils.isRooted());
                                    builder2.os = builder3.build();
                                    StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
                                    String str14 = Build.CPU_ABI;
                                    if (TextUtils.isEmpty(str14) || (num = (Integer) CrashlyticsReportDataCapture.ARCHITECTURES_BY_NAME.get(str14.toLowerCase(locale))) == null) {
                                        r4 = 7;
                                    } else {
                                        r4 = num.intValue();
                                    }
                                    int availableProcessors2 = Runtime.getRuntime().availableProcessors();
                                    long totalRamInBytes2 = CommonUtils.getTotalRamInBytes();
                                    long blockCount = statFs2.getBlockCount() * statFs2.getBlockSize();
                                    boolean isEmulator2 = CommonUtils.isEmulator();
                                    int deviceState2 = CommonUtils.getDeviceState();
                                    AutoValue_CrashlyticsReport_Session_Device.Builder builder4 = new AutoValue_CrashlyticsReport_Session_Device.Builder();
                                    builder4.arch = Integer.valueOf(r4);
                                    builder4.model = str5;
                                    builder4.cores = Integer.valueOf(availableProcessors2);
                                    builder4.ram = Long.valueOf(totalRamInBytes2);
                                    builder4.diskSpace = Long.valueOf(blockCount);
                                    builder4.simulator = Boolean.valueOf(isEmulator2);
                                    builder4.state = Integer.valueOf(deviceState2);
                                    builder4.manufacturer = str6;
                                    builder4.modelClass = str7;
                                    builder2.device = builder4.build();
                                    builder2.generatorType = 3;
                                    builder.session = builder2.build();
                                    AutoValue_CrashlyticsReport build = builder.build();
                                    FileStore fileStore = sessionReportingCoordinator.reportPersistence.fileStore;
                                    CrashlyticsReport.Session session = build.session;
                                    if (session == null) {
                                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                            Log.d("FirebaseCrashlytics", "Could not get session for report", null);
                                            return;
                                        }
                                        return;
                                    }
                                    String identifier = session.getIdentifier();
                                    try {
                                        CrashlyticsReportPersistence.TRANSFORM.getClass();
                                        JsonDataEncoderBuilder.AnonymousClass1 anonymousClass1 = CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER;
                                        anonymousClass1.getClass();
                                        StringWriter stringWriter = new StringWriter();
                                        try {
                                            anonymousClass1.encode(build, stringWriter);
                                        } catch (IOException unused) {
                                        }
                                        CrashlyticsReportPersistence.writeTextFile(fileStore.getSessionFile(identifier, "report"), stringWriter.toString());
                                        File sessionFile = fileStore.getSessionFile(identifier, "start-time");
                                        long startedAt = session.getStartedAt();
                                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(sessionFile), CrashlyticsReportPersistence.UTF_8);
                                        try {
                                            outputStreamWriter.write("");
                                            sessionFile.setLastModified(startedAt * 1000);
                                            outputStreamWriter.close();
                                        } finally {
                                        }
                                    } catch (IOException e) {
                                        String m2 = ConstraintSet$$ExternalSyntheticOutline0.m("Could not persist report for session ", identifier);
                                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                            Log.d("FirebaseCrashlytics", m2, e);
                                        }
                                    }
                                } else {
                                    throw new NullPointerException("Null identifier");
                                }
                            } else {
                                throw new NullPointerException("Null generator");
                            }
                        } else {
                            throw new NullPointerException("Null identifier");
                        }
                    } else {
                        throw new NullPointerException("Null displayVersion");
                    }
                } else {
                    throw new NullPointerException("Null buildVersion");
                }
            } else {
                throw new NullPointerException("Null installationUuid");
            }
        } else {
            throw new NullPointerException("Null gmpAppId");
        }
    }

    public static zzw access$900(CrashlyticsController crashlyticsController) {
        boolean z;
        zzw call;
        crashlyticsController.getClass();
        ArrayList arrayList = new ArrayList();
        for (File file : FileStore.safeArrayToList(crashlyticsController.fileStore.crashlyticsDir.listFiles(APP_EXCEPTION_MARKER_FILTER))) {
            try {
                final long parseLong = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    Log.w("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                    call = Tasks.forResult(null);
                } else {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Logging app exception event to Firebase Analytics", null);
                    }
                    call = Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.8
                        @Override // java.util.concurrent.Callable
                        public final Void call() throws Exception {
                            Bundle bundle = new Bundle();
                            bundle.putInt("fatal", 1);
                            bundle.putLong(AnalyticsConstants.KEY_TIMESTAMP, parseLong);
                            CrashlyticsController.this.analyticsEventLogger.logEvent(bundle);
                            return null;
                        }
                    });
                }
                arrayList.add(call);
            } catch (NumberFormatException unused2) {
                Log.w("FirebaseCrashlytics", "Could not parse app exception timestamp from file " + file.getName(), null);
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05c8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03f4 A[LOOP:1: B:46:0x03f4->B:52:0x0411, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0427  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void doCloseSessions(boolean r26, com.google.firebase.crashlytics.internal.settings.SettingsProvider r27) {
        /*
            Method dump skipped, instructions count: 1481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsController.doCloseSessions(boolean, com.google.firebase.crashlytics.internal.settings.SettingsProvider):void");
    }

    public final boolean finalizeSessions(SettingsProvider settingsProvider) {
        boolean z;
        if (Boolean.TRUE.equals(this.backgroundWorker.isExecutorThread.get())) {
            CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
            if (crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException.get()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("FirebaseCrashlytics", "Skipping session finalization because a crash has already occurred.", null);
                return false;
            }
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Finalizing previously open sessions.", null);
            }
            try {
                doCloseSessions(true, settingsProvider);
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Closed all previously open sessions.", null);
                }
                return true;
            } catch (Exception e) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e);
                return false;
            }
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }

    public final String getCurrentSessionId() {
        CrashlyticsReportPersistence crashlyticsReportPersistence = this.reportingCoordinator.reportPersistence;
        crashlyticsReportPersistence.getClass();
        NavigableSet descendingSet = new TreeSet(FileStore.safeArrayToList(crashlyticsReportPersistence.fileStore.sessionsDir.list())).descendingSet();
        if (!descendingSet.isEmpty()) {
            return (String) descendingSet.first();
        }
        return null;
    }

    @SuppressLint({"TaskMainThread"})
    public final Task submitAllReports(zzw zzwVar) {
        boolean z;
        zzw zzwVar2;
        zzw zzwVar3;
        FileStore fileStore = this.reportingCoordinator.reportPersistence.fileStore;
        if (FileStore.safeArrayToList(fileStore.reportsDir.listFiles()).isEmpty() && FileStore.safeArrayToList(fileStore.priorityReportsDir.listFiles()).isEmpty() && FileStore.safeArrayToList(fileStore.nativeReportsDir.listFiles()).isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        TaskCompletionSource<Boolean> taskCompletionSource = this.unsentReportsAvailable;
        if (!z) {
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "No crash reports are available to be sent.", null);
            }
            taskCompletionSource.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        UrlKt urlKt = UrlKt.DEFAULT_LOGGER;
        urlKt.v("Crash reports are available to be sent.");
        DataCollectionArbiter dataCollectionArbiter = this.dataCollectionArbiter;
        if (dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Automatic data collection is enabled. Allowing upload.", null);
            }
            taskCompletionSource.trySetResult(Boolean.FALSE);
            zzwVar3 = Tasks.forResult(Boolean.TRUE);
        } else {
            urlKt.d("Automatic data collection is disabled.");
            urlKt.v("Notifying that unsent reports are available.");
            taskCompletionSource.trySetResult(Boolean.TRUE);
            synchronized (dataCollectionArbiter.taskLock) {
                zzwVar2 = dataCollectionArbiter.dataCollectionEnabledTask.zza;
            }
            zzw onSuccessTask = zzwVar2.onSuccessTask(new AnonymousClass3());
            urlKt.d("Waiting for send/deleteUnsentReports to be called.");
            zzw zzwVar4 = this.reportActionProvided.zza;
            ExecutorService executorService = Utils.TASK_CONTINUATION_EXECUTOR_SERVICE;
            final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            Continuation continuation = new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.Utils$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    boolean isSuccessful = task.isSuccessful();
                    TaskCompletionSource taskCompletionSource3 = TaskCompletionSource.this;
                    if (isSuccessful) {
                        taskCompletionSource3.trySetResult(task.getResult());
                        return null;
                    }
                    Exception exception = task.getException();
                    Objects.requireNonNull(exception);
                    taskCompletionSource3.trySetException(exception);
                    return null;
                }
            };
            onSuccessTask.continueWith(continuation);
            zzwVar4.continueWith(continuation);
            zzwVar3 = taskCompletionSource2.zza;
        }
        return zzwVar3.onSuccessTask(new AnonymousClass4(zzwVar));
    }
}
