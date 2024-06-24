package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzew extends zzgl {
    public static final Pair zza = new Pair("", 0L);
    public zzeu zzb;
    public final zzes zzc;
    public final zzev zze;
    public final zzes zzf;
    public final zzeq zzg;
    public final zzev zzh;
    public final zzeq zzi;
    public final zzes zzj;
    public final zzes zzk;
    public boolean zzl;
    public final zzeq zzm;
    public final zzeq zzn;
    public final zzes zzo;
    public final zzev zzp;
    public final zzev zzq;
    public final zzes zzr;
    public final zzer zzs;
    public SharedPreferences zzu;
    public String zzv;
    public boolean zzw;
    public long zzx;

    public zzew(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = new zzes(this, "session_timeout", 1800000L);
        this.zzg = new zzeq(this, "start_new_session", true);
        this.zzj = new zzes(this, "last_pause_time", 0L);
        this.zzk = new zzes(this, "session_id", 0L);
        this.zzh = new zzev(this, "non_personalized_ads");
        this.zzi = new zzeq(this, "allow_remote_dynamite", false);
        this.zzc = new zzes(this, "first_open_time", 0L);
        Preconditions.checkNotEmpty("app_install_time");
        this.zze = new zzev(this, "app_instance_id");
        this.zzm = new zzeq(this, "app_backgrounded", false);
        this.zzn = new zzeq(this, "deep_link_retrieval_complete", false);
        this.zzo = new zzes(this, "deep_link_retrieval_attempts", 0L);
        this.zzp = new zzev(this, "firebase_feature_rollouts");
        this.zzq = new zzev(this, "deferred_attribution_cache");
        this.zzr = new zzes(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzs = new zzer(this);
    }

    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzu);
        return this.zzu;
    }

    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzaA() {
        SharedPreferences sharedPreferences = this.zzt.zze.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzu = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzl = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzu.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzeu(this, Math.max(0L, ((Long) zzdu.zzb.zza(null)).longValue()));
    }

    public final zzai zzc() {
        zzg();
        return zzai.zzb(zza().getString("consent_settings", "G1"));
    }

    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return true;
    }

    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final void zzi(boolean z) {
        zzg();
        zzeh zzehVar = this.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Boolean.valueOf(z), "App measurement setting deferred collection");
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    public final boolean zzk(long j) {
        if (j - this.zzf.zza() > this.zzj.zza()) {
            return true;
        }
        return false;
    }

    public final boolean zzl(int r4) {
        int r0 = zza().getInt("consent_source", 100);
        zzai zzaiVar = zzai.zza;
        if (r4 <= r0) {
            return true;
        }
        return false;
    }
}
