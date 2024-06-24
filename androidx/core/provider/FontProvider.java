package androidx.core.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class FontProvider {
    public static final FontProvider$$ExternalSyntheticLambda0 sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[LOOP:1: B:13:0x004b->B:27:0x008e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[EDGE_INSN: B:28:0x0092->B:29:0x0092 BREAK  A[LOOP:1: B:13:0x004b->B:27:0x008e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.core.provider.FontsContractCompat$FontFamilyResult getFontFamilyResult(android.content.Context r22, androidx.core.provider.FontRequest r23) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.getFontFamilyResult(android.content.Context, androidx.core.provider.FontRequest):androidx.core.provider.FontsContractCompat$FontFamilyResult");
    }
}
