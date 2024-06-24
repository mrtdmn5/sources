package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.google.android.gms.tasks.zzac;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AmplifyCredential.kt */
@Serializable
/* loaded from: classes.dex */
public abstract class AmplifyCredential {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.amplifyframework.statemachine.codegen.data.AmplifyCredential$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.amplifyframework.statemachine.codegen.data.AmplifyCredential", Reflection.getOrCreateKotlinClass(AmplifyCredential.class), new KClass[]{Reflection.getOrCreateKotlinClass(AmplifyCredential.ASFDevice.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.DeviceData.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.Empty.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.IdentityPool.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.IdentityPoolFederated.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.UserAndIdentityPool.class), Reflection.getOrCreateKotlinClass(AmplifyCredential.UserPool.class)}, new KSerializer[]{AmplifyCredential$ASFDevice$$serializer.INSTANCE, AmplifyCredential$DeviceData$$serializer.INSTANCE, new ObjectSerializer("empty", AmplifyCredential.Empty.INSTANCE, new Annotation[0]), AmplifyCredential$IdentityPool$$serializer.INSTANCE, AmplifyCredential$IdentityPoolFederated$$serializer.INSTANCE, AmplifyCredential$UserAndIdentityPool$$serializer.INSTANCE, AmplifyCredential$UserPool$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class ASFDevice extends AmplifyCredential {
        public static final Companion Companion = new Companion(null);
        private final String id;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ASFDevice> serializer() {
                return AmplifyCredential$ASFDevice$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ASFDevice(int r3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (1 != (r3 & 1)) {
                zzac.throwMissingFieldException(r3, 1, AmplifyCredential$ASFDevice$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.id = str;
        }

        public static /* synthetic */ ASFDevice copy$default(ASFDevice aSFDevice, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = aSFDevice.id;
            }
            return aSFDevice.copy(str);
        }

        public static final void write$Self(ASFDevice self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }

        public final String component1() {
            return this.id;
        }

        public final ASFDevice copy(String str) {
            return new ASFDevice(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ASFDevice) && Intrinsics.areEqual(this.id, ((ASFDevice) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ASFDevice(id="), this.id, ')');
        }

        public ASFDevice(String str) {
            super(null);
            this.id = str;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return AmplifyCredential.$cachedSerializer$delegate;
        }

        public final KSerializer<AmplifyCredential> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }

        private Companion() {
        }
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class DeviceData extends AmplifyCredential implements DeviceMetaDataTypeCredential {
        public static final Companion Companion = new Companion(null);
        private final DeviceMetadata deviceMetadata;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<DeviceData> serializer() {
                return AmplifyCredential$DeviceData$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DeviceData(int r3, DeviceMetadata deviceMetadata, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (1 != (r3 & 1)) {
                zzac.throwMissingFieldException(r3, 1, AmplifyCredential$DeviceData$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.deviceMetadata = deviceMetadata;
        }

        public static /* synthetic */ DeviceData copy$default(DeviceData deviceData, DeviceMetadata deviceMetadata, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                deviceMetadata = deviceData.getDeviceMetadata();
            }
            return deviceData.copy(deviceMetadata);
        }

        public static final void write$Self(DeviceData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, DeviceMetadata.Companion.serializer(), self.getDeviceMetadata());
        }

        public final DeviceMetadata component1() {
            return getDeviceMetadata();
        }

        public final DeviceData copy(DeviceMetadata deviceMetadata) {
            Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
            return new DeviceData(deviceMetadata);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DeviceData) && Intrinsics.areEqual(getDeviceMetadata(), ((DeviceData) obj).getDeviceMetadata())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.DeviceMetaDataTypeCredential
        public DeviceMetadata getDeviceMetadata() {
            return this.deviceMetadata;
        }

        public int hashCode() {
            return getDeviceMetadata().hashCode();
        }

        public String toString() {
            return "DeviceData(deviceMetadata=" + getDeviceMetadata() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceData(DeviceMetadata deviceMetadata) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
            this.deviceMetadata = deviceMetadata;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public interface DeviceMetaDataTypeCredential {
        DeviceMetadata getDeviceMetadata();
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class Empty extends AmplifyCredential {
        public static final Empty INSTANCE = new Empty();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.amplifyframework.statemachine.codegen.data.AmplifyCredential$Empty$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return new ObjectSerializer("empty", AmplifyCredential.Empty.INSTANCE, new Annotation[0]);
            }
        });

        private Empty() {
            super(null);
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return $cachedSerializer$delegate;
        }

        public final KSerializer<Empty> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class IdentityPool extends AmplifyCredential implements IdentityPoolTypeCredential {
        public static final Companion Companion = new Companion(null);
        private final AWSCredentials credentials;
        private final String identityId;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IdentityPool> serializer() {
                return AmplifyCredential$IdentityPool$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IdentityPool(int r3, String str, AWSCredentials aWSCredentials, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (3 != (r3 & 3)) {
                zzac.throwMissingFieldException(r3, 3, AmplifyCredential$IdentityPool$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.identityId = str;
            this.credentials = aWSCredentials;
        }

        public static /* synthetic */ IdentityPool copy$default(IdentityPool identityPool, String str, AWSCredentials aWSCredentials, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = identityPool.getIdentityId();
            }
            if ((r3 & 2) != 0) {
                aWSCredentials = identityPool.getCredentials();
            }
            return identityPool.copy(str, aWSCredentials);
        }

        public static final void write$Self(IdentityPool self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.getIdentityId());
            output.encodeSerializableElement(serialDesc, 1, AWSCredentials$$serializer.INSTANCE, self.getCredentials());
        }

        public final String component1() {
            return getIdentityId();
        }

        public final AWSCredentials component2() {
            return getCredentials();
        }

        public final IdentityPool copy(String identityId, AWSCredentials credentials) {
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            return new IdentityPool(identityId, credentials);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdentityPool)) {
                return false;
            }
            IdentityPool identityPool = (IdentityPool) obj;
            if (Intrinsics.areEqual(getIdentityId(), identityPool.getIdentityId()) && Intrinsics.areEqual(getCredentials(), identityPool.getCredentials())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public AWSCredentials getCredentials() {
            return this.credentials;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public String getIdentityId() {
            return this.identityId;
        }

        public int hashCode() {
            return getCredentials().hashCode() + (getIdentityId().hashCode() * 31);
        }

        public String toString() {
            return "IdentityPool(identityId=" + getIdentityId() + ", credentials=" + getCredentials() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdentityPool(String identityId, AWSCredentials credentials) {
            super(null);
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            this.identityId = identityId;
            this.credentials = credentials;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class IdentityPoolFederated extends AmplifyCredential implements IdentityPoolTypeCredential {
        public static final Companion Companion = new Companion(null);
        private final AWSCredentials credentials;
        private final FederatedToken federatedToken;
        private final String identityId;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IdentityPoolFederated> serializer() {
                return AmplifyCredential$IdentityPoolFederated$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IdentityPoolFederated(int r3, FederatedToken federatedToken, String str, AWSCredentials aWSCredentials, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (7 != (r3 & 7)) {
                zzac.throwMissingFieldException(r3, 7, AmplifyCredential$IdentityPoolFederated$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.federatedToken = federatedToken;
            this.identityId = str;
            this.credentials = aWSCredentials;
        }

        public static /* synthetic */ IdentityPoolFederated copy$default(IdentityPoolFederated identityPoolFederated, FederatedToken federatedToken, String str, AWSCredentials aWSCredentials, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                federatedToken = identityPoolFederated.federatedToken;
            }
            if ((r4 & 2) != 0) {
                str = identityPoolFederated.getIdentityId();
            }
            if ((r4 & 4) != 0) {
                aWSCredentials = identityPoolFederated.getCredentials();
            }
            return identityPoolFederated.copy(federatedToken, str, aWSCredentials);
        }

        public static final void write$Self(IdentityPoolFederated self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, FederatedToken$$serializer.INSTANCE, self.federatedToken);
            output.encodeStringElement(serialDesc, 1, self.getIdentityId());
            output.encodeSerializableElement(serialDesc, 2, AWSCredentials$$serializer.INSTANCE, self.getCredentials());
        }

        public final FederatedToken component1() {
            return this.federatedToken;
        }

        public final String component2() {
            return getIdentityId();
        }

        public final AWSCredentials component3() {
            return getCredentials();
        }

        public final IdentityPoolFederated copy(FederatedToken federatedToken, String identityId, AWSCredentials credentials) {
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            return new IdentityPoolFederated(federatedToken, identityId, credentials);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdentityPoolFederated)) {
                return false;
            }
            IdentityPoolFederated identityPoolFederated = (IdentityPoolFederated) obj;
            if (Intrinsics.areEqual(this.federatedToken, identityPoolFederated.federatedToken) && Intrinsics.areEqual(getIdentityId(), identityPoolFederated.getIdentityId()) && Intrinsics.areEqual(getCredentials(), identityPoolFederated.getCredentials())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public AWSCredentials getCredentials() {
            return this.credentials;
        }

        public final FederatedToken getFederatedToken() {
            return this.federatedToken;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public String getIdentityId() {
            return this.identityId;
        }

        public int hashCode() {
            return getCredentials().hashCode() + ((getIdentityId().hashCode() + (this.federatedToken.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "IdentityPoolFederated(federatedToken=" + this.federatedToken + ", identityId=" + getIdentityId() + ", credentials=" + getCredentials() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdentityPoolFederated(FederatedToken federatedToken, String identityId, AWSCredentials credentials) {
            super(null);
            Intrinsics.checkNotNullParameter(federatedToken, "federatedToken");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            this.federatedToken = federatedToken;
            this.identityId = identityId;
            this.credentials = credentials;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public interface IdentityPoolTypeCredential {
        AWSCredentials getCredentials();

        String getIdentityId();
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class UserAndIdentityPool extends AmplifyCredential implements UserPoolTypeCredential, IdentityPoolTypeCredential {
        public static final Companion Companion = new Companion(null);
        private final AWSCredentials credentials;
        private final String identityId;
        private final SignedInData signedInData;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<UserAndIdentityPool> serializer() {
                return AmplifyCredential$UserAndIdentityPool$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UserAndIdentityPool(int r3, SignedInData signedInData, String str, AWSCredentials aWSCredentials, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (7 != (r3 & 7)) {
                zzac.throwMissingFieldException(r3, 7, AmplifyCredential$UserAndIdentityPool$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.signedInData = signedInData;
            this.identityId = str;
            this.credentials = aWSCredentials;
        }

        public static /* synthetic */ UserAndIdentityPool copy$default(UserAndIdentityPool userAndIdentityPool, SignedInData signedInData, String str, AWSCredentials aWSCredentials, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                signedInData = userAndIdentityPool.getSignedInData();
            }
            if ((r4 & 2) != 0) {
                str = userAndIdentityPool.getIdentityId();
            }
            if ((r4 & 4) != 0) {
                aWSCredentials = userAndIdentityPool.getCredentials();
            }
            return userAndIdentityPool.copy(signedInData, str, aWSCredentials);
        }

        public static final void write$Self(UserAndIdentityPool self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, SignedInData$$serializer.INSTANCE, self.getSignedInData());
            output.encodeStringElement(serialDesc, 1, self.getIdentityId());
            output.encodeSerializableElement(serialDesc, 2, AWSCredentials$$serializer.INSTANCE, self.getCredentials());
        }

        public final SignedInData component1() {
            return getSignedInData();
        }

        public final String component2() {
            return getIdentityId();
        }

        public final AWSCredentials component3() {
            return getCredentials();
        }

        public final UserAndIdentityPool copy(SignedInData signedInData, String identityId, AWSCredentials credentials) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            return new UserAndIdentityPool(signedInData, identityId, credentials);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserAndIdentityPool)) {
                return false;
            }
            UserAndIdentityPool userAndIdentityPool = (UserAndIdentityPool) obj;
            if (Intrinsics.areEqual(getSignedInData(), userAndIdentityPool.getSignedInData()) && Intrinsics.areEqual(getIdentityId(), userAndIdentityPool.getIdentityId()) && Intrinsics.areEqual(getCredentials(), userAndIdentityPool.getCredentials())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public AWSCredentials getCredentials() {
            return this.credentials;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.IdentityPoolTypeCredential
        public String getIdentityId() {
            return this.identityId;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.UserPoolTypeCredential
        public SignedInData getSignedInData() {
            return this.signedInData;
        }

        public int hashCode() {
            return getCredentials().hashCode() + ((getIdentityId().hashCode() + (getSignedInData().hashCode() * 31)) * 31);
        }

        public String toString() {
            return "UserAndIdentityPool(signedInData=" + getSignedInData() + ", identityId=" + getIdentityId() + ", credentials=" + getCredentials() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserAndIdentityPool(SignedInData signedInData, String identityId, AWSCredentials credentials) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            this.signedInData = signedInData;
            this.identityId = identityId;
            this.credentials = credentials;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class UserPool extends AmplifyCredential implements UserPoolTypeCredential {
        public static final Companion Companion = new Companion(null);
        private final SignedInData signedInData;

        /* compiled from: AmplifyCredential.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<UserPool> serializer() {
                return AmplifyCredential$UserPool$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UserPool(int r3, SignedInData signedInData, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (1 != (r3 & 1)) {
                zzac.throwMissingFieldException(r3, 1, AmplifyCredential$UserPool$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.signedInData = signedInData;
        }

        public static /* synthetic */ UserPool copy$default(UserPool userPool, SignedInData signedInData, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signedInData = userPool.getSignedInData();
            }
            return userPool.copy(signedInData);
        }

        public static final void write$Self(UserPool self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            AmplifyCredential.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, SignedInData$$serializer.INSTANCE, self.getSignedInData());
        }

        public final SignedInData component1() {
            return getSignedInData();
        }

        public final UserPool copy(SignedInData signedInData) {
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            return new UserPool(signedInData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof UserPool) && Intrinsics.areEqual(getSignedInData(), ((UserPool) obj).getSignedInData())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.data.AmplifyCredential.UserPoolTypeCredential
        public SignedInData getSignedInData() {
            return this.signedInData;
        }

        public int hashCode() {
            return getSignedInData().hashCode();
        }

        public String toString() {
            return "UserPool(signedInData=" + getSignedInData() + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserPool(SignedInData signedInData) {
            super(null);
            Intrinsics.checkNotNullParameter(signedInData, "signedInData");
            this.signedInData = signedInData;
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public interface UserPoolTypeCredential {
        SignedInData getSignedInData();
    }

    public /* synthetic */ AmplifyCredential(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void write$Self(AmplifyCredential self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
    }

    private AmplifyCredential() {
    }

    public /* synthetic */ AmplifyCredential(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }
}
