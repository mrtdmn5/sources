package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.scan.ScanFilter;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EmulatedScanFilterMatcher {
    public final boolean isEmpty;
    public final ScanFilterInterface[] scanFilters;

    public EmulatedScanFilterMatcher(ScanFilterInterface... scanFilterInterfaceArr) {
        boolean z;
        this.scanFilters = scanFilterInterfaceArr;
        if (scanFilterInterfaceArr != null && scanFilterInterfaceArr.length != 0) {
            z = false;
            for (ScanFilterInterface scanFilterInterface : scanFilterInterfaceArr) {
                if (!((ScanFilter) scanFilterInterface).equals(ScanFilter.EMPTY)) {
                    break;
                }
            }
        }
        z = true;
        this.isEmpty = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:            if (r8 == null) goto L73;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:            if (r11 == false) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:            if (r11 == false) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:            if (com.polidea.rxandroidble2.scan.ScanFilter.matchesPartialData(r8, r7.mServiceDataMask, r10.getServiceData(r11)) == false) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e9, code lost:            if (com.polidea.rxandroidble2.scan.ScanFilter.matchesPartialData(r9, r7.mManufacturerDataMask, r10.getManufacturerSpecificData(r8)) == false) goto L72;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f1 A[LOOP:0: B:6:0x0011->B:13:0x00f1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean matches(com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult r17) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher.matches(com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult):boolean");
    }

    public final String toString() {
        return "emulatedFilters=" + Arrays.toString(this.scanFilters);
    }
}
