package androidx.compose.ui.graphics.colorspace;

import android.database.Cursor;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda2 implements DoubleFunction, SQLiteEventStore.Function {
    public static Map m(String str, String str2) {
        return MapsKt__MapsJVMKt.mapOf(new Pair(str, str2));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        ArrayList arrayList = new ArrayList();
        int r2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            r2 += blob.length;
        }
        byte[] bArr = new byte[r2];
        int r3 = 0;
        for (int r22 = 0; r22 < arrayList.size(); r22++) {
            byte[] bArr2 = (byte[]) arrayList.get(r22);
            System.arraycopy(bArr2, 0, bArr, r3, bArr2.length);
            r3 += bArr2.length;
        }
        return bArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        return d;
    }
}
