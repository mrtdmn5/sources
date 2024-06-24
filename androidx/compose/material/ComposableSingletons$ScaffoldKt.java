package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class ComposableSingletons$ScaffoldKt {

    /* renamed from: lambda-1, reason: not valid java name */
    public static final ComposableLambdaImpl f3lambda1 = ComposableLambdaKt.composableLambdaInstance(2069405901, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
            return Unit.INSTANCE;
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static final ComposableLambdaImpl f4lambda2 = ComposableLambdaKt.composableLambdaInstance(-231850563, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
            return Unit.INSTANCE;
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static final ComposableLambdaImpl f5lambda3 = ComposableLambdaKt.composableLambdaInstance(-147687984, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-3$1
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

    /* renamed from: lambda-4, reason: not valid java name */
    public static final ComposableLambdaImpl f6lambda4 = ComposableLambdaKt.composableLambdaInstance(-900670499, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
            return Unit.INSTANCE;
        }
    }, false);
}
