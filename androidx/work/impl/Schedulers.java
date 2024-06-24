package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Schedulers {
    public static final String TAG = Logger.tagWithPrefix("Schedulers");

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> schedulers) {
        if (schedulers != null && schedulers.size() != 0) {
            WorkSpecDao workSpecDao = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            try {
                WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
                ArrayList eligibleWorkForScheduling = workSpecDao_Impl.getEligibleWorkForScheduling(configuration.mMaxSchedulerLimit);
                ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_Impl.getAllEligibleWorkSpecsForScheduling();
                if (eligibleWorkForScheduling.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = eligibleWorkForScheduling.iterator();
                    while (it.hasNext()) {
                        workSpecDao_Impl.markWorkSpecScheduled(currentTimeMillis, ((WorkSpec) it.next()).id);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (eligibleWorkForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                    for (Scheduler scheduler : schedulers) {
                        if (scheduler.hasLimitedSchedulingSlots()) {
                            scheduler.schedule(workSpecArr);
                        }
                    }
                }
                if (allEligibleWorkSpecsForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                    for (Scheduler scheduler2 : schedulers) {
                        if (!scheduler2.hasLimitedSchedulingSlots()) {
                            scheduler2.schedule(workSpecArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
