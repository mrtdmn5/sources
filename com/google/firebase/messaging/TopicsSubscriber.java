package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class TopicsSubscriber {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public final Context context;
    public final FirebaseMessaging firebaseMessaging;
    public final Metadata metadata;
    public final GmsRpc rpc;
    public final TopicsStore store;
    public final ScheduledExecutorService syncExecutor;
    public final ArrayMap pendingOperations = new ArrayMap();
    public boolean syncScheduledOrRunning = false;

    public TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context;
        this.syncExecutor = scheduledExecutorService;
    }

    public static <T> void awaitTask(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e2);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public static boolean isDebugLogEnabled() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return false;
        }
        return true;
    }

    public final void blockingSubscribeToTopic(String str) throws IOException {
        String blockingGetToken = this.firebaseMessaging.blockingGetToken();
        GmsRpc gmsRpc = this.rpc;
        gmsRpc.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(blockingGetToken, "/topics/" + str, bundle)));
    }

    public final void blockingUnsubscribeFromTopic(String str) throws IOException {
        String blockingGetToken = this.firebaseMessaging.blockingGetToken();
        GmsRpc gmsRpc = this.rpc;
        gmsRpc.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(blockingGetToken, "/topics/" + str, bundle)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x000e, code lost:            if (isDebugLogEnabled() == false) goto L8;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0010, code lost:            android.util.Log.d("FirebaseMessaging", "topic sync succeeded");     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0018, code lost:            return true;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0087 A[Catch: IOException -> 0x00a3, TryCatch #1 {IOException -> 0x00a3, blocks: (B:8:0x0023, B:17:0x004f, B:19:0x0055, B:66:0x006b, B:68:0x0074, B:69:0x0087, B:71:0x0090, B:72:0x0032, B:75:0x003c), top: B:7:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean syncTopics() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public final void syncWithDelaySecondsInternal(long j) {
        this.syncExecutor.schedule(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, 2 * j), MAX_DELAY_SEC)), j, TimeUnit.SECONDS);
        synchronized (this) {
            this.syncScheduledOrRunning = true;
        }
    }
}
