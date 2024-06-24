package okhttp3;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.TlsVersion;
import okhttp3.internal._UtilCommonKt;

/* compiled from: ConnectionSpec.kt */
/* loaded from: classes4.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec MODERN_TLS;
    public final String[] cipherSuitesAsString;
    public final boolean isTls;
    public final boolean supportsTlsExtensions;
    public final String[] tlsVersionsAsString;

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        Builder builder = new Builder();
        builder.cipherSuites((CipherSuite[]) Arrays.copyOf(new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9}, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.tlsVersions(tlsVersion, tlsVersion2);
        builder.supportsTlsExtensions();
        builder.build();
        Builder builder2 = new Builder();
        builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16));
        builder2.tlsVersions(tlsVersion, tlsVersion2);
        builder2.supportsTlsExtensions();
        MODERN_TLS = builder2.build();
        Builder builder3 = new Builder();
        builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16));
        builder3.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        builder3.supportsTlsExtensions();
        builder3.build();
        CLEARTEXT = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean z) {
        String[] tlsVersionsIntersection;
        boolean z2;
        String[] socketEnabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        Intrinsics.checkNotNullExpressionValue(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            socketEnabledCipherSuites = _UtilCommonKt.intersect(socketEnabledCipherSuites, strArr, CipherSuite.ORDER_BY_NAME);
        }
        String[] strArr2 = this.tlsVersionsAsString;
        if (strArr2 != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = _UtilCommonKt.intersect(enabledProtocols, strArr2, NaturalOrderComparator.INSTANCE);
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        CipherSuite$Companion$ORDER_BY_NAME$1 cipherSuite$Companion$ORDER_BY_NAME$1 = CipherSuite.ORDER_BY_NAME;
        byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
        int length = supportedCipherSuites.length;
        int r6 = 0;
        while (true) {
            if (r6 < length) {
                if (cipherSuite$Companion$ORDER_BY_NAME$1.compare(supportedCipherSuites[r6], "TLS_FALLBACK_SCSV") == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                } else {
                    r6++;
                }
            } else {
                r6 = -1;
                break;
            }
        }
        if (z && r6 != -1) {
            String str = supportedCipherSuites[r6];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] copyOf = Arrays.copyOf(socketEnabledCipherSuites, socketEnabledCipherSuites.length + 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            socketEnabledCipherSuites = (String[]) copyOf;
            socketEnabledCipherSuites[socketEnabledCipherSuites.length - 1] = str;
        }
        Builder builder = new Builder(this);
        builder.cipherSuites((String[]) Arrays.copyOf(socketEnabledCipherSuites, socketEnabledCipherSuites.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        builder.tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        ConnectionSpec build = builder.build();
        if (build.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(build.tlsVersionsAsString);
        }
        if (build.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(build.cipherSuitesAsString);
        }
    }

    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(CipherSuite.Companion.forJavaName(str));
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = connectionSpec.isTls;
        boolean z2 = this.isTls;
        if (z2 != z) {
            return false;
        }
        if (z2 && (!Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) || !Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) || this.supportsTlsExtensions != connectionSpec.supportsTlsExtensions)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int r1;
        if (this.isTls) {
            int r0 = 0;
            String[] strArr = this.cipherSuitesAsString;
            if (strArr != null) {
                r1 = Arrays.hashCode(strArr);
            } else {
                r1 = 0;
            }
            int r2 = (527 + r1) * 31;
            String[] strArr2 = this.tlsVersionsAsString;
            if (strArr2 != null) {
                r0 = Arrays.hashCode(strArr2);
            }
            return ((r2 + r0) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                TlsVersion.Companion.getClass();
                arrayList.add(TlsVersion.Companion.forJavaName(str));
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return null;
    }

    public final String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        StringBuilder sb = new StringBuilder("ConnectionSpec(cipherSuites=");
        sb.append(Objects.toString(cipherSuites(), "[all enabled]"));
        sb.append(", tlsVersions=");
        sb.append(Objects.toString(tlsVersions(), "[all enabled]"));
        sb.append(", supportsTlsExtensions=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.supportsTlsExtensions, ')');
    }

    /* compiled from: ConnectionSpec.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public String[] cipherSuites;
        public boolean supportsTlsExtensions;
        public final boolean tls;
        public String[] tlsVersions;

        public Builder() {
            this.tls = true;
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final void cipherSuites(CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(cipherSuites.length);
                for (CipherSuite cipherSuite : cipherSuites) {
                    arrayList.add(cipherSuite.javaName);
                }
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final void supportsTlsExtensions() {
            if (this.tls) {
                this.supportsTlsExtensions = true;
                return;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final void tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                ArrayList arrayList = new ArrayList(tlsVersionArr.length);
                for (TlsVersion tlsVersion : tlsVersionArr) {
                    arrayList.add(tlsVersion.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public Builder(ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls;
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public final void tlsVersions(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(tlsVersions.length == 0)) {
                Object clone = tlsVersions.clone();
                Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                this.tlsVersions = (String[]) clone;
                return;
            }
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }

        public final void cipherSuites(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(cipherSuites.length == 0)) {
                Object clone = cipherSuites.clone();
                Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                this.cipherSuites = (String[]) clone;
                return;
            }
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }
    }
}
