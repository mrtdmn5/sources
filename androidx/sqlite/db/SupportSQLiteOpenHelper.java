package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.Closeable;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: SupportSQLiteOpenHelper.kt */
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* compiled from: SupportSQLiteOpenHelper.kt */
    /* loaded from: classes.dex */
    public static final class Configuration {
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public Configuration(Context context, String str, Callback callback, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z;
            this.allowDataLossOnRecovery = false;
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.kt */
    /* loaded from: classes.dex */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    String getDatabaseName();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    /* compiled from: SupportSQLiteOpenHelper.kt */
    /* loaded from: classes.dex */
    public static abstract class Callback {
        public final int version;

        public Callback(int r1) {
            this.version = r1;
        }

        public static void deleteDatabaseFile(String str) {
            int r5;
            boolean z;
            if (!StringsKt__StringsJVMKt.equals(str, ":memory:")) {
                boolean z2 = true;
                int length = str.length() - 1;
                int r3 = 0;
                boolean z3 = false;
                while (r3 <= length) {
                    if (!z3) {
                        r5 = r3;
                    } else {
                        r5 = length;
                    }
                    if (Intrinsics.compare(str.charAt(r5), 32) <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z3) {
                        if (!z) {
                            z3 = true;
                        } else {
                            r3++;
                        }
                    } else if (!z) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(r3, length + 1).toString().length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    Log.w("SupportSQLite", "deleting the database file: ".concat(str));
                    try {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } catch (Exception e) {
                        Log.w("SupportSQLite", "delete failed: ", e);
                    }
                }
            }
        }

        public abstract void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public void onDowngrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int r4, int r5) {
            throw new SQLiteException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Can't downgrade database from version ", r4, " to ", r5));
        }

        public abstract void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int r2, int r3);

        public void onConfigure(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        }

        public void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        }
    }
}
