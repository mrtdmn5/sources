package com.animaconnected.watch.device;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: CrashInfo.kt */
/* loaded from: classes3.dex */
public final class CrashInfo {
    private final long errorCode;
    private final String filename;
    private final boolean isValid;
    private final int lineNumber;
    private final int lr;
    private final int pc;
    private final int psr;
    private final int r0;
    private final int r1;
    private final int r12;
    private final int r2;
    private final int r3;
    private final int sp;

    public CrashInfo(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, String str, int r11, long j) {
        boolean z;
        this.r0 = r1;
        this.r1 = r2;
        this.r2 = r3;
        this.r3 = r4;
        this.r12 = r5;
        this.sp = r6;
        this.lr = r7;
        this.pc = r8;
        this.psr = r9;
        this.filename = str;
        this.lineNumber = r11;
        this.errorCode = j;
        boolean z2 = false;
        Integer[] numArr = {Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9)};
        int r12 = 0;
        while (true) {
            if (r12 >= 9) {
                break;
            }
            if (numArr[r12].intValue() != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
                break;
            }
            r12++;
        }
        this.isValid = z2;
    }

    public static /* synthetic */ CrashInfo copy$default(CrashInfo crashInfo, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, String str, int r26, long j, int r29, Object obj) {
        int r2;
        int r3;
        int r4;
        int r5;
        int r6;
        int r7;
        int r8;
        int r9;
        int r10;
        String str2;
        int r12;
        long j2;
        if ((r29 & 1) != 0) {
            r2 = crashInfo.r0;
        } else {
            r2 = r16;
        }
        if ((r29 & 2) != 0) {
            r3 = crashInfo.r1;
        } else {
            r3 = r17;
        }
        if ((r29 & 4) != 0) {
            r4 = crashInfo.r2;
        } else {
            r4 = r18;
        }
        if ((r29 & 8) != 0) {
            r5 = crashInfo.r3;
        } else {
            r5 = r19;
        }
        if ((r29 & 16) != 0) {
            r6 = crashInfo.r12;
        } else {
            r6 = r20;
        }
        if ((r29 & 32) != 0) {
            r7 = crashInfo.sp;
        } else {
            r7 = r21;
        }
        if ((r29 & 64) != 0) {
            r8 = crashInfo.lr;
        } else {
            r8 = r22;
        }
        if ((r29 & 128) != 0) {
            r9 = crashInfo.pc;
        } else {
            r9 = r23;
        }
        if ((r29 & 256) != 0) {
            r10 = crashInfo.psr;
        } else {
            r10 = r24;
        }
        if ((r29 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            str2 = crashInfo.filename;
        } else {
            str2 = str;
        }
        if ((r29 & 1024) != 0) {
            r12 = crashInfo.lineNumber;
        } else {
            r12 = r26;
        }
        if ((r29 & 2048) != 0) {
            j2 = crashInfo.errorCode;
        } else {
            j2 = j;
        }
        return crashInfo.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, str2, r12, j2);
    }

    public final int component1() {
        return this.r0;
    }

    public final String component10() {
        return this.filename;
    }

    public final int component11() {
        return this.lineNumber;
    }

    public final long component12() {
        return this.errorCode;
    }

    public final int component2() {
        return this.r1;
    }

    public final int component3() {
        return this.r2;
    }

    public final int component4() {
        return this.r3;
    }

    public final int component5() {
        return this.r12;
    }

    public final int component6() {
        return this.sp;
    }

    public final int component7() {
        return this.lr;
    }

    public final int component8() {
        return this.pc;
    }

    public final int component9() {
        return this.psr;
    }

    public final CrashInfo copy(int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, String str, int r26, long j) {
        return new CrashInfo(r16, r17, r18, r19, r20, r21, r22, r23, r24, str, r26, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrashInfo)) {
            return false;
        }
        CrashInfo crashInfo = (CrashInfo) obj;
        if (this.r0 == crashInfo.r0 && this.r1 == crashInfo.r1 && this.r2 == crashInfo.r2 && this.r3 == crashInfo.r3 && this.r12 == crashInfo.r12 && this.sp == crashInfo.sp && this.lr == crashInfo.lr && this.pc == crashInfo.pc && this.psr == crashInfo.psr && Intrinsics.areEqual(this.filename, crashInfo.filename) && this.lineNumber == crashInfo.lineNumber && this.errorCode == crashInfo.errorCode) {
            return true;
        }
        return false;
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final int getLr() {
        return this.lr;
    }

    public final int getPc() {
        return this.pc;
    }

    public final int getPsr() {
        return this.psr;
    }

    public final int getR0() {
        return this.r0;
    }

    public final int getR1() {
        return this.r1;
    }

    public final int getR12() {
        return this.r12;
    }

    public final int getR2() {
        return this.r2;
    }

    public final int getR3() {
        return this.r3;
    }

    public final int getSp() {
        return this.sp;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.psr, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.pc, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.lr, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.sp, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.r12, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.r3, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.r2, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.r1, Integer.hashCode(this.r0) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        String str = this.filename;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return Long.hashCode(this.errorCode) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.lineNumber, (m + hashCode) * 31, 31);
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CrashInfo(r0=");
        sb.append(this.r0);
        sb.append(", r1=");
        sb.append(this.r1);
        sb.append(", r2=");
        sb.append(this.r2);
        sb.append(", r3=");
        sb.append(this.r3);
        sb.append(", r12=");
        sb.append(this.r12);
        sb.append(", sp=");
        sb.append(this.sp);
        sb.append(", lr=");
        sb.append(this.lr);
        sb.append(", pc=");
        sb.append(this.pc);
        sb.append(", psr=");
        sb.append(this.psr);
        sb.append(", filename=");
        sb.append(this.filename);
        sb.append(", lineNumber=");
        sb.append(this.lineNumber);
        sb.append(", errorCode=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.errorCode, ')');
    }
}
