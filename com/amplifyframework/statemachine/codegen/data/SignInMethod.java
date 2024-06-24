package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
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
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SignInMethod.kt */
@Serializable
/* loaded from: classes.dex */
public abstract class SignInMethod {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.amplifyframework.statemachine.codegen.data.SignInMethod$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.amplifyframework.statemachine.codegen.data.SignInMethod", Reflection.getOrCreateKotlinClass(SignInMethod.class), new KClass[]{Reflection.getOrCreateKotlinClass(SignInMethod.ApiBased.class), Reflection.getOrCreateKotlinClass(SignInMethod.HostedUI.class)}, new KSerializer[]{SignInMethod$ApiBased$$serializer.INSTANCE, SignInMethod$HostedUI$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* compiled from: SignInMethod.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class ApiBased extends SignInMethod {
        public static final Companion Companion = new Companion(null);
        private final AuthType authType;

        /* compiled from: SignInMethod.kt */
        /* loaded from: classes.dex */
        public enum AuthType {
            USER_SRP_AUTH,
            CUSTOM_AUTH,
            USER_PASSWORD_AUTH,
            UNKNOWN
        }

        /* compiled from: SignInMethod.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ApiBased> serializer() {
                return SignInMethod$ApiBased$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ApiBased(int r3, AuthType authType, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (1 != (r3 & 1)) {
                zzac.throwMissingFieldException(r3, 1, SignInMethod$ApiBased$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.authType = authType;
        }

        public static /* synthetic */ ApiBased copy$default(ApiBased apiBased, AuthType authType, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                authType = apiBased.authType;
            }
            return apiBased.copy(authType);
        }

        public static final void write$Self(ApiBased self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            SignInMethod.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, new EnumSerializer("com.amplifyframework.statemachine.codegen.data.SignInMethod.ApiBased.AuthType", AuthType.values()), self.authType);
        }

        public final AuthType component1() {
            return this.authType;
        }

        public final ApiBased copy(AuthType authType) {
            Intrinsics.checkNotNullParameter(authType, "authType");
            return new ApiBased(authType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ApiBased) && this.authType == ((ApiBased) obj).authType) {
                return true;
            }
            return false;
        }

        public final AuthType getAuthType() {
            return this.authType;
        }

        public int hashCode() {
            return this.authType.hashCode();
        }

        public String toString() {
            return "ApiBased(authType=" + this.authType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiBased(AuthType authType) {
            super(null);
            Intrinsics.checkNotNullParameter(authType, "authType");
            this.authType = authType;
        }
    }

    /* compiled from: SignInMethod.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return SignInMethod.$cachedSerializer$delegate;
        }

        public final KSerializer<SignInMethod> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }

        private Companion() {
        }
    }

    /* compiled from: SignInMethod.kt */
    @Serializable
    /* loaded from: classes.dex */
    public static final class HostedUI extends SignInMethod {
        public static final Companion Companion = new Companion(null);
        private final String browserPackage;

        /* compiled from: SignInMethod.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<HostedUI> serializer() {
                return SignInMethod$HostedUI$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public HostedUI() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ HostedUI copy$default(HostedUI hostedUI, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = hostedUI.browserPackage;
            }
            return hostedUI.copy(str);
        }

        public static final void write$Self(HostedUI self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z;
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            SignInMethod.write$Self(self, output, serialDesc);
            if (output.shouldEncodeElementDefault(serialDesc) || self.browserPackage != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.browserPackage);
            }
        }

        public final String component1() {
            return this.browserPackage;
        }

        public final HostedUI copy(String str) {
            return new HostedUI(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof HostedUI) && Intrinsics.areEqual(this.browserPackage, ((HostedUI) obj).browserPackage)) {
                return true;
            }
            return false;
        }

        public final String getBrowserPackage() {
            return this.browserPackage;
        }

        public int hashCode() {
            String str = this.browserPackage;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("HostedUI(browserPackage="), this.browserPackage, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HostedUI(int r3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if ((r3 & 0) != 0) {
                zzac.throwMissingFieldException(r3, 0, SignInMethod$HostedUI$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r3 & 1) == 0) {
                this.browserPackage = null;
            } else {
                this.browserPackage = str;
            }
        }

        public HostedUI(String str) {
            super(null);
            this.browserPackage = str;
        }

        public /* synthetic */ HostedUI(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? null : str);
        }
    }

    public /* synthetic */ SignInMethod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void write$Self(SignInMethod self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
    }

    private SignInMethod() {
    }

    public /* synthetic */ SignInMethod(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }
}
