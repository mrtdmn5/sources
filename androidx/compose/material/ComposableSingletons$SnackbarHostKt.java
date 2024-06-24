package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackbarHost.kt */
/* loaded from: classes.dex */
public final class ComposableSingletons$SnackbarHostKt {

    /* renamed from: lambda-1, reason: not valid java name */
    public static final ComposableLambdaImpl f7lambda1 = ComposableLambdaKt.composableLambdaInstance(996639038, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$SnackbarHostKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            int r2;
            SnackbarData it = snackbarData;
            Composer composer2 = composer;
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(it, "it");
            if ((intValue & 14) == 0) {
                if (composer2.changed(it)) {
                    r2 = 4;
                } else {
                    r2 = 2;
                }
                intValue |= r2;
            }
            if ((intValue & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                SnackbarKt.m203SnackbarsPrSdHI(it, null, false, null, 0L, 0L, 0L, 0.0f, composer2, intValue & 14, 254);
            }
            return Unit.INSTANCE;
        }
    }, false);
}
