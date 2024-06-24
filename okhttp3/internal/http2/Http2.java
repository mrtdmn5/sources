package okhttp3.internal.http2;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt;
import okio.ByteString;

/* compiled from: Http2.kt */
/* loaded from: classes4.dex */
public final class Http2 {
    public static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    public static final String[] FLAGS;
    public static final String[] FRAME_NAMES;
    public static final Http2 INSTANCE = new Http2();

    static {
        ByteString byteString = ByteString.EMPTY;
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int r3 = 0; r3 < 256; r3++) {
            String binaryString = Integer.toBinaryString(r3);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            String replace = _UtilJvmKt.format("%8s", binaryString).replace(' ', '0');
            Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
            strArr[r3] = replace;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] r1 = {1};
        strArr2[8] = "PADDED";
        int r32 = r1[0];
        strArr2[r32 | 8] = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), strArr2[r32], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] r0 = {4, 32, 36};
        for (int r33 = 0; r33 < 3; r33++) {
            int r4 = r0[r33];
            int r6 = r1[0];
            String[] strArr3 = FLAGS;
            int r9 = r6 | r4;
            strArr3[r9] = strArr3[r6] + '|' + strArr3[r4];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[r6]);
            sb.append('|');
            strArr3[r9 | 8] = ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, strArr3[r4], "|PADDED");
        }
        int length = FLAGS.length;
        for (int r2 = 0; r2 < length; r2++) {
            String[] strArr4 = FLAGS;
            if (strArr4[r2] == null) {
                strArr4[r2] = BINARY[r2];
            }
        }
    }

    public static String formattedType$okhttp(int r2) {
        String[] strArr = FRAME_NAMES;
        if (r2 < strArr.length) {
            return strArr[r2];
        }
        return _UtilJvmKt.format("0x%02x", Integer.valueOf(r2));
    }

    public static String frameLog(boolean z, int r5, int r6, int r7, int r8) {
        String str;
        String str2;
        String str3;
        String formattedType$okhttp = formattedType$okhttp(r7);
        if (r8 == 0) {
            str = "";
        } else {
            String[] strArr = BINARY;
            if (r7 != 2 && r7 != 3) {
                if (r7 != 4 && r7 != 6) {
                    if (r7 != 7 && r7 != 8) {
                        String[] strArr2 = FLAGS;
                        if (r8 < strArr2.length) {
                            str2 = strArr2[r8];
                            Intrinsics.checkNotNull(str2);
                        } else {
                            str2 = strArr[r8];
                        }
                        if (r7 == 5 && (r8 & 4) != 0) {
                            str = StringsKt__StringsJVMKt.replace$default(str2, "HEADERS", "PUSH_PROMISE");
                        } else if (r7 == 0 && (r8 & 32) != 0) {
                            str = StringsKt__StringsJVMKt.replace$default(str2, "PRIORITY", "COMPRESSED");
                        } else {
                            str = str2;
                        }
                    }
                } else if (r8 == 1) {
                    str = "ACK";
                } else {
                    str = strArr[r8];
                }
            }
            str = strArr[r8];
        }
        if (z) {
            str3 = "<<";
        } else {
            str3 = ">>";
        }
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", str3, Integer.valueOf(r5), Integer.valueOf(r6), formattedType$okhttp, str);
    }

    public static String frameLogWindowUpdate(boolean z, int r2, int r3, long j) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(8);
        if (z) {
            str = "<<";
        } else {
            str = ">>";
        }
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", str, Integer.valueOf(r2), Integer.valueOf(r3), formattedType$okhttp, Long.valueOf(j));
    }
}
