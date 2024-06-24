package com.google.firebase.crashlytics;

import android.util.Log;
import com.animaconnected.watch.device.Command;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import io.ktor.http.UrlKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class AnalyticsDeferredProxy {
    public volatile AnalyticsEventLogger analyticsEventLogger;
    public final ArrayList breadcrumbHandlerList;
    public volatile BreadcrumbSource breadcrumbSource;

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred) {
        DisabledBreadcrumbSource disabledBreadcrumbSource = new DisabledBreadcrumbSource();
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        this.breadcrumbSource = disabledBreadcrumbSource;
        this.breadcrumbHandlerList = new ArrayList();
        this.analyticsEventLogger = unavailableAnalyticsEventLogger;
        ((OptionalProvider) deferred).whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.AnalyticsDeferredProxy$$ExternalSyntheticLambda2
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                AnalyticsDeferredProxy analyticsDeferredProxy = AnalyticsDeferredProxy.this;
                analyticsDeferredProxy.getClass();
                UrlKt urlKt = UrlKt.DEFAULT_LOGGER;
                urlKt.d("AnalyticsConnector now available.");
                AnalyticsConnector analyticsConnector = (AnalyticsConnector) provider.get();
                CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
                CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
                AnalyticsConnectorImpl.AnonymousClass1 registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", crashlyticsAnalyticsListener);
                if (registerAnalyticsConnectorListener == null) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
                    }
                    AnalyticsConnectorImpl.AnonymousClass1 registerAnalyticsConnectorListener2 = analyticsConnector.registerAnalyticsConnectorListener(Command.CRASH, crashlyticsAnalyticsListener);
                    if (registerAnalyticsConnectorListener2 != null) {
                        Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
                    }
                    registerAnalyticsConnectorListener = registerAnalyticsConnectorListener2;
                }
                if (registerAnalyticsConnectorListener != null) {
                    urlKt.d("Registered Firebase Analytics listener.");
                    BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                    BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, TimeUnit.MILLISECONDS);
                    synchronized (analyticsDeferredProxy) {
                        Iterator it = analyticsDeferredProxy.breadcrumbHandlerList.iterator();
                        while (it.hasNext()) {
                            breadcrumbAnalyticsEventReceiver.registerBreadcrumbHandler((BreadcrumbHandler) it.next());
                        }
                        crashlyticsAnalyticsListener.breadcrumbEventReceiver = breadcrumbAnalyticsEventReceiver;
                        crashlyticsAnalyticsListener.crashlyticsOriginEventReceiver = blockingAnalyticsEventLogger;
                        analyticsDeferredProxy.breadcrumbSource = breadcrumbAnalyticsEventReceiver;
                        analyticsDeferredProxy.analyticsEventLogger = blockingAnalyticsEventLogger;
                    }
                    return;
                }
                urlKt.w("Could not register Firebase Analytics listener; a listener is already registered.", null);
            }
        });
    }
}
