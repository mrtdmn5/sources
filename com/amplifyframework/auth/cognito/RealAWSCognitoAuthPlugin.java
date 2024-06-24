package com.amplifyframework.auth.cognito;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceRememberedStatusType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesResponse;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AWSTemporaryCredentials;
import com.amplifyframework.auth.AuthCategoryBehavior;
import com.amplifyframework.auth.AuthChannelEventName;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthDevice;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter;
import com.amplifyframework.auth.cognito.exceptions.configuration.InvalidOauthConfigurationException;
import com.amplifyframework.auth.cognito.exceptions.configuration.InvalidUserPoolConfigurationException;
import com.amplifyframework.auth.cognito.exceptions.invalidstate.SignedInException;
import com.amplifyframework.auth.cognito.exceptions.service.HostedUISignOutException;
import com.amplifyframework.auth.cognito.exceptions.service.InvalidAccountTypeException;
import com.amplifyframework.auth.cognito.exceptions.service.UserCancelledException;
import com.amplifyframework.auth.cognito.helpers.AuthHelper;
import com.amplifyframework.auth.cognito.helpers.CodegenExtensionsKt;
import com.amplifyframework.auth.cognito.helpers.HostedUIHelper;
import com.amplifyframework.auth.cognito.helpers.SessionHelper;
import com.amplifyframework.auth.cognito.helpers.SignInChallengeHelper;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthConfirmResetPasswordOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthConfirmSignInOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignInOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignOutOptions;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthWebUISignInOptions;
import com.amplifyframework.auth.cognito.options.AuthFlowType;
import com.amplifyframework.auth.cognito.options.FederateToIdentityPoolOptions;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.FederateToIdentityPoolResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.auth.exceptions.ConfigurationException;
import com.amplifyframework.auth.exceptions.InvalidStateException;
import com.amplifyframework.auth.exceptions.SessionExpiredException;
import com.amplifyframework.auth.exceptions.SignedOutException;
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
import com.amplifyframework.auth.result.step.AuthNextSignInStep;
import com.amplifyframework.auth.result.step.AuthNextUpdateAttributeStep;
import com.amplifyframework.auth.result.step.AuthSignInStep;
import com.amplifyframework.auth.result.step.AuthUpdateAttributeStep;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.StateChangeListenerToken;
import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.FederatedToken;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData;
import com.amplifyframework.statemachine.codegen.data.HostedUIErrorData;
import com.amplifyframework.statemachine.codegen.data.HostedUIOptions;
import com.amplifyframework.statemachine.codegen.data.RevokeTokenErrorData;
import com.amplifyframework.statemachine.codegen.data.SignInData;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignOutData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import com.amplifyframework.statemachine.codegen.errors.SessionError;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.DeleteUserEvent;
import com.amplifyframework.statemachine.codegen.events.HostedUIEvent;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import com.amplifyframework.statemachine.codegen.states.AuthState;
import com.amplifyframework.statemachine.codegen.states.AuthenticationState;
import com.amplifyframework.statemachine.codegen.states.AuthorizationState;
import com.amplifyframework.statemachine.codegen.states.DeleteUserState;
import com.amplifyframework.statemachine.codegen.states.HostedUISignInState;
import com.amplifyframework.statemachine.codegen.states.SRPSignInState;
import com.amplifyframework.statemachine.codegen.states.SignInChallengeState;
import com.amplifyframework.statemachine.codegen.states.SignInState;
import com.amplifyframework.statemachine.codegen.states.SignOutState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin implements AuthCategoryBehavior {
    private final AuthEnvironment authEnvironment;
    private final AuthStateMachine authStateMachine;
    private final AuthConfiguration configuration;
    private final AtomicReference<String> lastPublishedHubEventName;
    private final Logger logger;

    public RealAWSCognitoAuthPlugin(AuthConfiguration configuration, AuthEnvironment authEnvironment, AuthStateMachine authStateMachine, Logger logger) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(authEnvironment, "authEnvironment");
        Intrinsics.checkNotNullParameter(authStateMachine, "authStateMachine");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.configuration = configuration;
        this.authEnvironment = authEnvironment;
        this.authStateMachine = authStateMachine;
        this.logger = logger;
        this.lastPublishedHubEventName = new AtomicReference<>();
        addAuthStateChangeListener();
        configureAuthStates();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _clearFederationToIdentityPool(final Action action, final Consumer<AuthException> consumer) {
        _signOut(false, new Consumer(this) { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$$ExternalSyntheticLambda0
            public final /* synthetic */ RealAWSCognitoAuthPlugin f$2;

            {
                this.f$2 = this;
            }

            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                RealAWSCognitoAuthPlugin.m632_clearFederationToIdentityPool$lambda19(consumer, action, this.f$2, (AuthSignOutResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _clearFederationToIdentityPool$lambda-19, reason: not valid java name */
    public static final void m632_clearFederationToIdentityPool$lambda19(Consumer onError, Action onSuccess, RealAWSCognitoAuthPlugin this$0, AuthSignOutResult it) {
        Intrinsics.checkNotNullParameter(onError, "$onError");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof AWSCognitoAuthSignOutResult.FailedSignOut) {
            onError.accept(((AWSCognitoAuthSignOutResult.FailedSignOut) it).getException());
        } else {
            onSuccess.call();
            this$0.sendHubEvent(AWSCognitoAuthChannelEventName.FEDERATION_TO_IDENTITY_POOL_CLEARED.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _confirmSignIn(final String str, final AuthConfirmSignInOptions authConfirmSignInOptions, final Consumer<AuthSignInResult> consumer, final Consumer<AuthException> consumer2) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_confirmSignIn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                AuthStateMachine authStateMachine3;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthenticationState authNState = authState.getAuthNState();
                AuthorizationState authZState = authState.getAuthZState();
                AuthenticationState.SigningIn signingIn = authNState instanceof AuthenticationState.SigningIn ? (AuthenticationState.SigningIn) authNState : null;
                SignInState signInState = signingIn != null ? signingIn.getSignInState() : null;
                if ((authNState instanceof AuthenticationState.SignedIn) && (authZState instanceof AuthorizationState.SessionEstablished)) {
                    authStateMachine3 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine3.cancel(stateChangeListenerToken);
                    consumer.accept(new AuthSignInResult(true, new AuthNextSignInStep(AuthSignInStep.DONE, EmptyMap.INSTANCE, null)));
                    RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SIGNED_IN.toString());
                    return;
                }
                if (signInState instanceof SignInState.Error) {
                    authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine2.cancel(stateChangeListenerToken);
                    consumer2.accept(CognitoAuthExceptionConverter.Companion.lookup(((SignInState.Error) signInState).getException(), "Confirm Sign in failed."));
                } else if (signInState instanceof SignInState.ResolvingChallenge) {
                    SignInState.ResolvingChallenge resolvingChallenge = (SignInState.ResolvingChallenge) signInState;
                    if (resolvingChallenge.getChallengeState() instanceof SignInChallengeState.Error) {
                        authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine.cancel(stateChangeListenerToken);
                        Consumer<AuthException> consumer3 = consumer2;
                        CognitoAuthExceptionConverter.Companion companion = CognitoAuthExceptionConverter.Companion;
                        SignInChallengeState challengeState = resolvingChallenge.getChallengeState();
                        Intrinsics.checkNotNull(challengeState, "null cannot be cast to non-null type com.amplifyframework.statemachine.codegen.states.SignInChallengeState.Error");
                        consumer3.accept(companion.lookup(((SignInChallengeState.Error) challengeState).getException(), "Confirm Sign in failed."));
                    }
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_confirmSignIn$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, String> map;
                AuthStateMachine authStateMachine;
                AuthConfirmSignInOptions authConfirmSignInOptions2 = AuthConfirmSignInOptions.this;
                AWSCognitoAuthConfirmSignInOptions aWSCognitoAuthConfirmSignInOptions = authConfirmSignInOptions2 instanceof AWSCognitoAuthConfirmSignInOptions ? (AWSCognitoAuthConfirmSignInOptions) authConfirmSignInOptions2 : null;
                String str2 = str;
                if (aWSCognitoAuthConfirmSignInOptions == null || (map = aWSCognitoAuthConfirmSignInOptions.getMetadata()) == null) {
                    map = EmptyMap.INSTANCE;
                }
                SignInChallengeEvent signInChallengeEvent = new SignInChallengeEvent(new SignInChallengeEvent.EventType.VerifyChallengeAnswer(str2, map), null, 2, null);
                authStateMachine = this.authStateMachine;
                authStateMachine.send(signInChallengeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[Catch: Exception -> 0x016b, TryCatch #3 {Exception -> 0x016b, blocks: (B:15:0x0151, B:29:0x0064, B:30:0x0099, B:32:0x00ad, B:34:0x00c0, B:35:0x00c6, B:37:0x00d4, B:38:0x00dc, B:40:0x00e6, B:41:0x00ee, B:43:0x00f6, B:45:0x010c, B:46:0x0120, B:48:0x0124, B:50:0x012a, B:51:0x0130), top: B:28:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object _confirmSignUp(java.lang.String r19, java.lang.String r20, com.amplifyframework.auth.options.AuthConfirmSignUpOptions r21, com.amplifyframework.core.Consumer<com.amplifyframework.auth.result.AuthSignUpResult> r22, com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin._confirmSignUp(java.lang.String, java.lang.String, com.amplifyframework.auth.options.AuthConfirmSignUpOptions, com.amplifyframework.core.Consumer, com.amplifyframework.core.Consumer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _deleteUser(final String str, final Action action, final Consumer<AuthException> consumer) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_deleteUser$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Exception] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                Intrinsics.checkNotNullParameter(authState, "authState");
                if (authState instanceof AuthState.Configured) {
                    AuthState.Configured configured = (AuthState.Configured) authState;
                    AuthenticationState component1 = configured.component1();
                    AuthorizationState component2 = configured.component2();
                    Exception exc = ref$ObjectRef.element;
                    if (component2 instanceof AuthorizationState.DeletingUser) {
                        AuthorizationState.DeletingUser deletingUser = (AuthorizationState.DeletingUser) component2;
                        if (deletingUser.getDeleteUserState() instanceof DeleteUserState.Error) {
                            ref$ObjectRef.element = ((DeleteUserState.Error) deletingUser.getDeleteUserState()).getException();
                            return;
                        }
                    }
                    if ((component1 instanceof AuthenticationState.SignedOut) && (component2 instanceof AuthorizationState.Configured)) {
                        this.sendHubEvent(AuthChannelEventName.USER_DELETED.toString());
                        authStateMachine2 = this.authStateMachine;
                        authStateMachine2.cancel(stateChangeListenerToken);
                        action.call();
                        return;
                    }
                    if (!(component2 instanceof AuthorizationState.SessionEstablished) || exc == null) {
                        return;
                    }
                    authStateMachine = this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                    consumer.accept(CognitoAuthExceptionConverter.Companion.lookup(exc, "Request to delete user may have failed. Please check exception stack"));
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_deleteUser$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AuthStateMachine authStateMachine;
                DeleteUserEvent deleteUserEvent = new DeleteUserEvent(new DeleteUserEvent.EventType.DeleteUser(str), null, 2, null);
                authStateMachine = this.authStateMachine;
                authStateMachine.send(deleteUserEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _federateToIdentityPool(final Consumer<FederateToIdentityPoolResult> consumer, final Consumer<AuthException> consumer2) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_federateToIdentityPool$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthenticationState authNState = authState.getAuthNState();
                AuthorizationState authZState = authState.getAuthZState();
                if ((authNState instanceof AuthenticationState.FederatedToIdentityPool) && (authZState instanceof AuthorizationState.SessionEstablished)) {
                    authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine2.cancel(stateChangeListenerToken);
                    AmplifyCredential amplifyCredential = ((AuthorizationState.SessionEstablished) authZState).getAmplifyCredential();
                    AmplifyCredential.IdentityPoolFederated identityPoolFederated = amplifyCredential instanceof AmplifyCredential.IdentityPoolFederated ? (AmplifyCredential.IdentityPoolFederated) amplifyCredential : null;
                    String identityId = identityPoolFederated != null ? identityPoolFederated.getIdentityId() : null;
                    AWSCredentials credentials = identityPoolFederated != null ? identityPoolFederated.getCredentials() : null;
                    com.amplifyframework.auth.AWSCredentials createAWSCredentials = com.amplifyframework.auth.AWSCredentials.Factory.createAWSCredentials(credentials != null ? credentials.getAccessKeyId() : null, credentials != null ? credentials.getSecretAccessKey() : null, credentials != null ? credentials.getSessionToken() : null, credentials != null ? credentials.getExpiration() : null);
                    AWSTemporaryCredentials aWSTemporaryCredentials = createAWSCredentials instanceof AWSTemporaryCredentials ? (AWSTemporaryCredentials) createAWSCredentials : null;
                    if (identityId != null && aWSTemporaryCredentials != null) {
                        consumer.accept(new FederateToIdentityPoolResult(identityId, aWSTemporaryCredentials));
                        RealAWSCognitoAuthPlugin.this.sendHubEvent(AWSCognitoAuthChannelEventName.FEDERATED_TO_IDENTITY_POOL.toString());
                        return;
                    } else {
                        consumer2.accept(new UnknownException("Unable to parse credentials to expected output.", null, 2, null));
                        return;
                    }
                }
                if ((authNState instanceof AuthenticationState.Error) && (authZState instanceof AuthorizationState.Error)) {
                    authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                    consumer2.accept(CognitoAuthExceptionConverter.Companion.lookup(((AuthorizationState.Error) authZState).getException(), "Federation could not be completed."));
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_federateToIdentityPool$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _fetchAuthSession(final Consumer<AuthSession> consumer, Consumer<AuthException> consumer2) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_fetchAuthSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthorizationState authZState = authState.getAuthZState();
                if (authZState instanceof AuthorizationState.SessionEstablished) {
                    authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine2.cancel(stateChangeListenerToken);
                    consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession$default(((AuthorizationState.SessionEstablished) authZState).getAmplifyCredential(), null, 1, null));
                    return;
                }
                if (authZState instanceof AuthorizationState.Error) {
                    authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                    Exception exception = ((AuthorizationState.Error) authZState).getException();
                    if (exception instanceof SessionError) {
                        SessionError sessionError = (SessionError) exception;
                        Exception exception2 = sessionError.getException();
                        if (exception2 instanceof SignedOutException) {
                            consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession(sessionError.getAmplifyCredential(), (AuthException) sessionError.getException()));
                            return;
                        } else if (exception2 instanceof SessionExpiredException) {
                            consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession(AmplifyCredential.Empty.INSTANCE, (AuthException) sessionError.getException()));
                            RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SESSION_EXPIRED.toString());
                            return;
                        } else {
                            consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession(sessionError.getAmplifyCredential(), new UnknownException("Fetch auth session failed.", exception)));
                            return;
                        }
                    }
                    if (exception instanceof ConfigurationException) {
                        consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession(AmplifyCredential.Empty.INSTANCE, new InvalidAccountTypeException(exception)));
                    } else {
                        consumer.accept(AWSCognitoAuthSessionKt.getCognitoSession(AmplifyCredential.Empty.INSTANCE, new UnknownException("Fetch auth session failed.", exception)));
                    }
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _fetchDevices(Consumer<List<AuthDevice>> consumer, Consumer<AuthException> consumer2) {
        BuildersKt.async$default(GlobalScope.INSTANCE, null, new RealAWSCognitoAuthPlugin$_fetchDevices$1(this, consumer, consumer2, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(14:11|12|13|14|15|(1:40)(3:19|(1:21)(1:39)|22)|23|(1:38)|(1:28)(1:37)|29|(1:31)|32|33|34)(2:41|42))(2:43|44))(10:69|70|71|(1:73)(1:88)|(1:75)(1:87)|76|77|78|79|(1:81)(1:82))|45|(11:47|(1:49)(1:67)|50|(1:52)(1:66)|53|(1:55)(1:65)|56|(1:58)|(1:60)|61|(1:63)(15:64|13|14|15|(1:17)|40|23|(1:25)|38|(0)(0)|29|(0)|32|33|34))(13:68|15|(0)|40|23|(0)|38|(0)(0)|29|(0)|32|33|34)))|93|6|7|(0)(0)|45|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0061, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b8, code lost:            r10 = r2;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0152 A[Catch: Exception -> 0x0061, TRY_ENTER, TryCatch #2 {Exception -> 0x0061, blocks: (B:12:0x003c, B:13:0x0144, B:17:0x0152, B:19:0x0156, B:21:0x0167, B:22:0x016d, B:23:0x0185, B:25:0x0189, B:28:0x0195, B:29:0x019d, B:31:0x01a3, B:32:0x01aa, B:44:0x005d, B:45:0x00a2, B:47:0x00b6, B:49:0x00c5, B:50:0x00cb, B:52:0x00db, B:53:0x00e3, B:55:0x00ed, B:56:0x00f5, B:58:0x00ff, B:60:0x0115, B:61:0x0129), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0189 A[Catch: Exception -> 0x0061, TryCatch #2 {Exception -> 0x0061, blocks: (B:12:0x003c, B:13:0x0144, B:17:0x0152, B:19:0x0156, B:21:0x0167, B:22:0x016d, B:23:0x0185, B:25:0x0189, B:28:0x0195, B:29:0x019d, B:31:0x01a3, B:32:0x01aa, B:44:0x005d, B:45:0x00a2, B:47:0x00b6, B:49:0x00c5, B:50:0x00cb, B:52:0x00db, B:53:0x00e3, B:55:0x00ed, B:56:0x00f5, B:58:0x00ff, B:60:0x0115, B:61:0x0129), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0195 A[Catch: Exception -> 0x0061, TryCatch #2 {Exception -> 0x0061, blocks: (B:12:0x003c, B:13:0x0144, B:17:0x0152, B:19:0x0156, B:21:0x0167, B:22:0x016d, B:23:0x0185, B:25:0x0189, B:28:0x0195, B:29:0x019d, B:31:0x01a3, B:32:0x01aa, B:44:0x005d, B:45:0x00a2, B:47:0x00b6, B:49:0x00c5, B:50:0x00cb, B:52:0x00db, B:53:0x00e3, B:55:0x00ed, B:56:0x00f5, B:58:0x00ff, B:60:0x0115, B:61:0x0129), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a3 A[Catch: Exception -> 0x0061, TryCatch #2 {Exception -> 0x0061, blocks: (B:12:0x003c, B:13:0x0144, B:17:0x0152, B:19:0x0156, B:21:0x0167, B:22:0x016d, B:23:0x0185, B:25:0x0189, B:28:0x0195, B:29:0x019d, B:31:0x01a3, B:32:0x01aa, B:44:0x005d, B:45:0x00a2, B:47:0x00b6, B:49:0x00c5, B:50:0x00cb, B:52:0x00db, B:53:0x00e3, B:55:0x00ed, B:56:0x00f5, B:58:0x00ff, B:60:0x0115, B:61:0x0129), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b6 A[Catch: Exception -> 0x0061, TryCatch #2 {Exception -> 0x0061, blocks: (B:12:0x003c, B:13:0x0144, B:17:0x0152, B:19:0x0156, B:21:0x0167, B:22:0x016d, B:23:0x0185, B:25:0x0189, B:28:0x0195, B:29:0x019d, B:31:0x01a3, B:32:0x01aa, B:44:0x005d, B:45:0x00a2, B:47:0x00b6, B:49:0x00c5, B:50:0x00cb, B:52:0x00db, B:53:0x00e3, B:55:0x00ed, B:56:0x00f5, B:58:0x00ff, B:60:0x0115, B:61:0x0129), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.amplifyframework.core.Consumer] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object _resendSignUpCode(java.lang.String r19, com.amplifyframework.auth.options.AuthResendSignUpCodeOptions r20, com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthCodeDeliveryDetails> r21, com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin._resendSignUpCode(java.lang.String, com.amplifyframework.auth.options.AuthResendSignUpCodeOptions, com.amplifyframework.core.Consumer, com.amplifyframework.core.Consumer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _signIn(final String str, final String str2, final AWSCognitoAuthSignInOptions aWSCognitoAuthSignInOptions, final Consumer<AuthSignInResult> consumer, final Consumer<AuthException> consumer2) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signIn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                AuthStateMachine authStateMachine3;
                AuthStateMachine authStateMachine4;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthenticationState authNState = authState.getAuthNState();
                AuthorizationState authZState = authState.getAuthZState();
                if (authNState instanceof AuthenticationState.SigningIn) {
                    SignInState signInState = ((AuthenticationState.SigningIn) authNState).getSignInState();
                    SignInState.SigningInWithSRP signingInWithSRP = signInState instanceof SignInState.SigningInWithSRP ? (SignInState.SigningInWithSRP) signInState : null;
                    SRPSignInState srpSignInState = signingInWithSRP != null ? signingInWithSRP.getSrpSignInState() : null;
                    SignInState.ResolvingChallenge resolvingChallenge = signInState instanceof SignInState.ResolvingChallenge ? (SignInState.ResolvingChallenge) signInState : null;
                    SignInChallengeState challengeState = resolvingChallenge != null ? resolvingChallenge.getChallengeState() : null;
                    if (srpSignInState instanceof SRPSignInState.Error) {
                        authStateMachine4 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine4.cancel(stateChangeListenerToken);
                        consumer2.accept(CognitoAuthExceptionConverter.Companion.lookup(((SRPSignInState.Error) srpSignInState).getException(), "Sign in failed."));
                        return;
                    } else if (signInState instanceof SignInState.Error) {
                        authStateMachine3 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine3.cancel(stateChangeListenerToken);
                        consumer2.accept(CognitoAuthExceptionConverter.Companion.lookup(((SignInState.Error) signInState).getException(), "Sign in failed."));
                        return;
                    } else {
                        if (challengeState instanceof SignInChallengeState.WaitingForAnswer) {
                            authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                            authStateMachine2.cancel(stateChangeListenerToken);
                            SignInChallengeHelper.INSTANCE.getNextStep(((SignInChallengeState.WaitingForAnswer) challengeState).getChallenge(), consumer, consumer2);
                            return;
                        }
                        return;
                    }
                }
                if ((authNState instanceof AuthenticationState.SignedIn) && (authZState instanceof AuthorizationState.SessionEstablished)) {
                    authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                    consumer.accept(new AuthSignInResult(true, new AuthNextSignInStep(AuthSignInStep.DONE, EmptyMap.INSTANCE, null)));
                    RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SIGNED_IN.toString());
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signIn$2

            /* compiled from: RealAWSCognitoAuthPlugin.kt */
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[AuthFlowType.values().length];
                    r0[AuthFlowType.USER_SRP_AUTH.ordinal()] = 1;
                    r0[AuthFlowType.CUSTOM_AUTH.ordinal()] = 2;
                    r0[AuthFlowType.CUSTOM_AUTH_WITHOUT_SRP.ordinal()] = 3;
                    r0[AuthFlowType.CUSTOM_AUTH_WITH_SRP.ordinal()] = 4;
                    r0[AuthFlowType.USER_PASSWORD_AUTH.ordinal()] = 5;
                    $EnumSwitchMapping$0 = r0;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SignInData sRPSignInData;
                AuthStateMachine authStateMachine;
                AuthFlowType authFlowType = AWSCognitoAuthSignInOptions.this.getAuthFlowType();
                if (authFlowType == null) {
                    authFlowType = this.configuration.getAuthFlowType();
                }
                int r0 = WhenMappings.$EnumSwitchMapping$0[authFlowType.ordinal()];
                if (r0 == 1) {
                    String str3 = str;
                    String str4 = str2;
                    Map<String, String> metadata = AWSCognitoAuthSignInOptions.this.getMetadata();
                    Intrinsics.checkNotNullExpressionValue(metadata, "options.metadata");
                    sRPSignInData = new SignInData.SRPSignInData(str3, str4, metadata);
                } else if (r0 == 2 || r0 == 3) {
                    String str5 = str;
                    Map<String, String> metadata2 = AWSCognitoAuthSignInOptions.this.getMetadata();
                    Intrinsics.checkNotNullExpressionValue(metadata2, "options.metadata");
                    sRPSignInData = new SignInData.CustomAuthSignInData(str5, metadata2);
                } else if (r0 == 4) {
                    String str6 = str;
                    String str7 = str2;
                    Map<String, String> metadata3 = AWSCognitoAuthSignInOptions.this.getMetadata();
                    Intrinsics.checkNotNullExpressionValue(metadata3, "options.metadata");
                    sRPSignInData = new SignInData.CustomSRPAuthSignInData(str6, str7, metadata3);
                } else {
                    if (r0 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String str8 = str;
                    String str9 = str2;
                    Map<String, String> metadata4 = AWSCognitoAuthSignInOptions.this.getMetadata();
                    Intrinsics.checkNotNullExpressionValue(metadata4, "options.metadata");
                    sRPSignInData = new SignInData.MigrationAuthSignInData(str8, str9, metadata4);
                }
                AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignInRequested(sRPSignInData), null, 2, null);
                authStateMachine = this.authStateMachine;
                authStateMachine.send(authenticationEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _signInWithHostedUI(final Activity activity, final AuthWebUISignInOptions authWebUISignInOptions, final Consumer<AuthSignInResult> consumer, final Consumer<AuthException> consumer2, final AuthProvider authProvider) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signInWithHostedUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                AuthException unknownException;
                AuthStateMachine authStateMachine3;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthenticationState authNState = authState.getAuthNState();
                AuthorizationState authZState = authState.getAuthZState();
                if (authNState instanceof AuthenticationState.SigningIn) {
                    HostedUISignInState hostedUISignInState = ((AuthenticationState.SigningIn) authNState).getSignInState().getHostedUISignInState();
                    if (hostedUISignInState instanceof HostedUISignInState.Error) {
                        authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine2.cancel(stateChangeListenerToken);
                        Exception exception = ((HostedUISignInState.Error) hostedUISignInState).getException();
                        Consumer<AuthException> consumer3 = consumer2;
                        if (exception instanceof AuthException) {
                            unknownException = (AuthException) exception;
                        } else {
                            unknownException = new UnknownException("Sign in failed", exception);
                        }
                        consumer3.accept(unknownException);
                        authStateMachine3 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine3.send(new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignIn(null, 1, null), null, 2, null));
                        return;
                    }
                    return;
                }
                if ((authNState instanceof AuthenticationState.SignedIn) && (authZState instanceof AuthorizationState.SessionEstablished)) {
                    authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                    consumer.accept(new AuthSignInResult(true, new AuthNextSignInStep(AuthSignInStep.DONE, EmptyMap.INSTANCE, null)));
                    RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SIGNED_IN.toString());
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signInWithHostedUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AuthStateMachine authStateMachine;
                HostedUIOptions createHostedUIOptions = HostedUIHelper.INSTANCE.createHostedUIOptions(activity, authProvider, authWebUISignInOptions);
                authStateMachine = this.authStateMachine;
                authStateMachine.send(new AuthenticationEvent(new AuthenticationEvent.EventType.SignInRequested(new SignInData.HostedUISignInData(createHostedUIOptions)), null, 2, null));
            }
        });
    }

    public static /* synthetic */ void _signInWithHostedUI$default(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2, AuthProvider authProvider, int r12, Object obj) {
        if ((r12 & 16) != 0) {
            authProvider = null;
        }
        realAWSCognitoAuthPlugin._signInWithHostedUI(activity, authWebUISignInOptions, consumer, consumer2, authProvider);
    }

    private final void _signOut(final boolean z, final Consumer<AuthSignOutResult> consumer) {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signOut$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                AuthStateMachine authStateMachine2;
                Intrinsics.checkNotNullParameter(authState, "authState");
                if (authState instanceof AuthState.Configured) {
                    AuthState.Configured configured = (AuthState.Configured) authState;
                    AuthenticationState component1 = configured.component1();
                    AuthorizationState component2 = configured.component2();
                    if ((component1 instanceof AuthenticationState.SignedOut) && (component2 instanceof AuthorizationState.Configured)) {
                        authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine2.cancel(stateChangeListenerToken);
                        AuthenticationState.SignedOut signedOut = (AuthenticationState.SignedOut) component1;
                        if (signedOut.getSignedOutData().getHasError()) {
                            SignedOutData signedOutData = signedOut.getSignedOutData();
                            Consumer<AuthSignOutResult> consumer2 = consumer;
                            HostedUIErrorData hostedUIErrorData = signedOutData.getHostedUIErrorData();
                            HostedUIError hostedUIError = hostedUIErrorData != null ? new HostedUIError(hostedUIErrorData) : null;
                            GlobalSignOutErrorData globalSignOutErrorData = signedOutData.getGlobalSignOutErrorData();
                            GlobalSignOutError globalSignOutError = globalSignOutErrorData != null ? new GlobalSignOutError(globalSignOutErrorData) : null;
                            RevokeTokenErrorData revokeTokenErrorData = signedOutData.getRevokeTokenErrorData();
                            consumer2.accept(new AWSCognitoAuthSignOutResult.PartialSignOut(hostedUIError, globalSignOutError, revokeTokenErrorData != null ? new RevokeTokenError(revokeTokenErrorData) : null));
                            if (z) {
                                RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SIGNED_OUT.toString());
                                return;
                            }
                            return;
                        }
                        consumer.accept(AWSCognitoAuthSignOutResult.CompleteSignOut.INSTANCE);
                        if (z) {
                            RealAWSCognitoAuthPlugin.this.sendHubEvent(AuthChannelEventName.SIGNED_OUT.toString());
                            return;
                        }
                        return;
                    }
                    if (component1 instanceof AuthenticationState.Error) {
                        authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine.cancel(stateChangeListenerToken);
                        consumer.accept(new AWSCognitoAuthSignOutResult.FailedSignOut(CognitoAuthExceptionConverter.Companion.lookup(((AuthenticationState.Error) component1).getException(), "Sign out failed.")));
                    }
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$_signOut$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    public static /* synthetic */ void _signOut$default(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, boolean z, Consumer consumer, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            z = true;
        }
        realAWSCognitoAuthPlugin._signOut(z, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01e3 A[Catch: Exception -> 0x01a8, TRY_ENTER, TryCatch #3 {Exception -> 0x01a8, blocks: (B:17:0x01e3, B:19:0x01e7, B:21:0x01f7, B:22:0x01fd, B:24:0x0217, B:30:0x0223, B:31:0x026d, B:39:0x0233, B:41:0x023d, B:44:0x0249, B:45:0x0251, B:47:0x0257, B:48:0x025f, B:50:0x0267, B:51:0x0269, B:65:0x0067, B:67:0x00e4, B:69:0x00f8, B:71:0x010d, B:72:0x0113, B:74:0x0121, B:75:0x0127, B:77:0x0131, B:78:0x0139, B:80:0x0141, B:82:0x0157, B:83:0x016b, B:85:0x016f, B:87:0x0175, B:88:0x0186, B:90:0x018c, B:92:0x01ab, B:93:0x01b3), top: B:64:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0217 A[Catch: Exception -> 0x01a8, TRY_LEAVE, TryCatch #3 {Exception -> 0x01a8, blocks: (B:17:0x01e3, B:19:0x01e7, B:21:0x01f7, B:22:0x01fd, B:24:0x0217, B:30:0x0223, B:31:0x026d, B:39:0x0233, B:41:0x023d, B:44:0x0249, B:45:0x0251, B:47:0x0257, B:48:0x025f, B:50:0x0267, B:51:0x0269, B:65:0x0067, B:67:0x00e4, B:69:0x00f8, B:71:0x010d, B:72:0x0113, B:74:0x0121, B:75:0x0127, B:77:0x0131, B:78:0x0139, B:80:0x0141, B:82:0x0157, B:83:0x016b, B:85:0x016f, B:87:0x0175, B:88:0x0186, B:90:0x018c, B:92:0x01ab, B:93:0x01b3), top: B:64:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0223 A[Catch: Exception -> 0x01a8, TRY_ENTER, TryCatch #3 {Exception -> 0x01a8, blocks: (B:17:0x01e3, B:19:0x01e7, B:21:0x01f7, B:22:0x01fd, B:24:0x0217, B:30:0x0223, B:31:0x026d, B:39:0x0233, B:41:0x023d, B:44:0x0249, B:45:0x0251, B:47:0x0257, B:48:0x025f, B:50:0x0267, B:51:0x0269, B:65:0x0067, B:67:0x00e4, B:69:0x00f8, B:71:0x010d, B:72:0x0113, B:74:0x0121, B:75:0x0127, B:77:0x0131, B:78:0x0139, B:80:0x0141, B:82:0x0157, B:83:0x016b, B:85:0x016f, B:87:0x0175, B:88:0x0186, B:90:0x018c, B:92:0x01ab, B:93:0x01b3), top: B:64:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0233 A[Catch: Exception -> 0x01a8, TryCatch #3 {Exception -> 0x01a8, blocks: (B:17:0x01e3, B:19:0x01e7, B:21:0x01f7, B:22:0x01fd, B:24:0x0217, B:30:0x0223, B:31:0x026d, B:39:0x0233, B:41:0x023d, B:44:0x0249, B:45:0x0251, B:47:0x0257, B:48:0x025f, B:50:0x0267, B:51:0x0269, B:65:0x0067, B:67:0x00e4, B:69:0x00f8, B:71:0x010d, B:72:0x0113, B:74:0x0121, B:75:0x0127, B:77:0x0131, B:78:0x0139, B:80:0x0141, B:82:0x0157, B:83:0x016b, B:85:0x016f, B:87:0x0175, B:88:0x0186, B:90:0x018c, B:92:0x01ab, B:93:0x01b3), top: B:64:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8 A[Catch: Exception -> 0x01a8, TryCatch #3 {Exception -> 0x01a8, blocks: (B:17:0x01e3, B:19:0x01e7, B:21:0x01f7, B:22:0x01fd, B:24:0x0217, B:30:0x0223, B:31:0x026d, B:39:0x0233, B:41:0x023d, B:44:0x0249, B:45:0x0251, B:47:0x0257, B:48:0x025f, B:50:0x0267, B:51:0x0269, B:65:0x0067, B:67:0x00e4, B:69:0x00f8, B:71:0x010d, B:72:0x0113, B:74:0x0121, B:75:0x0127, B:77:0x0131, B:78:0x0139, B:80:0x0141, B:82:0x0157, B:83:0x016b, B:85:0x016f, B:87:0x0175, B:88:0x0186, B:90:0x018c, B:92:0x01ab, B:93:0x01b3), top: B:64:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object _signUp(java.lang.String r19, java.lang.String r20, com.amplifyframework.auth.options.AuthSignUpOptions r21, com.amplifyframework.core.Consumer<com.amplifyframework.auth.result.AuthSignUpResult> r22, com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin._signUp(java.lang.String, java.lang.String, com.amplifyframework.auth.options.AuthSignUpOptions, com.amplifyframework.core.Consumer, com.amplifyframework.core.Consumer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void _updatePassword(String str, String str2, Action action, Consumer<AuthException> consumer) {
        BuildersKt.async$default(GlobalScope.INSTANCE, null, new RealAWSCognitoAuthPlugin$_updatePassword$1(this, action, consumer, str, str2, null), 3);
    }

    private final void addAuthStateChangeListener() {
        this.authStateMachine.listen(new StateChangeListenerToken(), new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$addAuthStateChangeListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                Logger logger;
                Intrinsics.checkNotNullParameter(authState, "authState");
                logger = RealAWSCognitoAuthPlugin.this.logger;
                logger.verbose("Auth State Change: " + authState);
            }
        }, null);
    }

    private final void configureAuthStates() {
        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
        this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$configureAuthStates$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                Intrinsics.checkNotNullParameter(authState, "authState");
                if (authState instanceof AuthState.Configured) {
                    authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                    authStateMachine.cancel(stateChangeListenerToken);
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$configureAuthStates$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AuthStateMachine authStateMachine;
                authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                authStateMachine.send(new AuthEvent(new AuthEvent.EventType.ConfigureAuth(RealAWSCognitoAuthPlugin.this.configuration), null, 2, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getSession(Continuation<? super AWSCognitoAuthSession> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        fetchAuthSession(new Consumer() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$getSession$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession authSession) {
                Intrinsics.checkNotNullParameter(authSession, "authSession");
                if (authSession instanceof AWSCognitoAuthSession) {
                    safeContinuation.resumeWith(authSession);
                } else {
                    safeContinuation.resumeWith(ResultKt.createFailure(new UnknownException("fetchAuthSession did not return a type of AWSCognitoAuthSession", null, 2, null)));
                }
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$getSession$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<AuthUserAttributeKey, AuthUpdateAttributeResult> getUpdateUserAttributeResult(UpdateUserAttributesResponse updateUserAttributesResponse, List<AttributeType> list) {
        List<CodeDeliveryDetailsType> list2;
        String str;
        HashMap hashMap = new HashMap();
        if (updateUserAttributesResponse != null && (list2 = updateUserAttributesResponse.codeDeliveryDetailsList) != null) {
            for (CodeDeliveryDetailsType codeDeliveryDetailsType : list2) {
                if (codeDeliveryDetailsType.attributeName != null) {
                    DeliveryMediumType deliveryMediumType = codeDeliveryDetailsType.deliveryMedium;
                    if (deliveryMediumType != null) {
                        str = deliveryMediumType.getValue();
                    } else {
                        str = null;
                    }
                    AuthCodeDeliveryDetails.DeliveryMedium fromString = AuthCodeDeliveryDetails.DeliveryMedium.fromString(str);
                    Intrinsics.checkNotNullExpressionValue(fromString, "fromString(item.deliveryMedium?.value)");
                    String valueOf = String.valueOf(codeDeliveryDetailsType.destination);
                    String str2 = codeDeliveryDetailsType.attributeName;
                    AuthUpdateAttributeResult authUpdateAttributeResult = new AuthUpdateAttributeResult(false, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.CONFIRM_ATTRIBUTE_WITH_CODE, new HashMap(), new AuthCodeDeliveryDetails(valueOf, fromString, str2)));
                    AuthUserAttributeKey custom = AuthUserAttributeKey.custom(str2);
                    Intrinsics.checkNotNullExpressionValue(custom, "custom(item.attributeName)");
                    hashMap.put(custom, authUpdateAttributeResult);
                }
            }
        }
        for (AttributeType attributeType : list) {
            if (!hashMap.containsKey(AuthUserAttributeKey.custom(attributeType.name))) {
                AuthUpdateAttributeResult authUpdateAttributeResult2 = new AuthUpdateAttributeResult(true, new AuthNextUpdateAttributeStep(AuthUpdateAttributeStep.DONE, new HashMap(), null));
                AuthUserAttributeKey custom2 = AuthUserAttributeKey.custom(attributeType.name);
                Intrinsics.checkNotNullExpressionValue(custom2, "custom(item.name)");
                hashMap.put(custom2, authUpdateAttributeResult2);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendHubEvent(String str) {
        if (!Intrinsics.areEqual(this.lastPublishedHubEventName.get(), str)) {
            this.lastPublishedHubEventName.set(str);
            Amplify.Hub.publish(HubChannel.AUTH, HubEvent.create(str));
        }
    }

    private final void signInWithHostedUI(final AuthProvider authProvider, final Activity activity, final AuthWebUISignInOptions authWebUISignInOptions, final Consumer<AuthSignInResult> consumer, final Consumer<AuthException> consumer2) {
        this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signInWithHostedUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                AuthStateMachine authStateMachine;
                Intrinsics.checkNotNullParameter(authState, "authState");
                AuthenticationState authNState = authState.getAuthNState();
                if (authNState instanceof AuthenticationState.NotConfigured) {
                    consumer2.accept(new InvalidUserPoolConfigurationException());
                    return;
                }
                if (authNState instanceof AuthenticationState.SignedOut) {
                    if (this.configuration.getOauth() != null) {
                        this._signInWithHostedUI(activity, authWebUISignInOptions, consumer, consumer2, authProvider);
                        return;
                    } else {
                        consumer2.accept(new InvalidOauthConfigurationException());
                        return;
                    }
                }
                if (authNState instanceof AuthenticationState.SignedIn) {
                    consumer2.accept(new SignedInException(null, null, 3, null));
                    return;
                }
                if (authNState instanceof AuthenticationState.SigningIn) {
                    final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
                    authStateMachine = this.authStateMachine;
                    final RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this;
                    final Activity activity2 = activity;
                    final AuthWebUISignInOptions authWebUISignInOptions2 = authWebUISignInOptions;
                    final Consumer<AuthSignInResult> consumer3 = consumer;
                    final Consumer<AuthException> consumer4 = consumer2;
                    final AuthProvider authProvider2 = authProvider;
                    Function1<AuthState, Unit> function1 = new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signInWithHostedUI$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AuthState authState2) {
                            invoke2(authState2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AuthState authState2) {
                            AuthStateMachine authStateMachine2;
                            Intrinsics.checkNotNullParameter(authState2, "authState");
                            if (authState2.getAuthNState() instanceof AuthenticationState.SignedOut) {
                                authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                                authStateMachine2.cancel(stateChangeListenerToken);
                                RealAWSCognitoAuthPlugin.this._signInWithHostedUI(activity2, authWebUISignInOptions2, consumer3, consumer4, authProvider2);
                            }
                        }
                    };
                    final RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin2 = this;
                    authStateMachine.listen(stateChangeListenerToken, function1, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signInWithHostedUI$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AuthStateMachine authStateMachine2;
                            authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                            authStateMachine2.send(new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignIn(null, 1, null), null, 2, null));
                        }
                    });
                    return;
                }
                consumer2.accept(new InvalidStateException(null, null, null, 7, null));
            }
        });
    }

    public static /* synthetic */ void signInWithHostedUI$default(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer consumer, Consumer consumer2, int r12, Object obj) {
        if ((r12 & 1) != 0) {
            authProvider = null;
        }
        realAWSCognitoAuthPlugin.signInWithHostedUI(authProvider, activity, authWebUISignInOptions, consumer, consumer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDevice(String str, DeviceRememberedStatusType deviceRememberedStatusType, Action action, Consumer<AuthException> consumer) {
        BuildersKt.async$default(GlobalScope.INSTANCE, null, new RealAWSCognitoAuthPlugin$updateDevice$1(this, action, consumer, str, deviceRememberedStatusType, null), 3);
    }

    public final void clearFederationToIdentityPool(final Action onSuccess, final Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$clearFederationToIdentityPool$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:            if ((((com.amplifyframework.statemachine.codegen.errors.SessionError) r1.getException()).getAmplifyCredential() instanceof com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolFederated) != false) goto L14;     */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(com.amplifyframework.statemachine.codegen.states.AuthState r8) {
                /*
                    r7 = this;
                    java.lang.String r0 = "authState"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    com.amplifyframework.statemachine.codegen.states.AuthenticationState r0 = r8.getAuthNState()
                    com.amplifyframework.statemachine.codegen.states.AuthorizationState r1 = r8.getAuthZState()
                    boolean r8 = r8 instanceof com.amplifyframework.statemachine.codegen.states.AuthState.Configured
                    if (r8 == 0) goto L19
                    boolean r8 = r0 instanceof com.amplifyframework.statemachine.codegen.states.AuthenticationState.FederatedToIdentityPool
                    if (r8 == 0) goto L19
                    boolean r8 = r1 instanceof com.amplifyframework.statemachine.codegen.states.AuthorizationState.SessionEstablished
                    if (r8 != 0) goto L35
                L19:
                    boolean r8 = r1 instanceof com.amplifyframework.statemachine.codegen.states.AuthorizationState.Error
                    if (r8 == 0) goto L55
                    com.amplifyframework.statemachine.codegen.states.AuthorizationState$Error r1 = (com.amplifyframework.statemachine.codegen.states.AuthorizationState.Error) r1
                    java.lang.Exception r8 = r1.getException()
                    boolean r8 = r8 instanceof com.amplifyframework.statemachine.codegen.errors.SessionError
                    if (r8 == 0) goto L55
                    java.lang.Exception r8 = r1.getException()
                    com.amplifyframework.statemachine.codegen.errors.SessionError r8 = (com.amplifyframework.statemachine.codegen.errors.SessionError) r8
                    com.amplifyframework.statemachine.codegen.data.AmplifyCredential r8 = r8.getAmplifyCredential()
                    boolean r8 = r8 instanceof com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolFederated
                    if (r8 == 0) goto L55
                L35:
                    com.amplifyframework.statemachine.codegen.events.AuthenticationEvent r8 = new com.amplifyframework.statemachine.codegen.events.AuthenticationEvent
                    com.amplifyframework.statemachine.codegen.events.AuthenticationEvent$EventType$ClearFederationToIdentityPool r0 = new com.amplifyframework.statemachine.codegen.events.AuthenticationEvent$EventType$ClearFederationToIdentityPool
                    r1 = 1
                    r2 = 0
                    r0.<init>(r2, r1, r2)
                    r1 = 2
                    r8.<init>(r0, r2, r1, r2)
                    com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r0 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.this
                    com.amplifyframework.auth.cognito.AuthStateMachine r0 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getAuthStateMachine$p(r0)
                    r0.send(r8)
                    com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r8 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.this
                    com.amplifyframework.core.Action r0 = r2
                    com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r1 = r3
                    com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$_clearFederationToIdentityPool(r8, r0, r1)
                    goto L66
                L55:
                    com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r8 = r3
                    com.amplifyframework.auth.exceptions.InvalidStateException r6 = new com.amplifyframework.auth.exceptions.InvalidStateException
                    java.lang.String r1 = "Clearing of federation failed."
                    r2 = 0
                    r3 = 0
                    r4 = 6
                    r5 = 0
                    r0 = r6
                    r0.<init>(r1, r2, r3, r4, r5)
                    r8.accept(r6)
                L66:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$clearFederationToIdentityPool$1.invoke2(com.amplifyframework.statemachine.codegen.states.AuthState):void");
            }
        });
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmResetPassword(final String username, final String newPassword, final String confirmationCode, final AuthConfirmResetPasswordOptions options, final Action onSuccess, final Consumer<AuthException> onError) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1

            /* compiled from: RealAWSCognitoAuthPlugin.kt */
            @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1213, 1958}, m = "invokeSuspend")
            /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $confirmationCode;
                final /* synthetic */ String $newPassword;
                final /* synthetic */ Consumer<AuthException> $onError;
                final /* synthetic */ Action $onSuccess;
                final /* synthetic */ AuthConfirmResetPasswordOptions $options;
                final /* synthetic */ String $username;
                int label;
                final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, String str, Consumer<AuthException> consumer, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = realAWSCognitoAuthPlugin;
                    this.$username = str;
                    this.$onError = consumer;
                    this.$confirmationCode = str2;
                    this.$newPassword = str3;
                    this.$options = authConfirmResetPasswordOptions;
                    this.$onSuccess = action;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$username, this.$onError, this.$confirmationCode, this.$newPassword, this.$options, this.$onSuccess, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    AuthEnvironment authEnvironment;
                    AuthEnvironment authEnvironment2;
                    AuthEnvironment authEnvironment3;
                    String str;
                    String str2;
                    AWSCognitoAuthConfirmResetPasswordOptions aWSCognitoAuthConfirmResetPasswordOptions;
                    Map<String, String> map;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    try {
                    } catch (Exception e) {
                        this.$onError.accept(CognitoAuthExceptionConverter.Companion.lookup(e, AmplifyException.REPORT_BUG_TO_AWS_SUGGESTION));
                    }
                    if (r1 != 0) {
                        if (r1 != 1) {
                            if (r1 == 2) {
                                ResultKt.throwOnFailure(obj);
                                this.$onSuccess.call();
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        authEnvironment = this.this$0.authEnvironment;
                        String str3 = this.$username;
                        this.label = 1;
                        obj = authEnvironment.getUserContextData(str3, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    final String str4 = (String) obj;
                    authEnvironment2 = this.this$0.authEnvironment;
                    final String pinpointEndpointId = authEnvironment2.getPinpointEndpointId();
                    authEnvironment3 = this.this$0.authEnvironment;
                    CognitoIdentityProviderClient cognitoIdentityProviderClient = authEnvironment3.getCognitoAuthService().getCognitoIdentityProviderClient();
                    Intrinsics.checkNotNull(cognitoIdentityProviderClient);
                    String str5 = this.$username;
                    String str6 = this.$confirmationCode;
                    String str7 = this.$newPassword;
                    RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                    AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions = this.$options;
                    ConfirmForgotPasswordRequest.Builder builder = new ConfirmForgotPasswordRequest.Builder();
                    builder.username = str5;
                    builder.confirmationCode = str6;
                    builder.password = str7;
                    AuthHelper.Companion companion = AuthHelper.Companion;
                    UserPoolConfiguration userPool = realAWSCognitoAuthPlugin.configuration.getUserPool();
                    String str8 = null;
                    if (userPool != null) {
                        str = userPool.getAppClient();
                    } else {
                        str = null;
                    }
                    UserPoolConfiguration userPool2 = realAWSCognitoAuthPlugin.configuration.getUserPool();
                    if (userPool2 != null) {
                        str2 = userPool2.getAppClientSecret();
                    } else {
                        str2 = null;
                    }
                    builder.secretHash = companion.getSecretHash(str5, str, str2);
                    if (authConfirmResetPasswordOptions instanceof AWSCognitoAuthConfirmResetPasswordOptions) {
                        aWSCognitoAuthConfirmResetPasswordOptions = (AWSCognitoAuthConfirmResetPasswordOptions) authConfirmResetPasswordOptions;
                    } else {
                        aWSCognitoAuthConfirmResetPasswordOptions = null;
                    }
                    if (aWSCognitoAuthConfirmResetPasswordOptions == null || (map = aWSCognitoAuthConfirmResetPasswordOptions.getMetadata()) == null) {
                        map = EmptyMap.INSTANCE;
                    }
                    builder.clientMetadata = map;
                    UserPoolConfiguration userPool3 = realAWSCognitoAuthPlugin.configuration.getUserPool();
                    if (userPool3 != null) {
                        str8 = userPool3.getAppClient();
                    }
                    builder.clientId = str8;
                    if (str4 != null) {
                        Function1<UserContextDataType.Builder, Unit> function1 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b4: CONSTRUCTOR (r4v7 'function1' kotlin.jvm.functions.Function1<aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType$Builder, kotlin.Unit>) = (r13v8 'str4' java.lang.String A[DONT_INLINE]) A[Catch: Exception -> 0x00f2, DECLARE_VAR, MD:(java.lang.String):void (m)] (LINE:181) call: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1$1$1$1$1.<init>(java.lang.String):void type: CONSTRUCTOR in method: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1$1$1$1$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 21 more
                            */
                        /*
                            Method dump skipped, instructions count: 259
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmResetPassword$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    if (authState.getAuthNState() instanceof AuthenticationState.NotConfigured) {
                        onError.accept(new ConfigurationException("Confirm Reset Password failed.", "Cognito User Pool not configured. Please check amplifyconfiguration.json file.", null, 4, null));
                    } else {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, username, onError, confirmationCode, newPassword, options, onSuccess, null), 3);
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmSignIn(String challengeResponse, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(challengeResponse, "challengeResponse");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthConfirmSignInOptions.DefaultAuthConfirmSignInOptions defaults = AuthConfirmSignInOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            confirmSignIn(challengeResponse, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmSignUp(String username, String confirmationCode, Consumer<AuthSignUpResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthConfirmSignUpOptions.DefaultAuthConfirmSignUpOptions defaults = AuthConfirmSignUpOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            confirmSignUp(username, confirmationCode, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmUserAttribute(final AuthUserAttributeKey attributeKey, final String confirmationCode, final Action onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
            Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1570, 1578}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ AuthUserAttributeKey $attributeKey;
                    final /* synthetic */ String $confirmationCode;
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Action $onSuccess;
                    Object L$0;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<AuthException> consumer, Action action, AuthUserAttributeKey authUserAttributeKey, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$onError = consumer;
                        this.$onSuccess = action;
                        this.$attributeKey = authUserAttributeKey;
                        this.$confirmationCode = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$onError, this.$onSuccess, this.$attributeKey, this.$confirmationCode, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0083 A[Catch: Exception -> 0x008e, TRY_LEAVE, TryCatch #0 {Exception -> 0x008e, blocks: (B:7:0x0010, B:8:0x0079, B:9:0x007c, B:11:0x0083, B:18:0x001c, B:19:0x002e, B:21:0x003d, B:23:0x0045, B:25:0x006d, B:31:0x0023), top: B:2:0x0006 }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                        /*
                            r7 = this;
                            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r1 = r7.label
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L20
                            if (r1 == r3) goto L1c
                            if (r1 != r2) goto L14
                            java.lang.Object r0 = r7.L$0
                            com.amplifyframework.core.Action r0 = (com.amplifyframework.core.Action) r0
                            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L8e
                            goto L79
                        L14:
                            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r8.<init>(r0)
                            throw r8
                        L1c:
                            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L8e
                            goto L2e
                        L20:
                            kotlin.ResultKt.throwOnFailure(r8)
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r8 = r7.this$0     // Catch: java.lang.Exception -> L8e
                            r7.label = r3     // Catch: java.lang.Exception -> L8e
                            java.lang.Object r8 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getSession(r8, r7)     // Catch: java.lang.Exception -> L8e
                            if (r8 != r0) goto L2e
                            return r0
                        L2e:
                            com.amplifyframework.auth.cognito.AWSCognitoAuthSession r8 = (com.amplifyframework.auth.cognito.AWSCognitoAuthSession) r8     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.result.AuthSessionResult r8 = r8.getUserPoolTokensResult()     // Catch: java.lang.Exception -> L8e
                            java.lang.Object r8 = r8.getValue()     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.AWSCognitoUserPoolTokens r8 = (com.amplifyframework.auth.AWSCognitoUserPoolTokens) r8     // Catch: java.lang.Exception -> L8e
                            r1 = 0
                            if (r8 == 0) goto L42
                            java.lang.String r8 = r8.getAccessToken()     // Catch: java.lang.Exception -> L8e
                            goto L43
                        L42:
                            r8 = r1
                        L43:
                            if (r8 == 0) goto L81
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r1 = r7.this$0     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.core.Action r3 = r7.$onSuccess     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.AuthUserAttributeKey r4 = r7.$attributeKey     // Catch: java.lang.Exception -> L8e
                            java.lang.String r5 = r7.$confirmationCode     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1$1$1$verifyUserAttributeRequest$1 r6 = new com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1$1$1$verifyUserAttributeRequest$1     // Catch: java.lang.Exception -> L8e
                            r6.<init>(r8, r4, r5)     // Catch: java.lang.Exception -> L8e
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest$Builder r8 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest$Builder     // Catch: java.lang.Exception -> L8e
                            r8.<init>()     // Catch: java.lang.Exception -> L8e
                            r6.invoke(r8)     // Catch: java.lang.Exception -> L8e
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest r4 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest     // Catch: java.lang.Exception -> L8e
                            r4.<init>(r8)     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.cognito.AuthEnvironment r8 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getAuthEnvironment$p(r1)     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.cognito.AWSCognitoAuthService r8 = r8.getCognitoAuthService()     // Catch: java.lang.Exception -> L8e
                            aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient r8 = r8.getCognitoIdentityProviderClient()     // Catch: java.lang.Exception -> L8e
                            if (r8 == 0) goto L7c
                            r7.L$0 = r3     // Catch: java.lang.Exception -> L8e
                            r7.label = r2     // Catch: java.lang.Exception -> L8e
                            java.lang.Object r8 = r8.verifyUserAttribute(r4, r7)     // Catch: java.lang.Exception -> L8e
                            if (r8 != r0) goto L78
                            return r0
                        L78:
                            r0 = r3
                        L79:
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeResponse r8 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeResponse) r8     // Catch: java.lang.Exception -> L8e
                            r3 = r0
                        L7c:
                            r3.call()     // Catch: java.lang.Exception -> L8e
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L8e
                        L81:
                            if (r1 != 0) goto L9e
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r8 = r7.$onError     // Catch: java.lang.Exception -> L8e
                            com.amplifyframework.auth.cognito.exceptions.configuration.InvalidUserPoolConfigurationException r0 = new com.amplifyframework.auth.cognito.exceptions.configuration.InvalidUserPoolConfigurationException     // Catch: java.lang.Exception -> L8e
                            r0.<init>()     // Catch: java.lang.Exception -> L8e
                            r8.accept(r0)     // Catch: java.lang.Exception -> L8e
                            goto L9e
                        L8e:
                            r8 = move-exception
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r0 = r7.$onError
                            com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter$Companion r1 = com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter.Companion
                            java.lang.String r2 = r8.toString()
                            com.amplifyframework.auth.AuthException r8 = r1.lookup(r8, r2)
                            r0.accept(r8)
                        L9e:
                            kotlin.Unit r8 = kotlin.Unit.INSTANCE
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmUserAttribute$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, onError, onSuccess, attributeKey, confirmationCode, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void deleteUser(final Action onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$deleteUser$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$deleteUser$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1721}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$deleteUser$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Action $onSuccess;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<AuthException> consumer, Action action, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$onError = consumer;
                        this.$onSuccess = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$onError, this.$onSuccess, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        String str;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        try {
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                                this.label = 1;
                                obj = realAWSCognitoAuthPlugin.getSession(this);
                                if (obj == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            AWSCognitoUserPoolTokens value = ((AWSCognitoAuthSession) obj).getUserPoolTokensResult().getValue();
                            Unit unit = null;
                            if (value != null) {
                                str = value.getAccessToken();
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                this.this$0._deleteUser(str, this.$onSuccess, this.$onError);
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                this.$onError.accept(new SignedOutException(null, null, null, 7, null));
                            }
                        } catch (Exception unused) {
                            this.$onError.accept(new SignedOutException(null, null, null, 7, null));
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, onError, onSuccess, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        public final AWSCognitoAuthService escapeHatch() {
            return this.authEnvironment.getCognitoAuthService();
        }

        public final void federateToIdentityPool(final String providerToken, final AuthProvider authProvider, final FederateToIdentityPoolOptions federateToIdentityPoolOptions, final Consumer<FederateToIdentityPoolResult> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(providerToken, "providerToken");
            Intrinsics.checkNotNullParameter(authProvider, "authProvider");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$federateToIdentityPool$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    AmplifyCredential amplifyCredential;
                    AuthStateMachine authStateMachine;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    AuthorizationState authZState = authState.getAuthZState();
                    if (!(authState instanceof AuthState.Configured)) {
                        onError.accept(new InvalidStateException("Federation could not be completed.", null, null, 6, null));
                        return;
                    }
                    if ((!(authNState instanceof AuthenticationState.SignedOut) && !(authNState instanceof AuthenticationState.Error) && !(authNState instanceof AuthenticationState.NotConfigured) && !(authNState instanceof AuthenticationState.FederatedToIdentityPool)) || (!(authZState instanceof AuthorizationState.Configured) && !(authZState instanceof AuthorizationState.SessionEstablished) && !(authZState instanceof AuthorizationState.Error))) {
                        onError.accept(new InvalidStateException("Federation could not be completed.", null, null, 6, null));
                        return;
                    }
                    if (authZState instanceof AuthorizationState.SessionEstablished) {
                        amplifyCredential = ((AuthorizationState.SessionEstablished) authZState).getAmplifyCredential();
                    } else {
                        if (authZState instanceof AuthorizationState.Error) {
                            Exception exception = ((AuthorizationState.Error) authZState).getException();
                            SessionError sessionError = exception instanceof SessionError ? (SessionError) exception : null;
                            if (sessionError != null) {
                                amplifyCredential = sessionError.getAmplifyCredential();
                            }
                        }
                        amplifyCredential = null;
                    }
                    authStateMachine = this.authStateMachine;
                    FederatedToken federatedToken = new FederatedToken(providerToken, CodegenExtensionsKt.getIdentityProviderName(authProvider));
                    FederateToIdentityPoolOptions federateToIdentityPoolOptions2 = federateToIdentityPoolOptions;
                    authStateMachine.send(new AuthorizationEvent(new AuthorizationEvent.EventType.StartFederationToIdentityPool(federatedToken, federateToIdentityPoolOptions2 != null ? federateToIdentityPoolOptions2.getDeveloperProvidedIdentityId() : null, amplifyCredential), null, 2, null));
                    this._federateToIdentityPool(onSuccess, onError);
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void fetchAuthSession(Consumer<AuthSession> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            fetchAuthSession(AuthFetchSessionOptions.Companion.defaults(), onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void fetchDevices(final Consumer<List<AuthDevice>> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchDevices$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        RealAWSCognitoAuthPlugin.this._fetchDevices(onSuccess, onError);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void fetchUserAttributes(final Consumer<List<AuthUserAttribute>> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1313, 1317}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<List<AuthUserAttribute>> $onSuccess;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<List<AuthUserAttribute>> consumer, Consumer<AuthException> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$onSuccess = consumer;
                        this.$onError = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$onSuccess, this.$onError, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: Exception -> 0x00a5, LOOP:0: B:13:0x007e->B:15:0x0084, LOOP_END, TryCatch #0 {Exception -> 0x00a5, blocks: (B:6:0x000c, B:7:0x006a, B:8:0x006d, B:10:0x0074, B:12:0x0078, B:13:0x007e, B:15:0x0084, B:17:0x009b, B:24:0x0018, B:25:0x002a, B:27:0x0039, B:28:0x003f, B:30:0x0061, B:35:0x001f), top: B:2:0x0006 }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                        /*
                            r4 = this;
                            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r1 = r4.label
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L1c
                            if (r1 == r3) goto L18
                            if (r1 != r2) goto L10
                            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> La5
                            goto L6a
                        L10:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r0)
                            throw r5
                        L18:
                            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> La5
                            goto L2a
                        L1c:
                            kotlin.ResultKt.throwOnFailure(r5)
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r5 = r4.this$0     // Catch: java.lang.Exception -> La5
                            r4.label = r3     // Catch: java.lang.Exception -> La5
                            java.lang.Object r5 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getSession(r5, r4)     // Catch: java.lang.Exception -> La5
                            if (r5 != r0) goto L2a
                            return r0
                        L2a:
                            com.amplifyframework.auth.cognito.AWSCognitoAuthSession r5 = (com.amplifyframework.auth.cognito.AWSCognitoAuthSession) r5     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.result.AuthSessionResult r5 = r5.getUserPoolTokensResult()     // Catch: java.lang.Exception -> La5
                            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.AWSCognitoUserPoolTokens r5 = (com.amplifyframework.auth.AWSCognitoUserPoolTokens) r5     // Catch: java.lang.Exception -> La5
                            r1 = 0
                            if (r5 == 0) goto L3e
                            java.lang.String r5 = r5.getAccessToken()     // Catch: java.lang.Exception -> La5
                            goto L3f
                        L3e:
                            r5 = r1
                        L3f:
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1$1$getUserRequest$1 r3 = new com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1$1$getUserRequest$1     // Catch: java.lang.Exception -> La5
                            r3.<init>(r5)     // Catch: java.lang.Exception -> La5
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest$Builder r5 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest$Builder     // Catch: java.lang.Exception -> La5
                            r5.<init>()     // Catch: java.lang.Exception -> La5
                            r3.invoke(r5)     // Catch: java.lang.Exception -> La5
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest r3 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest     // Catch: java.lang.Exception -> La5
                            r3.<init>(r5)     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r5 = r4.this$0     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.cognito.AuthEnvironment r5 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getAuthEnvironment$p(r5)     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.cognito.AWSCognitoAuthService r5 = r5.getCognitoAuthService()     // Catch: java.lang.Exception -> La5
                            aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient r5 = r5.getCognitoIdentityProviderClient()     // Catch: java.lang.Exception -> La5
                            if (r5 == 0) goto L6d
                            r4.label = r2     // Catch: java.lang.Exception -> La5
                            java.lang.Object r5 = r5.getUser(r3, r4)     // Catch: java.lang.Exception -> La5
                            if (r5 != r0) goto L6a
                            return r0
                        L6a:
                            r1 = r5
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse r1 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse) r1     // Catch: java.lang.Exception -> La5
                        L6d:
                            kotlin.collections.builders.ListBuilder r5 = new kotlin.collections.builders.ListBuilder     // Catch: java.lang.Exception -> La5
                            r5.<init>()     // Catch: java.lang.Exception -> La5
                            if (r1 == 0) goto L9b
                            java.util.List<aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType> r0 = r1.userAttributes     // Catch: java.lang.Exception -> La5
                            if (r0 == 0) goto L9b
                            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> La5
                            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> La5
                        L7e:
                            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> La5
                            if (r1 == 0) goto L9b
                            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> La5
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType r1 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType) r1     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.AuthUserAttribute r2 = new com.amplifyframework.auth.AuthUserAttribute     // Catch: java.lang.Exception -> La5
                            java.lang.String r3 = r1.name     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.auth.AuthUserAttributeKey r3 = com.amplifyframework.auth.AuthUserAttributeKey.custom(r3)     // Catch: java.lang.Exception -> La5
                            java.lang.String r1 = r1.value     // Catch: java.lang.Exception -> La5
                            r2.<init>(r3, r1)     // Catch: java.lang.Exception -> La5
                            r5.add(r2)     // Catch: java.lang.Exception -> La5
                            goto L7e
                        L9b:
                            kotlin.collections.builders.ListBuilder r5 = kotlin.collections.CollectionsKt__CollectionsKt.build(r5)     // Catch: java.lang.Exception -> La5
                            com.amplifyframework.core.Consumer<java.util.List<com.amplifyframework.auth.AuthUserAttribute>> r0 = r4.$onSuccess     // Catch: java.lang.Exception -> La5
                            r0.accept(r5)     // Catch: java.lang.Exception -> La5
                            goto Lb5
                        La5:
                            r5 = move-exception
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r0 = r4.$onError
                            com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter$Companion r1 = com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter.Companion
                            java.lang.String r2 = r5.toString()
                            com.amplifyframework.auth.AuthException r5 = r1.lookup(r5, r2)
                            r0.accept(r5)
                        Lb5:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchUserAttributes$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, onSuccess, onError, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void forgetDevice(Action onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthDevice fromId = AuthDevice.fromId("");
            Intrinsics.checkNotNullExpressionValue(fromId, "fromId(\"\")");
            forgetDevice(fromId, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void getCurrentUser(final Consumer<AuthUser> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$getCurrentUser$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$getCurrentUser$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1602}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$getCurrentUser$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<AuthUser> $onSuccess;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<AuthException> consumer, Consumer<AuthUser> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$onError = consumer;
                        this.$onSuccess = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$onError, this.$onSuccess, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        String str;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                            this.label = 1;
                            obj = realAWSCognitoAuthPlugin.getSession(this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        AWSCognitoUserPoolTokens value = ((AWSCognitoAuthSession) obj).getUserPoolTokensResult().getValue();
                        Unit unit = null;
                        if (value != null) {
                            str = value.getAccessToken();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            Consumer<AuthUser> consumer = this.$onSuccess;
                            SessionHelper sessionHelper = SessionHelper.INSTANCE;
                            String userSub = sessionHelper.getUserSub(str);
                            String str2 = "";
                            if (userSub == null) {
                                userSub = "";
                            }
                            String username = sessionHelper.getUsername(str);
                            if (username != null) {
                                str2 = username;
                            }
                            consumer.accept(new AuthUser(userSub, str2));
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            this.$onError.accept(new InvalidUserPoolConfigurationException());
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.async$default(GlobalScope.INSTANCE, null, new AnonymousClass1(this, onError, onSuccess, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void handleWebUISignInResponse(final Intent intent) {
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$handleWebUISignInResponse$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState it) {
                    Logger logger;
                    AuthStateMachine authStateMachine;
                    AuthStateMachine authStateMachine2;
                    HostedUIErrorData hostedUIErrorData;
                    AuthStateMachine authStateMachine3;
                    AuthStateMachine authStateMachine4;
                    AuthEnvironment authEnvironment;
                    AuthEnvironment authEnvironment2;
                    Uri createSignOutUri$aws_auth_cognito_release;
                    AuthStateMachine authStateMachine5;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Intent intent2 = intent;
                    Uri data = intent2 != null ? intent2.getData() : null;
                    AuthenticationState authNState = it.getAuthNState();
                    if (authNState instanceof AuthenticationState.SigningOut) {
                        SignOutState signOutState = ((AuthenticationState.SigningOut) authNState).getSignOutState();
                        SignOutState.SigningOutHostedUI signingOutHostedUI = signOutState instanceof SignOutState.SigningOutHostedUI ? (SignOutState.SigningOutHostedUI) signOutState : null;
                        if (signingOutHostedUI != null) {
                            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this;
                            if (data == null && !signingOutHostedUI.getBypassCancel() && !Intrinsics.areEqual(signingOutHostedUI.getSignedInData().getSignInMethod(), new SignInMethod.ApiBased(SignInMethod.ApiBased.AuthType.UNKNOWN))) {
                                authStateMachine5 = realAWSCognitoAuthPlugin.authStateMachine;
                                authStateMachine5.send(new SignOutEvent(new SignOutEvent.EventType.UserCancelled(signingOutHostedUI.getSignedInData()), null, 2, null));
                                return;
                            }
                            if (data == null) {
                                authEnvironment = realAWSCognitoAuthPlugin.authEnvironment;
                                HostedUIClient hostedUIClient = authEnvironment.getHostedUIClient();
                                String uri = (hostedUIClient == null || (createSignOutUri$aws_auth_cognito_release = hostedUIClient.createSignOutUri$aws_auth_cognito_release()) == null) ? null : createSignOutUri$aws_auth_cognito_release.toString();
                                authEnvironment2 = realAWSCognitoAuthPlugin.authEnvironment;
                                hostedUIErrorData = new HostedUIErrorData(uri, new HostedUISignOutException(authEnvironment2.getHostedUIClient() != null));
                            } else {
                                hostedUIErrorData = null;
                            }
                            if (signingOutHostedUI.getGlobalSignOut()) {
                                authStateMachine4 = realAWSCognitoAuthPlugin.authStateMachine;
                                authStateMachine4.send(new SignOutEvent(new SignOutEvent.EventType.SignOutGlobally(signingOutHostedUI.getSignedInData(), hostedUIErrorData), null, 2, null));
                                return;
                            } else {
                                authStateMachine3 = realAWSCognitoAuthPlugin.authStateMachine;
                                authStateMachine3.send(new SignOutEvent(new SignOutEvent.EventType.RevokeToken(signingOutHostedUI.getSignedInData(), hostedUIErrorData, null, 4, null), null, 2, null));
                                return;
                            }
                        }
                        return;
                    }
                    if (!(authNState instanceof AuthenticationState.SigningIn)) {
                        logger = this.logger;
                        logger.warn("Received handleWebUIResponse but ignoring because the user is not currently signing in or signing out");
                    } else if (data == null) {
                        authStateMachine2 = this.authStateMachine;
                        authStateMachine2.send(new HostedUIEvent(new HostedUIEvent.EventType.ThrowError(new UserCancelledException("The user cancelled the sign-in attempt, so it did not complete.", "To recover: catch this error, and show the sign-in screen again.")), null, 2, null));
                    } else {
                        authStateMachine = this.authStateMachine;
                        authStateMachine.send(new HostedUIEvent(new HostedUIEvent.EventType.FetchToken(data), null, 2, null));
                    }
                }
            });
        }

        public final void initialize() throws AmplifyException {
            final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.authStateMachine.listen(stateChangeListenerToken, new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$initialize$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    AuthStateMachine authStateMachine;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    if (authState instanceof AuthState.Configured) {
                        authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine.cancel(stateChangeListenerToken);
                        countDownLatch.countDown();
                    }
                }
            }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$initialize$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (Exception unused) {
                throw new AmplifyException("Failed to configure auth plugin.", "Make sure your amplifyconfiguration.json is valid");
            }
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void rememberDevice(final Action onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$rememberDevice$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = RealAWSCognitoAuthPlugin.this;
                        DeviceMetadata deviceMetadata = ((AuthenticationState.SignedIn) authNState).getDeviceMetadata();
                        DeviceMetadata.Metadata metadata = deviceMetadata instanceof DeviceMetadata.Metadata ? (DeviceMetadata.Metadata) deviceMetadata : null;
                        realAWSCognitoAuthPlugin.updateDevice(metadata != null ? metadata.getDeviceKey() : null, DeviceRememberedStatusType.Remembered.INSTANCE, onSuccess, onError);
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resendSignUpCode(String username, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthResendSignUpCodeOptions.DefaultAuthResendSignUpCodeOptions defaults = AuthResendSignUpCodeOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            resendSignUpCode(username, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resendUserAttributeConfirmationCode(final AuthUserAttributeKey attributeKey, AuthResendUserAttributeConfirmationCodeOptions options, final Consumer<AuthCodeDeliveryDetails> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            final AWSCognitoAuthResendUserAttributeConfirmationCodeOptions aWSCognitoAuthResendUserAttributeConfirmationCodeOptions = options instanceof AWSCognitoAuthResendUserAttributeConfirmationCodeOptions ? (AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) options : null;
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1500, 1510}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ AuthUserAttributeKey $attributeKey;
                    final /* synthetic */ AWSCognitoAuthResendUserAttributeConfirmationCodeOptions $metadataOptions;
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<AuthCodeDeliveryDetails> $onSuccess;
                    Object L$0;
                    Object L$1;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<AuthException> consumer, AuthUserAttributeKey authUserAttributeKey, AWSCognitoAuthResendUserAttributeConfirmationCodeOptions aWSCognitoAuthResendUserAttributeConfirmationCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$onError = consumer;
                        this.$attributeKey = authUserAttributeKey;
                        this.$metadataOptions = aWSCognitoAuthResendUserAttributeConfirmationCodeOptions;
                        this.$onSuccess = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$onError, this.$attributeKey, this.$metadataOptions, this.$onSuccess, continuation);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ba, code lost:            if (r4 == null) goto L42;     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x008a A[Catch: Exception -> 0x00c9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c9, blocks: (B:7:0x0015, B:8:0x0082, B:10:0x008a, B:14:0x0092, B:16:0x0096, B:17:0x009a, B:19:0x00b4, B:21:0x00bc, B:28:0x0021, B:29:0x0033, B:31:0x0041, B:33:0x0049, B:35:0x0073, B:42:0x0028), top: B:2:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0092 A[Catch: Exception -> 0x00c9, TRY_ENTER, TryCatch #0 {Exception -> 0x00c9, blocks: (B:7:0x0015, B:8:0x0082, B:10:0x008a, B:14:0x0092, B:16:0x0096, B:17:0x009a, B:19:0x00b4, B:21:0x00bc, B:28:0x0021, B:29:0x0033, B:31:0x0041, B:33:0x0049, B:35:0x0073, B:42:0x0028), top: B:2:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4 A[Catch: Exception -> 0x00c9, TryCatch #0 {Exception -> 0x00c9, blocks: (B:7:0x0015, B:8:0x0082, B:10:0x008a, B:14:0x0092, B:16:0x0096, B:17:0x009a, B:19:0x00b4, B:21:0x00bc, B:28:0x0021, B:29:0x0033, B:31:0x0041, B:33:0x0049, B:35:0x0073, B:42:0x0028), top: B:2:0x0007 }] */
                    /* JADX WARN: Type inference failed for: r10v24, types: [com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1$1$1$2] */
                    /* JADX WARN: Type inference failed for: r10v28, types: [kotlin.Unit] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                        /*
                            r9 = this;
                            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r1 = r9.label
                            r2 = 2
                            r3 = 1
                            r4 = 0
                            if (r1 == 0) goto L25
                            if (r1 == r3) goto L21
                            if (r1 != r2) goto L19
                            java.lang.Object r0 = r9.L$1
                            com.amplifyframework.core.Consumer r0 = (com.amplifyframework.core.Consumer) r0
                            java.lang.Object r1 = r9.L$0
                            com.amplifyframework.core.Consumer r1 = (com.amplifyframework.core.Consumer) r1
                            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> Lc9
                            goto L82
                        L19:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r0)
                            throw r10
                        L21:
                            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> Lc9
                            goto L33
                        L25:
                            kotlin.ResultKt.throwOnFailure(r10)
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r10 = r9.this$0     // Catch: java.lang.Exception -> Lc9
                            r9.label = r3     // Catch: java.lang.Exception -> Lc9
                            java.lang.Object r10 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getSession(r10, r9)     // Catch: java.lang.Exception -> Lc9
                            if (r10 != r0) goto L33
                            return r0
                        L33:
                            com.amplifyframework.auth.cognito.AWSCognitoAuthSession r10 = (com.amplifyframework.auth.cognito.AWSCognitoAuthSession) r10     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.result.AuthSessionResult r10 = r10.getUserPoolTokensResult()     // Catch: java.lang.Exception -> Lc9
                            java.lang.Object r10 = r10.getValue()     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.AWSCognitoUserPoolTokens r10 = (com.amplifyframework.auth.AWSCognitoUserPoolTokens) r10     // Catch: java.lang.Exception -> Lc9
                            if (r10 == 0) goto L46
                            java.lang.String r10 = r10.getAccessToken()     // Catch: java.lang.Exception -> Lc9
                            goto L47
                        L46:
                            r10 = r4
                        L47:
                            if (r10 == 0) goto Lbc
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin r1 = r9.this$0     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.AuthUserAttributeKey r3 = r9.$attributeKey     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.cognito.options.AWSCognitoAuthResendUserAttributeConfirmationCodeOptions r5 = r9.$metadataOptions     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthCodeDeliveryDetails> r6 = r9.$onSuccess     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r7 = r9.$onError     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1$1$getUserAttributeVerificationCodeRequest$1 r8 = new com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1$1$getUserAttributeVerificationCodeRequest$1     // Catch: java.lang.Exception -> Lc9
                            r8.<init>(r10, r3, r5)     // Catch: java.lang.Exception -> Lc9
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest$Builder r10 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest$Builder     // Catch: java.lang.Exception -> Lc9
                            r10.<init>()     // Catch: java.lang.Exception -> Lc9
                            r8.invoke(r10)     // Catch: java.lang.Exception -> Lc9
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest r3 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest     // Catch: java.lang.Exception -> Lc9
                            r3.<init>(r10)     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.cognito.AuthEnvironment r10 = com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin.access$getAuthEnvironment$p(r1)     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.cognito.AWSCognitoAuthService r10 = r10.getCognitoAuthService()     // Catch: java.lang.Exception -> Lc9
                            aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient r10 = r10.getCognitoIdentityProviderClient()     // Catch: java.lang.Exception -> Lc9
                            if (r10 == 0) goto L87
                            r9.L$0 = r6     // Catch: java.lang.Exception -> Lc9
                            r9.L$1 = r7     // Catch: java.lang.Exception -> Lc9
                            r9.label = r2     // Catch: java.lang.Exception -> Lc9
                            java.lang.Object r10 = r10.getUserAttributeVerificationCode(r3, r9)     // Catch: java.lang.Exception -> Lc9
                            if (r10 != r0) goto L80
                            return r0
                        L80:
                            r1 = r6
                            r0 = r7
                        L82:
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse r10 = (aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse) r10     // Catch: java.lang.Exception -> Lc9
                            r7 = r0
                            r6 = r1
                            goto L88
                        L87:
                            r10 = r4
                        L88:
                            if (r10 == 0) goto Lba
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryDetailsType r10 = r10.codeDeliveryDetails     // Catch: java.lang.Exception -> Lc9
                            if (r10 == 0) goto Lba
                            java.lang.String r0 = r10.attributeName
                            if (r0 == 0) goto Lb4
                            aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType r1 = r10.deliveryMedium     // Catch: java.lang.Exception -> Lc9
                            if (r1 == 0) goto L9a
                            java.lang.String r4 = r1.getValue()     // Catch: java.lang.Exception -> Lc9
                        L9a:
                            com.amplifyframework.auth.AuthCodeDeliveryDetails$DeliveryMedium r1 = com.amplifyframework.auth.AuthCodeDeliveryDetails.DeliveryMedium.fromString(r4)     // Catch: java.lang.Exception -> Lc9
                            java.lang.String r2 = "fromString(\n            …                        )"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.AuthCodeDeliveryDetails r2 = new com.amplifyframework.auth.AuthCodeDeliveryDetails     // Catch: java.lang.Exception -> Lc9
                            java.lang.String r10 = r10.destination     // Catch: java.lang.Exception -> Lc9
                            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Exception -> Lc9
                            r2.<init>(r10, r1, r0)     // Catch: java.lang.Exception -> Lc9
                            r6.accept(r2)     // Catch: java.lang.Exception -> Lc9
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lc9
                            goto Lb9
                        Lb4:
                            com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1$1$1$2 r10 = new com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1$1$1$1$2     // Catch: java.lang.Exception -> Lc9
                            r10.<init>(r7)     // Catch: java.lang.Exception -> Lc9
                        Lb9:
                            r4 = r10
                        Lba:
                            if (r4 != 0) goto Ld9
                        Lbc:
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r10 = r9.$onError     // Catch: java.lang.Exception -> Lc9
                            com.amplifyframework.auth.cognito.exceptions.configuration.InvalidUserPoolConfigurationException r0 = new com.amplifyframework.auth.cognito.exceptions.configuration.InvalidUserPoolConfigurationException     // Catch: java.lang.Exception -> Lc9
                            r0.<init>()     // Catch: java.lang.Exception -> Lc9
                            r10.accept(r0)     // Catch: java.lang.Exception -> Lc9
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lc9
                            goto Ld9
                        Lc9:
                            r10 = move-exception
                            com.amplifyframework.core.Consumer<com.amplifyframework.auth.AuthException> r0 = r9.$onError
                            com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter$Companion r1 = com.amplifyframework.auth.cognito.CognitoAuthExceptionConverter.Companion
                            java.lang.String r2 = r10.toString()
                            com.amplifyframework.auth.AuthException r10 = r1.lookup(r10, r2)
                            r0.accept(r10)
                        Ld9:
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendUserAttributeConfirmationCode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, onError, attributeKey, aWSCognitoAuthResendUserAttributeConfirmationCodeOptions, onSuccess, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resetPassword(String username, AuthResetPasswordOptions options, Consumer<AuthResetPasswordResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            try {
                CognitoIdentityProviderClient cognitoIdentityProviderClient = this.authEnvironment.getCognitoAuthService().getCognitoIdentityProviderClient();
                if (cognitoIdentityProviderClient != null) {
                    UserPoolConfiguration userPool = this.configuration.getUserPool();
                    String appClient = userPool != null ? userPool.getAppClient() : null;
                    if (appClient != null) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RealAWSCognitoAuthPlugin$resetPassword$1(this, username, cognitoIdentityProviderClient, appClient, options, onSuccess, onError, null), 3);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            } catch (Exception unused) {
                onError.accept(new InvalidUserPoolConfigurationException());
            }
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signIn(String str, String str2, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthSignInOptions.DefaultAuthSignInOptions defaults = AuthSignInOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            signIn(str, str2, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signInWithSocialWebUI(AuthProvider provider, Activity callingActivity, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AWSCognitoAuthWebUISignInOptions build = AWSCognitoAuthWebUISignInOptions.builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "builder().build()");
            signInWithSocialWebUI(provider, callingActivity, build, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signInWithWebUI(Activity callingActivity, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthWebUISignInOptions build = AuthWebUISignInOptions.builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "builder().build()");
            signInWithWebUI(callingActivity, build, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signOut(Consumer<AuthSignOutResult> onComplete) {
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            AuthSignOutOptions build = AuthSignOutOptions.builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "builder().build()");
            signOut(build, onComplete);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signUp(final String username, final String password, final AuthSignUpOptions options, final Consumer<AuthSignUpResult> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signUp$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signUp$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {206}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signUp$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<AuthSignUpResult> $onSuccess;
                    final /* synthetic */ AuthSignUpOptions $options;
                    final /* synthetic */ String $password;
                    final /* synthetic */ String $username;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$username = str;
                        this.$password = str2;
                        this.$options = authSignUpOptions;
                        this.$onSuccess = consumer;
                        this.$onError = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$username, this.$password, this.$options, this.$onSuccess, this.$onError, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object _signUp;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                            String str = this.$username;
                            String str2 = this.$password;
                            AuthSignUpOptions authSignUpOptions = this.$options;
                            Consumer<AuthSignUpResult> consumer = this.$onSuccess;
                            Consumer<AuthException> consumer2 = this.$onError;
                            this.label = 1;
                            _signUp = realAWSCognitoAuthPlugin._signUp(str, str2, authSignUpOptions, consumer, consumer2, this);
                            if (_signUp == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.NotConfigured) {
                        onError.accept(new InvalidUserPoolConfigurationException());
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedIn ? true : authNState instanceof AuthenticationState.SignedOut) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, username, password, options, onSuccess, onError, null), 3);
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void updatePassword(final String oldPassword, final String newPassword, final Action onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updatePassword$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        RealAWSCognitoAuthPlugin.this._updatePassword(oldPassword, newPassword, onSuccess, onError);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void updateUserAttribute(AuthUserAttribute attribute, AuthUpdateUserAttributeOptions options, Consumer<AuthUpdateAttributeResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attribute, "attribute");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RealAWSCognitoAuthPlugin$updateUserAttribute$1(attribute, options, this, onSuccess, onError, null), 3);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void updateUserAttributes(List<AuthUserAttribute> attributes, AuthUpdateUserAttributesOptions options, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RealAWSCognitoAuthPlugin$updateUserAttributes$1(options, onSuccess, this, attributes, onError, null), 3);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmResetPassword(String username, String newPassword, String confirmationCode, Action onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthConfirmResetPasswordOptions.DefaultAuthConfirmResetPasswordOptions defaults = AuthConfirmResetPasswordOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            confirmResetPassword(username, newPassword, confirmationCode, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmSignIn(final String challengeResponse, final AuthConfirmSignInOptions options, final Consumer<AuthSignInResult> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(challengeResponse, "challengeResponse");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmSignIn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    AuthenticationState.SigningIn signingIn = authNState instanceof AuthenticationState.SigningIn ? (AuthenticationState.SigningIn) authNState : null;
                    SignInState signInState = signingIn != null ? signingIn.getSignInState() : null;
                    if (signInState instanceof SignInState.ResolvingChallenge) {
                        if (((SignInState.ResolvingChallenge) signInState).getChallengeState() instanceof SignInChallengeState.WaitingForAnswer) {
                            RealAWSCognitoAuthPlugin.this._confirmSignIn(challengeResponse, options, onSuccess, onError);
                            return;
                        } else {
                            onError.accept(new InvalidStateException(null, null, null, 7, null));
                            return;
                        }
                    }
                    onError.accept(new InvalidStateException(null, null, null, 7, null));
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void confirmSignUp(final String username, final String confirmationCode, final AuthConfirmSignUpOptions options, final Consumer<AuthSignUpResult> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmSignUp$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmSignUp$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {322}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$confirmSignUp$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $confirmationCode;
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<AuthSignUpResult> $onSuccess;
                    final /* synthetic */ AuthConfirmSignUpOptions $options;
                    final /* synthetic */ String $username;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$username = str;
                        this.$confirmationCode = str2;
                        this.$options = authConfirmSignUpOptions;
                        this.$onSuccess = consumer;
                        this.$onError = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$username, this.$confirmationCode, this.$options, this.$onSuccess, this.$onError, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object _confirmSignUp;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                            String str = this.$username;
                            String str2 = this.$confirmationCode;
                            AuthConfirmSignUpOptions authConfirmSignUpOptions = this.$options;
                            Consumer<AuthSignUpResult> consumer = this.$onSuccess;
                            Consumer<AuthException> consumer2 = this.$onError;
                            this.label = 1;
                            _confirmSignUp = realAWSCognitoAuthPlugin._confirmSignUp(str, str2, authConfirmSignUpOptions, consumer, consumer2, this);
                            if (_confirmSignUp == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.NotConfigured) {
                        onError.accept(new InvalidUserPoolConfigurationException());
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedIn ? true : authNState instanceof AuthenticationState.SignedOut) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, username, confirmationCode, options, onSuccess, onError, null), 3);
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void fetchAuthSession(AuthFetchSessionOptions options, final Consumer<AuthSession> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            final boolean forceRefresh = options.getForceRefresh();
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$fetchAuthSession$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    AuthStateMachine authStateMachine;
                    AuthStateMachine authStateMachine2;
                    AuthStateMachine authStateMachine3;
                    AuthStateMachine authStateMachine4;
                    AuthStateMachine authStateMachine5;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthorizationState authZState = authState.getAuthZState();
                    if (authZState instanceof AuthorizationState.Configured) {
                        authStateMachine5 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                        authStateMachine5.send(new AuthorizationEvent(AuthorizationEvent.EventType.FetchUnAuthSession.INSTANCE, null, 2, null));
                        RealAWSCognitoAuthPlugin.this._fetchAuthSession(onSuccess, onError);
                        return;
                    }
                    if (authZState instanceof AuthorizationState.SessionEstablished) {
                        AmplifyCredential amplifyCredential = ((AuthorizationState.SessionEstablished) authZState).getAmplifyCredential();
                        if (AWSCognitoAuthSessionKt.isValid(amplifyCredential) && !forceRefresh) {
                            onSuccess.accept(AWSCognitoAuthSessionKt.getCognitoSession$default(amplifyCredential, null, 1, null));
                            return;
                        }
                        if (amplifyCredential instanceof AmplifyCredential.IdentityPoolFederated) {
                            authStateMachine4 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                            AmplifyCredential.IdentityPoolFederated identityPoolFederated = (AmplifyCredential.IdentityPoolFederated) amplifyCredential;
                            authStateMachine4.send(new AuthorizationEvent(new AuthorizationEvent.EventType.StartFederationToIdentityPool(identityPoolFederated.getFederatedToken(), identityPoolFederated.getIdentityId(), amplifyCredential), null, 2, null));
                        } else {
                            authStateMachine3 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                            authStateMachine3.send(new AuthorizationEvent(new AuthorizationEvent.EventType.RefreshSession(amplifyCredential), null, 2, null));
                        }
                        RealAWSCognitoAuthPlugin.this._fetchAuthSession(onSuccess, onError);
                        return;
                    }
                    if (authZState instanceof AuthorizationState.Error) {
                        Exception exception = ((AuthorizationState.Error) authZState).getException();
                        if (exception instanceof SessionError) {
                            AmplifyCredential amplifyCredential2 = ((SessionError) exception).getAmplifyCredential();
                            if (amplifyCredential2 instanceof AmplifyCredential.IdentityPoolFederated) {
                                authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                                AmplifyCredential.IdentityPoolFederated identityPoolFederated2 = (AmplifyCredential.IdentityPoolFederated) amplifyCredential2;
                                authStateMachine2.send(new AuthorizationEvent(new AuthorizationEvent.EventType.StartFederationToIdentityPool(identityPoolFederated2.getFederatedToken(), identityPoolFederated2.getIdentityId(), amplifyCredential2), null, 2, null));
                            } else {
                                authStateMachine = RealAWSCognitoAuthPlugin.this.authStateMachine;
                                authStateMachine.send(new AuthorizationEvent(new AuthorizationEvent.EventType.RefreshSession(amplifyCredential2), null, 2, null));
                            }
                            RealAWSCognitoAuthPlugin.this._fetchAuthSession(onSuccess, onError);
                            return;
                        }
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                        return;
                    }
                    onError.accept(new InvalidStateException(null, null, null, 7, null));
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void forgetDevice(final AuthDevice device, final Action onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$forgetDevice$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        String id = AuthDevice.this.getId();
                        Intrinsics.checkNotNullExpressionValue(id, "device.id");
                        if (!(id.length() == 0)) {
                            this.updateDevice(AuthDevice.this.getId(), DeviceRememberedStatusType.NotRemembered.INSTANCE, onSuccess, onError);
                            return;
                        }
                        DeviceMetadata deviceMetadata = ((AuthenticationState.SignedIn) authNState).getDeviceMetadata();
                        DeviceMetadata.Metadata metadata = deviceMetadata instanceof DeviceMetadata.Metadata ? (DeviceMetadata.Metadata) deviceMetadata : null;
                        this.updateDevice(metadata != null ? metadata.getDeviceKey() : null, DeviceRememberedStatusType.NotRemembered.INSTANCE, onSuccess, onError);
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedOut) {
                        onError.accept(new SignedOutException(null, null, null, 7, null));
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resendSignUpCode(final String username, final AuthResendSignUpCodeOptions options, final Consumer<AuthCodeDeliveryDetails> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendSignUpCode$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendSignUpCode$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {394}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$resendSignUpCode$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Consumer<AuthException> $onError;
                    final /* synthetic */ Consumer<AuthCodeDeliveryDetails> $onSuccess;
                    final /* synthetic */ AuthResendSignUpCodeOptions $options;
                    final /* synthetic */ String $username;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$username = str;
                        this.$options = authResendSignUpCodeOptions;
                        this.$onSuccess = consumer;
                        this.$onError = consumer2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$username, this.$options, this.$onSuccess, this.$onError, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object _resendSignUpCode;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                            String str = this.$username;
                            AuthResendSignUpCodeOptions authResendSignUpCodeOptions = this.$options;
                            Consumer<AuthCodeDeliveryDetails> consumer = this.$onSuccess;
                            Consumer<AuthException> consumer2 = this.$onError;
                            this.label = 1;
                            _resendSignUpCode = realAWSCognitoAuthPlugin._resendSignUpCode(str, authResendSignUpCodeOptions, consumer, consumer2, this);
                            if (_resendSignUpCode == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.NotConfigured) {
                        onError.accept(new InvalidUserPoolConfigurationException());
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedIn ? true : authNState instanceof AuthenticationState.SignedOut) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, username, options, onSuccess, onError, null), 3);
                    } else {
                        onError.accept(new InvalidStateException(null, null, null, 7, null));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signIn(final String str, final String str2, final AuthSignInOptions options, final Consumer<AuthSignInResult> onSuccess, final Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signIn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    AuthStateMachine authStateMachine;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthSignInOptions authSignInOptions = AuthSignInOptions.this;
                    AWSCognitoAuthSignInOptions aWSCognitoAuthSignInOptions = authSignInOptions instanceof AWSCognitoAuthSignInOptions ? (AWSCognitoAuthSignInOptions) authSignInOptions : null;
                    if (aWSCognitoAuthSignInOptions == null) {
                        aWSCognitoAuthSignInOptions = AWSCognitoAuthSignInOptions.builder().authFlowType(this.configuration.getAuthFlowType()).build();
                        Intrinsics.checkNotNullExpressionValue(aWSCognitoAuthSignInOptions, "builder()\n              …\n                .build()");
                    }
                    final AWSCognitoAuthSignInOptions aWSCognitoAuthSignInOptions2 = aWSCognitoAuthSignInOptions;
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.NotConfigured) {
                        onError.accept(new InvalidUserPoolConfigurationException());
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedOut ? true : authNState instanceof AuthenticationState.Configured) {
                        this._signIn(str, str2, aWSCognitoAuthSignInOptions2, onSuccess, onError);
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        onError.accept(new SignedInException(null, null, 3, null));
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SigningIn) {
                        final StateChangeListenerToken stateChangeListenerToken = new StateChangeListenerToken();
                        authStateMachine = this.authStateMachine;
                        final RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this;
                        final String str3 = str;
                        final String str4 = str2;
                        final Consumer<AuthSignInResult> consumer = onSuccess;
                        final Consumer<AuthException> consumer2 = onError;
                        Function1<AuthState, Unit> function1 = new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signIn$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState2) {
                                invoke2(authState2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AuthState authState2) {
                                AuthStateMachine authStateMachine2;
                                Intrinsics.checkNotNullParameter(authState2, "authState");
                                if (authState2.getAuthNState() instanceof AuthenticationState.SignedOut) {
                                    authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                                    authStateMachine2.cancel(stateChangeListenerToken);
                                    RealAWSCognitoAuthPlugin.this._signIn(str3, str4, aWSCognitoAuthSignInOptions2, consumer, consumer2);
                                }
                            }
                        };
                        final RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin2 = this;
                        authStateMachine.listen(stateChangeListenerToken, function1, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signIn$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                AuthStateMachine authStateMachine2;
                                authStateMachine2 = RealAWSCognitoAuthPlugin.this.authStateMachine;
                                authStateMachine2.send(new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignIn(null, 1, null), null, 2, null));
                            }
                        });
                        return;
                    }
                    onError.accept(new InvalidStateException(null, null, null, 7, null));
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signInWithWebUI(Activity callingActivity, AuthWebUISignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            signInWithHostedUI$default(this, null, callingActivity, options, onSuccess, onError, 1, null);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signOut(final AuthSignOutOptions options, final Consumer<AuthSignOutResult> onComplete) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$signOut$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    AuthStateMachine authStateMachine;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.NotConfigured) {
                        onComplete.accept(AWSCognitoAuthSignOutResult.CompleteSignOut.INSTANCE);
                        return;
                    }
                    if (authNState instanceof AuthenticationState.SignedIn ? true : authNState instanceof AuthenticationState.SignedOut) {
                        boolean isGlobalSignOut = options.isGlobalSignOut();
                        AuthSignOutOptions authSignOutOptions = options;
                        AWSCognitoAuthSignOutOptions aWSCognitoAuthSignOutOptions = authSignOutOptions instanceof AWSCognitoAuthSignOutOptions ? (AWSCognitoAuthSignOutOptions) authSignOutOptions : null;
                        AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignOutRequested(new SignOutData(isGlobalSignOut, aWSCognitoAuthSignOutOptions != null ? aWSCognitoAuthSignOutOptions.getBrowserPackage() : null, false, 4, null)), null, 2, null);
                        authStateMachine = this.authStateMachine;
                        authStateMachine.send(authenticationEvent);
                        RealAWSCognitoAuthPlugin._signOut$default(this, false, onComplete, 1, null);
                        return;
                    }
                    if (authNState instanceof AuthenticationState.FederatedToIdentityPool) {
                        onComplete.accept(new AWSCognitoAuthSignOutResult.FailedSignOut(new InvalidStateException("The user is currently federated to identity pool. You must call clearFederationToIdentityPool to clear credentials.", null, null, 6, null)));
                    } else {
                        onComplete.accept(new AWSCognitoAuthSignOutResult.FailedSignOut(new InvalidStateException(null, null, null, 7, null)));
                    }
                }
            });
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void updateUserAttribute(AuthUserAttribute attribute, Consumer<AuthUpdateAttributeResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attribute, "attribute");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthUpdateUserAttributeOptions.DefaultAuthUpdateUserAttributeOptions defaults = AuthUpdateUserAttributeOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            updateUserAttribute(attribute, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void updateUserAttributes(List<AuthUserAttribute> attributes, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthUpdateUserAttributesOptions.DefaultAuthUpdateUserAttributesOptions defaults = AuthUpdateUserAttributesOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            updateUserAttributes(attributes, defaults, onSuccess, onError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object updateUserAttributes(final List<AuthUserAttribute> list, final Map<String, String> map, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation) {
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            this.authStateMachine.getCurrentState(new Function1<AuthState, Unit>() { // from class: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttributes$3$1

                /* compiled from: RealAWSCognitoAuthPlugin.kt */
                @DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttributes$3$1$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1407, 1421}, m = "invokeSuspend")
                /* renamed from: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttributes$3$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ List<AuthUserAttribute> $attributes;
                    final /* synthetic */ Continuation<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> $continuation;
                    final /* synthetic */ Map<String, String> $userAttributesOptionsMetadata;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation, List<AuthUserAttribute> list, Map<String, String> map, Continuation<? super AnonymousClass1> continuation2) {
                        super(2, continuation2);
                        this.this$0 = realAWSCognitoAuthPlugin;
                        this.$continuation = continuation;
                        this.$attributes = list;
                        this.$userAttributesOptionsMetadata = map;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$continuation, this.$attributes, this.$userAttributesOptionsMetadata, continuation);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x00d9 A[Catch: Exception -> 0x008e, TRY_LEAVE, TryCatch #0 {Exception -> 0x008e, blocks: (B:7:0x0018, B:8:0x00c4, B:9:0x00ca, B:11:0x00d9, B:18:0x0025, B:19:0x0037, B:21:0x0046, B:23:0x004e, B:24:0x006c, B:26:0x0072, B:28:0x0090, B:30:0x00b2, B:36:0x002c), top: B:2:0x0006 }] */
                    /* JADX WARN: Type inference failed for: r8v0, types: [T, java.util.ArrayList] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                        /*
                            Method dump skipped, instructions count: 254
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttributes$3$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                    invoke2(authState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AuthState authState) {
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    AuthenticationState authNState = authState.getAuthNState();
                    if (authNState instanceof AuthenticationState.SignedIn) {
                        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, safeContinuation, list, map, null), 3);
                    } else if (authNState instanceof AuthenticationState.SignedOut) {
                        safeContinuation.resumeWith(ResultKt.createFailure(new SignedOutException(null, null, null, 7, null)));
                    } else {
                        safeContinuation.resumeWith(ResultKt.createFailure(new InvalidStateException(null, null, null, 7, null)));
                    }
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return orThrow;
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resendUserAttributeConfirmationCode(AuthUserAttributeKey attributeKey, Consumer<AuthCodeDeliveryDetails> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(attributeKey, "attributeKey");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthResendUserAttributeConfirmationCodeOptions.DefaultAuthResendUserAttributeConfirmationCodeOptions defaults = AuthResendUserAttributeConfirmationCodeOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            resendUserAttributeConfirmationCode(attributeKey, defaults, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void signInWithSocialWebUI(AuthProvider provider, Activity callingActivity, AuthWebUISignInOptions options, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            signInWithHostedUI(provider, callingActivity, options, onSuccess, onError);
        }

        @Override // com.amplifyframework.auth.AuthCategoryBehavior
        public void resetPassword(String username, Consumer<AuthResetPasswordResult> onSuccess, Consumer<AuthException> onError) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            AuthResetPasswordOptions.DefaultAuthResetPasswordOptions defaults = AuthResetPasswordOptions.defaults();
            Intrinsics.checkNotNullExpressionValue(defaults, "defaults()");
            resetPassword(username, defaults, onSuccess, onError);
        }
    }
