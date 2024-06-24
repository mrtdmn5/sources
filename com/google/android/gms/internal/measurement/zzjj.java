package com.google.android.gms.internal.measurement;

import com.animaconnected.secondo.R;
import java.io.IOException;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjj extends zzjm {
    public final byte[] zzb;
    public final int zzc;
    public int zzd;

    public zzjj(byte[] bArr, int r5) {
        super(0);
        int length = bArr.length;
        if (((length - r5) | r5) >= 0) {
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = r5;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(r5)));
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzb(byte b) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int r1 = this.zzd;
            this.zzd = r1 + 1;
            bArr[r1] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzc(byte[] bArr, int r5) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, r5);
            this.zzd += r5;
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(r5)), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzd(int r1, boolean z) throws IOException {
        zzq(r1 << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zze(int r1, zzje zzjeVar) throws IOException {
        zzq((r1 << 3) | 2);
        zzq(zzjeVar.zzd());
        zzjeVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzf(int r1, int r2) throws IOException {
        zzq((r1 << 3) | 5);
        zzg(r2);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzg(int r5) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int r1 = this.zzd;
            int r2 = r1 + 1;
            bArr[r1] = (byte) (r5 & 255);
            int r12 = r2 + 1;
            bArr[r2] = (byte) ((r5 >> 8) & 255);
            int r22 = r12 + 1;
            bArr[r12] = (byte) ((r5 >> 16) & 255);
            this.zzd = r22 + 1;
            bArr[r22] = (byte) ((r5 >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzh(int r1, long j) throws IOException {
        zzq((r1 << 3) | 1);
        zzi(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int r1 = this.zzd;
            int r2 = r1 + 1;
            bArr[r1] = (byte) (((int) j) & 255);
            int r12 = r2 + 1;
            bArr[r2] = (byte) (((int) (j >> 8)) & 255);
            int r22 = r12 + 1;
            bArr[r12] = (byte) (((int) (j >> 16)) & 255);
            int r13 = r22 + 1;
            bArr[r22] = (byte) (((int) (j >> 24)) & 255);
            int r23 = r13 + 1;
            bArr[r13] = (byte) (((int) (j >> 32)) & 255);
            int r14 = r23 + 1;
            bArr[r23] = (byte) (((int) (j >> 40)) & 255);
            int r24 = r14 + 1;
            bArr[r14] = (byte) (((int) (j >> 48)) & 255);
            this.zzd = r24 + 1;
            bArr[r24] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzj(int r1, int r2) throws IOException {
        zzq(r1 << 3);
        zzk(r2);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzk(int r3) throws IOException {
        if (r3 >= 0) {
            zzq(r3);
        } else {
            zzs(r3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzm(int r8, String str) throws IOException {
        zzq((r8 << 3) | 2);
        int r82 = this.zzd;
        try {
            int zzA = zzjm.zzA(str.length() * 3);
            int zzA2 = zzjm.zzA(str.length());
            int r2 = this.zzc;
            byte[] bArr = this.zzb;
            if (zzA2 == zzA) {
                int r0 = r82 + zzA2;
                this.zzd = r0;
                int zzb = zznd.zzb(str, bArr, r0, r2 - r0);
                this.zzd = r82;
                zzq((zzb - r82) - zzA2);
                this.zzd = zzb;
            } else {
                zzq(zznd.zzc(str));
                int r02 = this.zzd;
                this.zzd = zznd.zzb(str, bArr, r02, r2 - r02);
            }
        } catch (zznc e) {
            this.zzd = r82;
            zzjm.zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
            byte[] bytes = str.getBytes(zzkn.zzb);
            try {
                int length = bytes.length;
                zzq(length);
                zzc(bytes, length);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzjk(e2);
            }
        } catch (IndexOutOfBoundsException e3) {
            throw new zzjk(e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzo(int r1, int r2) throws IOException {
        zzq((r1 << 3) | r2);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzp(int r1, int r2) throws IOException {
        zzq(r1 << 3);
        zzq(r2);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzq(int r5) throws IOException {
        while (true) {
            int r0 = r5 & (-128);
            byte[] bArr = this.zzb;
            if (r0 == 0) {
                int r02 = this.zzd;
                this.zzd = r02 + 1;
                bArr[r02] = (byte) r5;
                return;
            } else {
                try {
                    int r03 = this.zzd;
                    this.zzd = r03 + 1;
                    bArr[r03] = (byte) ((r5 & R.styleable.AppTheme_statusTextH5) | 128);
                    r5 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzr(int r1, long j) throws IOException {
        zzq(r1 << 3);
        zzs(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    public final void zzs(long j) throws IOException {
        boolean z = zzjm.zzc;
        int r6 = this.zzc;
        byte[] bArr = this.zzb;
        if (z && r6 - this.zzd >= 10) {
            while ((j & (-128)) != 0) {
                int r0 = this.zzd;
                this.zzd = r0 + 1;
                long j2 = r0;
                zzmy.zzf.zzd(bArr, zzmy.zza + j2, (byte) ((((int) j) & R.styleable.AppTheme_statusTextH5) | 128));
                j >>>= 7;
            }
            int r02 = this.zzd;
            this.zzd = r02 + 1;
            zzmy.zzf.zzd(bArr, zzmy.zza + r02, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                int r03 = this.zzd;
                this.zzd = r03 + 1;
                bArr[r03] = (byte) ((((int) j) & R.styleable.AppTheme_statusTextH5) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(r6), 1), e);
            }
        }
        int r04 = this.zzd;
        this.zzd = r04 + 1;
        bArr[r04] = (byte) j;
    }
}
