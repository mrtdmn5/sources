package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import io.reactivex.Scheduler;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ScanPreconditionsVerifierApi24 implements ScanPreconditionsVerifier {
    public static final long EXCESSIVE_SCANNING_PERIOD = TimeUnit.SECONDS.toMillis(30);
    public final long[] previousChecks = new long[5];
    public final ScanPreconditionsVerifierApi18 scanPreconditionVerifierApi18;
    public final Scheduler timeScheduler;

    public ScanPreconditionsVerifierApi24(ScanPreconditionsVerifierApi18 scanPreconditionsVerifierApi18, Scheduler scheduler) {
        this.scanPreconditionVerifierApi18 = scanPreconditionsVerifierApi18;
        this.timeScheduler = scheduler;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier
    public final void verify(boolean z) {
        long[] jArr;
        this.scanPreconditionVerifierApi18.verify(z);
        long j = Long.MAX_VALUE;
        int r10 = -1;
        int r2 = 0;
        while (true) {
            jArr = this.previousChecks;
            if (r2 >= 5) {
                break;
            }
            long j2 = jArr[r2];
            if (j2 < j) {
                r10 = r2;
                j = j2;
            }
            r2++;
        }
        long j3 = jArr[r10];
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.timeScheduler.getClass();
        long convert = timeUnit.convert(System.currentTimeMillis(), timeUnit);
        long j4 = convert - j3;
        long j5 = EXCESSIVE_SCANNING_PERIOD;
        if (j4 >= j5) {
            jArr[r10] = convert;
            return;
        }
        throw new BleScanException(new Date(j3 + j5));
    }
}
