package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.unit.Dp;

/* compiled from: FloatingActionButton.kt */
/* loaded from: classes.dex */
public final class FloatingActionButtonDefaults {
    /* renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public static DefaultFloatingActionButtonElevation m184elevationxZ9QkE(Composer composer) {
        composer.startReplaceableGroup(380403812);
        float f = 6;
        float f2 = 12;
        float f3 = 8;
        float f4 = 8;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object[] objArr = {new Dp(f), new Dp(f2), new Dp(f3), new Dp(f4)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int r5 = 0; r5 < 4; r5++) {
            z |= composer.changed(objArr[r5]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new DefaultFloatingActionButtonElevation(f, f2, f3, f4);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) rememberedValue;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
