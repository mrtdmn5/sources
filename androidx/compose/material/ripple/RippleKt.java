package androidx.compose.material.ripple;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.google.common.collect.Platform;

/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public final class RippleKt {
    public static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec<>(15, 0, EasingKt.LinearEasing, 2);

    /* renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final PlatformRipple m226rememberRipple9IZ8Weo(boolean z, float f, Composer composer, int r5, int r6) {
        long j;
        composer.startReplaceableGroup(1635163520);
        if ((r6 & 1) != 0) {
            z = true;
        }
        if ((r6 & 2) != 0) {
            f = Float.NaN;
        }
        if ((r6 & 4) != 0) {
            j = Color.Unspecified;
        } else {
            j = 0;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        Boolean valueOf = Boolean.valueOf(z);
        Dp dp = new Dp(f);
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(valueOf) | composer.changed(dp);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new PlatformRipple(z, f, rememberUpdatedState);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PlatformRipple platformRipple = (PlatformRipple) rememberedValue;
        composer.endReplaceableGroup();
        return platformRipple;
    }
}
