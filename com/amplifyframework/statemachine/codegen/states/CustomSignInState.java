package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.CustomSignInActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.CustomSignInEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomSignInState.kt */
/* loaded from: classes.dex */
public abstract class CustomSignInState implements State {
    private final String type;

    /* compiled from: CustomSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends CustomSignInState {
        private final Exception error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                exc = error.error;
            }
            return error.copy(exc);
        }

        public final Exception component1() {
            return this.error;
        }

        public final Error copy(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error)) {
                return true;
            }
            return false;
        }

        public final Exception getError() {
            return this.error;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.error.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("Error(error="), this.error, ')');
        }
    }

    /* compiled from: CustomSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Initiating extends CustomSignInState {
        private final String id;

        public Initiating() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Initiating copy$default(Initiating initiating, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = initiating.id;
            }
            return initiating.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Initiating copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Initiating(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Initiating) && Intrinsics.areEqual(this.id, ((Initiating) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Initiating(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Initiating(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Initiating(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CustomSignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends CustomSignInState {
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

    /* compiled from: CustomSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<CustomSignInState> {
        private final NotStarted defaultState;
        private final CustomSignInActions signInCustomActions;

        public Resolver(CustomSignInActions signInCustomActions) {
            Intrinsics.checkNotNullParameter(signInCustomActions, "signInCustomActions");
            this.signInCustomActions = signInCustomActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final CustomSignInEvent.EventType asCustomSignInEvent(StateMachineEvent stateMachineEvent) {
            CustomSignInEvent customSignInEvent;
            if (stateMachineEvent instanceof CustomSignInEvent) {
                customSignInEvent = (CustomSignInEvent) stateMachineEvent;
            } else {
                customSignInEvent = null;
            }
            if (customSignInEvent == null) {
                return null;
            }
            return customSignInEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<CustomSignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<CustomSignInState, StateMachineResolver<CustomSignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public CustomSignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<CustomSignInState> resolve(CustomSignInState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            StateResolution<CustomSignInState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            CustomSignInEvent.EventType asCustomSignInEvent = asCustomSignInEvent(event);
            int r4 = 1;
            if (!(oldState instanceof NotStarted)) {
                return oldState instanceof Initiating ? asCustomSignInEvent instanceof CustomSignInEvent.EventType.FinalizeSignIn ? new StateResolution<>(new SignedIn(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), null, 2, null) : asCustomSignInEvent instanceof CustomSignInEvent.EventType.ThrowAuthError ? new StateResolution<>(new Error(((CustomSignInEvent.EventType.ThrowAuthError) asCustomSignInEvent).getException()), null, 2, null) : stateResolution : stateResolution;
            }
            if (asCustomSignInEvent instanceof CustomSignInEvent.EventType.InitiateCustomSignIn) {
                return new StateResolution<>(new Initiating(str, r4, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signInCustomActions.initiateCustomSignInAuthAction((CustomSignInEvent.EventType.InitiateCustomSignIn) asCustomSignInEvent)));
            }
            return asCustomSignInEvent instanceof CustomSignInEvent.EventType.ThrowAuthError ? new StateResolution<>(new Error(((CustomSignInEvent.EventType.ThrowAuthError) asCustomSignInEvent).getException()), null, 2, null) : stateResolution;
        }
    }

    /* compiled from: CustomSignInState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends CustomSignInState {
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

    public /* synthetic */ CustomSignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return this.type;
    }

    private CustomSignInState() {
        this.type = toString();
    }
}
