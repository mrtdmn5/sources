package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda0;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class FirebaseMessaging {
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public static Store store;
    public static ScheduledThreadPoolExecutor syncExecutor;

    @SuppressLint({"FirebaseUnknownNullness"})
    public static TransportFactory transportFactory;
    public final AutoInit autoInit;
    public final Context context;
    public final Executor fileExecutor;
    public final FirebaseApp firebaseApp;
    public final FirebaseInstallationsApi fis;
    public final GmsRpc gmsRpc;
    public final FirebaseInstanceIdInternal iid;
    public final Executor initExecutor;
    public final Metadata metadata;
    public final RequestDeduplicator requestDeduplicator;
    public boolean syncScheduledOrRunning;

    /* loaded from: classes3.dex */
    public class AutoInit {
        public Boolean autoInitEnabled;
        public boolean initialized;
        public final Subscriber subscriber;

        public AutoInit(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0] */
        public final synchronized void initialize() {
            if (this.initialized) {
                return;
            }
            Boolean readEnabled = readEnabled();
            this.autoInitEnabled = readEnabled;
            if (readEnabled == null) {
                this.subscriber.subscribe(new EventHandler() { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0
                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        boolean isDataCollectionDefaultEnabled;
                        FirebaseMessaging.AutoInit autoInit = FirebaseMessaging.AutoInit.this;
                        synchronized (autoInit) {
                            autoInit.initialize();
                            Boolean bool = autoInit.autoInitEnabled;
                            if (bool != null) {
                                isDataCollectionDefaultEnabled = bool.booleanValue();
                            } else {
                                isDataCollectionDefaultEnabled = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
                            }
                        }
                        if (isDataCollectionDefaultEnabled) {
                            Store store = FirebaseMessaging.store;
                            FirebaseMessaging.this.startSyncIfNecessary();
                        }
                    }
                });
            }
            this.initialized = true;
        }

        public final Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            FirebaseApp firebaseApp = FirebaseMessaging.this.firebaseApp;
            firebaseApp.checkNotDeleted();
            Context context = firebaseApp.applicationContext;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging() {
        throw null;
    }

    public FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        firebaseApp.checkNotDeleted();
        Context context = firebaseApp.applicationContext;
        final Metadata metadata = new Metadata(context);
        final GmsRpc gmsRpc = new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-File-Io"));
        int r5 = 0;
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        firebaseApp.checkNotDeleted();
        final Context context2 = firebaseApp.applicationContext;
        this.context = context2;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.metadata = metadata;
        this.gmsRpc = gmsRpc;
        this.requestDeduplicator = new RequestDeduplicator(newSingleThreadExecutor);
        this.initExecutor = scheduledThreadPoolExecutor;
        this.fileExecutor = threadPoolExecutor;
        firebaseApp.checkNotDeleted();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener();
        }
        scheduledThreadPoolExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                boolean isDataCollectionDefaultEnabled;
                Store store2 = FirebaseMessaging.store;
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.this;
                FirebaseMessaging.AutoInit autoInit = firebaseMessaging.autoInit;
                synchronized (autoInit) {
                    autoInit.initialize();
                    Boolean bool = autoInit.autoInitEnabled;
                    if (bool != null) {
                        isDataCollectionDefaultEnabled = bool.booleanValue();
                    } else {
                        isDataCollectionDefaultEnabled = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
                    }
                }
                if (isDataCollectionDefaultEnabled) {
                    firebaseMessaging.startSyncIfNecessary();
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
        int r3 = TopicsSubscriber.$r8$clinit;
        Tasks.call(scheduledThreadPoolExecutor2, new Callable() { // from class: com.google.firebase.messaging.TopicsSubscriber$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsStore topicsStore;
                Context context3 = context2;
                ScheduledExecutorService scheduledExecutorService = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                Metadata metadata2 = metadata;
                GmsRpc gmsRpc2 = gmsRpc;
                synchronized (TopicsStore.class) {
                    WeakReference<TopicsStore> weakReference = TopicsStore.topicsStoreWeakReference;
                    if (weakReference != null) {
                        topicsStore = weakReference.get();
                    } else {
                        topicsStore = null;
                    }
                    if (topicsStore == null) {
                        SharedPreferences sharedPreferences = context3.getSharedPreferences("com.google.android.gms.appid", 0);
                        TopicsStore topicsStore2 = new TopicsStore(sharedPreferences, scheduledExecutorService);
                        synchronized (topicsStore2) {
                            topicsStore2.topicOperationsQueue = SharedPreferencesQueue.createInstance(sharedPreferences, scheduledExecutorService);
                        }
                        TopicsStore.topicsStoreWeakReference = new WeakReference<>(topicsStore2);
                        topicsStore = topicsStore2;
                    }
                }
                return new TopicsSubscriber(firebaseMessaging, metadata2, topicsStore, gmsRpc2, context3, scheduledExecutorService);
            }
        }).addOnSuccessListener(scheduledThreadPoolExecutor, new OnSuccessListener() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                boolean isDataCollectionDefaultEnabled;
                boolean z;
                boolean z2;
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.this;
                TopicsSubscriber topicsSubscriber = (TopicsSubscriber) obj;
                Store store2 = FirebaseMessaging.store;
                FirebaseMessaging.AutoInit autoInit = firebaseMessaging.autoInit;
                synchronized (autoInit) {
                    autoInit.initialize();
                    Boolean bool = autoInit.autoInitEnabled;
                    if (bool != null) {
                        isDataCollectionDefaultEnabled = bool.booleanValue();
                    } else {
                        isDataCollectionDefaultEnabled = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
                    }
                }
                if (isDataCollectionDefaultEnabled) {
                    if (topicsSubscriber.store.getNextTopicOperation() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        synchronized (topicsSubscriber) {
                            z2 = topicsSubscriber.syncScheduledOrRunning;
                        }
                        if (!z2) {
                            topicsSubscriber.syncWithDelaySecondsInternal(0L);
                        }
                    }
                }
            }
        });
        scheduledThreadPoolExecutor.execute(new FirebaseMessaging$$ExternalSyntheticLambda2(r5, this));
    }

    @SuppressLint({"ThreadPoolCreation"})
    public static void enqueueTaskWithDelaySeconds(SyncTask syncTask, long j) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(syncTask, j, TimeUnit.SECONDS);
        }
    }

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.getInstance());
        }
        return firebaseMessaging;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String blockingGetToken() throws IOException {
        Task task;
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException(e);
            }
        }
        final Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return tokenWithoutTriggeringSync.token;
        }
        final String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        RequestDeduplicator requestDeduplicator = this.requestDeduplicator;
        synchronized (requestDeduplicator) {
            task = (Task) requestDeduplicator.getTokenRequests.getOrDefault(defaultSenderId, null);
            if (task != null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Joining ongoing request for: " + defaultSenderId);
                }
            } else {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + defaultSenderId);
                }
                GmsRpc gmsRpc = this.gmsRpc;
                task = gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(Metadata.getDefaultSenderId(gmsRpc.f142app), "*", new Bundle())).onSuccessTask(this.fileExecutor, new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4
                    @Override // com.google.android.gms.tasks.SuccessContinuation
                    public final Task then(Object obj) {
                        Store store2;
                        String persistenceKey;
                        String str;
                        FirebaseMessaging firebaseMessaging = FirebaseMessaging.this;
                        String str2 = defaultSenderId;
                        Store.Token token = tokenWithoutTriggeringSync;
                        String str3 = (String) obj;
                        Context context = firebaseMessaging.context;
                        synchronized (FirebaseMessaging.class) {
                            if (FirebaseMessaging.store == null) {
                                FirebaseMessaging.store = new Store(context);
                            }
                            store2 = FirebaseMessaging.store;
                        }
                        FirebaseApp firebaseApp = firebaseMessaging.firebaseApp;
                        firebaseApp.checkNotDeleted();
                        if ("[DEFAULT]".equals(firebaseApp.name)) {
                            persistenceKey = "";
                        } else {
                            persistenceKey = firebaseApp.getPersistenceKey();
                        }
                        Metadata metadata = firebaseMessaging.metadata;
                        synchronized (metadata) {
                            if (metadata.appVersionCode == null) {
                                metadata.populateAppVersionInfo();
                            }
                            str = metadata.appVersionCode;
                        }
                        synchronized (store2) {
                            String encode = Store.Token.encode(str3, str, System.currentTimeMillis());
                            if (encode != null) {
                                SharedPreferences.Editor edit = store2.store.edit();
                                edit.putString(persistenceKey + "|T|" + str2 + "|*", encode);
                                edit.commit();
                            }
                        }
                        if (token == null || !str3.equals(token.token)) {
                            FirebaseApp firebaseApp2 = firebaseMessaging.firebaseApp;
                            firebaseApp2.checkNotDeleted();
                            if ("[DEFAULT]".equals(firebaseApp2.name)) {
                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                                    firebaseApp2.checkNotDeleted();
                                    sb.append(firebaseApp2.name);
                                    Log.d("FirebaseMessaging", sb.toString());
                                }
                                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                                intent.putExtra(AWSCognitoLegacyCredentialStore.TOKEN_KEY, str3);
                                new FcmBroadcastProcessor(firebaseMessaging.context).process(intent);
                            }
                        }
                        return Tasks.forResult(str3);
                    }
                }).continueWithTask(requestDeduplicator.executor, new MainActivity$$ExternalSyntheticLambda0(requestDeduplicator, defaultSenderId));
                requestDeduplicator.getTokenRequests.put(defaultSenderId, task);
            }
        }
        try {
            return (String) Tasks.await(task);
        } catch (InterruptedException | ExecutionException e2) {
            throw new IOException(e2);
        }
    }

    public final Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                Store store2 = FirebaseMessaging.store;
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.this;
                firebaseMessaging.getClass();
                try {
                    taskCompletionSource2.setResult(firebaseMessaging.blockingGetToken());
                } catch (Exception e) {
                    taskCompletionSource2.setException(e);
                }
            }
        });
        return taskCompletionSource.zza;
    }

    public final Store.Token getTokenWithoutTriggeringSync() {
        Store store2;
        String persistenceKey;
        Store.Token parse;
        Context context = this.context;
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(context);
            }
            store2 = store;
        }
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        if ("[DEFAULT]".equals(firebaseApp.name)) {
            persistenceKey = "";
        } else {
            persistenceKey = firebaseApp.getPersistenceKey();
        }
        String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        synchronized (store2) {
            parse = Store.Token.parse(store2.store.getString(persistenceKey + "|T|" + defaultSenderId + "|*", null));
        }
        return parse;
    }

    public final void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            synchronized (this) {
                if (!this.syncScheduledOrRunning) {
                    syncWithDelaySecondsInternal(0L);
                }
            }
        }
    }

    public final synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, 2 * j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public final boolean tokenNeedsRefresh(Store.Token token) {
        String str;
        boolean z;
        if (token == null) {
            return true;
        }
        Metadata metadata = this.metadata;
        synchronized (metadata) {
            if (metadata.appVersionCode == null) {
                metadata.populateAppVersionInfo();
            }
            str = metadata.appVersionCode;
        }
        if (System.currentTimeMillis() <= token.timestamp + Store.Token.REFRESH_PERIOD_MILLIS && str.equals(token.appVersion)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }
}
