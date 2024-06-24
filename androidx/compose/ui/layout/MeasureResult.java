package androidx.compose.ui.layout;

import java.util.Map;

/* compiled from: MeasureResult.kt */
/* loaded from: classes.dex */
public interface MeasureResult {
    Map<AlignmentLine, Integer> getAlignmentLines();

    int getHeight();

    int getWidth();

    void placeChildren();
}
