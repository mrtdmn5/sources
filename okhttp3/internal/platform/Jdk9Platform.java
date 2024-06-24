package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;

/* compiled from: Jdk9Platform.kt */
/* loaded from: classes4.dex */
public final class Jdk9Platform extends Platform {
    public static final boolean isAvailable;
    public static final Integer majorVersion;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:            if (r0.intValue() >= 9) goto L30;     */
    static {
        /*
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto Ld
            java.lang.Integer r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0)
            goto Le
        Ld:
            r0 = 0
        Le:
            okhttp3.internal.platform.Jdk9Platform.majorVersion = r0
            r1 = 0
            if (r0 == 0) goto L1c
            int r0 = r0.intValue()
            r2 = 9
            if (r0 < r2) goto L26
            goto L25
        L1c:
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r2 = "getApplicationProtocol"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchMethodException -> L26
            r0.getMethod(r2, r3)     // Catch: java.lang.NoSuchMethodException -> L26
        L25:
            r1 = 1
        L26:
            okhttp3.internal.platform.Jdk9Platform.isAvailable = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Jdk9Platform.<clinit>():void");
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol;
        boolean areEqual;
        try {
            applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(applicationProtocol, "");
            }
        } catch (UnsupportedOperationException unused) {
        }
        if (areEqual) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() {
        SSLContext sSLContext;
        Integer num = majorVersion;
        if (num != null && num.intValue() >= 9) {
            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
            Intrinsics.checkNotNullExpressionValue(sSLContext2, "getInstance(\"TLS\")");
            return sSLContext2;
        }
        try {
            sSLContext = SSLContext.getInstance("TLSv1.3");
        } catch (NoSuchAlgorithmException unused) {
            sSLContext = SSLContext.getInstance("TLS");
        }
        Intrinsics.checkNotNullExpressionValue(sSLContext, "try {\n          // Based…Instance(\"TLS\")\n        }");
        return sSLContext;
    }
}
