package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironmentKt;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.SignOutActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignOutState.kt */
/* loaded from: classes.dex */
public abstract class SignOutState implements State {

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class BuildingRevokeTokenError extends SignOutState {
        private final String id;

        public BuildingRevokeTokenError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BuildingRevokeTokenError copy$default(BuildingRevokeTokenError buildingRevokeTokenError, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = buildingRevokeTokenError.id;
            }
            return buildingRevokeTokenError.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final BuildingRevokeTokenError copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new BuildingRevokeTokenError(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof BuildingRevokeTokenError) && Intrinsics.areEqual(this.id, ((BuildingRevokeTokenError) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("BuildingRevokeTokenError(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BuildingRevokeTokenError(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ BuildingRevokeTokenError(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends SignOutState {
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

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends SignOutState {
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

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<SignOutState> {
        private final NotStarted defaultState;
        private final SignOutActions signOutActions;

        public Resolver(SignOutActions signOutActions) {
            Intrinsics.checkNotNullParameter(signOutActions, "signOutActions");
            this.signOutActions = signOutActions;
            this.defaultState = new NotStarted("");
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<SignOutState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<SignOutState, StateMachineResolver<SignOutState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public SignOutState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<SignOutState> resolve(SignOutState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
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
            StateResolution<SignOutState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            SignOutEvent.EventType isSignOutEvent = AuthEnvironmentKt.isSignOutEvent(event);
            boolean z = true;
            boolean z2 = true;
            boolean z3 = true;
            boolean z4 = true;
            boolean z5 = true;
            boolean z6 = true;
            if (oldState instanceof NotStarted) {
                if (isSignOutEvent instanceof SignOutEvent.EventType.InvokeHostedUISignOut) {
                    SignOutEvent.EventType.InvokeHostedUISignOut invokeHostedUISignOut = (SignOutEvent.EventType.InvokeHostedUISignOut) isSignOutEvent;
                    return new StateResolution<>(new SigningOutHostedUI(invokeHostedUISignOut.getSignedInData(), invokeHostedUISignOut.getSignOutData().getGlobalSignOut(), invokeHostedUISignOut.getSignOutData().getBypassCancel()), CollectionsKt__CollectionsKt.listOf(this.signOutActions.hostedUISignOutAction(invokeHostedUISignOut)));
                }
                if (isSignOutEvent instanceof SignOutEvent.EventType.SignOutGlobally) {
                    return new StateResolution<>(new SigningOutGlobally(str, z6 ? 1 : 0, b11 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.globalSignOutAction((SignOutEvent.EventType.SignOutGlobally) isSignOutEvent)));
                }
                if (isSignOutEvent instanceof SignOutEvent.EventType.RevokeToken) {
                    return new StateResolution<>(new RevokingToken(b10 == true ? 1 : 0, z5 ? 1 : 0, b9 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.revokeTokenAction((SignOutEvent.EventType.RevokeToken) isSignOutEvent)));
                }
                if (!(isSignOutEvent instanceof SignOutEvent.EventType.SignOutLocally)) {
                    return stateResolution;
                }
                SignOutEvent.EventType.SignOutLocally signOutLocally = (SignOutEvent.EventType.SignOutLocally) isSignOutEvent;
                return new StateResolution<>(new SigningOutLocally(signOutLocally.getSignedInData()), CollectionsKt__CollectionsKt.listOf(this.signOutActions.localSignOutAction(signOutLocally)));
            }
            if (oldState instanceof SigningOutHostedUI) {
                if (isSignOutEvent instanceof SignOutEvent.EventType.SignOutGlobally) {
                    return new StateResolution<>(new SigningOutGlobally(b8 == true ? 1 : 0, z4 ? 1 : 0, b7 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.globalSignOutAction((SignOutEvent.EventType.SignOutGlobally) isSignOutEvent)));
                }
                if (isSignOutEvent instanceof SignOutEvent.EventType.RevokeToken) {
                    return new StateResolution<>(new RevokingToken(b6 == true ? 1 : 0, z3 ? 1 : 0, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.revokeTokenAction((SignOutEvent.EventType.RevokeToken) isSignOutEvent)));
                }
                if (isSignOutEvent instanceof SignOutEvent.EventType.UserCancelled) {
                    return new StateResolution<>(new Error(new Exception("User Cancelled")), CollectionsKt__CollectionsKt.listOf(this.signOutActions.userCancelledAction((SignOutEvent.EventType.UserCancelled) isSignOutEvent)));
                }
                return stateResolution;
            }
            if (oldState instanceof SigningOutLocally) {
                AuthEvent.EventType isAuthEvent = AuthEnvironmentKt.isAuthEvent(event);
                if (!(isAuthEvent instanceof AuthEvent.EventType.ReceivedCachedCredentials)) {
                    return isAuthEvent instanceof AuthEvent.EventType.CachedCredentialsFailed ? new StateResolution<>(new Error(new Exception("Failed clearing store")), null, 2, null) : stateResolution;
                }
                SignedInData signedInData = ((SigningOutLocally) oldState).getSignedInData();
                return new StateResolution<>(new SignedOut(new SignedOutData(signedInData != null ? signedInData.getUsername() : null, null, null, null, 14, null)), null, 2, null);
            }
            if (oldState instanceof SigningOutGlobally) {
                if (isSignOutEvent instanceof SignOutEvent.EventType.RevokeToken) {
                    return new StateResolution<>(new RevokingToken(b4 == true ? 1 : 0, z2 ? 1 : 0, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.revokeTokenAction((SignOutEvent.EventType.RevokeToken) isSignOutEvent)));
                }
                if (!(isSignOutEvent instanceof SignOutEvent.EventType.SignOutGloballyError)) {
                    return stateResolution;
                }
                return new StateResolution<>(new BuildingRevokeTokenError(b2 == true ? 1 : 0, z ? 1 : 0, b == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signOutActions.buildRevokeTokenErrorAction((SignOutEvent.EventType.SignOutGloballyError) isSignOutEvent)));
            }
            if (!(oldState instanceof RevokingToken ? true : oldState instanceof BuildingRevokeTokenError) || !(isSignOutEvent instanceof SignOutEvent.EventType.SignOutLocally)) {
                return stateResolution;
            }
            SignOutEvent.EventType.SignOutLocally signOutLocally2 = (SignOutEvent.EventType.SignOutLocally) isSignOutEvent;
            return new StateResolution<>(new SigningOutLocally(signOutLocally2.getSignedInData()), CollectionsKt__CollectionsKt.listOf(this.signOutActions.localSignOutAction(signOutLocally2)));
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class RevokingToken extends SignOutState {
        private final String id;

        public RevokingToken() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RevokingToken copy$default(RevokingToken revokingToken, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = revokingToken.id;
            }
            return revokingToken.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final RevokingToken copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new RevokingToken(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RevokingToken) && Intrinsics.areEqual(this.id, ((RevokingToken) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RevokingToken(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RevokingToken(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ RevokingToken(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class SignedOut extends SignOutState {
        private final SignedOutData signedOutData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedOut(SignedOutData signedOutData) {
            super(null);
            Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
            this.signedOutData = signedOutData;
        }

        public static /* synthetic */ SignedOut copy$default(SignedOut signedOut, SignedOutData signedOutData, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signedOutData = signedOut.signedOutData;
            }
            return signedOut.copy(signedOutData);
        }

        public final SignedOutData component1() {
            return this.signedOutData;
        }

        public final SignedOut copy(SignedOutData signedOutData) {
            Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
            return new SignedOut(signedOutData);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SignedOut) && Intrinsics.areEqual(this.signedOutData, ((SignedOut) obj).signedOutData)) {
                return true;
            }
            return false;
        }

        public final SignedOutData getSignedOutData() {
            return this.signedOutData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.signedOutData.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SignedOut(signedOutData=" + this.signedOutData + ')';
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class SigningOutGlobally extends SignOutState {
        private final String id;

        public SigningOutGlobally() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SigningOutGlobally copy$default(SigningOutGlobally signingOutGlobally, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = signingOutGlobally.id;
            }
            return signingOutGlobally.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final SigningOutGlobally copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SigningOutGlobally(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningOutGlobally) && Intrinsics.areEqual(this.id, ((SigningOutGlobally) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SigningOutGlobally(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningOutGlobally(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ SigningOutGlobally(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class SigningOutHostedUI extends SignOutState {
        private final boolean bypassCancel;
        private final boolean globalSignOut;
        private final SignedInData signedInData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningOutHostedUI(SignedInData signedInData, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            this.signedInData = signedInData;
            this.globalSignOut = z;
            this.bypassCancel = z2;
        }

        public static /* synthetic */ SigningOutHostedUI copy$default(SigningOutHostedUI signingOutHostedUI, SignedInData signedInData, boolean z, boolean z2, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                signedInData = signingOutHostedUI.signedInData;
            }
            if ((r4 & 2) != 0) {
                z = signingOutHostedUI.globalSignOut;
            }
            if ((r4 & 4) != 0) {
                z2 = signingOutHostedUI.bypassCancel;
            }
            return signingOutHostedUI.copy(signedInData, z, z2);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final boolean component2() {
            return this.globalSignOut;
        }

        public final boolean component3() {
            return this.bypassCancel;
        }

        public final SigningOutHostedUI copy(SignedInData signedInData, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            return new SigningOutHostedUI(signedInData, z, z2);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SigningOutHostedUI)) {
                return false;
            }
            SigningOutHostedUI signingOutHostedUI = (SigningOutHostedUI) obj;
            if (Intrinsics.areEqual(this.signedInData, signingOutHostedUI.signedInData) && this.globalSignOut == signingOutHostedUI.globalSignOut && this.bypassCancel == signingOutHostedUI.bypassCancel) {
                return true;
            }
            return false;
        }

        public final boolean getBypassCancel() {
            return this.bypassCancel;
        }

        public final boolean getGlobalSignOut() {
            return this.globalSignOut;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            int hashCode = this.signedInData.hashCode() * 31;
            boolean z = this.globalSignOut;
            int r2 = 1;
            int r1 = z;
            if (z != 0) {
                r1 = 1;
            }
            int r0 = (hashCode + r1) * 31;
            boolean z2 = this.bypassCancel;
            if (!z2) {
                r2 = z2 ? 1 : 0;
            }
            return r0 + r2;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            StringBuilder sb = new StringBuilder("SigningOutHostedUI(signedInData=");
            sb.append(this.signedInData);
            sb.append(", globalSignOut=");
            sb.append(this.globalSignOut);
            sb.append(", bypassCancel=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.bypassCancel, ')');
        }
    }

    /* compiled from: SignOutState.kt */
    /* loaded from: classes.dex */
    public static final class SigningOutLocally extends SignOutState {
        private final SignedInData signedInData;

        public SigningOutLocally(SignedInData signedInData) {
            super(null);
            this.signedInData = signedInData;
        }

        public static /* synthetic */ SigningOutLocally copy$default(SigningOutLocally signingOutLocally, SignedInData signedInData, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signedInData = signingOutLocally.signedInData;
            }
            return signingOutLocally.copy(signedInData);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final SigningOutLocally copy(SignedInData signedInData) {
            return new SigningOutLocally(signedInData);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningOutLocally) && Intrinsics.areEqual(this.signedInData, ((SigningOutLocally) obj).signedInData)) {
                return true;
            }
            return false;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            SignedInData signedInData = this.signedInData;
            if (signedInData == null) {
                return 0;
            }
            return signedInData.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningOutLocally(signedInData=" + this.signedInData + ')';
        }
    }

    public /* synthetic */ SignOutState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private SignOutState() {
    }
}
