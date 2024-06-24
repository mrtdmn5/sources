package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;

/* loaded from: classes3.dex */
public interface ScanSetupBuilder {
    ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr);
}
