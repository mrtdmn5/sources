package com.google.firebase.remoteconfig.internal;

import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ConfigCacheClient {
    public zzw cachedContainerTask = null;
    public final Executor executor;
    public final ConfigStorageClient storageClient;
    public static final HashMap clientInstances = new HashMap();
    public static final ProfileInstallReceiver$$ExternalSyntheticLambda0 DIRECT_EXECUTOR = new ProfileInstallReceiver$$ExternalSyntheticLambda0();

    /* loaded from: classes3.dex */
    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {
        public final CountDownLatch latch = new CountDownLatch(1);

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.latch.countDown();
        }
    }

    public ConfigCacheClient(Executor executor, ConfigStorageClient configStorageClient) {
        this.executor = executor;
        this.storageClient = configStorageClient;
    }

    public static Object await(Task task, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (awaitListener.latch.await(5L, timeUnit)) {
            if (task.isSuccessful()) {
                return task.getResult();
            }
            throw new ExecutionException(task.getException());
        }
        throw new TimeoutException("Task await timed out.");
    }

    public final synchronized Task<ConfigContainer> get() {
        zzw zzwVar = this.cachedContainerTask;
        if (zzwVar == null || (zzwVar.isComplete() && !this.cachedContainerTask.isSuccessful())) {
            Executor executor = this.executor;
            final ConfigStorageClient configStorageClient = this.storageClient;
            Objects.requireNonNull(configStorageClient);
            this.cachedContainerTask = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    FileInputStream fileInputStream;
                    ConfigContainer configContainer;
                    ConfigStorageClient configStorageClient2 = ConfigStorageClient.this;
                    synchronized (configStorageClient2) {
                        FileInputStream fileInputStream2 = null;
                        configContainer = null;
                        try {
                            fileInputStream = configStorageClient2.context.openFileInput(configStorageClient2.fileName);
                            try {
                                int available = fileInputStream.available();
                                byte[] bArr = new byte[available];
                                fileInputStream.read(bArr, 0, available);
                                configContainer = ConfigContainer.copyOf(new JSONObject(new String(bArr, Constants.DEFAULT_ENCODING)));
                                fileInputStream.close();
                            } catch (FileNotFoundException | JSONException unused) {
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return configContainer;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException | JSONException unused2) {
                            fileInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return configContainer;
                }
            });
        }
        return this.cachedContainerTask;
    }

    public final Task<ConfigContainer> put(final ConfigContainer configContainer) {
        Callable callable = new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ConfigCacheClient configCacheClient = ConfigCacheClient.this;
                ConfigContainer configContainer2 = configContainer;
                ConfigStorageClient configStorageClient = configCacheClient.storageClient;
                synchronized (configStorageClient) {
                    FileOutputStream openFileOutput = configStorageClient.context.openFileOutput(configStorageClient.fileName, 0);
                    try {
                        openFileOutput.write(configContainer2.toString().getBytes(Constants.DEFAULT_ENCODING));
                    } finally {
                        openFileOutput.close();
                    }
                }
                return null;
            }
        };
        Executor executor = this.executor;
        return Tasks.call(executor, callable).onSuccessTask(executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda2
            public final /* synthetic */ boolean f$1 = true;

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                ConfigCacheClient configCacheClient = ConfigCacheClient.this;
                boolean z = this.f$1;
                ConfigContainer configContainer2 = configContainer;
                if (z) {
                    synchronized (configCacheClient) {
                        configCacheClient.cachedContainerTask = Tasks.forResult(configContainer2);
                    }
                } else {
                    configCacheClient.getClass();
                }
                return Tasks.forResult(configContainer2);
            }
        });
    }
}
