package com.google.firebase.crashlytics.internal.persistence;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public final class CrashlyticsReportPersistence {
    public final AtomicInteger eventCounter = new AtomicInteger(0);
    public final FileStore fileStore;
    public final SettingsProvider settingsProvider;
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);
    public static final int EVENT_NAME_LENGTH = 15;
    public static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    public static final CrashlyticsReportPersistence$$ExternalSyntheticLambda2 LATEST_SESSION_ID_FIRST_COMPARATOR = new CrashlyticsReportPersistence$$ExternalSyntheticLambda2();
    public static final CrashlyticsReportPersistence$$ExternalSyntheticLambda3 EVENT_FILE_FILTER = new CrashlyticsReportPersistence$$ExternalSyntheticLambda3();

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsController settingsController) {
        this.fileStore = fileStore;
        this.settingsProvider = settingsController;
    }

    public static void deleteFiles(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String readTextFile(File file) throws IOException {
        byte[] bArr = new byte[DfuBaseService.ERROR_REMOTE_MASK];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void writeTextFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final ArrayList getAllFinalizedReportFiles() {
        ArrayList arrayList = new ArrayList();
        FileStore fileStore = this.fileStore;
        arrayList.addAll(FileStore.safeArrayToList(fileStore.priorityReportsDir.listFiles()));
        arrayList.addAll(FileStore.safeArrayToList(fileStore.nativeReportsDir.listFiles()));
        CrashlyticsReportPersistence$$ExternalSyntheticLambda2 crashlyticsReportPersistence$$ExternalSyntheticLambda2 = LATEST_SESSION_ID_FIRST_COMPARATOR;
        Collections.sort(arrayList, crashlyticsReportPersistence$$ExternalSyntheticLambda2);
        List safeArrayToList = FileStore.safeArrayToList(fileStore.reportsDir.listFiles());
        Collections.sort(safeArrayToList, crashlyticsReportPersistence$$ExternalSyntheticLambda2);
        arrayList.addAll(safeArrayToList);
        return arrayList;
    }

    public final void persistEvent(AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event, String str, boolean z) {
        String str2;
        FileStore fileStore = this.fileStore;
        int r1 = ((SettingsController) this.settingsProvider).getSettingsSync().sessionData.maxCustomExceptionEvents;
        TRANSFORM.getClass();
        JsonDataEncoderBuilder.AnonymousClass1 anonymousClass1 = CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER;
        anonymousClass1.getClass();
        StringWriter stringWriter = new StringWriter();
        try {
            anonymousClass1.encode(autoValue_CrashlyticsReport_Session_Event, stringWriter);
        } catch (IOException unused) {
        }
        String stringWriter2 = stringWriter.toString();
        String format = String.format(Locale.US, "%010d", Integer.valueOf(this.eventCounter.getAndIncrement()));
        if (z) {
            str2 = "_";
        } else {
            str2 = "";
        }
        try {
            writeTextFile(fileStore.getSessionFile(str, zzav$$ExternalSyntheticOutline0.m("event", format, str2)), stringWriter2);
        } catch (IOException e) {
            Log.w("FirebaseCrashlytics", "Could not persist event for session " + str, e);
        }
        CrashlyticsReportPersistence$$ExternalSyntheticLambda0 crashlyticsReportPersistence$$ExternalSyntheticLambda0 = new CrashlyticsReportPersistence$$ExternalSyntheticLambda0();
        fileStore.getClass();
        File file = new File(fileStore.sessionsDir, str);
        file.mkdirs();
        List<File> safeArrayToList = FileStore.safeArrayToList(file.listFiles(crashlyticsReportPersistence$$ExternalSyntheticLambda0));
        Collections.sort(safeArrayToList, new CrashlyticsReportPersistence$$ExternalSyntheticLambda1());
        int size = safeArrayToList.size();
        for (File file2 : safeArrayToList) {
            if (size > r1) {
                FileStore.recursiveDelete(file2);
                size--;
            } else {
                return;
            }
        }
    }
}
