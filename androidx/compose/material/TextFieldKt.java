package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: TextField.kt */
/* loaded from: classes.dex */
public final class TextFieldKt {
    public static final float FirstBaselineOffset = 20;
    public static final float TextFieldBottomPadding = 10;
    public static final float TextFieldTopPadding = 4;

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b4, code lost:            if (r7.changed(r60) == false) goto L145;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0588  */
    /* JADX WARN: Type inference failed for: r3v15, types: [androidx.compose.material.TextFieldKt$TextField$2, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextField(final java.lang.String r47, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r48, androidx.compose.ui.Modifier r49, boolean r50, boolean r51, androidx.compose.ui.text.TextStyle r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.ui.text.input.VisualTransformation r58, androidx.compose.foundation.text.KeyboardOptions r59, androidx.compose.foundation.text.KeyboardActions r60, boolean r61, int r62, int r63, androidx.compose.foundation.interaction.MutableInteractionSource r64, androidx.compose.ui.graphics.Shape r65, androidx.compose.material.TextFieldColors r66, androidx.compose.runtime.Composer r67, final int r68, final int r69, final int r70) {
        /*
            Method dump skipped, instructions count: 1443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x042e  */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextFieldLayout(final androidx.compose.ui.Modifier r25, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, final boolean r31, final float r32, final androidx.compose.foundation.layout.PaddingValues r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: access$calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m214access$calculateHeightO3s9Psw(int r2, boolean z, int r4, int r5, int r6, int r7, long j, float f, PaddingValues paddingValues) {
        float f2;
        float f3 = TextFieldTopPadding * f;
        float mo79calculateTopPaddingD9Ej5fM = paddingValues.mo79calculateTopPaddingD9Ej5fM() * f;
        float mo76calculateBottomPaddingD9Ej5fM = paddingValues.mo76calculateBottomPaddingD9Ej5fM() * f;
        int max = Math.max(r2, r7);
        if (z) {
            f2 = r4 + f3 + max + mo76calculateBottomPaddingD9Ej5fM;
        } else {
            f2 = mo79calculateTopPaddingD9Ej5fM + max + mo76calculateBottomPaddingD9Ej5fM;
        }
        return Math.max(MathKt__MathJVMKt.roundToInt(f2), Math.max(Math.max(r5, r6), Constraints.m566getMinHeightimpl(j)));
    }
}
