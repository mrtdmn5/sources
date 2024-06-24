package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatingActionButton.kt */
/* loaded from: classes.dex */
public final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    public final float defaultElevation;
    public final float focusedElevation;
    public final float hoveredElevation;
    public final float pressedElevation;

    public DefaultFloatingActionButtonElevation(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public final AnimationState elevation(MutableInteractionSource interactionSource, Composer composer, int r14) {
        float f;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-478475335);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Object obj = Composer.Companion.Empty;
        if (rememberedValue == obj) {
            rememberedValue = new SnapshotStateList();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(interactionSource) | composer.changed(snapshotStateList);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == obj) {
            rememberedValue2 = new DefaultFloatingActionButtonElevation$elevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2) rememberedValue2, composer);
        Interaction interaction = (Interaction) CollectionsKt___CollectionsKt.lastOrNull(snapshotStateList);
        if (interaction instanceof PressInteraction$Press) {
            f = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction$Enter) {
            f = this.hoveredElevation;
        } else if (interaction instanceof FocusInteraction$Focus) {
            f = this.focusedElevation;
        } else {
            f = this.defaultElevation;
        }
        float f2 = f;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == obj) {
            rememberedValue3 = new Animatable(new Dp(f2), VectorConvertersKt.DpToVector, (Object) null, 12);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue3;
        EffectsKt.LaunchedEffect(new Dp(f2), new DefaultFloatingActionButtonElevation$elevation$2(animatable, this, f2, interaction, null), composer);
        AnimationState<T, V> animationState = animatable.internalState;
        composer.endReplaceableGroup();
        return animationState;
    }
}
