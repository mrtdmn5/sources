package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.mock.SessionMock;
import com.animaconnected.watch.workout.SessionListItem;
import java.util.List;

/* compiled from: SessionMock.kt */
/* loaded from: classes3.dex */
public interface FakeSessionGenerator {
    Session bikeSession();

    FitnessProvider.Profile.Measurement getMeasurement();

    SessionListItem healthOnboardingSessions();

    Session otherSession();

    Session runningSession();

    CommonFlow<List<Session>> sessions();

    void setMeasurement(FitnessProvider.Profile.Measurement measurement);

    void setSessionIntervals(List<SessionMock.IntervalType> list);

    Session walkingSession();
}
