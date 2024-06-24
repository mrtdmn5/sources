package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import io.ktor.util.CharsetKt;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class MapsInitializer {
    public static boolean zzb = false;
    public static Renderer zzc = Renderer.LEGACY;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes3.dex */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    public static synchronized int initialize(Context context) {
        synchronized (MapsInitializer.class) {
            try {
                if (context != null) {
                    Log.d("MapsInitializer", "preferredRenderer: ".concat(Constants.NULL_VERSION_ID));
                    if (zzb) {
                        return 0;
                    }
                    try {
                        zzf zza = zzcb.zza(context);
                        try {
                            ICameraUpdateFactoryDelegate zze = zza.zze();
                            Preconditions.checkNotNull(zze);
                            MagicApiIntrinsics.zza = zze;
                            zzi zzj = zza.zzj();
                            if (CharsetKt.zza == null) {
                                Preconditions.checkNotNull(zzj, "delegate must not be null");
                                CharsetKt.zza = zzj;
                            }
                            zzb = true;
                            try {
                                if (zza.zzd() == 2) {
                                    zzc = Renderer.LATEST;
                                }
                                zza.zzl(new ObjectWrapper(context), 0);
                            } catch (RemoteException e) {
                                Log.e("MapsInitializer", "Failed to retrieve renderer type or log initialization.", e);
                            }
                            Log.d("MapsInitializer", "loadedRenderer: ".concat(String.valueOf(zzc)));
                            return 0;
                        } catch (RemoteException e2) {
                            throw new RuntimeRemoteException(e2);
                        }
                    } catch (GooglePlayServicesNotAvailableException e3) {
                        return e3.errorCode;
                    }
                }
                throw new NullPointerException("Context is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
