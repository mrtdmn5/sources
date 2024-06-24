package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.StateMachine;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.codegen.states.CredentialStoreState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreStateMachine.kt */
/* loaded from: classes.dex */
public final class CredentialStoreStateMachine extends StateMachine<CredentialStoreState, Environment> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: CredentialStoreStateMachine.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CredentialStoreStateMachine logging(Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            return new CredentialStoreStateMachine(StateMachineResolver.DefaultImpls.logging$default(new CredentialStoreState.Resolver(CredentialStoreCognitoActions.INSTANCE), null, null, 3, null), environment);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialStoreStateMachine(StateMachineResolver<CredentialStoreState> resolver, Environment environment) {
        super(resolver, environment, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(environment, "environment");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public CredentialStoreStateMachine(Environment environment) {
        this(new CredentialStoreState.Resolver(CredentialStoreCognitoActions.INSTANCE), environment);
        Intrinsics.checkNotNullParameter(environment, "environment");
    }
}
