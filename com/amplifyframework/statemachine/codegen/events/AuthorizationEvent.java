package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.FederatedToken;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationEvent.kt */
/* loaded from: classes.dex */
public final class AuthorizationEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: AuthorizationEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class CachedCredentialsAvailable extends EventType {
            private final AmplifyCredential amplifyCredential;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CachedCredentialsAvailable(AmplifyCredential amplifyCredential) {
                super(null);
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                this.amplifyCredential = amplifyCredential;
            }

            public static /* synthetic */ CachedCredentialsAvailable copy$default(CachedCredentialsAvailable cachedCredentialsAvailable, AmplifyCredential amplifyCredential, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    amplifyCredential = cachedCredentialsAvailable.amplifyCredential;
                }
                return cachedCredentialsAvailable.copy(amplifyCredential);
            }

            public final AmplifyCredential component1() {
                return this.amplifyCredential;
            }

            public final CachedCredentialsAvailable copy(AmplifyCredential amplifyCredential) {
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                return new CachedCredentialsAvailable(amplifyCredential);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof CachedCredentialsAvailable) && Intrinsics.areEqual(this.amplifyCredential, ((CachedCredentialsAvailable) obj).amplifyCredential)) {
                    return true;
                }
                return false;
            }

            public final AmplifyCredential getAmplifyCredential() {
                return this.amplifyCredential;
            }

            public int hashCode() {
                return this.amplifyCredential.hashCode();
            }

            public String toString() {
                return "CachedCredentialsAvailable(amplifyCredential=" + this.amplifyCredential + ')';
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class Configure extends EventType {
            public static final Configure INSTANCE = new Configure();

            private Configure() {
                super(null);
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class FetchAuthSession extends EventType {
            public static final FetchAuthSession INSTANCE = new FetchAuthSession();

            private FetchAuthSession() {
                super(null);
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class FetchUnAuthSession extends EventType {
            public static final FetchUnAuthSession INSTANCE = new FetchUnAuthSession();

            private FetchUnAuthSession() {
                super(null);
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class Fetched extends EventType {
            private final AWSCredentials awsCredentials;
            private final String identityId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fetched(String identityId, AWSCredentials awsCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(identityId, "identityId");
                Intrinsics.checkNotNullParameter(awsCredentials, "awsCredentials");
                this.identityId = identityId;
                this.awsCredentials = awsCredentials;
            }

            public static /* synthetic */ Fetched copy$default(Fetched fetched, String str, AWSCredentials aWSCredentials, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = fetched.identityId;
                }
                if ((r3 & 2) != 0) {
                    aWSCredentials = fetched.awsCredentials;
                }
                return fetched.copy(str, aWSCredentials);
            }

            public final String component1() {
                return this.identityId;
            }

            public final AWSCredentials component2() {
                return this.awsCredentials;
            }

            public final Fetched copy(String identityId, AWSCredentials awsCredentials) {
                Intrinsics.checkNotNullParameter(identityId, "identityId");
                Intrinsics.checkNotNullParameter(awsCredentials, "awsCredentials");
                return new Fetched(identityId, awsCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Fetched)) {
                    return false;
                }
                Fetched fetched = (Fetched) obj;
                if (Intrinsics.areEqual(this.identityId, fetched.identityId) && Intrinsics.areEqual(this.awsCredentials, fetched.awsCredentials)) {
                    return true;
                }
                return false;
            }

            public final AWSCredentials getAwsCredentials() {
                return this.awsCredentials;
            }

            public final String getIdentityId() {
                return this.identityId;
            }

            public int hashCode() {
                return this.awsCredentials.hashCode() + (this.identityId.hashCode() * 31);
            }

            public String toString() {
                return "Fetched(identityId=" + this.identityId + ", awsCredentials=" + this.awsCredentials + ')';
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class RefreshSession extends EventType {
            private final AmplifyCredential amplifyCredential;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshSession(AmplifyCredential amplifyCredential) {
                super(null);
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                this.amplifyCredential = amplifyCredential;
            }

            public static /* synthetic */ RefreshSession copy$default(RefreshSession refreshSession, AmplifyCredential amplifyCredential, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    amplifyCredential = refreshSession.amplifyCredential;
                }
                return refreshSession.copy(amplifyCredential);
            }

            public final AmplifyCredential component1() {
                return this.amplifyCredential;
            }

            public final RefreshSession copy(AmplifyCredential amplifyCredential) {
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                return new RefreshSession(amplifyCredential);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof RefreshSession) && Intrinsics.areEqual(this.amplifyCredential, ((RefreshSession) obj).amplifyCredential)) {
                    return true;
                }
                return false;
            }

            public final AmplifyCredential getAmplifyCredential() {
                return this.amplifyCredential;
            }

            public int hashCode() {
                return this.amplifyCredential.hashCode();
            }

            public String toString() {
                return "RefreshSession(amplifyCredential=" + this.amplifyCredential + ')';
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class Refreshed extends EventType {
            private final AmplifyCredential amplifyCredential;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Refreshed(AmplifyCredential amplifyCredential) {
                super(null);
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                this.amplifyCredential = amplifyCredential;
            }

            public static /* synthetic */ Refreshed copy$default(Refreshed refreshed, AmplifyCredential amplifyCredential, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    amplifyCredential = refreshed.amplifyCredential;
                }
                return refreshed.copy(amplifyCredential);
            }

            public final AmplifyCredential component1() {
                return this.amplifyCredential;
            }

            public final Refreshed copy(AmplifyCredential amplifyCredential) {
                Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
                return new Refreshed(amplifyCredential);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Refreshed) && Intrinsics.areEqual(this.amplifyCredential, ((Refreshed) obj).amplifyCredential)) {
                    return true;
                }
                return false;
            }

            public final AmplifyCredential getAmplifyCredential() {
                return this.amplifyCredential;
            }

            public int hashCode() {
                return this.amplifyCredential.hashCode();
            }

            public String toString() {
                return "Refreshed(amplifyCredential=" + this.amplifyCredential + ')';
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class StartFederationToIdentityPool extends EventType {
            private final AmplifyCredential existingCredential;
            private final String identityId;
            private final FederatedToken token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartFederationToIdentityPool(FederatedToken token, String str, AmplifyCredential amplifyCredential) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                this.token = token;
                this.identityId = str;
                this.existingCredential = amplifyCredential;
            }

            public static /* synthetic */ StartFederationToIdentityPool copy$default(StartFederationToIdentityPool startFederationToIdentityPool, FederatedToken federatedToken, String str, AmplifyCredential amplifyCredential, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    federatedToken = startFederationToIdentityPool.token;
                }
                if ((r4 & 2) != 0) {
                    str = startFederationToIdentityPool.identityId;
                }
                if ((r4 & 4) != 0) {
                    amplifyCredential = startFederationToIdentityPool.existingCredential;
                }
                return startFederationToIdentityPool.copy(federatedToken, str, amplifyCredential);
            }

            public final FederatedToken component1() {
                return this.token;
            }

            public final String component2() {
                return this.identityId;
            }

            public final AmplifyCredential component3() {
                return this.existingCredential;
            }

            public final StartFederationToIdentityPool copy(FederatedToken token, String str, AmplifyCredential amplifyCredential) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new StartFederationToIdentityPool(token, str, amplifyCredential);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof StartFederationToIdentityPool)) {
                    return false;
                }
                StartFederationToIdentityPool startFederationToIdentityPool = (StartFederationToIdentityPool) obj;
                if (Intrinsics.areEqual(this.token, startFederationToIdentityPool.token) && Intrinsics.areEqual(this.identityId, startFederationToIdentityPool.identityId) && Intrinsics.areEqual(this.existingCredential, startFederationToIdentityPool.existingCredential)) {
                    return true;
                }
                return false;
            }

            public final AmplifyCredential getExistingCredential() {
                return this.existingCredential;
            }

            public final String getIdentityId() {
                return this.identityId;
            }

            public final FederatedToken getToken() {
                return this.token;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = this.token.hashCode() * 31;
                String str = this.identityId;
                int r2 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int r0 = (hashCode2 + hashCode) * 31;
                AmplifyCredential amplifyCredential = this.existingCredential;
                if (amplifyCredential != null) {
                    r2 = amplifyCredential.hashCode();
                }
                return r0 + r2;
            }

            public String toString() {
                return "StartFederationToIdentityPool(token=" + this.token + ", identityId=" + this.identityId + ", existingCredential=" + this.existingCredential + ')';
            }
        }

        /* compiled from: AuthorizationEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowError extends EventType {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowError(Exception exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public static /* synthetic */ ThrowError copy$default(ThrowError throwError, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = throwError.exception;
                }
                return throwError.copy(exc);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final ThrowError copy(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowError(exception);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowError) && Intrinsics.areEqual(this.exception, ((ThrowError) obj).exception)) {
                    return true;
                }
                return false;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("ThrowError(exception="), this.exception, ')');
            }
        }

        /* compiled from: AuthorizationEvent.kt */
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

    public AuthorizationEvent(EventType eventType, Date date) {
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

    public /* synthetic */ AuthorizationEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
