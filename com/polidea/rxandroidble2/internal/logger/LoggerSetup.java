package com.polidea.rxandroidble2.internal.logger;

import com.polidea.rxandroidble2.LogOptions$Logger;
import com.polidea.rxandroidble2.internal.RxBleLog;

/* loaded from: classes3.dex */
public final class LoggerSetup {
    public final LogOptions$Logger logger;

    public LoggerSetup(RxBleLog.AnonymousClass1 anonymousClass1) {
        this.logger = anonymousClass1;
    }

    public final String toString() {
        return "LoggerSetup{logLevel=2147483647, macAddressLogSetting=2147483647, uuidLogSetting=2147483647, shouldLogAttributeValues=false, shouldLogScannedPeripherals=true, logger=" + this.logger + '}';
    }
}
