package com.animaconnected.secondo.provider.googlefit;

import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;

/* compiled from: GoogleFitScopeProvider.kt */
/* loaded from: classes3.dex */
public final class GoogleFitScopeProvider {
    public static final int $stable = 0;
    public static final GoogleFitScopeProvider INSTANCE = new GoogleFitScopeProvider();

    private GoogleFitScopeProvider() {
    }

    private final FitnessOptions getScopesForDisplay() {
        FitnessOptions.Builder builder = new FitnessOptions.Builder();
        builder.addDataType(DataType.TYPE_STEP_COUNT_DELTA);
        builder.addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA);
        builder.addDataType(DataType.TYPE_HEART_RATE_BPM);
        builder.addDataType(DataType.TYPE_SLEEP_SEGMENT);
        builder.addDataType(DataType.TYPE_CALORIES_EXPENDED);
        builder.zza.add(new Scope(1, "https://www.googleapis.com/auth/fitness.sleep.write"));
        return new FitnessOptions(builder);
    }

    private final FitnessOptions getScopesForHybrid() {
        FitnessOptions.Builder builder = new FitnessOptions.Builder();
        builder.addDataType(DataType.TYPE_STEP_COUNT_DELTA);
        builder.addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA);
        return new FitnessOptions(builder);
    }

    public final FitnessOptions getFitnessOptions() {
        DeviceType deviceType = ProviderFactory.getWatch().getDeviceType();
        boolean z = false;
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        }
        if (z) {
            return getScopesForDisplay();
        }
        return getScopesForHybrid();
    }
}
