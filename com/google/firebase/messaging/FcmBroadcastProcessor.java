package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.watch.account.HttpUtilsKt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class FcmBroadcastProcessor {
    public static WithinAppServiceConnection fcmServiceConn;
    public static final Object lock = new Object();
    public final Context context;
    public final ProfileInstallReceiver$$ExternalSyntheticLambda0 executor = new ProfileInstallReceiver$$ExternalSyntheticLambda0();

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
    }

    public static zzw bindToMessagingService(Context context, final Intent intent) {
        WithinAppServiceConnection withinAppServiceConnection;
        WithinAppServiceConnection withinAppServiceConnection2;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context)) {
            synchronized (lock) {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new WithinAppServiceConnection(context);
                }
                withinAppServiceConnection2 = fcmServiceConn;
            }
            synchronized (WakeLockHolder.syncObject) {
                if (WakeLockHolder.wakeLock == null) {
                    WakeLock wakeLock = new WakeLock(context);
                    WakeLockHolder.wakeLock = wakeLock;
                    synchronized (wakeLock.zzf) {
                        wakeLock.zzl = true;
                    }
                }
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                if (!booleanExtra) {
                    WakeLockHolder.wakeLock.acquire(WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                withinAppServiceConnection2.sendIntent(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.WakeLockHolder$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        WakeLockHolder.completeWakefulIntent(intent);
                    }
                });
            }
        } else {
            synchronized (lock) {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new WithinAppServiceConnection(context);
                }
                withinAppServiceConnection = fcmServiceConn;
            }
            withinAppServiceConnection.sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    public final Task<Integer> process(final Intent intent) {
        boolean z;
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z2 = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        boolean isAtLeastO = PlatformVersion.isAtLeastO();
        final Context context = this.context;
        if (isAtLeastO && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        } else {
            z = false;
        }
        if ((intent.getFlags() & 268435456) != 0) {
            z2 = true;
        }
        if (z && !z2) {
            return bindToMessagingService(context, intent);
        }
        Callable callable = new Callable() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int r0;
                ComponentName startService;
                Context context2 = context;
                Intent intent2 = intent;
                ServiceStarter serviceStarter = ServiceStarter.getInstance();
                serviceStarter.getClass();
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Starting service");
                }
                serviceStarter.messagingEvents.offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (serviceStarter) {
                    str = serviceStarter.firebaseMessagingServiceClassName;
                    if (str == null) {
                        ResolveInfo resolveService = context2.getPackageManager().resolveService(intent3, 0);
                        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                            if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                if (str2.startsWith(InstructionFileId.DOT)) {
                                    serviceStarter.firebaseMessagingServiceClassName = context2.getPackageName() + serviceInfo.name;
                                } else {
                                    serviceStarter.firebaseMessagingServiceClassName = serviceInfo.name;
                                }
                                str = serviceStarter.firebaseMessagingServiceClassName;
                            }
                            Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                            str = null;
                        }
                        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                        str = null;
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (serviceStarter.hasWakeLockPermission(context2)) {
                        startService = WakeLockHolder.startWakefulService(context2, intent3);
                    } else {
                        startService = context2.startService(intent3);
                        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
                    }
                    if (startService == null) {
                        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                        r0 = com.amazonaws.services.s3.internal.Constants.NO_SUCH_BUCKET_STATUS_CODE;
                    } else {
                        r0 = -1;
                    }
                } catch (IllegalStateException e) {
                    Log.e("FirebaseMessaging", "Failed to start service while in background: " + e);
                    r0 = 402;
                } catch (SecurityException e2) {
                    Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e2);
                    r0 = HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE;
                }
                return Integer.valueOf(r0);
            }
        };
        ProfileInstallReceiver$$ExternalSyntheticLambda0 profileInstallReceiver$$ExternalSyntheticLambda0 = this.executor;
        return Tasks.call(profileInstallReceiver$$ExternalSyntheticLambda0, callable).continueWithTask(profileInstallReceiver$$ExternalSyntheticLambda0, new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) {
                    return FcmBroadcastProcessor.bindToMessagingService(context, intent).continueWith(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new FcmBroadcastProcessor$$ExternalSyntheticLambda2());
                }
                return task;
            }
        });
    }
}
