package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.SignInChallengeActions;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInChallengeState.kt */
/* loaded from: classes.dex */
public abstract class SignInChallengeState implements State {

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends SignInChallengeState {
        private final AuthChallenge challenge;
        private final Exception exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception exception, AuthChallenge challenge) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            this.exception = exception;
            this.challenge = challenge;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, AuthChallenge authChallenge, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                exc = error.exception;
            }
            if ((r3 & 2) != 0) {
                authChallenge = error.challenge;
            }
            return error.copy(exc, authChallenge);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final AuthChallenge component2() {
            return this.challenge;
        }

        public final Error copy(Exception exception, AuthChallenge challenge) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            return new Error(exception, challenge);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            if (Intrinsics.areEqual(this.exception, error.exception) && Intrinsics.areEqual(this.challenge, error.challenge)) {
                return true;
            }
            return false;
        }

        public final AuthChallenge getChallenge() {
            return this.challenge;
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.challenge.hashCode() + (this.exception.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "Error(exception=" + this.exception + ", challenge=" + this.challenge + ')';
        }
    }

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends SignInChallengeState {
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

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<SignInChallengeState> {
        private final SignInChallengeActions challengeActions;
        private final SignInChallengeState defaultState;

        public Resolver(SignInChallengeActions challengeActions) {
            Intrinsics.checkNotNullParameter(challengeActions, "challengeActions");
            this.challengeActions = challengeActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final SignInChallengeEvent.EventType asSignInChallengeEvent(StateMachineEvent stateMachineEvent) {
            SignInChallengeEvent signInChallengeEvent;
            if (stateMachineEvent instanceof SignInChallengeEvent) {
                signInChallengeEvent = (SignInChallengeEvent) stateMachineEvent;
            } else {
                signInChallengeEvent = null;
            }
            if (signInChallengeEvent == null) {
                return null;
            }
            return signInChallengeEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<SignInChallengeState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<SignInChallengeState, StateMachineResolver<SignInChallengeState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public SignInChallengeState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<SignInChallengeState> resolve(SignInChallengeState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            String str = null;
            byte b = 0;
            StateResolution<SignInChallengeState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            SignInChallengeEvent.EventType asSignInChallengeEvent = asSignInChallengeEvent(event);
            if (oldState instanceof NotStarted) {
                return asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.WaitForAnswer ? new StateResolution<>(new WaitingForAnswer(((SignInChallengeEvent.EventType.WaitForAnswer) asSignInChallengeEvent).getChallenge()), null, 2, null) : stateResolution;
            }
            if (oldState instanceof WaitingForAnswer) {
                if (!(asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.VerifyChallengeAnswer)) {
                    return stateResolution;
                }
                WaitingForAnswer waitingForAnswer = (WaitingForAnswer) oldState;
                return new StateResolution<>(new Verifying(waitingForAnswer.getChallenge().getChallengeName()), CollectionsKt__CollectionsKt.listOf(this.challengeActions.verifyChallengeAuthAction((SignInChallengeEvent.EventType.VerifyChallengeAnswer) asSignInChallengeEvent, waitingForAnswer.getChallenge())));
            }
            if (oldState instanceof Verifying) {
                if (asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.Verified) {
                    return new StateResolution<>(new Verified(str, 1, b == true ? 1 : 0), null, 2, null);
                }
                if (!(asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.ThrowError)) {
                    return stateResolution;
                }
                SignInChallengeEvent.EventType.ThrowError throwError = (SignInChallengeEvent.EventType.ThrowError) asSignInChallengeEvent;
                return new StateResolution<>(new Error(throwError.getException(), throwError.getChallenge()), CollectionsKt__CollectionsKt.listOf(this.challengeActions.resetToWaitingForAnswer(throwError, throwError.getChallenge())));
            }
            if (!(oldState instanceof Error)) {
                return stateResolution;
            }
            if (!(asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.VerifyChallengeAnswer)) {
                return asSignInChallengeEvent instanceof SignInChallengeEvent.EventType.WaitForAnswer ? new StateResolution<>(new WaitingForAnswer(((SignInChallengeEvent.EventType.WaitForAnswer) asSignInChallengeEvent).getChallenge()), null, 2, null) : stateResolution;
            }
            Error error = (Error) oldState;
            return new StateResolution<>(new Verifying(error.getChallenge().getChallengeName()), CollectionsKt__CollectionsKt.listOf(this.challengeActions.verifyChallengeAuthAction((SignInChallengeEvent.EventType.VerifyChallengeAnswer) asSignInChallengeEvent, error.getChallenge())));
        }
    }

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class Verified extends SignInChallengeState {
        private final String id;

        public Verified() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Verified copy$default(Verified verified, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = verified.id;
            }
            return verified.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Verified copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Verified(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Verified) && Intrinsics.areEqual(this.id, ((Verified) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Verified(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Verified(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Verified(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class Verifying extends SignInChallengeState {
        private final String id;

        public Verifying() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Verifying copy$default(Verifying verifying, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = verifying.id;
            }
            return verifying.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Verifying copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Verifying(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Verifying) && Intrinsics.areEqual(this.id, ((Verifying) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Verifying(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Verifying(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Verifying(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInChallengeState.kt */
    /* loaded from: classes.dex */
    public static final class WaitingForAnswer extends SignInChallengeState {
        private final AuthChallenge challenge;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForAnswer(AuthChallenge challenge) {
            super(null);
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            this.challenge = challenge;
        }

        public static /* synthetic */ WaitingForAnswer copy$default(WaitingForAnswer waitingForAnswer, AuthChallenge authChallenge, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                authChallenge = waitingForAnswer.challenge;
            }
            return waitingForAnswer.copy(authChallenge);
        }

        public final AuthChallenge component1() {
            return this.challenge;
        }

        public final WaitingForAnswer copy(AuthChallenge challenge) {
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            return new WaitingForAnswer(challenge);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof WaitingForAnswer) && Intrinsics.areEqual(this.challenge, ((WaitingForAnswer) obj).challenge)) {
                return true;
            }
            return false;
        }

        public final AuthChallenge getChallenge() {
            return this.challenge;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.challenge.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "WaitingForAnswer(challenge=" + this.challenge + ')';
        }
    }

    public /* synthetic */ SignInChallengeState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private SignInChallengeState() {
    }
}
