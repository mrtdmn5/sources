package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class CrashlyticsReportDataCapture {
    public static final HashMap ARCHITECTURES_BY_NAME;
    public static final String GENERATOR;
    public final AppData appData;
    public final Context context;
    public final IdManager idManager;
    public final SettingsProvider settingsProvider;
    public final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;

    static {
        HashMap hashMap = new HashMap();
        ARCHITECTURES_BY_NAME = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
        GENERATOR = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.3.5");
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, MiddleOutFallbackStrategy middleOutFallbackStrategy, SettingsController settingsController) {
        this.context = context;
        this.idManager = idManager;
        this.appData = appData;
        this.stackTraceTrimmingStrategy = middleOutFallbackStrategy;
        this.settingsProvider = settingsController;
    }

    public static AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int r11) {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
        int r0 = 0;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (r11 >= 8) {
            for (TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2; trimmedThrowableData3 != null; trimmedThrowableData3 = trimmedThrowableData3.cause) {
                r0++;
            }
        }
        String str = trimmedThrowableData.className;
        if (str != null) {
            String str2 = trimmedThrowableData.localizedMessage;
            ImmutableList immutableList = new ImmutableList(populateFramesList(stackTraceElementArr, 4));
            Integer valueOf = Integer.valueOf(r0);
            if (trimmedThrowableData2 != null && r0 == 0) {
                autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = populateExceptionData(trimmedThrowableData2, r11 + 1);
            } else {
                autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = null;
            }
            String str3 = "";
            if (valueOf == null) {
                str3 = ComposableInvoker$$ExternalSyntheticOutline0.m("", " overflowCount");
            }
            if (str3.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, str2, immutableList, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception, valueOf.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str3));
        }
        throw new NullPointerException("Null type");
    }

    public static ImmutableList populateFramesList(StackTraceElement[] stackTraceElementArr, int r13) {
        long j;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
            builder.importance = Integer.valueOf(r13);
            long j2 = 0;
            if (stackTraceElement.isNativeMethod()) {
                j = Math.max(stackTraceElement.getLineNumber(), 0L);
            } else {
                j = 0;
            }
            String str = stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                j2 = stackTraceElement.getLineNumber();
            }
            builder.pc = Long.valueOf(j);
            if (str != null) {
                builder.symbol = str;
                builder.file = fileName;
                builder.offset = Long.valueOf(j2);
                arrayList.add(builder.build());
            } else {
                throw new NullPointerException("Null symbol");
            }
        }
        return new ImmutableList(arrayList);
    }

    public static AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArr, int r4) {
        String name = thread.getName();
        if (name != null) {
            Integer valueOf = Integer.valueOf(r4);
            ImmutableList immutableList = new ImmutableList(populateFramesList(stackTraceElementArr, r4));
            String str = "";
            if (valueOf == null) {
                str = "".concat(" importance");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(name, valueOf.intValue(), immutableList);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
        throw new NullPointerException("Null name");
    }

    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> populateBinaryImagesList() {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[] binaryImageArr = new CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[1];
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
        builder.baseAddress = 0L;
        builder.size = 0L;
        AppData appData = this.appData;
        String str = appData.packageName;
        if (str != null) {
            builder.name = str;
            builder.uuid = appData.buildId;
            binaryImageArr[0] = builder.build();
            return new ImmutableList<>(Arrays.asList(binaryImageArr));
        }
        throw new NullPointerException("Null name");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device populateEventDeviceData(int r14) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture.populateEventDeviceData(int):com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device");
    }
}
