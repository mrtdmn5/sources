package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.SRPActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SRPSignInState.kt */
/* loaded from: classes.dex */
public abstract class SRPSignInState implements State {

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Cancelling extends SRPSignInState {
        private final String id;

        public Cancelling() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Cancelling copy$default(Cancelling cancelling, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = cancelling.id;
            }
            return cancelling.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Cancelling copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Cancelling(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Cancelling) && Intrinsics.areEqual(this.id, ((Cancelling) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Cancelling(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancelling(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Cancelling(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends SRPSignInState {
        private final Exception exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                exc = error.exception;
            }
            return error.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final Error copy(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Error(exception);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Error) && Intrinsics.areEqual(this.exception, ((Error) obj).exception)) {
                return true;
            }
            return false;
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("Error(exception="), this.exception, ')');
        }
    }

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class InitiatingSRPA extends SRPSignInState {
        private final String id;

        public InitiatingSRPA() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InitiatingSRPA copy$default(InitiatingSRPA initiatingSRPA, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = initiatingSRPA.id;
            }
            return initiatingSRPA.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final InitiatingSRPA copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new InitiatingSRPA(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof InitiatingSRPA) && Intrinsics.areEqual(this.id, ((InitiatingSRPA) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("InitiatingSRPA(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitiatingSRPA(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ InitiatingSRPA(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends SRPSignInState {
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

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<SRPSignInState> {
        private final NotStarted defaultState;
        private final SRPActions srpActions;

        public Resolver(SRPActions srpActions) {
            Intrinsics.checkNotNullParameter(srpActions, "srpActions");
            this.srpActions = srpActions;
            this.defaultState = new NotStarted("");
        }

        private final SRPEvent.EventType asSRPEvent(StateMachineEvent stateMachineEvent) {
            SRPEvent sRPEvent;
            if (stateMachineEvent instanceof SRPEvent) {
                sRPEvent = (SRPEvent) stateMachineEvent;
            } else {
                sRPEvent = null;
            }
            if (sRPEvent == null) {
                return null;
            }
            return sRPEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<SRPSignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<SRPSignInState, StateMachineResolver<SRPSignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public SRPSignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<SRPSignInState> resolve(SRPSignInState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            SRPEvent.EventType asSRPEvent = asSRPEvent(event);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            byte b7 = 0;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            byte b11 = 0;
            StateResolution<SRPSignInState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            int r4 = 1;
            if (oldState instanceof NotStarted) {
                if (asSRPEvent instanceof SRPEvent.EventType.InitiateSRP) {
                    return new StateResolution<>(new InitiatingSRPA(str, r4, b11 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.srpActions.initiateSRPAuthAction((SRPEvent.EventType.InitiateSRP) asSRPEvent)));
                }
                if (asSRPEvent instanceof SRPEvent.EventType.InitiateSRPWithCustom) {
                    return new StateResolution<>(new InitiatingSRPA(b10 == true ? 1 : 0, r4, b9 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.srpActions.initiateSRPWithCustomAuthAction((SRPEvent.EventType.InitiateSRPWithCustom) asSRPEvent)));
                }
                return stateResolution;
            }
            if (!(oldState instanceof InitiatingSRPA)) {
                return oldState instanceof RespondingPasswordVerifier ? asSRPEvent instanceof SRPEvent.EventType.ThrowPasswordVerifierError ? new StateResolution<>(new Error(((SRPEvent.EventType.ThrowPasswordVerifierError) asSRPEvent).getException()), null, 2, null) : asSRPEvent instanceof SRPEvent.EventType.CancelSRPSignIn ? new StateResolution<>(new Cancelling(b4 == true ? 1 : 0, r4, b3 == true ? 1 : 0), null, 2, null) : stateResolution : ((oldState instanceof Cancelling) && (asSRPEvent instanceof SRPEvent.EventType.Reset)) ? new StateResolution<>(new NotStarted(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), null, 2, null) : stateResolution;
            }
            if (asSRPEvent instanceof SRPEvent.EventType.RespondPasswordVerifier) {
                return new StateResolution<>(new RespondingPasswordVerifier(b8 == true ? 1 : 0, r4, b7 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.srpActions.verifyPasswordSRPAction((SRPEvent.EventType.RespondPasswordVerifier) asSRPEvent)));
            }
            return asSRPEvent instanceof SRPEvent.EventType.ThrowAuthError ? new StateResolution<>(new Error(((SRPEvent.EventType.ThrowAuthError) asSRPEvent).getException()), null, 2, null) : asSRPEvent instanceof SRPEvent.EventType.CancelSRPSignIn ? new StateResolution<>(new Cancelling(b6 == true ? 1 : 0, r4, b5 == true ? 1 : 0), null, 2, null) : stateResolution;
        }
    }

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class RespondingPasswordVerifier extends SRPSignInState {
        private final String id;

        public RespondingPasswordVerifier() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RespondingPasswordVerifier copy$default(RespondingPasswordVerifier respondingPasswordVerifier, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = respondingPasswordVerifier.id;
            }
            return respondingPasswordVerifier.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final RespondingPasswordVerifier copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new RespondingPasswordVerifier(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RespondingPasswordVerifier) && Intrinsics.areEqual(this.id, ((RespondingPasswordVerifier) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RespondingPasswordVerifier(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RespondingPasswordVerifier(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ RespondingPasswordVerifier(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends SRPSignInState {
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

    public /* synthetic */ SRPSignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private SRPSignInState() {
    }
}
