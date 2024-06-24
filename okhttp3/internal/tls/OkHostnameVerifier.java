package okhttp3.internal.tls;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkHostnameVerifier.kt */
/* loaded from: classes4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    public static List getSubjectAltNames(X509Certificate x509Certificate, int r6) {
        Object obj;
        EmptyList emptyList = EmptyList.INSTANCE;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(r6)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return emptyList;
        }
    }

    public static boolean isAscii(String str) {
        boolean z;
        boolean z2;
        int r7;
        char c;
        int length = str.length();
        int length2 = str.length();
        if (length2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (length2 <= str.length()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                long j = 0;
                int r6 = 0;
                while (r6 < length2) {
                    char charAt = str.charAt(r6);
                    if (charAt < 128) {
                        j++;
                    } else {
                        if (charAt < 2048) {
                            r7 = 2;
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int r11 = r6 + 1;
                            if (r11 < length2) {
                                c = str.charAt(r11);
                            } else {
                                c = 0;
                            }
                            if (charAt <= 56319 && c >= 56320 && c <= 57343) {
                                j += 4;
                                r6 += 2;
                            } else {
                                j++;
                                r6 = r11;
                            }
                        } else {
                            r7 = 3;
                        }
                        j += r7;
                    }
                    r6++;
                }
                if (length != ((int) j)) {
                    return false;
                }
                return true;
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("endIndex > string.length: ", length2, " > ");
            m.append(str.length());
            throw new IllegalArgumentException(m.toString().toString());
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("endIndex < beginIndex: ", length2, " < 0").toString());
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String host, SSLSession session) {
        Certificate certificate;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[LOOP:1: B:29:0x0077->B:63:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean verify(java.lang.String r11, java.security.cert.X509Certificate r12) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.OkHostnameVerifier.verify(java.lang.String, java.security.cert.X509Certificate):boolean");
    }
}
