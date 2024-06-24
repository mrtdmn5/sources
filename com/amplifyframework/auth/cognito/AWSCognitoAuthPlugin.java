package com.amplifyframework.auth.cognito;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.annotations.InternalAmplifyApi;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthDevice;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthPlugin;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.asf.UserContextDataProvider;
import com.amplifyframework.auth.cognito.options.FederateToIdentityPoolOptions;
import com.amplifyframework.auth.cognito.result.FederateToIdentityPoolResult;
import com.amplifyframework.auth.exceptions.ConfigurationException;
import com.amplifyframework.auth.exceptions.UnknownException;
import com.amplifyframework.auth.options.AuthConfirmResetPasswordOptions;
import com.amplifyframework.auth.options.AuthConfirmSignInOptions;
import com.amplifyframework.auth.options.AuthConfirmSignUpOptions;
import com.amplifyframework.auth.options.AuthFetchSessionOptions;
import com.amplifyframework.auth.options.AuthResendSignUpCodeOptions;
import com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.logging.LoggingCategory;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import com.amplifyframework.statemachine.codegen.states.AuthState;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.internal.ContextScope;
import org.json.JSONObject;

/* compiled from: AWSCognitoAuthPlugin.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin extends AuthPlugin<AWSCognitoAuthService> {
    public static final String AWS_COGNITO_AUTH_LOG_NAMESPACE = "amplify:aws-cognito-auth:%s";
    private static final String AWS_COGNITO_AUTH_PLUGIN_KEY = "awsCognitoAuthPlugin";
    public static final Companion Companion = new Companion(null);
    private final Logger logger;
    private JSONObject pluginConfigurationJSON;
    private final CoroutineScope pluginScope;
    private final Channel<Job> queueChannel;
    private final Lazy queueFacade$delegate;
    public RealAWSCognitoAuthPlugin realPlugin;

    /* compiled from: AWSCognitoAuthPlugin.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthPlugin() {
        LoggingCategory loggingCategory = Amplify.Logging;
        String format = String.format(AWS_COGNITO_AUTH_LOG_NAMESPACE, Arrays.copyOf(new Object[]{"AWSCognitoAuthPlugin"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Logger forNamespace = loggingCategory.forNamespace(format);
        Intrinsics.checkNotNullExpressionValue(forNamespace, "Logging.forNamespace(AWS…::class.java.simpleName))");
        this.logger = forNamespace;
        ContextScope CoroutineScope = CoroutineScopeKt.CoroutineScope(JobKt.Job$default().plus(Dispatchers.Default));
        this.pluginScope = CoroutineScope;
        this.queueFacade$delegate = LazyKt__LazyJVMKt.lazy(new Function0<KotlinAuthFacadeInternal>() { // from class: com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$queueFacade$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KotlinAuthFacadeInternal invoke() {
                return new KotlinAuthFacadeInternal(AWSCognitoAuthPlugin.this.getRealPlugin$aws_auth_cognito_release());
            }
        });
        BufferedChannel Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, 6);
        BuildersKt.launch$default(CoroutineScope, null, null, new AWSCognitoAuthPlugin$queueChannel$1$1(Channel$default, null), 3);
        this.queueChannel = Channel$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinAuthFacadeInternal getQueueFacade() {
        return (KotlinAuthFacadeInternal) this.queueFacade$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthException toAuthException(Exception exc) {
        if (exc instanceof AuthException) {
            return (AuthException) exc;
        }
        return new UnknownException(null, exc, 1, null);
    }

    public final void clearFederationToIdentityPool(Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$clearFederationToIdentityPool$1(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void configure(JSONObject pluginConfiguration, Context context) throws AmplifyException {
        UserContextDataProvider userContextDataProvider;
        Intrinsics.checkNotNullParameter(pluginConfiguration, "pluginConfiguration");
        Intrinsics.checkNotNullParameter(context, "context");
        this.pluginConfigurationJSON = pluginConfiguration;
        try {
            int r1 = 2;
            AuthState authState = null;
            byte b = 0;
            AuthConfiguration fromJson$aws_auth_cognito_release$default = AuthConfiguration.Companion.fromJson$aws_auth_cognito_release$default(AuthConfiguration.Companion, pluginConfiguration, null, 2, null);
            CredentialStoreClient credentialStoreClient = new CredentialStoreClient(fromJson$aws_auth_cognito_release$default, context, this.logger);
            AWSCognitoAuthService fromConfiguration$aws_auth_cognito_release = AWSCognitoAuthService.Companion.fromConfiguration$aws_auth_cognito_release(fromJson$aws_auth_cognito_release$default);
            UserPoolConfiguration userPool = fromJson$aws_auth_cognito_release$default.getUserPool();
            if (userPool != null) {
                String poolId = userPool.getPoolId();
                Intrinsics.checkNotNull(poolId);
                String appClient = userPool.getAppClient();
                Intrinsics.checkNotNull(appClient);
                userContextDataProvider = new UserContextDataProvider(context, poolId, appClient);
            } else {
                userContextDataProvider = null;
            }
            AuthEnvironment authEnvironment = new AuthEnvironment(context, fromJson$aws_auth_cognito_release$default, fromConfiguration$aws_auth_cognito_release, credentialStoreClient, userContextDataProvider, HostedUIClient.Companion.create(context, fromJson$aws_auth_cognito_release$default.getOauth(), this.logger), this.logger);
            setRealPlugin$aws_auth_cognito_release(new RealAWSCognitoAuthPlugin(fromJson$aws_auth_cognito_release$default, authEnvironment, new AuthStateMachine(authEnvironment, authState, r1, b == true ? 1 : 0), this.logger));
        } catch (Exception e) {
            throw new ConfigurationException("Failed to configure AWSCognitoAuthPlugin.", "Make sure your amplifyconfiguration.json is valid.", e);
        }
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmResetPassword(String username, String newPassword, String confirmationCode, AuthConfirmResetPasswordOptions options, Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmResetPassword$1(this, username, newPassword, confirmationCode, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignIn(String challengeResponse, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(challengeResponse, "challengeResponse");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmSignIn$1(this, challengeResponse, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignUp(String username, String confirmationCode, Consumer<AuthSignUpResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmSignUp$1(this, username, confirmationCode, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmUserAttribute(AuthUserAttributeKey attributeKey, String confirmationCode, Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmUserAttribute$1(this, attributeKey, confirmationCode, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void deleteUser(Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$deleteUser$1(this, onSuccess, onError, null), 1));
    }

    public final void federateToIdentityPool(String providerToken, AuthProvider authProvider, Consumer<FederateToIdentityPoolResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(providerToken, "providerToken");
        Intrinsics.checkNotNullParameter(authProvider, "authProvider");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$federateToIdentityPool$1(this, providerToken, authProvider, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchAuthSession(AuthFetchSessionOptions options, Consumer<AuthSession> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$fetchAuthSession$1(this, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchDevices(Consumer<List<AuthDevice>> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$fetchDevices$1(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchUserAttributes(Consumer<List<AuthUserAttribute>> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$fetchUserAttributes$1(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void forgetDevice(Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$forgetDevice$1(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void getCurrentUser(Consumer<AuthUser> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$getCurrentUser$1(this, onSuccess, onError, null), 1));
    }

    @InternalAmplifyApi
    public final JSONObject getPluginConfiguration() {
        JSONObject jSONObject = this.pluginConfigurationJSON;
        if (jSONObject != null) {
            return jSONObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pluginConfigurationJSON");
        throw null;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getPluginKey() {
        return AWS_COGNITO_AUTH_PLUGIN_KEY;
    }

    public final RealAWSCognitoAuthPlugin getRealPlugin$aws_auth_cognito_release() {
        RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.realPlugin;
        if (realAWSCognitoAuthPlugin != null) {
            return realAWSCognitoAuthPlugin;
        }
        Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        throw null;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getVersion() {
        return "2.5.0";
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void handleWebUISignInResponse(Intent intent) {
        getQueueFacade().handleWebUISignInResponse(intent);
    }

    @Override // com.amplifyframework.auth.AuthPlugin, com.amplifyframework.core.plugin.Plugin
    public void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getRealPlugin$aws_auth_cognito_release().initialize();
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void rememberDevice(Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$rememberDevice$1(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendSignUpCode(String username, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resendSignUpCode$1(this, username, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey attributeKey, AuthResendUserAttributeConfirmationCodeOptions options, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1(this, attributeKey, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resetPassword(String username, AuthResetPasswordOptions options, Consumer<AuthResetPasswordResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resetPassword$1(this, username, options, onSuccess, onError, null), 1));
    }

    public final void setRealPlugin$aws_auth_cognito_release(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin) {
        Intrinsics.checkNotNullParameter(realAWSCognitoAuthPlugin, "<set-?>");
        this.realPlugin = realAWSCognitoAuthPlugin;
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signIn(String str, String str2, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signIn$1(this, str, str2, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithSocialWebUI(AuthProvider provider, Activity callingActivity, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signInWithSocialWebUI$1(this, provider, callingActivity, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithWebUI(Activity callingActivity, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signInWithWebUI$1(this, callingActivity, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signOut(Consumer<AuthSignOutResult> onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signOut$1(this, onComplete, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signUp(String username, String password, AuthSignUpOptions options, Consumer<AuthSignUpResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signUp$1(this, username, password, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updatePassword(String oldPassword, String newPassword, Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$updatePassword$1(this, oldPassword, newPassword, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttribute(AuthUserAttribute attribute, AuthUpdateUserAttributeOptions options, Consumer<AuthUpdateAttributeResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$updateUserAttribute$1(this, attribute, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttributes(List<AuthUserAttribute> attributes, AuthUpdateUserAttributesOptions options, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$updateUserAttributes$1(this, attributes, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public AWSCognitoAuthService getEscapeHatch() {
        return getRealPlugin$aws_auth_cognito_release().escapeHatch();
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmResetPassword(String username, String newPassword, String confirmationCode, Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmResetPassword$2(this, username, newPassword, confirmationCode, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignIn(String challengeResponse, AuthConfirmSignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(challengeResponse, "challengeResponse");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmSignIn$2(this, challengeResponse, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignUp(String username, String confirmationCode, AuthConfirmSignUpOptions options, Consumer<AuthSignUpResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$confirmSignUp$2(this, username, confirmationCode, options, onSuccess, onError, null), 1));
    }

    public final void federateToIdentityPool(String providerToken, AuthProvider authProvider, FederateToIdentityPoolOptions options, Consumer<FederateToIdentityPoolResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(providerToken, "providerToken");
        Intrinsics.checkNotNullParameter(authProvider, "authProvider");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$federateToIdentityPool$2(this, providerToken, authProvider, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchAuthSession(Consumer<AuthSession> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$fetchAuthSession$2(this, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void forgetDevice(AuthDevice device, Action onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$forgetDevice$2(this, device, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendSignUpCode(String username, AuthResendSignUpCodeOptions options, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resendSignUpCode$2(this, username, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey attributeKey, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$2(this, attributeKey, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resetPassword(String username, Consumer<AuthResetPasswordResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$resetPassword$2(this, username, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signIn(String str, String str2, AuthSignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signIn$2(this, str, str2, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithSocialWebUI(AuthProvider provider, Activity callingActivity, AuthWebUISignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signInWithSocialWebUI$2(this, provider, callingActivity, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithWebUI(Activity callingActivity, AuthWebUISignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signInWithWebUI$2(this, callingActivity, options, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signOut(AuthSignOutOptions options, Consumer<AuthSignOutResult> onComplete) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$signOut$2(this, options, onComplete, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttribute(AuthUserAttribute attribute, Consumer<AuthUpdateAttributeResult> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$updateUserAttribute$2(this, attribute, onSuccess, onError, null), 1));
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttributes(List<AuthUserAttribute> attributes, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> onSuccess, Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.queueChannel.mo1701trySendJP2dKIU(BuildersKt.launch$default(this.pluginScope, null, CoroutineStart.LAZY, new AWSCognitoAuthPlugin$updateUserAttributes$2(this, attributes, onSuccess, onError, null), 1));
    }

    public static /* synthetic */ void getRealPlugin$aws_auth_cognito_release$annotations() {
    }
}
