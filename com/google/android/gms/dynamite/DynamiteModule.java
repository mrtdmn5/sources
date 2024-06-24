package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.secondo.R;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class DynamiteModule {
    public static Boolean zzb = null;
    public static String zzc = null;
    public static boolean zzd = false;
    public static int zze = -1;
    public static Boolean zzf;
    public static zzq zzk;
    public static zzr zzl;
    public final Context zzj;
    public static final ThreadLocal zzg = new ThreadLocal();
    public static final zzd zzh = new zzd();
    public static final zze zzi = new zze();
    public static final zzf PREFER_REMOTE = new zzf();
    public static final zzi PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final zzj PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @DynamiteApi
    /* loaded from: classes3.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class LoadingException extends Exception {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        /* loaded from: classes3.dex */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        /* loaded from: classes3.dex */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Boolean bool;
        IObjectWrapper zzh2;
        DynamiteModule dynamiteModule;
        zzr zzrVar;
        boolean z;
        Boolean valueOf;
        IObjectWrapper zze2;
        ThreadLocal threadLocal = zzg;
        zzn zznVar = (zzn) threadLocal.get();
        zzn zznVar2 = new zzn(0);
        threadLocal.set(zznVar2);
        zzd zzdVar = zzh;
        long longValue = ((Long) zzdVar.get()).longValue();
        try {
            zzdVar.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzi);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + selectModule.localVersion + " and remote module " + str + ":" + selectModule.remoteVersion);
            int r5 = selectModule.selection;
            if (r5 != 0) {
                if (r5 == -1) {
                    if (selectModule.localVersion != 0) {
                        r5 = -1;
                    }
                }
                if (r5 != 1 || selectModule.remoteVersion != 0) {
                    if (r5 == -1) {
                        Log.i("DynamiteModule", "Selected local version of ".concat(str));
                        DynamiteModule dynamiteModule2 = new DynamiteModule(context.getApplicationContext());
                        if (longValue == 0) {
                            zzdVar.remove();
                        } else {
                            zzdVar.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = zznVar2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zznVar);
                        return dynamiteModule2;
                    }
                    if (r5 == 1) {
                        try {
                            int r52 = selectModule.remoteVersion;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (zzf(context)) {
                                        bool = zzb;
                                    } else {
                                        throw new LoadingException("Remote loading disabled");
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + r52);
                                        synchronized (DynamiteModule.class) {
                                            zzrVar = zzl;
                                        }
                                        if (zzrVar != null) {
                                            zzn zznVar3 = (zzn) threadLocal.get();
                                            if (zznVar3 != null && zznVar3.zza != null) {
                                                Context applicationContext = context.getApplicationContext();
                                                Cursor cursor2 = zznVar3.zza;
                                                new ObjectWrapper(null);
                                                synchronized (DynamiteModule.class) {
                                                    if (zze >= 2) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    valueOf = Boolean.valueOf(z);
                                                }
                                                if (valueOf.booleanValue()) {
                                                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                    zze2 = zzrVar.zzf(new ObjectWrapper(applicationContext), str, r52, new ObjectWrapper(cursor2));
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    zze2 = zzrVar.zze(new ObjectWrapper(applicationContext), str, r52, new ObjectWrapper(cursor2));
                                                }
                                                Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                                if (context2 != null) {
                                                    dynamiteModule = new DynamiteModule(context2);
                                                } else {
                                                    throw new LoadingException("Failed to get module context");
                                                }
                                            } else {
                                                throw new LoadingException("No result cursor");
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.");
                                        }
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + r52);
                                        zzq zzg2 = zzg(context);
                                        if (zzg2 != null) {
                                            Parcel zzB = zzg2.zzB(zzg2.zza(), 6);
                                            int readInt = zzB.readInt();
                                            zzB.recycle();
                                            if (readInt >= 3) {
                                                zzn zznVar4 = (zzn) threadLocal.get();
                                                if (zznVar4 != null) {
                                                    zzh2 = zzg2.zzi(new ObjectWrapper(context), str, r52, new ObjectWrapper(zznVar4.zza));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder");
                                                }
                                            } else if (readInt == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                zzh2 = zzg2.zzj(new ObjectWrapper(context), str, r52);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                zzh2 = zzg2.zzh(new ObjectWrapper(context), str, r52);
                                            }
                                            Object unwrap = ObjectWrapper.unwrap(zzh2);
                                            if (unwrap != null) {
                                                dynamiteModule = new DynamiteModule((Context) unwrap);
                                            } else {
                                                throw new LoadingException("Failed to load remote module.");
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.");
                                        }
                                    }
                                    if (longValue == 0) {
                                        zzdVar.remove();
                                    } else {
                                        zzdVar.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = zznVar2.zza;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(zznVar);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.");
                            } catch (RemoteException e) {
                                throw new LoadingException("Failed to load remote module.", e);
                            } catch (LoadingException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                try {
                                    Preconditions.checkNotNull(context);
                                } catch (Exception e3) {
                                    Log.e("CrashUtils", "Error adding exception to DropBox!", e3);
                                }
                                throw new LoadingException("Failed to load remote module.", th);
                            }
                        } catch (LoadingException e4) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e4.getMessage());
                            int r2 = selectModule.localVersion;
                            if (r2 != 0 && versionPolicy.selectModule(context, str, new zzo(r2)).selection == -1) {
                                Log.i("DynamiteModule", "Selected local version of ".concat(str));
                                DynamiteModule dynamiteModule3 = new DynamiteModule(context.getApplicationContext());
                                if (longValue == 0) {
                                    zzh.remove();
                                } else {
                                    zzh.set(Long.valueOf(longValue));
                                }
                                Cursor cursor4 = zznVar2.zza;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                zzg.set(zznVar);
                                return dynamiteModule3;
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e4);
                        }
                    }
                    throw new LoadingException("VersionPolicy returned invalid code:" + r5);
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + InstructionFileId.DOT);
        } catch (Throwable th2) {
            if (longValue == 0) {
                zzh.remove();
            } else {
                zzh.set(Long.valueOf(longValue));
            }
            Cursor cursor5 = zznVar2.zza;
            if (cursor5 != null) {
                cursor5.close();
            }
            zzg.set(zznVar);
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0170, code lost:            if (r2 != false) goto L96;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4 A[Catch: all -> 0x00dd, TryCatch #5 {all -> 0x00dd, blocks: (B:41:0x00a6, B:42:0x00ad, B:45:0x00cf, B:47:0x00d4, B:48:0x00d5, B:49:0x00dc), top: B:40:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[Catch: all -> 0x00dd, TryCatch #5 {all -> 0x00dd, blocks: (B:41:0x00a6, B:42:0x00ad, B:45:0x00cf, B:47:0x00d4, B:48:0x00d5, B:49:0x00dc), top: B:40:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzrVar = (zzr) queryLocalInterface;
                } else {
                    zzrVar = new zzr(iBinder);
                }
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & R.styleable.AppTheme_statusTopStripeImportant) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzq) {
                        zzqVar = (zzq) queryLocalInterface;
                    } else {
                        zzqVar = new zzq(iBinder);
                    }
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(str), e);
        }
    }
}
