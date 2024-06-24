package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import io.reactivex.exceptions.Exceptions;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlb extends zzgl {
    public static final String[] zza = {"firebase_", "google_", "ga_"};
    public static final String[] zzb = {"_err"};
    public SecureRandom zzc;
    public final AtomicLong zzd;
    public int zze;
    public Integer zzf;

    public zzlb(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = null;
        this.zzd = new AtomicLong(0L);
    }

    public static String zzD(String str, int r4, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > r4) {
            if (!z) {
                return null;
            }
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, r4))).concat("...");
        }
        return str;
    }

    public static MessageDigest zzF() {
        MessageDigest messageDigest;
        for (int r0 = 0; r0 < 2; r0++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(AnalyticsConstants.USER_PROPERTY_APP_ID, zzacVar.zza);
            bundle.putString("origin", zzacVar.zzb);
            bundle.putLong("creation_timestamp", zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zzb);
            Object zza2 = zzacVar.zzc.zza();
            Preconditions.checkNotNull(zza2);
            Exceptions.zzb(bundle, zza2);
            bundle.putBoolean("active", zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaw zzawVar = zzacVar.zzg;
            if (zzawVar != null) {
                bundle.putString("timed_out_event_name", zzawVar.zza);
                zzau zzauVar = zzawVar.zzb;
                if (zzauVar != null) {
                    bundle.putBundle("timed_out_event_params", zzauVar.zzc());
                }
            }
            bundle.putLong("trigger_timeout", zzacVar.zzh);
            zzaw zzawVar2 = zzacVar.zzi;
            if (zzawVar2 != null) {
                bundle.putString("triggered_event_name", zzawVar2.zza);
                zzau zzauVar2 = zzawVar2.zzb;
                if (zzauVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzauVar2.zzc());
                }
            }
            bundle.putLong("triggered_timestamp", zzacVar.zzc.zzc);
            bundle.putLong("time_to_live", zzacVar.zzj);
            zzaw zzawVar3 = zzacVar.zzk;
            if (zzawVar3 != null) {
                bundle.putString("expired_event_name", zzawVar3.zza);
                zzau zzauVar3 = zzawVar3.zzb;
                if (zzauVar3 != null) {
                    bundle.putBundle("expired_event_params", zzauVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzK(zzie zzieVar, Bundle bundle, boolean z) {
        if (bundle != null && zzieVar != null) {
            if (bundle.containsKey("_sc") && !z) {
                z = false;
            } else {
                String str = zzieVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzieVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzieVar.zzc);
                return;
            }
        }
        if (bundle != null && zzieVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static void zzN(zzla zzlaVar, String str, int r4, String str2, String str3, int r7) {
        Bundle bundle = new Bundle();
        zzao(r4, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (r4 == 6 || r4 == 7 || r4 == 2) {
            bundle.putLong("_el", r7);
        }
        zzlaVar.zza(str, bundle);
    }

    public static boolean zzaf(Object obj) {
        if (!(obj instanceof Parcelable[]) && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
            return false;
        }
        return true;
    }

    public static boolean zzah(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("_")) {
            return true;
        }
        return false;
    }

    public static boolean zzai(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) == '_' && !str.equals("_ep")) {
            return false;
        }
        return true;
    }

    public static boolean zzaj(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean zzam(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        }
        if (isEmpty && isEmpty2) {
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (!str3.equals(str4)) {
                    return true;
                }
                return false;
            }
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        }
        if (!isEmpty) {
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            }
            return false;
        }
        if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
            return true;
        }
        return false;
    }

    public static byte[] zzan(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static final boolean zzao(int r5, Bundle bundle) {
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", r5);
            return true;
        }
        return false;
    }

    public static boolean zzas(String str, String[] strArr) {
        boolean z;
        Preconditions.checkNotNull(strArr);
        for (Object obj : strArr) {
            if (str != obj && (str == null || !str.equals(obj))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static long zzp(byte[] bArr) {
        boolean z;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int r1 = 0;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            long j = 0;
            for (int r0 = length - 1; r0 >= 0 && r0 >= bArr.length - 8; r0--) {
                j += (bArr[r0] & 255) << r1;
                r1 += 8;
            }
            return j;
        }
        throw new IllegalStateException();
    }

    public final Object zzA(Object obj, String str) {
        boolean equals = "_ev".equals(str);
        int r1 = 256;
        zzfr zzfrVar = this.zzt;
        if (equals) {
            zzfrVar.getClass();
            return zzar(256, obj, true, true);
        }
        if (zzah(str)) {
            zzfrVar.getClass();
        } else {
            zzfrVar.getClass();
            r1 = 100;
        }
        return zzar(r1, obj, false, true);
    }

    public final Object zzB(Object obj, String str) {
        if ("_ldl".equals(str)) {
            return zzar(zzaq(str), obj, true, false);
        }
        return zzar(zzaq(str), obj, false, false);
    }

    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public final void zzI(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(Long.valueOf(j2), "Params already contained engagement");
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzJ(Bundle bundle, int r3, String str, Object obj) {
        if (zzao(r3, bundle)) {
            this.zzt.getClass();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzlb zzlbVar = this.zzt.zzp;
                zzfr.zzP(zzlbVar);
                zzlbVar.zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void zzM(zzei zzeiVar, int r10) {
        Bundle bundle = zzeiVar.zzd;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int r2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (zzai(str) && (r2 = r2 + 1) > r10) {
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Event can't contain more than ", r10, " params");
                zzfr zzfrVar = this.zzt;
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                String sb = m.toString();
                String str2 = zzeiVar.zza;
                zzec zzecVar = zzfrVar.zzq;
                zzehVar.zzf.zzc(zzecVar.zzd(str2), zzecVar.zzb(bundle), sb);
                zzao(5, bundle);
                bundle.remove(str);
            }
        }
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            if (obj != null) {
                str2 = obj.getClass().getSimpleName();
            } else {
                str2 = null;
            }
            zzfr zzfrVar = this.zzt;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzi.zzc(zzfrVar.zzq.zze(str), str2, "Not putting event parameter. Invalid value type. name, type");
        }
    }

    public final void zzP(zzcf zzcfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning boolean value to wrapper");
        }
    }

    public final void zzQ(zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle list to wrapper");
        }
    }

    public final void zzR(zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle value to wrapper");
        }
    }

    public final void zzS(zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning byte array to wrapper");
        }
    }

    public final void zzT(zzcf zzcfVar, int r4) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", r4);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning int value to wrapper");
        }
    }

    public final void zzU(zzcf zzcfVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning long value to wrapper");
        }
    }

    public final void zzV(String str, zzcf zzcfVar) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning string value to wrapper");
        }
    }

    public final void zzW(String str, String str2, Bundle bundle, List list, boolean z) {
        int r0;
        String str3;
        zzeh zzehVar;
        String str4;
        int zza2;
        if (bundle == null) {
            return;
        }
        zzfr zzfrVar = this.zzt;
        zzfrVar.getClass();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int r15 = 0;
        while (it.hasNext()) {
            String str5 = (String) it.next();
            if (list != null && list.contains(str5)) {
                r0 = 0;
            } else {
                if (!z) {
                    r0 = zzj(str5);
                } else {
                    r0 = 0;
                }
                if (r0 == 0) {
                    r0 = zzi(str5);
                }
            }
            if (r0 != 0) {
                if (r0 == 3) {
                    str3 = str5;
                } else {
                    str3 = null;
                }
                zzJ(bundle, r0, str5, str3);
                bundle.remove(str5);
            } else {
                boolean zzaf = zzaf(bundle.get(str5));
                zzeh zzehVar2 = zzfrVar.zzm;
                if (zzaf) {
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzi.zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str5);
                    zza2 = 22;
                    zzehVar = zzehVar2;
                    str4 = str5;
                } else {
                    zzehVar = zzehVar2;
                    str4 = str5;
                    zza2 = zza(str, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (zza2 != 0 && !"_ev".equals(str4)) {
                    zzJ(bundle, zza2, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzai(str4) && !zzas(str4, zzgp.zzd) && (r15 = r15 + 1) > 0) {
                    zzfr.zzR(zzehVar);
                    zzec zzecVar = zzfrVar.zzq;
                    zzehVar.zzf.zzc(zzecVar.zzd(str), zzecVar.zzb(bundle), "Item cannot contain custom parameters");
                    zzao(23, bundle);
                    bundle.remove(str4);
                }
            }
        }
    }

    public final boolean zzX(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        zzfr zzfrVar = this.zzt;
        if (!isEmpty) {
            Preconditions.checkNotNull(str);
            if (!str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                if (TextUtils.isEmpty(zzfrVar.zzf)) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzf.zzb(zzeh.zzn(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
                }
                return false;
            }
            return true;
        }
        if (!TextUtils.isEmpty(str2)) {
            Preconditions.checkNotNull(str2);
            if (!str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzf.zzb(zzeh.zzn(str2), "Invalid admob_app_id. Analytics disabled.");
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(zzfrVar.zzf)) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzf.zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    public final boolean zzY(String str, int r5, String str2) {
        zzfr zzfrVar = this.zzt;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) > r5) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzf.zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(r5), str2);
            return false;
        }
        return true;
    }

    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        zzfr zzfrVar = this.zzt;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        String[] strArr3 = zza;
        for (int r3 = 0; r3 < 3; r3++) {
            if (str2.startsWith(strArr3[r3])) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzf.zzc(str, str2, "Name starts with reserved prefix. Type, name");
                return false;
            }
        }
        if (strArr != null && zzas(str2, strArr)) {
            if (strArr2 == null || !zzas(str2, strArr2)) {
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzf.zzc(str, str2, "Name is reserved. Type, name");
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.String r14, java.lang.String r15, java.lang.Object r16, android.os.Bundle r17, java.util.List r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zza(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final void zzaA() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzeh zzehVar = this.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    public final boolean zzaa(String str, String str2, int r6, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > r6) {
                zzeh zzehVar = this.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzi.zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean zzab(String str, String str2) {
        zzfr zzfrVar = this.zzt;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzf.zzb(str, "Name is required and can't be empty. Type");
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt == 95) {
                codePointAt = 95;
            } else {
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzf.zzc(str, str2, "Name must start with a letter or _ (underscore). Type, name");
                return false;
            }
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzeh zzehVar4 = zzfrVar.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzf.zzc(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean zzac(String str, String str2) {
        zzfr zzfrVar = this.zzt;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzf.zzb(str, "Name is required and can't be empty. Type");
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzf.zzc(str, str2, "Name must start with a letter. Type, name");
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzeh zzehVar4 = zzfrVar.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzf.zzc(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean zzad(String str) {
        zzg();
        zzfr zzfrVar = this.zzt;
        if (Wrappers.packageManager(zzfrVar.zze).zza.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zzb(str, "Permission not granted");
        return false;
    }

    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        zzfr zzfrVar = this.zzt;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(64, str);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Package name not found");
            return true;
        } catch (CertificateException e2) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e2, "Error obtaining certificate");
            return true;
        }
    }

    public final int zzaq(String str) {
        boolean equals = "_ldl".equals(str);
        zzfr zzfrVar = this.zzt;
        if (equals) {
            zzfrVar.getClass();
            return 2048;
        }
        if (TransferTable.COLUMN_ID.equals(str)) {
            zzfrVar.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            zzfrVar.getClass();
            return 100;
        }
        zzfrVar.getClass();
        return 36;
    }

    public final Object zzar(int r3, Object obj, boolean z, boolean z2) {
        long j;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            if (obj instanceof Integer) {
                return Long.valueOf(((Integer) obj).intValue());
            }
            if (obj instanceof Byte) {
                return Long.valueOf(((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return Long.valueOf(((Short) obj).shortValue());
            }
            if (obj instanceof Boolean) {
                if (true != ((Boolean) obj).booleanValue()) {
                    j = 0;
                } else {
                    j = 1;
                }
                return Long.valueOf(j);
            }
            if (obj instanceof Float) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (parcelable instanceof Bundle) {
                        Bundle zzt = zzt((Bundle) parcelable);
                        if (!zzt.isEmpty()) {
                            arrayList.add(zzt);
                        }
                    }
                }
                return arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return zzD(obj.toString(), r3, z);
        }
        return obj;
    }

    public final int zzd(Object obj, String str) {
        boolean zzaa;
        if ("_ldl".equals(str)) {
            zzaa = zzaa("user property referrer", str, zzaq(str), obj);
        } else {
            zzaa = zzaa("user property", str, zzaq(str), obj);
        }
        if (zzaa) {
            return 0;
        }
        return 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return true;
    }

    public final int zzh(String str) {
        if (!zzab("event", str)) {
            return 2;
        }
        if (!zzZ("event", zzgo.zza, zzgo.zzb, str)) {
            return 13;
        }
        this.zzt.getClass();
        if (!zzY("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzt.getClass();
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzt.getClass();
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzgq.zza, null, str)) {
            return 15;
        }
        this.zzt.getClass();
        if (!zzY("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzf == null) {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
            Context context = this.zzt.zze;
            googleApiAvailabilityLight.getClass();
            AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
            int r0 = 0;
            try {
                r0 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.zzf = Integer.valueOf(r0 / 1000);
        }
        return this.zzf.intValue();
    }

    public final long zzq() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nanoTime = System.nanoTime();
                this.zzt.zzr.getClass();
                long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
                int r3 = this.zze + 1;
                this.zze = r3;
                j = nextLong + r3;
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1L, 1L);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public final Bundle zzs(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str = uri.getQueryParameter("utm_campaign");
                    str2 = uri.getQueryParameter("utm_source");
                    str3 = uri.getQueryParameter("utm_medium");
                    str4 = uri.getQueryParameter("gclid");
                    str5 = uri.getQueryParameter("utm_id");
                    str6 = uri.getQueryParameter("dclid");
                    str7 = uri.getQueryParameter("srsltid");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                }
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("campaign", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("source", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("medium", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("term", queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("content", queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("aclid", queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("cp1", queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("campaign_id", str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("dclid", str6);
                }
                String queryParameter6 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("source_platform", queryParameter6);
                }
                String queryParameter7 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("creative_format", queryParameter7);
                }
                String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("marketing_tactic", queryParameter8);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("srsltid", str7);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                zzeh zzehVar = this.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, "Install referrer url isn't a hierarchical URI");
            }
        }
        return null;
    }

    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzA = zzA(bundle.get(str), str);
                if (zzA == null) {
                    zzfr zzfrVar = this.zzt;
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zzb(zzfrVar.zzq.zze(str), "Param value can't be null");
                } else {
                    zzO(bundle2, str, zzA);
                }
            }
        }
        return bundle2;
    }

    public final Bundle zzy(String str, Bundle bundle, List list, boolean z) {
        int r0;
        String str2;
        String str3;
        List list2 = list;
        boolean zzas = zzas(str, zzgo.zzd);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            zzfr zzfrVar = this.zzt;
            int zzc = zzfrVar.zzk.zzc();
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int r18 = 0;
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (list2 != null && list2.contains(str4)) {
                    r0 = 0;
                } else {
                    if (!z) {
                        r0 = zzj(str4);
                    } else {
                        r0 = 0;
                    }
                    if (r0 == 0) {
                        r0 = zzi(str4);
                    }
                }
                if (r0 != 0) {
                    if (r0 == 3) {
                        str3 = str4;
                    } else {
                        str3 = null;
                    }
                    zzJ(bundle2, r0, str4, str3);
                    bundle2.remove(str4);
                } else {
                    int zza2 = zza(str, str4, bundle.get(str4), bundle2, list, z, zzas);
                    if (zza2 == 17) {
                        zzJ(bundle2, 17, str4, Boolean.FALSE);
                    } else if (zza2 != 0 && !"_ev".equals(str4)) {
                        if (zza2 == 21) {
                            str2 = str;
                        } else {
                            str2 = str4;
                        }
                        zzJ(bundle2, zza2, str2, bundle.get(str4));
                        bundle2.remove(str4);
                    }
                    if (zzai(str4)) {
                        int r02 = r18 + 1;
                        if (r02 > zzc) {
                            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Event can't contain more than ", zzc, " params");
                            zzeh zzehVar = zzfrVar.zzm;
                            zzfr.zzR(zzehVar);
                            String sb = m.toString();
                            zzec zzecVar = zzfrVar.zzq;
                            zzehVar.zzf.zzc(zzecVar.zzd(str), zzecVar.zzb(bundle), sb);
                            zzao(5, bundle2);
                            bundle2.remove(str4);
                        }
                        r18 = r02;
                    }
                }
                list2 = list;
            }
            return bundle2;
        }
        return null;
    }

    public final zzaw zzz(String str, Bundle bundle, String str2, long j, boolean z) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzh(str) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putString("_o", str2);
            Bundle zzy = zzy(str, bundle2, Collections.singletonList("_o"), true);
            if (z) {
                zzy = zzt(zzy);
            }
            Preconditions.checkNotNull(zzy);
            return new zzaw(str, new zzau(zzy), str2, j);
        }
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(zzfrVar.zzq.zzf(str), "Invalid conditional property event name");
        throw new IllegalArgumentException();
    }
}
