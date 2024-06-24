package com.animaconnected.widget;

import android.content.Context;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes3.dex */
public final class TextKt {
    private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ercitation ullamco laboris nisi ";

    public static final void AllTexts(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1426145228);
        if (r9 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            CardKt.m162CardFjzlyU(null, null, 0.0f, ComposableSingletons$TextKt.INSTANCE.m1599getLambda1$widget_release(), startRestartGroup, 1572864, 63);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.TextKt$AllTexts$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    TextKt.AllTexts(composer2, Strings.updateChangedFlags(r9 | 1));
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ad  */
    /* renamed from: CapsText-fLXpl1I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1633CapsTextfLXpl1I(final java.lang.String r51, androidx.compose.ui.Modifier r52, long r53, long r55, androidx.compose.ui.text.font.FontStyle r57, androidx.compose.ui.text.font.FontWeight r58, androidx.compose.ui.text.font.FontFamily r59, long r60, androidx.compose.ui.text.style.TextDecoration r62, androidx.compose.ui.text.style.TextAlign r63, long r64, int r66, boolean r67, int r68, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r69, androidx.compose.ui.text.TextStyle r70, androidx.compose.runtime.Composer r71, final int r72, final int r73, final int r74) {
        /*
            Method dump skipped, instructions count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.TextKt.m1633CapsTextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void FestinaText(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1285256884);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$TextKt.INSTANCE.m1601getLambda3$widget_release(), startRestartGroup, 54);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.TextKt$FestinaText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    TextKt.FestinaText(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void KronabyText(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(242458198);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(KronabyComposeLightThemeProvider.INSTANCE, ComposableSingletons$TextKt.INSTANCE.m1600getLambda2$widget_release(), startRestartGroup, 54);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.TextKt$KronabyText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    TextKt.KronabyText(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$AllTexts(Composer composer, int r1) {
        AllTexts(composer, r1);
    }

    public static final AnnotatedString annotatedStringResource(int r0, Composer composer, int r2) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CharSequence text = ((Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources().getText(r0);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return TextConvertUtilsKt.toAnnotatedText(text);
    }
}
