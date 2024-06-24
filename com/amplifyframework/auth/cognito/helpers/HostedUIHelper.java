package com.amplifyframework.auth.cognito.helpers;

import android.app.Activity;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthWebUISignInOptions;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.statemachine.codegen.data.HostedUIOptions;
import com.amplifyframework.statemachine.codegen.data.HostedUIProviderInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIHelper.kt */
/* loaded from: classes.dex */
public final class HostedUIHelper {
    public static final HostedUIHelper INSTANCE = new HostedUIHelper();

    private HostedUIHelper() {
    }

    public final HostedUIOptions createHostedUIOptions(Activity callingActivity, AuthProvider authProvider, AuthWebUISignInOptions options) {
        AWSCognitoAuthWebUISignInOptions aWSCognitoAuthWebUISignInOptions;
        String str;
        AWSCognitoAuthWebUISignInOptions aWSCognitoAuthWebUISignInOptions2;
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(options, "options");
        List<String> scopes = options.getScopes();
        boolean z = options instanceof AWSCognitoAuthWebUISignInOptions;
        String str2 = null;
        if (z) {
            aWSCognitoAuthWebUISignInOptions = (AWSCognitoAuthWebUISignInOptions) options;
        } else {
            aWSCognitoAuthWebUISignInOptions = null;
        }
        if (aWSCognitoAuthWebUISignInOptions != null) {
            str = aWSCognitoAuthWebUISignInOptions.getIdpIdentifier();
        } else {
            str = null;
        }
        HostedUIProviderInfo hostedUIProviderInfo = new HostedUIProviderInfo(authProvider, str);
        if (z) {
            aWSCognitoAuthWebUISignInOptions2 = (AWSCognitoAuthWebUISignInOptions) options;
        } else {
            aWSCognitoAuthWebUISignInOptions2 = null;
        }
        if (aWSCognitoAuthWebUISignInOptions2 != null) {
            str2 = aWSCognitoAuthWebUISignInOptions2.getBrowserPackage();
        }
        return new HostedUIOptions(callingActivity, scopes, hostedUIProviderInfo, str2);
    }
}
