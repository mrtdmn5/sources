package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import app.cash.sqldelight.TransactionWithoutReturn;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.WatchDatabase;
import com.animaconnected.watch.fitness.FitnessDatabaseParser;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import com.google.android.gms.tasks.zzac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessDatabaseParser.kt */
/* loaded from: classes3.dex */
public final class FitnessDatabaseParser {
    public static final FitnessDatabaseParser INSTANCE = new FitnessDatabaseParser();

    /* compiled from: FitnessDatabaseParser.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class FitnessData {
        private final List<ActivityEntry> activityData;
        private final List<ExerciseEntry> exerciseData;
        private final List<FitnessIndexEntry> fitnessIndexData;
        private final Goals goals;
        private final List<HeartrateEntry> heartrateData;
        private final List<LocationEntry> locationData;
        private final List<PowerEntry> powerData;
        private final FitnessConfig profile;
        private final List<RestingHeartrateEntry> restingHeartrateData;
        private final List<SessionEntry> sessionData;
        private final List<Session> sessions;
        private final List<SleepEntry> sleepData;
        private final List<SleepHistoryEntry> sleepHistoryData;
        private final List<SpeedCalibrationEntry> speedCalibrationData;
        private final List<StandEntry> standData;
        private final long startOfDay;
        private final List<StressEntry> stressData;
        private final int version;
        private final List<WristEntry> wristData;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(ActivityEntry$$serializer.INSTANCE), new ArrayListSerializer(HeartrateEntry$$serializer.INSTANCE), new ArrayListSerializer(RestingHeartrateEntry$$serializer.INSTANCE), new ArrayListSerializer(SleepEntry$$serializer.INSTANCE), new ArrayListSerializer(SleepHistoryEntry$$serializer.INSTANCE), new ArrayListSerializer(StandEntry$$serializer.INSTANCE), new ArrayListSerializer(PowerEntry$$serializer.INSTANCE), new ArrayListSerializer(StressEntry$$serializer.INSTANCE), new ArrayListSerializer(WristEntry$$serializer.INSTANCE), new ArrayListSerializer(SpeedCalibrationEntry$$serializer.INSTANCE), new ArrayListSerializer(FitnessIndexEntry$$serializer.INSTANCE), new ArrayListSerializer(ExerciseEntry$$serializer.INSTANCE), new ArrayListSerializer(SessionEntry$$serializer.INSTANCE), new ArrayListSerializer(LocationEntry$$serializer.INSTANCE), new ArrayListSerializer(FitnessDatabaseParser$Session$$serializer.INSTANCE)};

        /* compiled from: FitnessDatabaseParser.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<FitnessData> serializer() {
                return FitnessDatabaseParser$FitnessData$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ FitnessData(int r7, int r8, long j, Goals goals, FitnessConfig fitnessConfig, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, List list12, List list13, List list14, List list15, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (r7 & 7)) {
                zzac.throwMissingFieldException(r7, 7, FitnessDatabaseParser$FitnessData$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.version = r8;
            this.startOfDay = j;
            this.goals = goals;
            if ((r7 & 8) == 0) {
                this.profile = null;
            } else {
                this.profile = fitnessConfig;
            }
            int r2 = r7 & 16;
            EmptyList emptyList = EmptyList.INSTANCE;
            if (r2 == 0) {
                this.activityData = emptyList;
            } else {
                this.activityData = list;
            }
            if ((r7 & 32) == 0) {
                this.heartrateData = emptyList;
            } else {
                this.heartrateData = list2;
            }
            if ((r7 & 64) == 0) {
                this.restingHeartrateData = emptyList;
            } else {
                this.restingHeartrateData = list3;
            }
            if ((r7 & 128) == 0) {
                this.sleepData = emptyList;
            } else {
                this.sleepData = list4;
            }
            if ((r7 & 256) == 0) {
                this.sleepHistoryData = emptyList;
            } else {
                this.sleepHistoryData = list5;
            }
            if ((r7 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) == 0) {
                this.standData = emptyList;
            } else {
                this.standData = list6;
            }
            if ((r7 & 1024) == 0) {
                this.powerData = emptyList;
            } else {
                this.powerData = list7;
            }
            if ((r7 & 2048) == 0) {
                this.stressData = emptyList;
            } else {
                this.stressData = list8;
            }
            if ((r7 & 4096) == 0) {
                this.wristData = emptyList;
            } else {
                this.wristData = list9;
            }
            if ((r7 & DfuBaseService.ERROR_REMOTE_MASK) == 0) {
                this.speedCalibrationData = emptyList;
            } else {
                this.speedCalibrationData = list10;
            }
            if ((r7 & DfuBaseService.ERROR_CONNECTION_MASK) == 0) {
                this.fitnessIndexData = emptyList;
            } else {
                this.fitnessIndexData = list11;
            }
            if ((32768 & r7) == 0) {
                this.exerciseData = emptyList;
            } else {
                this.exerciseData = list12;
            }
            if ((65536 & r7) == 0) {
                this.sessionData = emptyList;
            } else {
                this.sessionData = list13;
            }
            if ((131072 & r7) == 0) {
                this.locationData = emptyList;
            } else {
                this.locationData = list14;
            }
            if ((r7 & 262144) == 0) {
                this.sessions = emptyList;
            } else {
                this.sessions = list15;
            }
        }

        public static final /* synthetic */ void write$Self$watch_release(FitnessData fitnessData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            boolean z16 = false;
            compositeEncoder.encodeIntElement(0, fitnessData.version, serialDescriptor);
            compositeEncoder.encodeLongElement(serialDescriptor, 1, fitnessData.startOfDay);
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, FitnessDatabaseParser$Goals$$serializer.INSTANCE, fitnessData.goals);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessData.profile != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, FitnessConfig$$serializer.INSTANCE, fitnessData.profile);
            }
            boolean shouldEncodeElementDefault = compositeEncoder.shouldEncodeElementDefault(serialDescriptor);
            EmptyList emptyList = EmptyList.INSTANCE;
            if (shouldEncodeElementDefault || !Intrinsics.areEqual(fitnessData.activityData, emptyList)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], fitnessData.activityData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.heartrateData, emptyList)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], fitnessData.heartrateData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.restingHeartrateData, emptyList)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], fitnessData.restingHeartrateData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.sleepData, emptyList)) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], fitnessData.sleepData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.sleepHistoryData, emptyList)) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], fitnessData.sleepHistoryData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.standData, emptyList)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], fitnessData.standData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.powerData, emptyList)) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], fitnessData.powerData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.stressData, emptyList)) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 11, kSerializerArr[11], fitnessData.stressData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.wristData, emptyList)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], fitnessData.wristData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.speedCalibrationData, emptyList)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 13, kSerializerArr[13], fitnessData.speedCalibrationData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.fitnessIndexData, emptyList)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 14, kSerializerArr[14], fitnessData.fitnessIndexData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.exerciseData, emptyList)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], fitnessData.exerciseData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.sessionData, emptyList)) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], fitnessData.sessionData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.locationData, emptyList)) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 17, kSerializerArr[17], fitnessData.locationData);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(fitnessData.sessions, emptyList)) {
                z16 = true;
            }
            if (z16) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 18, kSerializerArr[18], fitnessData.sessions);
            }
        }

        public final int component1() {
            return this.version;
        }

        public final List<StandEntry> component10() {
            return this.standData;
        }

        public final List<PowerEntry> component11() {
            return this.powerData;
        }

        public final List<StressEntry> component12() {
            return this.stressData;
        }

        public final List<WristEntry> component13() {
            return this.wristData;
        }

        public final List<SpeedCalibrationEntry> component14() {
            return this.speedCalibrationData;
        }

        public final List<FitnessIndexEntry> component15() {
            return this.fitnessIndexData;
        }

        public final List<ExerciseEntry> component16() {
            return this.exerciseData;
        }

        public final List<SessionEntry> component17() {
            return this.sessionData;
        }

        public final List<LocationEntry> component18() {
            return this.locationData;
        }

        public final List<Session> component19() {
            return this.sessions;
        }

        public final long component2() {
            return this.startOfDay;
        }

        public final Goals component3() {
            return this.goals;
        }

        public final FitnessConfig component4() {
            return this.profile;
        }

        public final List<ActivityEntry> component5() {
            return this.activityData;
        }

        public final List<HeartrateEntry> component6() {
            return this.heartrateData;
        }

        public final List<RestingHeartrateEntry> component7() {
            return this.restingHeartrateData;
        }

        public final List<SleepEntry> component8() {
            return this.sleepData;
        }

        public final List<SleepHistoryEntry> component9() {
            return this.sleepHistoryData;
        }

        public final FitnessData copy(int r23, long j, Goals goals, FitnessConfig fitnessConfig, List<ActivityEntry> activityData, List<HeartrateEntry> heartrateData, List<RestingHeartrateEntry> restingHeartrateData, List<SleepEntry> sleepData, List<SleepHistoryEntry> sleepHistoryData, List<StandEntry> standData, List<PowerEntry> powerData, List<StressEntry> stressData, List<WristEntry> wristData, List<SpeedCalibrationEntry> speedCalibrationData, List<FitnessIndexEntry> fitnessIndexData, List<ExerciseEntry> exerciseData, List<SessionEntry> sessionData, List<LocationEntry> locationData, List<Session> sessions) {
            Intrinsics.checkNotNullParameter(activityData, "activityData");
            Intrinsics.checkNotNullParameter(heartrateData, "heartrateData");
            Intrinsics.checkNotNullParameter(restingHeartrateData, "restingHeartrateData");
            Intrinsics.checkNotNullParameter(sleepData, "sleepData");
            Intrinsics.checkNotNullParameter(sleepHistoryData, "sleepHistoryData");
            Intrinsics.checkNotNullParameter(standData, "standData");
            Intrinsics.checkNotNullParameter(powerData, "powerData");
            Intrinsics.checkNotNullParameter(stressData, "stressData");
            Intrinsics.checkNotNullParameter(wristData, "wristData");
            Intrinsics.checkNotNullParameter(speedCalibrationData, "speedCalibrationData");
            Intrinsics.checkNotNullParameter(fitnessIndexData, "fitnessIndexData");
            Intrinsics.checkNotNullParameter(exerciseData, "exerciseData");
            Intrinsics.checkNotNullParameter(sessionData, "sessionData");
            Intrinsics.checkNotNullParameter(locationData, "locationData");
            Intrinsics.checkNotNullParameter(sessions, "sessions");
            return new FitnessData(r23, j, goals, fitnessConfig, activityData, heartrateData, restingHeartrateData, sleepData, sleepHistoryData, standData, powerData, stressData, wristData, speedCalibrationData, fitnessIndexData, exerciseData, sessionData, locationData, sessions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FitnessData)) {
                return false;
            }
            FitnessData fitnessData = (FitnessData) obj;
            if (this.version == fitnessData.version && this.startOfDay == fitnessData.startOfDay && Intrinsics.areEqual(this.goals, fitnessData.goals) && Intrinsics.areEqual(this.profile, fitnessData.profile) && Intrinsics.areEqual(this.activityData, fitnessData.activityData) && Intrinsics.areEqual(this.heartrateData, fitnessData.heartrateData) && Intrinsics.areEqual(this.restingHeartrateData, fitnessData.restingHeartrateData) && Intrinsics.areEqual(this.sleepData, fitnessData.sleepData) && Intrinsics.areEqual(this.sleepHistoryData, fitnessData.sleepHistoryData) && Intrinsics.areEqual(this.standData, fitnessData.standData) && Intrinsics.areEqual(this.powerData, fitnessData.powerData) && Intrinsics.areEqual(this.stressData, fitnessData.stressData) && Intrinsics.areEqual(this.wristData, fitnessData.wristData) && Intrinsics.areEqual(this.speedCalibrationData, fitnessData.speedCalibrationData) && Intrinsics.areEqual(this.fitnessIndexData, fitnessData.fitnessIndexData) && Intrinsics.areEqual(this.exerciseData, fitnessData.exerciseData) && Intrinsics.areEqual(this.sessionData, fitnessData.sessionData) && Intrinsics.areEqual(this.locationData, fitnessData.locationData) && Intrinsics.areEqual(this.sessions, fitnessData.sessions)) {
                return true;
            }
            return false;
        }

        public final List<ActivityEntry> getActivityData() {
            return this.activityData;
        }

        public final List<ExerciseEntry> getExerciseData() {
            return this.exerciseData;
        }

        public final List<FitnessIndexEntry> getFitnessIndexData() {
            return this.fitnessIndexData;
        }

        public final Goals getGoals() {
            return this.goals;
        }

        public final List<HeartrateEntry> getHeartrateData() {
            return this.heartrateData;
        }

        public final List<LocationEntry> getLocationData() {
            return this.locationData;
        }

        public final List<PowerEntry> getPowerData() {
            return this.powerData;
        }

        public final FitnessConfig getProfile() {
            return this.profile;
        }

        public final List<RestingHeartrateEntry> getRestingHeartrateData() {
            return this.restingHeartrateData;
        }

        public final List<SessionEntry> getSessionData() {
            return this.sessionData;
        }

        public final List<Session> getSessions() {
            return this.sessions;
        }

        public final List<SleepEntry> getSleepData() {
            return this.sleepData;
        }

        public final List<SleepHistoryEntry> getSleepHistoryData() {
            return this.sleepHistoryData;
        }

        public final List<SpeedCalibrationEntry> getSpeedCalibrationData() {
            return this.speedCalibrationData;
        }

        public final List<StandEntry> getStandData() {
            return this.standData;
        }

        public final long getStartOfDay() {
            return this.startOfDay;
        }

        public final List<StressEntry> getStressData() {
            return this.stressData;
        }

        public final int getVersion() {
            return this.version;
        }

        public final List<WristEntry> getWristData() {
            return this.wristData;
        }

        public int hashCode() {
            int hashCode;
            int m = Scale$$ExternalSyntheticOutline0.m(this.startOfDay, Integer.hashCode(this.version) * 31, 31);
            Goals goals = this.goals;
            int r2 = 0;
            if (goals == null) {
                hashCode = 0;
            } else {
                hashCode = goals.hashCode();
            }
            int r0 = (m + hashCode) * 31;
            FitnessConfig fitnessConfig = this.profile;
            if (fitnessConfig != null) {
                r2 = fitnessConfig.hashCode();
            }
            return this.sessions.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.locationData, VectorGroup$$ExternalSyntheticOutline0.m(this.sessionData, VectorGroup$$ExternalSyntheticOutline0.m(this.exerciseData, VectorGroup$$ExternalSyntheticOutline0.m(this.fitnessIndexData, VectorGroup$$ExternalSyntheticOutline0.m(this.speedCalibrationData, VectorGroup$$ExternalSyntheticOutline0.m(this.wristData, VectorGroup$$ExternalSyntheticOutline0.m(this.stressData, VectorGroup$$ExternalSyntheticOutline0.m(this.powerData, VectorGroup$$ExternalSyntheticOutline0.m(this.standData, VectorGroup$$ExternalSyntheticOutline0.m(this.sleepHistoryData, VectorGroup$$ExternalSyntheticOutline0.m(this.sleepData, VectorGroup$$ExternalSyntheticOutline0.m(this.restingHeartrateData, VectorGroup$$ExternalSyntheticOutline0.m(this.heartrateData, VectorGroup$$ExternalSyntheticOutline0.m(this.activityData, (r0 + r2) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FitnessData(version=");
            sb.append(this.version);
            sb.append(", startOfDay=");
            sb.append(this.startOfDay);
            sb.append(", goals=");
            sb.append(this.goals);
            sb.append(", profile=");
            sb.append(this.profile);
            sb.append(", activityData=");
            sb.append(this.activityData);
            sb.append(", heartrateData=");
            sb.append(this.heartrateData);
            sb.append(", restingHeartrateData=");
            sb.append(this.restingHeartrateData);
            sb.append(", sleepData=");
            sb.append(this.sleepData);
            sb.append(", sleepHistoryData=");
            sb.append(this.sleepHistoryData);
            sb.append(", standData=");
            sb.append(this.standData);
            sb.append(", powerData=");
            sb.append(this.powerData);
            sb.append(", stressData=");
            sb.append(this.stressData);
            sb.append(", wristData=");
            sb.append(this.wristData);
            sb.append(", speedCalibrationData=");
            sb.append(this.speedCalibrationData);
            sb.append(", fitnessIndexData=");
            sb.append(this.fitnessIndexData);
            sb.append(", exerciseData=");
            sb.append(this.exerciseData);
            sb.append(", sessionData=");
            sb.append(this.sessionData);
            sb.append(", locationData=");
            sb.append(this.locationData);
            sb.append(", sessions=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.sessions, ')');
        }

        public FitnessData(int r17, long j, Goals goals, FitnessConfig fitnessConfig, List<ActivityEntry> activityData, List<HeartrateEntry> heartrateData, List<RestingHeartrateEntry> restingHeartrateData, List<SleepEntry> sleepData, List<SleepHistoryEntry> sleepHistoryData, List<StandEntry> standData, List<PowerEntry> powerData, List<StressEntry> stressData, List<WristEntry> wristData, List<SpeedCalibrationEntry> speedCalibrationData, List<FitnessIndexEntry> fitnessIndexData, List<ExerciseEntry> exerciseData, List<SessionEntry> sessionData, List<LocationEntry> locationData, List<Session> sessions) {
            Intrinsics.checkNotNullParameter(activityData, "activityData");
            Intrinsics.checkNotNullParameter(heartrateData, "heartrateData");
            Intrinsics.checkNotNullParameter(restingHeartrateData, "restingHeartrateData");
            Intrinsics.checkNotNullParameter(sleepData, "sleepData");
            Intrinsics.checkNotNullParameter(sleepHistoryData, "sleepHistoryData");
            Intrinsics.checkNotNullParameter(standData, "standData");
            Intrinsics.checkNotNullParameter(powerData, "powerData");
            Intrinsics.checkNotNullParameter(stressData, "stressData");
            Intrinsics.checkNotNullParameter(wristData, "wristData");
            Intrinsics.checkNotNullParameter(speedCalibrationData, "speedCalibrationData");
            Intrinsics.checkNotNullParameter(fitnessIndexData, "fitnessIndexData");
            Intrinsics.checkNotNullParameter(exerciseData, "exerciseData");
            Intrinsics.checkNotNullParameter(sessionData, "sessionData");
            Intrinsics.checkNotNullParameter(locationData, "locationData");
            Intrinsics.checkNotNullParameter(sessions, "sessions");
            this.version = r17;
            this.startOfDay = j;
            this.goals = goals;
            this.profile = fitnessConfig;
            this.activityData = activityData;
            this.heartrateData = heartrateData;
            this.restingHeartrateData = restingHeartrateData;
            this.sleepData = sleepData;
            this.sleepHistoryData = sleepHistoryData;
            this.standData = standData;
            this.powerData = powerData;
            this.stressData = stressData;
            this.wristData = wristData;
            this.speedCalibrationData = speedCalibrationData;
            this.fitnessIndexData = fitnessIndexData;
            this.exerciseData = exerciseData;
            this.sessionData = sessionData;
            this.locationData = locationData;
            this.sessions = sessions;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ FitnessData(int r24, long r25, com.animaconnected.watch.fitness.FitnessDatabaseParser.Goals r27, com.animaconnected.watch.fitness.FitnessConfig r28, java.util.List r29, java.util.List r30, java.util.List r31, java.util.List r32, java.util.List r33, java.util.List r34, java.util.List r35, java.util.List r36, java.util.List r37, java.util.List r38, java.util.List r39, java.util.List r40, java.util.List r41, java.util.List r42, java.util.List r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
            /*
                r23 = this;
                r0 = r44
                r1 = r0 & 8
                if (r1 == 0) goto L9
                r1 = 0
                r7 = r1
                goto Lb
            L9:
                r7 = r28
            Lb:
                r1 = r0 & 16
                kotlin.collections.EmptyList r2 = kotlin.collections.EmptyList.INSTANCE
                if (r1 == 0) goto L13
                r8 = r2
                goto L15
            L13:
                r8 = r29
            L15:
                r1 = r0 & 32
                if (r1 == 0) goto L1b
                r9 = r2
                goto L1d
            L1b:
                r9 = r30
            L1d:
                r1 = r0 & 64
                if (r1 == 0) goto L23
                r10 = r2
                goto L25
            L23:
                r10 = r31
            L25:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L2b
                r11 = r2
                goto L2d
            L2b:
                r11 = r32
            L2d:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L33
                r12 = r2
                goto L35
            L33:
                r12 = r33
            L35:
                r1 = r0 & 512(0x200, float:7.17E-43)
                if (r1 == 0) goto L3b
                r13 = r2
                goto L3d
            L3b:
                r13 = r34
            L3d:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L43
                r14 = r2
                goto L45
            L43:
                r14 = r35
            L45:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L4b
                r15 = r2
                goto L4d
            L4b:
                r15 = r36
            L4d:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L54
                r16 = r2
                goto L56
            L54:
                r16 = r37
            L56:
                r1 = r0 & 8192(0x2000, float:1.148E-41)
                if (r1 == 0) goto L5d
                r17 = r2
                goto L5f
            L5d:
                r17 = r38
            L5f:
                r1 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r1 == 0) goto L66
                r18 = r2
                goto L68
            L66:
                r18 = r39
            L68:
                r1 = 32768(0x8000, float:4.5918E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L71
                r19 = r2
                goto L73
            L71:
                r19 = r40
            L73:
                r1 = 65536(0x10000, float:9.1835E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L7b
                r20 = r2
                goto L7d
            L7b:
                r20 = r41
            L7d:
                r1 = 131072(0x20000, float:1.83671E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L85
                r21 = r2
                goto L87
            L85:
                r21 = r42
            L87:
                r1 = 262144(0x40000, float:3.67342E-40)
                r0 = r0 & r1
                if (r0 == 0) goto L8f
                r22 = r2
                goto L91
            L8f:
                r22 = r43
            L91:
                r2 = r23
                r3 = r24
                r4 = r25
                r6 = r27
                r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.FitnessDatabaseParser.FitnessData.<init>(int, long, com.animaconnected.watch.fitness.FitnessDatabaseParser$Goals, com.animaconnected.watch.fitness.FitnessConfig, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    /* compiled from: FitnessDatabaseParser.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Goals {
        public static final Companion Companion = new Companion(null);
        private final int exercise;
        private final String historyDeviceId;
        private final int stand;
        private final int steps;
        private final long timestamp;

        /* compiled from: FitnessDatabaseParser.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Goals> serializer() {
                return FitnessDatabaseParser$Goals$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Goals(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, int r6, int r7, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, str, j, r5, r6, r7, serializationConstructorMarker);
        }

        /* renamed from: copy-_w5UW7A$default, reason: not valid java name */
        public static /* synthetic */ Goals m1266copy_w5UW7A$default(Goals goals, String str, long j, int r8, int r9, int r10, int r11, Object obj) {
            if ((r11 & 1) != 0) {
                str = goals.historyDeviceId;
            }
            if ((r11 & 2) != 0) {
                j = goals.timestamp;
            }
            long j2 = j;
            if ((r11 & 4) != 0) {
                r8 = goals.steps;
            }
            int r12 = r8;
            if ((r11 & 8) != 0) {
                r9 = goals.stand;
            }
            int r2 = r9;
            if ((r11 & 16) != 0) {
                r10 = goals.exercise;
            }
            return goals.m1269copy_w5UW7A(str, j2, r12, r2, r10);
        }

        public static final /* synthetic */ void write$Self$watch_release(Goals goals, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(goals.historyDeviceId));
            compositeEncoder.encodeLongElement(serialDescriptor, 1, goals.timestamp);
            compositeEncoder.encodeIntElement(2, goals.steps, serialDescriptor);
            compositeEncoder.encodeIntElement(3, goals.stand, serialDescriptor);
            compositeEncoder.encodeIntElement(4, goals.exercise, serialDescriptor);
        }

        /* renamed from: component1-V9ZILtA, reason: not valid java name */
        public final String m1268component1V9ZILtA() {
            return this.historyDeviceId;
        }

        public final long component2() {
            return this.timestamp;
        }

        public final int component3() {
            return this.steps;
        }

        public final int component4() {
            return this.stand;
        }

        public final int component5() {
            return this.exercise;
        }

        /* renamed from: copy-_w5UW7A, reason: not valid java name */
        public final Goals m1269copy_w5UW7A(String historyDeviceId, long j, int r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new Goals(historyDeviceId, j, r13, r14, r15, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Goals)) {
                return false;
            }
            Goals goals = (Goals) obj;
            if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, goals.historyDeviceId) && this.timestamp == goals.timestamp && this.steps == goals.steps && this.stand == goals.stand && this.exercise == goals.exercise) {
                return true;
            }
            return false;
        }

        public final int getExercise() {
            return this.exercise;
        }

        /* renamed from: getHistoryDeviceId-V9ZILtA, reason: not valid java name */
        public final String m1270getHistoryDeviceIdV9ZILtA() {
            return this.historyDeviceId;
        }

        public final int getStand() {
            return this.stand;
        }

        public final int getSteps() {
            return this.steps;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Integer.hashCode(this.exercise) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.stand, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Goals(historyDeviceId=");
            ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
            sb.append(this.timestamp);
            sb.append(", steps=");
            sb.append(this.steps);
            sb.append(", stand=");
            sb.append(this.stand);
            sb.append(", exercise=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.exercise, ')');
        }

        public /* synthetic */ Goals(String str, long j, int r4, int r5, int r6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, r4, r5, r6);
        }

        private Goals(int r2, String str, long j, int r6, int r7, int r8, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (r2 & 31)) {
                zzac.throwMissingFieldException(r2, 31, FitnessDatabaseParser$Goals$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.historyDeviceId = str;
            this.timestamp = j;
            this.steps = r6;
            this.stand = r7;
            this.exercise = r8;
        }

        private Goals(String historyDeviceId, long j, int r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            this.historyDeviceId = historyDeviceId;
            this.timestamp = j;
            this.steps = r5;
            this.stand = r6;
            this.exercise = r7;
        }

        @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
        /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
        public static /* synthetic */ void m1267getHistoryDeviceIdV9ZILtA$annotations() {
        }
    }

    /* compiled from: FitnessDatabaseParser.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Session {
        private final long activeTimeMs;
        private final int calories;
        private final List<Elevation> elevation;
        private final int elevationGain;
        private final long endTs;
        private final Float fitnessIndex;
        private final Boolean gps;
        private final String historyDeviceId;
        private final List<Interval> intervals;
        private final Long sessionId;
        private final long startTs;
        private final Integer status;
        private final int steps;
        private final double totalDistanceMeter;
        private final long totalTimeMs;
        private final Integer type;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(Elevation$$serializer.INSTANCE), new ArrayListSerializer(Interval$$serializer.INSTANCE), null};

        /* compiled from: FitnessDatabaseParser.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Session> serializer() {
                return FitnessDatabaseParser$Session$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Session(int r1, @JsonNames(names = {"identifier"}) String str, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r16, int r17, int r18, Float f, List list, List list2, Integer num2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, str, l, num, bool, j, j2, j3, j4, d, r16, r17, r18, f, (List<Elevation>) list, (List<Interval>) list2, num2, serializationConstructorMarker);
        }

        /* renamed from: copy-PFZjV1k$default, reason: not valid java name */
        public static /* synthetic */ Session m1271copyPFZjV1k$default(Session session, String str, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r32, int r33, int r34, Float f, List list, List list2, Integer num2, int r39, Object obj) {
            return session.m1274copyPFZjV1k((r39 & 1) != 0 ? session.historyDeviceId : str, (r39 & 2) != 0 ? session.sessionId : l, (r39 & 4) != 0 ? session.type : num, (r39 & 8) != 0 ? session.gps : bool, (r39 & 16) != 0 ? session.startTs : j, (r39 & 32) != 0 ? session.endTs : j2, (r39 & 64) != 0 ? session.totalTimeMs : j3, (r39 & 128) != 0 ? session.activeTimeMs : j4, (r39 & 256) != 0 ? session.totalDistanceMeter : d, (r39 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? session.steps : r32, (r39 & 1024) != 0 ? session.calories : r33, (r39 & 2048) != 0 ? session.elevationGain : r34, (r39 & 4096) != 0 ? session.fitnessIndex : f, (r39 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? session.elevation : list, (r39 & DfuBaseService.ERROR_CONNECTION_MASK) != 0 ? session.intervals : list2, (r39 & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0 ? session.status : num2);
        }

        public static final /* synthetic */ void write$Self$watch_release(Session session, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            boolean z7 = false;
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(session.historyDeviceId));
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || session.sessionId != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, session.sessionId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || session.type != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, session.type);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || session.gps != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, session.gps);
            }
            compositeEncoder.encodeLongElement(serialDescriptor, 4, session.startTs);
            compositeEncoder.encodeLongElement(serialDescriptor, 5, session.endTs);
            compositeEncoder.encodeLongElement(serialDescriptor, 6, session.totalTimeMs);
            compositeEncoder.encodeLongElement(serialDescriptor, 7, session.activeTimeMs);
            compositeEncoder.encodeDoubleElement(serialDescriptor, 8, session.totalDistanceMeter);
            compositeEncoder.encodeIntElement(9, session.steps, serialDescriptor);
            compositeEncoder.encodeIntElement(10, session.calories, serialDescriptor);
            compositeEncoder.encodeIntElement(11, session.elevationGain, serialDescriptor);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || session.fitnessIndex != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, FloatSerializer.INSTANCE, session.fitnessIndex);
            }
            boolean shouldEncodeElementDefault = compositeEncoder.shouldEncodeElementDefault(serialDescriptor);
            EmptyList emptyList = EmptyList.INSTANCE;
            if (shouldEncodeElementDefault || !Intrinsics.areEqual(session.elevation, emptyList)) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 13, kSerializerArr[13], session.elevation);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(session.intervals, emptyList)) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 14, kSerializerArr[14], session.intervals);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || session.status != null) {
                z7 = true;
            }
            if (z7) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 15, IntSerializer.INSTANCE, session.status);
            }
        }

        /* renamed from: component1-V9ZILtA, reason: not valid java name */
        public final String m1273component1V9ZILtA() {
            return this.historyDeviceId;
        }

        public final int component10() {
            return this.steps;
        }

        public final int component11() {
            return this.calories;
        }

        public final int component12() {
            return this.elevationGain;
        }

        public final Float component13() {
            return this.fitnessIndex;
        }

        public final List<Elevation> component14() {
            return this.elevation;
        }

        public final List<Interval> component15() {
            return this.intervals;
        }

        public final Integer component16() {
            return this.status;
        }

        public final Long component2() {
            return this.sessionId;
        }

        public final Integer component3() {
            return this.type;
        }

        public final Boolean component4() {
            return this.gps;
        }

        public final long component5() {
            return this.startTs;
        }

        public final long component6() {
            return this.endTs;
        }

        public final long component7() {
            return this.totalTimeMs;
        }

        public final long component8() {
            return this.activeTimeMs;
        }

        public final double component9() {
            return this.totalDistanceMeter;
        }

        /* renamed from: copy-PFZjV1k, reason: not valid java name */
        public final Session m1274copyPFZjV1k(String historyDeviceId, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r40, int r41, int r42, Float f, List<Elevation> elevation, List<Interval> intervals, Integer num2) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            Intrinsics.checkNotNullParameter(elevation, "elevation");
            Intrinsics.checkNotNullParameter(intervals, "intervals");
            return new Session(historyDeviceId, l, num, bool, j, j2, j3, j4, d, r40, r41, r42, f, elevation, intervals, num2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return false;
            }
            Session session = (Session) obj;
            if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, session.historyDeviceId) && Intrinsics.areEqual(this.sessionId, session.sessionId) && Intrinsics.areEqual(this.type, session.type) && Intrinsics.areEqual(this.gps, session.gps) && this.startTs == session.startTs && this.endTs == session.endTs && this.totalTimeMs == session.totalTimeMs && this.activeTimeMs == session.activeTimeMs && Double.compare(this.totalDistanceMeter, session.totalDistanceMeter) == 0 && this.steps == session.steps && this.calories == session.calories && this.elevationGain == session.elevationGain && Intrinsics.areEqual(this.fitnessIndex, session.fitnessIndex) && Intrinsics.areEqual(this.elevation, session.elevation) && Intrinsics.areEqual(this.intervals, session.intervals) && Intrinsics.areEqual(this.status, session.status)) {
                return true;
            }
            return false;
        }

        public final long getActiveTimeMs() {
            return this.activeTimeMs;
        }

        public final int getCalories() {
            return this.calories;
        }

        public final List<Elevation> getElevation() {
            return this.elevation;
        }

        public final int getElevationGain() {
            return this.elevationGain;
        }

        public final long getEndTs() {
            return this.endTs;
        }

        public final Float getFitnessIndex() {
            return this.fitnessIndex;
        }

        public final Boolean getGps() {
            return this.gps;
        }

        /* renamed from: getHistoryDeviceId-V9ZILtA, reason: not valid java name */
        public final String m1275getHistoryDeviceIdV9ZILtA() {
            return this.historyDeviceId;
        }

        public final List<Interval> getIntervals() {
            return this.intervals;
        }

        public final Long getSessionId() {
            return this.sessionId;
        }

        public final long getStartTs() {
            return this.startTs;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final int getSteps() {
            return this.steps;
        }

        public final double getTotalDistanceMeter() {
            return this.totalDistanceMeter;
        }

        public final long getTotalTimeMs() {
            return this.totalTimeMs;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int m1560hashCodeimpl = HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31;
            Long l = this.sessionId;
            int r2 = 0;
            if (l == null) {
                hashCode = 0;
            } else {
                hashCode = l.hashCode();
            }
            int r0 = (m1560hashCodeimpl + hashCode) * 31;
            Integer num = this.type;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int r02 = (r0 + hashCode2) * 31;
            Boolean bool = this.gps;
            if (bool == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = bool.hashCode();
            }
            int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.elevationGain, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.calories, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.steps, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.totalDistanceMeter, Scale$$ExternalSyntheticOutline0.m(this.activeTimeMs, Scale$$ExternalSyntheticOutline0.m(this.totalTimeMs, Scale$$ExternalSyntheticOutline0.m(this.endTs, Scale$$ExternalSyntheticOutline0.m(this.startTs, (r02 + hashCode3) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
            Float f = this.fitnessIndex;
            if (f == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = f.hashCode();
            }
            int m2 = VectorGroup$$ExternalSyntheticOutline0.m(this.intervals, VectorGroup$$ExternalSyntheticOutline0.m(this.elevation, (m + hashCode4) * 31, 31), 31);
            Integer num2 = this.status;
            if (num2 != null) {
                r2 = num2.hashCode();
            }
            return m2 + r2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Session(historyDeviceId=");
            ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", sessionId=");
            sb.append(this.sessionId);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", gps=");
            sb.append(this.gps);
            sb.append(", startTs=");
            sb.append(this.startTs);
            sb.append(", endTs=");
            sb.append(this.endTs);
            sb.append(", totalTimeMs=");
            sb.append(this.totalTimeMs);
            sb.append(", activeTimeMs=");
            sb.append(this.activeTimeMs);
            sb.append(", totalDistanceMeter=");
            sb.append(this.totalDistanceMeter);
            sb.append(", steps=");
            sb.append(this.steps);
            sb.append(", calories=");
            sb.append(this.calories);
            sb.append(", elevationGain=");
            sb.append(this.elevationGain);
            sb.append(", fitnessIndex=");
            sb.append(this.fitnessIndex);
            sb.append(", elevation=");
            sb.append(this.elevation);
            sb.append(", intervals=");
            sb.append(this.intervals);
            sb.append(", status=");
            return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.status, ')');
        }

        public /* synthetic */ Session(String str, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r15, int r16, int r17, Float f, List list, List list2, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, l, num, bool, j, j2, j3, j4, d, r15, r16, r17, f, list, list2, num2);
        }

        private Session(int r7, String str, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r22, int r23, int r24, Float f, List<Elevation> list, List<Interval> list2, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
            if (4081 != (r7 & 4081)) {
                zzac.throwMissingFieldException(r7, 4081, FitnessDatabaseParser$Session$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.historyDeviceId = str;
            if ((r7 & 2) == 0) {
                this.sessionId = null;
            } else {
                this.sessionId = l;
            }
            if ((r7 & 4) == 0) {
                this.type = null;
            } else {
                this.type = num;
            }
            if ((r7 & 8) == 0) {
                this.gps = null;
            } else {
                this.gps = bool;
            }
            this.startTs = j;
            this.endTs = j2;
            this.totalTimeMs = j3;
            this.activeTimeMs = j4;
            this.totalDistanceMeter = d;
            this.steps = r22;
            this.calories = r23;
            this.elevationGain = r24;
            if ((r7 & 4096) == 0) {
                this.fitnessIndex = null;
            } else {
                this.fitnessIndex = f;
            }
            int r2 = r7 & DfuBaseService.ERROR_REMOTE_MASK;
            EmptyList emptyList = EmptyList.INSTANCE;
            if (r2 == 0) {
                this.elevation = emptyList;
            } else {
                this.elevation = list;
            }
            if ((r7 & DfuBaseService.ERROR_CONNECTION_MASK) == 0) {
                this.intervals = emptyList;
            } else {
                this.intervals = list2;
            }
            if ((r7 & DfuBaseService.ERROR_CONNECTION_STATE_MASK) == 0) {
                this.status = null;
            } else {
                this.status = num2;
            }
        }

        private Session(String historyDeviceId, Long l, Integer num, Boolean bool, long j, long j2, long j3, long j4, double d, int r21, int r22, int r23, Float f, List<Elevation> elevation, List<Interval> intervals, Integer num2) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            Intrinsics.checkNotNullParameter(elevation, "elevation");
            Intrinsics.checkNotNullParameter(intervals, "intervals");
            this.historyDeviceId = historyDeviceId;
            this.sessionId = l;
            this.type = num;
            this.gps = bool;
            this.startTs = j;
            this.endTs = j2;
            this.totalTimeMs = j3;
            this.activeTimeMs = j4;
            this.totalDistanceMeter = d;
            this.steps = r21;
            this.calories = r22;
            this.elevationGain = r23;
            this.fitnessIndex = f;
            this.elevation = elevation;
            this.intervals = intervals;
            this.status = num2;
        }

        @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
        /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
        public static /* synthetic */ void m1272getHistoryDeviceIdV9ZILtA$annotations() {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Session(java.lang.String r27, java.lang.Long r28, java.lang.Integer r29, java.lang.Boolean r30, long r31, long r33, long r35, long r37, double r39, int r41, int r42, int r43, java.lang.Float r44, java.util.List r45, java.util.List r46, java.lang.Integer r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
            /*
                r26 = this;
                r0 = r48
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L9
                r5 = r2
                goto Lb
            L9:
                r5 = r28
            Lb:
                r1 = r0 & 4
                if (r1 == 0) goto L11
                r6 = r2
                goto L13
            L11:
                r6 = r29
            L13:
                r1 = r0 & 8
                if (r1 == 0) goto L19
                r7 = r2
                goto L1b
            L19:
                r7 = r30
            L1b:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L22
                r21 = r2
                goto L24
            L22:
                r21 = r44
            L24:
                r1 = r0 & 8192(0x2000, float:1.148E-41)
                kotlin.collections.EmptyList r3 = kotlin.collections.EmptyList.INSTANCE
                if (r1 == 0) goto L2d
                r22 = r3
                goto L2f
            L2d:
                r22 = r45
            L2f:
                r1 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r1 == 0) goto L36
                r23 = r3
                goto L38
            L36:
                r23 = r46
            L38:
                r1 = 32768(0x8000, float:4.5918E-41)
                r0 = r0 & r1
                if (r0 == 0) goto L41
                r24 = r2
                goto L43
            L41:
                r24 = r47
            L43:
                r25 = 0
                r3 = r26
                r4 = r27
                r8 = r31
                r10 = r33
                r12 = r35
                r14 = r37
                r16 = r39
                r18 = r41
                r19 = r42
                r20 = r43
                r3.<init>(r4, r5, r6, r7, r8, r10, r12, r14, r16, r18, r19, r20, r21, r22, r23, r24, r25)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.FitnessDatabaseParser.Session.<init>(java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Boolean, long, long, long, long, double, int, int, int, java.lang.Float, java.util.List, java.util.List, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    private FitnessDatabaseParser() {
    }

    private final List<SleepHistoryEntry> exportSleepHistoryData(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        long m1505getDurationUwyO8pc = timePeriod.m1505getDurationUwyO8pc();
        int r2 = Duration.$r8$clinit;
        if (Duration.m1672compareToLRDsOJo(m1505getDurationUwyO8pc, DurationKt.toDuration(1, DurationUnit.DAYS)) > 0) {
            return FitnessDatabaseExtensionsKt.getSleepHistoryDataEntries(fitnessQueries, timePeriod).executeAsList();
        }
        return FitnessDatabaseExtensionsKt.getSleepHistoryDataEndInclusiveEntries(fitnessQueries, timePeriod).executeAsList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDeletedSessions(FitnessQueries fitnessQueries, FitnessData fitnessData) {
        long j;
        boolean z;
        List<Session> sessions = fitnessData.getSessions();
        ArrayList<Session> arrayList = new ArrayList();
        for (Object obj : sessions) {
            if (SessionStatus.Companion.fromId(((Session) obj).getStatus()) == SessionStatus.Deleted) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        for (Session session : arrayList) {
            FitnessDatabaseParser fitnessDatabaseParser = INSTANCE;
            String m1275getHistoryDeviceIdV9ZILtA = session.m1275getHistoryDeviceIdV9ZILtA();
            Long sessionId = session.getSessionId();
            if (sessionId != null) {
                j = sessionId.longValue();
            } else {
                j = -1;
            }
            fitnessDatabaseParser.m1265removeSessionDataAjOicPU(fitnessQueries, m1275getHistoryDeviceIdV9ZILtA, j, session.getStartTs(), session.getEndTs());
        }
    }

    /* renamed from: removeSessionData-AjOicPU, reason: not valid java name */
    private final void m1265removeSessionDataAjOicPU(FitnessQueries fitnessQueries, final String str, final long j, final long j2, final long j3) {
        fitnessQueries.m1285deleteElevationcu7zPM(str, j2);
        fitnessQueries.m1287deleteLocationsOZHprlw(str, j2, j3);
        fitnessQueries.m1286deleteIntervalcu7zPM(str, j2);
        fitnessQueries.m1288deleteSessioncu7zPM(str, j2);
        fitnessQueries.m1289deleteSessionData4i7cvns(str, j2, j3, j);
        LogKt.debug$default((Object) fitnessQueries, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$removeSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder("Removing session (historyDeviceId=");
                ActivityEntry$$ExternalSyntheticOutline0.m(str, sb, ", startTs=");
                sb.append(j2);
                sb.append(", endTs=");
                sb.append(j3);
                sb.append(", sessionId=");
                return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, j, ')');
            }
        }, 7, (Object) null);
    }

    public final String exportToJson(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Json.Default r0 = Json.Default;
        FitnessData fitnessData = toFitnessData(fitnessQueries, timePeriod);
        r0.getClass();
        return r0.encodeToString(FitnessData.Companion.serializer(), fitnessData);
    }

    public final void importFitnessData(final FitnessQueries fitnessQueries, final FitnessData data) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        fitnessQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$importFitnessData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                FitnessDatabaseParser.Goals goals = FitnessDatabaseParser.FitnessData.this.getGoals();
                if (goals != null) {
                    fitnessQueries.m1339insertGoalAjOicPU(Long.valueOf(goals.getTimestamp()), goals.m1270getHistoryDeviceIdV9ZILtA(), goals.getSteps(), goals.getStand(), goals.getExercise());
                }
                FitnessConfig profile = FitnessDatabaseParser.FitnessData.this.getProfile();
                if (profile != null) {
                    FitnessQueries fitnessQueries2 = fitnessQueries;
                    Long timestamp = profile.getTimestamp();
                    Integer height = profile.getHeight();
                    Integer weight = profile.getWeight();
                    Long dateOfBirthTs = profile.getDateOfBirthTs();
                    Integer gender = profile.getGender();
                    Integer measurement = profile.getMeasurement();
                    Integer temperature = profile.getTemperature();
                    Bedtime bedtime = profile.getBedtime();
                    Integer valueOf = bedtime != null ? Integer.valueOf(bedtime.getHour()) : null;
                    Bedtime bedtime2 = profile.getBedtime();
                    fitnessQueries2.insertProfile(timestamp, height, weight, dateOfBirthTs, gender, measurement, temperature, valueOf, bedtime2 != null ? Integer.valueOf(bedtime2.getMinute()) : null);
                }
                List<ActivityEntry> activityData = FitnessDatabaseParser.FitnessData.this.getActivityData();
                FitnessQueries fitnessQueries3 = fitnessQueries;
                Iterator<T> it = activityData.iterator();
                while (it.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertActivityDataEntry(fitnessQueries3, (ActivityEntry) it.next());
                }
                List<HeartrateEntry> heartrateData = FitnessDatabaseParser.FitnessData.this.getHeartrateData();
                FitnessQueries fitnessQueries4 = fitnessQueries;
                Iterator<T> it2 = heartrateData.iterator();
                while (it2.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertHeartrateDataEntry(fitnessQueries4, (HeartrateEntry) it2.next());
                }
                List<RestingHeartrateEntry> restingHeartrateData = FitnessDatabaseParser.FitnessData.this.getRestingHeartrateData();
                FitnessQueries fitnessQueries5 = fitnessQueries;
                Iterator<T> it3 = restingHeartrateData.iterator();
                while (it3.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertRestingHeartrateDataEntry(fitnessQueries5, (RestingHeartrateEntry) it3.next());
                }
                List<SleepEntry> sleepData = FitnessDatabaseParser.FitnessData.this.getSleepData();
                FitnessQueries fitnessQueries6 = fitnessQueries;
                Iterator<T> it4 = sleepData.iterator();
                while (it4.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertSleepDataEntry(fitnessQueries6, (SleepEntry) it4.next());
                }
                List<SleepHistoryEntry> sleepHistoryData = FitnessDatabaseParser.FitnessData.this.getSleepHistoryData();
                FitnessQueries fitnessQueries7 = fitnessQueries;
                Iterator<T> it5 = sleepHistoryData.iterator();
                while (it5.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertSleepHistoryDataEntry(fitnessQueries7, (SleepHistoryEntry) it5.next());
                }
                List<StandEntry> standData = FitnessDatabaseParser.FitnessData.this.getStandData();
                FitnessQueries fitnessQueries8 = fitnessQueries;
                Iterator<T> it6 = standData.iterator();
                while (it6.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertStandDataEntry(fitnessQueries8, (StandEntry) it6.next());
                }
                List<PowerEntry> powerData = FitnessDatabaseParser.FitnessData.this.getPowerData();
                FitnessQueries fitnessQueries9 = fitnessQueries;
                Iterator<T> it7 = powerData.iterator();
                while (it7.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertPowerDataEntry(fitnessQueries9, (PowerEntry) it7.next());
                }
                List<StressEntry> stressData = FitnessDatabaseParser.FitnessData.this.getStressData();
                FitnessQueries fitnessQueries10 = fitnessQueries;
                Iterator<T> it8 = stressData.iterator();
                while (it8.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertStressDataEntry(fitnessQueries10, (StressEntry) it8.next());
                }
                List<ExerciseEntry> exerciseData = FitnessDatabaseParser.FitnessData.this.getExerciseData();
                FitnessQueries fitnessQueries11 = fitnessQueries;
                Iterator<T> it9 = exerciseData.iterator();
                while (it9.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertExerciseDataEntry(fitnessQueries11, (ExerciseEntry) it9.next());
                }
                List<WristEntry> wristData = FitnessDatabaseParser.FitnessData.this.getWristData();
                FitnessQueries fitnessQueries12 = fitnessQueries;
                Iterator<T> it10 = wristData.iterator();
                while (it10.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertWristDataEntry(fitnessQueries12, (WristEntry) it10.next());
                }
                List<SpeedCalibrationEntry> speedCalibrationData = FitnessDatabaseParser.FitnessData.this.getSpeedCalibrationData();
                FitnessQueries fitnessQueries13 = fitnessQueries;
                Iterator<T> it11 = speedCalibrationData.iterator();
                while (it11.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertSpeedCalibrationEntry(fitnessQueries13, (SpeedCalibrationEntry) it11.next());
                }
                List<FitnessIndexEntry> fitnessIndexData = FitnessDatabaseParser.FitnessData.this.getFitnessIndexData();
                FitnessQueries fitnessQueries14 = fitnessQueries;
                Iterator<T> it12 = fitnessIndexData.iterator();
                while (it12.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertRawFitnessIndexDataEntry(fitnessQueries14, (FitnessIndexEntry) it12.next());
                }
                List<SessionEntry> sessionData = FitnessDatabaseParser.FitnessData.this.getSessionData();
                FitnessQueries fitnessQueries15 = fitnessQueries;
                Iterator<T> it13 = sessionData.iterator();
                while (it13.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertSessionDataEntry(fitnessQueries15, (SessionEntry) it13.next());
                }
                List<LocationEntry> locationData = FitnessDatabaseParser.FitnessData.this.getLocationData();
                FitnessQueries fitnessQueries16 = fitnessQueries;
                Iterator<T> it14 = locationData.iterator();
                while (it14.hasNext()) {
                    FitnessDatabaseExtensionsKt.insertLocationDataEntry(fitnessQueries16, (LocationEntry) it14.next());
                }
                List<FitnessDatabaseParser.Session> sessions = FitnessDatabaseParser.FitnessData.this.getSessions();
                FitnessQueries fitnessQueries17 = fitnessQueries;
                for (FitnessDatabaseParser.Session session : sessions) {
                    String m1275getHistoryDeviceIdV9ZILtA = session.m1275getHistoryDeviceIdV9ZILtA();
                    long startTs = session.getStartTs();
                    long startTs2 = session.getStartTs();
                    long endTs = session.getEndTs();
                    long totalTimeMs = session.getTotalTimeMs();
                    long activeTimeMs = session.getActiveTimeMs();
                    double totalDistanceMeter = session.getTotalDistanceMeter();
                    int steps = session.getSteps();
                    int calories = session.getCalories();
                    int elevationGain = session.getElevationGain();
                    Integer type = session.getType();
                    int intValue = type != null ? type.intValue() : SessionType.Other.getId();
                    Boolean gps = session.getGps();
                    boolean booleanValue = gps != null ? gps.booleanValue() : false;
                    Long sessionId = session.getSessionId();
                    FitnessQueries fitnessQueries18 = fitnessQueries17;
                    fitnessQueries17.m1347insertSessionus9H8TY(m1275getHistoryDeviceIdV9ZILtA, startTs2, endTs, totalTimeMs, activeTimeMs, totalDistanceMeter, steps, calories, elevationGain, intValue, booleanValue, sessionId != null ? sessionId.longValue() : session.getStartTs(), session.getFitnessIndex(), session.getStatus());
                    int r7 = 0;
                    for (Object obj : session.getElevation()) {
                        int r17 = r7 + 1;
                        if (r7 >= 0) {
                            Elevation elevation = (Elevation) obj;
                            fitnessQueries18.m1337insertElevationEBUUAns(m1275getHistoryDeviceIdV9ZILtA, startTs, r7, elevation.getLong(), elevation.getLat(), elevation.getElevation(), elevation.getResolution());
                            r7 = r17;
                        } else {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                            throw null;
                        }
                    }
                    for (Interval interval : session.getIntervals()) {
                        fitnessQueries18.m1341insertInterval4i7cvns(m1275getHistoryDeviceIdV9ZILtA, startTs, interval.getStartTimestamp(), interval.getEndTimestamp());
                    }
                    fitnessQueries17 = fitnessQueries18;
                }
                FitnessDatabaseParser.INSTANCE.removeDeletedSessions(fitnessQueries, FitnessDatabaseParser.FitnessData.this);
            }
        });
    }

    public final void importFromJson(FitnessQueries fitnessQueries, String json) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Json DefaultConfig = DefaultJsonConfigKt.DefaultConfig(Json.Default);
        DefaultConfig.getClass();
        importFitnessData(fitnessQueries, (FitnessData) DefaultConfig.decodeFromString(FitnessData.Companion.serializer(), json));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FitnessData toFitnessData(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Goals goals = (Goals) fitnessQueries.getGoalForTimestamp(timePeriod.getEndTs(), new Function5<Long, HistoryDeviceId, Integer, Integer, Integer, Goals>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$toFitnessData$goals$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ FitnessDatabaseParser.Goals invoke(Long l, HistoryDeviceId historyDeviceId, Integer num, Integer num2, Integer num3) {
                return m1276invokeAjOicPU(l.longValue(), historyDeviceId.m1562unboximpl(), num.intValue(), num2.intValue(), num3.intValue());
            }

            /* renamed from: invoke-AjOicPU, reason: not valid java name */
            public final FitnessDatabaseParser.Goals m1276invokeAjOicPU(long j, String historyDeviceId, int r13, int r14, int r15) {
                Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
                return new FitnessDatabaseParser.Goals(historyDeviceId, j, r13, r14, r15, null);
            }
        }).executeAsOneOrNull();
        FitnessConfig executeAsOneOrNull = FitnessDatabaseExtensionsKt.getProfile(fitnessQueries, timePeriod.getEndTs()).executeAsOneOrNull();
        List<ActivityEntry> executeAsList = FitnessDatabaseExtensionsKt.getActivityDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<HeartrateEntry> executeAsList2 = FitnessDatabaseExtensionsKt.getHeartrateDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<RestingHeartrateEntry> executeAsList3 = FitnessDatabaseExtensionsKt.getRestingHeartrateDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<SleepEntry> executeAsList4 = FitnessDatabaseExtensionsKt.getSleepDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<SleepHistoryEntry> exportSleepHistoryData = exportSleepHistoryData(fitnessQueries, timePeriod);
        List<StandEntry> executeAsList5 = FitnessDatabaseExtensionsKt.getStandDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<StressEntry> executeAsList6 = FitnessDatabaseExtensionsKt.getStressDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<WristEntry> executeAsList7 = FitnessDatabaseExtensionsKt.getWristDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<SpeedCalibrationEntry> executeAsList8 = FitnessDatabaseExtensionsKt.getSpeedCalibrationEntry(fitnessQueries, timePeriod).executeAsList();
        List<FitnessIndexEntry> executeAsList9 = FitnessDatabaseExtensionsKt.getRawFitnessIndexDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<ExerciseEntry> executeAsList10 = FitnessDatabaseExtensionsKt.getExerciseDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<SessionEntry> executeAsList11 = FitnessDatabaseExtensionsKt.getSessionDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<LocationEntry> executeAsList12 = FitnessDatabaseExtensionsKt.getLocationDataEntries(fitnessQueries, timePeriod).executeAsList();
        List<PowerEntry> executeAsList13 = FitnessDatabaseExtensionsKt.getPowerDataEntries(fitnessQueries, timePeriod).executeAsList();
        Iterable<Session> executeAsList14 = fitnessQueries.getSessions(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function14<HistoryDeviceId, Long, Long, Long, Long, Double, Integer, Integer, Integer, Integer, Boolean, Long, Float, Integer, Session>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$toFitnessData$sessionsWithoutElevationAndIntervals$1
            @Override // kotlin.jvm.functions.Function14
            public /* bridge */ /* synthetic */ FitnessDatabaseParser.Session invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4, Double d, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Long l5, Float f, Integer num5) {
                return m1279invokeus9H8TY(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue(), d.doubleValue(), num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), bool.booleanValue(), l5.longValue(), f, num5);
            }

            /* renamed from: invoke-us9H8TY, reason: not valid java name */
            public final FitnessDatabaseParser.Session m1279invokeus9H8TY(String historyDeviceId, long j, long j2, long j3, long j4, double d, int r37, int r38, int r39, int r40, boolean z, long j5, Float f, Integer num) {
                Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
                return new FitnessDatabaseParser.Session(historyDeviceId, Long.valueOf(j5), Integer.valueOf(r40), Boolean.valueOf(z), j, j2, j3, j4, d, r37, r38, r39, f, (List) null, (List) null, num, 24576, (DefaultConstructorMarker) null);
            }
        }).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList14, 10));
        for (Session session : executeAsList14) {
            arrayList.add(Session.m1271copyPFZjV1k$default(session, null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0, 0, 0, null, fitnessQueries.getElevationForSession(session.getStartTs(), new Function7<HistoryDeviceId, Long, Integer, Double, Double, Double, Double, Elevation>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$toFitnessData$sessions$1$elevations$1
                @Override // kotlin.jvm.functions.Function7
                public /* bridge */ /* synthetic */ Elevation invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Double d, Double d2, Double d3, Double d4) {
                    return m1277invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), d.doubleValue(), d2.doubleValue(), d3.doubleValue(), d4.doubleValue());
                }

                /* renamed from: invoke-EBUUAns, reason: not valid java name */
                public final Elevation m1277invokeEBUUAns(String str, long j, int r14, double d, double d2, double d3, double d4) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    return new Elevation(d, d2, d3, d4);
                }
            }).executeAsList(), fitnessQueries.getIntervalsForSession(session.getStartTs(), new Function4<HistoryDeviceId, Long, Long, Long, Interval>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseParser$toFitnessData$sessions$1$intervals$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Interval invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3) {
                    return m1278invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue());
                }

                /* renamed from: invoke-4i7cvns, reason: not valid java name */
                public final Interval m1278invoke4i7cvns(String str, long j, long j2, long j3) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    return new Interval(j2, j3);
                }
            }).executeAsList(), null, 40959, null));
        }
        return new FitnessData((int) WatchDatabase.Companion.getSchema().getVersion(), timePeriod.getStartTs(), goals, executeAsOneOrNull, executeAsList, executeAsList2, executeAsList3, executeAsList4, exportSleepHistoryData, executeAsList5, executeAsList13, executeAsList6, executeAsList7, executeAsList8, executeAsList9, executeAsList10, executeAsList11, executeAsList12, arrayList);
    }
}
