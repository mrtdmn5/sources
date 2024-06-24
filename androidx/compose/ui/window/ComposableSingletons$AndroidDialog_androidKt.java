package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class ComposableSingletons$AndroidDialog_androidKt {

    /* renamed from: lambda-1, reason: not valid java name */
    public static final ComposableLambdaImpl f13lambda1 = ComposableLambdaKt.composableLambdaInstance(210148896, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.ComposableSingletons$AndroidDialog_androidKt$lambda-1$1
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
