package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.auth.exceptions.ValidationException;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.actions.AuthenticationActions;
import com.amplifyframework.statemachine.codegen.data.SignInData;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationCognitoActions.kt */
/* loaded from: classes.dex */
public final class AuthenticationCognitoActions implements AuthenticationActions {
    public static final AuthenticationCognitoActions INSTANCE = new AuthenticationCognitoActions();

    private AuthenticationCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthenticationActions
    public Action configureAuthenticationAction(AuthenticationEvent.EventType.Configure event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1("ConfigureAuthN", event);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthenticationActions
    public Action initiateSignInAction(final AuthenticationEvent.EventType.SignInRequested event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitiateSignInAction";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions$initiateSignInAction$$inlined$invoke$1
            final /* synthetic */ AuthenticationEvent.EventType.SignInRequested $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                StateMachineEvent authenticationEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                SignInData signInData = this.$event$inlined.getSignInData();
                if (signInData instanceof SignInData.SRPSignInData) {
                    SignInData.SRPSignInData sRPSignInData = (SignInData.SRPSignInData) signInData;
                    if (sRPSignInData.getUsername() != null && sRPSignInData.getPassword() != null) {
                        authenticationEvent = new SignInEvent(new SignInEvent.EventType.InitiateSignInWithSRP(sRPSignInData.getUsername(), sRPSignInData.getPassword(), sRPSignInData.getMetadata()), null, 2, null);
                    } else {
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.ThrowError(new ValidationException("Sign in failed.", "username or password empty", null, 4, null)), null, 2, null);
                    }
                } else if (signInData instanceof SignInData.CustomAuthSignInData) {
                    SignInData.CustomAuthSignInData customAuthSignInData = (SignInData.CustomAuthSignInData) signInData;
                    if (customAuthSignInData.getUsername() != null) {
                        authenticationEvent = new SignInEvent(new SignInEvent.EventType.InitiateSignInWithCustom(customAuthSignInData.getUsername(), customAuthSignInData.getMetadata()), null, 2, null);
                    } else {
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.ThrowError(new ValidationException("Sign in failed.", "username can not be empty", null, 4, null)), null, 2, null);
                    }
                } else if (signInData instanceof SignInData.CustomSRPAuthSignInData) {
                    SignInData.CustomSRPAuthSignInData customSRPAuthSignInData = (SignInData.CustomSRPAuthSignInData) signInData;
                    if (customSRPAuthSignInData.getUsername() != null && customSRPAuthSignInData.getPassword() != null) {
                        authenticationEvent = new SignInEvent(new SignInEvent.EventType.InitiateCustomSignInWithSRP(customSRPAuthSignInData.getUsername(), customSRPAuthSignInData.getPassword(), customSRPAuthSignInData.getMetadata()), null, 2, null);
                    } else {
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.ThrowError(new ValidationException("Sign in failed.", "username can not be empty", null, 4, null)), null, 2, null);
                    }
                } else if (signInData instanceof SignInData.HostedUISignInData) {
                    authenticationEvent = new SignInEvent(new SignInEvent.EventType.InitiateHostedUISignIn((SignInData.HostedUISignInData) signInData), null, 2, null);
                } else if (signInData instanceof SignInData.MigrationAuthSignInData) {
                    SignInData.MigrationAuthSignInData migrationAuthSignInData = (SignInData.MigrationAuthSignInData) signInData;
                    if (migrationAuthSignInData.getUsername() != null && migrationAuthSignInData.getPassword() != null) {
                        authenticationEvent = new SignInEvent(new SignInEvent.EventType.InitiateMigrateAuth(migrationAuthSignInData.getUsername(), migrationAuthSignInData.getPassword(), migrationAuthSignInData.getMetadata()), null, 2, null);
                    } else {
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.ThrowError(new ValidationException("Sign in failed.", "username or password empty", null, 4, null)), null, 2, null);
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
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

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthenticationActions
    public Action initiateSignOutAction(final AuthenticationEvent.EventType.SignOutRequested event, final SignedInData signedInData) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitSignOut";
        return new Action(str, signedInData, event) { // from class: com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions$initiateSignOutAction$$inlined$invoke$1
            final /* synthetic */ AuthenticationEvent.EventType.SignOutRequested $event$inlined;
            final /* synthetic */ SignedInData $signedInData$inlined;
            private final String id;

            {
                this.$signedInData$inlined = signedInData;
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                SignOutEvent signOutEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                SignedInData signedInData2 = this.$signedInData$inlined;
                if (signedInData2 != null && (signedInData2.getSignInMethod() instanceof SignInMethod.HostedUI)) {
                    signOutEvent = new SignOutEvent(new SignOutEvent.EventType.InvokeHostedUISignOut(this.$event$inlined.getSignOutData(), this.$signedInData$inlined), null, 2, null);
                } else {
                    SignedInData signedInData3 = this.$signedInData$inlined;
                    if (signedInData3 != null && Intrinsics.areEqual(signedInData3.getSignInMethod(), new SignInMethod.ApiBased(SignInMethod.ApiBased.AuthType.UNKNOWN)) && authEnvironment.getHostedUIClient() != null) {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.InvokeHostedUISignOut(this.$event$inlined.getSignOutData(), this.$signedInData$inlined), null, 2, null);
                    } else if (this.$signedInData$inlined != null && this.$event$inlined.getSignOutData().getGlobalSignOut()) {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.SignOutGlobally(this.$signedInData$inlined, null, 2, null), null, 2, null);
                    } else if (this.$signedInData$inlined != null && !this.$event$inlined.getSignOutData().getGlobalSignOut()) {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.RevokeToken(this.$signedInData$inlined, null, null, 6, null), null, 2, null);
                    } else {
                        signOutEvent = new SignOutEvent(new SignOutEvent.EventType.SignOutLocally(this.$signedInData$inlined, null, null, null, 14, null), null, 2, null);
                    }
                }
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
}
