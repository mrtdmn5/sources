package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.os.BuildCompat;
import androidx.room.RoomDatabase;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobInfoConverter;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class SystemJobScheduler implements Scheduler {
    public static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(Context context, WorkManagerImpl workManager) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context);
        this.mContext = context;
        this.mWorkManager = workManager;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public static void cancelJobById(JobScheduler jobScheduler, int id) {
        try {
            jobScheduler.cancel(id);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(id)), th);
        }
    }

    public static ArrayList getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0016 A[SYNTHETIC] */
    @Override // androidx.work.impl.Scheduler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void cancel(java.lang.String r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.mContext
            android.app.job.JobScheduler r1 = r8.mJobScheduler
            java.util.ArrayList r0 = getPendingJobs(r0, r1)
            r2 = 0
            if (r0 != 0) goto Lc
            goto L49
        Lc:
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 2
            r3.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L16:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L48
            java.lang.Object r4 = r0.next()
            android.app.job.JobInfo r4 = (android.app.job.JobInfo) r4
            java.lang.String r5 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r6 = r4.getExtras()
            if (r6 == 0) goto L35
            boolean r7 = r6.containsKey(r5)     // Catch: java.lang.NullPointerException -> L35
            if (r7 == 0) goto L35
            java.lang.String r5 = r6.getString(r5)     // Catch: java.lang.NullPointerException -> L35
            goto L36
        L35:
            r5 = r2
        L36:
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L16
            int r4 = r4.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            goto L16
        L48:
            r2 = r3
        L49:
            if (r2 == 0) goto L76
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L76
            java.util.Iterator r0 = r2.iterator()
        L55:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L69
            java.lang.Object r2 = r0.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            cancelJobById(r1, r2)
            goto L55
        L69:
            androidx.work.impl.WorkManagerImpl r0 = r8.mWorkManager
            androidx.work.impl.WorkDatabase r0 = r0.mWorkDatabase
            androidx.work.impl.model.SystemIdInfoDao r0 = r0.systemIdInfoDao()
            androidx.work.impl.model.SystemIdInfoDao_Impl r0 = (androidx.work.impl.model.SystemIdInfoDao_Impl) r0
            r0.removeSystemIdInfo(r9)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobScheduler.cancel(java.lang.String):void");
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecs) {
        int r12;
        int r13;
        int r16;
        int r9;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        int length = workSpecs.length;
        int r5 = 0;
        int r6 = 0;
        while (r6 < length) {
            WorkSpec workSpec = workSpecs[r6];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(workSpec.id);
                String str = TAG;
                if (workSpec2 == null) {
                    Logger.get().warning(str, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB", new Throwable[r5]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(str, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued", new Throwable[r5]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) workDatabase.systemIdInfoDao()).getSystemIdInfo(workSpec.id);
                    if (systemIdInfo != null) {
                        r9 = systemIdInfo.systemId;
                        r16 = r6;
                    } else {
                        workManagerImpl.mConfiguration.getClass();
                        int r92 = workManagerImpl.mConfiguration.mMaxJobSchedulerId;
                        synchronized (IdGenerator.class) {
                            workDatabase.beginTransaction();
                            try {
                                Long longValue = ((PreferenceDao_Impl) workDatabase.preferenceDao()).getLongValue("next_job_scheduler_id");
                                if (longValue != null) {
                                    r12 = longValue.intValue();
                                } else {
                                    r12 = r5;
                                }
                                if (r12 == Integer.MAX_VALUE) {
                                    r13 = r5;
                                } else {
                                    r13 = r12 + 1;
                                }
                                r16 = r6;
                                ((PreferenceDao_Impl) workDatabase.preferenceDao()).insertPreference(new Preference("next_job_scheduler_id", r13));
                                workDatabase.setTransactionSuccessful();
                                if (r12 >= 0 && r12 <= r92) {
                                    r9 = r12;
                                }
                                ((PreferenceDao_Impl) workDatabase.preferenceDao()).insertPreference(new Preference("next_job_scheduler_id", 1));
                                r9 = 0;
                            } finally {
                            }
                        }
                    }
                    if (systemIdInfo == null) {
                        SystemIdInfo systemIdInfo2 = new SystemIdInfo(workSpec.id, r9);
                        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workManagerImpl.mWorkDatabase.systemIdInfoDao();
                        RoomDatabase roomDatabase = systemIdInfoDao_Impl.__db;
                        roomDatabase.assertNotSuspendingTransaction();
                        roomDatabase.beginTransaction();
                        try {
                            systemIdInfoDao_Impl.__insertionAdapterOfSystemIdInfo.insert(systemIdInfo2);
                            roomDatabase.setTransactionSuccessful();
                            roomDatabase.endTransaction();
                        } catch (Throwable th) {
                            roomDatabase.endTransaction();
                            throw th;
                        }
                    }
                    scheduleInternal(workSpec, r9);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    r6 = r16 + 1;
                    r5 = 0;
                }
                r16 = r6;
                workDatabase.endTransaction();
                r6 = r16 + 1;
                r5 = 0;
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scheduleInternal(WorkSpec workSpec, int r18) {
        int r13;
        byte b;
        boolean z;
        boolean z2;
        int r2;
        int r5;
        JobScheduler jobScheduler = this.mJobScheduler;
        SystemJobInfoConverter systemJobInfoConverter = this.mSystemJobInfoConverter;
        systemJobInfoConverter.getClass();
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(r18, systemJobInfoConverter.mWorkServiceComponent).setRequiresCharging(constraints.mRequiresCharging).setRequiresDeviceIdle(constraints.mRequiresDeviceIdle).setExtras(persistableBundle);
        NetworkType networkType = constraints.mRequiredNetworkType;
        int r6 = Build.VERSION.SDK_INT;
        if (r6 >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            int r10 = SystemJobInfoConverter.AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
            if (r10 != 1) {
                int r12 = 2;
                if (r10 != 2) {
                    r13 = 3;
                    if (r10 != 3) {
                        r12 = 4;
                        if (r10 != 4) {
                            if (r10 != 5 || r6 < 26) {
                                Logger.get().debug(SystemJobInfoConverter.TAG, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
                            }
                        }
                    }
                    r13 = r12;
                }
                r13 = 1;
            } else {
                r13 = 0;
            }
            extras.setRequiredNetworkType(r13);
        }
        if (!constraints.mRequiresDeviceIdle) {
            if (workSpec.backoffPolicy == BackoffPolicy.LINEAR) {
                r5 = 0;
            } else {
                r5 = 1;
            }
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, r5);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0L);
        if (r6 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.expedited) {
            extras.setImportantWhileForeground(true);
        }
        if (constraints.mContentUriTriggers.mTriggers.size() > 0) {
            b = true;
        } else {
            b = false;
        }
        if (b != false) {
            Iterator it = constraints.mContentUriTriggers.mTriggers.iterator();
            while (it.hasNext()) {
                ContentUriTriggers.Trigger trigger = (ContentUriTriggers.Trigger) it.next();
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(trigger.mUri, trigger.mTriggerForDescendants ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(constraints.mTriggerContentUpdateDelay);
            extras.setTriggerContentMaxDelay(constraints.mTriggerMaxContentDelay);
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(constraints.mRequiresBatteryNotLow);
            extras.setRequiresStorageNotLow(constraints.mRequiresStorageNotLow);
        }
        if (workSpec.runAttemptCount > 0) {
            z = true;
        } else {
            z = false;
        }
        if (max > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (BuildCompat.isAtLeastS() && workSpec.expedited && !z && !z2) {
            extras.setExpedited(true);
        }
        JobInfo build = extras.build();
        String str = TAG;
        Logger.get().debug(str, String.format("Scheduling work ID %s Job ID %s", workSpec.id, Integer.valueOf(r18)), new Throwable[0]);
        try {
            if (jobScheduler.schedule(build) == 0) {
                Logger.get().warning(str, String.format("Unable to schedule work ID %s", workSpec.id), new Throwable[0]);
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug(str, String.format("Scheduling a non-expedited job (work ID %s)", workSpec.id), new Throwable[0]);
                    scheduleInternal(workSpec, r18);
                }
            }
        } catch (IllegalStateException e) {
            ArrayList pendingJobs = getPendingJobs(this.mContext, jobScheduler);
            if (pendingJobs != null) {
                r2 = pendingJobs.size();
            } else {
                r2 = 0;
            }
            Locale locale = Locale.getDefault();
            Integer valueOf = Integer.valueOf(r2);
            WorkManagerImpl workManagerImpl = this.mWorkManager;
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", valueOf, Integer.valueOf(((WorkSpecDao_Impl) workManagerImpl.mWorkDatabase.workSpecDao()).getScheduledWork().size()), Integer.valueOf(workManagerImpl.mConfiguration.mMaxSchedulerLimit));
            Logger.get().error(str, format, new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            Logger.get().error(str, String.format("Unable to schedule %s", workSpec), th);
        }
    }
}
