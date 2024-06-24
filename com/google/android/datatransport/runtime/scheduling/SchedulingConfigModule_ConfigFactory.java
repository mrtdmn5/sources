package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {
    public final Provider<Clock> clockProvider = TimeModule_EventClockFactory.InstanceHolder.INSTANCE;

    @Override // javax.inject.Provider
    public final Object get() {
        Clock clock = this.clockProvider.get();
        HashMap hashMap = new HashMap();
        Priority priority = Priority.DEFAULT;
        AutoValue_SchedulerConfig_ConfigValue.Builder builder = new AutoValue_SchedulerConfig_ConfigValue.Builder();
        Set<SchedulerConfig.Flag> emptySet = Collections.emptySet();
        if (emptySet != null) {
            builder.flags = emptySet;
            builder.delta = 30000L;
            builder.maxAllowedDelay = 86400000L;
            hashMap.put(priority, builder.build());
            Priority priority2 = Priority.HIGHEST;
            AutoValue_SchedulerConfig_ConfigValue.Builder builder2 = new AutoValue_SchedulerConfig_ConfigValue.Builder();
            Set<SchedulerConfig.Flag> emptySet2 = Collections.emptySet();
            if (emptySet2 != null) {
                builder2.flags = emptySet2;
                builder2.delta = 1000L;
                builder2.maxAllowedDelay = 86400000L;
                hashMap.put(priority2, builder2.build());
                Priority priority3 = Priority.VERY_LOW;
                AutoValue_SchedulerConfig_ConfigValue.Builder builder3 = new AutoValue_SchedulerConfig_ConfigValue.Builder();
                Set<SchedulerConfig.Flag> emptySet3 = Collections.emptySet();
                if (emptySet3 != null) {
                    builder3.flags = emptySet3;
                    builder3.delta = 86400000L;
                    builder3.maxAllowedDelay = 86400000L;
                    Set<SchedulerConfig.Flag> unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig.Flag.DEVICE_IDLE)));
                    if (unmodifiableSet != null) {
                        builder3.flags = unmodifiableSet;
                        hashMap.put(priority3, builder3.build());
                        if (clock != null) {
                            if (hashMap.keySet().size() >= Priority.values().length) {
                                new HashMap();
                                return new AutoValue_SchedulerConfig(clock, hashMap);
                            }
                            throw new IllegalStateException("Not all priorities have been configured");
                        }
                        throw new NullPointerException("missing required property: clock");
                    }
                    throw new NullPointerException("Null flags");
                }
                throw new NullPointerException("Null flags");
            }
            throw new NullPointerException("Null flags");
        }
        throw new NullPointerException("Null flags");
    }
}
