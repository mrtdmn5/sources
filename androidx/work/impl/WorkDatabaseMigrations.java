package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* loaded from: classes.dex */
public final class WorkDatabaseMigrations {
    public static final AnonymousClass1 MIGRATION_1_2 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.1
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            database.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            database.execSQL("DROP TABLE IF EXISTS alarmInfo");
            database.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };
    public static final AnonymousClass2 MIGRATION_3_4 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.2
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    };
    public static final AnonymousClass3 MIGRATION_4_5 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.3
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            database.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };
    public static final AnonymousClass4 MIGRATION_6_7 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.4
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };
    public static final AnonymousClass5 MIGRATION_7_8 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.5
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };
    public static final AnonymousClass6 MIGRATION_8_9 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.6
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };
    public static final AnonymousClass7 MIGRATION_11_12 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.7
        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* loaded from: classes.dex */
    public static class RescheduleMigration extends Migration {
        public final Context mContext;

        public RescheduleMigration(Context context, int startVersion, int endVersion) {
            super(startVersion, endVersion);
            this.mContext = context;
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            if (this.endVersion >= 10) {
                database.execSQL(new Object[]{"reschedule_needed", 1});
            } else {
                this.mContext.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WorkMigration9To10 extends Migration {
        public final Context mContext;

        public WorkMigration9To10(Context context) {
            super(9, 10);
            this.mContext = context;
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(FrameworkSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            Context context = this.mContext;
            SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                database.beginTransaction();
                try {
                    database.execSQL(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    database.execSQL(new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    database.setTransactionSuccessful();
                } finally {
                }
            }
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int r3 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int r7 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                database.beginTransaction();
                try {
                    database.execSQL(new Object[]{"next_job_scheduler_id", Integer.valueOf(r3)});
                    database.execSQL(new Object[]{"next_alarm_manager_id", Integer.valueOf(r7)});
                    sharedPreferences2.edit().clear().apply();
                    database.setTransactionSuccessful();
                } finally {
                }
            }
        }
    }
}
