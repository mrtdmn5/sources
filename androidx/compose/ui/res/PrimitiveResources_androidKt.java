package androidx.compose.ui.res;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;

/* compiled from: PrimitiveResources.android.kt */
/* loaded from: classes.dex */
public final class PrimitiveResources_androidKt {
    public static final float dimensionResource(int r2, Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        return ((Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources().getDimension(r2) / ((Density) composer.consume(CompositionLocalsKt.LocalDensity)).getDensity();
    }
}
