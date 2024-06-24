package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.AndroidOverscrollKt;
import androidx.compose.foundation.NoOpOverscrollEffect;
import androidx.compose.foundation.OverscrollConfiguration;
import androidx.compose.foundation.OverscrollConfigurationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollableDefaults {
    public static OverscrollEffect overscrollEffect(Composer composer) {
        OverscrollEffect overscrollEffect;
        composer.startReplaceableGroup(1809802212);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier modifier = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        composer.startReplaceableGroup(-81138291);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfigurationKt.LocalOverscrollConfiguration);
        if (overscrollConfiguration != null) {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(context) | composer.changed(overscrollConfiguration);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.Empty) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            overscrollEffect = (OverscrollEffect) rememberedValue;
        } else {
            overscrollEffect = NoOpOverscrollEffect.INSTANCE;
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return overscrollEffect;
    }
}
