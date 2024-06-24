package androidx.compose.ui.text.input;

/* compiled from: GapBuffer.kt */
/* loaded from: classes.dex */
public final class GapBuffer {
    public char[] buffer;
    public int capacity;
    public int gapEnd;
    public int gapStart;

    public GapBuffer(char[] cArr, int r3, int r4) {
        this.capacity = cArr.length;
        this.buffer = cArr;
        this.gapStart = r3;
        this.gapEnd = r4;
    }

    public final String toString() {
        return "";
    }
}
