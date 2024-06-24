package androidx.compose.ui.text.input;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: GapBuffer.kt */
/* loaded from: classes.dex */
public final class PartialGapBuffer {
    public int bufEnd;
    public int bufStart;
    public GapBuffer buffer;
    public String text;

    public PartialGapBuffer(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.length();
        }
        return (gapBuffer.capacity - (gapBuffer.gapEnd - gapBuffer.gapStart)) + (this.text.length() - (this.bufEnd - this.bufStart));
    }

    public final void replace(int r9, int r10, String text) {
        boolean z;
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z2 = true;
        if (r9 <= r10) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r9 < 0) {
                z2 = false;
            }
            if (z2) {
                GapBuffer gapBuffer = this.buffer;
                if (gapBuffer == null) {
                    int max = Math.max(255, text.length() + 128);
                    char[] cArr = new char[max];
                    int min = Math.min(r9, 64);
                    int min2 = Math.min(this.text.length() - r10, 64);
                    int r6 = r9 - min;
                    MessageFormatter.toCharArray(this.text, cArr, 0, r6, r9);
                    int r0 = max - min2;
                    int r3 = min2 + r10;
                    MessageFormatter.toCharArray(this.text, cArr, r0, r10, r3);
                    MessageFormatter.toCharArray(text, cArr, min, 0, text.length());
                    this.buffer = new GapBuffer(cArr, text.length() + min, r0);
                    this.bufStart = r6;
                    this.bufEnd = r3;
                    return;
                }
                int r2 = this.bufStart;
                int r32 = r9 - r2;
                int r22 = r10 - r2;
                if (r32 >= 0 && r22 <= gapBuffer.capacity - (gapBuffer.gapEnd - gapBuffer.gapStart)) {
                    int length = text.length() - (r22 - r32);
                    int r102 = gapBuffer.gapEnd - gapBuffer.gapStart;
                    if (length > r102) {
                        int r92 = length - r102;
                        int r103 = gapBuffer.capacity;
                        do {
                            r103 *= 2;
                        } while (r103 - gapBuffer.capacity < r92);
                        char[] cArr2 = new char[r103];
                        ArraysKt___ArraysJvmKt.copyInto(gapBuffer.buffer, cArr2, 0, 0, gapBuffer.gapStart);
                        int r4 = gapBuffer.capacity;
                        int r5 = gapBuffer.gapEnd;
                        int r42 = r4 - r5;
                        int r62 = r103 - r42;
                        ArraysKt___ArraysJvmKt.copyInto(gapBuffer.buffer, cArr2, r62, r5, r42 + r5);
                        gapBuffer.buffer = cArr2;
                        gapBuffer.capacity = r103;
                        gapBuffer.gapEnd = r62;
                    }
                    int r93 = gapBuffer.gapStart;
                    if (r32 < r93 && r22 <= r93) {
                        int r104 = r93 - r22;
                        char[] cArr3 = gapBuffer.buffer;
                        ArraysKt___ArraysJvmKt.copyInto(cArr3, cArr3, gapBuffer.gapEnd - r104, r22, r93);
                        gapBuffer.gapStart = r32;
                        gapBuffer.gapEnd -= r104;
                    } else if (r32 < r93 && r22 >= r93) {
                        gapBuffer.gapEnd = (gapBuffer.gapEnd - r93) + r22;
                        gapBuffer.gapStart = r32;
                    } else {
                        int r105 = gapBuffer.gapEnd;
                        int r43 = r105 - r93;
                        int r33 = r32 + r43;
                        char[] cArr4 = gapBuffer.buffer;
                        ArraysKt___ArraysJvmKt.copyInto(cArr4, cArr4, r93, r105, r33);
                        gapBuffer.gapStart += r33 - r105;
                        gapBuffer.gapEnd = r43 + r22;
                    }
                    MessageFormatter.toCharArray(text, gapBuffer.buffer, gapBuffer.gapStart, 0, text.length());
                    gapBuffer.gapStart = text.length() + gapBuffer.gapStart;
                    return;
                }
                this.text = toString();
                this.buffer = null;
                this.bufStart = -1;
                this.bufEnd = -1;
                replace(r9, r10, text);
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("start must be non-negative, but was ", r9).toString());
        }
        throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("start index must be less than or equal to end index: ", r9, " > ", r10).toString());
    }

    public final String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        sb.append(gapBuffer.buffer, 0, gapBuffer.gapStart);
        char[] cArr = gapBuffer.buffer;
        int r3 = gapBuffer.gapEnd;
        sb.append(cArr, r3, gapBuffer.capacity - r3);
        String str = this.text;
        sb.append((CharSequence) str, this.bufEnd, str.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
