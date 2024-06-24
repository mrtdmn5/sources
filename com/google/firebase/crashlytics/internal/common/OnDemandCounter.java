package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class OnDemandCounter {
    public final AtomicInteger recordedOnDemandExceptions = new AtomicInteger();
    public final AtomicInteger droppedOnDemandExceptions = new AtomicInteger();
}
