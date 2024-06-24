package com.google.firebase.crashlytics.internal.persistence;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class FileStore {
    public final File crashlyticsDir;
    public final File filesDir;
    public final File nativeReportsDir;
    public final File priorityReportsDir;
    public final File reportsDir;
    public final File sessionsDir;

    public FileStore(Context context) {
        boolean z;
        String str;
        String processName;
        File filesDir = context.getFilesDir();
        this.filesDir = filesDir;
        if (Build.VERSION.SDK_INT >= 28) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder(".com.google.firebase.crashlytics.files.v2");
            sb.append(File.pathSeparator);
            processName = Application.getProcessName();
            sb.append(processName.replaceAll("[^a-zA-Z0-9.]", "_"));
            str = sb.toString();
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File file = new File(filesDir, str);
        prepareBaseDir(file);
        this.crashlyticsDir = file;
        File file2 = new File(file, "open-sessions");
        prepareBaseDir(file2);
        this.sessionsDir = file2;
        File file3 = new File(file, "reports");
        prepareBaseDir(file3);
        this.reportsDir = file3;
        File file4 = new File(file, "priority-reports");
        prepareBaseDir(file4);
        this.priorityReportsDir = file4;
        File file5 = new File(file, "native-reports");
        prepareBaseDir(file5);
        this.nativeReportsDir = file5;
    }

    public static void cleanupDir(File file) {
        if (file.exists() && recursiveDelete(file)) {
            String str = "Deleted previous Crashlytics file system: " + file.getPath();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
        }
    }

    public static synchronized void prepareBaseDir(File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                String str = "Unexpected non-directory file: " + file + "; deleting file and creating new directory.";
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str, null);
                }
                file.delete();
            }
            if (!file.mkdirs()) {
                Log.e("FirebaseCrashlytics", "Could not create Crashlytics-specific directory: " + file, null);
            }
        }
    }

    public static boolean recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                recursiveDelete(file2);
            }
        }
        return file.delete();
    }

    public static <T> List<T> safeArrayToList(T[] tArr) {
        if (tArr == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(tArr);
    }

    public final File getSessionFile(String str, String str2) {
        File file = new File(this.sessionsDir, str);
        file.mkdirs();
        return new File(file, str2);
    }
}
