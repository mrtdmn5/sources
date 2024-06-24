package okhttp3.internal.http;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.ByteString;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes4.dex */
public final class HttpHeaders {
    public static final ByteString QUOTED_STRING_DELIMITERS;
    public static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString byteString = ByteString.EMPTY;
        QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");
    }

    public static final boolean promisesBody(Response response) {
        if (Intrinsics.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int r3 = response.code;
        if (((r3 >= 100 && r3 < 200) || r3 == 204 || r3 == 304) && _UtilJvmKt.headersContentLength(response) == -1 && !StringsKt__StringsJVMKt.equals("chunked", Response.header$default(response, "Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0114, code lost:            continue;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0114, code lost:            continue;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void readChallengeHeader(okio.Buffer r18, java.util.ArrayList r19) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(okio.Buffer, java.util.ArrayList):void");
    }

    public static final String readToken(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (indexOfElement == -1) {
            indexOfElement = buffer.size;
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01cd, code lost:            if (okhttp3.internal._HostnamesCommonKt.VERIFY_AS_IP_ADDRESS.matches(r0) == false) goto L101;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void receiveHeaders(okhttp3.CookieJar r36, okhttp3.HttpUrl r37, okhttp3.Headers r38) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.receiveHeaders(okhttp3.CookieJar, okhttp3.HttpUrl, okhttp3.Headers):void");
    }

    public static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            boolean z2 = true;
            if (b == ((byte) 44)) {
                buffer.readByte();
                z = true;
            } else {
                if (b != ((byte) 32) && b != ((byte) 9)) {
                    z2 = false;
                }
                if (!z2) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z;
    }
}
