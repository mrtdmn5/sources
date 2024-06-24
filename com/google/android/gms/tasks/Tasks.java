package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class Tasks {
    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
        if (task != null) {
            if (task.isComplete()) {
                return (TResult) zza(task);
            }
            zzad zzadVar = new zzad();
            zzt zztVar = TaskExecutors.zza;
            task.addOnSuccessListener(zztVar, zzadVar);
            task.addOnFailureListener(zztVar, zzadVar);
            task.addOnCanceledListener(zztVar, zzadVar);
            zzadVar.zza.await();
            return (TResult) zza(task);
        }
        throw new NullPointerException("Task must not be null");
    }

    @Deprecated
    public static zzw call(Executor executor, Callable callable) {
        if (executor != null) {
            zzw zzwVar = new zzw();
            executor.execute(new zzz(zzwVar, callable));
            return zzwVar;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public static zzw forException(Exception exc) {
        zzw zzwVar = new zzw();
        zzwVar.zza(exc);
        return zzwVar;
    }

    public static zzw forResult(Object obj) {
        zzw zzwVar = new zzw();
        zzwVar.zzb(obj);
        return zzwVar;
    }

    public static zzw whenAll(List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Task) it.next()) == null) {
                    throw new NullPointerException("null tasks are not accepted");
                }
            }
            zzw zzwVar = new zzw();
            zzaf zzafVar = new zzaf(list.size(), zzwVar);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Task task = (Task) it2.next();
                zzt zztVar = TaskExecutors.zza;
                task.addOnSuccessListener(zztVar, zzafVar);
                task.addOnFailureListener(zztVar, zzafVar);
                task.addOnCanceledListener(zztVar, zzafVar);
            }
            return zzwVar;
        }
        return forResult(null);
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        if (taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        List asList = Arrays.asList(taskArr);
        if (asList != null && !asList.isEmpty()) {
            List list = asList;
            return whenAll(list).continueWithTask(TaskExecutors.MAIN_THREAD, new zzab(list));
        }
        return forResult(Collections.emptyList());
    }

    public static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
        if (task == null) {
            throw new NullPointerException("Task must not be null");
        }
        if (timeUnit != null) {
            if (task.isComplete()) {
                return (TResult) zza(task);
            }
            zzad zzadVar = new zzad();
            zzt zztVar = TaskExecutors.zza;
            task.addOnSuccessListener(zztVar, zzadVar);
            task.addOnFailureListener(zztVar, zzadVar);
            task.addOnCanceledListener(zztVar, zzadVar);
            if (zzadVar.zza.await(j, timeUnit)) {
                return (TResult) zza(task);
            }
            throw new TimeoutException("Timed out waiting for Task");
        }
        throw new NullPointerException("TimeUnit must not be null");
    }
}
