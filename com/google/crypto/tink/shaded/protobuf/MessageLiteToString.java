package com.google.crypto.tink.shaded.protobuf;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MessageLiteToString {
    public static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int r1 = 0; r1 < str.length(); r1++) {
            char charAt = str.charAt(r1);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static final void printField(StringBuilder sb, int r7, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, r7, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                printField(sb, r7, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int r0 = 0;
        for (int r1 = 0; r1 < r7; r1++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
            sb.append(TextFormatEscaper.escapeBytes(new ByteString.LiteralByteString(((String) obj).getBytes(Internal.UTF_8))));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, r7 + 2);
            sb.append("\n");
            while (r0 < r7) {
                sb.append(' ');
                r0++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int r8 = r7 + 2;
            printField(sb, r8, TransferTable.COLUMN_KEY, entry.getKey());
            printField(sb, r8, "value", entry.getValue());
            sb.append("\n");
            while (r0 < r7) {
                sb.append(' ');
                r0++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ad, code lost:            if (((java.lang.Integer) r4).intValue() == 0) goto L228;     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0204, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01be, code lost:            if (((java.lang.Float) r4).floatValue() == 0.0f) goto L228;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d0, code lost:            if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L228;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void reflectivePrintWithIndent(com.google.crypto.tink.shaded.protobuf.MessageLite r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageLiteToString.reflectivePrintWithIndent(com.google.crypto.tink.shaded.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }
}
