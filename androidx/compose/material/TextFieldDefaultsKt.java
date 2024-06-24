package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import com.animaconnected.secondo.R;
import com.google.common.collect.Platform;

/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public final class TextFieldDefaultsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: access$animateBorderStrokeAsState-NuRrP5Q */
    public static final MutableState m212access$animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, Composer composer, int r15) {
        State rememberUpdatedState;
        composer.startReplaceableGroup(1097899920);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (r15 >> 6) & 14);
        State<Color> indicatorColor = textFieldColors.indicatorColor(z, z2, interactionSource, composer, (r15 & 14) | (r15 & 112) | (r15 & 896) | (r15 & 7168));
        if (!((Boolean) collectIsFocusedAsState.getValue()).booleanValue()) {
            f = f2;
        }
        if (z) {
            composer.startReplaceableGroup(1685712066);
            rememberUpdatedState = AnimateAsStateKt.m9animateDpAsStateAjpBEmI(f, AnimationSpecKt.tween$default(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 0, null, 6), composer);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1685712164);
            rememberUpdatedState = Platform.rememberUpdatedState(new Dp(f2), composer);
            composer.endReplaceableGroup();
        }
        MutableState rememberUpdatedState2 = Platform.rememberUpdatedState(new BorderStroke(((Dp) rememberUpdatedState.getValue()).value, new SolidColor(indicatorColor.getValue().value)), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState2;
    }
}
