package androidx.compose.runtime;

import com.google.android.gms.internal.measurement.zzpa;
import com.google.android.gms.internal.measurement.zzpb;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class Updater implements zzdq {
    public static final /* synthetic */ Updater zza = new Updater();

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m228setimpl(Composer composer, Object obj, Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), obj)) {
            composer.updateRememberedValue(obj);
            composer.apply(obj, block);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzpb) zzpa.zza.zzb.zza()).zzb());
    }
}
