package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignInData;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInEvent.kt */
/* loaded from: classes.dex */
public final class SignInEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: SignInEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfirmDevice extends EventType {
            private final DeviceMetadata.Metadata deviceMetadata;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmDevice(DeviceMetadata.Metadata deviceMetadata, SignedInData signedInData) {
                super(null);
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                this.deviceMetadata = deviceMetadata;
                this.signedInData = signedInData;
            }

            public static /* synthetic */ ConfirmDevice copy$default(ConfirmDevice confirmDevice, DeviceMetadata.Metadata metadata, SignedInData signedInData, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    metadata = confirmDevice.deviceMetadata;
                }
                if ((r3 & 2) != 0) {
                    signedInData = confirmDevice.signedInData;
                }
                return confirmDevice.copy(metadata, signedInData);
            }

            public final DeviceMetadata.Metadata component1() {
                return this.deviceMetadata;
            }

            public final SignedInData component2() {
                return this.signedInData;
            }

            public final ConfirmDevice copy(DeviceMetadata.Metadata deviceMetadata, SignedInData signedInData) {
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                return new ConfirmDevice(deviceMetadata, signedInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConfirmDevice)) {
                    return false;
                }
                ConfirmDevice confirmDevice = (ConfirmDevice) obj;
                if (Intrinsics.areEqual(this.deviceMetadata, confirmDevice.deviceMetadata) && Intrinsics.areEqual(this.signedInData, confirmDevice.signedInData)) {
                    return true;
                }
                return false;
            }

            public final DeviceMetadata.Metadata getDeviceMetadata() {
                return this.deviceMetadata;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.signedInData.hashCode() + (this.deviceMetadata.hashCode() * 31);
            }

            public String toString() {
                return "ConfirmDevice(deviceMetadata=" + this.deviceMetadata + ", signedInData=" + this.signedInData + ')';
            }
        }

        /* compiled from: SignInEvent.kt */
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

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateCustomSignInWithSRP extends EventType {
            private final Map<String, String> metadata;
            private final String password;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateCustomSignInWithSRP(String username, String password, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.password = password;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateCustomSignInWithSRP copy$default(InitiateCustomSignInWithSRP initiateCustomSignInWithSRP, String str, String str2, Map map, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = initiateCustomSignInWithSRP.username;
                }
                if ((r4 & 2) != 0) {
                    str2 = initiateCustomSignInWithSRP.password;
                }
                if ((r4 & 4) != 0) {
                    map = initiateCustomSignInWithSRP.metadata;
                }
                return initiateCustomSignInWithSRP.copy(str, str2, map);
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

            public final InitiateCustomSignInWithSRP copy(String username, String password, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateCustomSignInWithSRP(username, password, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateCustomSignInWithSRP)) {
                    return false;
                }
                InitiateCustomSignInWithSRP initiateCustomSignInWithSRP = (InitiateCustomSignInWithSRP) obj;
                if (Intrinsics.areEqual(this.username, initiateCustomSignInWithSRP.username) && Intrinsics.areEqual(this.password, initiateCustomSignInWithSRP.password) && Intrinsics.areEqual(this.metadata, initiateCustomSignInWithSRP.metadata)) {
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
                StringBuilder sb = new StringBuilder("InitiateCustomSignInWithSRP(username=");
                sb.append(this.username);
                sb.append(", password=");
                sb.append(this.password);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateHostedUISignIn extends EventType {
            private final SignInData.HostedUISignInData hostedUISignInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateHostedUISignIn(SignInData.HostedUISignInData hostedUISignInData) {
                super(null);
                Intrinsics.checkNotNullParameter(hostedUISignInData, "hostedUISignInData");
                this.hostedUISignInData = hostedUISignInData;
            }

            public static /* synthetic */ InitiateHostedUISignIn copy$default(InitiateHostedUISignIn initiateHostedUISignIn, SignInData.HostedUISignInData hostedUISignInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    hostedUISignInData = initiateHostedUISignIn.hostedUISignInData;
                }
                return initiateHostedUISignIn.copy(hostedUISignInData);
            }

            public final SignInData.HostedUISignInData component1() {
                return this.hostedUISignInData;
            }

            public final InitiateHostedUISignIn copy(SignInData.HostedUISignInData hostedUISignInData) {
                Intrinsics.checkNotNullParameter(hostedUISignInData, "hostedUISignInData");
                return new InitiateHostedUISignIn(hostedUISignInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof InitiateHostedUISignIn) && Intrinsics.areEqual(this.hostedUISignInData, ((InitiateHostedUISignIn) obj).hostedUISignInData)) {
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
                return "InitiateHostedUISignIn(hostedUISignInData=" + this.hostedUISignInData + ')';
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateMigrateAuth extends EventType {
            private final Map<String, String> metadata;
            private final String password;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateMigrateAuth(String username, String password, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.password = password;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateMigrateAuth copy$default(InitiateMigrateAuth initiateMigrateAuth, String str, String str2, Map map, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = initiateMigrateAuth.username;
                }
                if ((r4 & 2) != 0) {
                    str2 = initiateMigrateAuth.password;
                }
                if ((r4 & 4) != 0) {
                    map = initiateMigrateAuth.metadata;
                }
                return initiateMigrateAuth.copy(str, str2, map);
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

            public final InitiateMigrateAuth copy(String username, String password, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateMigrateAuth(username, password, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateMigrateAuth)) {
                    return false;
                }
                InitiateMigrateAuth initiateMigrateAuth = (InitiateMigrateAuth) obj;
                if (Intrinsics.areEqual(this.username, initiateMigrateAuth.username) && Intrinsics.areEqual(this.password, initiateMigrateAuth.password) && Intrinsics.areEqual(this.metadata, initiateMigrateAuth.metadata)) {
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
                StringBuilder sb = new StringBuilder("InitiateMigrateAuth(username=");
                sb.append(this.username);
                sb.append(", password=");
                sb.append(this.password);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateSignInWithCustom extends EventType {
            private final Map<String, String> metadata;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateSignInWithCustom(String username, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateSignInWithCustom copy$default(InitiateSignInWithCustom initiateSignInWithCustom, String str, Map map, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = initiateSignInWithCustom.username;
                }
                if ((r3 & 2) != 0) {
                    map = initiateSignInWithCustom.metadata;
                }
                return initiateSignInWithCustom.copy(str, map);
            }

            public final String component1() {
                return this.username;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final InitiateSignInWithCustom copy(String username, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateSignInWithCustom(username, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateSignInWithCustom)) {
                    return false;
                }
                InitiateSignInWithCustom initiateSignInWithCustom = (InitiateSignInWithCustom) obj;
                if (Intrinsics.areEqual(this.username, initiateSignInWithCustom.username) && Intrinsics.areEqual(this.metadata, initiateSignInWithCustom.metadata)) {
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
                StringBuilder sb = new StringBuilder("InitiateSignInWithCustom(username=");
                sb.append(this.username);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateSignInWithDeviceSRP extends EventType {
            private final Map<String, String> metadata;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateSignInWithDeviceSRP(String username, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateSignInWithDeviceSRP copy$default(InitiateSignInWithDeviceSRP initiateSignInWithDeviceSRP, String str, Map map, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = initiateSignInWithDeviceSRP.username;
                }
                if ((r3 & 2) != 0) {
                    map = initiateSignInWithDeviceSRP.metadata;
                }
                return initiateSignInWithDeviceSRP.copy(str, map);
            }

            public final String component1() {
                return this.username;
            }

            public final Map<String, String> component2() {
                return this.metadata;
            }

            public final InitiateSignInWithDeviceSRP copy(String username, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateSignInWithDeviceSRP(username, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateSignInWithDeviceSRP)) {
                    return false;
                }
                InitiateSignInWithDeviceSRP initiateSignInWithDeviceSRP = (InitiateSignInWithDeviceSRP) obj;
                if (Intrinsics.areEqual(this.username, initiateSignInWithDeviceSRP.username) && Intrinsics.areEqual(this.metadata, initiateSignInWithDeviceSRP.metadata)) {
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
                StringBuilder sb = new StringBuilder("InitiateSignInWithDeviceSRP(username=");
                sb.append(this.username);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitiateSignInWithSRP extends EventType {
            private final Map<String, String> metadata;
            private final String password;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateSignInWithSRP(String username, String password, Map<String, String> metadata) {
                super(null);
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.username = username;
                this.password = password;
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitiateSignInWithSRP copy$default(InitiateSignInWithSRP initiateSignInWithSRP, String str, String str2, Map map, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = initiateSignInWithSRP.username;
                }
                if ((r4 & 2) != 0) {
                    str2 = initiateSignInWithSRP.password;
                }
                if ((r4 & 4) != 0) {
                    map = initiateSignInWithSRP.metadata;
                }
                return initiateSignInWithSRP.copy(str, str2, map);
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

            public final InitiateSignInWithSRP copy(String username, String password, Map<String, String> metadata) {
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new InitiateSignInWithSRP(username, password, metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitiateSignInWithSRP)) {
                    return false;
                }
                InitiateSignInWithSRP initiateSignInWithSRP = (InitiateSignInWithSRP) obj;
                if (Intrinsics.areEqual(this.username, initiateSignInWithSRP.username) && Intrinsics.areEqual(this.password, initiateSignInWithSRP.password) && Intrinsics.areEqual(this.metadata, initiateSignInWithSRP.metadata)) {
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
                StringBuilder sb = new StringBuilder("InitiateSignInWithSRP(username=");
                sb.append(this.username);
                sb.append(", password=");
                sb.append(this.password);
                sb.append(", metadata=");
                return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class ReceivedChallenge extends EventType {
            private final AuthChallenge challenge;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReceivedChallenge(AuthChallenge challenge) {
                super(null);
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                this.challenge = challenge;
            }

            public static /* synthetic */ ReceivedChallenge copy$default(ReceivedChallenge receivedChallenge, AuthChallenge authChallenge, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    authChallenge = receivedChallenge.challenge;
                }
                return receivedChallenge.copy(authChallenge);
            }

            public final AuthChallenge component1() {
                return this.challenge;
            }

            public final ReceivedChallenge copy(AuthChallenge challenge) {
                Intrinsics.checkNotNullParameter(challenge, "challenge");
                return new ReceivedChallenge(challenge);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ReceivedChallenge) && Intrinsics.areEqual(this.challenge, ((ReceivedChallenge) obj).challenge)) {
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
                return "ReceivedChallenge(challenge=" + this.challenge + ')';
            }
        }

        /* compiled from: SignInEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignedIn extends EventType {
            private final String id;

            public SignedIn() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ SignedIn copy$default(SignedIn signedIn, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = signedIn.id;
                }
                return signedIn.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final SignedIn copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new SignedIn(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof SignedIn) && Intrinsics.areEqual(this.id, ((SignedIn) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SignedIn(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignedIn(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ SignedIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: SignInEvent.kt */
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

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public SignInEvent(EventType eventType, Date date) {
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

    public /* synthetic */ SignInEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
