package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import androidx.core.os.UserManagerCompat$Api24Impl;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class FirebaseApp {
    public final Context applicationContext;
    public final ComponentRuntime componentRuntime;
    public final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    public final Provider<DefaultHeartBeatController> defaultHeartBeatController;
    public final String name;
    public final FirebaseOptions options;
    public static final Object LOCK = new Object();
    public static final ArrayMap INSTANCES = new ArrayMap();
    public final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    public final AtomicBoolean deleted = new AtomicBoolean();
    public final CopyOnWriteArrayList backgroundStateChangeListeners = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    /* loaded from: classes3.dex */
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
        public static final AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public final void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it2 = firebaseApp.backgroundStateChangeListeners.iterator();
                        while (it2.hasNext()) {
                            ((BackgroundStateChangeListener) it2.next()).onBackgroundStateChanged(z);
                        }
                    }
                }
            }
        }
    }

    @TargetApi(24)
    /* loaded from: classes3.dex */
    public static class UserUnlockReceiver extends BroadcastReceiver {
        public static final AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
        public final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = ((MapCollections.ValuesCollection) FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    ((FirebaseApp) it.next()).initializeAllApis();
                }
            }
            this.applicationContext.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00be A[LOOP:0: B:10:0x00b8->B:12:0x00be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0073  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FirebaseApp(final android.content.Context r9, com.google.firebase.FirebaseOptions r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.<init>(android.content.Context, com.google.firebase.FirebaseOptions, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = (FirebaseApp) INSTANCES.getOrDefault("[DEFAULT]", null);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (LOCK) {
            if (INSTANCES.containsKey("[DEFAULT]")) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    public final void checkNotDeleted() {
        Preconditions.checkState("FirebaseApp was deleted", !this.deleted.get());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        FirebaseApp firebaseApp = (FirebaseApp) obj;
        firebaseApp.checkNotDeleted();
        return this.name.equals(firebaseApp.name);
    }

    public final <T> T get(Class<T> cls) {
        checkNotDeleted();
        return (T) this.componentRuntime.get(cls);
    }

    public final String getPersistenceKey() {
        String encodeToString;
        StringBuilder sb = new StringBuilder();
        checkNotDeleted();
        byte[] bytes = this.name.getBytes(Charset.defaultCharset());
        String str = null;
        if (bytes == null) {
            encodeToString = null;
        } else {
            encodeToString = Base64.encodeToString(bytes, 11);
        }
        sb.append(encodeToString);
        sb.append("+");
        checkNotDeleted();
        byte[] bytes2 = this.options.applicationId.getBytes(Charset.defaultCharset());
        if (bytes2 != null) {
            str = Base64.encodeToString(bytes2, 11);
        }
        sb.append(str);
        return sb.toString();
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final void initializeAllApis() {
        HashMap hashMap;
        boolean z = true;
        if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            checkNotDeleted();
            sb.append(this.name);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.applicationContext;
            AtomicReference<UserUnlockReceiver> atomicReference = UserUnlockReceiver.INSTANCE;
            if (atomicReference.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                while (true) {
                    if (atomicReference.compareAndSet(null, userUnlockReceiver)) {
                        break;
                    } else if (atomicReference.get() != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        checkNotDeleted();
        sb2.append(this.name);
        Log.i("FirebaseApp", sb2.toString());
        ComponentRuntime componentRuntime = this.componentRuntime;
        checkNotDeleted();
        boolean equals = "[DEFAULT]".equals(this.name);
        AtomicReference<Boolean> atomicReference2 = componentRuntime.eagerComponentsInitializedWith;
        Boolean valueOf = Boolean.valueOf(equals);
        while (true) {
            if (atomicReference2.compareAndSet(null, valueOf)) {
                break;
            } else if (atomicReference2.get() != null) {
                z = false;
                break;
            }
        }
        if (z) {
            synchronized (componentRuntime) {
                hashMap = new HashMap(componentRuntime.components);
            }
            componentRuntime.doInitializeEagerComponents(hashMap, equals);
        }
        this.defaultHeartBeatController.get().registerHeartBeat();
    }

    public final boolean isDataCollectionDefaultEnabled() {
        boolean z;
        checkNotDeleted();
        DataCollectionConfigStorage dataCollectionConfigStorage = this.dataCollectionConfigStorage.get();
        synchronized (dataCollectionConfigStorage) {
            z = dataCollectionConfigStorage.dataCollectionDefaultEnabled;
        }
        return z;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.name, "name");
        toStringHelper.add(this.options, "options");
        return toStringHelper.toString();
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        FirebaseApp firebaseApp;
        boolean z;
        AtomicReference<GlobalBackgroundStateListener> atomicReference = GlobalBackgroundStateListener.INSTANCE;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<GlobalBackgroundStateListener> atomicReference2 = GlobalBackgroundStateListener.INSTANCE;
            if (atomicReference2.get() == null) {
                GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                while (true) {
                    if (atomicReference2.compareAndSet(null, globalBackgroundStateListener)) {
                        z = true;
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    synchronized (backgroundDetector) {
                        if (!backgroundDetector.zze) {
                            application.registerActivityLifecycleCallbacks(backgroundDetector);
                            application.registerComponentCallbacks(backgroundDetector);
                            backgroundDetector.zze = true;
                        }
                    }
                    backgroundDetector.getClass();
                    synchronized (backgroundDetector) {
                        backgroundDetector.zzd.add(globalBackgroundStateListener);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            ArrayMap arrayMap = INSTANCES;
            Preconditions.checkState("FirebaseApp name [DEFAULT] already exists!", true ^ arrayMap.containsKey("[DEFAULT]"));
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, firebaseOptions, "[DEFAULT]");
            arrayMap.put("[DEFAULT]", firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
