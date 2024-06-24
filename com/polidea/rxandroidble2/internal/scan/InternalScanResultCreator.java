package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.ScanRecordParser;

/* loaded from: classes3.dex */
public final class InternalScanResultCreator {
    public final IsConnectableChecker isConnectableChecker;
    public final ScanRecordParser scanRecordParser;

    public InternalScanResultCreator(ScanRecordParser scanRecordParser, IsConnectableChecker isConnectableChecker) {
        this.scanRecordParser = scanRecordParser;
        this.isConnectableChecker = isConnectableChecker;
    }
}
