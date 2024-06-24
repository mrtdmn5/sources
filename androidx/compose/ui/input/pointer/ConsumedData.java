package androidx.compose.ui.input.pointer;

/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class ConsumedData {
    public boolean downChange;
    public boolean positionChange;

    public ConsumedData(boolean z, boolean z2) {
        this.positionChange = z;
        this.downChange = z2;
    }
}
