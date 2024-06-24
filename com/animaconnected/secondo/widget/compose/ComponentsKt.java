package com.animaconnected.secondo.widget.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Components.kt */
/* loaded from: classes3.dex */
public final class ComponentsKt {
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.widget.compose.ComponentsKt$BrandTheme$1] */
    public static final void BrandTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r5) {
        int r0;
        int r02;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-210950977);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r5;
        } else {
            r0 = r5;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(ProviderFactory.INSTANCE.getThemeProvider(), ComposableLambdaKt.composableLambda(startRestartGroup, -1498658385, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ComponentsKt$BrandTheme$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    if ((r3 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        content.invoke(composer2, 0);
                    }
                }
            }), startRestartGroup, 56);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ComponentsKt$BrandTheme$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    ComponentsKt.BrandTheme(content, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }
}
