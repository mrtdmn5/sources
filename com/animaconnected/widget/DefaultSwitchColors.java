package com.animaconnected.widget;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Switch2.kt */
/* loaded from: classes3.dex */
final class DefaultSwitchColors implements SwitchColors2 {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultSwitchColors.class != obj.getClass()) {
            return false;
        }
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) obj;
        if (Color.m317equalsimpl0(this.checkedThumbColor, defaultSwitchColors.checkedThumbColor) && Color.m317equalsimpl0(this.checkedTrackColor, defaultSwitchColors.checkedTrackColor) && Color.m317equalsimpl0(this.uncheckedThumbColor, defaultSwitchColors.uncheckedThumbColor) && Color.m317equalsimpl0(this.uncheckedTrackColor, defaultSwitchColors.uncheckedTrackColor) && Color.m317equalsimpl0(this.disabledCheckedThumbColor, defaultSwitchColors.disabledCheckedThumbColor) && Color.m317equalsimpl0(this.disabledCheckedTrackColor, defaultSwitchColors.disabledCheckedTrackColor) && Color.m317equalsimpl0(this.disabledUncheckedThumbColor, defaultSwitchColors.disabledUncheckedThumbColor) && Color.m317equalsimpl0(this.disabledUncheckedTrackColor, defaultSwitchColors.disabledUncheckedTrackColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.checkedThumbColor;
        int r2 = Color.$r8$clinit;
        return Long.hashCode(this.disabledUncheckedTrackColor) + Scale$$ExternalSyntheticOutline0.m(this.disabledUncheckedThumbColor, Scale$$ExternalSyntheticOutline0.m(this.disabledCheckedTrackColor, Scale$$ExternalSyntheticOutline0.m(this.disabledCheckedThumbColor, Scale$$ExternalSyntheticOutline0.m(this.uncheckedTrackColor, Scale$$ExternalSyntheticOutline0.m(this.uncheckedThumbColor, Scale$$ExternalSyntheticOutline0.m(this.checkedTrackColor, Long.hashCode(j) * 31, 31), 31), 31), 31), 31), 31);
    }

    @Override // com.animaconnected.widget.SwitchColors2
    public State<Color> thumbColor(boolean z, boolean z2, Composer composer, int r4) {
        long j;
        composer.startReplaceableGroup(2029838743);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            if (z2) {
                j = this.checkedThumbColor;
            } else {
                j = this.uncheckedThumbColor;
            }
        } else if (z2) {
            j = this.disabledCheckedThumbColor;
        } else {
            j = this.disabledUncheckedThumbColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // com.animaconnected.widget.SwitchColors2
    public State<Color> trackColor(boolean z, boolean z2, Composer composer, int r4) {
        long j;
        composer.startReplaceableGroup(1982082562);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            if (z2) {
                j = this.checkedTrackColor;
            } else {
                j = this.uncheckedTrackColor;
            }
        } else if (z2) {
            j = this.disabledCheckedTrackColor;
        } else {
            j = this.disabledUncheckedTrackColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.uncheckedThumbColor = j3;
        this.uncheckedTrackColor = j4;
        this.disabledCheckedThumbColor = j5;
        this.disabledCheckedTrackColor = j6;
        this.disabledUncheckedThumbColor = j7;
        this.disabledUncheckedTrackColor = j8;
    }
}
