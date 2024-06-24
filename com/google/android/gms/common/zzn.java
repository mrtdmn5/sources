package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzn {
    public static final zzh zzc;
    public static final zzi zzd;
    public static volatile zzaf zze;
    public static final Object zzf;
    public static Context zzg;

    static {
        new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        zzc = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        zzd = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        zzf = new Object();
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [com.google.android.gms.common.zze] */
    public static zzx zzh(final String str, final zzj zzjVar, final boolean z, boolean z2) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                if (zze.zzh(new zzs(str, zzjVar, z, z2), new ObjectWrapper(zzg.getPackageManager()))) {
                    return zzx.zze;
                }
                return new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        boolean z3;
                        String str2;
                        MessageDigest messageDigest;
                        boolean z4 = z;
                        String str3 = str;
                        zzj zzjVar2 = zzjVar;
                        if (!z4 && zzn.zzh(str3, zzjVar2, true, false).zza) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (true != z3) {
                            str2 = "not allowed";
                        } else {
                            str2 = "debug cert rejected";
                        }
                        Object[] objArr = new Object[5];
                        objArr[0] = str2;
                        objArr[1] = str3;
                        int r2 = 0;
                        while (true) {
                            if (r2 < 2) {
                                try {
                                    messageDigest = MessageDigest.getInstance("SHA-256");
                                } catch (NoSuchAlgorithmException unused) {
                                }
                                if (messageDigest != null) {
                                    break;
                                }
                                r2++;
                            } else {
                                messageDigest = null;
                                break;
                            }
                        }
                        Preconditions.checkNotNull(messageDigest);
                        byte[] digest = messageDigest.digest(zzjVar2.zzf());
                        int length = digest.length;
                        char[] cArr = new char[length + length];
                        int r3 = 0;
                        for (byte b : digest) {
                            int r7 = b & 255;
                            int r8 = r3 + 1;
                            char[] cArr2 = Hex.zzb;
                            cArr[r3] = cArr2[r7 >>> 4];
                            r3 = r8 + 1;
                            cArr[r8] = cArr2[r7 & 15];
                        }
                        objArr[2] = new String(cArr);
                        objArr[3] = Boolean.valueOf(z4);
                        objArr[4] = "12451000.false";
                        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", objArr);
                    }
                });
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzx.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return zzx.zzd("module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    public static void zzj() throws DynamiteModule.LoadingException {
        zzaf zzadVar;
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            if (zze == null) {
                IBinder instantiate = DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl");
                int r2 = com.google.android.gms.common.internal.zzae.$r8$clinit;
                if (instantiate == null) {
                    zzadVar = null;
                } else {
                    IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    if (queryLocalInterface instanceof zzaf) {
                        zzadVar = (zzaf) queryLocalInterface;
                    } else {
                        zzadVar = new zzad(instantiate);
                    }
                }
                zze = zzadVar;
            }
        }
    }
}
