package com.google.android.gms.measurement.internal;

import aws.smithy.kotlin.runtime.auth.awssigning.DefaultRequestMutator;
import com.google.android.gms.internal.measurement.zzou;
import com.google.android.gms.internal.measurement.zzov;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzcb implements zzdq {
    public static zzcb singleton;
    public static final DefaultRequestMutator Default = new DefaultRequestMutator();
    public static final /* synthetic */ zzcb zza = new zzcb();

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzov) zzou.zza.zzb.zza()).zza());
    }
}
