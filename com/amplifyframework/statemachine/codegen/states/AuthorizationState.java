package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironmentKt;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.AuthorizationActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.FederatedToken;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.errors.SessionError;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.DeleteUserEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import com.amplifyframework.statemachine.codegen.states.DeleteUserState;
import com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState;
import com.amplifyframework.statemachine.codegen.states.RefreshSessionState;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationState.kt */
/* loaded from: classes.dex */
public abstract class AuthorizationState implements State {
    private final String type;

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class Configured extends AuthorizationState {
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

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class DeletingUser extends AuthorizationState {
        private final AmplifyCredential amplifyCredential;
        private final DeleteUserState deleteUserState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeletingUser(DeleteUserState deleteUserState, AmplifyCredential amplifyCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(deleteUserState, "deleteUserState");
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            this.deleteUserState = deleteUserState;
            this.amplifyCredential = amplifyCredential;
        }

        public static /* synthetic */ DeletingUser copy$default(DeletingUser deletingUser, DeleteUserState deleteUserState, AmplifyCredential amplifyCredential, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                deleteUserState = deletingUser.deleteUserState;
            }
            if ((r3 & 2) != 0) {
                amplifyCredential = deletingUser.amplifyCredential;
            }
            return deletingUser.copy(deleteUserState, amplifyCredential);
        }

        public final DeleteUserState component1() {
            return this.deleteUserState;
        }

        public final AmplifyCredential component2() {
            return this.amplifyCredential;
        }

        public final DeletingUser copy(DeleteUserState deleteUserState, AmplifyCredential amplifyCredential) {
            Intrinsics.checkNotNullParameter(deleteUserState, "deleteUserState");
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            return new DeletingUser(deleteUserState, amplifyCredential);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeletingUser)) {
                return false;
            }
            DeletingUser deletingUser = (DeletingUser) obj;
            if (Intrinsics.areEqual(this.deleteUserState, deletingUser.deleteUserState) && Intrinsics.areEqual(this.amplifyCredential, deletingUser.amplifyCredential)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getAmplifyCredential() {
            return this.amplifyCredential;
        }

        public final DeleteUserState getDeleteUserState() {
            return this.deleteUserState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.amplifyCredential.hashCode() + (this.deleteUserState.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "DeletingUser(deleteUserState=" + this.deleteUserState + ", amplifyCredential=" + this.amplifyCredential + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends AuthorizationState {
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

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class FederatingToIdentityPool extends AuthorizationState {
        private final AmplifyCredential existingCredential;
        private final FederatedToken federatedToken;
        private final FetchAuthSessionState fetchAuthSessionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FederatingToIdentityPool(FederatedToken federatedToken, FetchAuthSessionState fetchAuthSessionState, AmplifyCredential amplifyCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            this.federatedToken = federatedToken;
            this.fetchAuthSessionState = fetchAuthSessionState;
            this.existingCredential = amplifyCredential;
        }

        public static /* synthetic */ FederatingToIdentityPool copy$default(FederatingToIdentityPool federatingToIdentityPool, FederatedToken federatedToken, FetchAuthSessionState fetchAuthSessionState, AmplifyCredential amplifyCredential, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                federatedToken = federatingToIdentityPool.federatedToken;
            }
            if ((r4 & 2) != 0) {
                fetchAuthSessionState = federatingToIdentityPool.fetchAuthSessionState;
            }
            if ((r4 & 4) != 0) {
                amplifyCredential = federatingToIdentityPool.existingCredential;
            }
            return federatingToIdentityPool.copy(federatedToken, fetchAuthSessionState, amplifyCredential);
        }

        public final FederatedToken component1() {
            return this.federatedToken;
        }

        public final FetchAuthSessionState component2() {
            return this.fetchAuthSessionState;
        }

        public final AmplifyCredential component3() {
            return this.existingCredential;
        }

        public final FederatingToIdentityPool copy(FederatedToken federatedToken, FetchAuthSessionState fetchAuthSessionState, AmplifyCredential amplifyCredential) {
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            return new FederatingToIdentityPool(federatedToken, fetchAuthSessionState, amplifyCredential);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FederatingToIdentityPool)) {
                return false;
            }
            FederatingToIdentityPool federatingToIdentityPool = (FederatingToIdentityPool) obj;
            if (Intrinsics.areEqual(this.federatedToken, federatingToIdentityPool.federatedToken) && Intrinsics.areEqual(this.fetchAuthSessionState, federatingToIdentityPool.fetchAuthSessionState) && Intrinsics.areEqual(this.existingCredential, federatingToIdentityPool.existingCredential)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getExistingCredential() {
            return this.existingCredential;
        }

        public final FederatedToken getFederatedToken() {
            return this.federatedToken;
        }

        public final FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            int hashCode;
            int hashCode2 = (this.fetchAuthSessionState.hashCode() + (this.federatedToken.hashCode() * 31)) * 31;
            AmplifyCredential amplifyCredential = this.existingCredential;
            if (amplifyCredential == null) {
                hashCode = 0;
            } else {
                hashCode = amplifyCredential.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "FederatingToIdentityPool(federatedToken=" + this.federatedToken + ", fetchAuthSessionState=" + this.fetchAuthSessionState + ", existingCredential=" + this.existingCredential + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class FetchingAuthSession extends AuthorizationState {
        private final FetchAuthSessionState fetchAuthSessionState;
        private final SignedInData signedInData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchingAuthSession(SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            this.signedInData = signedInData;
            this.fetchAuthSessionState = fetchAuthSessionState;
        }

        public static /* synthetic */ FetchingAuthSession copy$default(FetchingAuthSession fetchingAuthSession, SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                signedInData = fetchingAuthSession.signedInData;
            }
            if ((r3 & 2) != 0) {
                fetchAuthSessionState = fetchingAuthSession.fetchAuthSessionState;
            }
            return fetchingAuthSession.copy(signedInData, fetchAuthSessionState);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final FetchAuthSessionState component2() {
            return this.fetchAuthSessionState;
        }

        public final FetchingAuthSession copy(SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            return new FetchingAuthSession(signedInData, fetchAuthSessionState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FetchingAuthSession)) {
                return false;
            }
            FetchingAuthSession fetchingAuthSession = (FetchingAuthSession) obj;
            if (Intrinsics.areEqual(this.signedInData, fetchingAuthSession.signedInData) && Intrinsics.areEqual(this.fetchAuthSessionState, fetchingAuthSession.fetchAuthSessionState)) {
                return true;
            }
            return false;
        }

        public final FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.fetchAuthSessionState.hashCode() + (this.signedInData.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "FetchingAuthSession(signedInData=" + this.signedInData + ", fetchAuthSessionState=" + this.fetchAuthSessionState + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class FetchingUnAuthSession extends AuthorizationState {
        private final FetchAuthSessionState fetchAuthSessionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchingUnAuthSession(FetchAuthSessionState fetchAuthSessionState) {
            super(null);
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            this.fetchAuthSessionState = fetchAuthSessionState;
        }

        public static /* synthetic */ FetchingUnAuthSession copy$default(FetchingUnAuthSession fetchingUnAuthSession, FetchAuthSessionState fetchAuthSessionState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                fetchAuthSessionState = fetchingUnAuthSession.fetchAuthSessionState;
            }
            return fetchingUnAuthSession.copy(fetchAuthSessionState);
        }

        public final FetchAuthSessionState component1() {
            return this.fetchAuthSessionState;
        }

        public final FetchingUnAuthSession copy(FetchAuthSessionState fetchAuthSessionState) {
            Intrinsics.checkNotNullParameter(fetchAuthSessionState, "fetchAuthSessionState");
            return new FetchingUnAuthSession(fetchAuthSessionState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FetchingUnAuthSession) && Intrinsics.areEqual(this.fetchAuthSessionState, ((FetchingUnAuthSession) obj).fetchAuthSessionState)) {
                return true;
            }
            return false;
        }

        public final FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.fetchAuthSessionState.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "FetchingUnAuthSession(fetchAuthSessionState=" + this.fetchAuthSessionState + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class NotConfigured extends AuthorizationState {
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

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class RefreshingSession extends AuthorizationState {
        private final AmplifyCredential existingCredential;
        private final RefreshSessionState refreshSessionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshingSession(AmplifyCredential existingCredential, RefreshSessionState refreshSessionState) {
            super(null);
            Intrinsics.checkNotNullParameter(existingCredential, "existingCredential");
            Intrinsics.checkNotNullParameter(refreshSessionState, "refreshSessionState");
            this.existingCredential = existingCredential;
            this.refreshSessionState = refreshSessionState;
        }

        public static /* synthetic */ RefreshingSession copy$default(RefreshingSession refreshingSession, AmplifyCredential amplifyCredential, RefreshSessionState refreshSessionState, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                amplifyCredential = refreshingSession.existingCredential;
            }
            if ((r3 & 2) != 0) {
                refreshSessionState = refreshingSession.refreshSessionState;
            }
            return refreshingSession.copy(amplifyCredential, refreshSessionState);
        }

        public final AmplifyCredential component1() {
            return this.existingCredential;
        }

        public final RefreshSessionState component2() {
            return this.refreshSessionState;
        }

        public final RefreshingSession copy(AmplifyCredential existingCredential, RefreshSessionState refreshSessionState) {
            Intrinsics.checkNotNullParameter(existingCredential, "existingCredential");
            Intrinsics.checkNotNullParameter(refreshSessionState, "refreshSessionState");
            return new RefreshingSession(existingCredential, refreshSessionState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RefreshingSession)) {
                return false;
            }
            RefreshingSession refreshingSession = (RefreshingSession) obj;
            if (Intrinsics.areEqual(this.existingCredential, refreshingSession.existingCredential) && Intrinsics.areEqual(this.refreshSessionState, refreshingSession.refreshSessionState)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getExistingCredential() {
            return this.existingCredential;
        }

        public final RefreshSessionState getRefreshSessionState() {
            return this.refreshSessionState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.refreshSessionState.hashCode() + (this.existingCredential.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "RefreshingSession(existingCredential=" + this.existingCredential + ", refreshSessionState=" + this.refreshSessionState + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<AuthorizationState> {
        private final AuthorizationActions authorizationActions;
        private final NotConfigured defaultState;
        private final StateMachineResolver<DeleteUserState> deleteUserResolver;
        private final StateMachineResolver<FetchAuthSessionState> fetchAuthSessionResolver;
        private final StateMachineResolver<RefreshSessionState> refreshSessionResolver;

        public Resolver(StateMachineResolver<FetchAuthSessionState> fetchAuthSessionResolver, StateMachineResolver<RefreshSessionState> refreshSessionResolver, StateMachineResolver<DeleteUserState> deleteUserResolver, AuthorizationActions authorizationActions) {
            Intrinsics.checkNotNullParameter(fetchAuthSessionResolver, "fetchAuthSessionResolver");
            Intrinsics.checkNotNullParameter(refreshSessionResolver, "refreshSessionResolver");
            Intrinsics.checkNotNullParameter(deleteUserResolver, "deleteUserResolver");
            Intrinsics.checkNotNullParameter(authorizationActions, "authorizationActions");
            this.fetchAuthSessionResolver = fetchAuthSessionResolver;
            this.refreshSessionResolver = refreshSessionResolver;
            this.deleteUserResolver = deleteUserResolver;
            this.authorizationActions = authorizationActions;
            this.defaultState = new NotConfigured("");
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<AuthorizationState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<AuthorizationState, StateMachineResolver<AuthorizationState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AuthorizationState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<AuthorizationState> resolve(AuthorizationState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            AuthEvent.EventType isAuthEvent = AuthEnvironmentKt.isAuthEvent(event);
            AuthenticationEvent.EventType isAuthenticationEvent = AuthEnvironmentKt.isAuthenticationEvent(event);
            AuthorizationEvent.EventType isAuthorizationEvent = AuthEnvironmentKt.isAuthorizationEvent(event);
            DeleteUserEvent.EventType isDeleteUserEvent = AuthEnvironmentKt.isDeleteUserEvent(event);
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
            byte b24 = 0;
            byte b25 = 0;
            byte b26 = 0;
            byte b27 = 0;
            byte b28 = 0;
            byte b29 = 0;
            byte b30 = 0;
            byte b31 = 0;
            byte b32 = 0;
            byte b33 = 0;
            byte b34 = 0;
            byte b35 = 0;
            StateResolution<AuthorizationState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            int r8 = 1;
            if (oldState instanceof NotConfigured) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.Configure) {
                    return new StateResolution<>(new Configured(str, r8, b35 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.configureAuthorizationAction()));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.CachedCredentialsAvailable) {
                    return new StateResolution<>(new SessionEstablished(((AuthorizationEvent.EventType.CachedCredentialsAvailable) isAuthorizationEvent).getAmplifyCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.configureAuthorizationAction()));
                }
                return isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError ? new StateResolution<>(new NotConfigured(b34 == true ? 1 : 0, r8, b33 == true ? 1 : 0), null, 2, null) : stateResolution;
            }
            if (oldState instanceof Configured) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.FetchUnAuthSession) {
                    return new StateResolution<>(new FetchingUnAuthSession(new FetchAuthSessionState.NotStarted(b32 == true ? 1 : 0, r8, b31 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFetchUnAuthSession()));
                }
                if (!(isAuthorizationEvent instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool)) {
                    return isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInRequested ? new StateResolution<>(new SigningIn(b28 == true ? 1 : 0, r8, b27 == true ? 1 : 0), null, 2, null) : stateResolution;
                }
                AuthorizationEvent.EventType.StartFederationToIdentityPool startFederationToIdentityPool = (AuthorizationEvent.EventType.StartFederationToIdentityPool) isAuthorizationEvent;
                return new StateResolution<>(new FederatingToIdentityPool(startFederationToIdentityPool.getToken(), new FetchAuthSessionState.NotStarted(b30 == true ? 1 : 0, r8, b29 == true ? 1 : 0), startFederationToIdentityPool.getExistingCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFederationToIdentityPool(startFederationToIdentityPool.getToken(), startFederationToIdentityPool.getIdentityId())));
            }
            if (oldState instanceof StoringCredentials) {
                if (!(isAuthEvent instanceof AuthEvent.EventType.ReceivedCachedCredentials)) {
                    return isAuthEvent instanceof AuthEvent.EventType.CachedCredentialsFailed ? new StateResolution<>(new NotConfigured(b24 == true ? 1 : 0, r8, b23 == true ? 1 : 0), null, 2, null) : stateResolution;
                }
                if (((StoringCredentials) oldState).getAmplifyCredential() instanceof AmplifyCredential.Empty) {
                    return new StateResolution<>(new Configured(b26 == true ? 1 : 0, r8, b25 == true ? 1 : 0), null, 2, null);
                }
                return new StateResolution<>(new SessionEstablished(((AuthEvent.EventType.ReceivedCachedCredentials) isAuthEvent).getStoredCredentials()), null, 2, null);
            }
            if (oldState instanceof SigningIn) {
                if (!(isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInCompleted)) {
                    return isAuthenticationEvent instanceof AuthenticationEvent.EventType.CancelSignIn ? new StateResolution<>(new Configured(b20 == true ? 1 : 0, r8, b19 == true ? 1 : 0), null, 2, null) : stateResolution;
                }
                AuthenticationEvent.EventType.SignInCompleted signInCompleted = (AuthenticationEvent.EventType.SignInCompleted) isAuthenticationEvent;
                return new StateResolution<>(new FetchingAuthSession(signInCompleted.getSignedInData(), new FetchAuthSessionState.NotStarted(b22 == true ? 1 : 0, r8, b21 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFetchAuthSession(signInCompleted.getSignedInData())));
            }
            if (oldState instanceof SigningOut) {
                if (!(AuthEnvironmentKt.isSignOutEvent(event) instanceof SignOutEvent.EventType.SignOutLocally)) {
                    return isAuthenticationEvent instanceof AuthenticationEvent.EventType.CancelSignOut ? new StateResolution<>(new SessionEstablished(((SigningOut) oldState).getAmplifyCredential()), null, 2, null) : stateResolution;
                }
                AuthorizationActions authorizationActions = this.authorizationActions;
                AmplifyCredential.Empty empty = AmplifyCredential.Empty.INSTANCE;
                return new StateResolution<>(new StoringCredentials(empty), CollectionsKt__CollectionsKt.listOf(authorizationActions.persistCredentials(empty)));
            }
            if (oldState instanceof FetchingUnAuthSession) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.Fetched) {
                    AuthorizationEvent.EventType.Fetched fetched = (AuthorizationEvent.EventType.Fetched) isAuthorizationEvent;
                    AmplifyCredential.IdentityPool identityPool = new AmplifyCredential.IdentityPool(fetched.getIdentityId(), fetched.getAwsCredentials());
                    return new StateResolution<>(new StoringCredentials(identityPool), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.persistCredentials(identityPool)));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(new SessionError(((AuthorizationEvent.EventType.ThrowError) isAuthorizationEvent).getException(), AmplifyCredential.Empty.INSTANCE)), null, 2, null);
                }
                StateResolution<FetchAuthSessionState> resolve = this.fetchAuthSessionResolver.resolve(((FetchingUnAuthSession) oldState).getFetchAuthSessionState(), event);
                return new StateResolution<>(new FetchingUnAuthSession(resolve.getNewState()), resolve.getActions());
            }
            if (oldState instanceof FetchingAuthSession) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.Fetched) {
                    AuthorizationEvent.EventType.Fetched fetched2 = (AuthorizationEvent.EventType.Fetched) isAuthorizationEvent;
                    AmplifyCredential.UserAndIdentityPool userAndIdentityPool = new AmplifyCredential.UserAndIdentityPool(((FetchingAuthSession) oldState).getSignedInData(), fetched2.getIdentityId(), fetched2.getAwsCredentials());
                    return new StateResolution<>(new StoringCredentials(userAndIdentityPool), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.persistCredentials(userAndIdentityPool)));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError) {
                    AmplifyCredential.UserPool userPool = new AmplifyCredential.UserPool(((FetchingAuthSession) oldState).getSignedInData());
                    return new StateResolution<>(new StoringCredentials(userPool), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.persistCredentials(userPool)));
                }
                FetchingAuthSession fetchingAuthSession = (FetchingAuthSession) oldState;
                StateResolution<FetchAuthSessionState> resolve2 = this.fetchAuthSessionResolver.resolve(fetchingAuthSession.getFetchAuthSessionState(), event);
                return new StateResolution<>(new FetchingAuthSession(fetchingAuthSession.getSignedInData(), resolve2.getNewState()), resolve2.getActions());
            }
            if (oldState instanceof FederatingToIdentityPool) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.Fetched) {
                    AuthorizationEvent.EventType.Fetched fetched3 = (AuthorizationEvent.EventType.Fetched) isAuthorizationEvent;
                    AmplifyCredential.IdentityPoolFederated identityPoolFederated = new AmplifyCredential.IdentityPoolFederated(((FederatingToIdentityPool) oldState).getFederatedToken(), fetched3.getIdentityId(), fetched3.getAwsCredentials());
                    return new StateResolution<>(new StoringCredentials(identityPoolFederated), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.persistCredentials(identityPoolFederated)));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError) {
                    Exception exception = ((AuthorizationEvent.EventType.ThrowError) isAuthorizationEvent).getException();
                    AmplifyCredential existingCredential = ((FederatingToIdentityPool) oldState).getExistingCredential();
                    if (existingCredential == null) {
                        existingCredential = AmplifyCredential.Empty.INSTANCE;
                    }
                    return new StateResolution<>(new Error(new SessionError(exception, existingCredential)), null, 2, null);
                }
                FederatingToIdentityPool federatingToIdentityPool = (FederatingToIdentityPool) oldState;
                StateResolution<FetchAuthSessionState> resolve3 = this.fetchAuthSessionResolver.resolve(federatingToIdentityPool.getFetchAuthSessionState(), event);
                return new StateResolution<>(new FederatingToIdentityPool(federatingToIdentityPool.getFederatedToken(), resolve3.getNewState(), federatingToIdentityPool.getExistingCredential()), resolve3.getActions());
            }
            if (oldState instanceof RefreshingSession) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.Refreshed) {
                    AuthorizationEvent.EventType.Refreshed refreshed = (AuthorizationEvent.EventType.Refreshed) isAuthorizationEvent;
                    return new StateResolution<>(new StoringCredentials(refreshed.getAmplifyCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.persistCredentials(refreshed.getAmplifyCredential())));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(new SessionError(((AuthorizationEvent.EventType.ThrowError) isAuthorizationEvent).getException(), ((RefreshingSession) oldState).getExistingCredential())), null, 2, null);
                }
                RefreshingSession refreshingSession = (RefreshingSession) oldState;
                StateResolution<RefreshSessionState> resolve4 = this.refreshSessionResolver.resolve(refreshingSession.getRefreshSessionState(), event);
                return new StateResolution<>(new RefreshingSession(refreshingSession.getExistingCredential(), resolve4.getNewState()), resolve4.getActions());
            }
            if (oldState instanceof DeletingUser) {
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.UserDeleted) {
                    return new StateResolution<>(new SigningOut(((DeletingUser) oldState).getAmplifyCredential()), EmptyList.INSTANCE);
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.ThrowError) {
                    return new StateResolution<>(new SessionEstablished(((DeletingUser) oldState).getAmplifyCredential()), null, 2, null);
                }
                DeletingUser deletingUser = (DeletingUser) oldState;
                StateResolution<DeleteUserState> resolve5 = this.deleteUserResolver.resolve(deletingUser.getDeleteUserState(), event);
                return new StateResolution<>(new DeletingUser(resolve5.getNewState(), deletingUser.getAmplifyCredential()), resolve5.getActions());
            }
            if (oldState instanceof SessionEstablished) {
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInRequested) {
                    return new StateResolution<>(new SigningIn(b18 == true ? 1 : 0, r8, b17 == true ? 1 : 0), null, 2, null);
                }
                if (!(isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignOutRequested) && !(isAuthenticationEvent instanceof AuthenticationEvent.EventType.ClearFederationToIdentityPool)) {
                    if (isDeleteUserEvent instanceof DeleteUserEvent.EventType.DeleteUser) {
                        return new StateResolution<>(new DeletingUser(new DeleteUserState.NotStarted(b16 == true ? 1 : 0, r8, b15 == true ? 1 : 0), ((SessionEstablished) oldState).getAmplifyCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initiateDeleteUser((DeleteUserEvent.EventType.DeleteUser) isDeleteUserEvent)));
                    }
                    if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.RefreshSession) {
                        AuthorizationEvent.EventType.RefreshSession refreshSession = (AuthorizationEvent.EventType.RefreshSession) isAuthorizationEvent;
                        return new StateResolution<>(new RefreshingSession(refreshSession.getAmplifyCredential(), new RefreshSessionState.NotStarted(b14 == true ? 1 : 0, r8, b13 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initiateRefreshSessionAction(refreshSession.getAmplifyCredential())));
                    }
                    if (!(isAuthorizationEvent instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool)) {
                        return stateResolution;
                    }
                    AuthorizationEvent.EventType.StartFederationToIdentityPool startFederationToIdentityPool2 = (AuthorizationEvent.EventType.StartFederationToIdentityPool) isAuthorizationEvent;
                    return new StateResolution<>(new FederatingToIdentityPool(startFederationToIdentityPool2.getToken(), new FetchAuthSessionState.NotStarted(b12 == true ? 1 : 0, r8, b11 == true ? 1 : 0), startFederationToIdentityPool2.getExistingCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFederationToIdentityPool(startFederationToIdentityPool2.getToken(), startFederationToIdentityPool2.getIdentityId())));
                }
                return new StateResolution<>(new SigningOut(((SessionEstablished) oldState).getAmplifyCredential()), null, 2, null);
            }
            if (oldState instanceof Error) {
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignInRequested) {
                    return new StateResolution<>(new SigningIn(b10 == true ? 1 : 0, r8, b9 == true ? 1 : 0), null, 2, null);
                }
                if (isAuthenticationEvent instanceof AuthenticationEvent.EventType.SignOutRequested) {
                    return new StateResolution<>(new SigningOut(AmplifyCredential.Empty.INSTANCE), null, 2, null);
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.FetchUnAuthSession) {
                    return new StateResolution<>(new FetchingUnAuthSession(new FetchAuthSessionState.NotStarted(b8 == true ? 1 : 0, r8, b7 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFetchUnAuthSession()));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.RefreshSession) {
                    AuthorizationEvent.EventType.RefreshSession refreshSession2 = (AuthorizationEvent.EventType.RefreshSession) isAuthorizationEvent;
                    return new StateResolution<>(new RefreshingSession(refreshSession2.getAmplifyCredential(), new RefreshSessionState.NotStarted(b6 == true ? 1 : 0, r8, b5 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initiateRefreshSessionAction(refreshSession2.getAmplifyCredential())));
                }
                if (isAuthorizationEvent instanceof AuthorizationEvent.EventType.StartFederationToIdentityPool) {
                    AuthorizationEvent.EventType.StartFederationToIdentityPool startFederationToIdentityPool3 = (AuthorizationEvent.EventType.StartFederationToIdentityPool) isAuthorizationEvent;
                    return new StateResolution<>(new FederatingToIdentityPool(startFederationToIdentityPool3.getToken(), new FetchAuthSessionState.NotStarted(b4 == true ? 1 : 0, r8, b3 == true ? 1 : 0), startFederationToIdentityPool3.getExistingCredential()), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initializeFederationToIdentityPool(startFederationToIdentityPool3.getToken(), startFederationToIdentityPool3.getIdentityId())));
                }
                if (isDeleteUserEvent instanceof DeleteUserEvent.EventType.DeleteUser) {
                    return new StateResolution<>(new DeletingUser(new DeleteUserState.NotStarted(b2 == true ? 1 : 0, r8, b == true ? 1 : 0), AmplifyCredential.Empty.INSTANCE), CollectionsKt__CollectionsKt.listOf(this.authorizationActions.initiateDeleteUser((DeleteUserEvent.EventType.DeleteUser) isDeleteUserEvent)));
                }
                return stateResolution;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class SessionEstablished extends AuthorizationState {
        private final AmplifyCredential amplifyCredential;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionEstablished(AmplifyCredential amplifyCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            this.amplifyCredential = amplifyCredential;
        }

        public static /* synthetic */ SessionEstablished copy$default(SessionEstablished sessionEstablished, AmplifyCredential amplifyCredential, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                amplifyCredential = sessionEstablished.amplifyCredential;
            }
            return sessionEstablished.copy(amplifyCredential);
        }

        public final AmplifyCredential component1() {
            return this.amplifyCredential;
        }

        public final SessionEstablished copy(AmplifyCredential amplifyCredential) {
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            return new SessionEstablished(amplifyCredential);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SessionEstablished) && Intrinsics.areEqual(this.amplifyCredential, ((SessionEstablished) obj).amplifyCredential)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getAmplifyCredential() {
            return this.amplifyCredential;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.amplifyCredential.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SessionEstablished(amplifyCredential=" + this.amplifyCredential + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class SigningIn extends AuthorizationState {
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

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class SigningOut extends AuthorizationState {
        private final AmplifyCredential amplifyCredential;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SigningOut(AmplifyCredential amplifyCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            this.amplifyCredential = amplifyCredential;
        }

        public static /* synthetic */ SigningOut copy$default(SigningOut signingOut, AmplifyCredential amplifyCredential, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                amplifyCredential = signingOut.amplifyCredential;
            }
            return signingOut.copy(amplifyCredential);
        }

        public final AmplifyCredential component1() {
            return this.amplifyCredential;
        }

        public final SigningOut copy(AmplifyCredential amplifyCredential) {
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            return new SigningOut(amplifyCredential);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningOut) && Intrinsics.areEqual(this.amplifyCredential, ((SigningOut) obj).amplifyCredential)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getAmplifyCredential() {
            return this.amplifyCredential;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.amplifyCredential.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningOut(amplifyCredential=" + this.amplifyCredential + ')';
        }
    }

    /* compiled from: AuthorizationState.kt */
    /* loaded from: classes.dex */
    public static final class StoringCredentials extends AuthorizationState {
        private final AmplifyCredential amplifyCredential;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoringCredentials(AmplifyCredential amplifyCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            this.amplifyCredential = amplifyCredential;
        }

        public static /* synthetic */ StoringCredentials copy$default(StoringCredentials storingCredentials, AmplifyCredential amplifyCredential, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                amplifyCredential = storingCredentials.amplifyCredential;
            }
            return storingCredentials.copy(amplifyCredential);
        }

        public final AmplifyCredential component1() {
            return this.amplifyCredential;
        }

        public final StoringCredentials copy(AmplifyCredential amplifyCredential) {
            Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
            return new StoringCredentials(amplifyCredential);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof StoringCredentials) && Intrinsics.areEqual(this.amplifyCredential, ((StoringCredentials) obj).amplifyCredential)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getAmplifyCredential() {
            return this.amplifyCredential;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.amplifyCredential.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "StoringCredentials(amplifyCredential=" + this.amplifyCredential + ')';
        }
    }

    public /* synthetic */ AuthorizationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return this.type;
    }

    private AuthorizationState() {
        this.type = toString();
    }
}
