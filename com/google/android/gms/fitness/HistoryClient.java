package com.google.android.gms.fitness;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzaj;
import com.google.android.gms.internal.fitness.zzdi;
import com.google.android.gms.tasks.zzw;
import org.slf4j.helpers.NOPMDCAdapter;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class HistoryClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    static {
        new NOPMDCAdapter();
    }

    public HistoryClient(Context context, zzi zziVar) {
        super(context, zzaj.zzg, zziVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final zzw insertData(DataSet dataSet) {
        if (dataSet != null) {
            Preconditions.checkState("Cannot use an empty data set", !dataSet.getDataPoints().isEmpty());
            Preconditions.checkNotNull(dataSet.zzb.zzf, "Must set the app package name for the data source");
            zabv zabvVar = this.zai;
            zzdi zzdiVar = new zzdi(zabvVar, dataSet);
            zabvVar.zaa.zad(0, zzdiVar);
            return PendingResultUtil.toVoidTask(zzdiVar);
        }
        throw new NullPointerException("Must set the data set");
    }
}
