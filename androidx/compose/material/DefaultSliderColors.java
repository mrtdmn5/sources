package androidx.compose.material;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import com.google.common.collect.Platform;

/* compiled from: Slider.kt */
/* loaded from: classes.dex */
public final class DefaultSliderColors implements SliderColors {
    public final long activeTickColor;
    public final long activeTrackColor;
    public final long disabledActiveTickColor;
    public final long disabledActiveTrackColor;
    public final long disabledInactiveTickColor;
    public final long disabledInactiveTrackColor;
    public final long disabledThumbColor;
    public final long inactiveTickColor;
    public final long inactiveTrackColor;
    public final long thumbColor;

    public DefaultSliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.thumbColor = j;
        this.disabledThumbColor = j2;
        this.activeTrackColor = j3;
        this.inactiveTrackColor = j4;
        this.disabledActiveTrackColor = j5;
        this.disabledInactiveTrackColor = j6;
        this.activeTickColor = j7;
        this.inactiveTickColor = j8;
        this.disabledActiveTickColor = j9;
        this.disabledInactiveTickColor = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultSliderColors.class != obj.getClass()) {
            return false;
        }
        DefaultSliderColors defaultSliderColors = (DefaultSliderColors) obj;
        if (Color.m317equalsimpl0(this.thumbColor, defaultSliderColors.thumbColor) && Color.m317equalsimpl0(this.disabledThumbColor, defaultSliderColors.disabledThumbColor) && Color.m317equalsimpl0(this.activeTrackColor, defaultSliderColors.activeTrackColor) && Color.m317equalsimpl0(this.inactiveTrackColor, defaultSliderColors.inactiveTrackColor) && Color.m317equalsimpl0(this.disabledActiveTrackColor, defaultSliderColors.disabledActiveTrackColor) && Color.m317equalsimpl0(this.disabledInactiveTrackColor, defaultSliderColors.disabledInactiveTrackColor) && Color.m317equalsimpl0(this.activeTickColor, defaultSliderColors.activeTickColor) && Color.m317equalsimpl0(this.inactiveTickColor, defaultSliderColors.inactiveTickColor) && Color.m317equalsimpl0(this.disabledActiveTickColor, defaultSliderColors.disabledActiveTickColor) && Color.m317equalsimpl0(this.disabledInactiveTickColor, defaultSliderColors.disabledInactiveTickColor)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.disabledInactiveTickColor) + Scale$$ExternalSyntheticOutline0.m(this.disabledActiveTickColor, Scale$$ExternalSyntheticOutline0.m(this.inactiveTickColor, Scale$$ExternalSyntheticOutline0.m(this.activeTickColor, Scale$$ExternalSyntheticOutline0.m(this.disabledInactiveTrackColor, Scale$$ExternalSyntheticOutline0.m(this.disabledActiveTrackColor, Scale$$ExternalSyntheticOutline0.m(this.inactiveTrackColor, Scale$$ExternalSyntheticOutline0.m(this.activeTrackColor, Scale$$ExternalSyntheticOutline0.m(this.disabledThumbColor, Long.hashCode(this.thumbColor) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @Override // androidx.compose.material.SliderColors
    public final MutableState thumbColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(-1733795637);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.thumbColor;
        } else {
            j = this.disabledThumbColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    public final MutableState tickColor(boolean z, boolean z2, Composer composer) {
        long j;
        composer.startReplaceableGroup(-1491563694);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            if (z2) {
                j = this.activeTickColor;
            } else {
                j = this.inactiveTickColor;
            }
        } else if (z2) {
            j = this.disabledActiveTickColor;
        } else {
            j = this.disabledInactiveTickColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    public final MutableState trackColor(boolean z, boolean z2, Composer composer) {
        long j;
        composer.startReplaceableGroup(1575395620);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            if (z2) {
                j = this.activeTrackColor;
            } else {
                j = this.inactiveTrackColor;
            }
        } else if (z2) {
            j = this.disabledActiveTrackColor;
        } else {
            j = this.disabledInactiveTrackColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
