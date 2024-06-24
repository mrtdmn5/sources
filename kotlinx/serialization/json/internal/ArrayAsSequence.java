package kotlinx.serialization.json.internal;

import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonLexer.kt */
/* loaded from: classes4.dex */
public final class ArrayAsSequence implements CharSequence {
    public final char[] buffer;
    public int length;

    public ArrayAsSequence(char[] cArr) {
        this.buffer = cArr;
        this.length = cArr.length;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r2) {
        return this.buffer[r2];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r2, int r3) {
        return StringsKt__StringsJVMKt.concatToString(this.buffer, r2, Math.min(r3, this.length));
    }
}
