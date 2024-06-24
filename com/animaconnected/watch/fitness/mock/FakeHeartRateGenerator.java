package com.animaconnected.watch.fitness.mock;

import kotlin.jvm.functions.Function0;

/* compiled from: HeartRateMock.kt */
/* loaded from: classes3.dex */
public interface FakeHeartRateGenerator {
    /* renamed from: getLiveHeartRateDelay-UwyO8pc */
    long mo1453getLiveHeartRateDelayUwyO8pc();

    Function0<Integer> getNextHeartRateValue();

    Function0<Integer> getNextRestingHeartRateValue();

    boolean isLiveHeartRateEnabled();

    /* renamed from: setLiveHeartRateDelay-LRDsOJo */
    void mo1454setLiveHeartRateDelayLRDsOJo(long j);

    void setLiveHeartRateEnabled(boolean z);

    void setNextHeartRateValue(Function0<Integer> function0);

    void setNextRestingHeartRateValue(Function0<Integer> function0);
}
