package com.animaconnected.watch.fitness;

import com.animaconnected.watch.Watch;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: InternalFitnessProvider.kt */
/* loaded from: classes3.dex */
public interface InternalFitnessProvider {

    /* compiled from: InternalFitnessProvider.kt */
    /* loaded from: classes3.dex */
    public interface InternalSessionProvider {
        static /* synthetic */ Object setGpsData$default(InternalSessionProvider internalSessionProvider, GpsQuality gpsQuality, Distance distance, Float f, Continuation continuation, int r5, Object obj) {
            if (obj == null) {
                if ((r5 & 2) != 0) {
                    distance = UnknownDistance.INSTANCE;
                }
                if ((r5 & 4) != 0) {
                    f = null;
                }
                return internalSessionProvider.setGpsData(gpsQuality, distance, f, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setGpsData");
        }

        void abortSpeedCalibration();

        void clear();

        Object setGpsData(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation);

        Object setSessionData(Map<FitnessMetric, Integer> map, Continuation<? super Unit> continuation);
    }

    void onHybridSteps(int r1, int r2);

    Object processSessions(Continuation<? super Unit> continuation);

    void setWatch(Watch watch);

    void updateHeartrateLiveData(HeartrateValue heartrateValue);
}
