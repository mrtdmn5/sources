package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Map;
import java.util.Set;

@AutoValue
/* loaded from: classes3.dex */
public abstract class SchedulerConfig {

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class ConfigValue {

        @AutoValue.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder {
        }

        public abstract long getDelta();

        public abstract Set<Flag> getFlags();

        public abstract long getMaxAllowedDelay();
    }

    /* loaded from: classes3.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public abstract Clock getClock();

    public final long getScheduleDelay(Priority priority, long j, int r12) {
        long j2;
        long time = j - getClock().getTime();
        ConfigValue configValue = getValues().get(priority);
        long delta = configValue.getDelta();
        int r122 = r12 - 1;
        if (delta > 1) {
            j2 = delta;
        } else {
            j2 = 2;
        }
        return Math.min(Math.max((long) (Math.pow(3.0d, r122) * delta * Math.max(1.0d, Math.log(10000.0d) / Math.log(j2 * r122))), time), configValue.getMaxAllowedDelay());
    }

    public abstract Map<Priority, ConfigValue> getValues();
}
