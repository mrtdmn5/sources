package com.amplifyframework.auth.cognito.actions;

import android.net.Uri;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.auth.cognito.HostedUIClient;
import com.amplifyframework.auth.cognito.exceptions.configuration.InvalidOauthConfigurationException;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.SignOutActions;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.HostedUIErrorData;
import com.amplifyframework.statemachine.codegen.data.RevokeTokenErrorData;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignOutCognitoActions.kt */
/* loaded from: classes.dex */
public final class SignOutCognitoActions implements SignOutActions {
    public static final SignOutCognitoActions INSTANCE = new SignOutCognitoActions();

    private SignOutCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action buildRevokeTokenErrorAction(final SignOutEvent.EventType.SignOutGloballyError event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "BuildRevokeTokenError";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$buildRevokeTokenErrorAction$$inlined$invoke$1
            final /* synthetic */ SignOutEvent.EventType.SignOutGloballyError $event$inlined;
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
                SignOutEvent signOutEvent = new SignOutEvent(new SignOutEvent.EventType.SignOutLocally(this.$event$inlined.getSignedInData(), this.$event$inlined.getHostedUIErrorData(), this.$event$inlined.getGlobalSignOutErrorData(), new RevokeTokenErrorData(this.$event$inlined.getSignedInData().getCognitoUserPoolTokens().getRefreshToken(), new Exception("RevokeToken not attempted because GlobalSignOut failed."))), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(signOutEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(signOutEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action globalSignOutAction(SignOutEvent.EventType.SignOutGlobally event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new SignOutCognitoActions$globalSignOutAction$$inlined$invoke$1("GlobalSignOut", event);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action hostedUISignOutAction(final SignOutEvent.EventType.InvokeHostedUISignOut event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "HostedUISignOut";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$hostedUISignOutAction$$inlined$invoke$1
            final /* synthetic */ SignOutEvent.EventType.InvokeHostedUISignOut $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                String str2;
                SignOutEvent signOutEvent;
                Uri createSignOutUri$aws_auth_cognito_release;
                SignInMethod.HostedUI hostedUI;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                try {
                } catch (Exception e) {
                    authEnvironment.getLogger().warn("Failed to sign out web ui.", e);
                    HostedUIClient hostedUIClient = authEnvironment.getHostedUIClient();
                    if (hostedUIClient != null && (createSignOutUri$aws_auth_cognito_release = hostedUIClient.createSignOutUri$aws_auth_cognito_release()) != null) {
                        str2 = createSignOutUri$aws_auth_cognito_release.toString();
                    } else {
                        str2 = null;
                    }
                    HostedUIErrorData hostedUIErrorData = new HostedUIErrorData(str2, e);
                    if (this.$event$inlined.getSignOutData().getGlobalSignOut()) {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.SignOutGlobally(this.$event$inlined.getSignedInData(), hostedUIErrorData), null, 2, null);
                    } else {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.RevokeToken(this.$event$inlined.getSignedInData(), hostedUIErrorData, null, 4, null), null, 2, null);
                    }
                    Logger logger = authEnvironment.getLogger();
                    StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                    m.append(signOutEvent.getType());
                    logger.verbose(m.toString());
                    eventDispatcher.send(signOutEvent);
                }
                if (authEnvironment.getHostedUIClient() != null) {
                    String browserPackage = this.$event$inlined.getSignOutData().getBrowserPackage();
                    if (browserPackage == null) {
                        SignInMethod signInMethod = this.$event$inlined.getSignedInData().getSignInMethod();
                        if (signInMethod instanceof SignInMethod.HostedUI) {
                            hostedUI = (SignInMethod.HostedUI) signInMethod;
                        } else {
                            hostedUI = null;
                        }
                        if (hostedUI != null) {
                            browserPackage = hostedUI.getBrowserPackage();
                        } else {
                            browserPackage = null;
                        }
                    }
                    authEnvironment.getHostedUIClient().launchCustomTabsSignOut(browserPackage);
                    return Unit.INSTANCE;
                }
                throw new InvalidOauthConfigurationException();
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action localSignOutAction(final SignOutEvent.EventType.SignOutLocally event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "LocalSignOut";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$localSignOutAction$$inlined$invoke$1
            final /* synthetic */ SignOutEvent.EventType.SignOutLocally $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                String str2;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                SignedInData signedInData = this.$event$inlined.getSignedInData();
                if (signedInData != null) {
                    str2 = signedInData.getUsername();
                } else {
                    str2 = null;
                }
                SignOutEvent signOutEvent = new SignOutEvent(new SignOutEvent.EventType.SignedOutSuccess(new SignedOutData(str2, this.$event$inlined.getHostedUIErrorData(), this.$event$inlined.getGlobalSignOutErrorData(), this.$event$inlined.getRevokeTokenErrorData())), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(signOutEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(signOutEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action revokeTokenAction(SignOutEvent.EventType.RevokeToken event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1("RevokeTokens", event);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignOutActions
    public Action userCancelledAction(final SignOutEvent.EventType.UserCancelled event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "UserCancelledSignOut";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$userCancelledAction$$inlined$invoke$1
            final /* synthetic */ SignOutEvent.EventType.UserCancelled $event$inlined;
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
                AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignOut(this.$event$inlined.getSignedInData(), DeviceMetadata.Empty.INSTANCE), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authenticationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authenticationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }
}
