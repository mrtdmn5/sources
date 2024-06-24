package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.ui.text.TextStyle;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes.dex */
public final class TextKt {
    public static final DynamicProvidableCompositionLocal LocalTextStyle;

    static {
        StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
        TextKt$LocalTextStyle$1 defaultFactory = new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
            @Override // kotlin.jvm.functions.Function0
            public final TextStyle invoke() {
                return TypographyKt.DefaultTextStyle;
            }
        };
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        LocalTextStyle = new DynamicProvidableCompositionLocal(structuralEqualityPolicy, defaultFactory);
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r6) {
        int r0;
        int r1;
        int r02;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1772272796);
        if ((r6 & 14) == 0) {
            if (startRestartGroup.changed(value)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r6;
        } else {
            r0 = r6;
        }
        if ((r6 & 112) == 0) {
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
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{dynamicProvidableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(dynamicProvidableCompositionLocal)).merge(value))}, content, startRestartGroup, (r0 & 112) | 8);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r6 | 1);
                    TextKt.ProvideTextStyle(TextStyle.this, content, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0291  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m216Text4IGK_g(final java.lang.String r37, androidx.compose.ui.Modifier r38, long r39, long r41, androidx.compose.ui.text.font.FontStyle r43, androidx.compose.ui.text.font.FontWeight r44, androidx.compose.ui.text.font.FontFamily r45, long r46, androidx.compose.ui.text.style.TextDecoration r48, androidx.compose.ui.text.style.TextAlign r49, long r50, int r52, boolean r53, int r54, int r55, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r56, androidx.compose.ui.text.TextStyle r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m216Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0351  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m217TextIbK3jfQ(final androidx.compose.ui.text.AnnotatedString r38, androidx.compose.ui.Modifier r39, long r40, long r42, androidx.compose.ui.text.font.FontStyle r44, androidx.compose.ui.text.font.FontWeight r45, androidx.compose.ui.text.font.FontFamily r46, long r47, androidx.compose.ui.text.style.TextDecoration r49, androidx.compose.ui.text.style.TextAlign r50, long r51, int r53, boolean r54, int r55, int r56, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r57, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r58, androidx.compose.ui.text.TextStyle r59, androidx.compose.runtime.Composer r60, final int r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m217TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ae  */
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m218TextfLXpl1I(final java.lang.String r47, androidx.compose.ui.Modifier r48, long r49, long r51, androidx.compose.ui.text.font.FontStyle r53, androidx.compose.ui.text.font.FontWeight r54, androidx.compose.ui.text.font.FontFamily r55, long r56, androidx.compose.ui.text.style.TextDecoration r58, androidx.compose.ui.text.style.TextAlign r59, long r60, int r62, boolean r63, int r64, kotlin.jvm.functions.Function1 r65, androidx.compose.ui.text.TextStyle r66, androidx.compose.runtime.Composer r67, final int r68, final int r69, final int r70) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m218TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
