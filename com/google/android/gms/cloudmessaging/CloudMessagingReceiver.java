package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    public final ExecutorService zza;

    public CloudMessagingReceiver() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zze
            @Override // java.lang.Runnable
            public final void run() {
                Intent intent2;
                int zzb;
                Intent intent3 = intent;
                BroadcastReceiver.PendingResult pendingResult = goAsync;
                CloudMessagingReceiver cloudMessagingReceiver = CloudMessagingReceiver.this;
                cloudMessagingReceiver.getClass();
                try {
                    Parcelable parcelableExtra = intent3.getParcelableExtra("wrapped_intent");
                    if (parcelableExtra instanceof Intent) {
                        intent2 = (Intent) parcelableExtra;
                    } else {
                        intent2 = null;
                    }
                    Context context2 = context;
                    if (intent2 != null) {
                        zzb = cloudMessagingReceiver.zzc(context2, intent2);
                    } else {
                        zzb = cloudMessagingReceiver.zzb(context2, intent3);
                    }
                    if (isOrderedBroadcast) {
                        pendingResult.setResultCode(zzb);
                    }
                } finally {
                    pendingResult.finish();
                }
            }
        });
    }

    public final int zzb(Context context, Intent intent) {
        int r3;
        com.google.android.gms.tasks.zzw zzg;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            zzg = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            zzs zzb = zzs.zzb(context);
            synchronized (zzb) {
                r3 = zzb.zze;
                zzb.zze = r3 + 1;
            }
            zzg = zzb.zzg(new zzo(r3, bundle));
        }
        int onMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            Tasks.await(zzg, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(valueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return onMessageReceive;
    }

    public final int zzc(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            onNotificationDismissed(extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    public void onNotificationDismissed(Bundle bundle) {
    }
}
