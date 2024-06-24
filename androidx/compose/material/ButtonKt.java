package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Button.kt */
/* loaded from: classes.dex */
public final class ButtonKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d1  */
    /* JADX WARN: Type inference failed for: r3v14, types: [androidx.compose.material.ButtonKt$Button$3, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Button(final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.material.ButtonElevation r34, androidx.compose.ui.graphics.Shape r35, androidx.compose.foundation.BorderStroke r36, androidx.compose.material.ButtonColors r37, androidx.compose.foundation.layout.PaddingValues r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonKt.Button(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.ButtonElevation, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ButtonColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OutlinedButton(Function0 onClick, Modifier modifier, boolean z, BorderStroke borderStroke, DefaultButtonColors defaultButtonColors, Function3 content, Composer composer, int r28, int r29) {
        Modifier modifier2;
        boolean z2;
        MutableInteractionSource mutableInteractionSource;
        CornerBasedShape cornerBasedShape;
        BorderStroke borderStroke2;
        DefaultButtonColors defaultButtonColors2;
        long Color;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1776134358);
        if ((r29 & 2) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((r29 & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        PaddingValuesImpl paddingValuesImpl = null;
        if ((r29 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.Empty) {
                rememberedValue = new MutableInteractionSourceImpl();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource = null;
        }
        if ((r29 & 32) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            cornerBasedShape = ((Shapes) composer.consume(ShapesKt.LocalShapes)).small;
        } else {
            cornerBasedShape = null;
        }
        if ((r29 & 64) != 0) {
            PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
            composer.startReplaceableGroup(-2091313033);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            Color = ColorKt.Color(Color.m322getRedimpl(r0), Color.m321getGreenimpl(r0), Color.m319getBlueimpl(r0), 0.12f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
            BorderStroke borderStroke3 = new BorderStroke(ButtonDefaults.OutlinedBorderSize, new SolidColor(Color));
            composer.endReplaceableGroup();
            borderStroke2 = borderStroke3;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((r29 & 128) != 0) {
            defaultButtonColors2 = ButtonDefaults.m161outlinedButtonColorsRGew2ao(0L, 0L, composer, 7);
        } else {
            defaultButtonColors2 = defaultButtonColors;
        }
        if ((r29 & 256) != 0) {
            paddingValuesImpl = ButtonDefaults.ContentPadding;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
        Button(onClick, modifier2, z2, mutableInteractionSource, null, cornerBasedShape, borderStroke2, defaultButtonColors2, paddingValuesImpl, content, composer, (r28 & 14) | (r28 & 112) | (r28 & 896) | (r28 & 7168) | (57344 & r28) | (458752 & r28) | (3670016 & r28) | (29360128 & r28) | (234881024 & r28) | (1879048192 & r28), 0);
        composer.endReplaceableGroup();
    }
}
