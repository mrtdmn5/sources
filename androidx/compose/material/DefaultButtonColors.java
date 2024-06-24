package androidx.compose.material;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import com.google.common.collect.Platform;

/* compiled from: Button.kt */
/* loaded from: classes.dex */
public final class DefaultButtonColors implements ButtonColors {
    public final long backgroundColor;
    public final long contentColor;
    public final long disabledBackgroundColor;
    public final long disabledContentColor;

    public DefaultButtonColors(long j, long j2, long j3, long j4) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.disabledBackgroundColor = j3;
        this.disabledContentColor = j4;
    }

    @Override // androidx.compose.material.ButtonColors
    public final MutableState backgroundColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(-655254499);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.backgroundColor;
        } else {
            j = this.disabledBackgroundColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.ButtonColors
    public final MutableState contentColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(-2133647540);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.contentColor;
        } else {
            j = this.disabledContentColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultButtonColors.class != obj.getClass()) {
            return false;
        }
        DefaultButtonColors defaultButtonColors = (DefaultButtonColors) obj;
        if (Color.m317equalsimpl0(this.backgroundColor, defaultButtonColors.backgroundColor) && Color.m317equalsimpl0(this.contentColor, defaultButtonColors.contentColor) && Color.m317equalsimpl0(this.disabledBackgroundColor, defaultButtonColors.disabledBackgroundColor) && Color.m317equalsimpl0(this.disabledContentColor, defaultButtonColors.disabledContentColor)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.disabledContentColor) + Scale$$ExternalSyntheticOutline0.m(this.disabledBackgroundColor, Scale$$ExternalSyntheticOutline0.m(this.contentColor, Long.hashCode(this.backgroundColor) * 31, 31), 31);
    }
}
