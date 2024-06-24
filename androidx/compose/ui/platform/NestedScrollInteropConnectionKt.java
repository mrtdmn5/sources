package androidx.compose.ui.platform;

/* compiled from: NestedScrollInteropConnection.kt */
/* loaded from: classes.dex */
public final class NestedScrollInteropConnectionKt {
    public static final int composeToViewOffset(float f) {
        double floor;
        if (f >= 0.0f) {
            floor = Math.ceil(f);
        } else {
            floor = Math.floor(f);
        }
        return ((int) floor) * (-1);
    }
}
