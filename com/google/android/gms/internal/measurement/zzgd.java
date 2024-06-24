package com.google.android.gms.internal.measurement;

import com.amazonaws.services.s3.internal.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgd extends zzkf implements zzln {
    public static final /* synthetic */ int zza = 0;
    private static final zzgd zzd;
    private String zzA;
    private long zzB;
    private int zzC;
    private String zzD;
    private String zzE;
    private boolean zzF;
    private zzkm zzG;
    private String zzH;
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL;
    private long zzM;
    private long zzN;
    private String zzO;
    private String zzP;
    private int zzQ;
    private String zzR;
    private zzgg zzS;
    private zzkk zzT;
    private long zzU;
    private long zzV;
    private String zzW;
    private String zzX;
    private int zzY;
    private boolean zzZ;
    private String zzaa;
    private boolean zzab;
    private zzfz zzac;
    private String zzad;
    private zzkm zzae;
    private String zzaf;
    private int zze;
    private int zzf;
    private int zzg;
    private zzkm zzh;
    private zzkm zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private int zzs;
    private String zzt;
    private String zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private String zzy;
    private boolean zzz;

    static {
        zzgd zzgdVar = new zzgd();
        zzd = zzgdVar;
        zzkf.zzbL(zzgd.class, zzgdVar);
    }

    public zzgd() {
        zzlv zzlvVar = zzlv.zza;
        this.zzh = zzlvVar;
        this.zzi = zzlvVar;
        this.zzo = "";
        this.zzp = "";
        this.zzq = "";
        this.zzr = "";
        this.zzt = "";
        this.zzu = "";
        this.zzv = "";
        this.zzy = "";
        this.zzA = "";
        this.zzD = "";
        this.zzE = "";
        this.zzG = zzlvVar;
        this.zzH = "";
        this.zzL = "";
        this.zzO = "";
        this.zzP = "";
        this.zzR = "";
        this.zzT = zzkg.zza;
        this.zzW = "";
        this.zzX = "";
        this.zzaa = "";
        this.zzad = "";
        this.zzae = zzlvVar;
        this.zzaf = "";
    }

    public static /* synthetic */ void zzP(zzgd zzgdVar) {
        zzgdVar.zze &= Integer.MAX_VALUE;
        zzgdVar.zzO = zzd.zzO;
    }

    public static /* synthetic */ void zzQ(zzgd zzgdVar, int r2) {
        zzgdVar.zzf |= 2;
        zzgdVar.zzQ = r2;
    }

    public static /* synthetic */ void zzR(zzgd zzgdVar, int r1, zzft zzftVar) {
        zzgdVar.zzbP();
        zzgdVar.zzh.set(r1, zzftVar);
    }

    public static /* synthetic */ void zzS(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zzf |= 4;
        zzgdVar.zzR = str;
    }

    public static void zzU(zzgd zzgdVar, ArrayList arrayList) {
        int r1;
        List list = zzgdVar.zzT;
        if (!((zzip) list).zza) {
            int size = list.size();
            if (size == 0) {
                r1 = 10;
            } else {
                r1 = size + size;
            }
            zzkg zzkgVar = (zzkg) list;
            if (r1 >= zzkgVar.zzc) {
                zzgdVar.zzT = new zzkg(Arrays.copyOf(zzkgVar.zzb, r1), zzkgVar.zzc);
            } else {
                throw new IllegalArgumentException();
            }
        }
        zzio.zzbt(arrayList, zzgdVar.zzT);
    }

    public static /* synthetic */ void zzV(zzgd zzgdVar, zzft zzftVar) {
        zzgdVar.zzbP();
        zzgdVar.zzh.add(zzftVar);
    }

    public static /* synthetic */ void zzW(zzgd zzgdVar, long j) {
        zzgdVar.zzf |= 16;
        zzgdVar.zzU = j;
    }

    public static /* synthetic */ void zzX(zzgd zzgdVar, long j) {
        zzgdVar.zzf |= 32;
        zzgdVar.zzV = j;
    }

    public static /* synthetic */ void zzY(zzgd zzgdVar, String str) {
        zzgdVar.zzf |= 128;
        zzgdVar.zzX = str;
    }

    public static /* synthetic */ void zzZ(zzgd zzgdVar, ArrayList arrayList) {
        zzgdVar.zzbP();
        zzio.zzbt(arrayList, zzgdVar.zzh);
    }

    public static /* synthetic */ void zzaA(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= DfuBaseService.ERROR_REMOTE_MASK;
        zzgdVar.zzv = str;
    }

    public static /* synthetic */ void zzaB(zzgd zzgdVar, long j) {
        zzgdVar.zze |= DfuBaseService.ERROR_CONNECTION_MASK;
        zzgdVar.zzw = j;
    }

    public static /* synthetic */ void zzaC(zzgd zzgdVar) {
        zzgdVar.zze |= DfuBaseService.ERROR_CONNECTION_STATE_MASK;
        zzgdVar.zzx = 74029L;
    }

    public static /* synthetic */ void zzaD(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 65536;
        zzgdVar.zzy = str;
    }

    public static /* synthetic */ void zzaE(zzgd zzgdVar) {
        zzgdVar.zze &= -65537;
        zzgdVar.zzy = zzd.zzy;
    }

    public static /* synthetic */ void zzaF(zzgd zzgdVar, boolean z) {
        zzgdVar.zze |= 131072;
        zzgdVar.zzz = z;
    }

    public static /* synthetic */ void zzaG(zzgd zzgdVar) {
        zzgdVar.zze &= -131073;
        zzgdVar.zzz = false;
    }

    public static /* synthetic */ void zzaH(zzgd zzgdVar, String str) {
        zzgdVar.zze |= 262144;
        zzgdVar.zzA = str;
    }

    public static /* synthetic */ void zzaI(zzgd zzgdVar) {
        zzgdVar.zze &= -262145;
        zzgdVar.zzA = zzd.zzA;
    }

    public static /* synthetic */ void zzaJ(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 524288;
        zzgdVar.zzB = j;
    }

    public static /* synthetic */ void zzaK(zzgd zzgdVar, int r3) {
        zzgdVar.zze |= Constants.MB;
        zzgdVar.zzC = r3;
    }

    public static /* synthetic */ void zzaL(zzgd zzgdVar, String str) {
        zzgdVar.zze |= 2097152;
        zzgdVar.zzD = str;
    }

    public static /* synthetic */ void zzaM(zzgd zzgdVar) {
        zzgdVar.zze &= -2097153;
        zzgdVar.zzD = zzd.zzD;
    }

    public static /* synthetic */ void zzaN(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 4194304;
        zzgdVar.zzE = str;
    }

    public static /* synthetic */ void zzaO(zzgd zzgdVar) {
        zzgdVar.zze |= 8388608;
        zzgdVar.zzF = false;
    }

    public static /* synthetic */ void zzaP(zzgd zzgdVar, ArrayList arrayList) {
        zzkm zzkmVar = zzgdVar.zzG;
        if (!zzkmVar.zzc()) {
            zzgdVar.zzG = zzkf.zzbF(zzkmVar);
        }
        zzio.zzbt(arrayList, zzgdVar.zzG);
    }

    public static void zzaQ(zzgd zzgdVar) {
        zzgdVar.zzG = zzlv.zza;
    }

    public static /* synthetic */ void zzaR(zzgd zzgdVar, String str) {
        zzgdVar.zze |= 16777216;
        zzgdVar.zzH = str;
    }

    public static /* synthetic */ void zzaS(zzgd zzgdVar, int r3) {
        zzgdVar.zze |= 33554432;
        zzgdVar.zzI = r3;
    }

    public static /* synthetic */ void zzaT(zzgd zzgdVar) {
        zzgdVar.zze |= 1;
        zzgdVar.zzg = 1;
    }

    public static /* synthetic */ void zzaU(zzgd zzgdVar) {
        zzgdVar.zze &= -268435457;
        zzgdVar.zzL = zzd.zzL;
    }

    public static /* synthetic */ void zzaV(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 536870912;
        zzgdVar.zzM = j;
    }

    public static /* synthetic */ void zzaa(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zzf |= DfuBaseService.ERROR_REMOTE_MASK;
        zzgdVar.zzad = str;
    }

    public static /* synthetic */ void zzab(zzgd zzgdVar) {
        zzgdVar.zzf &= -8193;
        zzgdVar.zzad = zzd.zzad;
    }

    public static /* synthetic */ void zzac(zzgd zzgdVar, Set set) {
        zzkm zzkmVar = zzgdVar.zzae;
        if (!zzkmVar.zzc()) {
            zzgdVar.zzae = zzkf.zzbF(zzkmVar);
        }
        zzio.zzbt(set, zzgdVar.zzae);
    }

    public static void zzad(zzgd zzgdVar) {
        zzgdVar.zzh = zzlv.zza;
    }

    public static /* synthetic */ void zzae(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zzf |= DfuBaseService.ERROR_CONNECTION_MASK;
        zzgdVar.zzaf = str;
    }

    public static /* synthetic */ void zzaf(zzgd zzgdVar, int r1) {
        zzgdVar.zzbP();
        zzgdVar.zzh.remove(r1);
    }

    public static /* synthetic */ void zzag(zzgd zzgdVar, int r1, zzgm zzgmVar) {
        zzgdVar.zzbQ();
        zzgdVar.zzi.set(r1, zzgmVar);
    }

    public static /* synthetic */ void zzah(zzgd zzgdVar, zzgm zzgmVar) {
        zzgdVar.zzbQ();
        zzgdVar.zzi.add(zzgmVar);
    }

    public static /* synthetic */ void zzaj(zzgd zzgdVar, int r1) {
        zzgdVar.zzbQ();
        zzgdVar.zzi.remove(r1);
    }

    public static /* synthetic */ void zzak(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 2;
        zzgdVar.zzj = j;
    }

    public static /* synthetic */ void zzal(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 4;
        zzgdVar.zzk = j;
    }

    public static /* synthetic */ void zzam(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 8;
        zzgdVar.zzl = j;
    }

    public static /* synthetic */ void zzan(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 16;
        zzgdVar.zzm = j;
    }

    public static /* synthetic */ void zzao(zzgd zzgdVar) {
        zzgdVar.zze &= -17;
        zzgdVar.zzm = 0L;
    }

    public static /* synthetic */ void zzap(zzgd zzgdVar, long j) {
        zzgdVar.zze |= 32;
        zzgdVar.zzn = j;
    }

    public static /* synthetic */ void zzaq(zzgd zzgdVar) {
        zzgdVar.zze &= -33;
        zzgdVar.zzn = 0L;
    }

    public static /* synthetic */ void zzar(zzgd zzgdVar) {
        zzgdVar.zze |= 64;
        zzgdVar.zzo = "android";
    }

    public static /* synthetic */ void zzas(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 128;
        zzgdVar.zzp = str;
    }

    public static /* synthetic */ void zzat(zzgd zzgdVar) {
        zzgdVar.zze &= -129;
        zzgdVar.zzp = zzd.zzp;
    }

    public static /* synthetic */ void zzau(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 256;
        zzgdVar.zzq = str;
    }

    public static /* synthetic */ void zzav(zzgd zzgdVar) {
        zzgdVar.zze &= -257;
        zzgdVar.zzq = zzd.zzq;
    }

    public static /* synthetic */ void zzaw(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
        zzgdVar.zzr = str;
    }

    public static /* synthetic */ void zzax(zzgd zzgdVar, int r2) {
        zzgdVar.zze |= 1024;
        zzgdVar.zzs = r2;
    }

    public static /* synthetic */ void zzay(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 2048;
        zzgdVar.zzt = str;
    }

    public static /* synthetic */ void zzaz(zzgd zzgdVar, String str) {
        str.getClass();
        zzgdVar.zze |= 4096;
        zzgdVar.zzu = str;
    }

    public static zzgc zzt() {
        return (zzgc) zzd.zzbx();
    }

    public final String zzA() {
        return this.zzv;
    }

    public final String zzB() {
        return this.zzX;
    }

    public final String zzC() {
        return this.zzq;
    }

    public final String zzD() {
        return this.zzO;
    }

    public final String zzE() {
        return this.zzH;
    }

    public final String zzF() {
        return this.zzE;
    }

    public final String zzG() {
        return this.zzD;
    }

    public final String zzH() {
        return this.zzp;
    }

    public final String zzI() {
        return this.zzo;
    }

    public final String zzJ() {
        return this.zzy;
    }

    public final String zzK() {
        return this.zzad;
    }

    public final String zzL() {
        return this.zzr;
    }

    public final zzkm zzM() {
        return this.zzG;
    }

    public final zzkm zzN() {
        return this.zzh;
    }

    public final zzkm zzO() {
        return this.zzi;
    }

    public final int zza() {
        return this.zzI;
    }

    public final boolean zzaW() {
        return this.zzz;
    }

    public final boolean zzaX() {
        return this.zzF;
    }

    public final boolean zzaY() {
        if ((this.zze & 33554432) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzaZ() {
        if ((this.zze & Constants.MB) != 0) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzC;
    }

    public final void zzbP() {
        zzkm zzkmVar = this.zzh;
        if (!zzkmVar.zzc()) {
            this.zzh = zzkf.zzbF(zzkmVar);
        }
    }

    public final void zzbQ() {
        zzkm zzkmVar = this.zzi;
        if (!zzkmVar.zzc()) {
            this.zzi = zzkf.zzbF(zzkmVar);
        }
    }

    public final boolean zzba() {
        if ((this.zze & 536870912) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbb() {
        if ((this.zzf & 128) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbc() {
        if ((this.zze & 524288) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbd() {
        if ((this.zzf & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbe() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbf() {
        if ((this.zze & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbg() {
        if ((this.zze & 131072) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbh() {
        if ((this.zze & 32) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbi() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbj() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbk() {
        if ((this.zzf & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbl() {
        if ((this.zze & 8388608) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbm() {
        if ((this.zzf & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbn() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbo() {
        if ((this.zze & 1024) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbp() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzbq() {
        if ((this.zze & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzQ;
    }

    public final int zzf() {
        return this.zzs;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final long zzh() {
        return this.zzM;
    }

    public final long zzi() {
        return this.zzB;
    }

    public final long zzj() {
        return this.zzU;
    }

    public final long zzk() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r60) {
        int r0 = r60 - 1;
        if (r0 != 0) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        if (r0 != 5) {
                            return null;
                        }
                        return zzd;
                    }
                    return new zzgc(0);
                }
                return new zzgd();
            }
            return new zzlw(zzd, "\u00014\u0000\u0002\u0001A4\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.", new Object[]{"zze", "zzf", "zzg", "zzh", zzft.class, "zzi", zzgm.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzfp.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", zzfl.zza, "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf"});
        }
        return (byte) 1;
    }

    public final long zzm() {
        return this.zzw;
    }

    public final long zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzm;
    }

    public final long zzp() {
        return this.zzk;
    }

    public final long zzq() {
        return this.zzj;
    }

    public final long zzr() {
        return this.zzx;
    }

    public final zzft zzs(int r2) {
        return (zzft) this.zzh.get(r2);
    }

    public final zzgm zzv(int r2) {
        return (zzgm) this.zzi.get(r2);
    }

    public final String zzw() {
        return this.zzR;
    }

    public final String zzx() {
        return this.zzu;
    }

    public final String zzy() {
        return this.zzA;
    }

    public final String zzz() {
        return this.zzt;
    }
}
