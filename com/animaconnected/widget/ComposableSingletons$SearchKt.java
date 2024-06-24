package com.animaconnected.widget;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.icons.filled.ClearKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Search.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$SearchKt {
    public static final ComposableSingletons$SearchKt INSTANCE = new ComposableSingletons$SearchKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f119lambda1 = ComposableLambdaKt.composableLambdaInstance(-448583032, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$SearchKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r8) {
            if ((r8 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m188Iconww6aTOc(androidx.compose.material.icons.filled.SearchKt.getSearch(), "", SizeKt.m91size3ABfNKs(Modifier.Companion.$$INSTANCE, 24), composer, 432, 8);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f120lambda2 = ComposableLambdaKt.composableLambdaInstance(-343084224, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$SearchKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r8) {
            if ((r8 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m188Iconww6aTOc(ClearKt.getClear(), "Clear", null, composer, 48, 12);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f121lambda3 = ComposableLambdaKt.composableLambdaInstance(1723725988, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$SearchKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r8) {
            if ((r8 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m188Iconww6aTOc(ClearKt.getClear(), "Clear", null, composer, 48, 12);
            }
        }
    }, false);

    /* renamed from: getLambda-1$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1596getLambda1$widget_release() {
        return f119lambda1;
    }

    /* renamed from: getLambda-2$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1597getLambda2$widget_release() {
        return f120lambda2;
    }

    /* renamed from: getLambda-3$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1598getLambda3$widget_release() {
        return f121lambda3;
    }
}
