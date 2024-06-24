package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);

    /* renamed from: androidx.work.impl.WorkDatabase$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends RoomDatabase.Callback {
        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(FrameworkSQLiteDatabase db) {
            db.beginTransaction();
            try {
                int r0 = WorkDatabase.$r8$clinit;
                db.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - WorkDatabase.PRUNE_THRESHOLD_MILLIS) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();
}
