package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
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

/* compiled from: DeviceMetadata.kt */
@Serializable
/* loaded from: classes.dex */
public abstract class DeviceMetadata {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.amplifyframework.statemachine.codegen.data.DeviceMetadata", Reflection.getOrCreateKotlinClass(DeviceMetadata.class), new KClass[]{Reflection.getOrCreateKotlinClass(DeviceMetadata.Empty.class), Reflection.getOrCreateKotlinClass(DeviceMetadata.Metadata.class)}, new KSerializer[]{new ObjectSerializer("empty", DeviceMetadata.Empty.INSTANCE, new Annotation[0]), DeviceMetadata$Metadata$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* compiled from: DeviceMetadata.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return DeviceMetadata.$cachedSerializer$delegate;
        }

        public final KSerializer<DeviceMetadata> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }

        private Companion() {
        }
    }

    /* compiled from: DeviceMetadata.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class Empty extends DeviceMetadata {
        public static final Empty INSTANCE = new Empty();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.amplifyframework.statemachine.codegen.data.DeviceMetadata$Empty$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return new ObjectSerializer("empty", DeviceMetadata.Empty.INSTANCE, new Annotation[0]);
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

    /* compiled from: DeviceMetadata.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class Metadata extends DeviceMetadata {
        public static final Companion Companion = new Companion(null);
        private final String deviceGroupKey;
        private final String deviceKey;
        private final String deviceSecret;

        /* compiled from: DeviceMetadata.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Metadata> serializer() {
                return DeviceMetadata$Metadata$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Metadata(int r4, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            super(r4, serializationConstructorMarker);
            if (3 != (r4 & 3)) {
                zzac.throwMissingFieldException(r4, 3, DeviceMetadata$Metadata$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.deviceKey = str;
            this.deviceGroupKey = str2;
            if ((r4 & 4) == 0) {
                this.deviceSecret = null;
            } else {
                this.deviceSecret = str3;
            }
        }

        public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, String str3, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = metadata.deviceKey;
            }
            if ((r4 & 2) != 0) {
                str2 = metadata.deviceGroupKey;
            }
            if ((r4 & 4) != 0) {
                str3 = metadata.deviceSecret;
            }
            return metadata.copy(str, str2, str3);
        }

        public static final void write$Self(Metadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            DeviceMetadata.write$Self(self, output, serialDesc);
            boolean z = false;
            output.encodeStringElement(serialDesc, 0, self.deviceKey);
            output.encodeStringElement(serialDesc, 1, self.deviceGroupKey);
            if (output.shouldEncodeElementDefault(serialDesc) || self.deviceSecret != null) {
                z = true;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.deviceSecret);
            }
        }

        public final String component1() {
            return this.deviceKey;
        }

        public final String component2() {
            return this.deviceGroupKey;
        }

        public final String component3() {
            return this.deviceSecret;
        }

        public final Metadata copy(String deviceKey, String deviceGroupKey, String str) {
            Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
            Intrinsics.checkNotNullParameter(deviceGroupKey, "deviceGroupKey");
            return new Metadata(deviceKey, deviceGroupKey, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) obj;
            if (Intrinsics.areEqual(this.deviceKey, metadata.deviceKey) && Intrinsics.areEqual(this.deviceGroupKey, metadata.deviceGroupKey) && Intrinsics.areEqual(this.deviceSecret, metadata.deviceSecret)) {
                return true;
            }
            return false;
        }

        public final String getDeviceGroupKey() {
            return this.deviceGroupKey;
        }

        public final String getDeviceKey() {
            return this.deviceKey;
        }

        public final String getDeviceSecret() {
            return this.deviceSecret;
        }

        public int hashCode() {
            int hashCode;
            int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.deviceGroupKey, this.deviceKey.hashCode() * 31, 31);
            String str = this.deviceSecret;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return m + hashCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Metadata(deviceKey=");
            sb.append(this.deviceKey);
            sb.append(", deviceGroupKey=");
            sb.append(this.deviceGroupKey);
            sb.append(", deviceSecret=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.deviceSecret, ')');
        }

        public /* synthetic */ Metadata(String str, String str2, String str3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (r4 & 4) != 0 ? null : str3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Metadata(String deviceKey, String deviceGroupKey, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
            Intrinsics.checkNotNullParameter(deviceGroupKey, "deviceGroupKey");
            this.deviceKey = deviceKey;
            this.deviceGroupKey = deviceGroupKey;
            this.deviceSecret = str;
        }
    }

    public /* synthetic */ DeviceMetadata(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void write$Self(DeviceMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
    }

    private DeviceMetadata() {
    }

    public /* synthetic */ DeviceMetadata(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }
}
