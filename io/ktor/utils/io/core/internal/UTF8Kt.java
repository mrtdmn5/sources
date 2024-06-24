package io.ktor.utils.io.core.internal;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;

/* compiled from: UTF8.kt */
/* loaded from: classes3.dex */
public final class UTF8Kt {
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a4, code lost:            r19.put(r5, (byte) (((r7 >> 6) & 31) | 192));        r19.put(r5 + 1, (byte) ((r7 & '?') | 128));        r6 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b9, code lost:            if (2048 > r7) goto L107;     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bb, code lost:            if (r7 >= 0) goto L107;     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01bd, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c1, code lost:            if (r6 == false) goto L110;     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01c3, code lost:            r19.put(r5, (byte) (((r7 >> '\f') & 15) | 224));        r19.put(r5 + 1, (byte) (((r7 >> 6) & 63) | 128));        r19.put(r5 + 2, (byte) ((r7 & '?') | 128));        r6 = 3;     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01e2, code lost:            if (0 > r7) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e4, code lost:            if (r7 >= 0) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01e6, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ea, code lost:            if (r6 == false) goto L141;     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01ec, code lost:            r19.put(r5, (byte) (((r7 >> 18) & 7) | 240));        r19.put(r5 + 1, (byte) (((r7 >> '\f') & 63) | 128));        r19.put(r5 + 2, (byte) (((r7 >> 6) & 63) | 128));        r19.put(r5 + 3, (byte) ((r7 & '?') | 128));        r6 = 4;     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x021b, code lost:            malformedCodePoint(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x021e, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01e8, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01bf, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01a0, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x018f, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0185, code lost:            r7 = r8 - 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0223, code lost:            r0 = (short) (r7 - r21);        r1 = (short) (r5 - r23);        r2 = 65535;     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x023c, code lost:            return ((r0 & r2) << 16) | (r1 & r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0158, code lost:            r18 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0134, code lost:            if (r8 == r3) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x013e, code lost:            if (java.lang.Character.isLowSurrogate(r20.charAt(r8)) != false) goto L64;     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0141, code lost:            r7 = ((r7 - 55232) << 10) | (r20.charAt(r8) - r9);        r8 = r8 + 1;        r7 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x014f, code lost:            r7 = '?';     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0232, code lost:            r2 = 65535;        r0 = (short) (r7 - r21);        r1 = (short) (r5 - r23);     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011c, code lost:            if (r5 != r6) goto L123;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011e, code lost:            r6 = r4 - r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0120, code lost:            if (r6 <= 0) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0122, code lost:            if (r7 < r3) goto L57;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:            r8 = r7 + 1;        r7 = r20.charAt(r7);        r18 = java.lang.Character.isHighSurrogate(r7);        r7 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0130, code lost:            if (r18 != false) goto L60;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0132, code lost:            r9 = 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0151, code lost:            if (1 > r7) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0153, code lost:            if (r7 >= 128) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0155, code lost:            r18 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x015a, code lost:            if (r18 == false) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015d, code lost:            if (128 > r7) goto L75;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015f, code lost:            if (r7 >= 2048) goto L75;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0161, code lost:            r18 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0166, code lost:            if (r18 == false) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0168, code lost:            r9 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016a, code lost:            if (2048 > r7) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016c, code lost:            if (r7 >= 0) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x016e, code lost:            r18 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0173, code lost:            if (r18 == false) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0175, code lost:            r9 = 3;     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0177, code lost:            if (0 > r7) goto L87;     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0179, code lost:            if (r7 >= 0) goto L87;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017b, code lost:            r18 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0180, code lost:            if (r18 == false) goto L137;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0182, code lost:            r9 = 4;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x021f, code lost:            malformedCodePoint(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0222, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017e, code lost:            r18 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0171, code lost:            r18 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0164, code lost:            r18 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0183, code lost:            if (r9 <= r6) goto L92;     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0189, code lost:            if (r7 < 0) goto L95;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018b, code lost:            if (r7 >= 128) goto L95;     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018d, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0191, code lost:            if (r6 == false) goto L98;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0193, code lost:            r19.put(r5, (byte) r7);        r6 = 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0214, code lost:            r5 = r5 + r6;        r7 = r8;        r9 = 56320;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x019a, code lost:            if (128 > r7) goto L101;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:            if (r7 >= 2048) goto L101;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x019e, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a2, code lost:            if (r6 == false) goto L104;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* renamed from: encodeUTF8-lBXzO7A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int m1659encodeUTF8lBXzO7A(java.nio.ByteBuffer r19, java.lang.CharSequence r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.m1659encodeUTF8lBXzO7A(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int):int");
    }

    public static final void malformedCodePoint(int r3) {
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Malformed code-point ", r3, " found"));
    }
}
