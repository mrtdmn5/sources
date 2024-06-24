package com.animaconnected.secondo.behaviour.temperature;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.HybridWatch;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.RemoteComplicationBehaviour;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: Temperature.kt */
/* loaded from: classes3.dex */
public final class Temperature extends RemoteComplicationBehaviour {
    public static final int NOT_SET_HOUR = 0;
    public static final int NOT_SET_MINUTE = 0;
    private static final String TEMPERATURE_ANALYTICS_NAME = "temperature";
    private static final String TEMPERATURE_NAME = "Temperature";
    public static final String TYPE = "Temperature";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final HistoricalWeatherProvider weatherProvider = ProviderFactory.getWeatherProvider();
    private final String analyticsName = TEMPERATURE_ANALYTICS_NAME;
    private final String type = "Temperature";

    /* compiled from: Temperature.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean isCelsius() {
        if (ProviderFactory.getWatch().fitness().getProfile().getTemperatureUnit() == FitnessProvider.Profile.Temperature.Celsius) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.activate(slot);
        TemperatureWorkManager.INSTANCE.startTemperatureScheduler$secondo_kronabyRelease();
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour, com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Scale[]{Scale.ZeroToHundred, Scale.ZeroToSixty});
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour, com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        HybridWatch hybridWatch;
        Intrinsics.checkNotNullParameter(watch, "watch");
        super.connected(watch);
        if (watch instanceof HybridWatch) {
            hybridWatch = (HybridWatch) watch;
        } else {
            hybridWatch = null;
        }
        if (hybridWatch == null) {
            return;
        }
        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new Temperature$connected$1(hybridWatch, null), this.weatherProvider.getTemperature().observe()), hybridWatch.getScope());
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        super.deactivated(slot);
        TemperatureWorkManager.INSTANCE.stopTemperatureScheduler$secondo_kronabyRelease();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        Float rotation = this.weatherProvider.getTemperature().getRotation(isCelsius());
        if (rotation != null) {
            return rotation.floatValue();
        }
        return 0.0f;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        Float rotation = this.weatherProvider.getTemperature().getRotation(isCelsius());
        if (rotation != null) {
            return rotation.floatValue();
        }
        return 0.0f;
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour
    public int[] getRemoteData(List<? extends Scale> scales) {
        Integer num;
        Intrinsics.checkNotNullParameter(scales, "scales");
        Float rotation = this.weatherProvider.getTemperature().getRotation(isCelsius());
        if (rotation != null) {
            num = Integer.valueOf(MathKt__MathJVMKt.roundToInt(rotation.floatValue()));
        } else {
            num = null;
        }
        if (num != null) {
            return new int[]{num.intValue(), num.intValue()};
        }
        return new int[]{0, 0};
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour
    public int[] getRemoteDataConfig() {
        return new int[]{120, 0, 0};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}
