package com.animaconnected.watch.fitness.session;

import com.animaconnected.watch.fitness.Distance;
import com.animaconnected.watch.fitness.GpsQuality;

/* compiled from: SessionProviderImpl.kt */
/* loaded from: classes3.dex */
public interface SessionDataListener {
    static /* synthetic */ void feedToWatch$default(SessionDataListener sessionDataListener, GpsQuality gpsQuality, Distance distance, Float f, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                f = null;
            }
            sessionDataListener.feedToWatch(gpsQuality, distance, f);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedToWatch");
    }

    void feedToWatch(GpsQuality gpsQuality, Distance distance, Float f);

    void sessionEnded();

    void startSpeedCalibration();

    void stopSpeedCalibration(long j, long j2);

    void useConnectedGpsRequested(boolean z);
}
