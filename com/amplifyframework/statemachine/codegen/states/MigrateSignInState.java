package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.MigrateAuthActions;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MigrateSignInState.kt */
/* loaded from: classes.dex */
public abstract class MigrateSignInState implements State {

    /* compiled from: MigrateSignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends MigrateSignInState {
        private final String id;

        public NotStarted() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NotStarted copy$default(NotStarted notStarted, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = notStarted.id;
            }
            return notStarted.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final NotStarted copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new NotStarted(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof NotStarted) && Intrinsics.areEqual(this.id, ((NotStarted) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("NotStarted(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotStarted(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ NotStarted(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: MigrateSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<MigrateSignInState> {
        private final NotStarted defaultState;
        private final MigrateAuthActions migrateAuthActions;

        public Resolver(MigrateAuthActions migrateAuthActions) {
            Intrinsics.checkNotNullParameter(migrateAuthActions, "migrateAuthActions");
            this.migrateAuthActions = migrateAuthActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final SignInEvent.EventType asSignInEvent(StateMachineEvent stateMachineEvent) {
            SignInEvent signInEvent;
            if (stateMachineEvent instanceof SignInEvent) {
                signInEvent = (SignInEvent) stateMachineEvent;
            } else {
                signInEvent = null;
            }
            if (signInEvent == null) {
                return null;
            }
            return signInEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<MigrateSignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<MigrateSignInState, StateMachineResolver<MigrateSignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public MigrateSignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<MigrateSignInState> resolve(MigrateSignInState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            StateResolution<MigrateSignInState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            SignInEvent.EventType asSignInEvent = asSignInEvent(event);
            int r4 = 1;
            if (!(oldState instanceof NotStarted)) {
                return ((oldState instanceof SigningIn) && (asSignInEvent instanceof SignInEvent.EventType.FinalizeSignIn)) ? new StateResolution<>(new SignedIn(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), null, 2, null) : stateResolution;
            }
            if (asSignInEvent instanceof SignInEvent.EventType.InitiateMigrateAuth) {
                return new StateResolution<>(new SigningIn(str, r4, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.migrateAuthActions.initiateMigrateAuthAction((SignInEvent.EventType.InitiateMigrateAuth) asSignInEvent)));
            }
            return stateResolution;
        }
    }

    /* compiled from: MigrateSignInState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends MigrateSignInState {
        private final String id;

        public SignedIn() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SignedIn copy$default(SignedIn signedIn, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = signedIn.id;
            }
            return signedIn.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final SignedIn copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SignedIn(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SignedIn) && Intrinsics.areEqual(this.id, ((SignedIn) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SignedIn(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedIn(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ SignedIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: MigrateSignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningIn extends MigrateSignInState {
        private final String id;

        public SigningIn() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SigningIn copy$default(SigningIn signingIn, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = signingIn.id;
            }
            return signingIn.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final SigningIn copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SigningIn(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningIn) && Intrinsics.areEqual(this.id, ((SigningIn) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SigningIn(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningIn(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ SigningIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    public /* synthetic */ MigrateSignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private MigrateSignInState() {
    }
}
