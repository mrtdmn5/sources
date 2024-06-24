package com.amplifyframework.statemachine.codegen.events;

import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchAuthSessionEvent.kt */
/* loaded from: classes.dex */
public final class FetchAuthSessionEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: FetchAuthSessionEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: FetchAuthSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class FetchAwsCredentials extends EventType {
            private final String identityId;
            private final LoginsMapProvider logins;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchAwsCredentials(String identityId, LoginsMapProvider logins) {
                super(null);
                Intrinsics.checkNotNullParameter(identityId, "identityId");
                Intrinsics.checkNotNullParameter(logins, "logins");
                this.identityId = identityId;
                this.logins = logins;
            }

            public static /* synthetic */ FetchAwsCredentials copy$default(FetchAwsCredentials fetchAwsCredentials, String str, LoginsMapProvider loginsMapProvider, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = fetchAwsCredentials.identityId;
                }
                if ((r3 & 2) != 0) {
                    loginsMapProvider = fetchAwsCredentials.logins;
                }
                return fetchAwsCredentials.copy(str, loginsMapProvider);
            }

            public final String component1() {
                return this.identityId;
            }

            public final LoginsMapProvider component2() {
                return this.logins;
            }

            public final FetchAwsCredentials copy(String identityId, LoginsMapProvider logins) {
                Intrinsics.checkNotNullParameter(identityId, "identityId");
                Intrinsics.checkNotNullParameter(logins, "logins");
                return new FetchAwsCredentials(identityId, logins);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FetchAwsCredentials)) {
                    return false;
                }
                FetchAwsCredentials fetchAwsCredentials = (FetchAwsCredentials) obj;
                if (Intrinsics.areEqual(this.identityId, fetchAwsCredentials.identityId) && Intrinsics.areEqual(this.logins, fetchAwsCredentials.logins)) {
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

            public int hashCode() {
                return this.logins.hashCode() + (this.identityId.hashCode() * 31);
            }

            public String toString() {
                return "FetchAwsCredentials(identityId=" + this.identityId + ", logins=" + this.logins + ')';
            }
        }

        /* compiled from: FetchAuthSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class FetchIdentity extends EventType {
            private final LoginsMapProvider logins;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchIdentity(LoginsMapProvider logins) {
                super(null);
                Intrinsics.checkNotNullParameter(logins, "logins");
                this.logins = logins;
            }

            public static /* synthetic */ FetchIdentity copy$default(FetchIdentity fetchIdentity, LoginsMapProvider loginsMapProvider, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    loginsMapProvider = fetchIdentity.logins;
                }
                return fetchIdentity.copy(loginsMapProvider);
            }

            public final LoginsMapProvider component1() {
                return this.logins;
            }

            public final FetchIdentity copy(LoginsMapProvider logins) {
                Intrinsics.checkNotNullParameter(logins, "logins");
                return new FetchIdentity(logins);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof FetchIdentity) && Intrinsics.areEqual(this.logins, ((FetchIdentity) obj).logins)) {
                    return true;
                }
                return false;
            }

            public final LoginsMapProvider getLogins() {
                return this.logins;
            }

            public int hashCode() {
                return this.logins.hashCode();
            }

            public String toString() {
                return "FetchIdentity(logins=" + this.logins + ')';
            }
        }

        /* compiled from: FetchAuthSessionEvent.kt */
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

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public FetchAuthSessionEvent(EventType eventType, Date date) {
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

    public /* synthetic */ FetchAuthSessionEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
