package com.animaconnected.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: BackgroundCard.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$BackgroundCardKt {
    public static final ComposableSingletons$BackgroundCardKt INSTANCE = new ComposableSingletons$BackgroundCardKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f111lambda1 = ComposableLambdaKt.composableLambdaInstance(-1560342616, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$BackgroundCardKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f112lambda2 = ComposableLambdaKt.composableLambdaInstance(-1515293120, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$BackgroundCardKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
        }
    }, false);

    /* renamed from: getLambda-1$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1588getLambda1$widget_release() {
        return f111lambda1;
    }

    /* renamed from: getLambda-2$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1589getLambda2$widget_release() {
        return f112lambda2;
    }
}
