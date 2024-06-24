package com.amplifyframework.statemachine.codegen.events;

import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RefreshSessionEvent.kt */
/* loaded from: classes.dex */
public final class RefreshSessionEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: RefreshSessionEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: RefreshSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class RefreshAuthSession extends EventType {
            private final LoginsMapProvider logins;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshAuthSession(SignedInData signedInData, LoginsMapProvider logins) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(logins, "logins");
                this.signedInData = signedInData;
                this.logins = logins;
            }

            public static /* synthetic */ RefreshAuthSession copy$default(RefreshAuthSession refreshAuthSession, SignedInData signedInData, LoginsMapProvider loginsMapProvider, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signedInData = refreshAuthSession.signedInData;
                }
                if ((r3 & 2) != 0) {
                    loginsMapProvider = refreshAuthSession.logins;
                }
                return refreshAuthSession.copy(signedInData, loginsMapProvider);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final LoginsMapProvider component2() {
                return this.logins;
            }

            public final RefreshAuthSession copy(SignedInData signedInData, LoginsMapProvider logins) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(logins, "logins");
                return new RefreshAuthSession(signedInData, logins);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RefreshAuthSession)) {
                    return false;
                }
                RefreshAuthSession refreshAuthSession = (RefreshAuthSession) obj;
                if (Intrinsics.areEqual(this.signedInData, refreshAuthSession.signedInData) && Intrinsics.areEqual(this.logins, refreshAuthSession.logins)) {
                    return true;
                }
                return false;
            }

            public final LoginsMapProvider getLogins() {
                return this.logins;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.logins.hashCode() + (this.signedInData.hashCode() * 31);
            }

            public String toString() {
                return "RefreshAuthSession(signedInData=" + this.signedInData + ", logins=" + this.logins + ')';
            }
        }

        /* compiled from: RefreshSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class RefreshUnAuthSession extends EventType {
            private final LoginsMapProvider logins;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshUnAuthSession(LoginsMapProvider logins) {
                super(null);
                Intrinsics.checkNotNullParameter(logins, "logins");
                this.logins = logins;
            }

            public static /* synthetic */ RefreshUnAuthSession copy$default(RefreshUnAuthSession refreshUnAuthSession, LoginsMapProvider loginsMapProvider, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    loginsMapProvider = refreshUnAuthSession.logins;
                }
                return refreshUnAuthSession.copy(loginsMapProvider);
            }

            public final LoginsMapProvider component1() {
                return this.logins;
            }

            public final RefreshUnAuthSession copy(LoginsMapProvider logins) {
                Intrinsics.checkNotNullParameter(logins, "logins");
                return new RefreshUnAuthSession(logins);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof RefreshUnAuthSession) && Intrinsics.areEqual(this.logins, ((RefreshUnAuthSession) obj).logins)) {
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
                return "RefreshUnAuthSession(logins=" + this.logins + ')';
            }
        }

        /* compiled from: RefreshSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class RefreshUserPoolTokens extends EventType {
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshUserPoolTokens(SignedInData signedInData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
            }

            public static /* synthetic */ RefreshUserPoolTokens copy$default(RefreshUserPoolTokens refreshUserPoolTokens, SignedInData signedInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signedInData = refreshUserPoolTokens.signedInData;
                }
                return refreshUserPoolTokens.copy(signedInData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final RefreshUserPoolTokens copy(SignedInData signedInData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new RefreshUserPoolTokens(signedInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof RefreshUserPoolTokens) && Intrinsics.areEqual(this.signedInData, ((RefreshUserPoolTokens) obj).signedInData)) {
                    return true;
                }
                return false;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.signedInData.hashCode();
            }

            public String toString() {
                return "RefreshUserPoolTokens(signedInData=" + this.signedInData + ')';
            }
        }

        /* compiled from: RefreshSessionEvent.kt */
        /* loaded from: classes.dex */
        public static final class Refreshed extends EventType {
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Refreshed(SignedInData signedInData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
            }

            public static /* synthetic */ Refreshed copy$default(Refreshed refreshed, SignedInData signedInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signedInData = refreshed.signedInData;
                }
                return refreshed.copy(signedInData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final Refreshed copy(SignedInData signedInData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new Refreshed(signedInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Refreshed) && Intrinsics.areEqual(this.signedInData, ((Refreshed) obj).signedInData)) {
                    return true;
                }
                return false;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.signedInData.hashCode();
            }

            public String toString() {
                return "Refreshed(signedInData=" + this.signedInData + ')';
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public RefreshSessionEvent(EventType eventType, Date date) {
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

    public /* synthetic */ RefreshSessionEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
