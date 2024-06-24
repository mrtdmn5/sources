package androidx.compose.runtime;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class KeyInfo {
    public final int key;
    public final int location;
    public final int nodes;
    public final Object objectKey;

    public KeyInfo(int r1, int r2, int r3, Object obj) {
        this.key = r1;
        this.objectKey = obj;
        this.location = r2;
        this.nodes = r3;
    }
}
