package androidx.compose.ui.platform;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeView_androidKt {
    /* renamed from: access$preTransform-JiSxe2E, reason: not valid java name */
    public static final void m491access$preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float m492dotp89u6pk = m492dotp89u6pk(fArr2, 0, fArr, 0);
        float m492dotp89u6pk2 = m492dotp89u6pk(fArr2, 0, fArr, 1);
        float m492dotp89u6pk3 = m492dotp89u6pk(fArr2, 0, fArr, 2);
        float m492dotp89u6pk4 = m492dotp89u6pk(fArr2, 0, fArr, 3);
        float m492dotp89u6pk5 = m492dotp89u6pk(fArr2, 1, fArr, 0);
        float m492dotp89u6pk6 = m492dotp89u6pk(fArr2, 1, fArr, 1);
        float m492dotp89u6pk7 = m492dotp89u6pk(fArr2, 1, fArr, 2);
        float m492dotp89u6pk8 = m492dotp89u6pk(fArr2, 1, fArr, 3);
        float m492dotp89u6pk9 = m492dotp89u6pk(fArr2, 2, fArr, 0);
        float m492dotp89u6pk10 = m492dotp89u6pk(fArr2, 2, fArr, 1);
        float m492dotp89u6pk11 = m492dotp89u6pk(fArr2, 2, fArr, 2);
        float m492dotp89u6pk12 = m492dotp89u6pk(fArr2, 2, fArr, 3);
        float m492dotp89u6pk13 = m492dotp89u6pk(fArr2, 3, fArr, 0);
        float m492dotp89u6pk14 = m492dotp89u6pk(fArr2, 3, fArr, 1);
        float m492dotp89u6pk15 = m492dotp89u6pk(fArr2, 3, fArr, 2);
        float m492dotp89u6pk16 = m492dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = m492dotp89u6pk;
        fArr[1] = m492dotp89u6pk2;
        fArr[2] = m492dotp89u6pk3;
        fArr[3] = m492dotp89u6pk4;
        fArr[4] = m492dotp89u6pk5;
        fArr[5] = m492dotp89u6pk6;
        fArr[6] = m492dotp89u6pk7;
        fArr[7] = m492dotp89u6pk8;
        fArr[8] = m492dotp89u6pk9;
        fArr[9] = m492dotp89u6pk10;
        fArr[10] = m492dotp89u6pk11;
        fArr[11] = m492dotp89u6pk12;
        fArr[12] = m492dotp89u6pk13;
        fArr[13] = m492dotp89u6pk14;
        fArr[14] = m492dotp89u6pk15;
        fArr[15] = m492dotp89u6pk16;
    }

    /* renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m492dotp89u6pk(float[] fArr, int r4, float[] fArr2, int r6) {
        int r42 = r4 * 4;
        return (fArr[r42 + 3] * fArr2[12 + r6]) + (fArr[r42 + 2] * fArr2[8 + r6]) + (fArr[r42 + 1] * fArr2[4 + r6]) + (fArr[r42 + 0] * fArr2[0 + r6]);
    }
}
