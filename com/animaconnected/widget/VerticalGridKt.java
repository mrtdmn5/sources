package com.animaconnected.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: VerticalGrid.kt */
/* loaded from: classes3.dex */
public final class VerticalGridKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AllVerticalGrid(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1934264975);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changed(composeThemeProvider)) {
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableSingletons$VerticalGridKt.INSTANCE.m1606getLambda2$widget_release(), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.VerticalGridKt$AllVerticalGrid$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    VerticalGridKt.AllVerticalGrid(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x022c, code lost:            androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2.m(r0, false, false, true, false);        r0.end(false);     */
    /* renamed from: VerticalGrid-1yyLQnY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> void m1635VerticalGrid1yyLQnY(androidx.compose.ui.Modifier r19, final java.util.List<? extends T> r20, float r21, float r22, int r23, final kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.VerticalGridKt.m1635VerticalGrid1yyLQnY(androidx.compose.ui.Modifier, java.util.List, float, float, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
