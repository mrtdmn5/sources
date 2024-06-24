package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SRPEvent.kt */
/* loaded from: classes.dex */
public final class SRPEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: SRPEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class CancelSRPSignIn extends EventType {
            private final String id;

            public CancelSRPSignIn() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ CancelSRPSignIn copy$default(CancelSRPSignIn cancelSRPSignIn, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = cancelSRPSignIn.id;
                }
                return cancelSRPSignIn.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final CancelSRPSignIn copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new CancelSRPSignIn(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof CancelSRPSignIn) && Intrinsics.areEqual(this.id, ((CancelSRPSignIn) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("CancelSRPSignIn(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CancelSRPSignIn(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ CancelSRPSignIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateSRP extends EventType {
            private final Map<String, String> metadata;
            private final String password;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateSRP(String username, String password, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.password = password;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateSRP copy$default(InitiateSRP initiateSRP, String str, String str2, Map map, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = initiateSRP.username;
                }
                if ((r4 & 2) != 0) {
                    str2 = initiateSRP.password;
                }
                if ((r4 & 4) != 0) {
                    map = initiateSRP.metadata;
                }
                return initiateSRP.copy(str, str2, map);
            }

            public final String component1() {
                return this.username;
            }

            public final String component2() {
                return this.password;
            }

            public final Map<String, String> component3() {
                return this.metadata;
            }

            public final InitiateSRP copy(String username, String password, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateSRP(username, password, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateSRP)) {
                    return false;
                }
                InitiateSRP initiateSRP = (InitiateSRP) obj;
                if (Intrinsics.areEqual(this.username, initiateSRP.username) && Intrinsics.areEqual(this.password, initiateSRP.password) && Intrinsics.areEqual(this.metadata, initiateSRP.metadata)) {
                    return true;
                }
                return false;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public final String getPassword() {
                return this.password;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                return this.metadata.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.password, this.username.hashCode() * 31, 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("InitiateSRP(username=");
                sb.append(this.username);
                sb.append(", password=");
                sb.append(this.password);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateSRPWithCustom extends EventType {
            private final Map<String, String> metadata;
            private final String password;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateSRPWithCustom(String username, String password, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.password = password;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateSRPWithCustom copy$default(InitiateSRPWithCustom initiateSRPWithCustom, String str, String str2, Map map, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = initiateSRPWithCustom.username;
                }
                if ((r4 & 2) != 0) {
                    str2 = initiateSRPWithCustom.password;
                }
                if ((r4 & 4) != 0) {
                    map = initiateSRPWithCustom.metadata;
                }
                return initiateSRPWithCustom.copy(str, str2, map);
            }

            public final String component1() {
                return this.username;
            }

            public final String component2() {
                return this.password;
            }

            public final Map<String, String> component3() {
                return this.metadata;
            }

            public final InitiateSRPWithCustom copy(String username, String password, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateSRPWithCustom(username, password, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateSRPWithCustom)) {
                    return false;
                }
                InitiateSRPWithCustom initiateSRPWithCustom = (InitiateSRPWithCustom) obj;
                if (Intrinsics.areEqual(this.username, initiateSRPWithCustom.username) && Intrinsics.areEqual(this.password, initiateSRPWithCustom.password) && Intrinsics.areEqual(this.metadata, initiateSRPWithCustom.metadata)) {
                    return true;
                }
                return false;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public final String getPassword() {
                return this.password;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                return this.metadata.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.password, this.username.hashCode() * 31, 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("InitiateSRPWithCustom(username=");
                sb.append(this.username);
                sb.append(", password=");
                sb.append(this.password);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class Reset extends EventType {
            private final String id;

            public Reset() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Reset copy$default(Reset reset, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = reset.id;
                }
                return reset.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final Reset copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new Reset(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Reset) && Intrinsics.areEqual(this.id, ((Reset) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Reset(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Reset(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ Reset(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class RespondPasswordVerifier extends EventType {
            private final Map<String, String> challengeParameters;
            private final Map<String, String> metadata;
            private final String session;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RespondPasswordVerifier(Map<String, String> challengeParameters, Map<String, String> metadata, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(challengeParameters, "challengeParameters");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.challengeParameters = challengeParameters;
                this.metadata = metadata;
                this.session = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RespondPasswordVerifier copy$default(RespondPasswordVerifier respondPasswordVerifier, Map map, Map map2, String str, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    map = respondPasswordVerifier.challengeParameters;
                }
                if ((r4 & 2) != 0) {
                    map2 = respondPasswordVerifier.metadata;
                }
                if ((r4 & 4) != 0) {
                    str = respondPasswordVerifier.session;
                }
                return respondPasswordVerifier.copy(map, map2, str);
            }

            public final Map<String, String> component1() {
                return this.challengeParameters;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final String component3() {
                return this.session;
            }

            public final RespondPasswordVerifier copy(Map<String, String> challengeParameters, Map<String, String> metadata, String str) {
                Intrinsics.checkNotNullParameter(challengeParameters, "challengeParameters");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new RespondPasswordVerifier(challengeParameters, metadata, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RespondPasswordVerifier)) {
                    return false;
                }
                RespondPasswordVerifier respondPasswordVerifier = (RespondPasswordVerifier) obj;
                if (Intrinsics.areEqual(this.challengeParameters, respondPasswordVerifier.challengeParameters) && Intrinsics.areEqual(this.metadata, respondPasswordVerifier.metadata) && Intrinsics.areEqual(this.session, respondPasswordVerifier.session)) {
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

            public final String getSession() {
                return this.session;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = (this.metadata.hashCode() + (this.challengeParameters.hashCode() * 31)) * 31;
                String str = this.session;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return hashCode2 + hashCode;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("RespondPasswordVerifier(challengeParameters=");
                sb.append(this.challengeParameters);
                sb.append(", metadata=");
                sb.append(this.metadata);
                sb.append(", session=");
                return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.session, ')');
            }
        }

        /* compiled from: SRPEvent.kt */
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

        /* compiled from: SRPEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowPasswordVerifierError extends EventType {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowPasswordVerifierError(Exception exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public static /* synthetic */ ThrowPasswordVerifierError copy$default(ThrowPasswordVerifierError throwPasswordVerifierError, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = throwPasswordVerifierError.exception;
                }
                return throwPasswordVerifierError.copy(exc);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final ThrowPasswordVerifierError copy(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowPasswordVerifierError(exception);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowPasswordVerifierError) && Intrinsics.areEqual(this.exception, ((ThrowPasswordVerifierError) obj).exception)) {
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
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("ThrowPasswordVerifierError(exception="), this.exception, ')');
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public SRPEvent(EventType eventType, Date date) {
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

    public /* synthetic */ SRPEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
