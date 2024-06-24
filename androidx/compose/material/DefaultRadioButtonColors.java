package androidx.compose.material;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.google.common.collect.Platform;

/* compiled from: RadioButton.kt */
/* loaded from: classes.dex */
public final class DefaultRadioButtonColors implements RadioButtonColors {
    public final long disabledColor;
    public final long selectedColor;
    public final long unselectedColor;

    public DefaultRadioButtonColors(long j, long j2, long j3) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledColor = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultRadioButtonColors.class != obj.getClass()) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) obj;
        if (Color.m317equalsimpl0(this.selectedColor, defaultRadioButtonColors.selectedColor) && Color.m317equalsimpl0(this.unselectedColor, defaultRadioButtonColors.unselectedColor) && Color.m317equalsimpl0(this.disabledColor, defaultRadioButtonColors.disabledColor)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.disabledColor) + Scale$$ExternalSyntheticOutline0.m(this.unselectedColor, Long.hashCode(this.selectedColor) * 31, 31);
    }

    @Override // androidx.compose.material.RadioButtonColors
    public final State radioColor(boolean z, boolean z2, Composer composer) {
        long j;
        State rememberUpdatedState;
        composer.startReplaceableGroup(1243421834);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (!z) {
            j = this.disabledColor;
        } else if (!z2) {
            j = this.unselectedColor;
        } else {
            j = this.selectedColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(-1052799107);
            rememberUpdatedState = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, null, 6), composer, 48, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1052799002);
            rememberUpdatedState = Platform.rememberUpdatedState(new Color(j2), composer);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
