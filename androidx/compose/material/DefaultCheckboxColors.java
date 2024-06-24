package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import com.google.common.collect.Platform;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Checkbox.kt */
/* loaded from: classes.dex */
public final class DefaultCheckboxColors implements CheckboxColors {
    public final long checkedBorderColor;
    public final long checkedBoxColor;
    public final long checkedCheckmarkColor;
    public final long disabledBorderColor;
    public final long disabledCheckedBoxColor;
    public final long disabledIndeterminateBorderColor;
    public final long disabledIndeterminateBoxColor;
    public final long disabledUncheckedBoxColor;
    public final long uncheckedBorderColor;
    public final long uncheckedBoxColor;
    public final long uncheckedCheckmarkColor;

    /* compiled from: Checkbox.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ToggleableState.values().length];
            try {
                r0[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DefaultCheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledUncheckedBoxColor = j6;
        this.disabledIndeterminateBoxColor = j7;
        this.checkedBorderColor = j8;
        this.uncheckedBorderColor = j9;
        this.disabledBorderColor = j10;
        this.disabledIndeterminateBorderColor = j11;
    }

    @Override // androidx.compose.material.CheckboxColors
    public final State borderColor(boolean z, ToggleableState state, Composer composer) {
        long j;
        State rememberUpdatedState;
        int r9;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(-1568341342);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            int r3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r3 != 1 && r3 != 2) {
                if (r3 == 3) {
                    j = this.uncheckedBorderColor;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                j = this.checkedBorderColor;
            }
        } else {
            int r32 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r32 != 1) {
                if (r32 != 2) {
                    if (r32 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    j = this.disabledIndeterminateBorderColor;
                }
            }
            j = this.disabledBorderColor;
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(-796405227);
            if (state == ToggleableState.Off) {
                r9 = 100;
            } else {
                r9 = 50;
            }
            rememberUpdatedState = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(r9, 0, null, 6), composer, 0, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-796405041);
            rememberUpdatedState = Platform.rememberUpdatedState(new Color(j2), composer);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.CheckboxColors
    public final State boxColor(boolean z, ToggleableState state, Composer composer) {
        long j;
        State rememberUpdatedState;
        int r9;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(840901029);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (z) {
            int r3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r3 != 1 && r3 != 2) {
                if (r3 == 3) {
                    j = this.uncheckedBoxColor;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                j = this.checkedBoxColor;
            }
        } else {
            int r32 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r32 != 1) {
                if (r32 != 2) {
                    if (r32 == 3) {
                        j = this.disabledUncheckedBoxColor;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    j = this.disabledIndeterminateBoxColor;
                }
            } else {
                j = this.disabledCheckedBoxColor;
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(-2010643468);
            if (state == ToggleableState.Off) {
                r9 = 100;
            } else {
                r9 = 50;
            }
            rememberUpdatedState = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(r9, 0, null, 6), composer, 0, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2010643282);
            rememberUpdatedState = Platform.rememberUpdatedState(new Color(j2), composer);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.CheckboxColors
    public final State checkmarkColor(ToggleableState state, Composer composer) {
        long j;
        int r10;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(544656267);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ToggleableState toggleableState = ToggleableState.Off;
        if (state == toggleableState) {
            j = this.uncheckedCheckmarkColor;
        } else {
            j = this.checkedCheckmarkColor;
        }
        long j2 = j;
        if (state == toggleableState) {
            r10 = 100;
        } else {
            r10 = 50;
        }
        State m7animateColorAsStateeuL9pac = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(r10, 0, null, 6), composer, 0, 12);
        composer.endReplaceableGroup();
        return m7animateColorAsStateeuL9pac;
    }
}
