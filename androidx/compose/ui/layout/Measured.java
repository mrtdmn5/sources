package androidx.compose.ui.layout;

/* compiled from: Measured.kt */
/* loaded from: classes.dex */
public interface Measured {
    int get(AlignmentLine alignmentLine);

    default Object getParentData() {
        return null;
    }
}
