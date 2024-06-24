package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.DeleteUserActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.DeleteUserEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteUserState.kt */
/* loaded from: classes.dex */
public abstract class DeleteUserState implements State {

    /* compiled from: DeleteUserState.kt */
    /* loaded from: classes.dex */
    public static final class DeletingUser extends DeleteUserState {
        private final String id;

        public DeletingUser() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DeletingUser copy$default(DeletingUser deletingUser, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = deletingUser.id;
            }
            return deletingUser.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final DeletingUser copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new DeletingUser(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DeletingUser) && Intrinsics.areEqual(this.id, ((DeletingUser) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("DeletingUser(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeletingUser(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ DeletingUser(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: DeleteUserState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends DeleteUserState {
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

    /* compiled from: DeleteUserState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends DeleteUserState {
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

    /* compiled from: DeleteUserState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<DeleteUserState> {
        private final NotStarted defaultState;
        private final DeleteUserActions deleteUserActions;

        public Resolver(DeleteUserActions deleteUserActions) {
            Intrinsics.checkNotNullParameter(deleteUserActions, "deleteUserActions");
            this.deleteUserActions = deleteUserActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final DeleteUserEvent.EventType asDeleteUserEvent(StateMachineEvent stateMachineEvent) {
            DeleteUserEvent deleteUserEvent;
            if (stateMachineEvent instanceof DeleteUserEvent) {
                deleteUserEvent = (DeleteUserEvent) stateMachineEvent;
            } else {
                deleteUserEvent = null;
            }
            if (deleteUserEvent == null) {
                return null;
            }
            return deleteUserEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<DeleteUserState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<DeleteUserState, StateMachineResolver<DeleteUserState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public DeleteUserState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<DeleteUserState> resolve(DeleteUserState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            DeleteUserEvent.EventType asDeleteUserEvent = asDeleteUserEvent(event);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            if (asDeleteUserEvent == null) {
                return new StateResolution<>(oldState, null, 2, null);
            }
            int r3 = 1;
            if (oldState instanceof NotStarted ? true : oldState instanceof Error) {
                if (asDeleteUserEvent instanceof DeleteUserEvent.EventType.DeleteUser) {
                    return new StateResolution<>(new DeletingUser(str, r3, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.deleteUserActions.initDeleteUserAction(((DeleteUserEvent.EventType.DeleteUser) asDeleteUserEvent).getAccessToken())));
                }
                return new StateResolution<>(oldState, null, 2, null);
            }
            if (oldState instanceof DeletingUser) {
                if (asDeleteUserEvent instanceof DeleteUserEvent.EventType.UserDeleted) {
                    return new StateResolution<>(new UserDeleted(b4 == true ? 1 : 0, r3, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.deleteUserActions.initiateSignOut()));
                }
                if (asDeleteUserEvent instanceof DeleteUserEvent.EventType.ThrowError) {
                    DeleteUserEvent.EventType.ThrowError throwError = (DeleteUserEvent.EventType.ThrowError) asDeleteUserEvent;
                    if (throwError.getSignOutUser()) {
                        return new StateResolution<>(new UserDeleted(b2 == true ? 1 : 0, r3, b == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.deleteUserActions.initiateSignOut()));
                    }
                    return new StateResolution<>(new Error(throwError.getException()), null, 2, null);
                }
                return new StateResolution<>(oldState, null, 2, null);
            }
            return new StateResolution<>(oldState, null, 2, null);
        }
    }

    /* compiled from: DeleteUserState.kt */
    /* loaded from: classes.dex */
    public static final class UserDeleted extends DeleteUserState {
        private final String id;

        public UserDeleted() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ UserDeleted copy$default(UserDeleted userDeleted, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = userDeleted.id;
            }
            return userDeleted.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final UserDeleted copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UserDeleted(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof UserDeleted) && Intrinsics.areEqual(this.id, ((UserDeleted) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("UserDeleted(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserDeleted(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ UserDeleted(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    public /* synthetic */ DeleteUserState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    private DeleteUserState() {
    }
}
