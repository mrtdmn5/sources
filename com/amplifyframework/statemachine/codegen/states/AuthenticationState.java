package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironmentKt;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.AuthenticationActions;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignOutData;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import com.amplifyframework.statemachine.codegen.states.SignInState;
import com.amplifyframework.statemachine.codegen.states.SignOutState;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationState.kt */
/* loaded from: classes.dex */
public abstract class AuthenticationState implements State {

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class Configured extends AuthenticationState {
        private final String id;

        public Configured() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Configured copy$default(Configured configured, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = configured.id;
            }
            return configured.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Configured copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Configured(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Configured) && Intrinsics.areEqual(this.id, ((Configured) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Configured(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Configured(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Configured(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends AuthenticationState {
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

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class FederatedToIdentityPool extends AuthenticationState {
        private final String id;

        public FederatedToIdentityPool() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FederatedToIdentityPool copy$default(FederatedToIdentityPool federatedToIdentityPool, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = federatedToIdentityPool.id;
            }
            return federatedToIdentityPool.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final FederatedToIdentityPool copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new FederatedToIdentityPool(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FederatedToIdentityPool) && Intrinsics.areEqual(this.id, ((FederatedToIdentityPool) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FederatedToIdentityPool(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FederatedToIdentityPool(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ FederatedToIdentityPool(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class FederatingToIdentityPool extends AuthenticationState {
        private final String id;

        public FederatingToIdentityPool() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FederatingToIdentityPool copy$default(FederatingToIdentityPool federatingToIdentityPool, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = federatingToIdentityPool.id;
            }
            return federatingToIdentityPool.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final FederatingToIdentityPool copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new FederatingToIdentityPool(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FederatingToIdentityPool) && Intrinsics.areEqual(this.id, ((FederatingToIdentityPool) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FederatingToIdentityPool(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FederatingToIdentityPool(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ FederatingToIdentityPool(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class NotConfigured extends AuthenticationState {
        private final String id;

        public NotConfigured() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NotConfigured copy$default(NotConfigured notConfigured, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = notConfigured.id;
            }
            return notConfigured.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final NotConfigured copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new NotConfigured(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof NotConfigured) && Intrinsics.areEqual(this.id, ((NotConfigured) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("NotConfigured(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotConfigured(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ NotConfigured(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<AuthenticationState> {
        private final AuthenticationActions authenticationActions;
        private final NotConfigured defaultState;
        private final StateMachineResolver<SignInState> signInResolver;
        private final StateMachineResolver<SignOutState> signOutResolver;

        public Resolver(StateMachineResolver<SignInState> signInResolver, StateMachineResolver<SignOutState> signOutResolver, AuthenticationActions authenticationActions) {
            Intrinsics.checkNotNullParameter(signInResolver, "signInResolver");
            Intrinsics.checkNotNullParameter(signOutResolver, "signOutResolver");
            Intrinsics.checkNotNullParameter(authenticationActions, "authenticationActions");
            this.signInResolver = signInResolver;
            this.signOutResolver = signOutResolver;
            this.authenticationActions = authenticationActions;
            this.defaultState = new NotConfigured(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<AuthenticationState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<AuthenticationState, StateMachineResolver<AuthenticationState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AuthenticationState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<AuthenticationState> resolve(AuthenticationState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            AuthenticationEvent.EventType isAuthenticationEvent = AuthEnvironmentKt.isAuthenticationEvent(event);
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
            byte b12 = 0;
            byte b13 = 0;
            byte b14 = 0;
            byte b15 = 0;
            byte b16 = 0;
            byte b17 = 0;
            byte b18 = 0;
            byte b19 = 0;
            byte b20 = 0;
            byte b21 = 0;
            byte b22 = 0;
            byte b23 = 0;
            StateResolution<AuthenticationState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            int r5 = 1;
            if (oldState instanceof NotConfigured) {
                AuthorizationEvent.EventType isAuthorizationEvent = AuthEnvironmentKt.isAuthorizationEvent(event);
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.Configure) {
                    return new StateResolution<>(new Configured(str, r5, b23 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.configureAuthenticationAction((AuthenticationEvent.EventType.Configure) isAuthenticationEvent)));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool) {
                    return new StateResolution<>(new FederatingToIdentityPool(b22 == true ? 1 : 0, r5, b21 == true ? 1 : 0), null, 2, null);
                }
                return stateResolution;
            }
            if (oldState instanceof Configured) {
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.InitializedSignedIn) {
                    AuthenticationEvent.EventType.InitializedSignedIn initializedSignedIn = (AuthenticationEvent.EventType.InitializedSignedIn) isAuthenticationEvent;
                    return new StateResolution<>(new SignedIn(initializedSignedIn.getSignedInData(), initializedSignedIn.getDeviceMetadata()), null, 2, null);
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.InitializedFederated) {
                    return new StateResolution<>(new FederatedToIdentityPool(b20 == true ? 1 : 0, r5, b19 == true ? 1 : 0), null, 2, null);
                }
                return isAuthenticationEvent instanceof AuthenticationEvent.EventType.InitializedSignedOut ? new StateResolution<>(new SignedOut(((AuthenticationEvent.EventType.InitializedSignedOut) isAuthenticationEvent).getSignedOutData()), null, 2, null) : stateResolution;
            }
            if (oldState instanceof SigningIn) {
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInCompleted) {
                    AuthenticationEvent.EventType.SignInCompleted signInCompleted = (AuthenticationEvent.EventType.SignInCompleted) isAuthenticationEvent;
                    return new StateResolution<>(new SignedIn(signInCompleted.getSignedInData(), signInCompleted.getDeviceMetadata()), null, 2, null);
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.CancelSignIn) {
                    AuthenticationEvent.EventType.CancelSignIn cancelSignIn = (AuthenticationEvent.EventType.CancelSignIn) isAuthenticationEvent;
                    if (cancelSignIn.getError() != null) {
                        new StateResolution(new Error(cancelSignIn.getError()), null, 2, null);
                    }
                    return new StateResolution<>(new SignedOut(new SignedOutData(null, null, null, null, 15, null)), null, 2, null);
                }
                StateResolution<SignInState> resolve = this.signInResolver.resolve(((SigningIn) oldState).getSignInState(), event);
                return new StateResolution<>(new SigningIn(resolve.getNewState()), resolve.getActions());
            }
            if (oldState instanceof SignedIn) {
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignOutRequested) {
                    return new StateResolution<>(new SigningOut(b18 == true ? 1 : 0, r5, b17 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.initiateSignOutAction((AuthenticationEvent.EventType.SignOutRequested) isAuthenticationEvent, ((SignedIn) oldState).getSignedInData())));
                }
                return stateResolution;
            }
            if (oldState instanceof SigningOut) {
                SignOutEvent.EventType isSignOutEvent = AuthEnvironmentKt.isSignOutEvent(event);
                if (isSignOutEvent instanceof SignOutEvent.EventType.SignedOutSuccess) {
                    return new StateResolution<>(new SignedOut(((SignOutEvent.EventType.SignedOutSuccess) isSignOutEvent).getSignedOutData()), null, 2, null);
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.CancelSignOut) {
                    AuthenticationEvent.EventType.CancelSignOut cancelSignOut = (AuthenticationEvent.EventType.CancelSignOut) isAuthenticationEvent;
                    return new StateResolution<>(new SignedIn(cancelSignOut.getSignedInData(), cancelSignOut.getDeviceMetadata()), null, 2, null);
                }
                StateResolution<SignOutState> resolve2 = this.signOutResolver.resolve(((SigningOut) oldState).getSignOutState(), event);
                return new StateResolution<>(new SigningOut(resolve2.getNewState()), resolve2.getActions());
            }
            if (oldState instanceof SignedOut) {
                AuthorizationEvent.EventType isAuthorizationEvent2 = AuthEnvironmentKt.isAuthorizationEvent(event);
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInRequested) {
                    return new StateResolution<>(new SigningIn(b16 == true ? 1 : 0, r5, b15 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.initiateSignInAction((AuthenticationEvent.EventType.SignInRequested) isAuthenticationEvent)));
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignOutRequested) {
                    return new StateResolution<>(new SigningOut(b14 == true ? 1 : 0, r5, b13 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.initiateSignOutAction((AuthenticationEvent.EventType.SignOutRequested) isAuthenticationEvent, null)));
                }
                if (isAuthorizationEvent2 instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool) {
                    return new StateResolution<>(new FederatingToIdentityPool(b12 == true ? 1 : 0, r5, b11 == true ? 1 : 0), null, 2, null);
                }
                return stateResolution;
            }
            if (oldState instanceof FederatingToIdentityPool) {
                AuthorizationEvent.EventType isAuthorizationEvent3 = AuthEnvironmentKt.isAuthorizationEvent(event);
                if (isAuthorizationEvent3 instanceof AuthorizationEvent.EventType.Fetched) {
                    return new StateResolution<>(new FederatedToIdentityPool(b10 == true ? 1 : 0, r5, b9 == true ? 1 : 0), null, 2, null);
                }
                return isAuthorizationEvent3 instanceof AuthorizationEvent.EventType.ThrowError ? new StateResolution<>(new Error(((AuthorizationEvent.EventType.ThrowError) isAuthorizationEvent3).getException()), null, 2, null) : stateResolution;
            }
            if (oldState instanceof FederatedToIdentityPool) {
                AuthorizationEvent.EventType isAuthorizationEvent4 = AuthEnvironmentKt.isAuthorizationEvent(event);
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.ClearFederationToIdentityPool) {
                    return new StateResolution<>(new SigningOut(b8 == true ? 1 : 0, r5, b7 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.initiateSignOutAction(new AuthenticationEvent.EventType.SignOutRequested(new SignOutData(false, null, false, 7, null)), null)));
                }
                if (isAuthorizationEvent4 instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool) {
                    return new StateResolution<>(new FederatingToIdentityPool(b6 == true ? 1 : 0, r5, b5 == true ? 1 : 0), null, 2, null);
                }
                return stateResolution;
            }
            if (oldState instanceof Error) {
                if (AuthEnvironmentKt.isAuthorizationEvent(event) instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool) {
                    return new StateResolution<>(new FederatingToIdentityPool(b4 == true ? 1 : 0, r5, b3 == true ? 1 : 0), null, 2, null);
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.ClearFederationToIdentityPool) {
                    return new StateResolution<>(new SigningOut(b2 == true ? 1 : 0, r5, b == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authenticationActions.initiateSignOutAction(new AuthenticationEvent.EventType.SignOutRequested(new SignOutData(false, null, false, 7, null)), null)));
                }
                return stateResolution;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends AuthenticationState {
        private final DeviceMetadata deviceMetadata;
        private final SignedInData signedInData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedIn(SignedInData signedInData, DeviceMetadata deviceMetadata) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
            this.signedInData = signedInData;
            this.deviceMetadata = deviceMetadata;
        }

        public static /* synthetic */ SignedIn copy$default(SignedIn signedIn, SignedInData signedInData, DeviceMetadata deviceMetadata, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                signedInData = signedIn.signedInData;
            }
            if ((r3 & 2) != 0) {
                deviceMetadata = signedIn.deviceMetadata;
            }
            return signedIn.copy(signedInData, deviceMetadata);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final DeviceMetadata component2() {
            return this.deviceMetadata;
        }

        public final SignedIn copy(SignedInData signedInData, DeviceMetadata deviceMetadata) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
            return new SignedIn(signedInData, deviceMetadata);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SignedIn)) {
                return false;
            }
            SignedIn signedIn = (SignedIn) obj;
            if (Intrinsics.areEqual(this.signedInData, signedIn.signedInData) && Intrinsics.areEqual(this.deviceMetadata, signedIn.deviceMetadata)) {
                return true;
            }
            return false;
        }

        public final DeviceMetadata getDeviceMetadata() {
            return this.deviceMetadata;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.deviceMetadata.hashCode() + (this.signedInData.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SignedIn(signedInData=" + this.signedInData + ", deviceMetadata=" + this.deviceMetadata + ')';
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class SignedOut extends AuthenticationState {
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

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class SigningIn extends AuthenticationState {
        private SignInState signInState;

        public SigningIn() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SigningIn copy$default(SigningIn signingIn, SignInState signInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signInState = signingIn.signInState;
            }
            return signingIn.copy(signInState);
        }

        public final SignInState component1() {
            return this.signInState;
        }

        public final SigningIn copy(SignInState signInState) {
            Intrinsics.checkNotNullParameter(signInState, "signInState");
            return new SigningIn(signInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningIn) && Intrinsics.areEqual(this.signInState, ((SigningIn) obj).signInState)) {
                return true;
            }
            return false;
        }

        public final SignInState getSignInState() {
            return this.signInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.signInState.hashCode();
        }

        public final void setSignInState(SignInState signInState) {
            Intrinsics.checkNotNullParameter(signInState, "<set-?>");
            this.signInState = signInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningIn(signInState=" + this.signInState + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningIn(SignInState signInState) {
            super(null);
            Intrinsics.checkNotNullParameter(signInState, "signInState");
            this.signInState = signInState;
        }

        public /* synthetic */ SigningIn(SignInState signInState, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? new SignInState.NotStarted(null, 1, 0 == true ? 1 : 0) : signInState);
        }
    }

    /* compiled from: AuthenticationState.kt */
    /* loaded from: classes.dex */
    public static final class SigningOut extends AuthenticationState {
        private SignOutState signOutState;

        public SigningOut() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SigningOut copy$default(SigningOut signingOut, SignOutState signOutState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signOutState = signingOut.signOutState;
            }
            return signingOut.copy(signOutState);
        }

        public final SignOutState component1() {
            return this.signOutState;
        }

        public final SigningOut copy(SignOutState signOutState) {
            Intrinsics.checkNotNullParameter(signOutState, "signOutState");
            return new SigningOut(signOutState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningOut) && Intrinsics.areEqual(this.signOutState, ((SigningOut) obj).signOutState)) {
                return true;
            }
            return false;
        }

        public final SignOutState getSignOutState() {
            return this.signOutState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.signOutState.hashCode();
        }

        public final void setSignOutState(SignOutState signOutState) {
            Intrinsics.checkNotNullParameter(signOutState, "<set-?>");
            this.signOutState = signOutState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningOut(signOutState=" + this.signOutState + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningOut(SignOutState signOutState) {
            super(null);
            Intrinsics.checkNotNullParameter(signOutState, "signOutState");
            this.signOutState = signOutState;
        }

        public /* synthetic */ SigningOut(SignOutState signOutState, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? new SignOutState.NotStarted(null, 1, 0 == true ? 1 : 0) : signOutState);
        }
    }

    public /* synthetic */ AuthenticationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private AuthenticationState() {
    }
}
