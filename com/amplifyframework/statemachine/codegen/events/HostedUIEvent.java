package com.amplifyframework.statemachine.codegen.events;

import android.net.Uri;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignInData;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIEvent.kt */
/* loaded from: classes.dex */
public final class HostedUIEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: HostedUIEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: HostedUIEvent.kt */
        /* loaded from: classes.dex */
        public static final class FetchToken extends EventType {
            private final Uri uri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchToken(Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
            }

            public static /* synthetic */ FetchToken copy$default(FetchToken fetchToken, Uri uri, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    uri = fetchToken.uri;
                }
                return fetchToken.copy(uri);
            }

            public final Uri component1() {
                return this.uri;
            }

            public final FetchToken copy(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new FetchToken(uri);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof FetchToken) && Intrinsics.areEqual(this.uri, ((FetchToken) obj).uri)) {
                    return true;
                }
                return false;
            }

            public final Uri getUri() {
                return this.uri;
            }

            public int hashCode() {
                return this.uri.hashCode();
            }

            public String toString() {
                return "FetchToken(uri=" + this.uri + ')';
            }
        }

        /* compiled from: HostedUIEvent.kt */
        /* loaded from: classes.dex */
        public static final class ShowHostedUI extends EventType {
            private final SignInData.HostedUISignInData hostedUISignInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowHostedUI(SignInData.HostedUISignInData hostedUISignInData) {
                super(null);
                Intrinsics.checkNotNullParameter(hostedUISignInData, "hostedUISignInData");
                this.hostedUISignInData = hostedUISignInData;
            }

            public static /* synthetic */ ShowHostedUI copy$default(ShowHostedUI showHostedUI, SignInData.HostedUISignInData hostedUISignInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    hostedUISignInData = showHostedUI.hostedUISignInData;
                }
                return showHostedUI.copy(hostedUISignInData);
            }

            public final SignInData.HostedUISignInData component1() {
                return this.hostedUISignInData;
            }

            public final ShowHostedUI copy(SignInData.HostedUISignInData hostedUISignInData) {
                Intrinsics.checkNotNullParameter(hostedUISignInData, "hostedUISignInData");
                return new ShowHostedUI(hostedUISignInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ShowHostedUI) && Intrinsics.areEqual(this.hostedUISignInData, ((ShowHostedUI) obj).hostedUISignInData)) {
                    return true;
                }
                return false;
            }

            public final SignInData.HostedUISignInData getHostedUISignInData() {
                return this.hostedUISignInData;
            }

            public int hashCode() {
                return this.hostedUISignInData.hashCode();
            }

            public String toString() {
                return "ShowHostedUI(hostedUISignInData=" + this.hostedUISignInData + ')';
            }
        }

        /* compiled from: HostedUIEvent.kt */
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

        /* compiled from: HostedUIEvent.kt */
        /* loaded from: classes.dex */
        public static final class TokenFetched extends EventType {
            public static final TokenFetched INSTANCE = new TokenFetched();

            private TokenFetched() {
                super(null);
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public HostedUIEvent(EventType eventType, Date date) {
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

    public /* synthetic */ HostedUIEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
