package com.amplifyframework.auth.cognito.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.amplifyframework.core.Amplify;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabsManagerActivity.kt */
/* loaded from: classes.dex */
public final class CustomTabsManagerActivity extends Activity {
    public static final String CUSTOM_TABS_INTENT_KEY = "customTabsIntent";
    public static final String CUSTOM_TABS_LAUNCHED_KEY = "customTabsLaunched";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AuthClient";
    private Intent customTabsIntent;
    private boolean customTabsLaunched;

    /* compiled from: CustomTabsManagerActivity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent createBaseIntent(Context context) {
            return new Intent(context, (Class<?>) CustomTabsManagerActivity.class);
        }

        public final Intent createResponseHandlingIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent createBaseIntent = createBaseIntent(context);
            createBaseIntent.setData(uri);
            createBaseIntent.addFlags(603979776);
            return createBaseIntent;
        }

        public final Intent createStartIntent(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent createBaseIntent = createBaseIntent(context);
            createBaseIntent.putExtra(CustomTabsManagerActivity.CUSTOM_TABS_INTENT_KEY, intent);
            return createBaseIntent;
        }

        private Companion() {
        }
    }

    public static final Intent createResponseHandlingIntent(Context context, Uri uri) {
        return Companion.createResponseHandlingIntent(context, uri);
    }

    private final void extractState(Bundle bundle) {
        if (bundle == null) {
            Log.d(TAG, "CustomTabsManagerActivity was created with a null state.");
            finish();
        } else {
            this.customTabsIntent = (Intent) bundle.getParcelable(CUSTOM_TABS_INTENT_KEY);
            this.customTabsLaunched = bundle.getBoolean(CUSTOM_TABS_LAUNCHED_KEY, false);
        }
    }

    private final void handleAuthorizationCanceled() {
        Log.d(TAG, "Authorization flow canceled by user");
        setResult(0);
        Amplify.Auth.handleWebUISignInResponse(null);
    }

    private final void handleAuthorizationComplete() {
        Log.d(TAG, "Authorization flow completed successfully");
        setResult(-1, getIntent());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            extractState(getIntent().getExtras());
        } else {
            extractState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.customTabsLaunched) {
            startActivity(this.customTabsIntent);
            this.customTabsLaunched = true;
        } else {
            if (getIntent().getData() != null) {
                handleAuthorizationComplete();
            } else {
                handleAuthorizationCanceled();
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(CUSTOM_TABS_LAUNCHED_KEY, this.customTabsLaunched);
        outState.putParcelable(CUSTOM_TABS_INTENT_KEY, this.customTabsIntent);
    }
}
