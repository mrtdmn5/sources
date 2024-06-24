package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class WithinAppServiceConnection implements ServiceConnection {
    public WithinAppServiceBinder binder;
    public boolean connectionInProgress;
    public final Intent connectionIntent;
    public final Context context;
    public final ArrayDeque intentQueue;
    public final ScheduledExecutorService scheduledExecutorService;

    /* loaded from: classes3.dex */
    public static class BindRequest {
        public final Intent intent;
        public final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        public BindRequest(Intent intent) {
            this.intent = intent;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public WithinAppServiceConnection(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledThreadPoolExecutor;
    }

    public final synchronized void flushQueue() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.intentQueue.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            WithinAppServiceBinder withinAppServiceBinder = this.binder;
            if (withinAppServiceBinder != null && withinAppServiceBinder.isBinderAlive()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.binder.send((BindRequest) this.intentQueue.poll());
            } else {
                startConnectionIfNeeded();
                return;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            while (true) {
                ArrayDeque arrayDeque = this.intentQueue;
                if (!arrayDeque.isEmpty()) {
                    ((BindRequest) arrayDeque.poll()).taskCompletionSource.trySetResult(null);
                } else {
                    return;
                }
            }
        } else {
            this.binder = (WithinAppServiceBinder) iBinder;
            flushQueue();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        flushQueue();
    }

    public final synchronized zzw sendIntent(Intent intent) {
        final BindRequest bindRequest;
        boolean z;
        long j;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        bindRequest = new BindRequest(intent);
        ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
        if ((bindRequest.intent.getFlags() & 268435456) != 0) {
            z = true;
        } else {
            z = false;
        }
        Runnable runnable = new Runnable() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb = new StringBuilder("Service took too long to process intent: ");
                WithinAppServiceConnection.BindRequest bindRequest2 = WithinAppServiceConnection.BindRequest.this;
                sb.append(bindRequest2.intent.getAction());
                sb.append(" Releasing WakeLock.");
                Log.w("FirebaseMessaging", sb.toString());
                bindRequest2.taskCompletionSource.trySetResult(null);
            }
        };
        if (z) {
            j = WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
        } else {
            j = 9000;
        }
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        bindRequest.taskCompletionSource.zza.addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                schedule.cancel(false);
            }
        });
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.taskCompletionSource.zza;
    }

    public final void startConnectionIfNeeded() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.connectionInProgress);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.connectionInProgress) {
            return;
        }
        this.connectionInProgress = true;
        try {
        } catch (SecurityException e) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e);
        }
        if (ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.connectionInProgress = false;
        while (true) {
            ArrayDeque arrayDeque = this.intentQueue;
            if (!arrayDeque.isEmpty()) {
                ((BindRequest) arrayDeque.poll()).taskCompletionSource.trySetResult(null);
            } else {
                return;
            }
        }
    }
}
