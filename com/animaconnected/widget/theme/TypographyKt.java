package com.animaconnected.widget.theme;

import androidx.compose.material.Typography;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphKt;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.animaconnected.widget.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Typography.kt */
/* loaded from: classes3.dex */
public final class TypographyKt {
    private static final Typography KronabyTypography;
    private static final Typography MainTypography;
    private static final FontFamily interFontFamily;

    static {
        int r1 = R.font.inter_medium;
        FontWeight fontWeight = FontWeight.Medium;
        int r12 = R.font.inter_semi_bold;
        FontWeight fontWeight2 = FontWeight.SemiBold;
        int r13 = R.font.inter_regular;
        FontWeight fontWeight3 = FontWeight.Normal;
        FontListFontFamily fontListFontFamily = new FontListFontFamily(ArraysKt___ArraysJvmKt.asList(new Font[]{FontKt.m535FontYpTlLL0$default(r1, fontWeight), FontKt.m535FontYpTlLL0$default(r12, fontWeight2), FontKt.m535FontYpTlLL0$default(r13, fontWeight3)}));
        interFontFamily = fontListFontFamily;
        Typography typography = new Typography(fontListFontFamily, new TextStyle(0L, TextUnitKt.getSp(24), fontWeight2, null, 0L, TextUnitKt.getSp(36), 16646137), new TextStyle(0L, TextUnitKt.getSp(20), fontWeight2, null, 0L, TextUnitKt.getSp(30), 16646137), new TextStyle(0L, TextUnitKt.getSp(16), fontWeight2, null, TextUnitKt.getEm(0.03125d), TextUnitKt.getSp(24), 16646009), new TextStyle(0L, TextUnitKt.getSp(13), fontWeight, null, TextUnitKt.getEm(0.0384d), TextUnitKt.getSp(19.5d), 16646009), new TextStyle(0L, TextUnitKt.getSp(11), fontWeight2, null, TextUnitKt.getEm(0.0454d), TextUnitKt.getSp(16.5d), 16646009), new TextStyle(0L, TextUnitKt.getSp(16), fontWeight3, null, TextUnitKt.getEm(0.0454d), 0L, 16777081), new TextStyle(0L, TextUnitKt.getSp(16), fontWeight3, null, 0L, TextUnitKt.getSp(24), 16646137), new TextStyle(0L, TextUnitKt.getSp(13), fontWeight2, "s2sc", TextUnitKt.getEm(0.0384d), TextUnitKt.getSp(19.5d), 16645945), new TextStyle(0L, TextUnitKt.getSp(11), fontWeight3, null, TextUnitKt.getEm(0.0454d), TextUnitKt.getSp(16.5d), 16646009), 9536);
        MainTypography = typography;
        TextStyle m529copyv2rsoow$default = TextStyle.m529copyv2rsoow$default(16777211, 0L, 0L, 0L, null, typography.h1, null, fontWeight);
        TextStyle m529copyv2rsoow$default2 = TextStyle.m529copyv2rsoow$default(16777211, 0L, 0L, 0L, null, typography.h2, null, fontWeight);
        TextStyle m529copyv2rsoow$default3 = TextStyle.m529copyv2rsoow$default(16777211, 0L, 0L, 0L, null, typography.h3, null, fontWeight);
        TextStyle m529copyv2rsoow$default4 = TextStyle.m529copyv2rsoow$default(16777211, 0L, 0L, 0L, null, typography.h5, null, fontWeight);
        TextStyle h4 = typography.h4;
        Intrinsics.checkNotNullParameter(h4, "h4");
        TextStyle h6 = typography.h6;
        Intrinsics.checkNotNullParameter(h6, "h6");
        TextStyle subtitle1 = typography.subtitle1;
        Intrinsics.checkNotNullParameter(subtitle1, "subtitle1");
        TextStyle subtitle2 = typography.subtitle2;
        Intrinsics.checkNotNullParameter(subtitle2, "subtitle2");
        TextStyle body1 = typography.body1;
        Intrinsics.checkNotNullParameter(body1, "body1");
        TextStyle body2 = typography.body2;
        Intrinsics.checkNotNullParameter(body2, "body2");
        TextStyle button = typography.button;
        Intrinsics.checkNotNullParameter(button, "button");
        TextStyle caption = typography.caption;
        Intrinsics.checkNotNullParameter(caption, "caption");
        TextStyle overline = typography.overline;
        Intrinsics.checkNotNullParameter(overline, "overline");
        KronabyTypography = new Typography(m529copyv2rsoow$default, m529copyv2rsoow$default2, m529copyv2rsoow$default3, h4, m529copyv2rsoow$default4, h6, subtitle1, subtitle2, body1, body2, button, caption, overline);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0179 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0085  */
    /* renamed from: BigText-ZHfKjFs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1636BigTextZHfKjFs(androidx.compose.ui.Modifier r36, final java.lang.String r37, final long r38, androidx.compose.ui.text.style.TextAlign r40, int r41, int r42, boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.theme.TypographyKt.m1636BigTextZHfKjFs(androidx.compose.ui.Modifier, java.lang.String, long, androidx.compose.ui.text.style.TextAlign, int, int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long BigText_ZHfKjFs$lambda$1(MutableState<TextUnit> mutableState) {
        return mutableState.getValue().packedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BigText_ZHfKjFs$lambda$2(MutableState<TextUnit> mutableState, long j) {
        mutableState.setValue(new TextUnit(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* renamed from: ButtonBigText-OxOnQKw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1637ButtonBigTextOxOnQKw(androidx.compose.ui.Modifier r27, final java.lang.String r28, final long r29, androidx.compose.ui.text.style.TextAlign r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.theme.TypographyKt.m1637ButtonBigTextOxOnQKw(androidx.compose.ui.Modifier, java.lang.String, long, androidx.compose.ui.text.style.TextAlign, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: autoScale-Rk4xWKU, reason: not valid java name */
    public static final void m1638autoScaleRk4xWKU(TextLayoutResult autoScale, long j, Function1<? super TextUnit, Unit> onSizeScaled) {
        Intrinsics.checkNotNullParameter(autoScale, "$this$autoScale");
        Intrinsics.checkNotNullParameter(onSizeScaled, "onSizeScaled");
        MultiParagraph multiParagraph = autoScale.multiParagraph;
        int r0 = multiParagraph.lineCount - 1;
        multiParagraph.requireLineIndexInRange(r0);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (((ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r0, arrayList))).paragraph.isLineEllipsized(r0)) {
            if (!TextUnitKt.m600isUnspecifiedR2X_6o(j)) {
                onSizeScaled.invoke(new TextUnit(TextUnitKt.pack(TextUnit.m598getValueimpl(j) * 0.9f, 1095216660480L & j)));
                return;
            }
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    public static final Typography getKronabyTypography() {
        return KronabyTypography;
    }

    public static final Typography getMainTypography() {
        return MainTypography;
    }
}
