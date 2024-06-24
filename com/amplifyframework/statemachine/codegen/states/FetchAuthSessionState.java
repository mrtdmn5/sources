package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import com.amplifyframework.statemachine.codegen.events.FetchAuthSessionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchAuthSessionState.kt */
/* loaded from: classes.dex */
public abstract class FetchAuthSessionState implements State {

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends FetchAuthSessionState {
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

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Fetched extends FetchAuthSessionState {
        private final String id;

        public Fetched() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Fetched copy$default(Fetched fetched, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = fetched.id;
            }
            return fetched.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Fetched copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Fetched(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Fetched) && Intrinsics.areEqual(this.id, ((Fetched) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Fetched(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fetched(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Fetched(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class FetchingAWSCredentials extends FetchAuthSessionState {
        private final String identityId;
        private final LoginsMapProvider logins;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchingAWSCredentials(String identityId, LoginsMapProvider logins) {
            super(null);
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(logins, "logins");
            this.identityId = identityId;
            this.logins = logins;
        }

        public static /* synthetic */ FetchingAWSCredentials copy$default(FetchingAWSCredentials fetchingAWSCredentials, String str, LoginsMapProvider loginsMapProvider, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = fetchingAWSCredentials.identityId;
            }
            if ((r3 & 2) != 0) {
                loginsMapProvider = fetchingAWSCredentials.logins;
            }
            return fetchingAWSCredentials.copy(str, loginsMapProvider);
        }

        public final String component1() {
            return this.identityId;
        }

        public final LoginsMapProvider component2() {
            return this.logins;
        }

        public final FetchingAWSCredentials copy(String identityId, LoginsMapProvider logins) {
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(logins, "logins");
            return new FetchingAWSCredentials(identityId, logins);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FetchingAWSCredentials)) {
                return false;
            }
            FetchingAWSCredentials fetchingAWSCredentials = (FetchingAWSCredentials) obj;
            if (Intrinsics.areEqual(this.identityId, fetchingAWSCredentials.identityId) && Intrinsics.areEqual(this.logins, fetchingAWSCredentials.logins)) {
                return true;
            }
            return false;
        }

        public final String getIdentityId() {
            return this.identityId;
        }

        public final LoginsMapProvider getLogins() {
            return this.logins;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.logins.hashCode() + (this.identityId.hashCode() * 31);
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "FetchingAWSCredentials(identityId=" + this.identityId + ", logins=" + this.logins + ')';
        }
    }

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class FetchingIdentity extends FetchAuthSessionState {
        private final LoginsMapProvider logins;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchingIdentity(LoginsMapProvider logins) {
            super(null);
            Intrinsics.checkNotNullParameter(logins, "logins");
            this.logins = logins;
        }

        public static /* synthetic */ FetchingIdentity copy$default(FetchingIdentity fetchingIdentity, LoginsMapProvider loginsMapProvider, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                loginsMapProvider = fetchingIdentity.logins;
            }
            return fetchingIdentity.copy(loginsMapProvider);
        }

        public final LoginsMapProvider component1() {
            return this.logins;
        }

        public final FetchingIdentity copy(LoginsMapProvider logins) {
            Intrinsics.checkNotNullParameter(logins, "logins");
            return new FetchingIdentity(logins);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FetchingIdentity) && Intrinsics.areEqual(this.logins, ((FetchingIdentity) obj).logins)) {
                return true;
            }
            return false;
        }

        public final LoginsMapProvider getLogins() {
            return this.logins;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.logins.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "FetchingIdentity(logins=" + this.logins + ')';
        }
    }

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends FetchAuthSessionState {
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

    /* compiled from: FetchAuthSessionState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<FetchAuthSessionState> {
        private final NotStarted defaultState;
        private final FetchAuthSessionActions fetchAuthSessionActions;

        public Resolver(FetchAuthSessionActions fetchAuthSessionActions) {
            Intrinsics.checkNotNullParameter(fetchAuthSessionActions, "fetchAuthSessionActions");
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

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<FetchAuthSessionState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<FetchAuthSessionState, StateMachineResolver<FetchAuthSessionState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public FetchAuthSessionState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<FetchAuthSessionState> resolve(FetchAuthSessionState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            FetchAuthSessionEvent.EventType asFetchAuthSessionEvent = asFetchAuthSessionEvent(event);
            String str = null;
            byte b = 0;
            StateResolution<FetchAuthSessionState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            if (oldState instanceof NotStarted) {
                if (asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.FetchIdentity) {
                    FetchAuthSessionEvent.EventType.FetchIdentity fetchIdentity = (FetchAuthSessionEvent.EventType.FetchIdentity) asFetchAuthSessionEvent;
                    return new StateResolution<>(new FetchingIdentity(fetchIdentity.getLogins()), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.fetchIdentityAction(fetchIdentity.getLogins())));
                }
                if (!(asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.FetchAwsCredentials)) {
                    return stateResolution;
                }
                FetchAuthSessionEvent.EventType.FetchAwsCredentials fetchAwsCredentials = (FetchAuthSessionEvent.EventType.FetchAwsCredentials) asFetchAuthSessionEvent;
                return new StateResolution<>(new FetchingAWSCredentials(fetchAwsCredentials.getIdentityId(), fetchAwsCredentials.getLogins()), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.fetchAWSCredentialsAction(fetchAwsCredentials.getIdentityId(), fetchAwsCredentials.getLogins())));
            }
            if (oldState instanceof FetchingIdentity) {
                if (!(asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.FetchAwsCredentials)) {
                    return stateResolution;
                }
                FetchAuthSessionEvent.EventType.FetchAwsCredentials fetchAwsCredentials2 = (FetchAuthSessionEvent.EventType.FetchAwsCredentials) asFetchAuthSessionEvent;
                return new StateResolution<>(new FetchingAWSCredentials(fetchAwsCredentials2.getIdentityId(), fetchAwsCredentials2.getLogins()), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.fetchAWSCredentialsAction(fetchAwsCredentials2.getIdentityId(), fetchAwsCredentials2.getLogins())));
            }
            if (!(oldState instanceof FetchingAWSCredentials) || !(asFetchAuthSessionEvent instanceof FetchAuthSessionEvent.EventType.Fetched)) {
                return stateResolution;
            }
            FetchAuthSessionEvent.EventType.Fetched fetched = (FetchAuthSessionEvent.EventType.Fetched) asFetchAuthSessionEvent;
            return new StateResolution<>(new Fetched(str, 1, b == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.fetchAuthSessionActions.notifySessionEstablishedAction(fetched.getIdentityId(), fetched.getAwsCredentials())));
        }
    }

    public /* synthetic */ FetchAuthSessionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private FetchAuthSessionState() {
    }
}
