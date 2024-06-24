package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.compose.ui.geometry.MutableRectKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzt;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfi extends zzkh implements zzaf {
    public final ArrayMap zza;
    public final ArrayMap zzb;
    public final ArrayMap zzc;
    public final zzff zzd;
    public final zzfg zze;
    public final ArrayMap zzg;
    public final ArrayMap zzh;
    public final ArrayMap zzi;
    public final ArrayMap zzj;
    public final ArrayMap zzk;
    public final ArrayMap zzl;

    public zzfi(zzkt zzktVar) {
        super(zzktVar);
        this.zzg = new ArrayMap();
        this.zza = new ArrayMap();
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzd = new zzff(this);
        this.zze = new zzfg(this);
    }

    public static final ArrayMap zzE(com.google.android.gms.internal.measurement.zzff zzffVar) {
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.zzfj zzfjVar : zzffVar.zzn()) {
            arrayMap.put(zzfjVar.zzb(), zzfjVar.zzc());
        }
        return arrayMap;
    }

    public final com.google.android.gms.internal.measurement.zzff zzA(String str, byte[] bArr) {
        Long l;
        zzfr zzfrVar = this.zzt;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
        try {
            com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzkv.zzl(com.google.android.gms.internal.measurement.zzff.zze(), bArr)).zzaC();
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzef zzefVar = zzehVar.zzl;
            String str2 = null;
            if (zzffVar.zzs()) {
                l = Long.valueOf(zzffVar.zzc());
            } else {
                l = null;
            }
            if (zzffVar.zzr()) {
                str2 = zzffVar.zzh();
            }
            zzefVar.zzc(l, str2, "Parsed config. version, gmp_app_id");
            return zzffVar;
        } catch (zzkp e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzg.zzc(zzeh.zzn(str), e, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.zzff.zzg();
        } catch (RuntimeException e2) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzg.zzc(zzeh.zzn(str), e2, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
    }

    public final void zzB(String str, com.google.android.gms.internal.measurement.zzfe zzfeVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.zzff) zzfeVar.zza).zzk()).iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzfb) it.next()).zzb());
        }
        for (int r4 = 0; r4 < ((com.google.android.gms.internal.measurement.zzff) zzfeVar.zza).zzb(); r4++) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) ((com.google.android.gms.internal.measurement.zzff) zzfeVar.zza).zzd(r4).zzby();
            boolean isEmpty = zzfcVar.zzc().isEmpty();
            zzfr zzfrVar = this.zzt;
            if (isEmpty) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("EventConfig contained null event name");
            } else {
                String zzc = zzfcVar.zzc();
                String zzb = MutableRectKt.zzb(zzfcVar.zzc(), zzgo.zza, zzgo.zzc);
                if (!TextUtils.isEmpty(zzb)) {
                    zzfcVar.zzaG();
                    com.google.android.gms.internal.measurement.zzfd.zzd((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza, zzb);
                    zzfeVar.zzaG();
                    com.google.android.gms.internal.measurement.zzff.zzo((com.google.android.gms.internal.measurement.zzff) zzfeVar.zza, r4, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzaC());
                }
                if (((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zzg() && ((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zze()) {
                    arrayMap.put(zzc, Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zzh() && ((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zzf()) {
                    arrayMap2.put(zzfcVar.zzc(), Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zzi()) {
                    if (((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zza() >= 2 && ((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zza() <= 65535) {
                        arrayMap3.put(zzfcVar.zzc(), Integer.valueOf(((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zza()));
                    } else {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzg.zzc(zzfcVar.zzc(), Integer.valueOf(((com.google.android.gms.internal.measurement.zzfd) zzfcVar.zza).zza()), "Invalid sampling rate. Event name, sample rate");
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:            if (r6 == null) goto L76;     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzC(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.zzC(java.lang.String):void");
    }

    public final void zzD(final String str, com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar.zza() != 0) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(Integer.valueOf(zzffVar.zza()), "EES programs found");
            com.google.android.gms.internal.measurement.zzgt zzgtVar = (com.google.android.gms.internal.measurement.zzgt) zzffVar.zzm().get(0);
            try {
                com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
                zzcVar.zza.zzd.zza.put("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfc
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzn(new zzfh(zzfi.this, str));
                    }
                });
                zzcVar.zza.zzd.zza.put("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfd
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzu(new Callable() { // from class: com.google.android.gms.measurement.internal.zzfb
                            public final /* synthetic */ String zzb;

                            public /* synthetic */ zzfb(String str2) {
                                r2 = str2;
                            }

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                zzfi zzfiVar = zzfi.this;
                                zzam zzamVar = zzfiVar.zzf.zze;
                                zzkt.zzal(zzamVar);
                                String str2 = r2;
                                zzh zzj = zzamVar.zzj(str2);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", "android");
                                hashMap.put("package_name", str2);
                                zzfiVar.zzt.zzk.zzh();
                                hashMap.put("gmp_version", 74029L);
                                if (zzj != null) {
                                    String zzw = zzj.zzw();
                                    if (zzw != null) {
                                        hashMap.put("app_version", zzw);
                                    }
                                    hashMap.put("app_version_int", Long.valueOf(zzj.zzb()));
                                    hashMap.put("dynamite_version", Long.valueOf(zzj.zzk()));
                                }
                                return hashMap;
                            }
                        });
                    }
                });
                zzcVar.zza.zzd.zza.put("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfe
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new zzt(zzfi.this.zze);
                    }
                });
                zzcVar.zzc(zzgtVar);
                this.zzd.put(str, zzcVar);
                zzeh zzehVar2 = this.zzt.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzc(str, Integer.valueOf(zzgtVar.zza().zza()), "EES program loaded for appId, activities");
                for (zzgr zzgrVar : zzgtVar.zza().zzd()) {
                    zzeh zzehVar3 = this.zzt.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzl.zzb(zzgrVar.zzb(), "EES program activity");
                }
                return;
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                zzeh zzehVar4 = this.zzt.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzd.zzb(str, "Failed to load EES program. appId");
                return;
            }
        }
        zzff zzffVar2 = this.zzd;
        if (str != null) {
            synchronized (zzffVar2) {
                if (zzffVar2.map.remove(str) != null) {
                    zzffVar2.size--;
                }
            }
            return;
        }
        zzffVar2.getClass();
        throw new NullPointerException("key == null");
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final String zza(String str, String str2) {
        zzg();
        zzC(str);
        Map map = (Map) this.zzg.getOrDefault(str, null);
        if (map == null) {
            return null;
        }
        return (String) map.get(str2);
    }

    public final int zzc(String str, String str2) {
        Integer num;
        zzg();
        zzC(str);
        Map map = (Map) this.zzi.getOrDefault(str, null);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.gms.internal.measurement.zzff zze(String str) {
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzC(str);
        return (com.google.android.gms.internal.measurement.zzff) this.zzh.getOrDefault(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzi(String str) {
        zzg();
        zzC(str);
        return (String) this.zzj.getOrDefault(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzo(String str) {
        com.google.android.gms.internal.measurement.zzff zzffVar;
        if (TextUtils.isEmpty(str) || (zzffVar = (com.google.android.gms.internal.measurement.zzff) this.zzh.getOrDefault(str, null)) == null || zzffVar.zza() == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzq(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzr(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if ("1".equals(zza(str, "measurement.upload.blacklist_internal")) && zzlb.zzah(str2)) {
            return true;
        }
        if ("1".equals(zza(str, "measurement.upload.blacklist_public")) && zzlb.zzai(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x036a, code lost:            r3 = r24;        r10 = r25;        r1 = r26;     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0372, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0373, code lost:            r1 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r1);        r1.zzd.zzc(com.google.android.gms.measurement.internal.zzeh.zzn(r31), r0, "Error storing event filter. appId");     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x045c, code lost:            r8.zzW();        r8.zzg();        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31);        r0 = r8.zzh();        r5 = r21;        r0.delete("property_filters", r5, new java.lang.String[]{r31, java.lang.String.valueOf(r7)});        r0.delete("event_filters", r5, new java.lang.String[]{r31, java.lang.String.valueOf(r7)});     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x048a, code lost:            r21 = r5;        r3 = r24;        r1 = r26;     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0343, code lost:            r3 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0327, code lost:            r3 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02d5, code lost:            r0 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r0);        r0 = r0.zzg;        r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r31);        r5 = java.lang.Integer.valueOf(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02ea, code lost:            if (r13.zzp() == false) goto L295;     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02ec, code lost:            r6 = java.lang.Integer.valueOf(r13.zzb());     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02f6, code lost:            r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r6));     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02fd, code lost:            r26 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02f5, code lost:            r6 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0385, code lost:            r26 = r1;        r0 = r0.zzh().iterator();     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0393, code lost:            if (r0.hasNext() == false) goto L446;     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0395, code lost:            r1 = (com.google.android.gms.internal.measurement.zzet) r0.next();        r8.zzW();        r8.zzg();        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31);        com.google.android.gms.common.internal.Preconditions.checkNotNull(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03af, code lost:            if (r1.zze().isEmpty() == false) goto L326;     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03db, code lost:            r10 = r1.zzbu();        r13 = new android.content.ContentValues();        r13.put(r3, r31);        r25 = r0;        r13.put("audience_id", java.lang.Integer.valueOf(r7));     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03f4, code lost:            if (r1.zzj() == false) goto L329;     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03f6, code lost:            r0 = java.lang.Integer.valueOf(r1.zza());     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0400, code lost:            r13.put("filter_id", r0);        r27 = r3;        r13.put("property_name", r1.zze());     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0412, code lost:            if (r1.zzk() == false) goto L333;     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0414, code lost:            r0 = java.lang.Boolean.valueOf(r1.zzi());     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x041e, code lost:            r13.put("session_scoped", r0);        r13.put("data", r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0432, code lost:            if (r8.zzh().insertWithOnConflict("property_filters", null, r13, 5) != (-1)) goto L339;     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0445, code lost:            r0 = r25;        r3 = r27;     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0434, code lost:            r0 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r0);        r0.zzd.zzb(com.google.android.gms.measurement.internal.zzeh.zzn(r31), "Failed to insert property filter (got -1). appId");     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x044b, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x044c, code lost:            r1 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r1);        r1.zzd.zzc(com.google.android.gms.measurement.internal.zzeh.zzn(r31), r0, "Error storing property filter. appId");     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x041d, code lost:            r0 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03ff, code lost:            r0 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03b1, code lost:            r0 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r0);        r0 = r0.zzg;        r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r31);        r5 = java.lang.Integer.valueOf(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03c6, code lost:            if (r1.zzj() == false) goto L324;     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03c8, code lost:            r1 = java.lang.Integer.valueOf(r1.zza());     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03d2, code lost:            r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r1));     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03d1, code lost:            r1 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0488, code lost:            r5 = r21;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x026f, code lost:            r10 = r0.zzh().iterator();     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x027b, code lost:            if (r10.hasNext() == false) goto L431;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0287, code lost:            if (((com.google.android.gms.internal.measurement.zzet) r10.next()).zzj() != false) goto L439;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0289, code lost:            r0 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r0);        r0.zzg.zzc(com.google.android.gms.measurement.internal.zzeh.zzn(r31), java.lang.Integer.valueOf(r7), "Property filter with no ID. Audience definition ignored. appId, audienceId");     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x029f, code lost:            r10 = r0.zzg().iterator();     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02a7, code lost:            r13 = r10.hasNext();     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02ab, code lost:            r24 = r3;        r3 = com.animaconnected.firebase.AnalyticsConstants.USER_PROPERTY_APP_ID;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02b7, code lost:            if (r13 == false) goto L441;     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02b9, code lost:            r13 = (com.google.android.gms.internal.measurement.zzek) r10.next();        r8.zzW();        r8.zzg();        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31);        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02d3, code lost:            if (r13.zzg().isEmpty() == false) goto L298;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0301, code lost:            r25 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0303, code lost:            r10 = r13.zzbu();     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0307, code lost:            r26 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0309, code lost:            r1 = new android.content.ContentValues();        r1.put(com.animaconnected.firebase.AnalyticsConstants.USER_PROPERTY_APP_ID, r31);        r1.put("audience_id", java.lang.Integer.valueOf(r7));     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x031c, code lost:            if (r13.zzp() == false) goto L304;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x031e, code lost:            r3 = java.lang.Integer.valueOf(r13.zzb());     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0328, code lost:            r1.put("filter_id", r3);        r1.put("event_name", r13.zzg());     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0338, code lost:            if (r13.zzq() == false) goto L308;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x033a, code lost:            r3 = java.lang.Boolean.valueOf(r13.zzn());     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0344, code lost:            r1.put("session_scoped", r3);        r1.put("data", r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0358, code lost:            if (r8.zzh().insertWithOnConflict("event_filters", null, r1, 5) != (-1)) goto L443;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x035a, code lost:            r1 = r6.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r1);        r1.zzd.zzb(com.google.android.gms.measurement.internal.zzeh.zzn(r31), "Failed to insert event filter (got -1). appId");     */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05f2 A[Catch: SQLiteException -> 0x0601, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0601, blocks: (B:190:0x05db, B:192:0x05f2), top: B:189:0x05db }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzt(java.lang.String r31, byte[] r32, java.lang.String r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 1577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.zzt(java.lang.String, byte[], java.lang.String, java.lang.String):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
