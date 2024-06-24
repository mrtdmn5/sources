package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyAnimateScroll.kt */
/* loaded from: classes.dex */
public final class ItemFoundInScroll extends CancellationException {
    public final int itemOffset;
    public final AnimationState<Float, AnimationVector1D> previousAnimation;

    public ItemFoundInScroll(int r2, AnimationState<Float, AnimationVector1D> previousAnimation) {
        Intrinsics.checkNotNullParameter(previousAnimation, "previousAnimation");
        this.itemOffset = r2;
        this.previousAnimation = previousAnimation;
    }
}
