package androidx.compose.ui.text.font;

import android.graphics.Rect;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontWeight.kt */
/* loaded from: classes.dex */
public final class FontWeightKt implements zzdq {
    public static final /* synthetic */ FontWeightKt zza = new FontWeightKt();

    public static final Rect toAndroidRect(androidx.compose.ui.geometry.Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new Rect((int) rect.left, (int) rect.top, (int) rect.right, (int) rect.bottom);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzox.zza.zza().zzd());
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
