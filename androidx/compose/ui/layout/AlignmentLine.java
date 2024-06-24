package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;

/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public abstract class AlignmentLine {
    public final Function2<Integer, Integer, Integer> merger;

    public AlignmentLine() {
        throw null;
    }

    public AlignmentLine(Function2 function2) {
        this.merger = function2;
    }
}
