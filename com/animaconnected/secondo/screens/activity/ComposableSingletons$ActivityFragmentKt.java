package com.animaconnected.secondo.screens.activity;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$ActivityFragmentKt {
    public static final ComposableSingletons$ActivityFragmentKt INSTANCE = new ComposableSingletons$ActivityFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f24lambda1 = ComposableLambdaKt.composableLambdaInstance(43351751, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ComposableSingletons$ActivityFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r10) {
            if ((r10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_overflow_vert, composer), "", null, ((Colors) composer.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), composer, 56, 4);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f25lambda2 = ComposableLambdaKt.composableLambdaInstance(2000599987, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ComposableSingletons$ActivityFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope DropdownMenuItem, Composer composer, int r30) {
            Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
            if ((r30 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.activity_set_goal_title, composer), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer.consume(TypographyKt.LocalTypography)).subtitle1, composer, 0, 0, 65534);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m828getLambda1$secondo_kronabyRelease() {
        return f24lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m829getLambda2$secondo_kronabyRelease() {
        return f25lambda2;
    }
}
