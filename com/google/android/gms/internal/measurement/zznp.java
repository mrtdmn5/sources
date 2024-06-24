package com.google.android.gms.internal.measurement;

import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zznp implements zzno {
    public static final zzhu zzA;
    public static final zzhu zzB;
    public static final zzhu zzC;
    public static final zzhu zzD;
    public static final zzhu zzE;
    public static final zzhu zzF;
    public static final zzhu zzG;
    public static final zzhu zzH;
    public static final zzhu zzI;
    public static final zzhu zzJ;
    public static final zzhu zzK;
    public static final zzhx zzL;
    public static final zzhu zzM;
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhx zze;
    public static final zzhx zzf;
    public static final zzhu zzg;
    public static final zzhu zzh;
    public static final zzhu zzi;
    public static final zzhu zzj;
    public static final zzhu zzk;
    public static final zzhu zzl;
    public static final zzhu zzm;
    public static final zzhu zzn;
    public static final zzhu zzo;
    public static final zzhu zzp;
    public static final zzhu zzr;
    public static final zzhu zzt;
    public static final zzhu zzu;
    public static final zzhu zzv;
    public static final zzhu zzw;
    public static final zzhu zzx;
    public static final zzhu zzy;
    public static final zzhu zzz;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zza = zzhyVar.zzd(10000L, "measurement.ad_id_cache_time");
        zzb = zzhyVar.zzd(100L, "measurement.max_bundles_per_iteration");
        zzc = zzhyVar.zzd(86400000L, "measurement.config.cache_time");
        zzhyVar.zze("measurement.log_tag", "FA");
        zze = new zzhx(zzhyVar, "measurement.config.url_authority", "app-measurement.com");
        zzf = new zzhx(zzhyVar, "measurement.config.url_scheme", "https");
        zzg = zzhyVar.zzd(1000L, "measurement.upload.debug_upload_interval");
        zzh = zzhyVar.zzd(4L, "measurement.lifetimevalue.max_currency_tracked");
        zzi = zzhyVar.zzd(100000L, "measurement.store.max_stored_events_per_app");
        zzj = zzhyVar.zzd(50L, "measurement.experiment.max_ids");
        zzk = zzhyVar.zzd(200L, "measurement.audience.filter_result_max_count");
        zzl = zzhyVar.zzd(60000L, "measurement.alarm_manager.minimum_interval");
        zzm = zzhyVar.zzd(500L, "measurement.upload.minimum_delay");
        zzn = zzhyVar.zzd(86400000L, "measurement.monitoring.sample_period_millis");
        zzo = zzhyVar.zzd(10000L, "measurement.upload.realtime_upload_interval");
        zzp = zzhyVar.zzd(604800000L, "measurement.upload.refresh_blacklisted_config_interval");
        zzhyVar.zzd(3600000L, "measurement.config.cache_time.service");
        zzr = zzhyVar.zzd(DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT, "measurement.service_client.idle_disconnect_millis");
        zzhyVar.zze("measurement.log_tag.service", "FA-SVC");
        zzt = zzhyVar.zzd(86400000L, "measurement.upload.stale_data_deletion_interval");
        zzu = zzhyVar.zzd(604800000L, "measurement.sdk.attribution.cache.ttl");
        zzv = zzhyVar.zzd(7200000L, "measurement.redaction.app_instance_id.ttl");
        zzw = zzhyVar.zzd(43200000L, "measurement.upload.backoff_period");
        zzx = zzhyVar.zzd(15000L, "measurement.upload.initial_upload_delay_time");
        zzy = zzhyVar.zzd(3600000L, "measurement.upload.interval");
        zzz = zzhyVar.zzd(65536L, "measurement.upload.max_bundle_size");
        zzA = zzhyVar.zzd(100L, "measurement.upload.max_bundles");
        zzB = zzhyVar.zzd(500L, "measurement.upload.max_conversions_per_day");
        zzC = zzhyVar.zzd(1000L, "measurement.upload.max_error_events_per_day");
        zzD = zzhyVar.zzd(1000L, "measurement.upload.max_events_per_bundle");
        zzE = zzhyVar.zzd(100000L, "measurement.upload.max_events_per_day");
        zzF = zzhyVar.zzd(50000L, "measurement.upload.max_public_events_per_day");
        zzG = zzhyVar.zzd(2419200000L, "measurement.upload.max_queue_time");
        zzH = zzhyVar.zzd(10L, "measurement.upload.max_realtime_events_per_day");
        zzI = zzhyVar.zzd(65536L, "measurement.upload.max_batch_size");
        zzJ = zzhyVar.zzd(6L, "measurement.upload.retry_count");
        zzK = zzhyVar.zzd(1800000L, "measurement.upload.retry_time");
        zzL = new zzhx(zzhyVar, "measurement.upload.url", "https://app-measurement.com/a");
        zzM = zzhyVar.zzd(3600000L, "measurement.upload.window_interval");
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzA() {
        return ((Long) zzF.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzB() {
        return ((Long) zzG.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzC() {
        return ((Long) zzH.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzD() {
        return ((Long) zzI.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzE() {
        return ((Long) zzJ.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzF() {
        return ((Long) zzK.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzG() {
        return ((Long) zzM.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final String zzH() {
        return (String) zze.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final String zzI() {
        return (String) zzf.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final String zzJ() {
        return (String) zzL.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zza() {
        return ((Long) zza.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzb() {
        return ((Long) zzb.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzc() {
        return ((Long) zzc.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzd() {
        return ((Long) zzg.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zze() {
        return ((Long) zzh.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzf() {
        return ((Long) zzi.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzg() {
        return ((Long) zzj.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzh() {
        return ((Long) zzk.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzi() {
        return ((Long) zzl.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzj() {
        return ((Long) zzm.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzk() {
        return ((Long) zzn.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzl() {
        return ((Long) zzo.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzm() {
        return ((Long) zzp.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzn() {
        return ((Long) zzr.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzo() {
        return ((Long) zzt.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzp() {
        return ((Long) zzu.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzq() {
        return ((Long) zzv.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzr() {
        return ((Long) zzw.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzs() {
        return ((Long) zzx.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzt() {
        return ((Long) zzy.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzu() {
        return ((Long) zzz.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzv() {
        return ((Long) zzA.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzw() {
        return ((Long) zzB.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzx() {
        return ((Long) zzC.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzy() {
        return ((Long) zzD.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final long zzz() {
        return ((Long) zzE.zzb()).longValue();
    }
}
