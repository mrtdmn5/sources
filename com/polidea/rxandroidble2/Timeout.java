package com.polidea.rxandroidble2;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Timeout {
    public final TimeUnit timeUnit;
    public final long timeout = 30;

    public Timeout(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
