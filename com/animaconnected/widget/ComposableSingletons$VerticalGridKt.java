package com.animaconnected.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalGrid.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$VerticalGridKt {
    public static final ComposableSingletons$VerticalGridKt INSTANCE = new ComposableSingletons$VerticalGridKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<String, Composer, Integer, Unit> f128lambda1 = ComposableLambdaKt.composableLambdaInstance(1207674276, new Function3<String, Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$VerticalGridKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Composer composer, Integer num) {
            invoke(str, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(String metric, Composer composer, int r28) {
            int r21;
            Intrinsics.checkNotNullParameter(metric, "metric");
            if ((r28 & 14) == 0) {
                r21 = r28 | (composer.changed(metric) ? 4 : 2);
            } else {
                r21 = r28;
            }
            if ((r21 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                androidx.compose.material.TextKt.m216Text4IGK_g(metric, null, ((Colors) composer.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, r21 & 14, 0, 131066);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f129lambda2 = ComposableLambdaKt.composableLambdaInstance(1824464481, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$VerticalGridKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r14) {
            if ((r14 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                VerticalGridKt.m1635VerticalGrid1yyLQnY(BackgroundKt.m21backgroundbw27NRU(Modifier.Companion.$$INSTANCE, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU(), RectangleShapeKt.RectangleShape), CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Steps", "Heartrate", "Calories", "Vo2Max", "Sleep"}), 0.0f, 0.0f, 0, ComposableSingletons$VerticalGridKt.INSTANCE.m1605getLambda1$widget_release(), composer, 196656, 28);
            }
        }
    }, false);

    /* renamed from: getLambda-1$widget_release, reason: not valid java name */
    public final Function3<String, Composer, Integer, Unit> m1605getLambda1$widget_release() {
        return f128lambda1;
    }

    /* renamed from: getLambda-2$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1606getLambda2$widget_release() {
        return f129lambda2;
    }
}
