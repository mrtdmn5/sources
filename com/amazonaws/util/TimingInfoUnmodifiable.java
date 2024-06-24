package com.amazonaws.util;

/* loaded from: classes.dex */
final class TimingInfoUnmodifiable extends TimingInfo {
    public TimingInfoUnmodifiable(Long l, long j, Long l2) {
        super(l, j, l2);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo endTiming() {
        throw new UnsupportedOperationException();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void setEndTime(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void setEndTimeNano(long j) {
        throw new UnsupportedOperationException();
    }
}
