package com.animaconnected.secondo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.AmplifyConfiguration;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.AppAnalytics;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.app.RestartReceiver;
import com.animaconnected.secondo.behaviour.distress.notifications.StateNotificationReciever;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.campaign.CampaignProvider;
import com.animaconnected.secondo.provider.stopwatch.StopwatchProvider;
import com.animaconnected.secondo.screens.onboarding.OnboardingActivity;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.animaconnected.secondo.utils.debugging.DogfoodLogger;
import com.animaconnected.secondo.utils.debugging.LoggerAndroid;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import java.lang.Thread;
import kotlin.ExceptionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: KronabyApplication.kt */
/* loaded from: classes.dex */
public final class KronabyApplication extends Application {
    private static KronabyApplication application;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static final CoroutineScope scope;
    private boolean initDone;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: KronabyApplication.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createStartApplicationIntent() {
            return new Intent(getContext(), (Class<?>) OnboardingActivity.class);
        }

        public final KronabyApplication getApplication() {
            KronabyApplication kronabyApplication = KronabyApplication.application;
            if (kronabyApplication != null) {
                return kronabyApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("application");
            throw null;
        }

        public final Context getContext() {
            Context applicationContext = getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return applicationContext;
        }

        public final CoroutineScope getScope() {
            return KronabyApplication.scope;
        }

        public final void initialize() {
            getApplication().onInitializeCalled();
        }

        private Companion() {
        }

        public static /* synthetic */ void getApplication$annotations() {
        }

        public static /* synthetic */ void getContext$annotations() {
        }

        public static /* synthetic */ void getScope$annotations() {
        }
    }

    static {
        KronabyApplication$special$$inlined$CoroutineExceptionHandler$1 kronabyApplication$special$$inlined$CoroutineExceptionHandler$1 = new KronabyApplication$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE);
        exceptionHandler = kronabyApplication$special$$inlined$CoroutineExceptionHandler$1;
        SupervisorJobImpl SupervisorJob$default = SupervisorKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        scope = new ContextScope(SupervisorJob$default.plus(MainDispatcherLoader.dispatcher).plus(kronabyApplication$special$$inlined$CoroutineExceptionHandler$1));
    }

    public static final Intent createStartApplicationIntent() {
        return Companion.createStartApplicationIntent();
    }

    public static final KronabyApplication getApplication() {
        return Companion.getApplication();
    }

    public static final Context getContext() {
        return Companion.getContext();
    }

    public static final CoroutineScope getScope() {
        return Companion.getScope();
    }

    public static final void initialize() {
        Companion.initialize();
    }

    public final void onInitializeCalled() {
        Boolean dataCollectionValueFromManifest;
        ThreadUtils.assertIsOnMainThread();
        if (this.initDone) {
            return;
        }
        this.initDone = true;
        LogKt.info$default((Object) this, "KronabyApplication", (Throwable) null, true, (Function0) KronabyApplication$onInitializeCalled$1.INSTANCE, 2, (Object) null);
        ConnectionFactory.setContext(getApplicationContext());
        CrashlyticsCore crashlyticsCore = FirebaseCrashlytics.getInstance().core;
        Boolean bool = Boolean.TRUE;
        DataCollectionArbiter dataCollectionArbiter = crashlyticsCore.dataCollectionArbiter;
        synchronized (dataCollectionArbiter) {
            if (bool != null) {
                try {
                    dataCollectionArbiter.setInManifest = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                dataCollectionValueFromManifest = bool;
            } else {
                FirebaseApp firebaseApp = dataCollectionArbiter.firebaseApp;
                firebaseApp.checkNotDeleted();
                dataCollectionValueFromManifest = dataCollectionArbiter.getDataCollectionValueFromManifest(firebaseApp.applicationContext);
            }
            dataCollectionArbiter.crashlyticsDataCollectionEnabled = dataCollectionValueFromManifest;
            SharedPreferences.Editor edit = dataCollectionArbiter.sharedPreferences.edit();
            if (bool != null) {
                edit.putBoolean("firebase_crashlytics_collection_enabled", true);
            } else {
                edit.remove("firebase_crashlytics_collection_enabled");
            }
            edit.apply();
            synchronized (dataCollectionArbiter.taskLock) {
                if (dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                    if (!dataCollectionArbiter.taskResolved) {
                        dataCollectionArbiter.dataCollectionEnabledTask.trySetResult(null);
                        dataCollectionArbiter.taskResolved = true;
                    }
                } else if (dataCollectionArbiter.taskResolved) {
                    dataCollectionArbiter.dataCollectionEnabledTask = new TaskCompletionSource<>();
                    dataCollectionArbiter.taskResolved = false;
                }
            }
        }
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        providerFactory.registerMessageReceiver(LogRequestReceiver.NAME, new LogRequestReceiver());
        Companion companion = Companion;
        new AppAnalytics(companion.getContext()).init();
        ProviderFactory.getNotificationProvider().refresh();
        RemoteConfigController companion2 = RemoteConfigController.Companion.getInstance(companion.getContext());
        companion2.init();
        if ((companion2.getDebuggingEnabled() || UserCategoryKt.useDogfoodingLogger(ProviderFactory.getWatch().getUserCategory())) && !(LogKt.getCurrentLogger() instanceof DogfoodLogger)) {
            LogKt.prepareLogger(new DogfoodLogger(companion.getContext()));
        }
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.animaconnected.secondo.KronabyApplication$$ExternalSyntheticLambda0
            public final /* synthetic */ Thread.UncaughtExceptionHandler f$1;

            public /* synthetic */ KronabyApplication$$ExternalSyntheticLambda0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                r2 = uncaughtExceptionHandler;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th2) {
                KronabyApplication.onInitializeCalled$lambda$2(KronabyApplication.this, r2, thread, th2);
            }
        });
        setupAmplify();
        companion.getContext().registerReceiver(new RestartReceiver(), new IntentFilter("android.intent.action.MY_PACKAGE_REPLACED"));
        providerFactory.getGoogleFitProvider();
        StateNotificationReciever.getInstance(companion.getContext());
        ProviderFactory.getStatusProvider();
        ProviderFactory.getLostWatchProvider();
        ProviderFactory.getWatchFotaProvider();
        StopwatchProvider.getInstance();
        NotificationUtils.setupNotificationChannelIfNeeded(companion.getContext());
        providerFactory.getCallStateReceiver();
        companion2.registerListener(CampaignProvider.INSTANCE);
        providerFactory.getCloudAccountProvider();
    }

    public static final void onInitializeCalled$lambda$2(KronabyApplication this$0, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            LogKt.err$default((Object) this$0, (String) null, th, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$1
                final /* synthetic */ Thread $thread;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$1(Thread thread2) {
                    super(0);
                    r1 = thread2;
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "App crashed! (Thread: " + r1.getName() + ')';
                }
            }, 5, (Object) null);
            BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2(null));
        } catch (Exception unused) {
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread2, th);
        }
    }

    private final void setupAmplify() {
        int r0;
        try {
            if (ProviderFactory.getPoolIdProvider().isOnSandbox()) {
                r0 = com.kronaby.watch.app.R.raw.amplifyconfigurationsandbox;
            } else {
                r0 = com.kronaby.watch.app.R.raw.amplifyconfiguration;
            }
            Companion companion = Companion;
            AmplifyConfiguration fromConfigFile = AmplifyConfiguration.fromConfigFile(companion.getContext(), r0);
            Intrinsics.checkNotNullExpressionValue(fromConfigFile, "fromConfigFile(...)");
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(fromConfigFile, companion.getContext());
        } catch (Exception e) {
            LogKt.err((Object) this, "Amplify init failed ".concat(ExceptionsKt.stackTraceToString(e)), "KronabyApplication", (Throwable) e, true);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        application = this;
        ConnectionFactory.setContext(getApplicationContext());
        LogKt.prepareLogger(new LoggerAndroid());
    }
}
