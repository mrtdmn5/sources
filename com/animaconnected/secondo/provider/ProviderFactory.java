package com.animaconnected.secondo.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.firebase.AndroidAnalyticsBackend;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.KronabyFirebaseInstanceIdService;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.BehaviourFactoryImpl;
import com.animaconnected.secondo.behaviour.distress.DistressProvider;
import com.animaconnected.secondo.behaviour.music.MusicDataProvider;
import com.animaconnected.secondo.notification.CriteriaProvider;
import com.animaconnected.secondo.notification.NotificationCenter;
import com.animaconnected.secondo.provider.ProviderFactory$stravaAuth$2;
import com.animaconnected.secondo.provider.battery.BatteryProvider;
import com.animaconnected.secondo.provider.behaviouritems.DoubleCrownProvider;
import com.animaconnected.secondo.provider.googlefit.GoogleFitProvider;
import com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.provider.lostwatch.LostWatchProvider;
import com.animaconnected.secondo.provider.misc.ConfigProvider;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.productinfo.ProductInfoData;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider;
import com.animaconnected.secondo.provider.status.StatusProvider;
import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import com.animaconnected.secondo.provider.status.internal.connection.ConnectionStatusController;
import com.animaconnected.secondo.provider.status.internal.devicestatus.battery.DeviceBatteryStatusController;
import com.animaconnected.secondo.provider.status.internal.dfu.DfuStatusController;
import com.animaconnected.secondo.provider.status.internal.distress.DistressStatusController;
import com.animaconnected.secondo.provider.update.BackgroundUpdateChecker;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.provider.update.WatchUpdateProvider;
import com.animaconnected.secondo.provider.webhook.WebhookProvider;
import com.animaconnected.secondo.utils.SettingsProvider;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.account.strava.StravaAuth;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProviderFactory.kt */
/* loaded from: classes3.dex */
public final class ProviderFactory {
    private static WatchFotaProvider sWatchFotaProvider;
    private static WatchUpdateProvider sWatchUpdateProvider;
    public static final ProviderFactory INSTANCE = new ProviderFactory();
    private static final Map<String, RemoteMessageReceiver> sMessageReceiversMap = new HashMap();
    private static final Lazy cloudProvider$delegate = LazyKt__LazyJVMKt.lazy(ProviderFactory$cloudProvider$2.INSTANCE);
    private static final Lazy helpCenterProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HelpCenterProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$helpCenterProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HelpCenterProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new HelpCenterProvider(applicationContext, ProviderFactory.getStatusProvider(), ProviderFactory.getWatch());
        }
    });
    private static final Lazy notificationProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$notificationProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new NotificationProvider(applicationContext);
        }
    });
    private static final Lazy musicDataProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MusicDataProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$musicDataProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MusicDataProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new MusicDataProvider();
        }
    });
    private static final Lazy notificationCenter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationCenter>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$notificationCenter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationCenter invoke() {
            ThreadUtils.assertIsOnMainThread();
            return NotificationCenter.INSTANCE;
        }
    });
    private static final Lazy criteriaProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CriteriaProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$criteriaProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CriteriaProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new CriteriaProvider();
        }
    });
    private static final Lazy lostWatchProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LostWatchProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$lostWatchProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LostWatchProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new LostWatchProvider(applicationContext);
        }
    });
    private static final Lazy watchFotaProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchFotaProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watchFotaProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchFotaProvider invoke() {
            WatchFotaProvider watchFotaProvider;
            ThreadUtils.assertIsOnMainThread();
            ProviderFactory.getWatch();
            watchFotaProvider = ProviderFactory.sWatchFotaProvider;
            Intrinsics.checkNotNull(watchFotaProvider);
            return watchFotaProvider;
        }
    });
    private static final Lazy cloudAccountProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CloudAccountProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$cloudAccountProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CloudAccountProvider invoke() {
            return new CloudAccountProvider();
        }
    });
    private static final Lazy watchUpdateProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchUpdateProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watchUpdateProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchUpdateProvider invoke() {
            WatchUpdateProvider watchUpdateProvider;
            ThreadUtils.assertIsOnMainThread();
            ProviderFactory.getWatch();
            watchUpdateProvider = ProviderFactory.sWatchUpdateProvider;
            Intrinsics.checkNotNull(watchUpdateProvider);
            return watchUpdateProvider;
        }
    });
    private static final Lazy callStateReceiver$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CallStateReceiver>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$callStateReceiver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CallStateReceiver invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            ProviderFactory providerFactory = ProviderFactory.INSTANCE;
            applicationContext = providerFactory.getApplicationContext();
            return new CallStateReceiver(applicationContext, providerFactory.getNotificationCenter());
        }
    });
    private static final Lazy statusProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StatusProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$statusProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StatusProvider invoke() {
            Context applicationContext;
            Context applicationContext2;
            Context applicationContext3;
            Context applicationContext4;
            ThreadUtils.assertIsOnMainThread();
            WatchProvider watch = ProviderFactory.getWatch();
            ProviderFactory providerFactory = ProviderFactory.INSTANCE;
            applicationContext = providerFactory.getApplicationContext();
            BackgroundUpdateChecker backgroundUpdateChecker = ProviderFactory.getBackgroundUpdateChecker();
            WatchProvider watch2 = ProviderFactory.getWatch();
            applicationContext2 = providerFactory.getApplicationContext();
            applicationContext3 = providerFactory.getApplicationContext();
            applicationContext4 = providerFactory.getApplicationContext();
            return new StatusProvider(new ConnectionStatusController(watch, applicationContext), new DfuStatusController(backgroundUpdateChecker, watch2, applicationContext2, ProviderFactory.getWatchAppUpdateProvider(), ProviderFactory.getWatchUpdateProvider(), ProviderFactory.getWatchDfuProvider()), new DistressStatusController(applicationContext3), new DeviceBatteryStatusController(ProviderFactory.getWatch()), new PowerOptimizationStatusController(applicationContext4));
        }
    });
    private static final Lazy importantAppsProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImportantAppsProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$importantAppsProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImportantAppsProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new ImportantAppsProvider(applicationContext);
        }
    });
    private static final Lazy labsProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LabsProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$labsProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LabsProvider invoke() {
            Context applicationContext;
            Context applicationContext2;
            ThreadUtils.assertIsOnMainThread();
            ProviderFactory providerFactory = ProviderFactory.INSTANCE;
            applicationContext = providerFactory.getApplicationContext();
            RemoteConfigController.Companion companion = RemoteConfigController.Companion;
            applicationContext2 = providerFactory.getApplicationContext();
            return new LabsProvider(applicationContext, companion.getInstance(applicationContext2), ProviderFactory.getCloudProvider());
        }
    });
    private static final Lazy quietHoursProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<QuietHoursProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$quietHoursProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QuietHoursProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return ProviderFactory.getWatch().getWatchManager().getQuietHours();
        }
    });
    private static final Lazy settingProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SettingsProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$settingProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SettingsProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new SettingsProvider(applicationContext);
        }
    });
    private static final Lazy behaviourFactory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BehaviourFactoryImpl>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$behaviourFactory$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BehaviourFactoryImpl invoke() {
            Context applicationContext;
            Map map;
            ThreadUtils.assertIsOnMainThread();
            RemoteConfigController.Companion companion = RemoteConfigController.Companion;
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            BehaviourFactoryImpl behaviourFactoryImpl = new BehaviourFactoryImpl(companion.getInstance(applicationContext));
            List<RemoteMessageReceiver> remoteMessageReceivers = behaviourFactoryImpl.getRemoteMessageReceivers();
            int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(remoteMessageReceivers, 10));
            if (mapCapacity < 16) {
                mapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Object obj : remoteMessageReceivers) {
                linkedHashMap.put(((RemoteMessageReceiver) obj).getServiceName(), obj);
            }
            map = ProviderFactory.sMessageReceiversMap;
            map.putAll(linkedHashMap);
            return behaviourFactoryImpl;
        }
    });
    private static final Lazy themeProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ThemeProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$themeProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThemeProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            ProductInfoData currentSkuData = ProductInfoProvider.getCurrentSkuData();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new ThemeProvider(currentSkuData, applicationContext);
        }
    });
    private static final Lazy backgroundUpdateChecker$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BackgroundUpdateChecker>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$backgroundUpdateChecker$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BackgroundUpdateChecker invoke() {
            Context applicationContext;
            Context applicationContext2;
            Context applicationContext3;
            ThreadUtils.assertIsOnMainThread();
            WatchProvider watch = ProviderFactory.getWatch();
            ProviderFactory providerFactory = ProviderFactory.INSTANCE;
            applicationContext = providerFactory.getApplicationContext();
            JobSchedulerProvider jobSchedulerProvider = new JobSchedulerProvider(applicationContext);
            WatchAppUpdateProvider watchAppUpdateProvider = ProviderFactory.getWatchAppUpdateProvider();
            applicationContext2 = providerFactory.getApplicationContext();
            RemoteConfigController.Companion companion = RemoteConfigController.Companion;
            applicationContext3 = providerFactory.getApplicationContext();
            return new BackgroundUpdateChecker(watch, jobSchedulerProvider, watchAppUpdateProvider, applicationContext2, companion.getInstance(applicationContext3));
        }
    });
    private static final Lazy watchAppUpdateProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchAppUpdateProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watchAppUpdateProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchAppUpdateProvider invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            Cloud cloudProvider = ProviderFactory.getCloudProvider();
            ConfigProvider createConfigProvider = ProviderFactory.createConfigProvider();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new WatchAppUpdateProvider(cloudProvider, createConfigProvider, applicationContext);
        }
    });
    private static final Lazy watchDfuProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchDfuProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watchDfuProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchDfuProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new WatchDfuProvider(ProviderFactory.getWatchAppUpdateProvider());
        }
    });
    private static final Lazy googleFitProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<GoogleFitProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$googleFitProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GoogleFitProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new GoogleFitProvider();
        }
    });
    private static final Lazy watchAlarmProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchAlarmProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watchAlarmProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchAlarmProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return ProviderFactory.getWatch().getWatchManager().getAlarmsProvider();
        }
    });
    private static final Lazy remoteCrashProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RemoteCrashProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$remoteCrashProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RemoteCrashProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new RemoteCrashProvider(ProviderFactory.getCloudProvider(), ProviderFactory.getWatch());
        }
    });
    private static final Lazy doubleCrownProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DoubleCrownProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$doubleCrownProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DoubleCrownProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new DoubleCrownProvider();
        }
    });
    private static final Lazy webhookProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WebhookProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$webhookProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WebhookProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new WebhookProvider();
        }
    });
    private static final Lazy watch$delegate = LazyKt__LazyJVMKt.lazy(ProviderFactory$watch$2.INSTANCE);
    private static final Lazy stravaAuth$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ProviderFactory$stravaAuth$2.AnonymousClass1>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$stravaAuth$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.secondo.provider.ProviderFactory$stravaAuth$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            RemoteConfigController.Companion companion = RemoteConfigController.Companion;
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            final RemoteConfigController companion2 = companion.getInstance(applicationContext);
            return new StravaAuth() { // from class: com.animaconnected.secondo.provider.ProviderFactory$stravaAuth$2.1
                @Override // com.animaconnected.watch.account.strava.StravaAuth
                public void authenticate(String appOAuthUrl, String webOAuthUrl) {
                    Intrinsics.checkNotNullParameter(appOAuthUrl, "appOAuthUrl");
                    Intrinsics.checkNotNullParameter(webOAuthUrl, "webOAuthUrl");
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(webOAuthUrl));
                        intent.setFlags(268435456);
                        KronabyApplication.Companion.getContext().startActivity(intent);
                    } catch (Exception e) {
                        LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$stravaAuth$2$1$authenticate$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return String.valueOf(e.getMessage());
                            }
                        }, 7, (Object) null);
                    }
                }

                @Override // com.animaconnected.watch.account.strava.StravaAuth
                public String getClientId() {
                    return RemoteConfigController.this.getStravaClientId();
                }

                @Override // com.animaconnected.watch.account.strava.StravaAuth
                public String getClientSecret() {
                    return RemoteConfigController.this.getStravaClientSecret();
                }
            };
        }
    });
    private static final Lazy batteryProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BatteryProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$batteryProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BatteryProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new BatteryProvider(ProviderFactory.getWatch());
        }
    });
    private static final Lazy analytics$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Analytics>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$analytics$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Analytics invoke() {
            Context applicationContext;
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new Analytics(new AndroidAnalyticsBackend(applicationContext));
        }
    });
    private static final Lazy distressProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DistressProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$distressProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DistressProvider invoke() {
            Context applicationContext;
            Behaviours behaviours = ProviderFactory.getWatch().getWatchManager().getBehaviours();
            DistressProvider.Companion companion = DistressProvider.Companion;
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return companion.create(applicationContext, behaviours);
        }
    });
    private static final Lazy poolIdProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PoolIdProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$poolIdProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PoolIdProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return new PoolIdProvider();
        }
    });
    private static final Lazy kronabyFirebaseInstanceIdService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KronabyFirebaseInstanceIdService>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$kronabyFirebaseInstanceIdService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KronabyFirebaseInstanceIdService invoke() {
            Context applicationContext;
            ThreadUtils.assertIsOnMainThread();
            applicationContext = ProviderFactory.INSTANCE.getApplicationContext();
            return new KronabyFirebaseInstanceIdService(applicationContext);
        }
    });
    private static final Lazy weatherProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HistoricalWeatherProvider>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$weatherProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoricalWeatherProvider invoke() {
            ThreadUtils.assertIsOnMainThread();
            return ProviderFactory.getWatch().getWatchManager().getWeatherProvider();
        }
    });
    public static final int $stable = 8;

    private ProviderFactory() {
    }

    public static final BluetoothOnboardingProvider createBluetoothOnboardingProvider() {
        ThreadUtils.assertIsOnMainThread();
        return new BluetoothOnboardingProviderImpl(getWatch());
    }

    public static final ConfigProvider createConfigProvider() {
        return new ConfigProviderImpl(INSTANCE.getApplicationContext());
    }

    public static final LoginViewModel createLoginViewModel() {
        return new LoginViewModel(new SigninStorage(KronabyApplication.Companion.getContext()), getAppAnalytics(), getWatch().fitness());
    }

    public static final SigninProvider createSigninProvider() {
        return new SigninProviderImpl(INSTANCE.getApplicationContext());
    }

    public static final WeatherViewModel createWeatherViewModel() {
        return new WeatherViewModel(new Function0<FitnessProvider.Profile.Temperature>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$createWeatherViewModel$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FitnessProvider.Profile.Temperature invoke() {
                return ProviderFactory.getWatch().fitness().getProfile().getTemperatureUnit();
            }
        });
    }

    public static final synchronized AppEvents getAppAnalytics() {
        AppEvents appEvents;
        synchronized (ProviderFactory.class) {
            appEvents = INSTANCE.getAnalytics().getAppEvents();
        }
        return appEvents;
    }

    public final Context getApplicationContext() {
        Context applicationContext = KronabyApplication.Companion.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    public static final BackgroundUpdateChecker getBackgroundUpdateChecker() {
        return (BackgroundUpdateChecker) backgroundUpdateChecker$delegate.getValue();
    }

    public static final BatteryProvider getBatteryProvider() {
        return (BatteryProvider) batteryProvider$delegate.getValue();
    }

    public static final BehaviourFactory getBehaviourFactory() {
        return (BehaviourFactory) behaviourFactory$delegate.getValue();
    }

    public static final synchronized Cloud getCloudProvider() {
        Cloud cloud;
        synchronized (ProviderFactory.class) {
            cloud = (Cloud) cloudProvider$delegate.getValue();
        }
        return cloud;
    }

    public static final CriteriaProvider getCriteriaProvider() {
        return (CriteriaProvider) criteriaProvider$delegate.getValue();
    }

    public static final DistressProvider getDistressProvider() {
        return (DistressProvider) distressProvider$delegate.getValue();
    }

    public static final DoubleCrownProvider getDoubleCrownProvider() {
        return (DoubleCrownProvider) doubleCrownProvider$delegate.getValue();
    }

    public static final HelpCenterProvider getHelpCenterProvider() {
        return (HelpCenterProvider) helpCenterProvider$delegate.getValue();
    }

    public static final ImportantAppsProvider getImportantAppsProvider() {
        return (ImportantAppsProvider) importantAppsProvider$delegate.getValue();
    }

    public static final KronabyFirebaseInstanceIdService getKronabyFirebaseInstanceIdService() {
        return (KronabyFirebaseInstanceIdService) kronabyFirebaseInstanceIdService$delegate.getValue();
    }

    public static final LabsProvider getLabsProvider() {
        return (LabsProvider) labsProvider$delegate.getValue();
    }

    public static final LostWatchProvider getLostWatchProvider() {
        return (LostWatchProvider) lostWatchProvider$delegate.getValue();
    }

    public static final MusicDataProvider getMusicDataProvider() {
        return (MusicDataProvider) musicDataProvider$delegate.getValue();
    }

    public static final NotificationProvider getNotificationProvider() {
        return (NotificationProvider) notificationProvider$delegate.getValue();
    }

    public static final PoolIdProvider getPoolIdProvider() {
        return (PoolIdProvider) poolIdProvider$delegate.getValue();
    }

    public static final RemoteCrashProvider getRemoteCrashProvider() {
        return (RemoteCrashProvider) remoteCrashProvider$delegate.getValue();
    }

    public static final SettingsProvider getSettingProvider() {
        return (SettingsProvider) settingProvider$delegate.getValue();
    }

    public static final StatusProvider getStatusProvider() {
        return (StatusProvider) statusProvider$delegate.getValue();
    }

    public static final WatchProvider getWatch() {
        return (WatchProvider) watch$delegate.getValue();
    }

    public static final WatchAppUpdateProvider getWatchAppUpdateProvider() {
        return (WatchAppUpdateProvider) watchAppUpdateProvider$delegate.getValue();
    }

    public static final WatchDfuProvider getWatchDfuProvider() {
        return (WatchDfuProvider) watchDfuProvider$delegate.getValue();
    }

    public static final WatchFotaProvider getWatchFotaProvider() {
        return (WatchFotaProvider) watchFotaProvider$delegate.getValue();
    }

    public static final WatchUpdateProvider getWatchUpdateProvider() {
        return (WatchUpdateProvider) watchUpdateProvider$delegate.getValue();
    }

    public static final HistoricalWeatherProvider getWeatherProvider() {
        return (HistoricalWeatherProvider) weatherProvider$delegate.getValue();
    }

    public static final WebhookProvider getWebhookProvider() {
        return (WebhookProvider) webhookProvider$delegate.getValue();
    }

    public final synchronized Analytics getAnalytics() {
        return (Analytics) analytics$delegate.getValue();
    }

    public final CallStateReceiver getCallStateReceiver() {
        return (CallStateReceiver) callStateReceiver$delegate.getValue();
    }

    public final CloudAccountProvider getCloudAccountProvider() {
        return (CloudAccountProvider) cloudAccountProvider$delegate.getValue();
    }

    public final GoogleFitProvider getGoogleFitProvider() {
        return (GoogleFitProvider) googleFitProvider$delegate.getValue();
    }

    public final RemoteMessageReceiver getMessageReceiver(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return sMessageReceiversMap.get(service);
    }

    public final NotificationCenter getNotificationCenter() {
        return (NotificationCenter) notificationCenter$delegate.getValue();
    }

    public final QuietHoursProvider getQuietHoursProvider() {
        return (QuietHoursProvider) quietHoursProvider$delegate.getValue();
    }

    public final StravaAuth getStravaAuth() {
        return (StravaAuth) stravaAuth$delegate.getValue();
    }

    public final ThemeProvider getThemeProvider() {
        return (ThemeProvider) themeProvider$delegate.getValue();
    }

    public final WatchAlarmProvider getWatchAlarmProvider() {
        return (WatchAlarmProvider) watchAlarmProvider$delegate.getValue();
    }

    public final void registerMessageReceiver(String serviceName, RemoteMessageReceiver receiver) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        sMessageReceiversMap.put(serviceName, receiver);
    }

    public static /* synthetic */ void getAppAnalytics$annotations() {
    }

    public static /* synthetic */ void getBackgroundUpdateChecker$annotations() {
    }

    public static /* synthetic */ void getBatteryProvider$annotations() {
    }

    public static /* synthetic */ void getBehaviourFactory$annotations() {
    }

    public static /* synthetic */ void getCloudProvider$annotations() {
    }

    public static /* synthetic */ void getCriteriaProvider$annotations() {
    }

    public static /* synthetic */ void getDistressProvider$annotations() {
    }

    public static /* synthetic */ void getDoubleCrownProvider$annotations() {
    }

    public static /* synthetic */ void getHelpCenterProvider$annotations() {
    }

    public static /* synthetic */ void getImportantAppsProvider$annotations() {
    }

    public static /* synthetic */ void getKronabyFirebaseInstanceIdService$annotations() {
    }

    public static /* synthetic */ void getLabsProvider$annotations() {
    }

    public static /* synthetic */ void getLostWatchProvider$annotations() {
    }

    public static /* synthetic */ void getMusicDataProvider$annotations() {
    }

    public static /* synthetic */ void getNotificationProvider$annotations() {
    }

    public static /* synthetic */ void getPoolIdProvider$annotations() {
    }

    public static /* synthetic */ void getRemoteCrashProvider$annotations() {
    }

    public static /* synthetic */ void getSettingProvider$annotations() {
    }

    public static /* synthetic */ void getStatusProvider$annotations() {
    }

    public static /* synthetic */ void getWatch$annotations() {
    }

    public static /* synthetic */ void getWatchAppUpdateProvider$annotations() {
    }

    public static /* synthetic */ void getWatchDfuProvider$annotations() {
    }

    public static /* synthetic */ void getWatchFotaProvider$annotations() {
    }

    public static /* synthetic */ void getWatchUpdateProvider$annotations() {
    }

    public static /* synthetic */ void getWeatherProvider$annotations() {
    }

    public static /* synthetic */ void getWebhookProvider$annotations() {
    }
}
