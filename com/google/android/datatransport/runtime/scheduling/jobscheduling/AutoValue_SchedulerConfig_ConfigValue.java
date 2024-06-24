package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes3.dex */
public final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {
    public final long delta;
    public final Set<SchedulerConfig.Flag> flags;
    public final long maxAllowedDelay;

    /* loaded from: classes3.dex */
    public static final class Builder extends SchedulerConfig.ConfigValue.Builder {
        public Long delta;
        public Set<SchedulerConfig.Flag> flags;
        public Long maxAllowedDelay;

        public final AutoValue_SchedulerConfig_ConfigValue build() {
            String str;
            if (this.delta == null) {
                str = " delta";
            } else {
                str = "";
            }
            if (this.maxAllowedDelay == null) {
                str = str.concat(" maxAllowedDelay");
            }
            if (this.flags == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " flags");
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.delta.longValue(), this.maxAllowedDelay.longValue(), this.flags);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.delta == configValue.getDelta() && this.maxAllowedDelay == configValue.getMaxAllowedDelay() && this.flags.equals(configValue.getFlags())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final long getDelta() {
        return this.delta;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final Set<SchedulerConfig.Flag> getFlags() {
        return this.flags;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final long getMaxAllowedDelay() {
        return this.maxAllowedDelay;
    }

    public final int hashCode() {
        long j = this.delta;
        int r0 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.maxAllowedDelay;
        return ((r0 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.flags.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.delta + ", maxAllowedDelay=" + this.maxAllowedDelay + ", flags=" + this.flags + "}";
    }
}
