package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Handshake.kt */
/* loaded from: classes4.dex */
public final class Handshake {
    public final CipherSuite cipherSuite;
    public final List<Certificate> localCertificates;
    public final SynchronizedLazyImpl peerCertificates$delegate;
    public final TlsVersion tlsVersion;

    /* compiled from: Handshake.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static okhttp3.Handshake get(javax.net.ssl.SSLSession r5) throws java.io.IOException {
            /*
                kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
                java.lang.String r1 = r5.getCipherSuite()
                if (r1 == 0) goto L82
                java.lang.String r2 = "TLS_NULL_WITH_NULL_NULL"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                if (r2 == 0) goto L12
                r2 = 1
                goto L18
            L12:
                java.lang.String r2 = "SSL_NULL_WITH_NULL_NULL"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            L18:
                if (r2 != 0) goto L76
                okhttp3.CipherSuite$Companion r2 = okhttp3.CipherSuite.Companion
                okhttp3.CipherSuite r1 = r2.forJavaName(r1)
                java.lang.String r2 = r5.getProtocol()
                if (r2 == 0) goto L6a
                java.lang.String r3 = "NONE"
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
                if (r3 != 0) goto L62
                okhttp3.TlsVersion$Companion r3 = okhttp3.TlsVersion.Companion
                r3.getClass()
                okhttp3.TlsVersion r2 = okhttp3.TlsVersion.Companion.forJavaName(r2)
                java.security.cert.Certificate[] r3 = r5.getPeerCertificates()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> L47
                if (r3 == 0) goto L47
                int r4 = r3.length     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> L47
                java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> L47
                java.util.List r3 = okhttp3.internal._UtilJvmKt.immutableListOf(r3)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> L47
                goto L48
            L47:
                r3 = r0
            L48:
                okhttp3.Handshake r4 = new okhttp3.Handshake
                java.security.cert.Certificate[] r5 = r5.getLocalCertificates()
                if (r5 == 0) goto L59
                int r0 = r5.length
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r0)
                java.util.List r0 = okhttp3.internal._UtilJvmKt.immutableListOf(r5)
            L59:
                okhttp3.Handshake$Companion$handshake$1 r5 = new okhttp3.Handshake$Companion$handshake$1
                r5.<init>()
                r4.<init>(r2, r1, r0, r5)
                return r4
            L62:
                java.io.IOException r5 = new java.io.IOException
                java.lang.String r0 = "tlsVersion == NONE"
                r5.<init>(r0)
                throw r5
            L6a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "tlsVersion == null"
                java.lang.String r0 = r0.toString()
                r5.<init>(r0)
                throw r5
            L76:
                java.io.IOException r5 = new java.io.IOException
                java.lang.String r0 = "cipherSuite == "
                java.lang.String r0 = r0.concat(r1)
                r5.<init>(r0)
                throw r5
            L82:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "cipherSuite == null"
                java.lang.String r0 = r0.toString()
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Handshake.Companion.get(javax.net.ssl.SSLSession):okhttp3.Handshake");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> localCertificates, final Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Certificate> invoke() {
                try {
                    return function0.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.INSTANCE;
                }
            }
        });
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && Intrinsics.areEqual(handshake.cipherSuite, this.cipherSuite) && Intrinsics.areEqual(handshake.peerCertificates(), peerCertificates()) && Intrinsics.areEqual(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
            }
            arrayList.add(type2);
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
