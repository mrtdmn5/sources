package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.YieldKt;

/* compiled from: OutlinedTextField.kt */
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final float OutlinedTextFieldInnerPadding = 4;
    public static final float OutlinedTextFieldTopPadding = 8;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v15, types: [androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OutlinedTextField(final java.lang.String r43, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, boolean r47, androidx.compose.ui.text.TextStyle r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, boolean r53, androidx.compose.ui.text.input.VisualTransformation r54, androidx.compose.foundation.text.KeyboardOptions r55, androidx.compose.foundation.text.KeyboardActions r56, boolean r57, int r58, int r59, androidx.compose.foundation.interaction.MutableInteractionSource r60, androidx.compose.ui.graphics.Shape r61, androidx.compose.material.TextFieldColors r62, androidx.compose.runtime.Composer r63, final int r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0466  */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OutlinedTextFieldLayout(final androidx.compose.ui.Modifier r23, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final boolean r29, final float r30, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Size, kotlin.Unit> r31, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, final androidx.compose.foundation.layout.PaddingValues r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 1134
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: access$calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m193access$calculateHeightO3s9Psw(int r4, int r5, int r6, int r7, int r8, float f, long j, float f2, PaddingValues paddingValues) {
        int max = Math.max(r6, Math.max(r8, MathKt__MathJVMKt.roundToInt((0 - r7) * f) + r7));
        float mo79calculateTopPaddingD9Ej5fM = paddingValues.mo79calculateTopPaddingD9Ej5fM() * f2;
        return Math.max(Constraints.m566getMinHeightimpl(j), Math.max(r4, Math.max(r5, MathKt__MathJVMKt.roundToInt(YieldKt.lerp(mo79calculateTopPaddingD9Ej5fM, Math.max(mo79calculateTopPaddingD9Ej5fM, r7 / 2.0f), f) + max + (paddingValues.mo76calculateBottomPaddingD9Ej5fM() * f2)))));
    }

    /* renamed from: access$calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m194access$calculateWidthO3s9Psw(int r4, int r5, int r6, int r7, int r8, float f, long j, float f2, PaddingValues paddingValues) {
        int max = Math.max(r6, Math.max(MathKt__MathJVMKt.roundToInt((0 - r7) * f) + r7, r8)) + r4 + r5;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return Math.max(max, Math.max(MathKt__MathJVMKt.roundToInt((r7 + ((paddingValues.mo78calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues.mo77calculateLeftPaddingu2uoSUM(layoutDirection)) * f2)) * f), Constraints.m567getMinWidthimpl(j)));
    }
}
