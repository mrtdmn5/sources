package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class ChangeSize {
    public final Alignment alignment;
    public final FiniteAnimationSpec<IntSize> animationSpec;
    public final boolean clip;
    public final Function1<IntSize, IntSize> size;

    public ChangeSize(FiniteAnimationSpec animationSpec, Alignment alignment, Function1 size, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.alignment = alignment;
        this.size = size;
        this.animationSpec = animationSpec;
        this.clip = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        if (Intrinsics.areEqual(this.alignment, changeSize.alignment) && Intrinsics.areEqual(this.size, changeSize.size) && Intrinsics.areEqual(this.animationSpec, changeSize.animationSpec) && this.clip == changeSize.clip) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.animationSpec.hashCode() + ((this.size.hashCode() + (this.alignment.hashCode() * 31)) * 31)) * 31;
        boolean z = this.clip;
        int r1 = z;
        if (z != 0) {
            r1 = 1;
        }
        return hashCode + r1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChangeSize(alignment=");
        sb.append(this.alignment);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", animationSpec=");
        sb.append(this.animationSpec);
        sb.append(", clip=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.clip, ')');
    }
}
