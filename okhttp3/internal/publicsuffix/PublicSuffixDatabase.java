package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._UtilCommonKt;
import okio.GzipSource;
import okio.Okio;
import okio.RealBufferedSource;

/* compiled from: PublicSuffixDatabase.kt */
/* loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    public static final List<String> PREVAILING_RULE;
    public static final byte[] WILDCARD_LABEL;
    public static final PublicSuffixDatabase instance;
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public final AtomicBoolean listRead = new AtomicBoolean(false);
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* compiled from: PublicSuffixDatabase.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final String access$binarySearch(byte[] bArr, byte[][] bArr2, int r20) {
            int r10;
            boolean z;
            int r9;
            int r92;
            byte[] bArr3 = PublicSuffixDatabase.WILDCARD_LABEL;
            int length = bArr.length;
            int r4 = 0;
            while (r4 < length) {
                int r5 = (r4 + length) / 2;
                while (r5 > -1 && bArr[r5] != ((byte) 10)) {
                    r5--;
                }
                int r52 = r5 + 1;
                int r93 = 1;
                while (true) {
                    r10 = r52 + r93;
                    if (bArr[r10] == ((byte) 10)) {
                        break;
                    }
                    r93++;
                }
                int r7 = r10 - r52;
                int r11 = r20;
                boolean z2 = false;
                int r12 = 0;
                int r13 = 0;
                while (true) {
                    if (z2) {
                        r9 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[r11][r12];
                        byte[] bArr4 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                        int r14 = b & 255;
                        z = z2;
                        r9 = r14;
                    }
                    byte b2 = bArr[r52 + r13];
                    byte[] bArr5 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                    r92 = r9 - (b2 & 255);
                    if (r92 != 0) {
                        break;
                    }
                    r13++;
                    r12++;
                    if (r13 == r7) {
                        break;
                    }
                    if (bArr2[r11].length == r12) {
                        if (r11 == bArr2.length - 1) {
                            break;
                        }
                        r11++;
                        r12 = -1;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                if (r92 >= 0) {
                    if (r92 <= 0) {
                        int r6 = r7 - r13;
                        int length2 = bArr2[r11].length - r12;
                        int length3 = bArr2.length;
                        for (int r112 = r11 + 1; r112 < length3; r112++) {
                            length2 += bArr2[r112].length;
                        }
                        if (length2 >= r6) {
                            if (length2 <= r6) {
                                return new String(bArr, r52, r7, Charsets.UTF_8);
                            }
                        }
                    }
                    r4 = r10 + 1;
                }
                length = r52 - 1;
            }
            return null;
        }
    }

    static {
        new Companion();
        WILDCARD_LABEL = new byte[]{(byte) 42};
        PREVAILING_RULE = CollectionsKt__CollectionsKt.listOf("*");
        instance = new PublicSuffixDatabase();
    }

    public static List splitDomain(String str) {
        List split$default = StringsKt__StringsKt.split$default(0, 6, str, new char[]{'.'});
        if (Intrinsics.areEqual(CollectionsKt___CollectionsKt.last(split$default), "")) {
            return CollectionsKt___CollectionsKt.dropLast(split$default);
        }
        return split$default;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00db, code lost:            r7 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00bc, code lost:            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00bf, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00c0, code lost:            r11 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:            if (r1 != false) goto L15;     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0038, code lost:            java.lang.Thread.currentThread().interrupt();     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0036, code lost:            if (r1 == false) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:            if (r1 <= 1) goto L55;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:            r5 = (byte[][]) r4.clone();        r9 = r5.length - 1;        r10 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:            if (r10 >= r9) goto L129;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:            r5[r10] = okhttp3.internal.publicsuffix.PublicSuffixDatabase.WILDCARD_LABEL;        r11 = r12.publicSuffixListBytes;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:            if (r11 == null) goto L127;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:            r11 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion.access$binarySearch(r11, r5, r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:            if (r11 == null) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b9, code lost:            r10 = r10 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c1, code lost:            if (r11 == null) goto L67;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c3, code lost:            r1 = r1 - 1;        r5 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c5, code lost:            if (r5 >= r1) goto L130;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c7, code lost:            r7 = r12.publicSuffixExceptionListBytes;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:            if (r7 == null) goto L131;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:            r7 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion.access$binarySearch(r7, r4, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:            if (r7 == null) goto L64;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:            r5 = r5 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00df, code lost:            if (r7 == null) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:            r1 = kotlin.text.StringsKt__StringsKt.split$default(0, 6, "!".concat(r7), new char[]{'.'});     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0126, code lost:            if (r0.size() != r1.size()) goto L89;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:            if (r1.get(0).charAt(0) == '!') goto L89;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:            return null;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013f, code lost:            if (r1.get(0).charAt(0) != '!') goto L92;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0141, code lost:            r0 = r0.size();        r1 = r1.size();     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0153, code lost:            r0 = r0 - r1;        r13 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(splitDomain(r13));     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:            if (r0 < 0) goto L96;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:            r1 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0163, code lost:            if (r1 == false) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0165, code lost:            if (r0 != 0) goto L100;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016a, code lost:            if ((r13 instanceof kotlin.sequences.DropTakeSequence) == false) goto L103;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016c, code lost:            r13 = ((kotlin.sequences.DropTakeSequence) r13).drop(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0173, code lost:            r13 = new kotlin.sequences.DropSequence(r13, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0179, code lost:            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, "<this>");        r0 = new java.lang.StringBuilder();        r0.append((java.lang.CharSequence) "");        r13 = r13.iterator();     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:            if (r13.hasNext() == false) goto L133;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0192, code lost:            r4 = r13.next();        r2 = r2 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0197, code lost:            if (r2 <= 1) goto L135;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0199, code lost:            r0.append((java.lang.CharSequence) com.amazonaws.services.s3.model.InstructionFileId.DOT);     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019e, code lost:            kotlin.text.StringsKt__AppendableKt.appendElement(r0, r4, null);     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:            r0.append((java.lang.CharSequence) "");        r13 = r0.toString();        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ae, code lost:            return r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c0, code lost:            throw new java.lang.IllegalArgumentException(androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", r0, " is less than zero.").toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0162, code lost:            r1 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014a, code lost:            r0 = r0.size();        r1 = r1.size() + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f0, code lost:            if (r8 != null) goto L74;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f2, code lost:            if (r11 != null) goto L74;     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00f4, code lost:            r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.PREVAILING_RULE;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f7, code lost:            r5 = kotlin.collections.EmptyList.INSTANCE;     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f9, code lost:            if (r8 == null) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fb, code lost:            r7 = kotlin.text.StringsKt__StringsKt.split$default(0, 6, r8, new char[]{'.'});     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0105, code lost:            if (r11 == null) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0107, code lost:            r1 = kotlin.text.StringsKt__StringsKt.split$default(0, 6, r11, new char[]{'.'});     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0119, code lost:            if (r7.size() <= r1.size()) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x011b, code lost:            r1 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0110, code lost:            r1 = r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0104, code lost:            r7 = r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00d5, code lost:            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00da, code lost:            throw null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getEffectiveTldPlusOne(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.getEffectiveTldPlusOne(java.lang.String):java.lang.String");
    }

    public final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("PublicSuffixDatabase.gz");
        if (resourceAsStream == null) {
            return;
        }
        RealBufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            long readInt = buffer.readInt();
            buffer.require(readInt);
            byte[] readByteArray = buffer.bufferField.readByteArray(readInt);
            long readInt2 = buffer.readInt();
            buffer.require(readInt2);
            byte[] readByteArray2 = buffer.bufferField.readByteArray(readInt2);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(buffer, null);
            synchronized (this) {
                this.publicSuffixListBytes = readByteArray;
                this.publicSuffixExceptionListBytes = readByteArray2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }
}
