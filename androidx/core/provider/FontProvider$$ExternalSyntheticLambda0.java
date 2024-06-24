package androidx.core.provider;

import java.util.Comparator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class FontProvider$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int r1 = 0; r1 < bArr.length; r1++) {
            byte b = bArr[r1];
            byte b2 = bArr2[r1];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }
}
