package com.animaconnected.watch.fitness.sync;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.fitness.Distance;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.GpsQuality;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SpeedCalibration;
import com.animaconnected.watch.fitness.SyncResult;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FitnessSyncIO.kt */
/* loaded from: classes3.dex */
public interface FitnessSyncIO {
    void addLocationData(double d, double d2, float f, double d3, boolean z);

    void addProcessedSession(Session session);

    void addProcessedSessions(List<Session> list);

    Object addSteps(long j, int r3, Continuation<? super Unit> continuation);

    Flow<SyncResult> readFitnessData(DisplayWatch displayWatch);

    Object readSessionData(Continuation<? super Map<FitnessMetric, Integer>> continuation);

    Object readStepsDay(int r1, Continuation<? super List<Integer>> continuation);

    Object setGoal(HealthGoals healthGoals, Continuation<? super Unit> continuation);

    Object writeDailyFitnessData(BasicStorage basicStorage, Continuation<? super Unit> continuation);

    Object writeHeartRateLive(boolean z, Continuation<? super Unit> continuation);

    Object writeSessionDataFeed(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation);

    Object writeSpeedCalibration(SpeedCalibration speedCalibration, Continuation<? super Unit> continuation);

    Object writeStepsDay(int r1, int r2, Continuation<? super Unit> continuation);
}
