package com.amplifyframework.auth.cognito.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.helpers.CodegenExtensionsKt;
import com.amplifyframework.core.store.KeyValueRepository;
import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.AuthCredentialStore;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.FederatedToken;
import com.amplifyframework.statemachine.codegen.data.IdentityPoolConfiguration;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: AWSCognitoLegacyCredentialStore.kt */
/* loaded from: classes.dex */
public final class AWSCognitoLegacyCredentialStore implements AuthCredentialStore {
    private static final String AK_KEY = "accessKey";
    public static final String APP_DEVICE_INFO_CACHE = "CognitoIdentityProviderDeviceCache";
    private static final String APP_LAST_AUTH_USER = "LastAuthUser";
    private static final String APP_LOCAL_CACHE_KEY_PREFIX = "CognitoIdentityProvider";
    public static final String APP_TOKENS_INFO_CACHE = "CognitoIdentityProviderCache";
    public static final String AWS_KEY_VALUE_STORE_NAMESPACE_IDENTIFIER = "com.amazonaws.android.auth";
    public static final String AWS_MOBILE_CLIENT_PROVIDER = "com.amazonaws.mobile.client";
    public static final Companion Companion = new Companion(null);
    private static final String DEVICE_GROUP_KEY = "DeviceGroupKey";
    private static final String DEVICE_KEY = "DeviceKey";
    private static final String DEVICE_SECRET_KEY = "DeviceSecret";
    private static final String EXP_KEY = "expirationDate";
    private static final String ID_KEY = "identityId";
    private static final String LOCAL_STORAGE_DEVICE_ID_KEY = "CognitoDeviceId";
    public static final String LOCAL_STORAGE_PATH = "AWS.Cognito.ContextData";
    public static final String PROVIDER_KEY = "provider";
    public static final String SIGN_IN_MODE_KEY = "signInMode";
    private static final String SK_KEY = "secretKey";
    private static final String ST_KEY = "sessionToken";
    private static final String TOKEN_EXPIRATION = "tokenExpiration";
    public static final String TOKEN_KEY = "token";
    private static final String TOKEN_TYPE_ACCESS = "accessToken";
    private static final String TOKEN_TYPE_ID = "idToken";
    private static final String TOKEN_TYPE_REFRESH = "refreshToken";
    private final AuthConfiguration authConfiguration;
    private final Context context;
    private KeyValueRepository deviceKeyValue;
    private final Lazy idAndCredentialsKeyValue$delegate;
    private final KeyValueRepositoryFactory keyValueRepoFactory;
    private final Lazy mobileClientKeyValue$delegate;
    private final Lazy tokensKeyValue$delegate;
    private final String userDeviceDetailsCacheKey;

    /* compiled from: AWSCognitoLegacyCredentialStore.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AWSCognitoLegacyCredentialStore(Context context, AuthConfiguration authConfiguration, KeyValueRepositoryFactory keyValueRepoFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authConfiguration, "authConfiguration");
        Intrinsics.checkNotNullParameter(keyValueRepoFactory, "keyValueRepoFactory");
        this.context = context;
        this.authConfiguration = authConfiguration;
        this.keyValueRepoFactory = keyValueRepoFactory;
        StringBuilder sb = new StringBuilder("CognitoIdentityProviderDeviceCache.");
        UserPoolConfiguration userPool = authConfiguration.getUserPool();
        this.userDeviceDetailsCacheKey = ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, userPool != null ? userPool.getPoolId() : null, ".%s");
        this.idAndCredentialsKeyValue$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KeyValueRepository>() { // from class: com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore$idAndCredentialsKeyValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KeyValueRepository invoke() {
                KeyValueRepositoryFactory keyValueRepositoryFactory;
                keyValueRepositoryFactory = AWSCognitoLegacyCredentialStore.this.keyValueRepoFactory;
                return KeyValueRepositoryFactory.create$default(keyValueRepositoryFactory, AWSCognitoLegacyCredentialStore.this.getContext(), AWSCognitoLegacyCredentialStore.AWS_KEY_VALUE_STORE_NAMESPACE_IDENTIFIER, false, 4, null);
            }
        });
        this.mobileClientKeyValue$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KeyValueRepository>() { // from class: com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore$mobileClientKeyValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KeyValueRepository invoke() {
                KeyValueRepositoryFactory keyValueRepositoryFactory;
                keyValueRepositoryFactory = AWSCognitoLegacyCredentialStore.this.keyValueRepoFactory;
                return KeyValueRepositoryFactory.create$default(keyValueRepositoryFactory, AWSCognitoLegacyCredentialStore.this.getContext(), AWSCognitoLegacyCredentialStore.AWS_MOBILE_CLIENT_PROVIDER, false, 4, null);
            }
        });
        this.tokensKeyValue$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KeyValueRepository>() { // from class: com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore$tokensKeyValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KeyValueRepository invoke() {
                KeyValueRepositoryFactory keyValueRepositoryFactory;
                keyValueRepositoryFactory = AWSCognitoLegacyCredentialStore.this.keyValueRepoFactory;
                return KeyValueRepositoryFactory.create$default(keyValueRepositoryFactory, AWSCognitoLegacyCredentialStore.this.getContext(), AWSCognitoLegacyCredentialStore.APP_TOKENS_INFO_CACHE, false, 4, null);
            }
        });
    }

    private final void deleteAWSCredentials() {
        KeyValueRepository idAndCredentialsKeyValue = getIdAndCredentialsKeyValue();
        idAndCredentialsKeyValue.remove(namespace(AK_KEY));
        idAndCredentialsKeyValue.remove(namespace(SK_KEY));
        idAndCredentialsKeyValue.remove(namespace(ST_KEY));
        idAndCredentialsKeyValue.remove(namespace(EXP_KEY));
    }

    private final void deleteCognitoUserPoolTokens() {
        Map<String, String> tokenKeys = getTokenKeys();
        String str = tokenKeys.get(TOKEN_TYPE_ID);
        if (str != null) {
            getTokensKeyValue().remove(str);
        }
        String str2 = tokenKeys.get(TOKEN_TYPE_ACCESS);
        if (str2 != null) {
            getTokensKeyValue().remove(str2);
        }
        String str3 = tokenKeys.get(TOKEN_TYPE_REFRESH);
        if (str3 != null) {
            getTokensKeyValue().remove(str3);
        }
        String str4 = tokenKeys.get(TOKEN_EXPIRATION);
        if (str4 != null) {
            getTokensKeyValue().remove(str4);
        }
    }

    private final void deleteIdentityId() {
        getIdAndCredentialsKeyValue().remove(namespace(ID_KEY));
    }

    private final KeyValueRepository getIdAndCredentialsKeyValue() {
        return (KeyValueRepository) this.idAndCredentialsKeyValue$delegate.getValue();
    }

    private final String getIdentityPoolId() {
        IdentityPoolConfiguration identityPool = this.authConfiguration.getIdentityPool();
        if (identityPool != null) {
            return identityPool.getPoolId();
        }
        return null;
    }

    private final KeyValueRepository getMobileClientKeyValue() {
        return (KeyValueRepository) this.mobileClientKeyValue$delegate.getValue();
    }

    private final Map<String, String> getTokenKeys() {
        String str;
        UserPoolConfiguration userPool = this.authConfiguration.getUserPool();
        if (userPool != null) {
            str = userPool.getAppClient();
        } else {
            str = null;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, "%s.%s.%s", Arrays.copyOf(new Object[]{APP_LOCAL_CACHE_KEY_PREFIX, str, APP_LAST_AUTH_USER}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        String str2 = getTokensKeyValue().get(format);
        String format2 = String.format(locale, "%s.%s.%s.%s", Arrays.copyOf(new Object[]{APP_LOCAL_CACHE_KEY_PREFIX, str, str2, TOKEN_TYPE_ID}, 4));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        String format3 = String.format(locale, "%s.%s.%s.%s", Arrays.copyOf(new Object[]{APP_LOCAL_CACHE_KEY_PREFIX, str, str2, TOKEN_TYPE_ACCESS}, 4));
        Intrinsics.checkNotNullExpressionValue(format3, "format(locale, format, *args)");
        String format4 = String.format(locale, "%s.%s.%s.%s", Arrays.copyOf(new Object[]{APP_LOCAL_CACHE_KEY_PREFIX, str, str2, TOKEN_TYPE_REFRESH}, 4));
        Intrinsics.checkNotNullExpressionValue(format4, "format(locale, format, *args)");
        String format5 = String.format(locale, "%s.%s.%s.%s", Arrays.copyOf(new Object[]{APP_LOCAL_CACHE_KEY_PREFIX, str, str2, TOKEN_EXPIRATION}, 4));
        Intrinsics.checkNotNullExpressionValue(format5, "format(locale, format, *args)");
        return MapsKt__MapsKt.mapOf(new Pair(APP_LAST_AUTH_USER, format), new Pair(TOKEN_TYPE_ID, format2), new Pair(TOKEN_TYPE_ACCESS, format3), new Pair(TOKEN_TYPE_REFRESH, format4), new Pair(TOKEN_EXPIRATION, format5));
    }

    private final KeyValueRepository getTokensKeyValue() {
        return (KeyValueRepository) this.tokensKeyValue$delegate.getValue();
    }

    private final String namespace(String str) {
        return getIdentityPoolId() + '.' + str;
    }

    private final AWSCredentials retrieveAWSCredentials() {
        Long l;
        String str = getIdAndCredentialsKeyValue().get(namespace(AK_KEY));
        String str2 = getIdAndCredentialsKeyValue().get(namespace(SK_KEY));
        String str3 = getIdAndCredentialsKeyValue().get(namespace(ST_KEY));
        String str4 = getIdAndCredentialsKeyValue().get(namespace(EXP_KEY));
        if (str4 != null) {
            l = StringsKt__StringNumberConversionsKt.toLongOrNull(str4);
        } else {
            l = null;
        }
        if (str == null && str2 == null && str3 == null) {
            return null;
        }
        return new AWSCredentials(str, str2, str3, l);
    }

    private final CognitoUserPoolTokens retrieveCognitoUserPoolTokens(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        Long l;
        String str4;
        String str5 = map.get(TOKEN_TYPE_ID);
        if (str5 != null) {
            str = getTokensKeyValue().get(str5);
        } else {
            str = null;
        }
        String str6 = map.get(TOKEN_TYPE_ACCESS);
        if (str6 != null) {
            str2 = getTokensKeyValue().get(str6);
        } else {
            str2 = null;
        }
        String str7 = map.get(TOKEN_TYPE_REFRESH);
        if (str7 != null) {
            str3 = getTokensKeyValue().get(str7);
        } else {
            str3 = null;
        }
        String str8 = map.get(TOKEN_EXPIRATION);
        if (str8 != null && (str4 = getTokensKeyValue().get(str8)) != null) {
            l = StringsKt__StringNumberConversionsKt.toLongOrNull(str4);
        } else {
            l = null;
        }
        if (str == null && str2 == null && str3 == null) {
            return null;
        }
        return new CognitoUserPoolTokens(str, str2, str3, l);
    }

    private final FederatedToken retrieveFederateToIdentityPoolToken() {
        String str;
        String str2 = getMobileClientKeyValue().get("provider");
        if (str2 == null || (str = getMobileClientKeyValue().get(TOKEN_KEY)) == null) {
            return null;
        }
        AuthProvider amazon = AuthProvider.amazon();
        Intrinsics.checkNotNullExpressionValue(amazon, "amazon()");
        String identityProviderName = CodegenExtensionsKt.getIdentityProviderName(amazon);
        AuthProvider facebook = AuthProvider.facebook();
        Intrinsics.checkNotNullExpressionValue(facebook, "facebook()");
        String identityProviderName2 = CodegenExtensionsKt.getIdentityProviderName(facebook);
        AuthProvider apple = AuthProvider.apple();
        Intrinsics.checkNotNullExpressionValue(apple, "apple()");
        String identityProviderName3 = CodegenExtensionsKt.getIdentityProviderName(apple);
        AuthProvider google = AuthProvider.google();
        Intrinsics.checkNotNullExpressionValue(google, "google()");
        if (!CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{identityProviderName, identityProviderName2, identityProviderName3, CodegenExtensionsKt.getIdentityProviderName(google)}).contains(str2)) {
            return null;
        }
        return new FederatedToken(str2, str);
    }

    private final String retrieveIdentityId() {
        return getIdAndCredentialsKeyValue().get(namespace(ID_KEY));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:            if (r1 == null) goto L12;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.amplifyframework.statemachine.codegen.data.SignedInData retrieveSignedInData() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.util.Map r1 = r8.getTokenKeys()
            com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens r7 = r8.retrieveCognitoUserPoolTokens(r1)
            r1 = 0
            if (r7 != 0) goto Le
            return r1
        Le:
            com.amplifyframework.statemachine.codegen.data.SignInMethod r6 = r8.retrieveUserPoolSignInMethod()
            if (r6 != 0) goto L15
            return r1
        L15:
            java.lang.String r1 = r7.getAccessToken()     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L23
            com.amplifyframework.auth.cognito.helpers.SessionHelper r2 = com.amplifyframework.auth.cognito.helpers.SessionHelper.INSTANCE     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = r2.getUserSub(r1)     // Catch: java.lang.Exception -> L26
            if (r1 != 0) goto L24
        L23:
            r1 = r0
        L24:
            r3 = r1
            goto L27
        L26:
            r3 = r0
        L27:
            java.lang.String r1 = r7.getAccessToken()     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto L37
            com.amplifyframework.auth.cognito.helpers.SessionHelper r2 = com.amplifyframework.auth.cognito.helpers.SessionHelper.INSTANCE     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = r2.getUsername(r1)     // Catch: java.lang.Exception -> L37
            if (r1 != 0) goto L36
            goto L37
        L36:
            r0 = r1
        L37:
            r4 = r0
            com.amplifyframework.statemachine.codegen.data.SignedInData r0 = new com.amplifyframework.statemachine.codegen.data.SignedInData
            java.util.Date r5 = new java.util.Date
            r1 = 0
            r5.<init>(r1)
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore.retrieveSignedInData():com.amplifyframework.statemachine.codegen.data.SignedInData");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final SignInMethod retrieveUserPoolSignInMethod() {
        SignInMethod apiBased;
        String str = getMobileClientKeyValue().get(SIGN_IN_MODE_KEY);
        if (str != null) {
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        if (retrieveFederateToIdentityPoolToken() != null) {
                            return null;
                        }
                        apiBased = new SignInMethod.ApiBased(SignInMethod.ApiBased.AuthType.UNKNOWN);
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        apiBased = new SignInMethod.HostedUI((String) null, 1, (DefaultConstructorMarker) null);
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        return null;
                    }
                    break;
            }
            return apiBased;
        }
        return new SignInMethod.ApiBased(SignInMethod.ApiBased.AuthType.USER_SRP_AUTH);
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteASFDevice() {
        this.context.getSharedPreferences(LOCAL_STORAGE_PATH, 0).edit().remove(LOCAL_STORAGE_DEVICE_ID_KEY).apply();
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteCredential() {
        deleteAWSCredentials();
        deleteIdentityId();
        deleteCognitoUserPoolTokens();
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteDeviceKeyCredential(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        String str = getTokenKeys().get(APP_LAST_AUTH_USER);
        if (str != null) {
            getTokensKeyValue().remove(str);
        }
        KeyValueRepository keyValueRepository = this.deviceKeyValue;
        if (keyValueRepository != null) {
            keyValueRepository.remove(DEVICE_KEY);
            keyValueRepository.remove(DEVICE_GROUP_KEY);
            keyValueRepository.remove(DEVICE_SECRET_KEY);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceKeyValue");
        throw null;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public synchronized AmplifyCredential.ASFDevice retrieveASFDevice() {
        String str;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(LOCAL_STORAGE_PATH, 0);
        str = null;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString(LOCAL_STORAGE_DEVICE_ID_KEY, null);
        }
        return new AmplifyCredential.ASFDevice(str);
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public synchronized AmplifyCredential retrieveCredential() {
        AmplifyCredential amplifyCredential;
        SignedInData retrieveSignedInData = retrieveSignedInData();
        AWSCredentials retrieveAWSCredentials = retrieveAWSCredentials();
        String retrieveIdentityId = retrieveIdentityId();
        if (retrieveAWSCredentials != null && retrieveIdentityId != null) {
            FederatedToken retrieveFederateToIdentityPoolToken = retrieveFederateToIdentityPoolToken();
            if (retrieveSignedInData != null) {
                amplifyCredential = new AmplifyCredential.UserAndIdentityPool(retrieveSignedInData, retrieveIdentityId, retrieveAWSCredentials);
            } else if (retrieveFederateToIdentityPoolToken != null) {
                amplifyCredential = new AmplifyCredential.IdentityPoolFederated(retrieveFederateToIdentityPoolToken, retrieveIdentityId, retrieveAWSCredentials);
            } else {
                amplifyCredential = new AmplifyCredential.IdentityPool(retrieveIdentityId, retrieveAWSCredentials);
            }
        } else if (retrieveSignedInData != null) {
            amplifyCredential = new AmplifyCredential.UserPool(retrieveSignedInData);
        } else {
            amplifyCredential = AmplifyCredential.Empty.INSTANCE;
        }
        return amplifyCredential;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:            r9 = com.amplifyframework.statemachine.codegen.data.DeviceMetadata.Empty.INSTANCE;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.amplifyframework.statemachine.codegen.data.DeviceMetadata retrieveDeviceMetadata(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "username"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r8.userDeviceDetailsCacheKey     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r9 = new java.lang.Object[]{r9}     // Catch: java.lang.Throwable -> L85
            r1 = 1
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)     // Catch: java.lang.Throwable -> L85
            java.lang.String r4 = java.lang.String.format(r0, r9)     // Catch: java.lang.Throwable -> L85
            java.lang.String r9 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)     // Catch: java.lang.Throwable -> L85
            com.amplifyframework.auth.cognito.data.KeyValueRepositoryFactory r2 = r8.keyValueRepoFactory     // Catch: java.lang.Throwable -> L85
            android.content.Context r3 = r8.context     // Catch: java.lang.Throwable -> L85
            r5 = 0
            r6 = 4
            r7 = 0
            com.amplifyframework.core.store.KeyValueRepository r9 = com.amplifyframework.auth.cognito.data.KeyValueRepositoryFactory.create$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L85
            r8.deviceKeyValue = r9     // Catch: java.lang.Throwable -> L85
            r0 = 0
            if (r9 == 0) goto L7f
            java.lang.String r2 = "DeviceKey"
            java.lang.String r9 = r9.get(r2)     // Catch: java.lang.Throwable -> L85
            com.amplifyframework.core.store.KeyValueRepository r2 = r8.deviceKeyValue     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L79
            java.lang.String r3 = "DeviceGroupKey"
            java.lang.String r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L85
            com.amplifyframework.core.store.KeyValueRepository r3 = r8.deviceKeyValue     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L73
            java.lang.String r0 = "DeviceSecret"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L85
            r3 = 0
            if (r9 == 0) goto L51
            int r4 = r9.length()     // Catch: java.lang.Throwable -> L85
            if (r4 != 0) goto L4f
            goto L51
        L4f:
            r4 = r3
            goto L52
        L51:
            r4 = r1
        L52:
            if (r4 == 0) goto L63
            if (r2 == 0) goto L5e
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L85
            if (r4 != 0) goto L5d
            goto L5e
        L5d:
            r1 = r3
        L5e:
            if (r1 == 0) goto L63
            com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Empty r9 = com.amplifyframework.statemachine.codegen.data.DeviceMetadata.Empty.INSTANCE     // Catch: java.lang.Throwable -> L85
            goto L71
        L63:
            com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Metadata r1 = new com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Metadata     // Catch: java.lang.Throwable -> L85
            if (r9 != 0) goto L69
            java.lang.String r9 = ""
        L69:
            if (r2 != 0) goto L6d
            java.lang.String r2 = ""
        L6d:
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Throwable -> L85
            r9 = r1
        L71:
            monitor-exit(r8)
            return r9
        L73:
            java.lang.String r9 = "deviceKeyValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch: java.lang.Throwable -> L85
            throw r0     // Catch: java.lang.Throwable -> L85
        L79:
            java.lang.String r9 = "deviceKeyValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch: java.lang.Throwable -> L85
            throw r0     // Catch: java.lang.Throwable -> L85
        L7f:
            java.lang.String r9 = "deviceKeyValue"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch: java.lang.Throwable -> L85
            throw r0     // Catch: java.lang.Throwable -> L85
        L85:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore.retrieveDeviceMetadata(java.lang.String):com.amplifyframework.statemachine.codegen.data.DeviceMetadata");
    }

    public final synchronized String retrieveLastAuthUserId() {
        String str;
        String str2 = getTokenKeys().get(APP_LAST_AUTH_USER);
        if (str2 != null) {
            str = getTokensKeyValue().get(str2);
        } else {
            str = null;
        }
        return str;
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveASFDevice(AmplifyCredential.ASFDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveCredential(AmplifyCredential credential) {
        Intrinsics.checkNotNullParameter(credential, "credential");
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveDeviceMetadata(String username, DeviceMetadata deviceMetadata) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
    }

    public /* synthetic */ AWSCognitoLegacyCredentialStore(Context context, AuthConfiguration authConfiguration, KeyValueRepositoryFactory keyValueRepositoryFactory, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authConfiguration, (r4 & 4) != 0 ? new KeyValueRepositoryFactory() : keyValueRepositoryFactory);
    }
}
