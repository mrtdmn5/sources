package com.amplifyframework.statemachine.codegen.events;

import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData;
import com.amplifyframework.statemachine.codegen.data.HostedUIErrorData;
import com.amplifyframework.statemachine.codegen.data.RevokeTokenErrorData;
import com.amplifyframework.statemachine.codegen.data.SignOutData;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignOutEvent.kt */
/* loaded from: classes.dex */
public final class SignOutEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: SignOutEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class InvokeHostedUISignOut extends EventType {
            private final SignOutData signOutData;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InvokeHostedUISignOut(SignOutData signOutData, SignedInData signedInData) {
                super(null);
                Intrinsics.checkNotNullParameter(signOutData, "signOutData");
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signOutData = signOutData;
                this.signedInData = signedInData;
            }

            public static /* synthetic */ InvokeHostedUISignOut copy$default(InvokeHostedUISignOut invokeHostedUISignOut, SignOutData signOutData, SignedInData signedInData, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signOutData = invokeHostedUISignOut.signOutData;
                }
                if ((r3 & 2) != 0) {
                    signedInData = invokeHostedUISignOut.signedInData;
                }
                return invokeHostedUISignOut.copy(signOutData, signedInData);
            }

            public final SignOutData component1() {
                return this.signOutData;
            }

            public final SignedInData component2() {
                return this.signedInData;
            }

            public final InvokeHostedUISignOut copy(SignOutData signOutData, SignedInData signedInData) {
                Intrinsics.checkNotNullParameter(signOutData, "signOutData");
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new InvokeHostedUISignOut(signOutData, signedInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InvokeHostedUISignOut)) {
                    return false;
                }
                InvokeHostedUISignOut invokeHostedUISignOut = (InvokeHostedUISignOut) obj;
                if (Intrinsics.areEqual(this.signOutData, invokeHostedUISignOut.signOutData) && Intrinsics.areEqual(this.signedInData, invokeHostedUISignOut.signedInData)) {
                    return true;
                }
                return false;
            }

            public final SignOutData getSignOutData() {
                return this.signOutData;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.signedInData.hashCode() + (this.signOutData.hashCode() * 31);
            }

            public String toString() {
                return "InvokeHostedUISignOut(signOutData=" + this.signOutData + ", signedInData=" + this.signedInData + ')';
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class RevokeToken extends EventType {
            private final GlobalSignOutErrorData globalSignOutErrorData;
            private final HostedUIErrorData hostedUIErrorData;
            private final SignedInData signedInData;

            public /* synthetic */ RevokeToken(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, int r5, DefaultConstructorMarker defaultConstructorMarker) {
                this(signedInData, (r5 & 2) != 0 ? null : hostedUIErrorData, (r5 & 4) != 0 ? null : globalSignOutErrorData);
            }

            public static /* synthetic */ RevokeToken copy$default(RevokeToken revokeToken, SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    signedInData = revokeToken.signedInData;
                }
                if ((r4 & 2) != 0) {
                    hostedUIErrorData = revokeToken.hostedUIErrorData;
                }
                if ((r4 & 4) != 0) {
                    globalSignOutErrorData = revokeToken.globalSignOutErrorData;
                }
                return revokeToken.copy(signedInData, hostedUIErrorData, globalSignOutErrorData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final HostedUIErrorData component2() {
                return this.hostedUIErrorData;
            }

            public final GlobalSignOutErrorData component3() {
                return this.globalSignOutErrorData;
            }

            public final RevokeToken copy(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new RevokeToken(signedInData, hostedUIErrorData, globalSignOutErrorData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RevokeToken)) {
                    return false;
                }
                RevokeToken revokeToken = (RevokeToken) obj;
                if (Intrinsics.areEqual(this.signedInData, revokeToken.signedInData) && Intrinsics.areEqual(this.hostedUIErrorData, revokeToken.hostedUIErrorData) && Intrinsics.areEqual(this.globalSignOutErrorData, revokeToken.globalSignOutErrorData)) {
                    return true;
                }
                return false;
            }

            public final GlobalSignOutErrorData getGlobalSignOutErrorData() {
                return this.globalSignOutErrorData;
            }

            public final HostedUIErrorData getHostedUIErrorData() {
                return this.hostedUIErrorData;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = this.signedInData.hashCode() * 31;
                HostedUIErrorData hostedUIErrorData = this.hostedUIErrorData;
                int r2 = 0;
                if (hostedUIErrorData == null) {
                    hashCode = 0;
                } else {
                    hashCode = hostedUIErrorData.hashCode();
                }
                int r0 = (hashCode2 + hashCode) * 31;
                GlobalSignOutErrorData globalSignOutErrorData = this.globalSignOutErrorData;
                if (globalSignOutErrorData != null) {
                    r2 = globalSignOutErrorData.hashCode();
                }
                return r0 + r2;
            }

            public String toString() {
                return "RevokeToken(signedInData=" + this.signedInData + ", hostedUIErrorData=" + this.hostedUIErrorData + ", globalSignOutErrorData=" + this.globalSignOutErrorData + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RevokeToken(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
                this.hostedUIErrorData = hostedUIErrorData;
                this.globalSignOutErrorData = globalSignOutErrorData;
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignOutGlobally extends EventType {
            private final HostedUIErrorData hostedUIErrorData;
            private final SignedInData signedInData;

            public /* synthetic */ SignOutGlobally(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, int r3, DefaultConstructorMarker defaultConstructorMarker) {
                this(signedInData, (r3 & 2) != 0 ? null : hostedUIErrorData);
            }

            public static /* synthetic */ SignOutGlobally copy$default(SignOutGlobally signOutGlobally, SignedInData signedInData, HostedUIErrorData hostedUIErrorData, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signedInData = signOutGlobally.signedInData;
                }
                if ((r3 & 2) != 0) {
                    hostedUIErrorData = signOutGlobally.hostedUIErrorData;
                }
                return signOutGlobally.copy(signedInData, hostedUIErrorData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final HostedUIErrorData component2() {
                return this.hostedUIErrorData;
            }

            public final SignOutGlobally copy(SignedInData signedInData, HostedUIErrorData hostedUIErrorData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new SignOutGlobally(signedInData, hostedUIErrorData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SignOutGlobally)) {
                    return false;
                }
                SignOutGlobally signOutGlobally = (SignOutGlobally) obj;
                if (Intrinsics.areEqual(this.signedInData, signOutGlobally.signedInData) && Intrinsics.areEqual(this.hostedUIErrorData, signOutGlobally.hostedUIErrorData)) {
                    return true;
                }
                return false;
            }

            public final HostedUIErrorData getHostedUIErrorData() {
                return this.hostedUIErrorData;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = this.signedInData.hashCode() * 31;
                HostedUIErrorData hostedUIErrorData = this.hostedUIErrorData;
                if (hostedUIErrorData == null) {
                    hashCode = 0;
                } else {
                    hashCode = hostedUIErrorData.hashCode();
                }
                return hashCode2 + hashCode;
            }

            public String toString() {
                return "SignOutGlobally(signedInData=" + this.signedInData + ", hostedUIErrorData=" + this.hostedUIErrorData + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignOutGlobally(SignedInData signedInData, HostedUIErrorData hostedUIErrorData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
                this.hostedUIErrorData = hostedUIErrorData;
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignOutGloballyError extends EventType {
            private final GlobalSignOutErrorData globalSignOutErrorData;
            private final HostedUIErrorData hostedUIErrorData;
            private final SignedInData signedInData;

            public /* synthetic */ SignOutGloballyError(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, int r5, DefaultConstructorMarker defaultConstructorMarker) {
                this(signedInData, (r5 & 2) != 0 ? null : hostedUIErrorData, (r5 & 4) != 0 ? null : globalSignOutErrorData);
            }

            public static /* synthetic */ SignOutGloballyError copy$default(SignOutGloballyError signOutGloballyError, SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    signedInData = signOutGloballyError.signedInData;
                }
                if ((r4 & 2) != 0) {
                    hostedUIErrorData = signOutGloballyError.hostedUIErrorData;
                }
                if ((r4 & 4) != 0) {
                    globalSignOutErrorData = signOutGloballyError.globalSignOutErrorData;
                }
                return signOutGloballyError.copy(signedInData, hostedUIErrorData, globalSignOutErrorData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final HostedUIErrorData component2() {
                return this.hostedUIErrorData;
            }

            public final GlobalSignOutErrorData component3() {
                return this.globalSignOutErrorData;
            }

            public final SignOutGloballyError copy(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new SignOutGloballyError(signedInData, hostedUIErrorData, globalSignOutErrorData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SignOutGloballyError)) {
                    return false;
                }
                SignOutGloballyError signOutGloballyError = (SignOutGloballyError) obj;
                if (Intrinsics.areEqual(this.signedInData, signOutGloballyError.signedInData) && Intrinsics.areEqual(this.hostedUIErrorData, signOutGloballyError.hostedUIErrorData) && Intrinsics.areEqual(this.globalSignOutErrorData, signOutGloballyError.globalSignOutErrorData)) {
                    return true;
                }
                return false;
            }

            public final GlobalSignOutErrorData getGlobalSignOutErrorData() {
                return this.globalSignOutErrorData;
            }

            public final HostedUIErrorData getHostedUIErrorData() {
                return this.hostedUIErrorData;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2 = this.signedInData.hashCode() * 31;
                HostedUIErrorData hostedUIErrorData = this.hostedUIErrorData;
                int r2 = 0;
                if (hostedUIErrorData == null) {
                    hashCode = 0;
                } else {
                    hashCode = hostedUIErrorData.hashCode();
                }
                int r0 = (hashCode2 + hashCode) * 31;
                GlobalSignOutErrorData globalSignOutErrorData = this.globalSignOutErrorData;
                if (globalSignOutErrorData != null) {
                    r2 = globalSignOutErrorData.hashCode();
                }
                return r0 + r2;
            }

            public String toString() {
                return "SignOutGloballyError(signedInData=" + this.signedInData + ", hostedUIErrorData=" + this.hostedUIErrorData + ", globalSignOutErrorData=" + this.globalSignOutErrorData + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignOutGloballyError(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
                this.hostedUIErrorData = hostedUIErrorData;
                this.globalSignOutErrorData = globalSignOutErrorData;
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignOutLocally extends EventType {
            private final GlobalSignOutErrorData globalSignOutErrorData;
            private final HostedUIErrorData hostedUIErrorData;
            private final RevokeTokenErrorData revokeTokenErrorData;
            private final SignedInData signedInData;

            public /* synthetic */ SignOutLocally(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData, int r6, DefaultConstructorMarker defaultConstructorMarker) {
                this(signedInData, (r6 & 2) != 0 ? null : hostedUIErrorData, (r6 & 4) != 0 ? null : globalSignOutErrorData, (r6 & 8) != 0 ? null : revokeTokenErrorData);
            }

            public static /* synthetic */ SignOutLocally copy$default(SignOutLocally signOutLocally, SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData, int r5, Object obj) {
                if ((r5 & 1) != 0) {
                    signedInData = signOutLocally.signedInData;
                }
                if ((r5 & 2) != 0) {
                    hostedUIErrorData = signOutLocally.hostedUIErrorData;
                }
                if ((r5 & 4) != 0) {
                    globalSignOutErrorData = signOutLocally.globalSignOutErrorData;
                }
                if ((r5 & 8) != 0) {
                    revokeTokenErrorData = signOutLocally.revokeTokenErrorData;
                }
                return signOutLocally.copy(signedInData, hostedUIErrorData, globalSignOutErrorData, revokeTokenErrorData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final HostedUIErrorData component2() {
                return this.hostedUIErrorData;
            }

            public final GlobalSignOutErrorData component3() {
                return this.globalSignOutErrorData;
            }

            public final RevokeTokenErrorData component4() {
                return this.revokeTokenErrorData;
            }

            public final SignOutLocally copy(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData) {
                return new SignOutLocally(signedInData, hostedUIErrorData, globalSignOutErrorData, revokeTokenErrorData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SignOutLocally)) {
                    return false;
                }
                SignOutLocally signOutLocally = (SignOutLocally) obj;
                if (Intrinsics.areEqual(this.signedInData, signOutLocally.signedInData) && Intrinsics.areEqual(this.hostedUIErrorData, signOutLocally.hostedUIErrorData) && Intrinsics.areEqual(this.globalSignOutErrorData, signOutLocally.globalSignOutErrorData) && Intrinsics.areEqual(this.revokeTokenErrorData, signOutLocally.revokeTokenErrorData)) {
                    return true;
                }
                return false;
            }

            public final GlobalSignOutErrorData getGlobalSignOutErrorData() {
                return this.globalSignOutErrorData;
            }

            public final HostedUIErrorData getHostedUIErrorData() {
                return this.hostedUIErrorData;
            }

            public final RevokeTokenErrorData getRevokeTokenErrorData() {
                return this.revokeTokenErrorData;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2;
                int hashCode3;
                SignedInData signedInData = this.signedInData;
                int r1 = 0;
                if (signedInData == null) {
                    hashCode = 0;
                } else {
                    hashCode = signedInData.hashCode();
                }
                int r0 = hashCode * 31;
                HostedUIErrorData hostedUIErrorData = this.hostedUIErrorData;
                if (hostedUIErrorData == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = hostedUIErrorData.hashCode();
                }
                int r02 = (r0 + hashCode2) * 31;
                GlobalSignOutErrorData globalSignOutErrorData = this.globalSignOutErrorData;
                if (globalSignOutErrorData == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = globalSignOutErrorData.hashCode();
                }
                int r03 = (r02 + hashCode3) * 31;
                RevokeTokenErrorData revokeTokenErrorData = this.revokeTokenErrorData;
                if (revokeTokenErrorData != null) {
                    r1 = revokeTokenErrorData.hashCode();
                }
                return r03 + r1;
            }

            public String toString() {
                return "SignOutLocally(signedInData=" + this.signedInData + ", hostedUIErrorData=" + this.hostedUIErrorData + ", globalSignOutErrorData=" + this.globalSignOutErrorData + ", revokeTokenErrorData=" + this.revokeTokenErrorData + ')';
            }

            public SignOutLocally(SignedInData signedInData, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData) {
                super(null);
                this.signedInData = signedInData;
                this.hostedUIErrorData = hostedUIErrorData;
                this.globalSignOutErrorData = globalSignOutErrorData;
                this.revokeTokenErrorData = revokeTokenErrorData;
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignedOutSuccess extends EventType {
            private final SignedOutData signedOutData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignedOutSuccess(SignedOutData signedOutData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
                this.signedOutData = signedOutData;
            }

            public static /* synthetic */ SignedOutSuccess copy$default(SignedOutSuccess signedOutSuccess, SignedOutData signedOutData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signedOutData = signedOutSuccess.signedOutData;
                }
                return signedOutSuccess.copy(signedOutData);
            }

            public final SignedOutData component1() {
                return this.signedOutData;
            }

            public final SignedOutSuccess copy(SignedOutData signedOutData) {
                Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
                return new SignedOutSuccess(signedOutData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof SignedOutSuccess) && Intrinsics.areEqual(this.signedOutData, ((SignedOutSuccess) obj).signedOutData)) {
                    return true;
                }
                return false;
            }

            public final SignedOutData getSignedOutData() {
                return this.signedOutData;
            }

            public int hashCode() {
                return this.signedOutData.hashCode();
            }

            public String toString() {
                return "SignedOutSuccess(signedOutData=" + this.signedOutData + ')';
            }
        }

        /* compiled from: SignOutEvent.kt */
        /* loaded from: classes.dex */
        public static final class UserCancelled extends EventType {
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UserCancelled(SignedInData signedInData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.signedInData = signedInData;
            }

            public static /* synthetic */ UserCancelled copy$default(UserCancelled userCancelled, SignedInData signedInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signedInData = userCancelled.signedInData;
                }
                return userCancelled.copy(signedInData);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final UserCancelled copy(SignedInData signedInData) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new UserCancelled(signedInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof UserCancelled) && Intrinsics.areEqual(this.signedInData, ((UserCancelled) obj).signedInData)) {
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
                return "UserCancelled(signedInData=" + this.signedInData + ')';
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public SignOutEvent(EventType eventType, Date date) {
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

    public /* synthetic */ SignOutEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
