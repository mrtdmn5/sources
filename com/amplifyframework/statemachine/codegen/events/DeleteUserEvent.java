package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteUserEvent.kt */
/* loaded from: classes.dex */
public final class DeleteUserEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: DeleteUserEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: DeleteUserEvent.kt */
        /* loaded from: classes.dex */
        public static final class DeleteUser extends EventType {
            private final String accessToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeleteUser(String accessToken) {
                super(null);
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                this.accessToken = accessToken;
            }

            public static /* synthetic */ DeleteUser copy$default(DeleteUser deleteUser, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = deleteUser.accessToken;
                }
                return deleteUser.copy(str);
            }

            public final String component1() {
                return this.accessToken;
            }

            public final DeleteUser copy(String accessToken) {
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                return new DeleteUser(accessToken);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof DeleteUser) && Intrinsics.areEqual(this.accessToken, ((DeleteUser) obj).accessToken)) {
                    return true;
                }
                return false;
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public int hashCode() {
                return this.accessToken.hashCode();
            }

            public String toString() {
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("DeleteUser(accessToken="), this.accessToken, ')');
            }
        }

        /* compiled from: DeleteUserEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowError extends EventType {
            private final Exception exception;
            private final boolean signOutUser;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowError(Exception exception, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
                this.signOutUser = z;
            }

            public static /* synthetic */ ThrowError copy$default(ThrowError throwError, Exception exc, boolean z, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    exc = throwError.exception;
                }
                if ((r3 & 2) != 0) {
                    z = throwError.signOutUser;
                }
                return throwError.copy(exc, z);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final boolean component2() {
                return this.signOutUser;
            }

            public final ThrowError copy(Exception exception, boolean z) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowError(exception, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ThrowError)) {
                    return false;
                }
                ThrowError throwError = (ThrowError) obj;
                if (Intrinsics.areEqual(this.exception, throwError.exception) && this.signOutUser == throwError.signOutUser) {
                    return true;
                }
                return false;
            }

            public final Exception getException() {
                return this.exception;
            }

            public final boolean getSignOutUser() {
                return this.signOutUser;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = this.exception.hashCode() * 31;
                boolean z = this.signOutUser;
                int r1 = z;
                if (z != 0) {
                    r1 = 1;
                }
                return hashCode + r1;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("ThrowError(exception=");
                sb.append(this.exception);
                sb.append(", signOutUser=");
                return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.signOutUser, ')');
            }
        }

        /* compiled from: DeleteUserEvent.kt */
        /* loaded from: classes.dex */
        public static final class UserDeleted extends EventType {
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

            public int hashCode() {
                return this.id.hashCode();
            }

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

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public DeleteUserEvent(EventType eventType, Date date) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.time = date;
        this.type = eventType.getClass().getSimpleName();
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public String getId() {
        return StateMachineEvent.DefaultImpls.getId(this);
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public Date getTime() {
        return this.time;
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public String getType() {
        return this.type;
    }

    public /* synthetic */ DeleteUserEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
