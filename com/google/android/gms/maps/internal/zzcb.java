package com.google.android.gms.maps.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzcb {

    @SuppressLint({"StaticFieldLeak"})
    public static Context zzb;
    public static zzf zzc;

    public static zzf zza(Context context) throws GooglePlayServicesNotAvailableException {
        zzf zzeVar;
        Preconditions.checkNotNull(context);
        Log.d("zzcb", "preferredRenderer: ".concat(Constants.NULL_VERSION_ID));
        zzf zzfVar = zzc;
        if (zzfVar == null) {
            int r0 = GooglePlayServicesUtil.$r8$clinit;
            int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, 13400000);
            if (isGooglePlayServicesAvailable == 0) {
                Log.i("zzcb", "Making Creator dynamically");
                ClassLoader classLoader = zzc(context).getClassLoader();
                try {
                    Preconditions.checkNotNull(classLoader);
                    Class<?> loadClass = classLoader.loadClass("com.google.android.gms.maps.internal.CreatorImpl");
                    try {
                        try {
                            IBinder iBinder = (IBinder) loadClass.newInstance();
                            if (iBinder == null) {
                                zzeVar = null;
                            } else {
                                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                                if (queryLocalInterface instanceof zzf) {
                                    zzeVar = (zzf) queryLocalInterface;
                                } else {
                                    zzeVar = new zze(iBinder);
                                }
                            }
                            zzc = zzeVar;
                            try {
                                Context zzc2 = zzc(context);
                                zzc2.getClass();
                                zzeVar.zzk(new ObjectWrapper(zzc2.getResources()));
                                return zzc;
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        } catch (IllegalAccessException unused) {
                            throw new IllegalStateException("Unable to call the default constructor of ".concat(loadClass.getName()));
                        }
                    } catch (InstantiationException unused2) {
                        throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(loadClass.getName()));
                    }
                } catch (ClassNotFoundException unused3) {
                    throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl");
                }
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        return zzfVar;
    }

    public static Context zzc(Context context) {
        Context context2;
        Context context3 = zzb;
        if (context3 == null) {
            context.getApplicationContext();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").zzj;
            } catch (Exception e) {
                try {
                    if (!"com.google.android.gms.maps_dynamite".equals("com.google.android.gms.maps_dynamite")) {
                        try {
                            Log.d("zzcb", "Attempting to load maps_dynamite again.");
                            context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").zzj;
                        } catch (Exception e2) {
                            Log.e("zzcb", "Failed to load maps module, use pre-Chimera", e2);
                            int r0 = GooglePlayServicesUtil.$r8$clinit;
                            context2 = context.createPackageContext("com.google.android.gms", 3);
                        }
                    } else {
                        Log.e("zzcb", "Failed to load maps module, use pre-Chimera", e);
                        int r02 = GooglePlayServicesUtil.$r8$clinit;
                        context2 = context.createPackageContext("com.google.android.gms", 3);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    context2 = null;
                }
            }
            zzb = context2;
            return context2;
        }
        return context3;
    }
}
