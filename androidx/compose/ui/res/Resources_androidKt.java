package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Resources.android.kt */
/* loaded from: classes.dex */
public final class Resources_androidKt {
    public static final Resources resources(Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
        return resources;
    }
}
