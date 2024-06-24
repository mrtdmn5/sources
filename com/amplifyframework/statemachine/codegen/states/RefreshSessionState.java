package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.FetchAuthSessionEvent;
import com.amplifyframework.statemachine.codegen.events.RefreshSessionEvent;
import com.amplifyframework.statemachine.codegen.states.FetchAuthSessionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RefreshSessionState.kt */
/* loaded from: classes.dex */
public abstract class RefreshSessionState implements State {
    private final FetchAuthSessionState fetchAuthSessionState;

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Builder implements com.amplifyframework.statemachine.Builder<RefreshSessionState> {
        private FetchAuthSessionState fetchAuthSessionState;
        private final RefreshSessionState refreshSessionState;

        public Builder(RefreshSessionState refreshSessionState) {
            Intrinsics.checkNotNullParameter(refreshSessionState, "refreshSessionState");
            this.refreshSessionState = refreshSessionState;
        }

        public final FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        public final void setFetchAuthSessionState(FetchAuthSessionState fetchAuthSessionState) {
            this.fetchAuthSessionState = fetchAuthSessionState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.statemachine.Builder
        public RefreshSessionState build() {
            RefreshSessionState refreshSessionState = this.refreshSessionState;
            return refreshSessionState instanceof RefreshingUnAuthSession ? new RefreshingUnAuthSession(this.fetchAuthSessionState) : refreshSessionState instanceof RefreshingAuthSession ? new RefreshingAuthSession(((RefreshingAuthSession) refreshSessionState).getSignedInData(), this.fetchAuthSessionState) : refreshSessionState;
        }
    }

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends RefreshSessionState {
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

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Refreshed extends RefreshSessionState {
        private final String id;

        public Refreshed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Refreshed copy$default(Refreshed refreshed, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = refreshed.id;
            }
            return refreshed.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Refreshed copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Refreshed(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Refreshed) && Intrinsics.areEqual(this.id, ((Refreshed) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Refreshed(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refreshed(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Refreshed(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class RefreshingAuthSession extends RefreshSessionState {
        private final FetchAuthSessionState fetchAuthSessionState;
        private final SignedInData signedInData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshingAuthSession(SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            this.signedInData = signedInData;
            this.fetchAuthSessionState = fetchAuthSessionState;
        }

        public static /* synthetic */ RefreshingAuthSession copy$default(RefreshingAuthSession refreshingAuthSession, SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                signedInData = refreshingAuthSession.signedInData;
            }
            if ((r3 & 2) != 0) {
                fetchAuthSessionState = refreshingAuthSession.getFetchAuthSessionState();
            }
            return refreshingAuthSession.copy(signedInData, fetchAuthSessionState);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final FetchAuthSessionState component2() {
            return getFetchAuthSessionState();
        }

        public final RefreshingAuthSession copy(SignedInData signedInData, FetchAuthSessionState fetchAuthSessionState) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            return new RefreshingAuthSession(signedInData, fetchAuthSessionState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RefreshingAuthSession)) {
                return false;
            }
            RefreshingAuthSession refreshingAuthSession = (RefreshingAuthSession) obj;
            if (Intrinsics.areEqual(this.signedInData, refreshingAuthSession.signedInData) && Intrinsics.areEqual(getFetchAuthSessionState(), refreshingAuthSession.getFetchAuthSessionState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.RefreshSessionState
        public FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.signedInData.hashCode() * 31;
            if (getFetchAuthSessionState() == null) {
                hashCode = 0;
            } else {
                hashCode = getFetchAuthSessionState().hashCode();
            }
            return hashCode2 + hashCode;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "RefreshingAuthSession(signedInData=" + this.signedInData + ", fetchAuthSessionState=" + getFetchAuthSessionState() + ')';
        }
    }

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class RefreshingUnAuthSession extends RefreshSessionState {
        private final FetchAuthSessionState fetchAuthSessionState;

        public RefreshingUnAuthSession(FetchAuthSessionState fetchAuthSessionState) {
            super(null);
            this.fetchAuthSessionState = fetchAuthSessionState;
        }

        public static /* synthetic */ RefreshingUnAuthSession copy$default(RefreshingUnAuthSession refreshingUnAuthSession, FetchAuthSessionState fetchAuthSessionState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                fetchAuthSessionState = refreshingUnAuthSession.getFetchAuthSessionState();
            }
            return refreshingUnAuthSession.copy(fetchAuthSessionState);
        }

        public final FetchAuthSessionState component1() {
            return getFetchAuthSessionState();
        }

        public final RefreshingUnAuthSession copy(FetchAuthSessionState fetchAuthSessionState) {
            return new RefreshingUnAuthSession(fetchAuthSessionState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RefreshingUnAuthSession) && Intrinsics.areEqual(getFetchAuthSessionState(), ((RefreshingUnAuthSession) obj).getFetchAuthSessionState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.RefreshSessionState
        public FetchAuthSessionState getFetchAuthSessionState() {
            return this.fetchAuthSessionState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getFetchAuthSessionState() == null) {
                return 0;
            }
            return getFetchAuthSessionState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "RefreshingUnAuthSession(fetchAuthSessionState=" + getFetchAuthSessionState() + ')';
        }
    }

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class RefreshingUserPoolTokens extends RefreshSessionState {
        private final SignedInData signedInData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshingUserPoolTokens(SignedInData signedInData) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            this.signedInData = signedInData;
        }

        public static /* synthetic */ RefreshingUserPoolTokens copy$default(RefreshingUserPoolTokens refreshingUserPoolTokens, SignedInData signedInData, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signedInData = refreshingUserPoolTokens.signedInData;
            }
            return refreshingUserPoolTokens.copy(signedInData);
        }

        public final SignedInData component1() {
            return this.signedInData;
        }

        public final RefreshingUserPoolTokens copy(SignedInData signedInData) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            return new RefreshingUserPoolTokens(signedInData);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RefreshingUserPoolTokens) && Intrinsics.areEqual(this.signedInData, ((RefreshingUserPoolTokens) obj).signedInData)) {
                return true;
            }
            return false;
        }

        public final SignedInData getSignedInData() {
            return this.signedInData;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.signedInData.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "RefreshingUserPoolTokens(signedInData=" + this.signedInData + ')';
        }
    }

    /* compiled from: RefreshSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<RefreshSessionState> {
        private final NotStarted defaultState;
        private final FetchAuthSessionActions fetchAuthSessionActions;
        private final StateMachineResolver<FetchAuthSessionState> fetchAuthSessionResolver;

        public Resolver(StateMachineResolver<FetchAuthSessionState> fetchAuthSessionResolver, FetchAuthSessionActions fetchAuthSessionActions) {
            Intrinsics.checkNotNullParameter(fetchAuthSessionResolver, "fetchAuthSessionResolver");
            Intrinsics.checkNotNullParameter(fetchAuthSessionActions, "fetchAuthSessionActions");
            this.fetchAuthSessionResolver = fetchAuthSessionResolver;
            this.fetchAuthSessionActions = fetchAuthSessionActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final FetchAuthSessionEvent.EventType asFetchAuthSessionEvent(StateMachineEvent stateMachineEvent) {
            FetchAuthSessionEvent fetchAuthSessionEvent;
            if (stateMachineEvent instanceof FetchAuthSessionEvent) {
                fetchAuthSessionEvent = (FetchAuthSessionEvent) stateMachineEvent;
            } else {
                fetchAuthSessionEvent = null;
            }
            if (fetchAuthSessionEvent == null) {
                return null;
            }
            return fetchAuthSessionEvent.getEventType();
        }

        private final RefreshSessionEvent.EventType asRefreshSessionEvent(StateMachineEvent stateMachineEvent) {
            RefreshSessionEvent refreshSessionEvent;
            if (stateMachineEvent instanceof RefreshSessionEvent) {
                refreshSessionEvent = (RefreshSessionEvent) stateMachineEvent;
            } else {
                refreshSessionEvent = null;
            }
            if (refreshSessionEvent == null) {
                return null;
            }
            return refreshSessionEvent.getEventType();
        }

        private final StateResolution<RefreshSessionState> resolveRefreshSessionEvent(RefreshSessionState refreshSessionState, StateMachineEvent stateMachineEvent) {
            Action refreshUserPoolTokensAction;
            RefreshSessionEvent.EventType asRefreshSessionEvent = asRefreshSessionEvent(stateMachineEvent);
            FetchAuthSessionEvent.EventType asFetchAuthSessionEvent = asFetchAuthSessionEvent(stateMachineEvent);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            StateResolution<RefreshSessionState> stateResolution = new StateResolution<>(refreshSessionState, null, 2, null);
            int r4 = 1;
            if (refreshSessionState instanceof NotStarted) {
                if (asRefreshSessionEvent instanceof RefreshSessionEvent.EventType.RefreshUserPoolTokens) {
                    RefreshSessionEvent.EventType.RefreshUserPoolTokens refreshUserPoolTokens = (RefreshSessionEvent.EventType.RefreshUserPoolTokens) asRefreshSessionEvent;
                    if (refreshUserPoolTokens.getSignedInData().getSignInMethod() instanceof SignInMethod.HostedUI) {
                        refreshUserPoolTokensAction = this.fetchAuthSessionActions.refreshHostedUIUserPoolTokensAction(refreshUserPoolTokens.getSignedInData());
                    } else {
                        refreshUserPoolTokensAction = this.fetchAuthSessionActions.refreshUserPoolTokensAction(refreshUserPoolTokens.getSignedInData());
                    }
                    return new StateResolution<>(new RefreshingUserPoolTokens(refreshUserPoolTokens.getSignedInData()), CollectionsKt__CollectionsKt.listOf(refreshUserPoolTokensAction));
                }
                if (asRefreshSessionEvent instanceof RefreshSessionEvent.EventType.RefreshUnAuthSession) {
                    return new StateResolution<>(new RefreshingUnAuthSession(new FetchAuthSessionState.NotStarted(null, 1, null)), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.refreshAuthSessionAction(((RefreshSessionEvent.EventType.RefreshUnAuthSession) asRefreshSessionEvent).getLogins())));
                }
                return stateResolution;
            }
            if (refreshSessionState instanceof RefreshingUnAuthSession) {
                if (asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.Fetched) {
                    FetchAuthSessionEvent.EventType.Fetched fetched = (FetchAuthSessionEvent.EventType.Fetched) asFetchAuthSessionEvent;
                    return new StateResolution<>(new Refreshed(str, r4, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.notifySessionRefreshedAction(new AmplifyCredential.IdentityPool(fetched.getIdentityId(), fetched.getAwsCredentials()))));
                }
                return stateResolution;
            }
            if (refreshSessionState instanceof RefreshingUserPoolTokens) {
                if (asRefreshSessionEvent instanceof RefreshSessionEvent.EventType.Refreshed) {
                    return new StateResolution<>(new Refreshed(b4 == true ? 1 : 0, r4, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.notifySessionRefreshedAction(new AmplifyCredential.UserPool(((RefreshSessionEvent.EventType.Refreshed) asRefreshSessionEvent).getSignedInData()))));
                }
                if (asRefreshSessionEvent instanceof RefreshSessionEvent.EventType.RefreshAuthSession) {
                    RefreshSessionEvent.EventType.RefreshAuthSession refreshAuthSession = (RefreshSessionEvent.EventType.RefreshAuthSession) asRefreshSessionEvent;
                    return new StateResolution<>(new RefreshingAuthSession(refreshAuthSession.getSignedInData(), new FetchAuthSessionState.NotStarted(null, 1, null)), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.refreshAuthSessionAction(refreshAuthSession.getLogins())));
                }
                return stateResolution;
            }
            if ((refreshSessionState instanceof RefreshingAuthSession) && (asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.Fetched)) {
                FetchAuthSessionEvent.EventType.Fetched fetched2 = (FetchAuthSessionEvent.EventType.Fetched) asFetchAuthSessionEvent;
                return new StateResolution<>(new Refreshed(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.notifySessionRefreshedAction(new AmplifyCredential.UserAndIdentityPool(((RefreshingAuthSession) refreshSessionState).getSignedInData(), fetched2.getIdentityId(), fetched2.getAwsCredentials()))));
            }
            return stateResolution;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<RefreshSessionState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<RefreshSessionState, StateMachineResolver<RefreshSessionState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public RefreshSessionState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<RefreshSessionState> resolve(RefreshSessionState oldState, StateMachineEvent event) {
            StateResolution<FetchAuthSessionState> resolve;
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            StateResolution<RefreshSessionState> resolveRefreshSessionEvent = resolveRefreshSessionEvent(oldState, event);
            ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) resolveRefreshSessionEvent.getActions());
            Builder builder = new Builder(resolveRefreshSessionEvent.getNewState());
            FetchAuthSessionState fetchAuthSessionState = oldState.getFetchAuthSessionState();
            if (fetchAuthSessionState != null && (resolve = this.fetchAuthSessionResolver.resolve(fetchAuthSessionState, event)) != null) {
                builder.setFetchAuthSessionState(resolve.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve.getActions(), mutableList);
            }
            return new StateResolution<>(builder.build(), mutableList);
        }
    }

    public /* synthetic */ RefreshSessionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public FetchAuthSessionState getFetchAuthSessionState() {
        return this.fetchAuthSessionState;
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private RefreshSessionState() {
        this.fetchAuthSessionState = new FetchAuthSessionState.NotStarted(null, 1, null);
    }
}
