package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceSRPSignInEvent.kt */
/* loaded from: classes.dex */
public final class DeviceSRPSignInEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: DeviceSRPSignInEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: DeviceSRPSignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class FinalizeSignIn extends EventType {
            private final String id;

            public FinalizeSignIn() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ FinalizeSignIn copy$default(FinalizeSignIn finalizeSignIn, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = finalizeSignIn.id;
                }
                return finalizeSignIn.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final FinalizeSignIn copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new FinalizeSignIn(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof FinalizeSignIn) && Intrinsics.areEqual(this.id, ((FinalizeSignIn) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FinalizeSignIn(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FinalizeSignIn(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ FinalizeSignIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: DeviceSRPSignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class RespondDevicePasswordVerifier extends EventType {
            private final Map<String, String> challengeParameters;
            private final Map<String, String> metadata;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RespondDevicePasswordVerifier(Map<String, String> challengeParameters, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(challengeParameters, "challengeParameters");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.challengeParameters = challengeParameters;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RespondDevicePasswordVerifier copy$default(RespondDevicePasswordVerifier respondDevicePasswordVerifier, Map map, Map map2, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    map = respondDevicePasswordVerifier.challengeParameters;
                }
                if ((r3 & 2) != 0) {
                    map2 = respondDevicePasswordVerifier.metadata;
                }
                return respondDevicePasswordVerifier.copy(map, map2);
            }

            public final Map<String, String> component1() {
                return this.challengeParameters;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final RespondDevicePasswordVerifier copy(Map<String, String> challengeParameters, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(challengeParameters, "challengeParameters");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new RespondDevicePasswordVerifier(challengeParameters, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RespondDevicePasswordVerifier)) {
                    return false;
                }
                RespondDevicePasswordVerifier respondDevicePasswordVerifier = (RespondDevicePasswordVerifier) obj;
                if (Intrinsics.areEqual(this.challengeParameters, respondDevicePasswordVerifier.challengeParameters) && Intrinsics.areEqual(this.metadata, respondDevicePasswordVerifier.metadata)) {
                    return true;
                }
                return false;
            }

            public final Map<String, String> getChallengeParameters() {
                return this.challengeParameters;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public int hashCode() {
                return this.metadata.hashCode() + (this.challengeParameters.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("RespondDevicePasswordVerifier(challengeParameters=");
                sb.append(this.challengeParameters);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: DeviceSRPSignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class RespondDeviceSRPChallenge extends EventType {
            private final Map<String, String> metadata;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RespondDeviceSRPChallenge(String username, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RespondDeviceSRPChallenge copy$default(RespondDeviceSRPChallenge respondDeviceSRPChallenge, String str, Map map, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = respondDeviceSRPChallenge.username;
                }
                if ((r3 & 2) != 0) {
                    map = respondDeviceSRPChallenge.metadata;
                }
                return respondDeviceSRPChallenge.copy(str, map);
            }

            public final String component1() {
                return this.username;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final RespondDeviceSRPChallenge copy(String username, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new RespondDeviceSRPChallenge(username, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RespondDeviceSRPChallenge)) {
                    return false;
                }
                RespondDeviceSRPChallenge respondDeviceSRPChallenge = (RespondDeviceSRPChallenge) obj;
                if (Intrinsics.areEqual(this.username, respondDeviceSRPChallenge.username) && Intrinsics.areEqual(this.metadata, respondDeviceSRPChallenge.metadata)) {
                    return true;
                }
                return false;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                return this.metadata.hashCode() + (this.username.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("RespondDeviceSRPChallenge(username=");
                sb.append(this.username);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: DeviceSRPSignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowAuthError extends EventType {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowAuthError(Exception exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public static /* synthetic */ ThrowAuthError copy$default(ThrowAuthError throwAuthError, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = throwAuthError.exception;
                }
                return throwAuthError.copy(exc);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final ThrowAuthError copy(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowAuthError(exception);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowAuthError) && Intrinsics.areEqual(this.exception, ((ThrowAuthError) obj).exception)) {
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
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("ThrowAuthError(exception="), this.exception, ')');
            }
        }

        /* compiled from: DeviceSRPSignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowPasswordVerifiedError extends EventType {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowPasswordVerifiedError(Exception exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public static /* synthetic */ ThrowPasswordVerifiedError copy$default(ThrowPasswordVerifiedError throwPasswordVerifiedError, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = throwPasswordVerifiedError.exception;
                }
                return throwPasswordVerifiedError.copy(exc);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final ThrowPasswordVerifiedError copy(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowPasswordVerifiedError(exception);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowPasswordVerifiedError) && Intrinsics.areEqual(this.exception, ((ThrowPasswordVerifiedError) obj).exception)) {
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
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("ThrowPasswordVerifiedError(exception="), this.exception, ')');
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public DeviceSRPSignInEvent(EventType eventType, Date date) {
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

    public /* synthetic */ DeviceSRPSignInEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
