package androidx.compose.foundation.text;

/* compiled from: BasicTextField.kt */
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x038b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0402 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final java.lang.String r41, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r42, androidx.compose.ui.Modifier r43, boolean r44, boolean r45, androidx.compose.ui.text.TextStyle r46, androidx.compose.foundation.text.KeyboardOptions r47, androidx.compose.foundation.text.KeyboardActions r48, boolean r49, int r50, int r51, androidx.compose.ui.text.input.VisualTransformation r52, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.ui.graphics.Brush r55, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, androidx.compose.runtime.Composer r57, final int r58, final int r59, final int r60) {
        /*
            Method dump skipped, instructions count: 1179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
