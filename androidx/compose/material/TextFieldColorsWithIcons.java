package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public interface TextFieldColorsWithIcons extends TextFieldColors {
    default State<Color> leadingIconColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r5) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1279189910);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState leadingIconColor = leadingIconColor(z, z2, composer);
        composer.endReplaceableGroup();
        return leadingIconColor;
    }

    default State<Color> trailingIconColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r5) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-712140408);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState trailingIconColor = trailingIconColor(z, z2, composer);
        composer.endReplaceableGroup();
        return trailingIconColor;
    }
}
