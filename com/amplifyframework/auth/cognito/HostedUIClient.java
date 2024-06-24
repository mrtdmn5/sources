package com.amplifyframework.auth.cognito;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.os.BundleCompat$Api18Impl;
import com.amazonaws.http.HttpHeader;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.activities.CustomTabsManagerActivity;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.amplifyframework.auth.cognito.helpers.BrowserHelper;
import com.amplifyframework.auth.cognito.helpers.CodegenExtensionsKt;
import com.amplifyframework.auth.cognito.helpers.HostedUIHttpHelper;
import com.amplifyframework.auth.cognito.helpers.PkceHelper;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import com.amplifyframework.statemachine.codegen.data.HostedUIOptions;
import com.amplifyframework.statemachine.codegen.data.OauthConfiguration;
import com.animaconnected.firebase.AnalyticsConstants;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIClient.kt */
@SuppressLint({"QueryPermissionsNeeded"})
/* loaded from: classes.dex */
public final class HostedUIClient extends CustomTabsServiceConnection {
    public static final int CUSTOM_TABS_ACTIVITY_CODE = 49281;
    public static final Companion Companion = new Companion(null);
    private CustomTabsClient client;
    private final OauthConfiguration configuration;
    private final Context context;
    private final String defaultCustomTabsPackage;
    private final Logger logger;
    private final String proofKey;
    private final String proofKeyHash;
    private CustomTabsSession session;
    private final String state;

    /* compiled from: HostedUIClient.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HostedUIClient create(Context context, OauthConfiguration oauthConfiguration, Logger logger) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logger, "logger");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (oauthConfiguration == null) {
                return null;
            }
            return new HostedUIClient(context, oauthConfiguration, logger, defaultConstructorMarker);
        }

        private Companion() {
        }
    }

    public /* synthetic */ HostedUIClient(Context context, OauthConfiguration oauthConfiguration, Logger logger, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, oauthConfiguration, logger);
    }

    private final Uri createAuthorizeUri(HostedUIOptions hostedUIOptions) {
        String userPoolProviderName;
        boolean z;
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(this.configuration.getDomain()).appendPath("oauth2").appendPath("authorize").appendQueryParameter("client_id", this.configuration.getAppClient()).appendQueryParameter("redirect_uri", this.configuration.getSignInRedirectURI()).appendQueryParameter("response_type", AnalyticsConstants.KEY_CODE).appendQueryParameter("code_challenge", this.proofKeyHash).appendQueryParameter("code_challenge_method", "S256").appendQueryParameter("state", this.state);
        AuthProvider authProvider = hostedUIOptions.getProviderInfo().getAuthProvider();
        boolean z2 = true;
        List<String> list = null;
        if (authProvider != null && (userPoolProviderName = CodegenExtensionsKt.getUserPoolProviderName(authProvider)) != null) {
            if (userPoolProviderName.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                userPoolProviderName = null;
            }
            if (userPoolProviderName != null) {
                appendQueryParameter.appendQueryParameter("identity_provider", userPoolProviderName);
            }
        }
        String idpIdentifier = hostedUIOptions.getProviderInfo().getIdpIdentifier();
        if (idpIdentifier != null) {
            if (idpIdentifier.length() <= 0) {
                z2 = false;
            }
            if (!z2) {
                idpIdentifier = null;
            }
            if (idpIdentifier != null) {
                appendQueryParameter.appendQueryParameter("idp_identifier", idpIdentifier);
            }
        }
        List<String> scopes = hostedUIOptions.getScopes();
        if (scopes != null) {
            List<String> list2 = scopes;
            if (list2.isEmpty()) {
                list2 = CollectionsKt___CollectionsKt.toList(this.configuration.getScopes());
            }
            list = list2;
        }
        if (list != null) {
            appendQueryParameter.appendQueryParameter("scope", CollectionsKt___CollectionsKt.joinToString$default(list, " ", null, null, null, 62));
        }
        Uri build = appendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    private final Map<String, String> createFetchTokenHeaders() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Content-Type", "application/x-www-form-urlencoded"));
        if (this.configuration.getAppSecret() != null) {
            StringBuilder sb = new StringBuilder("Basic ");
            sb.append(PkceHelper.INSTANCE.encodeBase64(this.configuration.getAppClient() + ':' + this.configuration.getAppSecret()));
            mutableMapOf.put(HttpHeader.AUTHORIZATION, sb.toString());
        }
        return mutableMapOf;
    }

    private final URL createFetchTokenUrl() {
        return new URL(new Uri.Builder().scheme("https").authority(this.configuration.getDomain()).appendPath("oauth2").appendPath(AWSCognitoLegacyCredentialStore.TOKEN_KEY).build().toString());
    }

    private final void launchCustomTabs(Uri uri, Activity activity, String str) {
        if (BrowserHelper.INSTANCE.isBrowserInstalled(this.context)) {
            if (str == null) {
                str = this.defaultCustomTabsPackage;
            }
            CustomTabsSession customTabsSession = this.session;
            Intent intent = new Intent("android.intent.action.VIEW");
            if (customTabsSession != null) {
                intent.setPackage(customTabsSession.mComponentName.getPackageName());
                ICustomTabsCallback.Stub stub = (ICustomTabsCallback.Stub) customTabsSession.mCallback;
                stub.getClass();
                Bundle bundle = new Bundle();
                BundleCompat$Api18Impl.putBinder(bundle, "android.support.customtabs.extra.SESSION", stub);
                PendingIntent pendingIntent = customTabsSession.mId;
                if (pendingIntent != null) {
                    bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                }
                intent.putExtras(bundle);
            }
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle2 = new Bundle();
                BundleCompat$Api18Impl.putBinder(bundle2, "android.support.customtabs.extra.SESSION", null);
                intent.putExtras(bundle2);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
            intent.putExtras(new Bundle());
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            if (str != null) {
                intent.setPackage(str);
            }
            intent.setData(uri);
            Intent createStartIntent = CustomTabsManagerActivity.Companion.createStartIntent(this.context, intent);
            if (activity != null) {
                activity.startActivityForResult(createStartIntent, CUSTOM_TABS_ACTIVITY_CODE);
                return;
            } else {
                createStartIntent.addFlags(268435456);
                this.context.startActivity(createStartIntent);
                return;
            }
        }
        throw new RuntimeException("No browsers installed");
    }

    public static /* synthetic */ void launchCustomTabs$default(HostedUIClient hostedUIClient, Uri uri, Activity activity, String str, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            activity = null;
        }
        hostedUIClient.launchCustomTabs(uri, activity, str);
    }

    private final void preWarmCustomTabs(Context context, String str) {
        setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        context.bindService(intent, this, 33);
    }

    public final Uri createSignOutUri$aws_auth_cognito_release() {
        Uri build = new Uri.Builder().scheme("https").authority(this.configuration.getDomain()).appendPath("logout").appendQueryParameter("client_id", this.configuration.getAppClient()).appendQueryParameter("logout_uri", this.configuration.getSignOutRedirectURI()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…URI)\n            .build()");
        return build;
    }

    public final CognitoUserPoolTokens fetchRefreshedToken(String refreshToken) {
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        return HostedUIHttpHelper.INSTANCE.fetchTokens(createFetchTokenUrl(), createFetchTokenHeaders(), MapsKt__MapsKt.mapOf(new Pair("grant_type", "refresh_token"), new Pair("client_id", this.configuration.getAppClient()), new Pair("redirect_uri", this.configuration.getSignInRedirectURI()), new Pair("refresh_token", refreshToken)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:            if (r1 == true) goto L16;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens fetchToken(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "error"
            java.lang.String r0 = r8.getQueryParameter(r0)
            java.lang.String r1 = "state"
            java.lang.String r1 = r8.getQueryParameter(r1)
            java.lang.String r2 = "code"
            java.lang.String r3 = r8.getQueryParameter(r2)
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L4b
            java.lang.String r1 = "error_description"
            java.lang.String r8 = r8.getQueryParameter(r1)
            if (r8 == 0) goto L2d
            java.lang.CharSequence r8 = kotlin.text.StringsKt__StringsKt.trim(r8)
            java.lang.String r4 = r8.toString()
        L2d:
            r8 = 0
            if (r4 == 0) goto L3c
            int r1 = r4.length()
            if (r1 <= 0) goto L38
            r1 = r5
            goto L39
        L38:
            r1 = r8
        L39:
            if (r1 != r5) goto L3c
            goto L3d
        L3c:
            r5 = r8
        L3d:
            if (r5 == 0) goto L45
            java.lang.String r8 = ": "
            java.lang.String r0 = androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0.m(r0, r8, r4)
        L45:
            com.amplifyframework.auth.cognito.exceptions.service.CodeValidationException r8 = new com.amplifyframework.auth.cognito.exceptions.service.CodeValidationException
            r8.<init>(r0)
            throw r8
        L4b:
            if (r1 == 0) goto L97
            if (r3 == 0) goto L97
            kotlin.Pair r8 = new kotlin.Pair
            java.lang.String r0 = "grant_type"
            java.lang.String r1 = "authorization_code"
            r8.<init>(r0, r1)
            com.amplifyframework.statemachine.codegen.data.OauthConfiguration r0 = r7.configuration
            java.lang.String r0 = r0.getAppClient()
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.String r4 = "client_id"
            r1.<init>(r4, r0)
            com.amplifyframework.statemachine.codegen.data.OauthConfiguration r0 = r7.configuration
            java.lang.String r0 = r0.getSignInRedirectURI()
            kotlin.Pair r4 = new kotlin.Pair
            java.lang.String r5 = "redirect_uri"
            r4.<init>(r5, r0)
            java.lang.String r0 = r7.proofKey
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.String r6 = "code_verifier"
            r5.<init>(r6, r0)
            kotlin.Pair r0 = new kotlin.Pair
            r0.<init>(r2, r3)
            kotlin.Pair[] r8 = new kotlin.Pair[]{r8, r1, r4, r5, r0}
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.mapOf(r8)
            com.amplifyframework.auth.cognito.helpers.HostedUIHttpHelper r0 = com.amplifyframework.auth.cognito.helpers.HostedUIHttpHelper.INSTANCE
            java.net.URL r1 = r7.createFetchTokenUrl()
            java.util.Map r2 = r7.createFetchTokenHeaders()
            com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens r8 = r0.fetchTokens(r1, r2, r8)
            return r8
        L97:
            com.amplifyframework.auth.cognito.exceptions.service.CodeValidationException r8 = new com.amplifyframework.auth.cognito.exceptions.service.CodeValidationException
            r8.<init>(r4, r5, r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.HostedUIClient.fetchToken(android.net.Uri):com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens");
    }

    public final void launchCustomTabsSignIn(HostedUIOptions hostedUIOptions) throws RuntimeException {
        Intrinsics.checkNotNullParameter(hostedUIOptions, "hostedUIOptions");
        launchCustomTabs(createAuthorizeUri(hostedUIOptions), hostedUIOptions.getCallingActivity(), hostedUIOptions.getBrowserPackage());
    }

    public final void launchCustomTabsSignOut(String str) throws RuntimeException {
        launchCustomTabs$default(this, createSignOutUri$aws_auth_cognito_release(), null, str, 2, null);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        CustomTabsSession customTabsSession;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(client, "client");
        ICustomTabsService iCustomTabsService = client.mService;
        this.client = client;
        try {
            iCustomTabsService.warmup();
        } catch (RemoteException unused) {
        }
        CustomTabsClient.AnonymousClass2 anonymousClass2 = new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.CustomTabsClient.2
            public AnonymousClass2() {
                new Handler(Looper.getMainLooper());
            }
        };
        if (iCustomTabsService.newSession(anonymousClass2)) {
            customTabsSession = new CustomTabsSession(iCustomTabsService, anonymousClass2, client.mServiceComponentName);
            this.session = customTabsSession;
        }
        customTabsSession = null;
        this.session = customTabsSession;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.client = null;
    }

    private HostedUIClient(Context context, OauthConfiguration oauthConfiguration, Logger logger) {
        this.context = context;
        this.configuration = oauthConfiguration;
        this.logger = logger;
        PkceHelper pkceHelper = PkceHelper.INSTANCE;
        String generateRandom = pkceHelper.generateRandom();
        this.proofKey = generateRandom;
        this.proofKeyHash = pkceHelper.generateHash(generateRandom);
        this.state = pkceHelper.generateRandom();
        String defaultCustomTabPackage = BrowserHelper.INSTANCE.getDefaultCustomTabPackage(context);
        if (defaultCustomTabPackage != null) {
            preWarmCustomTabs(context, defaultCustomTabPackage);
        } else {
            defaultCustomTabPackage = null;
        }
        this.defaultCustomTabsPackage = defaultCustomTabPackage;
    }
}
