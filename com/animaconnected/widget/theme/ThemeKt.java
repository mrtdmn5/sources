package com.animaconnected.widget.theme;

import androidx.compose.foundation.OverscrollConfiguration;
import androidx.compose.foundation.OverscrollConfigurationKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Theme.kt */
/* loaded from: classes3.dex */
public final class ThemeKt {
    /* JADX WARN: Type inference failed for: r0v9, types: [com.animaconnected.widget.theme.ThemeKt$BrandTheme$1, kotlin.jvm.internal.Lambda] */
    public static final void BrandTheme(final ComposeThemeProvider themeProvider, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r11) {
        int r0;
        int r1;
        int r02;
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1995898184);
        if ((r11 & 14) == 0) {
            if (startRestartGroup.changed(themeProvider)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r11;
        } else {
            r0 = r11;
        }
        if ((r11 & 112) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            MaterialThemeKt.MaterialTheme(themeProvider.getBrandColors(), themeProvider.getBrandTypography(), themeProvider.getBrandShapes(), ComposableLambdaKt.composableLambda(startRestartGroup, -476443660, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.theme.ThemeKt$BrandTheme$1
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

                /* JADX WARN: Type inference failed for: r0v6, types: [com.animaconnected.widget.theme.ThemeKt$BrandTheme$1$1, kotlin.jvm.internal.Lambda] */
                public final void invoke(Composer composer2, int r8) {
                    if ((r8 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    float f = -300;
                    ProvidedValue[] providedValueArr = {ContentColorKt.LocalContentColor.provides(new Color(ComposeThemeProvider.this.getBrandColors().m166getOnBackground0d7_KjU())), OverscrollConfigurationKt.LocalOverscrollConfiguration.provides(new OverscrollConfiguration(Color.Transparent, new PaddingValuesImpl(f, f, f, f)))};
                    final Function2<Composer, Integer, Unit> function2 = content;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.composableLambda(composer2, 630100148, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.theme.ThemeKt$BrandTheme$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int r3) {
                            if ((r3 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                function2.invoke(composer3, 0);
                            }
                        }
                    }), composer2, 56);
                }
            }), startRestartGroup, 3072, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.theme.ThemeKt$BrandTheme$2
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

                public final void invoke(Composer composer2, int r4) {
                    ThemeKt.BrandTheme(ComposeThemeProvider.this, content, composer2, Strings.updateChangedFlags(r11 | 1));
                }
            };
        }
    }
}
