package com.amplifyframework.statemachine.codegen.data;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInData.kt */
/* loaded from: classes.dex */
public abstract class SignInData {

    /* compiled from: SignInData.kt */
    /* loaded from: classes.dex */
    public static final class CustomAuthSignInData extends SignInData {
        private final Map<String, String> metadata;
        private final String username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomAuthSignInData(String str, Map<String, String> metadata) {
            super(null);
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.username = str;
            this.metadata = metadata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomAuthSignInData copy$default(CustomAuthSignInData customAuthSignInData, String str, Map map, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = customAuthSignInData.username;
            }
            if ((r3 & 2) != 0) {
                map = customAuthSignInData.metadata;
            }
            return customAuthSignInData.copy(str, map);
        }

        public final String component1() {
            return this.username;
        }

        public final Map<String, String> component2() {
            return this.metadata;
        }

        public final CustomAuthSignInData copy(String str, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new CustomAuthSignInData(str, metadata);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomAuthSignInData)) {
                return false;
            }
            CustomAuthSignInData customAuthSignInData = (CustomAuthSignInData) obj;
            if (Intrinsics.areEqual(this.username, customAuthSignInData.username) && Intrinsics.areEqual(this.metadata, customAuthSignInData.metadata)) {
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
            int hashCode;
            String str = this.username;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return this.metadata.hashCode() + (hashCode * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CustomAuthSignInData(username=");
            sb.append(this.username);
            sb.append(", metadata=");
            return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
        }
    }

    /* compiled from: SignInData.kt */
    /* loaded from: classes.dex */
    public static final class CustomSRPAuthSignInData extends SignInData {
        private final Map<String, String> metadata;
        private final String password;
        private final String username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomSRPAuthSignInData(String str, String str2, Map<String, String> metadata) {
            super(null);
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.username = str;
            this.password = str2;
            this.metadata = metadata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomSRPAuthSignInData copy$default(CustomSRPAuthSignInData customSRPAuthSignInData, String str, String str2, Map map, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = customSRPAuthSignInData.username;
            }
            if ((r4 & 2) != 0) {
                str2 = customSRPAuthSignInData.password;
            }
            if ((r4 & 4) != 0) {
                map = customSRPAuthSignInData.metadata;
            }
            return customSRPAuthSignInData.copy(str, str2, map);
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

        public final CustomSRPAuthSignInData copy(String str, String str2, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new CustomSRPAuthSignInData(str, str2, metadata);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomSRPAuthSignInData)) {
                return false;
            }
            CustomSRPAuthSignInData customSRPAuthSignInData = (CustomSRPAuthSignInData) obj;
            if (Intrinsics.areEqual(this.username, customSRPAuthSignInData.username) && Intrinsics.areEqual(this.password, customSRPAuthSignInData.password) && Intrinsics.areEqual(this.metadata, customSRPAuthSignInData.metadata)) {
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
            int hashCode;
            String str = this.username;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.password;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return this.metadata.hashCode() + ((r0 + r1) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CustomSRPAuthSignInData(username=");
            sb.append(this.username);
            sb.append(", password=");
            sb.append(this.password);
            sb.append(", metadata=");
            return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
        }
    }

    /* compiled from: SignInData.kt */
    /* loaded from: classes.dex */
    public static final class HostedUISignInData extends SignInData {
        private final HostedUIOptions hostedUIOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HostedUISignInData(HostedUIOptions hostedUIOptions) {
            super(null);
            Intrinsics.checkNotNullParameter(hostedUIOptions, "hostedUIOptions");
            this.hostedUIOptions = hostedUIOptions;
        }

        public static /* synthetic */ HostedUISignInData copy$default(HostedUISignInData hostedUISignInData, HostedUIOptions hostedUIOptions, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                hostedUIOptions = hostedUISignInData.hostedUIOptions;
            }
            return hostedUISignInData.copy(hostedUIOptions);
        }

        public final HostedUIOptions component1() {
            return this.hostedUIOptions;
        }

        public final HostedUISignInData copy(HostedUIOptions hostedUIOptions) {
            Intrinsics.checkNotNullParameter(hostedUIOptions, "hostedUIOptions");
            return new HostedUISignInData(hostedUIOptions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof HostedUISignInData) && Intrinsics.areEqual(this.hostedUIOptions, ((HostedUISignInData) obj).hostedUIOptions)) {
                return true;
            }
            return false;
        }

        public final HostedUIOptions getHostedUIOptions() {
            return this.hostedUIOptions;
        }

        public int hashCode() {
            return this.hostedUIOptions.hashCode();
        }

        public String toString() {
            return "HostedUISignInData(hostedUIOptions=" + this.hostedUIOptions + ')';
        }
    }

    /* compiled from: SignInData.kt */
    /* loaded from: classes.dex */
    public static final class MigrationAuthSignInData extends SignInData {
        private final Map<String, String> metadata;
        private final String password;
        private final String username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MigrationAuthSignInData(String str, String str2, Map<String, String> metadata) {
            super(null);
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.username = str;
            this.password = str2;
            this.metadata = metadata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MigrationAuthSignInData copy$default(MigrationAuthSignInData migrationAuthSignInData, String str, String str2, Map map, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = migrationAuthSignInData.username;
            }
            if ((r4 & 2) != 0) {
                str2 = migrationAuthSignInData.password;
            }
            if ((r4 & 4) != 0) {
                map = migrationAuthSignInData.metadata;
            }
            return migrationAuthSignInData.copy(str, str2, map);
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

        public final MigrationAuthSignInData copy(String str, String str2, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new MigrationAuthSignInData(str, str2, metadata);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MigrationAuthSignInData)) {
                return false;
            }
            MigrationAuthSignInData migrationAuthSignInData = (MigrationAuthSignInData) obj;
            if (Intrinsics.areEqual(this.username, migrationAuthSignInData.username) && Intrinsics.areEqual(this.password, migrationAuthSignInData.password) && Intrinsics.areEqual(this.metadata, migrationAuthSignInData.metadata)) {
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
            int hashCode;
            String str = this.username;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.password;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return this.metadata.hashCode() + ((r0 + r1) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MigrationAuthSignInData(username=");
            sb.append(this.username);
            sb.append(", password=");
            sb.append(this.password);
            sb.append(", metadata=");
            return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
        }
    }

    /* compiled from: SignInData.kt */
    /* loaded from: classes.dex */
    public static final class SRPSignInData extends SignInData {
        private final Map<String, String> metadata;
        private final String password;
        private final String username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SRPSignInData(String str, String str2, Map<String, String> metadata) {
            super(null);
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.username = str;
            this.password = str2;
            this.metadata = metadata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SRPSignInData copy$default(SRPSignInData sRPSignInData, String str, String str2, Map map, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = sRPSignInData.username;
            }
            if ((r4 & 2) != 0) {
                str2 = sRPSignInData.password;
            }
            if ((r4 & 4) != 0) {
                map = sRPSignInData.metadata;
            }
            return sRPSignInData.copy(str, str2, map);
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

        public final SRPSignInData copy(String str, String str2, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new SRPSignInData(str, str2, metadata);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SRPSignInData)) {
                return false;
            }
            SRPSignInData sRPSignInData = (SRPSignInData) obj;
            if (Intrinsics.areEqual(this.username, sRPSignInData.username) && Intrinsics.areEqual(this.password, sRPSignInData.password) && Intrinsics.areEqual(this.metadata, sRPSignInData.metadata)) {
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
            int hashCode;
            String str = this.username;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.password;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return this.metadata.hashCode() + ((r0 + r1) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SRPSignInData(username=");
            sb.append(this.username);
            sb.append(", password=");
            sb.append(this.password);
            sb.append(", metadata=");
            return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.metadata, ')');
        }
    }

    public /* synthetic */ SignInData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SignInData() {
    }
}
