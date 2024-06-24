package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.Command;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.metadata.KeysMap;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.send.ReportQueue;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import io.ktor.http.UrlKt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SessionReportingCoordinator {
    public final CrashlyticsReportDataCapture dataCapture;
    public final LogFileManager logFileManager;
    public final UserMetadata reportMetadata;
    public final CrashlyticsReportPersistence reportPersistence;
    public final DataTransportCrashlyticsReportSender reportsSender;

    public SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager;
        this.reportMetadata = userMetadata;
    }

    public static AutoValue_CrashlyticsReport_Session_Event addLogsAndCustomKeysToEvent(AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event, LogFileManager logFileManager, UserMetadata userMetadata) {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        AutoValue_CrashlyticsReport_Session_Event.Builder builder = new AutoValue_CrashlyticsReport_Session_Event.Builder(autoValue_CrashlyticsReport_Session_Event);
        String logAsString = logFileManager.currentLog.getLogAsString();
        if (logAsString != null) {
            builder.log = new AutoValue_CrashlyticsReport_Session_Event_Log(logAsString);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        KeysMap reference = userMetadata.customKeys.map.getReference();
        synchronized (reference) {
            unmodifiableMap = Collections.unmodifiableMap(new HashMap(reference.keys));
        }
        ArrayList sortedCustomAttributes = getSortedCustomAttributes(unmodifiableMap);
        KeysMap reference2 = userMetadata.internalKeys.map.getReference();
        synchronized (reference2) {
            unmodifiableMap2 = Collections.unmodifiableMap(new HashMap(reference2.keys));
        }
        ArrayList sortedCustomAttributes2 = getSortedCustomAttributes(unmodifiableMap2);
        if (!sortedCustomAttributes.isEmpty() || !sortedCustomAttributes2.isEmpty()) {
            AutoValue_CrashlyticsReport_Session_Event_Application.Builder builder2 = autoValue_CrashlyticsReport_Session_Event.f140app.toBuilder();
            builder2.customAttributes = new ImmutableList<>(sortedCustomAttributes);
            builder2.internalKeys = new ImmutableList<>(sortedCustomAttributes2);
            builder.f141app = builder2.build();
        }
        return builder.build();
    }

    public static SessionReportingCoordinator create(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, MiddleOutFallbackStrategy middleOutFallbackStrategy, SettingsController settingsController, OnDemandCounter onDemandCounter) {
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = new CrashlyticsReportDataCapture(context, idManager, appData, middleOutFallbackStrategy, settingsController);
        CrashlyticsReportPersistence crashlyticsReportPersistence = new CrashlyticsReportPersistence(fileStore, settingsController);
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = DataTransportCrashlyticsReportSender.TRANSFORM;
        TransportRuntime.initialize(context);
        return new SessionReportingCoordinator(crashlyticsReportDataCapture, crashlyticsReportPersistence, new DataTransportCrashlyticsReportSender(new ReportQueue(TransportRuntime.getInstance().newFactory(new CCTDestination(DataTransportCrashlyticsReportSender.CRASHLYTICS_ENDPOINT, DataTransportCrashlyticsReportSender.CRASHLYTICS_API_KEY)).getTransport("FIREBASE_CRASHLYTICS_REPORT", new Encoding("json"), DataTransportCrashlyticsReportSender.DEFAULT_TRANSFORM), settingsController.getSettingsSync(), onDemandCounter)), logFileManager, userMetadata);
    }

    public static ArrayList getSortedCustomAttributes(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                String str2 = (String) entry.getValue();
                if (str2 != null) {
                    arrayList.add(new AutoValue_CrashlyticsReport_CustomAttribute(str, str2));
                } else {
                    throw new NullPointerException("Null value");
                }
            } else {
                throw new NullPointerException("Null key");
            }
        }
        Collections.sort(arrayList, new SessionReportingCoordinator$$ExternalSyntheticLambda8());
        return arrayList;
    }

    public final void persistEvent(Throwable th, Thread thread, String str, String str2, long j, boolean z) {
        TrimmedThrowableData trimmedThrowableData;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Boolean bool;
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
        String str3;
        String str4;
        boolean z2;
        Thread thread2 = thread;
        boolean equals = str2.equals(Command.CRASH);
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = this.dataCapture;
        Context context = crashlyticsReportDataCapture.context;
        int r6 = context.getResources().getConfiguration().orientation;
        String localizedMessage = th.getLocalizedMessage();
        String name = th.getClass().getName();
        StackTraceElement[] stackTrace = th.getStackTrace();
        StackTraceTrimmingStrategy stackTraceTrimmingStrategy = crashlyticsReportDataCapture.stackTraceTrimmingStrategy;
        StackTraceElement[] trimmedStackTrace = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTrace);
        Throwable cause = th.getCause();
        if (cause != null) {
            trimmedThrowableData = new TrimmedThrowableData(cause, stackTraceTrimmingStrategy);
        } else {
            trimmedThrowableData = null;
        }
        AutoValue_CrashlyticsReport_Session_Event.Builder builder = new AutoValue_CrashlyticsReport_Session_Event.Builder();
        builder.type = str2;
        builder.timestamp = Long.valueOf(j);
        String str5 = crashlyticsReportDataCapture.appData.packageName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                runningAppProcessInfo = it.next();
                if (runningAppProcessInfo.processName.equals(str5)) {
                    break;
                }
            }
        }
        runningAppProcessInfo = null;
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance != 100) {
                z2 = true;
            } else {
                z2 = false;
            }
            bool = Boolean.valueOf(z2);
        } else {
            bool = null;
        }
        Boolean bool2 = bool;
        Integer valueOf = Integer.valueOf(r6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(CrashlyticsReportDataCapture.populateThreadData(thread2, trimmedStackTrace, 4));
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread2)) {
                    arrayList.add(CrashlyticsReportDataCapture.populateThreadData(key, stackTraceTrimmingStrategy.getTrimmedStackTrace(entry.getValue()), 0));
                }
                thread2 = thread;
            }
        }
        ImmutableList immutableList = new ImmutableList(arrayList);
        if (trimmedStackTrace == null) {
            trimmedStackTrace = new StackTraceElement[0];
        }
        ImmutableList immutableList2 = new ImmutableList(CrashlyticsReportDataCapture.populateFramesList(trimmedStackTrace, 4));
        Integer num = 0;
        if (trimmedThrowableData != null) {
            autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = CrashlyticsReportDataCapture.populateExceptionData(trimmedThrowableData, 1);
        } else {
            autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = null;
        }
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception2 = autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
        String str6 = "";
        if (num != null) {
            str3 = "";
        } else {
            str3 = ComposableInvoker$$ExternalSyntheticOutline0.m("", " overflowCount");
        }
        if (str3.isEmpty()) {
            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception3 = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(name, localizedMessage, immutableList2, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception2, num.intValue());
            Long l = 0L;
            if (l != null) {
                str4 = "";
            } else {
                str4 = " address";
            }
            if (str4.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception3, null, new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal("0", "0", l.longValue()), crashlyticsReportDataCapture.populateBinaryImagesList());
                if (valueOf == null) {
                    str6 = "".concat(" uiOrientation");
                }
                if (str6.isEmpty()) {
                    builder.f141app = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, null, null, bool2, valueOf.intValue());
                    builder.device = crashlyticsReportDataCapture.populateEventDeviceData(r6);
                    this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(builder.build(), this.logFileManager, this.reportMetadata), str, equals);
                    return;
                }
                throw new IllegalStateException("Missing required properties:".concat(str6));
            }
            throw new IllegalStateException("Missing required properties:".concat(str4));
        }
        throw new IllegalStateException("Missing required properties:".concat(str3));
    }

    public final zzw sendReports(String str, Executor executor) {
        boolean z;
        TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource;
        ArrayList allFinalizedReportFiles = this.reportPersistence.getAllFinalizedReportFiles();
        ArrayList arrayList = new ArrayList();
        Iterator it = allFinalizedReportFiles.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = CrashlyticsReportPersistence.TRANSFORM;
                String readTextFile = CrashlyticsReportPersistence.readTextFile(file);
                crashlyticsReportJsonTransform.getClass();
                arrayList.add(new AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReportJsonTransform.reportFromJson(readTextFile), file.getName(), file));
            } catch (IOException e) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) it2.next();
            if (str == null || str.equals(crashlyticsReportWithSessionId.getSessionId())) {
                DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender = this.reportsSender;
                boolean z2 = true;
                if (str != null) {
                    z = true;
                } else {
                    z = false;
                }
                ReportQueue reportQueue = dataTransportCrashlyticsReportSender.reportQueue;
                synchronized (reportQueue.queue) {
                    taskCompletionSource = new TaskCompletionSource<>();
                    if (z) {
                        reportQueue.onDemandCounter.recordedOnDemandExceptions.getAndIncrement();
                        if (reportQueue.queue.size() >= reportQueue.queueCapacity) {
                            z2 = false;
                        }
                        if (z2) {
                            UrlKt urlKt = UrlKt.DEFAULT_LOGGER;
                            urlKt.d("Enqueueing report: " + crashlyticsReportWithSessionId.getSessionId());
                            urlKt.d("Queue size: " + reportQueue.queue.size());
                            reportQueue.singleThreadExecutor.execute(new ReportQueue.ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                            urlKt.d("Closing task for report: " + crashlyticsReportWithSessionId.getSessionId());
                            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                        } else {
                            reportQueue.calcStep();
                            String str2 = "Dropping report due to queue being full: " + crashlyticsReportWithSessionId.getSessionId();
                            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                Log.d("FirebaseCrashlytics", str2, null);
                            }
                            reportQueue.onDemandCounter.droppedOnDemandExceptions.getAndIncrement();
                            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                        }
                    } else {
                        reportQueue.sendReport(crashlyticsReportWithSessionId, taskCompletionSource);
                    }
                }
                arrayList2.add(taskCompletionSource.zza.continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator$$ExternalSyntheticLambda9
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        boolean z3;
                        SessionReportingCoordinator.this.getClass();
                        if (task.isSuccessful()) {
                            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2 = (CrashlyticsReportWithSessionId) task.getResult();
                            UrlKt urlKt2 = UrlKt.DEFAULT_LOGGER;
                            urlKt2.d("Crashlytics report successfully enqueued to DataTransport: " + crashlyticsReportWithSessionId2.getSessionId());
                            File reportFile = crashlyticsReportWithSessionId2.getReportFile();
                            if (reportFile.delete()) {
                                urlKt2.d("Deleted report file: " + reportFile.getPath());
                            } else {
                                urlKt2.w("Crashlytics could not delete report file: " + reportFile.getPath(), null);
                            }
                            z3 = true;
                        } else {
                            Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", task.getException());
                            z3 = false;
                        }
                        return Boolean.valueOf(z3);
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList2);
    }
}
