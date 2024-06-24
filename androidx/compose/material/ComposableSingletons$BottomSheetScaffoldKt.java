package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetScaffold.kt */
/* loaded from: classes.dex */
public final class ComposableSingletons$BottomSheetScaffoldKt {

    /* renamed from: lambda-1, reason: not valid java name */
    public static final ComposableLambdaImpl f2lambda1 = ComposableLambdaKt.composableLambdaInstance(895288908, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(SnackbarHostState snackbarHostState, Composer composer, Integer num) {
            int r8;
            SnackbarHostState it = snackbarHostState;
            Composer composer2 = composer;
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(it, "it");
            if ((intValue & 14) == 0) {
                if (composer2.changed(it)) {
                    r8 = 4;
                } else {
                    r8 = 2;
                }
                intValue |= r8;
            }
            if ((intValue & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                SnackbarHostKt.SnackbarHost(it, null, null, composer2, intValue & 14, 6);
            }
            return Unit.INSTANCE;
        }
    }, false);
}
