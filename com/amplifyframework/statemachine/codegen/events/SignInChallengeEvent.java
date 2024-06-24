package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInChallengeEvent.kt */
/* loaded from: classes.dex */
public final class SignInChallengeEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: SignInChallengeEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: SignInChallengeEvent.kt */
        /* loaded from: classes.dex */
        public static final class FinalizeSignIn extends EventType {
            private final String accessToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FinalizeSignIn(String accessToken) {
                super(null);
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                this.accessToken = accessToken;
            }

            public static /* synthetic */ FinalizeSignIn copy$default(FinalizeSignIn finalizeSignIn, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = finalizeSignIn.accessToken;
                }
                return finalizeSignIn.copy(str);
            }

            public final String component1() {
                return this.accessToken;
            }

            public final FinalizeSignIn copy(String accessToken) {
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                return new FinalizeSignIn(accessToken);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof FinalizeSignIn) && Intrinsics.areEqual(this.accessToken, ((FinalizeSignIn) obj).accessToken)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FinalizeSignIn(accessToken="), this.accessToken, ')');
            }
        }

        /* compiled from: SignInChallengeEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowError extends EventType {
            private final AuthChallenge challenge;
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowError(Exception exception, AuthChallenge challenge) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                this.exception = exception;
                this.challenge = challenge;
            }

            public static /* synthetic */ ThrowError copy$default(ThrowError throwError, Exception exc, AuthChallenge authChallenge, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    exc = throwError.exception;
                }
                if ((r3 & 2) != 0) {
                    authChallenge = throwError.challenge;
                }
                return throwError.copy(exc, authChallenge);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final AuthChallenge component2() {
                return this.challenge;
            }

            public final ThrowError copy(Exception exception, AuthChallenge challenge) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                return new ThrowError(exception, challenge);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ThrowError)) {
                    return false;
                }
                ThrowError throwError = (ThrowError) obj;
                if (Intrinsics.areEqual(this.exception, throwError.exception) && Intrinsics.areEqual(this.challenge, throwError.challenge)) {
                    return true;
                }
                return false;
            }

            public final AuthChallenge getChallenge() {
                return this.challenge;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                return this.challenge.hashCode() + (this.exception.hashCode() * 31);
            }

            public String toString() {
                return "ThrowError(exception=" + this.exception + ", challenge=" + this.challenge + ')';
            }
        }

        /* compiled from: SignInChallengeEvent.kt */
        /* loaded from: classes.dex */
        public static final class Verified extends EventType {
            private final String id;

            public Verified() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Verified copy$default(Verified verified, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = verified.id;
                }
                return verified.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final Verified copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new Verified(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Verified) && Intrinsics.areEqual(this.id, ((Verified) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Verified(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Verified(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ Verified(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: SignInChallengeEvent.kt */
        /* loaded from: classes.dex */
        public static final class VerifyChallengeAnswer extends EventType {
            private final String answer;
            private final Map<String, String> metadata;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VerifyChallengeAnswer(String answer, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(answer, "answer");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.answer = answer;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ VerifyChallengeAnswer copy$default(VerifyChallengeAnswer verifyChallengeAnswer, String str, Map map, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = verifyChallengeAnswer.answer;
                }
                if ((r3 & 2) != 0) {
                    map = verifyChallengeAnswer.metadata;
                }
                return verifyChallengeAnswer.copy(str, map);
            }

            public final String component1() {
                return this.answer;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final VerifyChallengeAnswer copy(String answer, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(answer, "answer");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new VerifyChallengeAnswer(answer, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof VerifyChallengeAnswer)) {
                    return false;
                }
                VerifyChallengeAnswer verifyChallengeAnswer = (VerifyChallengeAnswer) obj;
                if (Intrinsics.areEqual(this.answer, verifyChallengeAnswer.answer) && Intrinsics.areEqual(this.metadata, verifyChallengeAnswer.metadata)) {
                    return true;
                }
                return false;
            }

            public final String getAnswer() {
                return this.answer;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public int hashCode() {
                return this.metadata.hashCode() + (this.answer.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("VerifyChallengeAnswer(answer=");
                sb.append(this.answer);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInChallengeEvent.kt */
        /* loaded from: classes.dex */
        public static final class WaitForAnswer extends EventType {
            private final AuthChallenge challenge;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WaitForAnswer(AuthChallenge challenge) {
                super(null);
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                this.challenge = challenge;
            }

            public static /* synthetic */ WaitForAnswer copy$default(WaitForAnswer waitForAnswer, AuthChallenge authChallenge, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    authChallenge = waitForAnswer.challenge;
                }
                return waitForAnswer.copy(authChallenge);
            }

            public final AuthChallenge component1() {
                return this.challenge;
            }

            public final WaitForAnswer copy(AuthChallenge challenge) {
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                return new WaitForAnswer(challenge);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof WaitForAnswer) && Intrinsics.areEqual(this.challenge, ((WaitForAnswer) obj).challenge)) {
                    return true;
                }
                return false;
            }

            public final AuthChallenge getChallenge() {
                return this.challenge;
            }

            public int hashCode() {
                return this.challenge.hashCode();
            }

            public String toString() {
                return "WaitForAnswer(challenge=" + this.challenge + ')';
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public SignInChallengeEvent(EventType eventType, Date date) {
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

    public /* synthetic */ SignInChallengeEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
