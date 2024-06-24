package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class WorkDatabasePathHelper {
    public static final String TAG = Logger.tagWithPrefix("WrkDbPathHelper");
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};

    public static void migrateDatabase(Context context) {
        String format;
        if (context.getDatabasePath("androidx.work.workdb").exists()) {
            String str = TAG;
            Logger.get().debug(str, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            HashMap hashMap = new HashMap();
            File databasePath = context.getDatabasePath("androidx.work.workdb");
            File file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
            hashMap.put(databasePath, file);
            for (String str2 : DATABASE_EXTRA_FILES) {
                hashMap.put(new File(databasePath.getPath() + str2), new File(file.getPath() + str2));
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        Logger.get().warning(str, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                    }
                    if (file2.renameTo(file3)) {
                        format = String.format("Migrated %s to %s", file2, file3);
                    } else {
                        format = String.format("Renaming %s to %s failed", file2, file3);
                    }
                    Logger.get().debug(str, format, new Throwable[0]);
                }
            }
        }
    }
}
