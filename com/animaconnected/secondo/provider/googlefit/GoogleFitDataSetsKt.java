package com.animaconnected.secondo.provider.googlefit;

import android.text.TextUtils;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.FitnessDataUtilsKt;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.fitness.sleep.SleepSessionState;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.SleepType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.zzb;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.internal.fitness.zzfv;
import com.google.android.gms.internal.fitness.zzfw;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: GoogleFitDataSets.kt */
/* loaded from: classes3.dex */
public final class GoogleFitDataSetsKt {
    private static final String TAG = "GoogleFitApi";

    /* compiled from: GoogleFitDataSets.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[SleepType.values().length];
            try {
                r02[SleepType.AWAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[SleepType.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[SleepType.DEEP.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public static final DataSet buildCalorieDataSet(Device device, TimePeriod interval, final int r10) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        if (device != null && r10 >= 1) {
            try {
                DataType TYPE_CALORIES_EXPENDED = DataType.TYPE_CALORIES_EXPENDED;
                Intrinsics.checkNotNullExpressionValue(TYPE_CALORIES_EXPENDED, "TYPE_CALORIES_EXPENDED");
                DataSource buildDataSource = buildDataSource(TYPE_CALORIES_EXPENDED, device);
                return buildDataSet(buildDataSource, buildCaloriePoint(buildDataSource, interval.getStart(), interval.getEnd(), r10));
            } catch (Exception e) {
                LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildCalorieDataSet$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error when creating dataset for calories: "));
                    }
                }, 6, (Object) null);
                return null;
            }
        }
        LogKt.debug$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildCalorieDataSet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Missing device or the amount of calories is less than 1 when creating dataset for calories. Total calories: " + r10;
            }
        }, 6, (Object) null);
        return null;
    }

    private static final DataPoint buildCaloriePoint(DataSource dataSource, Instant instant, Instant instant2, int r9) {
        boolean z;
        if (dataSource != null) {
            DataPoint dataPoint = new DataPoint(dataSource);
            long epochMilliseconds = instant.toEpochMilliseconds();
            long epochMilliseconds2 = instant2.toEpochMilliseconds();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            dataPoint.zzc = timeUnit.toNanos(epochMilliseconds);
            dataPoint.zzb = timeUnit.toNanos(epochMilliseconds2);
            Field field = Field.FIELD_CALORIES;
            float f = r9;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            Value value = dataPoint.getValue(field);
            if (value.zza == 2) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.", z);
            value.zzb = true;
            value.zzc = f;
            Preconditions.checkState("DataPoint#build should not be called multiple times.", !false);
            return dataPoint;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    private static final DataSet buildDataSet(DataSource dataSource, DataPoint dataPoint) {
        if (dataSource != null) {
            DataSet dataSet = new DataSet(dataSource);
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            dataSet.add(dataPoint);
            Preconditions.checkState("DataSet#build() should only be called once.", !false);
            return dataSet;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    private static final DataSource buildDataSource(DataType dataType, Device device) {
        boolean z;
        zzb zzbVar;
        String str = getDeviceName() + '-' + dataType.zzt;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument("Must specify a valid stream name", z);
        String packageName = KronabyApplication.Companion.getContext().getPackageName();
        zzb zzbVar2 = zzb.zza;
        if ("com.google.android.gms".equals(packageName)) {
            zzbVar = zzb.zza;
        } else {
            zzbVar = new zzb(packageName);
        }
        return new DataSource(dataType, 0, device, zzbVar, str);
    }

    private static final Session buildFitSession(String str, Instant instant, Instant instant2, String str2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (str.length() <= 100) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Session name cannot exceed %d characters", 100);
        String str3 = getDeviceName() + '-' + instant.toEpochMilliseconds();
        if (str3 != null && TextUtils.getTrimmedLength(str3) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (str2.length() <= 1000) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Session description cannot exceed %d characters", 1000);
        long epochMilliseconds = instant.toEpochMilliseconds();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (epochMilliseconds > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState("Start time should be positive.", z4);
        long millis = timeUnit.toMillis(epochMilliseconds);
        long epochMilliseconds2 = instant2.toEpochMilliseconds();
        if (epochMilliseconds2 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState("End time should be positive.", z5);
        long millis2 = timeUnit.toMillis(epochMilliseconds2);
        int r6 = 0;
        while (true) {
            if (r6 < 124) {
                if (zzfv.zza[r6].equals(str)) {
                    break;
                }
                r6++;
            } else {
                r6 = 4;
                break;
            }
        }
        int r11 = r6;
        zzfw zza = zzfw.zza(r11, zzfw.UNKNOWN);
        if (zza.zzb() && !zza.equals(zzfw.SLEEP)) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(!z6, "Unsupported session activity type %s.", Integer.valueOf(r11));
        if (millis > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkState("Start time should be specified.", z7);
        if (millis2 == 0 || millis2 > millis) {
            z8 = true;
        }
        Preconditions.checkState("End time should be later than start time.", z8);
        if (str3 == null) {
            str3 = str + millis;
        }
        return new Session(millis, millis2, str, str3, str2, r11, null, null);
    }

    public static final DataSet buildHeartRateDataSet(Device device, final List<HeartrateEntry> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        if (device != null && !entries.isEmpty()) {
            try {
                DataType TYPE_HEART_RATE_BPM = DataType.TYPE_HEART_RATE_BPM;
                Intrinsics.checkNotNullExpressionValue(TYPE_HEART_RATE_BPM, "TYPE_HEART_RATE_BPM");
                DataSource buildDataSource = buildDataSource(TYPE_HEART_RATE_BPM, device);
                List<HeartrateEntry> list = entries;
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(buildHeartRatePoint(buildDataSource, (HeartrateEntry) it.next()));
                }
                return buildDataSet(buildDataSource, arrayList);
            } catch (Exception e) {
                LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildHeartRateDataSet$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error when creating dataset for heart rate: "));
                    }
                }, 6, (Object) null);
                return null;
            }
        }
        LogKt.debug$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildHeartRateDataSet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Missing device or too few entries when creating dataset for heart rate. Entries size: " + entries.size();
            }
        }, 6, (Object) null);
        return null;
    }

    private static final DataPoint buildHeartRatePoint(DataSource dataSource, HeartrateEntry heartrateEntry) {
        boolean z;
        if (dataSource != null) {
            DataPoint dataPoint = new DataPoint(dataSource);
            long timestamp = heartrateEntry.getTimestamp();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            dataPoint.zzb = timeUnit.toNanos(timestamp);
            Field field = Field.FIELD_BPM;
            float heartrate = heartrateEntry.getHeartrate();
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            Value value = dataPoint.getValue(field);
            if (value.zza == 2) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.", z);
            value.zzb = true;
            value.zzc = heartrate;
            Preconditions.checkState("DataPoint#build should not be called multiple times.", !false);
            return dataPoint;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    public static final DataSet buildSleepDataSet(Device device, final SleepSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (device != null && session.getState() == SleepSessionState.Completed) {
            try {
                DataType TYPE_SLEEP_SEGMENT = DataType.TYPE_SLEEP_SEGMENT;
                Intrinsics.checkNotNullExpressionValue(TYPE_SLEEP_SEGMENT, "TYPE_SLEEP_SEGMENT");
                final DataSource buildDataSource = buildDataSource(TYPE_SLEEP_SEGMENT, device);
                return buildDataSet(buildDataSource, CollectionsKt___CollectionsKt.windowed$default(session.getEntries(), 2, 0, new Function1<List<? extends SleepEntry>, DataPoint>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildSleepDataSet$dataPoints$1
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final DataPoint invoke2(List<SleepEntry> list) {
                        DataPoint buildSleepPoint;
                        Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                        SleepEntry sleepEntry = list.get(0);
                        SleepEntry sleepEntry2 = list.get(1);
                        DataSource dataSource = DataSource.this;
                        SleepType state = sleepEntry.getState();
                        Instant.Companion companion = Instant.Companion;
                        long timestamp = sleepEntry.getTimestamp();
                        companion.getClass();
                        buildSleepPoint = GoogleFitDataSetsKt.buildSleepPoint(dataSource, state, Instant.Companion.fromEpochMilliseconds(timestamp), Instant.Companion.fromEpochMilliseconds(sleepEntry2.getTimestamp()));
                        return buildSleepPoint;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ DataPoint invoke(List<? extends SleepEntry> list) {
                        return invoke2((List<SleepEntry>) list);
                    }
                }, 6));
            } catch (Exception e) {
                LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildSleepDataSet$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error when creating dataset for sleep: "));
                    }
                }, 6, (Object) null);
                return null;
            }
        }
        LogKt.debug$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildSleepDataSet$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Missing device or incomplete sleep when creating dataset. Sleep session state: " + SleepSession.this.getState();
            }
        }, 6, (Object) null);
        return null;
    }

    public static final SessionInsertRequest buildSleepInsertRequest(DataSet dataset) {
        Instant endInstant;
        Intrinsics.checkNotNullParameter(dataset, "dataset");
        Instant startInstant = getStartInstant(dataset);
        if (startInstant == null || (endInstant = getEndInstant(dataset)) == null) {
            return null;
        }
        Session buildFitSession = buildFitSession("sleep", startInstant, endInstant, GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(KronabyApplication.Companion, R.string.health_sleep_last_night_title, "getString(...)"));
        SessionInsertRequest.Builder builder = new SessionInsertRequest.Builder();
        builder.zza = buildFitSession;
        builder.addDataSet(dataset);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataPoint buildSleepPoint(DataSource dataSource, SleepType sleepType, Instant instant, Instant instant2) {
        int r7;
        boolean z;
        int r72 = WhenMappings.$EnumSwitchMapping$1[sleepType.ordinal()];
        if (r72 != 1) {
            if (r72 != 2) {
                if (r72 == 3) {
                    r7 = 5;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                r7 = 4;
            }
        } else {
            r7 = 1;
        }
        if (dataSource != null) {
            DataPoint dataPoint = new DataPoint(dataSource);
            long epochMilliseconds = instant.toEpochMilliseconds();
            long epochMilliseconds2 = instant2.toEpochMilliseconds();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            dataPoint.zzc = timeUnit.toNanos(epochMilliseconds);
            dataPoint.zzb = timeUnit.toNanos(epochMilliseconds2);
            Field field = Field.FIELD_SLEEP_SEGMENT_TYPE;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            Value value = dataPoint.getValue(field);
            if (value.zza == 1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.", z);
            value.zzb = true;
            value.zzc = Float.intBitsToFloat(r7);
            Preconditions.checkState("DataPoint#build should not be called multiple times.", !false);
            return dataPoint;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataPoint buildStepPoint(DataSource dataSource, int r7, Instant instant, Instant instant2) {
        boolean z;
        if (dataSource != null) {
            DataPoint dataPoint = new DataPoint(dataSource);
            long epochMilliseconds = instant.toEpochMilliseconds();
            long epochMilliseconds2 = instant2.toEpochMilliseconds();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            dataPoint.zzc = timeUnit.toNanos(epochMilliseconds);
            dataPoint.zzb = timeUnit.toNanos(epochMilliseconds2);
            Field field = Field.FIELD_STEPS;
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            Value value = dataPoint.getValue(field);
            if (value.zza == 1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.", z);
            value.zzb = true;
            value.zzc = Float.intBitsToFloat(r7);
            Preconditions.checkState("DataPoint#build should not be called multiple times.", !false);
            return dataPoint;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    private static final DataSet buildStepsDataSet(Device device, final List<ActivityEntry> list) {
        if (device != null && list.size() >= 2) {
            try {
                DataType TYPE_STEP_COUNT_DELTA = DataType.TYPE_STEP_COUNT_DELTA;
                Intrinsics.checkNotNullExpressionValue(TYPE_STEP_COUNT_DELTA, "TYPE_STEP_COUNT_DELTA");
                final DataSource buildDataSource = buildDataSource(TYPE_STEP_COUNT_DELTA, device);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (FitnessDataUtilsKt.getTotalSteps((ActivityEntry) next) > 0) {
                            arrayList.add(next);
                        }
                    } else {
                        return buildDataSet(buildDataSource, CollectionsKt___CollectionsKt.windowed$default(arrayList, 2, 0, new Function1<List<? extends ActivityEntry>, DataPoint>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildStepsDataSet$dataPoints$2
                            {
                                super(1);
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final DataPoint invoke2(List<ActivityEntry> list2) {
                                DataPoint buildStepPoint;
                                Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                                ActivityEntry activityEntry = list2.get(0);
                                ActivityEntry activityEntry2 = list2.get(1);
                                DataSource dataSource = DataSource.this;
                                int totalSteps = FitnessDataUtilsKt.getTotalSteps(activityEntry);
                                Instant.Companion companion = Instant.Companion;
                                long timestamp = activityEntry.getTimestamp();
                                companion.getClass();
                                buildStepPoint = GoogleFitDataSetsKt.buildStepPoint(dataSource, totalSteps, Instant.Companion.fromEpochMilliseconds(timestamp), Instant.Companion.fromEpochMilliseconds(activityEntry2.getTimestamp()));
                                return buildStepPoint;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ DataPoint invoke(List<? extends ActivityEntry> list2) {
                                return invoke2((List<ActivityEntry>) list2);
                            }
                        }, 6));
                    }
                }
            } catch (Exception e) {
                LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildStepsDataSet$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error when creating dataset for chunked steps: "));
                    }
                }, 6, (Object) null);
                return null;
            }
        } else {
            LogKt.debug$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildStepsDataSet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Missing device or too few entries when creating dataset for chunked steps. Entries size: " + list.size();
                }
            }, 6, (Object) null);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final SessionInsertRequest buildWorkoutInsertRequest(Device device, final com.animaconnected.watch.fitness.Session session) {
        Pair pair;
        Intrinsics.checkNotNullParameter(session, "session");
        Instant.Companion companion = Instant.Companion;
        long startTs = session.getStartTs();
        companion.getClass();
        final Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(startTs);
        final Instant fromEpochMilliseconds2 = Instant.Companion.fromEpochMilliseconds(session.getEndTs());
        int r2 = WhenMappings.$EnumSwitchMapping$0[session.getType().ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 == 4) {
                        pair = new Pair("other", StringsExtensionsKt.getAppString(Key.workout_type_other));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    pair = new Pair("biking", StringsExtensionsKt.getAppString(Key.workout_type_bike));
                }
            } else {
                pair = new Pair("walking", StringsExtensionsKt.getAppString(Key.workout_type_walk));
            }
        } else {
            pair = new Pair("running", StringsExtensionsKt.getAppString(Key.workout_type_run));
        }
        try {
            Session buildFitSession = buildFitSession((String) pair.first, fromEpochMilliseconds, fromEpochMilliseconds2, (String) pair.second);
            SessionInsertRequest.Builder builder = new SessionInsertRequest.Builder();
            builder.zza = buildFitSession;
            DataSet buildStepsDataSet = buildStepsDataSet(device, session.getActivityEntries());
            if (buildStepsDataSet != null) {
                builder.addDataSet(buildStepsDataSet);
            }
            return builder.build();
        } catch (Exception e) {
            LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildWorkoutInsertRequest$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Failed to create dataset for ");
                    sb.append(com.animaconnected.watch.fitness.Session.this.getType().name());
                    sb.append(" from ");
                    sb.append(fromEpochMilliseconds);
                    sb.append(" to ");
                    sb.append(fromEpochMilliseconds2);
                    sb.append(". Entries: ");
                    sb.append(com.animaconnected.watch.fitness.Session.this.getActivityEntries().size());
                    sb.append(". Error: ");
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, sb);
                }
            }, 6, (Object) null);
            return null;
        }
    }

    private static final String getDeviceName() {
        return GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(KronabyApplication.Companion, R.string.secondo_app_name, "getString(...)");
    }

    private static final Instant getEndInstant(DataSet dataSet) {
        List<DataPoint> dataPoints = dataSet.getDataPoints();
        Intrinsics.checkNotNullExpressionValue(dataPoints, "getDataPoints(...)");
        DataPoint dataPoint = (DataPoint) CollectionsKt___CollectionsKt.lastOrNull(dataPoints);
        if (dataPoint != null) {
            long convert = TimeUnit.MILLISECONDS.convert(dataPoint.zzb, TimeUnit.NANOSECONDS);
            Instant.Companion.getClass();
            return Instant.Companion.fromEpochMilliseconds(convert);
        }
        return null;
    }

    private static final Instant getStartInstant(DataSet dataSet) {
        List<DataPoint> dataPoints = dataSet.getDataPoints();
        Intrinsics.checkNotNullExpressionValue(dataPoints, "getDataPoints(...)");
        DataPoint dataPoint = (DataPoint) CollectionsKt___CollectionsKt.firstOrNull((List) dataPoints);
        if (dataPoint != null) {
            long convert = TimeUnit.MILLISECONDS.convert(dataPoint.zzc, TimeUnit.NANOSECONDS);
            Instant.Companion.getClass();
            return Instant.Companion.fromEpochMilliseconds(convert);
        }
        return null;
    }

    private static final DataSet buildDataSet(DataSource dataSource, List<DataPoint> list) {
        if (dataSource != null) {
            DataSet dataSet = new DataSet(dataSource);
            Preconditions.checkState("Builder should not be mutated after calling #build.", !false);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                dataSet.add((DataPoint) it.next());
            }
            Preconditions.checkState("DataSet#build() should only be called once.", !false);
            return dataSet;
        }
        throw new NullPointerException("DataSource should be specified");
    }

    public static final DataSet buildStepsDataSet(Device device, TimePeriod interval, final int r10) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        if (device != null && r10 >= 1) {
            try {
                DataType TYPE_STEP_COUNT_CUMULATIVE = DataType.TYPE_STEP_COUNT_CUMULATIVE;
                Intrinsics.checkNotNullExpressionValue(TYPE_STEP_COUNT_CUMULATIVE, "TYPE_STEP_COUNT_CUMULATIVE");
                DataSource buildDataSource = buildDataSource(TYPE_STEP_COUNT_CUMULATIVE, device);
                return buildDataSet(buildDataSource, buildStepPoint(buildDataSource, r10, interval.getStart(), interval.getEnd()));
            } catch (Exception e) {
                LogKt.warn$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildStepsDataSet$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error when creating dataset for total steps: "));
                    }
                }, 6, (Object) null);
                return null;
            }
        }
        LogKt.debug$default((Object) Unit.INSTANCE, "GoogleFitApi", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$buildStepsDataSet$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Missing device or the amount of steps is less than 1 when creating dataset for total steps. Steps: " + r10;
            }
        }, 6, (Object) null);
        return null;
    }
}
