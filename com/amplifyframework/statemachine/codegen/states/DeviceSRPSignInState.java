package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.DeviceSRPSignInActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.DeviceSRPSignInEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceSRPSignInState.kt */
/* loaded from: classes.dex */
public abstract class DeviceSRPSignInState implements State {

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends DeviceSRPSignInState {
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

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class InitiatingDeviceSRP extends DeviceSRPSignInState {
        private final String id;

        public InitiatingDeviceSRP() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InitiatingDeviceSRP copy$default(InitiatingDeviceSRP initiatingDeviceSRP, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = initiatingDeviceSRP.id;
            }
            return initiatingDeviceSRP.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final InitiatingDeviceSRP copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new InitiatingDeviceSRP(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof InitiatingDeviceSRP) && Intrinsics.areEqual(this.id, ((InitiatingDeviceSRP) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("InitiatingDeviceSRP(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitiatingDeviceSRP(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ InitiatingDeviceSRP(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends DeviceSRPSignInState {
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

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<DeviceSRPSignInState> {
        private final NotStarted defaultState;
        private final DeviceSRPSignInActions deviceSRPSignInActions;

        public Resolver(DeviceSRPSignInActions deviceSRPSignInActions) {
            Intrinsics.checkNotNullParameter(deviceSRPSignInActions, "deviceSRPSignInActions");
            this.deviceSRPSignInActions = deviceSRPSignInActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final DeviceSRPSignInEvent.EventType asDeviceSRPSignInEvent(StateMachineEvent stateMachineEvent) {
            DeviceSRPSignInEvent deviceSRPSignInEvent;
            if (stateMachineEvent instanceof DeviceSRPSignInEvent) {
                deviceSRPSignInEvent = (DeviceSRPSignInEvent) stateMachineEvent;
            } else {
                deviceSRPSignInEvent = null;
            }
            if (deviceSRPSignInEvent == null) {
                return null;
            }
            return deviceSRPSignInEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<DeviceSRPSignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<DeviceSRPSignInState, StateMachineResolver<DeviceSRPSignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public DeviceSRPSignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<DeviceSRPSignInState> resolve(DeviceSRPSignInState oldState, StateMachineEvent event) {
            StateResolution<DeviceSRPSignInState> stateResolution;
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            DeviceSRPSignInEvent.EventType asDeviceSRPSignInEvent = asDeviceSRPSignInEvent(event);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            if (asDeviceSRPSignInEvent == null) {
                return new StateResolution<>(oldState, null, 2, null);
            }
            int r3 = 1;
            if (oldState instanceof NotStarted) {
                if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge) {
                    return new StateResolution<>(new InitiatingDeviceSRP(str, r3, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.deviceSRPSignInActions.respondDeviceSRP((DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge) asDeviceSRPSignInEvent)));
                }
                if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.ThrowAuthError) {
                    stateResolution = new StateResolution<>(new Error(((DeviceSRPSignInEvent.EventType.ThrowAuthError) asDeviceSRPSignInEvent).getException()), null, 2, null);
                } else {
                    return new StateResolution<>(oldState, null, 2, null);
                }
            } else if (oldState instanceof InitiatingDeviceSRP) {
                if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.RespondDevicePasswordVerifier) {
                    return new StateResolution<>(new RespondingDevicePasswordVerifier(b4 == true ? 1 : 0, r3, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.deviceSRPSignInActions.respondDevicePasswordVerifier((DeviceSRPSignInEvent.EventType.RespondDevicePasswordVerifier) asDeviceSRPSignInEvent)));
                }
                if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.ThrowPasswordVerifiedError) {
                    stateResolution = new StateResolution<>(new Error(((DeviceSRPSignInEvent.EventType.ThrowPasswordVerifiedError) asDeviceSRPSignInEvent).getException()), null, 2, null);
                } else if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.ThrowAuthError) {
                    stateResolution = new StateResolution<>(new Error(((DeviceSRPSignInEvent.EventType.ThrowAuthError) asDeviceSRPSignInEvent).getException()), null, 2, null);
                } else {
                    return new StateResolution<>(oldState, null, 2, null);
                }
            } else {
                if (oldState instanceof RespondingDevicePasswordVerifier) {
                    if (asDeviceSRPSignInEvent instanceof DeviceSRPSignInEvent.EventType.FinalizeSignIn) {
                        return new StateResolution<>(new SignedIn(b2 == true ? 1 : 0, r3, b == true ? 1 : 0), null, 2, null);
                    }
                    return new StateResolution<>(oldState, null, 2, null);
                }
                return new StateResolution<>(oldState, null, 2, null);
            }
            return stateResolution;
        }
    }

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class RespondingDevicePasswordVerifier extends DeviceSRPSignInState {
        private final String id;

        public RespondingDevicePasswordVerifier() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RespondingDevicePasswordVerifier copy$default(RespondingDevicePasswordVerifier respondingDevicePasswordVerifier, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = respondingDevicePasswordVerifier.id;
            }
            return respondingDevicePasswordVerifier.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final RespondingDevicePasswordVerifier copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new RespondingDevicePasswordVerifier(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RespondingDevicePasswordVerifier) && Intrinsics.areEqual(this.id, ((RespondingDevicePasswordVerifier) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RespondingDevicePasswordVerifier(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RespondingDevicePasswordVerifier(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ RespondingDevicePasswordVerifier(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: DeviceSRPSignInState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends DeviceSRPSignInState {
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

    public /* synthetic */ DeviceSRPSignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private DeviceSRPSignInState() {
    }
}
