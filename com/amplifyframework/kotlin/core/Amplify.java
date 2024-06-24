package com.amplifyframework.kotlin.core;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.analytics.AnalyticsCategory;
import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.core.plugin.Plugin;
import com.amplifyframework.kotlin.api.KotlinApiFacade;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade;
import com.amplifyframework.kotlin.geo.KotlinGeoFacade;
import com.amplifyframework.kotlin.hub.KotlinHubFacade;
import com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade;
import com.amplifyframework.kotlin.predictions.KotlinPredictionsFacade;
import com.amplifyframework.kotlin.storage.KotlinStorageFacade;
import com.amplifyframework.logging.LoggingCategory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Amplify.kt */
/* loaded from: classes.dex */
public final class Amplify {
    private static final KotlinApiFacade API;
    private static final KotlinAuthFacade Auth;
    private static final KotlinDataStoreFacade DataStore;
    private static final KotlinHubFacade Hub;
    private static final KotlinNotificationsFacade Notifications;
    private static final KotlinPredictionsFacade Predictions;
    private static final KotlinStorageFacade Storage;
    public static final Companion Companion = new Companion(null);
    private static final AnalyticsCategory Analytics = new AnalyticsCategory();
    private static final KotlinGeoFacade Geo = new KotlinGeoFacade(null, 1, null);
    private static final LoggingCategory Logging = new LoggingCategory();

    /* compiled from: Amplify.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <P extends Plugin<?>> void addPlugin(P plugin) throws AmplifyException {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            com.amplifyframework.core.Amplify.addPlugin(plugin);
        }

        public final void configure(Context context) throws AmplifyException {
            Intrinsics.checkNotNullParameter(context, "context");
            com.amplifyframework.core.Amplify.configure(context);
        }

        public final KotlinApiFacade getAPI() {
            return Amplify.API;
        }

        public final AnalyticsCategory getAnalytics() {
            return Amplify.Analytics;
        }

        public final KotlinAuthFacade getAuth() {
            return Amplify.Auth;
        }

        public final KotlinDataStoreFacade getDataStore() {
            return Amplify.DataStore;
        }

        public final KotlinGeoFacade getGeo() {
            return Amplify.Geo;
        }

        public final KotlinHubFacade getHub() {
            return Amplify.Hub;
        }

        public final LoggingCategory getLogging() {
            return Amplify.Logging;
        }

        public final KotlinNotificationsFacade getNotifications() {
            return Amplify.Notifications;
        }

        public final KotlinPredictionsFacade getPredictions() {
            return Amplify.Predictions;
        }

        public final KotlinStorageFacade getStorage() {
            return Amplify.Storage;
        }

        public final <P extends Plugin<?>> void removePlugin(P plugin) throws AmplifyException {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            com.amplifyframework.core.Amplify.removePlugin(plugin);
        }

        private Companion() {
        }

        public final void configure(AmplifyConfiguration configuration, Context context) throws AmplifyException {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(context, "context");
            com.amplifyframework.core.Amplify.configure(configuration, context);
        }
    }

    static {
        int r2 = 1;
        API = new KotlinApiFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        Auth = new KotlinAuthFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        Storage = new KotlinStorageFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        Hub = new KotlinHubFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        DataStore = new KotlinDataStoreFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        Predictions = new KotlinPredictionsFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
        Notifications = new KotlinNotificationsFacade(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
    }
}
