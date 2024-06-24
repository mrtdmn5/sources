package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.common.base.Objects;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
/* loaded from: classes.dex */
public final class ContentTransform {
    public final ExitTransition initialContentExit;
    public final SizeTransform sizeTransform;
    public final EnterTransition targetContentEnter;
    public final ParcelableSnapshotMutableFloatState targetContentZIndex$delegate;

    public ContentTransform(EnterTransitionImpl targetContentEnter, ExitTransitionImpl initialContentExit) {
        AnimatedContentKt$SizeTransform$1 sizeAnimationSpec = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
            @Override // kotlin.jvm.functions.Function2
            public final SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                long j = intSize.packedValue;
                long j2 = intSize2.packedValue;
                Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
                return AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1);
            }
        };
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        SizeTransformImpl sizeTransformImpl = new SizeTransformImpl(true, sizeAnimationSpec);
        Intrinsics.checkNotNullParameter(targetContentEnter, "targetContentEnter");
        Intrinsics.checkNotNullParameter(initialContentExit, "initialContentExit");
        this.targetContentEnter = targetContentEnter;
        this.initialContentExit = initialContentExit;
        this.targetContentZIndex$delegate = Objects.mutableFloatStateOf(0.0f);
        this.sizeTransform = sizeTransformImpl;
    }
}
