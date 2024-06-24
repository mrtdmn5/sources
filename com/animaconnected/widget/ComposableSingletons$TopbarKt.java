package com.animaconnected.widget;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Topbar.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$TopbarKt {
    public static final ComposableSingletons$TopbarKt INSTANCE = new ComposableSingletons$TopbarKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<BoxScope, Composer, Integer, Unit> f125lambda1 = ComposableLambdaKt.composableLambdaInstance(-383678770, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TopbarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope boxScope, Composer composer, int r4) {
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            if ((r4 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f126lambda2 = ComposableLambdaKt.composableLambdaInstance(-1142778061, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TopbarKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r11) {
            if ((r11 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(android.R.drawable.ic_menu_info_details, composer), "", SizeKt.m91size3ABfNKs(Modifier.Companion.$$INSTANCE, 32), ((Colors) composer.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), composer, 440, 0);
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<BoxScope, Composer, Integer, Unit> f127lambda3 = ComposableLambdaKt.composableLambdaInstance(-917395305, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TopbarKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope TopBar, Composer composer, int r11) {
            Intrinsics.checkNotNullParameter(TopBar, "$this$TopBar");
            if ((r11 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TopbarKt$lambda-3$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, null, false, null, ComposableSingletons$TopbarKt.INSTANCE.m1603getLambda2$widget_release(), composer, 24582, 14);
            }
        }
    }, false);

    /* renamed from: getLambda-1$widget_release, reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m1602getLambda1$widget_release() {
        return f125lambda1;
    }

    /* renamed from: getLambda-2$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1603getLambda2$widget_release() {
        return f126lambda2;
    }

    /* renamed from: getLambda-3$widget_release, reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m1604getLambda3$widget_release() {
        return f127lambda3;
    }
}
