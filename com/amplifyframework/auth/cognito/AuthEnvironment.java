package com.amplifyframework.auth.cognito;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.amplifyframework.auth.cognito.asf.UserContextDataProvider;
import com.amplifyframework.auth.cognito.helpers.SRPHelper;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthEnvironment.kt */
/* loaded from: classes.dex */
public final class AuthEnvironment implements Environment {
    public static final Companion Companion = new Companion(null);
    public static final String PINPOINT_SHARED_PREFS_SUFFIX = "515d6767-01b7-49e5-8273-c8d11b0f331d";
    public static final String PINPOINT_UNIQUE_ID_KEY = "UniqueId";
    private String cachedPinpointEndpointId;
    private final AWSCognitoAuthService cognitoAuthService;
    private final AuthConfiguration configuration;
    private final Context context;
    private final StoreClientBehavior credentialStoreClient;
    private final HostedUIClient hostedUIClient;
    private final Logger logger;
    public SRPHelper srpHelper;
    private final UserContextDataProvider userContextDataProvider;

    /* compiled from: AuthEnvironment.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AuthEnvironment(Context context, AuthConfiguration configuration, AWSCognitoAuthService cognitoAuthService, StoreClientBehavior credentialStoreClient, UserContextDataProvider userContextDataProvider, HostedUIClient hostedUIClient, Logger logger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(cognitoAuthService, "cognitoAuthService");
        Intrinsics.checkNotNullParameter(credentialStoreClient, "credentialStoreClient");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.context = context;
        this.configuration = configuration;
        this.cognitoAuthService = cognitoAuthService;
        this.credentialStoreClient = credentialStoreClient;
        this.userContextDataProvider = userContextDataProvider;
        this.hostedUIClient = hostedUIClient;
        this.logger = logger;
    }

    public final AWSCognitoAuthService getCognitoAuthService() {
        return this.cognitoAuthService;
    }

    public final AuthConfiguration getConfiguration() {
        return this.configuration;
    }

    public final Context getContext() {
        return this.context;
    }

    public final StoreClientBehavior getCredentialStoreClient() {
        return this.credentialStoreClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDeviceMetadata(java.lang.String r5, kotlin.coroutines.Continuation<? super com.amplifyframework.statemachine.codegen.data.DeviceMetadata.Metadata> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.amplifyframework.auth.cognito.AuthEnvironment$getDeviceMetadata$1
            if (r0 == 0) goto L13
            r0 = r6
            com.amplifyframework.auth.cognito.AuthEnvironment$getDeviceMetadata$1 r0 = (com.amplifyframework.auth.cognito.AuthEnvironment$getDeviceMetadata$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.auth.cognito.AuthEnvironment$getDeviceMetadata$1 r0 = new com.amplifyframework.auth.cognito.AuthEnvironment$getDeviceMetadata$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.amplifyframework.auth.cognito.AuthEnvironment r5 = (com.amplifyframework.auth.cognito.AuthEnvironment) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            com.amplifyframework.auth.cognito.StoreClientBehavior r6 = r4.credentialStoreClient
            com.amplifyframework.statemachine.codegen.data.CredentialType$Device r2 = new com.amplifyframework.statemachine.codegen.data.CredentialType$Device
            r2.<init>(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.loadCredentials(r2, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            r5 = r4
        L49:
            boolean r0 = r6 instanceof com.amplifyframework.statemachine.codegen.data.AmplifyCredential.DeviceData
            r1 = 0
            if (r0 == 0) goto L51
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential$DeviceData r6 = (com.amplifyframework.statemachine.codegen.data.AmplifyCredential.DeviceData) r6
            goto L52
        L51:
            r6 = r1
        L52:
            if (r6 != 0) goto L5b
            com.amplifyframework.logging.Logger r5 = r5.logger
            java.lang.String r0 = "loadCredentials returned unexpected AmplifyCredential Type."
            r5.warn(r0)
        L5b:
            java.lang.String r5 = "null cannot be cast to non-null type com.amplifyframework.statemachine.codegen.data.AmplifyCredential.DeviceData"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            com.amplifyframework.statemachine.codegen.data.DeviceMetadata r5 = r6.getDeviceMetadata()
            boolean r6 = r5 instanceof com.amplifyframework.statemachine.codegen.data.DeviceMetadata.Metadata
            if (r6 == 0) goto L6b
            r1 = r5
            com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Metadata r1 = (com.amplifyframework.statemachine.codegen.data.DeviceMetadata.Metadata) r1
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.AuthEnvironment.getDeviceMetadata(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HostedUIClient getHostedUIClient() {
        return this.hostedUIClient;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized String getPinpointEndpointId() {
        String str;
        UserPoolConfiguration userPool = this.configuration.getUserPool();
        if (userPool != null) {
            str = userPool.getPinpointAppId();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        String str2 = this.cachedPinpointEndpointId;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.configuration.getUserPool().getPinpointAppId() + PINPOINT_SHARED_PREFS_SUFFIX, 0);
        String string = sharedPreferences.getString(PINPOINT_UNIQUE_ID_KEY, null);
        if (string == null) {
            String str3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str3, "randomUUID().toString()");
            sharedPreferences.edit().putString(PINPOINT_UNIQUE_ID_KEY, string).commit();
            string = str3;
        }
        this.cachedPinpointEndpointId = string;
        return string;
    }

    public final SRPHelper getSrpHelper$aws_auth_cognito_release() {
        SRPHelper sRPHelper = this.srpHelper;
        if (sRPHelper != null) {
            return sRPHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("srpHelper");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUserContextData(java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.amplifyframework.auth.cognito.AuthEnvironment$getUserContextData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.amplifyframework.auth.cognito.AuthEnvironment$getUserContextData$1 r0 = (com.amplifyframework.auth.cognito.AuthEnvironment$getUserContextData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.auth.cognito.AuthEnvironment$getUserContextData$1 r0 = new com.amplifyframework.auth.cognito.AuthEnvironment$getUserContextData$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.amplifyframework.auth.cognito.AuthEnvironment r0 = (com.amplifyframework.auth.cognito.AuthEnvironment) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb8
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            com.amplifyframework.auth.cognito.AuthEnvironment r2 = (com.amplifyframework.auth.cognito.AuthEnvironment) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L61
        L4c:
            kotlin.ResultKt.throwOnFailure(r10)
            com.amplifyframework.auth.cognito.StoreClientBehavior r10 = r8.credentialStoreClient
            com.amplifyframework.statemachine.codegen.data.CredentialType$ASF r2 = com.amplifyframework.statemachine.codegen.data.CredentialType.ASF.INSTANCE
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.loadCredentials(r2, r0)
            if (r10 != r1) goto L60
            return r1
        L60:
            r2 = r8
        L61:
            boolean r4 = r10 instanceof com.amplifyframework.statemachine.codegen.data.AmplifyCredential.ASFDevice
            if (r4 == 0) goto L68
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential$ASFDevice r10 = (com.amplifyframework.statemachine.codegen.data.AmplifyCredential.ASFDevice) r10
            goto L69
        L68:
            r10 = r5
        L69:
            if (r10 != 0) goto L72
            com.amplifyframework.logging.Logger r4 = r2.logger
            java.lang.String r6 = "loadCredentials returned unexpected AmplifyCredential Type."
            r4.warn(r6)
        L72:
            if (r10 == 0) goto L79
            java.lang.String r4 = r10.getId()
            goto L7a
        L79:
            r4 = r5
        L7a:
            if (r4 != 0) goto Lba
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.util.UUID r4 = java.util.UUID.randomUUID()
            r10.append(r4)
            r4 = 58
            r10.append(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            long r6 = r4.getTime()
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential$ASFDevice r4 = new com.amplifyframework.statemachine.codegen.data.AmplifyCredential$ASFDevice
            r4.<init>(r10)
            com.amplifyframework.auth.cognito.StoreClientBehavior r6 = r2.credentialStoreClient
            com.amplifyframework.statemachine.codegen.data.CredentialType$ASF r7 = com.amplifyframework.statemachine.codegen.data.CredentialType.ASF.INSTANCE
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r0 = r6.storeCredentials(r7, r4, r0)
            if (r0 != r1) goto Lb5
            return r1
        Lb5:
            r1 = r9
            r9 = r10
            r0 = r2
        Lb8:
            r2 = r0
            goto Lc0
        Lba:
            java.lang.String r10 = r10.getId()
            r1 = r9
            r9 = r10
        Lc0:
            com.amplifyframework.auth.cognito.asf.UserContextDataProvider r10 = r2.userContextDataProvider
            if (r10 == 0) goto Lc8
            java.lang.String r5 = r10.getEncodedContextData(r1, r9)
        Lc8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.AuthEnvironment.getUserContextData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setSrpHelper$aws_auth_cognito_release(SRPHelper sRPHelper) {
        Intrinsics.checkNotNullParameter(sRPHelper, "<set-?>");
        this.srpHelper = sRPHelper;
    }

    public /* synthetic */ AuthEnvironment(Context context, AuthConfiguration authConfiguration, AWSCognitoAuthService aWSCognitoAuthService, StoreClientBehavior storeClientBehavior, UserContextDataProvider userContextDataProvider, HostedUIClient hostedUIClient, Logger logger, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authConfiguration, aWSCognitoAuthService, storeClientBehavior, (r17 & 16) != 0 ? null : userContextDataProvider, hostedUIClient, logger);
    }
}
