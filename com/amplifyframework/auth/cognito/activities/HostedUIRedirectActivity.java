package com.amplifyframework.auth.cognito.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.amplifyframework.core.Amplify;

/* compiled from: HostedUIRedirectActivity.kt */
/* loaded from: classes.dex */
public final class HostedUIRedirectActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(CustomTabsManagerActivity.Companion.createResponseHandlingIntent(this, getIntent().getData()));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("AuthClient", "Handling auth redirect response");
        Amplify.Auth.handleWebUISignInResponse(getIntent());
        finish();
    }
}
