package androidx.compose.ui.text.font;

import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Font.kt */
/* loaded from: classes.dex */
public final class FontKt implements zzdq {
    public static final /* synthetic */ FontKt zza = new FontKt();

    /* renamed from: Font-YpTlLL0$default */
    public static ResourceFont m535FontYpTlLL0$default(int r7, FontWeight weight) {
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new ResourceFont(r7, weight, 0, new FontVariation$Settings(new FontVariation$Setting[0]), 0);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Integer.valueOf((int) zznn.zza.zza().zzC());
    }
}
