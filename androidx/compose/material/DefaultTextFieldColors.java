package androidx.compose.material;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.animaconnected.secondo.R;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public final class DefaultTextFieldColors implements TextFieldColors {
    public final long backgroundColor;
    public final long cursorColor;
    public final long disabledIndicatorColor;
    public final long disabledLabelColor;
    public final long disabledLeadingIconColor;
    public final long disabledPlaceholderColor;
    public final long disabledTextColor;
    public final long disabledTrailingIconColor;
    public final long errorCursorColor;
    public final long errorIndicatorColor;
    public final long errorLabelColor;
    public final long errorLeadingIconColor;
    public final long errorTrailingIconColor;
    public final long focusedIndicatorColor;
    public final long focusedLabelColor;
    public final long leadingIconColor;
    public final long placeholderColor;
    public final long textColor;
    public final long trailingIconColor;
    public final long unfocusedIndicatorColor;
    public final long unfocusedLabelColor;

    public DefaultTextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        this.textColor = j;
        this.disabledTextColor = j2;
        this.cursorColor = j3;
        this.errorCursorColor = j4;
        this.focusedIndicatorColor = j5;
        this.unfocusedIndicatorColor = j6;
        this.errorIndicatorColor = j7;
        this.disabledIndicatorColor = j8;
        this.leadingIconColor = j9;
        this.disabledLeadingIconColor = j10;
        this.errorLeadingIconColor = j11;
        this.trailingIconColor = j12;
        this.disabledTrailingIconColor = j13;
        this.errorTrailingIconColor = j14;
        this.backgroundColor = j15;
        this.focusedLabelColor = j16;
        this.unfocusedLabelColor = j17;
        this.disabledLabelColor = j18;
        this.errorLabelColor = j19;
        this.placeholderColor = j20;
        this.disabledPlaceholderColor = j21;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState backgroundColor(Composer composer) {
        composer.startReplaceableGroup(-1423938813);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(this.backgroundColor), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState cursorColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(-1446422485);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.errorCursorColor;
        } else {
            j = this.cursorColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultTextFieldColors.class != obj.getClass()) {
            return false;
        }
        DefaultTextFieldColors defaultTextFieldColors = (DefaultTextFieldColors) obj;
        if (Color.m317equalsimpl0(this.textColor, defaultTextFieldColors.textColor) && Color.m317equalsimpl0(this.disabledTextColor, defaultTextFieldColors.disabledTextColor) && Color.m317equalsimpl0(this.cursorColor, defaultTextFieldColors.cursorColor) && Color.m317equalsimpl0(this.errorCursorColor, defaultTextFieldColors.errorCursorColor) && Color.m317equalsimpl0(this.focusedIndicatorColor, defaultTextFieldColors.focusedIndicatorColor) && Color.m317equalsimpl0(this.unfocusedIndicatorColor, defaultTextFieldColors.unfocusedIndicatorColor) && Color.m317equalsimpl0(this.errorIndicatorColor, defaultTextFieldColors.errorIndicatorColor) && Color.m317equalsimpl0(this.disabledIndicatorColor, defaultTextFieldColors.disabledIndicatorColor) && Color.m317equalsimpl0(this.leadingIconColor, defaultTextFieldColors.leadingIconColor) && Color.m317equalsimpl0(this.disabledLeadingIconColor, defaultTextFieldColors.disabledLeadingIconColor) && Color.m317equalsimpl0(this.errorLeadingIconColor, defaultTextFieldColors.errorLeadingIconColor) && Color.m317equalsimpl0(this.trailingIconColor, defaultTextFieldColors.trailingIconColor) && Color.m317equalsimpl0(this.disabledTrailingIconColor, defaultTextFieldColors.disabledTrailingIconColor) && Color.m317equalsimpl0(this.errorTrailingIconColor, defaultTextFieldColors.errorTrailingIconColor) && Color.m317equalsimpl0(this.backgroundColor, defaultTextFieldColors.backgroundColor) && Color.m317equalsimpl0(this.focusedLabelColor, defaultTextFieldColors.focusedLabelColor) && Color.m317equalsimpl0(this.unfocusedLabelColor, defaultTextFieldColors.unfocusedLabelColor) && Color.m317equalsimpl0(this.disabledLabelColor, defaultTextFieldColors.disabledLabelColor) && Color.m317equalsimpl0(this.errorLabelColor, defaultTextFieldColors.errorLabelColor) && Color.m317equalsimpl0(this.placeholderColor, defaultTextFieldColors.placeholderColor) && Color.m317equalsimpl0(this.disabledPlaceholderColor, defaultTextFieldColors.disabledPlaceholderColor)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.disabledPlaceholderColor) + Scale$$ExternalSyntheticOutline0.m(this.placeholderColor, Scale$$ExternalSyntheticOutline0.m(this.errorLabelColor, Scale$$ExternalSyntheticOutline0.m(this.disabledLabelColor, Scale$$ExternalSyntheticOutline0.m(this.unfocusedLabelColor, Scale$$ExternalSyntheticOutline0.m(this.focusedLabelColor, Scale$$ExternalSyntheticOutline0.m(this.backgroundColor, Scale$$ExternalSyntheticOutline0.m(this.errorTrailingIconColor, Scale$$ExternalSyntheticOutline0.m(this.disabledTrailingIconColor, Scale$$ExternalSyntheticOutline0.m(this.trailingIconColor, Scale$$ExternalSyntheticOutline0.m(this.errorLeadingIconColor, Scale$$ExternalSyntheticOutline0.m(this.disabledLeadingIconColor, Scale$$ExternalSyntheticOutline0.m(this.leadingIconColor, Scale$$ExternalSyntheticOutline0.m(this.disabledIndicatorColor, Scale$$ExternalSyntheticOutline0.m(this.errorIndicatorColor, Scale$$ExternalSyntheticOutline0.m(this.unfocusedIndicatorColor, Scale$$ExternalSyntheticOutline0.m(this.focusedIndicatorColor, Scale$$ExternalSyntheticOutline0.m(this.errorCursorColor, Scale$$ExternalSyntheticOutline0.m(this.cursorColor, Scale$$ExternalSyntheticOutline0.m(this.disabledTextColor, Long.hashCode(this.textColor) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.material.TextFieldColors
    public final State<Color> indicatorColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r12) {
        long j;
        State<Color> rememberUpdatedState;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(998675979);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (r12 >> 6) & 14);
        if (!z) {
            j = this.disabledIndicatorColor;
        } else if (z2) {
            j = this.errorIndicatorColor;
        } else if (((Boolean) collectIsFocusedAsState.getValue()).booleanValue()) {
            j = this.focusedIndicatorColor;
        } else {
            j = this.unfocusedIndicatorColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(-2054190397);
            rememberUpdatedState = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 0, null, 6), composer, 48, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2054190292);
            rememberUpdatedState = Platform.rememberUpdatedState(new Color(j2), composer);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.material.TextFieldColors
    public final MutableState labelColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r6) {
        long j;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(727091888);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (r6 >> 6) & 14);
        if (!z) {
            j = this.disabledLabelColor;
        } else if (z2) {
            j = this.errorLabelColor;
        } else if (((Boolean) collectIsFocusedAsState.getValue()).booleanValue()) {
            j = this.focusedLabelColor;
        } else {
            j = this.unfocusedLabelColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState leadingIconColor(boolean z, boolean z2, Composer composer) {
        long j;
        composer.startReplaceableGroup(1016171324);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (!z) {
            j = this.disabledLeadingIconColor;
        } else if (z2) {
            j = this.errorLeadingIconColor;
        } else {
            j = this.leadingIconColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState placeholderColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(264799724);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.placeholderColor;
        } else {
            j = this.disabledPlaceholderColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState textColor(boolean z, Composer composer) {
        long j;
        composer.startReplaceableGroup(9804418);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            j = this.textColor;
        } else {
            j = this.disabledTextColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    public final MutableState trailingIconColor(boolean z, boolean z2, Composer composer) {
        long j;
        composer.startReplaceableGroup(225259054);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (!z) {
            j = this.disabledTrailingIconColor;
        } else if (z2) {
            j = this.errorTrailingIconColor;
        } else {
            j = this.trailingIconColor;
        }
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Color(j), composer);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
