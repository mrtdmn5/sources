package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicTextField.kt */
/* loaded from: classes.dex */
public final class ComposableSingletons$BasicTextFieldKt {

    /* renamed from: lambda-1, reason: not valid java name */
    public static final ComposableLambdaImpl f0lambda1 = ComposableLambdaKt.composableLambdaInstance(997835932, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            int r0;
            Function2<? super Composer, ? super Integer, ? extends Unit> innerTextField = function2;
            Composer composer2 = composer;
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
            if ((intValue & 14) == 0) {
                if (composer2.changedInstance(innerTextField)) {
                    r0 = 4;
                } else {
                    r0 = 2;
                }
                intValue |= r0;
            }
            if ((intValue & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                innerTextField.invoke(composer2, Integer.valueOf(intValue & 14));
            }
            return Unit.INSTANCE;
        }
    }, false);

    static {
        ComposableLambdaKt.composableLambdaInstance(2105616367, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt$lambda-2$1
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
                int r0;
                Function2<? super Composer, ? super Integer, ? extends Unit> innerTextField = function2;
                Composer composer2 = composer;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                if ((intValue & 14) == 0) {
                    if (composer2.changedInstance(innerTextField)) {
                        r0 = 4;
                    } else {
                        r0 = 2;
                    }
                    intValue |= r0;
                }
                if ((intValue & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    innerTextField.invoke(composer2, Integer.valueOf(intValue & 14));
                }
                return Unit.INSTANCE;
            }
        }, false);
        ComposableLambdaKt.composableLambdaInstance(434140383, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt$lambda-3$1
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
                int r0;
                Function2<? super Composer, ? super Integer, ? extends Unit> innerTextField = function2;
                Composer composer2 = composer;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                if ((intValue & 14) == 0) {
                    if (composer2.changedInstance(innerTextField)) {
                        r0 = 4;
                    } else {
                        r0 = 2;
                    }
                    intValue |= r0;
                }
                if ((intValue & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    innerTextField.invoke(composer2, Integer.valueOf(intValue & 14));
                }
                return Unit.INSTANCE;
            }
        }, false);
        ComposableLambdaKt.composableLambdaInstance(-34833998, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt$lambda-4$1
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
                int r0;
                Function2<? super Composer, ? super Integer, ? extends Unit> innerTextField = function2;
                Composer composer2 = composer;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                if ((intValue & 14) == 0) {
                    if (composer2.changedInstance(innerTextField)) {
                        r0 = 4;
                    } else {
                        r0 = 2;
                    }
                    intValue |= r0;
                }
                if ((intValue & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    innerTextField.invoke(composer2, Integer.valueOf(intValue & 14));
                }
                return Unit.INSTANCE;
            }
        }, false);
    }
}
