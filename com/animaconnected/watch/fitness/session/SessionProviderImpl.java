package com.animaconnected.watch.fitness.session;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.CurrentSessionData;
import com.animaconnected.watch.fitness.Distance;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.GpsQuality;
import com.animaconnected.watch.fitness.InternalFitnessProvider;
import com.animaconnected.watch.fitness.KnownDistance;
import com.animaconnected.watch.fitness.SessionState;
import com.animaconnected.watch.fitness.UnknownDistance;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SessionProviderImpl.kt */
/* loaded from: classes3.dex */
public final class SessionProviderImpl implements InternalFitnessProvider.InternalSessionProvider, FitnessProvider.SessionProvider {
    private final MutableStateFlow<CurrentSessionData> currentSessionDataFlow;
    private boolean enableSpeedCalibration;
    private final SessionDataListener listener;
    private Long speedCalibratingStart;
    private final String speedCalibrationTag;

    /* compiled from: SessionProviderImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FitnessMetric.values().length];
            try {
                r0[FitnessMetric.SessionGps.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FitnessMetric.SessionState.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FitnessMetric.SessionId.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public SessionProviderImpl(SessionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.speedCalibrationTag = "SpeedCalib";
        this.currentSessionDataFlow = StateFlowKt.MutableStateFlow(new CurrentSessionData(null, null, null, null, null, null, 63, null));
    }

    private final void sendToWatch(CurrentSessionData currentSessionData) {
        this.listener.feedToWatch(currentSessionData.getGpsQuality(), currentSessionData.getDistance(), currentSessionData.getSpeed());
    }

    private final void speedCalibrate(Distance distance, Distance distance2) {
        if ((distance instanceof UnknownDistance) && this.speedCalibratingStart != null) {
            LogKt.debug$default((Object) this, this.speedCalibrationTag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$speedCalibrate$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Aborted due to disconnect or paused";
                }
            }, 6, (Object) null);
            this.speedCalibratingStart = null;
        }
        final Long thresholdCrossedAt = thresholdCrossedAt(distance, distance2, 500);
        if (thresholdCrossedAt != null) {
            LogKt.debug$default((Object) this, this.speedCalibrationTag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$speedCalibrate$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Passing 500m start calibration at " + thresholdCrossedAt;
                }
            }, 6, (Object) null);
            this.listener.startSpeedCalibration();
            this.speedCalibratingStart = thresholdCrossedAt;
        }
        final Long thresholdCrossedAt2 = thresholdCrossedAt(distance, distance2, 3050);
        final Long l = this.speedCalibratingStart;
        if (thresholdCrossedAt2 != null && l != null) {
            LogKt.debug$default((Object) this, this.speedCalibrationTag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$speedCalibrate$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Passing 3050m! calculate between: " + l + " -> " + thresholdCrossedAt2;
                }
            }, 6, (Object) null);
            this.listener.stopSpeedCalibration(l.longValue(), thresholdCrossedAt2.longValue());
            this.speedCalibratingStart = null;
        }
    }

    private final Long thresholdCrossedAt(Distance distance, Distance distance2, int r7) {
        if (distance instanceof KnownDistance) {
            double d = r7;
            if (((KnownDistance) distance).getTotal() <= d && (distance2 instanceof KnownDistance)) {
                KnownDistance knownDistance = (KnownDistance) distance2;
                if (knownDistance.getTotal() > d) {
                    return Long.valueOf(knownDistance.getTimestamp());
                }
            }
        }
        return null;
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider
    public void abortSpeedCalibration() {
        if (this.speedCalibratingStart != null) {
            this.speedCalibratingStart = null;
            LogKt.debug$default((Object) this, this.speedCalibrationTag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$abortSpeedCalibration$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Watch aborted speed calibration!";
                }
            }, 6, (Object) null);
        } else {
            LogKt.warn$default((Object) this, this.speedCalibrationTag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$abortSpeedCalibration$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Watch tried to abort session that was never started or already aborted.";
                }
            }, 6, (Object) null);
        }
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider
    public void clear() {
        this.currentSessionDataFlow.setValue(new CurrentSessionData(null, null, null, null, null, null, 63, null));
        this.speedCalibratingStart = null;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.SessionProvider
    public CurrentSessionData getCurrentSessionData() {
        return this.currentSessionDataFlow.getValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.SessionProvider
    public CommonFlow<CurrentSessionData> getCurrentSessionDataFlow() {
        return FlowExtensionsKt.asCommonFlow(this.currentSessionDataFlow);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.SessionProvider
    public boolean getEnableSpeedCalibration() {
        return this.enableSpeedCalibration;
    }

    public final SessionDataListener getListener() {
        return this.listener;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.SessionProvider
    public boolean isSessionOngoing() {
        boolean z;
        CurrentSessionData value = this.currentSessionDataFlow.getValue();
        if (value.getSessionState() == SessionState.Off && value.getIdentifier() == null) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.SessionProvider
    public void setEnableSpeedCalibration(final boolean z) {
        this.enableSpeedCalibration = z;
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$enableSpeedCalibration$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "enableSpeedCalibration: " + z;
            }
        }, 7, (Object) null);
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider
    public Object setGpsData(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation) {
        CurrentSessionData value = this.currentSessionDataFlow.getValue();
        CurrentSessionData copy$default = CurrentSessionData.copy$default(value, null, null, null, gpsQuality, distance, f, 7, null);
        sendToWatch(copy$default);
        if (getEnableSpeedCalibration()) {
            speedCalibrate(value.getDistance(), distance);
        }
        this.currentSessionDataFlow.setValue(copy$default);
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider
    public Object setSessionData(Map<FitnessMetric, Integer> map, Continuation<? super Unit> continuation) {
        boolean z;
        Boolean bool;
        CurrentSessionData value = this.currentSessionDataFlow.getValue();
        while (true) {
            CurrentSessionData currentSessionData = value;
            for (final Map.Entry<FitnessMetric, Integer> entry : map.entrySet()) {
                int r1 = WhenMappings.$EnumSwitchMapping$0[entry.getKey().ordinal()];
                boolean z2 = true;
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 3) {
                            LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.session.SessionProviderImpl$setSessionData$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Unsupported FitnessMetric: " + entry.getKey();
                                }
                            }, 7, (Object) null);
                        } else {
                            value = CurrentSessionData.copy$default(currentSessionData, entry.getValue(), null, null, null, null, null, 62, null);
                        }
                    } else {
                        SessionState fromId = SessionState.Companion.fromId(entry.getValue());
                        CurrentSessionData currentSessionData2 = currentSessionData;
                        SessionState sessionState = currentSessionData2.getSessionState();
                        SessionState sessionState2 = SessionState.Off;
                        if (sessionState != sessionState2 && fromId == sessionState2) {
                            sendToWatch(currentSessionData2);
                            this.listener.sessionEnded();
                        } else if (currentSessionData2.getSessionState() == SessionState.Paused) {
                            currentSessionData = CurrentSessionData.copy$default(currentSessionData2, null, null, null, null, UnknownDistance.INSTANCE, null, 47, null);
                        }
                        value = CurrentSessionData.copy$default(currentSessionData, null, null, fromId, null, null, null, 59, null);
                    }
                } else {
                    Integer value2 = entry.getValue();
                    if (value2 != null && value2.intValue() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.listener.useConnectedGpsRequested(z);
                    CurrentSessionData currentSessionData3 = currentSessionData;
                    Integer value3 = entry.getValue();
                    if (value3 != null) {
                        if (value3.intValue() != 1) {
                            z2 = false;
                        }
                        bool = Boolean.valueOf(z2);
                    } else {
                        bool = null;
                    }
                    value = CurrentSessionData.copy$default(currentSessionData3, null, bool, null, null, null, null, 61, null);
                }
            }
            this.currentSessionDataFlow.setValue(currentSessionData);
            return Unit.INSTANCE;
        }
    }
}
