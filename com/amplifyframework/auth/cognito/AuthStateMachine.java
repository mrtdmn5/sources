package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.cognito.actions.AuthCognitoActions;
import com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions;
import com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions;
import com.amplifyframework.auth.cognito.actions.DeleteUserCognitoActions;
import com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions;
import com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions;
import com.amplifyframework.auth.cognito.actions.HostedUICognitoActions;
import com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions;
import com.amplifyframework.auth.cognito.actions.SRPCognitoActions;
import com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions;
import com.amplifyframework.auth.cognito.actions.SignInCognitoActions;
import com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions;
import com.amplifyframework.auth.cognito.actions.SignOutCognitoActions;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.StateMachine;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.codegen.states.AuthState;
import com.amplifyframework.statemachine.codegen.states.AuthenticationState;
import com.amplifyframework.statemachine.codegen.states.AuthorizationState;
import com.amplifyframework.statemachine.codegen.states.CustomSignInState;
import com.amplifyframework.statemachine.codegen.states.DeleteUserState;
import com.amplifyframework.statemachine.codegen.states.DeviceSRPSignInState;
import com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState;
import com.amplifyframework.statemachine.codegen.states.HostedUISignInState;
import com.amplifyframework.statemachine.codegen.states.MigrateSignInState;
import com.amplifyframework.statemachine.codegen.states.RefreshSessionState;
import com.amplifyframework.statemachine.codegen.states.SRPSignInState;
import com.amplifyframework.statemachine.codegen.states.SignInChallengeState;
import com.amplifyframework.statemachine.codegen.states.SignInState;
import com.amplifyframework.statemachine.codegen.states.SignOutState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthStateMachine.kt */
/* loaded from: classes.dex */
public final class AuthStateMachine extends StateMachine<AuthState, Environment> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: AuthStateMachine.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthStateMachine logging(Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            LoggingStateMachineResolver logging$default = StateMachineResolver.DefaultImpls.logging$default(new AuthenticationState.Resolver(StateMachineResolver.DefaultImpls.logging$default(new SignInState.Resolver(StateMachineResolver.DefaultImpls.logging$default(new SRPSignInState.Resolver(SRPCognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new CustomSignInState.Resolver(SignInCustomCognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new MigrateSignInState.Resolver(MigrateAuthCognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new SignInChallengeState.Resolver(SignInChallengeCognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new HostedUISignInState.Resolver(HostedUICognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new DeviceSRPSignInState.Resolver(DeviceSRPCognitoSignInActions.INSTANCE), null, null, 3, null), SignInCognitoActions.INSTANCE), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new SignOutState.Resolver(SignOutCognitoActions.INSTANCE), null, null, 3, null), AuthenticationCognitoActions.INSTANCE), null, null, 3, null);
            FetchAuthSessionCognitoActions fetchAuthSessionCognitoActions = FetchAuthSessionCognitoActions.INSTANCE;
            return new AuthStateMachine(StateMachineResolver.DefaultImpls.logging$default(new AuthState.Resolver(logging$default, StateMachineResolver.DefaultImpls.logging$default(new AuthorizationState.Resolver(StateMachineResolver.DefaultImpls.logging$default(new FetchAuthSessionState.Resolver(fetchAuthSessionCognitoActions), null, null, 3, null), StateMachineResolver.DefaultImpls.logging$default(new RefreshSessionState.Resolver(StateMachineResolver.DefaultImpls.logging$default(new FetchAuthSessionState.Resolver(fetchAuthSessionCognitoActions), null, null, 3, null), fetchAuthSessionCognitoActions), null, null, 3, null), new DeleteUserState.Resolver(DeleteUserCognitoActions.INSTANCE), AuthorizationCognitoActions.INSTANCE), null, null, 3, null), AuthCognitoActions.INSTANCE), null, null, 3, null), environment, null, 4, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AuthStateMachine(StateMachineResolver stateMachineResolver, Environment environment, AuthState authState, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(stateMachineResolver, environment, (r4 & 4) != 0 ? null : authState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthStateMachine(StateMachineResolver<AuthState> resolver, Environment environment, AuthState authState) {
        super(resolver, environment, null, null, authState, 12, null);
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(environment, "environment");
    }

    public /* synthetic */ AuthStateMachine(Environment environment, AuthState authState, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(environment, (r3 & 2) != 0 ? null : authState);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AuthStateMachine(com.amplifyframework.statemachine.Environment r12, com.amplifyframework.statemachine.codegen.states.AuthState r13) {
        /*
            r11 = this;
            java.lang.String r0 = "environment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.amplifyframework.statemachine.codegen.states.AuthState$Resolver r0 = new com.amplifyframework.statemachine.codegen.states.AuthState$Resolver
            com.amplifyframework.statemachine.codegen.states.AuthenticationState$Resolver r1 = new com.amplifyframework.statemachine.codegen.states.AuthenticationState$Resolver
            com.amplifyframework.statemachine.codegen.states.SignInState$Resolver r10 = new com.amplifyframework.statemachine.codegen.states.SignInState$Resolver
            com.amplifyframework.statemachine.codegen.states.SRPSignInState$Resolver r3 = new com.amplifyframework.statemachine.codegen.states.SRPSignInState$Resolver
            com.amplifyframework.auth.cognito.actions.SRPCognitoActions r2 = com.amplifyframework.auth.cognito.actions.SRPCognitoActions.INSTANCE
            r3.<init>(r2)
            com.amplifyframework.statemachine.codegen.states.CustomSignInState$Resolver r4 = new com.amplifyframework.statemachine.codegen.states.CustomSignInState$Resolver
            com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions r2 = com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions.INSTANCE
            r4.<init>(r2)
            com.amplifyframework.statemachine.codegen.states.MigrateSignInState$Resolver r5 = new com.amplifyframework.statemachine.codegen.states.MigrateSignInState$Resolver
            com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions r2 = com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions.INSTANCE
            r5.<init>(r2)
            com.amplifyframework.statemachine.codegen.states.SignInChallengeState$Resolver r6 = new com.amplifyframework.statemachine.codegen.states.SignInChallengeState$Resolver
            com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions r2 = com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions.INSTANCE
            r6.<init>(r2)
            com.amplifyframework.statemachine.codegen.states.HostedUISignInState$Resolver r7 = new com.amplifyframework.statemachine.codegen.states.HostedUISignInState$Resolver
            com.amplifyframework.auth.cognito.actions.HostedUICognitoActions r2 = com.amplifyframework.auth.cognito.actions.HostedUICognitoActions.INSTANCE
            r7.<init>(r2)
            com.amplifyframework.statemachine.codegen.states.DeviceSRPSignInState$Resolver r8 = new com.amplifyframework.statemachine.codegen.states.DeviceSRPSignInState$Resolver
            com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions r2 = com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions.INSTANCE
            r8.<init>(r2)
            com.amplifyframework.auth.cognito.actions.SignInCognitoActions r9 = com.amplifyframework.auth.cognito.actions.SignInCognitoActions.INSTANCE
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            com.amplifyframework.statemachine.codegen.states.SignOutState$Resolver r2 = new com.amplifyframework.statemachine.codegen.states.SignOutState$Resolver
            com.amplifyframework.auth.cognito.actions.SignOutCognitoActions r3 = com.amplifyframework.auth.cognito.actions.SignOutCognitoActions.INSTANCE
            r2.<init>(r3)
            com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions r3 = com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions.INSTANCE
            r1.<init>(r10, r2, r3)
            com.amplifyframework.statemachine.codegen.states.AuthorizationState$Resolver r2 = new com.amplifyframework.statemachine.codegen.states.AuthorizationState$Resolver
            com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState$Resolver r3 = new com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState$Resolver
            com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions r4 = com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions.INSTANCE
            r3.<init>(r4)
            com.amplifyframework.statemachine.codegen.states.RefreshSessionState$Resolver r5 = new com.amplifyframework.statemachine.codegen.states.RefreshSessionState$Resolver
            com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState$Resolver r6 = new com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState$Resolver
            r6.<init>(r4)
            r5.<init>(r6, r4)
            com.amplifyframework.statemachine.codegen.states.DeleteUserState$Resolver r4 = new com.amplifyframework.statemachine.codegen.states.DeleteUserState$Resolver
            com.amplifyframework.auth.cognito.actions.DeleteUserCognitoActions r6 = com.amplifyframework.auth.cognito.actions.DeleteUserCognitoActions.INSTANCE
            r4.<init>(r6)
            com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions r6 = com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions.INSTANCE
            r2.<init>(r3, r5, r4, r6)
            com.amplifyframework.auth.cognito.actions.AuthCognitoActions r3 = com.amplifyframework.auth.cognito.actions.AuthCognitoActions.INSTANCE
            r0.<init>(r1, r2, r3)
            r11.<init>(r0, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.AuthStateMachine.<init>(com.amplifyframework.statemachine.Environment, com.amplifyframework.statemachine.codegen.states.AuthState):void");
    }
}
