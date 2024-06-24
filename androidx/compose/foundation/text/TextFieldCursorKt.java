package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldCursor.kt */
/* loaded from: classes.dex */
public final class TextFieldCursorKt {
    public static final InfiniteRepeatableSpec cursorAnimationSpec = AnimationSpecKt.m10infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            KeyframesSpec.KeyframesSpecConfig<Float> keyframes = keyframesSpecConfig;
            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
            keyframes.durationMillis = 1000;
            Float valueOf = Float.valueOf(1.0f);
            keyframes.at(0, valueOf);
            keyframes.at(499, valueOf);
            Float valueOf2 = Float.valueOf(0.0f);
            keyframes.at(500, valueOf2);
            keyframes.at(999, valueOf2);
            return Unit.INSTANCE;
        }
    }), null, 6);
    public static final float DefaultCursorThickness = 2;
}
