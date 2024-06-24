package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.AuthActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import java.util.Date;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthCognitoActions.kt */
/* loaded from: classes.dex */
public final class AuthCognitoActions implements AuthActions {
    public static final AuthCognitoActions INSTANCE = new AuthCognitoActions();

    private AuthCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthActions
    public Action initializeAuthConfigurationAction(AuthEvent.EventType.ConfigureAuth event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1("InitAuthConfig");
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthActions
    public Action initializeAuthenticationConfigurationAction(final AuthEvent.EventType.ConfigureAuthentication event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitAuthNConfig";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthenticationConfigurationAction$$inlined$invoke$1
            final /* synthetic */ AuthEvent.EventType.ConfigureAuthentication $event$inlined;
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
                AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.Configure(this.$event$inlined.getConfiguration(), this.$event$inlined.getStoredCredentials()), null, 2, null);
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

    @Override // com.amplifyframework.statemachine.codegen.actions.AuthActions
    public Action initializeAuthorizationConfigurationAction(final AuthEvent.EventType event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitAuthZConfig";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1
            final /* synthetic */ AuthEvent.EventType $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                AuthorizationEvent authorizationEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                AuthCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1 authCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1 = new Function1<AmplifyCredential, AuthorizationEvent>() { // from class: com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1
                    @Override // kotlin.jvm.functions.Function1
                    public final AuthorizationEvent invoke(AmplifyCredential credentials) {
                        Intrinsics.checkNotNullParameter(credentials, "credentials");
                        int r1 = 2;
                        Date date = null;
                        byte b = 0;
                        byte b2 = 0;
                        byte b3 = 0;
                        if (Intrinsics.areEqual(credentials, AmplifyCredential.Empty.INSTANCE)) {
                            return new AuthorizationEvent(AuthorizationEvent.EventType.Configure.INSTANCE, date, r1, b3 == true ? 1 : 0);
                        }
                        return new AuthorizationEvent(new AuthorizationEvent.EventType.CachedCredentialsAvailable(credentials), b2 == true ? 1 : 0, r1, b == true ? 1 : 0);
                    }
                };
                AuthEvent.EventType eventType = this.$event$inlined;
                if (eventType instanceof AuthEvent.EventType.ConfiguredAuthentication) {
                    authorizationEvent = authCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1.invoke((AuthCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1) ((AuthEvent.EventType.ConfiguredAuthentication) eventType).getStoredCredentials());
                } else if (eventType instanceof AuthEvent.EventType.ConfigureAuthorization) {
                    authorizationEvent = authCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1.invoke((AuthCognitoActions$initializeAuthorizationConfigurationAction$1$handleEvent$1) ((AuthEvent.EventType.ConfigureAuthorization) eventType).getStoredCredentials());
                } else {
                    authorizationEvent = new AuthorizationEvent(AuthorizationEvent.EventType.Configure.INSTANCE, null, 2, 0 == true ? 1 : 0);
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
}
