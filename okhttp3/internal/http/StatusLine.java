package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Protocol;

/* compiled from: StatusLine.kt */
/* loaded from: classes4.dex */
public final class StatusLine {
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* compiled from: StatusLine.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static StatusLine parse(String statusLine) throws IOException {
            Protocol protocol;
            int r1;
            String str;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (StringsKt__StringsJVMKt.startsWith(statusLine, "HTTP/1.", false)) {
                r1 = 9;
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt != 0) {
                        if (charAt == 1) {
                            protocol = Protocol.HTTP_1_1;
                        } else {
                            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                        }
                    } else {
                        protocol = Protocol.HTTP_1_0;
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
            } else if (StringsKt__StringsJVMKt.startsWith(statusLine, "ICY ", false)) {
                protocol = Protocol.HTTP_1_0;
                r1 = 4;
            } else if (StringsKt__StringsJVMKt.startsWith(statusLine, "SOURCETABLE ", false)) {
                protocol = Protocol.HTTP_1_1;
                r1 = 12;
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int r6 = r1 + 3;
            if (statusLine.length() >= r6) {
                String substring = statusLine.substring(r1, r6);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(substring);
                if (intOrNull != null) {
                    int intValue = intOrNull.intValue();
                    if (statusLine.length() > r6) {
                        if (statusLine.charAt(r6) == ' ') {
                            str = statusLine.substring(r1 + 4);
                            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                        }
                    } else {
                        str = "";
                    }
                    return new StatusLine(protocol, intValue, str);
                }
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
    }

    public StatusLine(Protocol protocol, int r3, String str) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
        this.code = r3;
        this.message = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
