package androidx.compose.ui.semantics;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function0;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class ScrollAxisRange {
    public final Function0<Float> maxValue;
    public final boolean reverseScrolling;
    public final Function0<Float> value;

    public ScrollAxisRange(Function0<Float> function0, Function0<Float> function02, boolean z) {
        this.value = function0;
        this.maxValue = function02;
        this.reverseScrolling = z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScrollAxisRange(value=");
        sb.append(this.value.invoke().floatValue());
        sb.append(", maxValue=");
        sb.append(this.maxValue.invoke().floatValue());
        sb.append(", reverseScrolling=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.reverseScrolling, ')');
    }
}
