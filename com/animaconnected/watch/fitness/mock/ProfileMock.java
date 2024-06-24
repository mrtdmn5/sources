package com.animaconnected.watch.fitness.mock;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProfileMock.kt */
/* loaded from: classes3.dex */
public final class ProfileMock implements FitnessProvider.Profile {
    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object clearPersonalData(Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object fetchAndUpdateConfig(Continuation<? super WatchLibResult<FitnessConfig, WatchLibException>> continuation) {
        return new WatchLibResult.Success(new FitnessConfig((Long) null, (Integer) null, (Integer) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, (Bedtime) null, 255, (DefaultConstructorMarker) null));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Bedtime getBedtime() {
        return new Bedtime(0, 0, 3, (DefaultConstructorMarker) null);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Long getDateOfBirth() {
        return 3L;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Gender getGender() {
        return FitnessProvider.Profile.Gender.Male;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Integer getHeight() {
        return 188;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessConfig getLocalFitnessConfig() {
        return new FitnessConfig(Long.valueOf(DateTimeUtilsKt.currentTimeMillis()), (Integer) 188, (Integer) 71, (Long) 3L, Integer.valueOf(FitnessProvider.Profile.Gender.Male.getId$watch_release()), Integer.valueOf(FitnessProvider.Profile.Measurement.Metric.getId$watch_release()), Integer.valueOf(FitnessProvider.Profile.Temperature.Celsius.getId$watch_release()), (Bedtime) null, 128, (DefaultConstructorMarker) null);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Measurement getMeasurement() {
        return FitnessProvider.Profile.Measurement.Metric;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Temperature getTemperatureUnit() {
        return FitnessProvider.Profile.Temperature.Celsius;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Integer getWeight() {
        return 71;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object saveAndSyncConfig(FitnessConfig fitnessConfig, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setBedtime(Bedtime bedtime, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setDateOfBirth(Long l, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setGender(FitnessProvider.Profile.Gender gender, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setHeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setMeasurement(FitnessProvider.Profile.Measurement measurement, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setTemperatureUnit(FitnessProvider.Profile.Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setUnits(FitnessProvider.Profile.Measurement measurement, FitnessProvider.Profile.Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setWeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }
}
