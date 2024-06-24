package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.HostedUIActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.HostedUIOptions;
import com.amplifyframework.statemachine.codegen.events.HostedUIEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUISignInState.kt */
/* loaded from: classes.dex */
public abstract class HostedUISignInState implements State {

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class Done extends HostedUISignInState {
        private final String id;

        public Done() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Done copy$default(Done done, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = done.id;
            }
            return done.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Done copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Done(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Done) && Intrinsics.areEqual(this.id, ((Done) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Done(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Done(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Done(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends HostedUISignInState {
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

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class FetchingToken extends HostedUISignInState {
        private final String id;

        public FetchingToken() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FetchingToken copy$default(FetchingToken fetchingToken, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = fetchingToken.id;
            }
            return fetchingToken.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final FetchingToken copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new FetchingToken(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FetchingToken) && Intrinsics.areEqual(this.id, ((FetchingToken) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FetchingToken(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchingToken(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ FetchingToken(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends HostedUISignInState {
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

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<HostedUISignInState> {
        private final NotStarted defaultState;
        private final HostedUIActions hostedUIActions;

        public Resolver(HostedUIActions hostedUIActions) {
            Intrinsics.checkNotNullParameter(hostedUIActions, "hostedUIActions");
            this.hostedUIActions = hostedUIActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final HostedUIEvent.EventType asHostedUIEvent(StateMachineEvent stateMachineEvent) {
            HostedUIEvent hostedUIEvent;
            if (stateMachineEvent instanceof HostedUIEvent) {
                hostedUIEvent = (HostedUIEvent) stateMachineEvent;
            } else {
                hostedUIEvent = null;
            }
            if (hostedUIEvent == null) {
                return null;
            }
            return hostedUIEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<HostedUISignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<HostedUISignInState, StateMachineResolver<HostedUISignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public HostedUISignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<HostedUISignInState> resolve(HostedUISignInState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            HostedUIEvent.EventType asHostedUIEvent = asHostedUIEvent(event);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            StateResolution<HostedUISignInState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            if (oldState instanceof NotStarted) {
                if (!(asHostedUIEvent instanceof HostedUIEvent.EventType.ShowHostedUI)) {
                    return stateResolution;
                }
                HostedUIEvent.EventType.ShowHostedUI showHostedUI = (HostedUIEvent.EventType.ShowHostedUI) asHostedUIEvent;
                return new StateResolution<>(new ShowingUI(showHostedUI.getHostedUISignInData().getHostedUIOptions()), CollectionsKt__CollectionsKt.listOf(this.hostedUIActions.showHostedUI(showHostedUI)));
            }
            int r4 = 1;
            if (!(oldState instanceof ShowingUI)) {
                return oldState instanceof FetchingToken ? asHostedUIEvent instanceof HostedUIEvent.EventType.TokenFetched ? new StateResolution<>(new Done(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), null, 2, null) : asHostedUIEvent instanceof HostedUIEvent.EventType.ThrowError ? new StateResolution<>(new Error(((HostedUIEvent.EventType.ThrowError) asHostedUIEvent).getException()), null, 2, null) : stateResolution : stateResolution;
            }
            if (asHostedUIEvent instanceof HostedUIEvent.EventType.FetchToken) {
                return new StateResolution<>(new FetchingToken(str, r4, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.hostedUIActions.fetchHostedUISignInToken((HostedUIEvent.EventType.FetchToken) asHostedUIEvent, ((ShowingUI) oldState).getHostedUIOptions().getBrowserPackage())));
            }
            return asHostedUIEvent instanceof HostedUIEvent.EventType.ThrowError ? new StateResolution<>(new Error(((HostedUIEvent.EventType.ThrowError) asHostedUIEvent).getException()), null, 2, null) : stateResolution;
        }
    }

    /* compiled from: HostedUISignInState.kt */
    /* loaded from: classes.dex */
    public static final class ShowingUI extends HostedUISignInState {
        private final HostedUIOptions hostedUIOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowingUI(HostedUIOptions hostedUIOptions) {
            super(null);
            Intrinsics.checkNotNullParameter(hostedUIOptions, "hostedUIOptions");
            this.hostedUIOptions = hostedUIOptions;
        }

        public static /* synthetic */ ShowingUI copy$default(ShowingUI showingUI, HostedUIOptions hostedUIOptions, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                hostedUIOptions = showingUI.hostedUIOptions;
            }
            return showingUI.copy(hostedUIOptions);
        }

        public final HostedUIOptions component1() {
            return this.hostedUIOptions;
        }

        public final ShowingUI copy(HostedUIOptions hostedUIOptions) {
            Intrinsics.checkNotNullParameter(hostedUIOptions, "hostedUIOptions");
            return new ShowingUI(hostedUIOptions);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ShowingUI) && Intrinsics.areEqual(this.hostedUIOptions, ((ShowingUI) obj).hostedUIOptions)) {
                return true;
            }
            return false;
        }

        public final HostedUIOptions getHostedUIOptions() {
            return this.hostedUIOptions;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.hostedUIOptions.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "ShowingUI(hostedUIOptions=" + this.hostedUIOptions + ')';
        }
    }

    public /* synthetic */ HostedUISignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private HostedUISignInState() {
    }
}
