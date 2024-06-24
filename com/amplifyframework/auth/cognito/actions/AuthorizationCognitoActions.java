package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.auth.exceptions.ConfigurationException;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.actions.AuthorizationActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.FederatedToken;
import com.amplifyframework.statemachine.codegen.data.IdentityPoolConfiguration;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.DeleteUserEvent;
import com.amplifyframework.statemachine.codegen.events.FetchAuthSessionEvent;
import com.amplifyframework.statemachine.codegen.events.RefreshSessionEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationCognitoActions.kt */
/* loaded from: classes.dex */
public final class AuthorizationCognitoActions implements AuthorizationActions {
    public static final AuthorizationCognitoActions INSTANCE = new AuthorizationCognitoActions();

    private AuthorizationCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action configureAuthorizationAction() {
        Action.Companion companion = Action.Companion;
        final String str = "ConfigureAuthZ";
        return new Action(str) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$configureAuthorizationAction$$inlined$invoke$1
            private final String id;

            {
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                AuthEvent authEvent = new AuthEvent(AuthEvent.EventType.ConfiguredAuthorization.INSTANCE, null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action initializeFederationToIdentityPool(final FederatedToken federatedToken, final String str) {
        Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
        Action.Companion companion = Action.Companion;
        final String str2 = "InitializeFederationToIdentityPool";
        return new Action(str2, federatedToken, str) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$initializeFederationToIdentityPool$$inlined$invoke$1
            final /* synthetic */ String $developerProvidedIdentityId$inlined;
            final /* synthetic */ FederatedToken $federatedToken$inlined;
            private final String id;

            {
                this.$federatedToken$inlined = federatedToken;
                this.$developerProvidedIdentityId$inlined = str;
                this.id = str2 == null ? Action.DefaultImpls.getId(this) : str2;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                FetchAuthSessionEvent fetchAuthSessionEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                LoginsMapProvider.AuthProviderLogins authProviderLogins = new LoginsMapProvider.AuthProviderLogins(this.$federatedToken$inlined);
                String str3 = this.$developerProvidedIdentityId$inlined;
                if (str3 != null) {
                    fetchAuthSessionEvent = new FetchAuthSessionEvent(new FetchAuthSessionEvent.EventType.FetchAwsCredentials(str3, authProviderLogins), null, 2, null);
                } else {
                    fetchAuthSessionEvent = new FetchAuthSessionEvent(new FetchAuthSessionEvent.EventType.FetchIdentity(authProviderLogins), null, 2, null);
                }
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(fetchAuthSessionEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(fetchAuthSessionEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action initializeFetchAuthSession(final SignedInData signedInData) {
        Intrinsics.checkNotNullParameter(signedInData, "signedInData");
        Action.Companion companion = Action.Companion;
        final String str = "InitFetchAuthSession";
        return new Action(str, signedInData) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$initializeFetchAuthSession$$inlined$invoke$1
            final /* synthetic */ SignedInData $signedInData$inlined;
            private final String id;

            {
                this.$signedInData$inlined = signedInData;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                String str2;
                String str3;
                StateMachineEvent fetchAuthSessionEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                UserPoolConfiguration userPool = authEnvironment.getConfiguration().getUserPool();
                if (userPool != null) {
                    str2 = userPool.getPoolId();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    fetchAuthSessionEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new ConfigurationException("User Pool not configured.", "Please check amplifyconfiguration.json file.", null, 4, null)), null, 2, null);
                } else {
                    IdentityPoolConfiguration identityPool = authEnvironment.getConfiguration().getIdentityPool();
                    if (identityPool != null) {
                        str3 = identityPool.getPoolId();
                    } else {
                        str3 = null;
                    }
                    if (str3 == null) {
                        fetchAuthSessionEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new ConfigurationException("Identity Pool not configured.", "Please check amplifyconfiguration.json file.", null, 4, null)), null, 2, null);
                    } else if (this.$signedInData$inlined.getCognitoUserPoolTokens().getIdToken() == null) {
                        fetchAuthSessionEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new ConfigurationException("Identity token is null.", "Sorry, we don't have a suggested fix for this error yet.", null, 4, null)), null, 2, null);
                    } else {
                        fetchAuthSessionEvent = new FetchAuthSessionEvent(new FetchAuthSessionEvent.EventType.FetchIdentity(new LoginsMapProvider.CognitoUserPoolLogins(authEnvironment.getConfiguration().getUserPool().getRegion(), authEnvironment.getConfiguration().getUserPool().getPoolId(), this.$signedInData$inlined.getCognitoUserPoolTokens().getIdToken())), null, 2, null);
                    }
                }
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(fetchAuthSessionEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(fetchAuthSessionEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action initializeFetchUnAuthSession() {
        Action.Companion companion = Action.Companion;
        final String str = "InitFetchUnAuthSession";
        return new Action(str) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$initializeFetchUnAuthSession$$inlined$invoke$1
            private final String id;

            {
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                StateMachineEvent authorizationEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                IdentityPoolConfiguration identityPool = authEnvironment.getConfiguration().getIdentityPool();
                if (identityPool != null && identityPool.getPoolId() != null) {
                    authorizationEvent = new FetchAuthSessionEvent(new FetchAuthSessionEvent.EventType.FetchIdentity(new LoginsMapProvider.UnAuthLogins(null, 1, null)), null, 2, null);
                } else {
                    authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new ConfigurationException("Identity Pool not configured.", "Please check amplifyconfiguration.json file.", null, 4, null)), null, 2, null);
                }
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authorizationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authorizationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action initiateDeleteUser(final DeleteUserEvent.EventType.DeleteUser event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitiateDeleteUser";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$initiateDeleteUser$$inlined$invoke$1
            final /* synthetic */ DeleteUserEvent.EventType.DeleteUser $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                DeleteUserEvent deleteUserEvent = new DeleteUserEvent(new DeleteUserEvent.EventType.DeleteUser(this.$event$inlined.getAccessToken()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(deleteUserEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(deleteUserEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action initiateRefreshSessionAction(final AmplifyCredential amplifyCredential) {
        Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
        Action.Companion companion = Action.Companion;
        final String str = "InitiateRefreshSession";
        return new Action(str, amplifyCredential) { // from class: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$initiateRefreshSessionAction$$inlined$invoke$1
            final /* synthetic */ AmplifyCredential $amplifyCredential$inlined;
            private final String id;

            {
                this.$amplifyCredential$inlined = amplifyCredential;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                StateMachineEvent authorizationEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                Object obj = this.$amplifyCredential$inlined;
                if (obj instanceof AmplifyCredential.UserPoolTypeCredential) {
                    authorizationEvent = new RefreshSessionEvent(new RefreshSessionEvent.EventType.RefreshUserPoolTokens(((AmplifyCredential.UserPoolTypeCredential) obj).getSignedInData()), null, 2, null);
                } else if (obj instanceof AmplifyCredential.IdentityPool) {
                    authorizationEvent = new RefreshSessionEvent(new RefreshSessionEvent.EventType.RefreshUnAuthSession(new LoginsMapProvider.UnAuthLogins(null, 1, null)), null, 2, null);
                } else if (obj instanceof AmplifyCredential.IdentityPoolFederated) {
                    authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new Exception("Refreshing credentials from federationToIdentityPool is not supported.")), null, 2, null);
                } else {
                    authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.ThrowError(new Exception("Credentials empty, cannot refresh.")), null, 2, null);
                }
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authorizationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authorizationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthorizationActions
    public Action persistCredentials(AmplifyCredential amplifyCredential) {
        Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
        Action.Companion companion = Action.Companion;
        return new AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1("PersistCredentials", amplifyCredential);
    }
}
