package okhttp3;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CipherSuite.kt */
/* loaded from: classes4.dex */
public final class CipherSuite {
    public static final Companion Companion;
    public static final LinkedHashMap INSTANCES;
    public static final CipherSuite$Companion$ORDER_BY_NAME$1 ORDER_BY_NAME;
    public static final CipherSuite TLS_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public final String javaName;

    /* compiled from: CipherSuite.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final CipherSuite access$init(Companion companion, String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        public final synchronized CipherSuite forJavaName(String javaName) {
            CipherSuite cipherSuite;
            String str;
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            LinkedHashMap linkedHashMap = CipherSuite.INSTANCES;
            cipherSuite = (CipherSuite) linkedHashMap.get(javaName);
            if (cipherSuite == null) {
                if (StringsKt__StringsJVMKt.startsWith(javaName, "TLS_", false)) {
                    String substring = javaName.substring(4);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    str = "SSL_".concat(substring);
                } else if (StringsKt__StringsJVMKt.startsWith(javaName, "SSL_", false)) {
                    String substring2 = javaName.substring(4);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    str = "TLS_".concat(substring2);
                } else {
                    str = javaName;
                }
                cipherSuite = (CipherSuite) linkedHashMap.get(str);
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(javaName);
                }
                linkedHashMap.put(javaName, cipherSuite);
            }
            return cipherSuite;
        }
    }

    static {
        Companion companion = new Companion();
        Companion = companion;
        ORDER_BY_NAME = new CipherSuite$Companion$ORDER_BY_NAME$1();
        INSTANCES = new LinkedHashMap();
        Companion.access$init(companion, "SSL_RSA_WITH_NULL_MD5");
        Companion.access$init(companion, "SSL_RSA_WITH_NULL_SHA");
        Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_MD5");
        Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_SHA");
        Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Companion.access$init(companion, "SSL_RSA_WITH_DES_CBC_SHA");
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_DSS_WITH_DES_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_RSA_WITH_DES_CBC_SHA");
        Companion.access$init(companion, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        Companion.access$init(companion, "SSL_DH_anon_WITH_RC4_128_MD5");
        Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        Companion.access$init(companion, "SSL_DH_anon_WITH_DES_CBC_SHA");
        Companion.access$init(companion, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_SHA");
        Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_MD5");
        Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_MD5");
        Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        TLS_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA");
        TLS_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_RSA_WITH_NULL_SHA256");
        Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA256");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        Companion.access$init(companion, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Companion.access$init(companion, "TLS_PSK_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_PSK_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_PSK_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_RSA_WITH_SEED_CBC_SHA");
        TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_RSA_WITH_AES_128_GCM_SHA256");
        TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_RSA_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        Companion.access$init(companion, "TLS_FALLBACK_SCSV");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_NULL_SHA");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_NULL_SHA");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_NULL_SHA");
        Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_anon_WITH_NULL_SHA");
        Companion.access$init(companion, "TLS_ECDH_anon_WITH_RC4_128_SHA");
        Companion.access$init(companion, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        Companion.access$init(companion, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        TLS_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_AES_128_GCM_SHA256");
        TLS_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_AES_256_GCM_SHA384");
        TLS_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_CHACHA20_POLY1305_SHA256");
        Companion.access$init(companion, "TLS_AES_128_CCM_SHA256");
        Companion.access$init(companion, "TLS_AES_128_CCM_8_SHA256");
    }

    public CipherSuite(String str) {
        this.javaName = str;
    }

    public final String toString() {
        return this.javaName;
    }
}
