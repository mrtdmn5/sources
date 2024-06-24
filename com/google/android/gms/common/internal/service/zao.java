package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zao extends GoogleApi {
    public static final Api zae = new Api("ClientTelemetry.API", new zan(), new Api.ClientKey());

    public zao(Context context) {
        super(context, zae, TelemetryLoggingOptions.zaa, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final zzw log(final TelemetryData telemetryData) {
        TaskApiCall.Builder builder = new TaskApiCall.Builder();
        builder.zac = new Feature[]{zaf.zaa};
        builder.zab = false;
        builder.zaa = new RemoteCall() { // from class: com.google.android.gms.common.internal.service.zam
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Api.Client client, Object obj) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj;
                Api api = zao.zae;
                zai zaiVar = (zai) ((zap) client).getService();
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(zaiVar.zab);
                int r1 = zac.$r8$clinit;
                TelemetryData telemetryData2 = TelemetryData.this;
                if (telemetryData2 == null) {
                    obtain.writeInt(0);
                } else {
                    obtain.writeInt(1);
                    telemetryData2.writeToParcel(obtain, 0);
                }
                try {
                    zaiVar.zaa.transact(1, obtain, null, 1);
                    obtain.recycle();
                    taskCompletionSource.setResult(null);
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        };
        return zae(2, new zacv(builder, builder.zac, builder.zab, builder.zad));
    }
}
