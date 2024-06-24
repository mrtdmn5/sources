package androidx.work.impl;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.kronaby.watch.app.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class WorkManagerImpl extends WorkManager {
    public static WorkManagerImpl sDefaultInstance;
    public static WorkManagerImpl sDelegatedInstance;
    public static final Object sLock;
    public Configuration mConfiguration;
    public Context mContext;
    public boolean mForceStopRunnableCompleted;
    public PreferenceUtils mPreferenceUtils;
    public Processor mProcessor;
    public BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    public List<Scheduler> mSchedulers;
    public WorkDatabase mWorkDatabase;
    public TaskExecutor mWorkTaskExecutor;

    static {
        Logger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public WorkManagerImpl(Context context, Configuration configuration, WorkManagerTaskExecutor workTaskExecutor) {
        RoomDatabase.Builder builder;
        Executor executor;
        String str;
        boolean z;
        boolean z2 = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        SerialExecutor serialExecutor = workTaskExecutor.mBackgroundExecutor;
        int r5 = WorkDatabase.$r8$clinit;
        if (z2) {
            builder = new RoomDatabase.Builder(applicationContext, null);
            builder.mAllowMainThreadQueries = true;
        } else {
            String str2 = WorkDatabasePathHelper.TAG;
            builder = new RoomDatabase.Builder(applicationContext, "androidx.work.workdb");
            builder.mFactory = new SupportSQLiteOpenHelper.Factory() { // from class: androidx.work.impl.WorkDatabase.1
                public final /* synthetic */ Context val$context;

                public AnonymousClass1(Context applicationContext2) {
                    val$context = applicationContext2;
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration2) {
                    boolean z3;
                    Context context2 = val$context;
                    Intrinsics.checkNotNullParameter(context2, "context");
                    SupportSQLiteOpenHelper.Callback callback = configuration2.callback;
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    String str3 = configuration2.name;
                    boolean z4 = false;
                    if (str3 != null && str3.length() != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        z4 = true;
                    }
                    if (z4) {
                        SupportSQLiteOpenHelper.Configuration configuration3 = new SupportSQLiteOpenHelper.Configuration(context2, str3, callback, true);
                        return new FrameworkSQLiteOpenHelper(configuration3.context, configuration3.name, configuration3.callback, configuration3.useNoBackupDirectory, configuration3.allowDataLossOnRecovery);
                    }
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
                }
            };
        }
        builder.mQueryExecutor = serialExecutor;
        WorkDatabase.AnonymousClass2 anonymousClass2 = new WorkDatabase.AnonymousClass2();
        if (builder.mCallbacks == null) {
            builder.mCallbacks = new ArrayList<>();
        }
        builder.mCallbacks.add(anonymousClass2);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_1_2);
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(applicationContext2, 2, 3));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_3_4);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_4_5);
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(applicationContext2, 5, 6));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_6_7);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_7_8);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_8_9);
        builder.addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(applicationContext2));
        builder.addMigrations(new WorkDatabaseMigrations.RescheduleMigration(applicationContext2, 10, 11));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_11_12);
        builder.mRequireMigration = false;
        builder.mAllowDestructiveMigrationOnDowngrade = true;
        Context context2 = builder.mContext;
        if (context2 != null) {
            Class<T> cls = builder.mDatabaseClass;
            if (cls != 0) {
                Executor executor2 = builder.mQueryExecutor;
                if (executor2 == null && builder.mTransactionExecutor == null) {
                    ArchTaskExecutor$$ExternalSyntheticLambda0 archTaskExecutor$$ExternalSyntheticLambda0 = ArchTaskExecutor.sIOThreadExecutor;
                    builder.mTransactionExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
                    builder.mQueryExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
                } else if (executor2 != null && builder.mTransactionExecutor == null) {
                    builder.mTransactionExecutor = executor2;
                } else if (executor2 == null && (executor = builder.mTransactionExecutor) != null) {
                    builder.mQueryExecutor = executor;
                }
                if (builder.mFactory == null) {
                    builder.mFactory = new FrameworkSQLiteOpenHelperFactory();
                }
                String str3 = builder.mName;
                SupportSQLiteOpenHelper.Factory factory = builder.mFactory;
                RoomDatabase.MigrationContainer migrationContainer = builder.mMigrationContainer;
                ArrayList<RoomDatabase.Callback> arrayList = builder.mCallbacks;
                boolean z3 = builder.mAllowMainThreadQueries;
                RoomDatabase.JournalMode resolve = builder.mJournalMode.resolve(context2);
                Executor executor3 = builder.mQueryExecutor;
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str3, factory, migrationContainer, arrayList, z3, resolve, executor3, builder.mTransactionExecutor, builder.mRequireMigration, builder.mAllowDestructiveMigrationOnDowngrade);
                String name = cls.getPackage().getName();
                String canonicalName = cls.getCanonicalName();
                String str4 = (name.isEmpty() ? canonicalName : canonicalName.substring(name.length() + 1)).replace('.', '_') + "_Impl";
                try {
                    if (name.isEmpty()) {
                        str = str4;
                    } else {
                        str = name + InstructionFileId.DOT + str4;
                    }
                    RoomDatabase roomDatabase = (RoomDatabase) Class.forName(str).newInstance();
                    SupportSQLiteOpenHelper createOpenHelper = roomDatabase.createOpenHelper(databaseConfiguration);
                    roomDatabase.mOpenHelper = createOpenHelper;
                    if (createOpenHelper instanceof SQLiteCopyOpenHelper) {
                        ((SQLiteCopyOpenHelper) createOpenHelper).mDatabaseConfiguration = databaseConfiguration;
                    }
                    if (resolve == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
                        z = true;
                    } else {
                        z = false;
                    }
                    createOpenHelper.setWriteAheadLoggingEnabled(z);
                    roomDatabase.mCallbacks = arrayList;
                    roomDatabase.mQueryExecutor = executor3;
                    new ArrayDeque();
                    roomDatabase.mAllowMainThreadQueries = z3;
                    roomDatabase.mWriteAheadLoggingEnabled = z;
                    WorkDatabase workDatabase = (WorkDatabase) roomDatabase;
                    Context applicationContext2 = context.getApplicationContext();
                    Logger.LogcatLogger logcatLogger = new Logger.LogcatLogger(configuration.mLoggingLevel);
                    synchronized (Logger.class) {
                        Logger.sLogger = logcatLogger;
                    }
                    String str5 = Schedulers.TAG;
                    SystemJobScheduler systemJobScheduler = new SystemJobScheduler(applicationContext2, this);
                    PackageManagerHelper.setComponentEnabled(applicationContext2, SystemJobService.class, true);
                    Logger.get().debug(Schedulers.TAG, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
                    List<Scheduler> asList = Arrays.asList(systemJobScheduler, new GreedyScheduler(applicationContext2, configuration, workTaskExecutor, this));
                    Processor processor = new Processor(context, configuration, workTaskExecutor, workDatabase, asList);
                    Context applicationContext3 = context.getApplicationContext();
                    this.mContext = applicationContext3;
                    this.mConfiguration = configuration;
                    this.mWorkTaskExecutor = workTaskExecutor;
                    this.mWorkDatabase = workDatabase;
                    this.mSchedulers = asList;
                    this.mProcessor = processor;
                    this.mPreferenceUtils = new PreferenceUtils(workDatabase);
                    this.mForceStopRunnableCompleted = false;
                    if (!applicationContext3.isDeviceProtectedStorage()) {
                        ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).executeOnBackgroundThread(new ForceStopRunnable(applicationContext3, this));
                        return;
                    }
                    throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
                } catch (ClassNotFoundException unused) {
                    throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str4 + " does not exist");
                } catch (IllegalAccessException unused2) {
                    throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
                } catch (InstantiationException unused3) {
                    throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
                }
            }
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        }
        throw new IllegalArgumentException("Cannot provide null context for the database.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl workManagerImpl;
        Object obj = sLock;
        synchronized (obj) {
            synchronized (obj) {
                workManagerImpl = sDelegatedInstance;
                if (workManagerImpl == null) {
                    workManagerImpl = sDefaultInstance;
                }
            }
            return workManagerImpl;
        }
        if (workManagerImpl == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Configuration.Provider) {
                initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                workManagerImpl = getInstance(applicationContext);
            } else {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return workManagerImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:            r4 = r4.getApplicationContext();     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            if (androidx.work.impl.WorkManagerImpl.sDefaultInstance != null) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            androidx.work.impl.WorkManagerImpl.sDefaultInstance = new androidx.work.impl.WorkManagerImpl(r4, r5, new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor(r5.mTaskExecutor));     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:            androidx.work.impl.WorkManagerImpl.sDelegatedInstance = androidx.work.impl.WorkManagerImpl.sDefaultInstance;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initialize(android.content.Context r4, androidx.work.Configuration r5) {
        /*
            java.lang.Object r0 = androidx.work.impl.WorkManagerImpl.sLock
            monitor-enter(r0)
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDelegatedInstance     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L14
            androidx.work.impl.WorkManagerImpl r2 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto Lc
            goto L14
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L32
            throw r4     // Catch: java.lang.Throwable -> L32
        L14:
            if (r1 != 0) goto L30
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L32
            if (r1 != 0) goto L2c
            androidx.work.impl.WorkManagerImpl r1 = new androidx.work.impl.WorkManagerImpl     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor     // Catch: java.lang.Throwable -> L32
            java.util.concurrent.ExecutorService r3 = r5.mTaskExecutor     // Catch: java.lang.Throwable -> L32
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L32
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl.sDefaultInstance = r1     // Catch: java.lang.Throwable -> L32
        L2c:
            androidx.work.impl.WorkManagerImpl r4 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl.sDelegatedInstance = r4     // Catch: java.lang.Throwable -> L32
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return
        L32:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.initialize(android.content.Context, androidx.work.Configuration):void");
    }

    public final void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            this.mForceStopRunnableCompleted = true;
            BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
            if (pendingResult != null) {
                pendingResult.finish();
                this.mRescheduleReceiverResult = null;
            }
        }
    }

    public final void rescheduleEligibleWork() {
        ArrayList pendingJobs;
        Context context = this.mContext;
        String str = SystemJobScheduler.TAG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            Iterator it = pendingJobs.iterator();
            while (it.hasNext()) {
                SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) this.mWorkDatabase.workSpecDao();
        RoomDatabase roomDatabase = workSpecDao_Impl.__db;
        roomDatabase.assertNotSuspendingTransaction();
        WorkSpecDao_Impl.AnonymousClass8 anonymousClass8 = workSpecDao_Impl.__preparedStmtOfResetScheduledState;
        SupportSQLiteStatement acquire = anonymousClass8.acquire();
        roomDatabase.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            roomDatabase.endTransaction();
            anonymousClass8.release(acquire);
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        } catch (Throwable th) {
            roomDatabase.endTransaction();
            anonymousClass8.release(acquire);
            throw th;
        }
    }

    public final void startWork(String workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).executeOnBackgroundThread(new StartWorkRunnable(this, workSpecId, runtimeExtras));
    }

    public final void stopWork(String workSpecId) {
        ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).executeOnBackgroundThread(new StopWorkRunnable(this, workSpecId, false));
    }
}
