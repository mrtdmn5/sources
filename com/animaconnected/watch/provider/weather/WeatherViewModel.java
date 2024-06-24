package com.animaconnected.watch.provider.weather;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.temperature.Current;
import com.animaconnected.watch.behaviour.temperature.Daily;
import com.animaconnected.watch.behaviour.temperature.Hourly;
import com.animaconnected.watch.behaviour.temperature.Temp;
import com.animaconnected.watch.behaviour.temperature.WeatherHttpClientKt;
import com.animaconnected.watch.device.StringsBackendKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: WeatherViewModel.kt */
/* loaded from: classes3.dex */
public final class WeatherViewModel {
    public static final Companion Companion = new Companion(null);
    private final MitmapBackend mitmapBackend;
    private final MutableStateFlow<TemperatureState> privateTemperatureState;
    private final MutableStateFlow<WeatherForecastApp> privateWeatherForecastApp;
    private final CommonFlow<TemperatureState> temperatureFlow;
    private final Function0<FitnessProvider.Profile.Temperature> temperatureUnit;
    private final CommonFlow<WeatherForecastApp> weatherFlowApp;
    private final HistoricalWeatherProvider weatherProvider;

    /* compiled from: WeatherViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final double toFahrenheit(double d) {
            return ((d * 9) / 5) + 32;
        }

        public final String convertTempToString(Double d, FitnessProvider.Profile.Temperature unit) {
            double fahrenheit;
            Intrinsics.checkNotNullParameter(unit, "unit");
            if (d == null) {
                return null;
            }
            if (unit == FitnessProvider.Profile.Temperature.Celsius) {
                fahrenheit = d.doubleValue();
            } else {
                fahrenheit = toFahrenheit(d.doubleValue());
            }
            return String.valueOf(MathKt__MathJVMKt.roundToInt(fahrenheit)) + (char) 176;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WeatherViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Weather {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Weather[] $VALUES;
        public static final Weather Clear_Sky = new Weather("Clear_Sky", 0);
        public static final Weather Clear_Sky_Night = new Weather("Clear_Sky_Night", 1);
        public static final Weather Few_Clouds = new Weather("Few_Clouds", 2);
        public static final Weather Few_Clouds_Night = new Weather("Few_Clouds_Night", 3);
        public static final Weather Scattered_Clouds = new Weather("Scattered_Clouds", 4);
        public static final Weather Broken_Clouds = new Weather("Broken_Clouds", 5);
        public static final Weather Shower_Rain = new Weather("Shower_Rain", 6);
        public static final Weather Rain = new Weather("Rain", 7);
        public static final Weather Thunderstorm = new Weather("Thunderstorm", 8);
        public static final Weather Snow = new Weather("Snow", 9);
        public static final Weather Mist = new Weather("Mist", 10);
        public static final Weather Unknown = new Weather("Unknown", 11);

        private static final /* synthetic */ Weather[] $values() {
            return new Weather[]{Clear_Sky, Clear_Sky_Night, Few_Clouds, Few_Clouds_Night, Scattered_Clouds, Broken_Clouds, Shower_Rain, Rain, Thunderstorm, Snow, Mist, Unknown};
        }

        static {
            Weather[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Weather(String str, int r2) {
        }

        public static EnumEntries<Weather> getEntries() {
            return $ENTRIES;
        }

        public static Weather valueOf(String str) {
            return (Weather) Enum.valueOf(Weather.class, str);
        }

        public static Weather[] values() {
            return (Weather[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WeatherViewModel(Function0<? extends FitnessProvider.Profile.Temperature> temperatureUnit) {
        Intrinsics.checkNotNullParameter(temperatureUnit, "temperatureUnit");
        this.temperatureUnit = temperatureUnit;
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(new WeatherForecastApp(null, null, isCelsius(), 3, null));
        this.privateWeatherForecastApp = MutableStateFlow;
        this.weatherFlowApp = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.weatherProvider = serviceLocator.getWeatherProvider();
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(getLatestTemperature());
        this.privateTemperatureState = MutableStateFlow2;
        this.temperatureFlow = FlowExtensionsKt.asCommonFlow(MutableStateFlow2);
        this.mitmapBackend = serviceLocator.getMitmapBackend();
    }

    private final String asWeekDay(Instant instant) {
        if (instant == null) {
            return "-";
        }
        return StringsBackendKt.format$default(ServiceLocator.INSTANCE.getStringsBackend().createDateFormatter(DateTimeFormattersKt.mediumDayNameInWeekFormat, true), instant, null, false, 6, null);
    }

    private final String formattedTemp(Double d) {
        String convertTempToString = Companion.convertTempToString(d, this.temperatureUnit.invoke());
        if (convertTempToString == null) {
            return "-";
        }
        return convertTempToString;
    }

    private final CurrentForecast getCurrentForecast() {
        CurrentForecast currentForecast;
        Double d;
        WatchAsset watchAsset;
        Object obj;
        Double d2;
        WatchAsset watchAsset2;
        Temp temp;
        Instant instant;
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimeZone.Companion.getClass();
        String str = null;
        boolean z = true;
        TimePeriod day$default = TimePeriod.Companion.day$default(companion, null, TimeZone.UTC, 1, null);
        Current current = this.weatherProvider.getCurrent();
        boolean z2 = false;
        if (current != null && (instant = current.getInstant()) != null) {
            if (instant.compareTo(day$default.getStart()) >= 0) {
                z = false;
            }
            z2 = z;
        }
        if (z2) {
            Iterator<T> it = this.weatherProvider.getDaily().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (day$default.contains(((Daily) obj).getInstant())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Daily daily = (Daily) obj;
            if (daily != null && (temp = daily.getTemp()) != null) {
                d2 = Double.valueOf(temp.getMax());
            } else {
                d2 = null;
            }
            String formattedTemp = formattedTemp(d2);
            MitmapBackend mitmapBackend = this.mitmapBackend;
            if (daily != null) {
                watchAsset2 = daily.getAsset();
            } else {
                watchAsset2 = null;
            }
            Mitmap mitmap$default = MitmapBackend.getMitmap$default(mitmapBackend, watchAsset2, null, 2, null);
            if (daily != null) {
                str = daily.getIconId();
            }
            currentForecast = new CurrentForecast(formattedTemp, mitmap$default, WeatherHttpClientKt.mapIdToWeather(str));
        } else {
            if (current != null) {
                d = Double.valueOf(current.getTemp());
            } else {
                d = null;
            }
            String formattedTemp2 = formattedTemp(d);
            MitmapBackend mitmapBackend2 = this.mitmapBackend;
            if (current != null) {
                watchAsset = current.getAsset();
            } else {
                watchAsset = null;
            }
            Mitmap mitmap$default2 = MitmapBackend.getMitmap$default(mitmapBackend2, watchAsset, null, 2, null);
            if (current != null) {
                str = current.getIconId();
            }
            currentForecast = new CurrentForecast(formattedTemp2, mitmap$default2, WeatherHttpClientKt.mapIdToWeather(str));
        }
        return currentForecast;
    }

    private final List<DailyForecast> getDailyForecast() {
        boolean z;
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimeZone.Companion.getClass();
        TimePeriod day$default = TimePeriod.Companion.day$default(companion, null, TimeZone.UTC, 1, null);
        List<Daily> daily = this.weatherProvider.getDaily();
        ArrayList arrayList = new ArrayList();
        for (Object obj : daily) {
            if (((Daily) obj).getInstant().compareTo(day$default.getEnd()) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
            DateTimeUnit.Companion.getClass();
            DateTimeUnit.DayBased dayBased = DateTimeUnit.DAY;
            TimeZone.Companion.getClass();
            Instant plus = InstantJvmKt.plus(startOfDay$default, 1, (DateTimeUnit) dayBased, TimeZone.Companion.currentSystemDefault());
            List dayIntervals$default = TimePeriodKt.dayIntervals$default(new TimePeriod(plus, DateTimeUtilsKt.plusWeek$default(plus, (TimeZone) null, 1, (Object) null)), null, 1, null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
            Iterator it = dayIntervals$default.iterator();
            while (it.hasNext()) {
                arrayList2.add(new DailyForecast(asWeekDay(((TimePeriod) it.next()).getStart()), null, null, 6, null));
            }
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Daily daily2 = (Daily) it2.next();
            arrayList3.add(new DailyForecast(asWeekDay(daily2.getInstant()), formattedTemp(Double.valueOf(daily2.getTemp().getMax())), MitmapBackend.getMitmap$default(this.mitmapBackend, daily2.getSmallAsset(), null, 2, null)));
        }
        return arrayList3;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    private final List<HourlyForecast> getHourlyForecast() {
        ArrayList arrayList;
        List<Hourly> hourly = this.weatherProvider.getHourly();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = hourly.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Instant instant = ((Hourly) next).getInstant();
            Instant now = DateTimeUtilsKt.now();
            int r7 = Duration.$r8$clinit;
            if (instant.compareTo(now.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.HOURS))) > 0) {
                z = true;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        List take = CollectionsKt___CollectionsKt.take(arrayList2, 8);
        if (take.isEmpty()) {
            LocalDateTime copy$default = DateTimeUtilsKt.copy$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null), 0, null, 0, 0, 0, 0, 0, 79, null);
            TimeZone.Companion.getClass();
            Instant instant2 = TimeZoneKt.toInstant(copy$default, TimeZone.Companion.currentSystemDefault());
            IntRange intRange = new IntRange(0, 8);
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
            ?? it2 = intRange.iterator();
            while (it2.hasNext) {
                int nextInt = it2.nextInt();
                DateTimeUnit.Companion.getClass();
                DateTimeUnit.TimeBased unit = DateTimeUnit.HOUR;
                Intrinsics.checkNotNullParameter(unit, "unit");
                arrayList.add(new HourlyForecast(WorkoutFormatUtilsKt.formatInstantHourMinutes$default(InstantJvmKt.plus(instant2, nextInt, unit), null, false, 6, null), null, null, null, 14, null));
            }
        } else {
            List<Hourly> list = take;
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            for (Hourly hourly2 : list) {
                arrayList.add(new HourlyForecast(WorkoutFormatUtilsKt.formatInstantHourMinutes$default(hourly2.getInstant(), null, false, 6, null), formattedTemp(Double.valueOf(hourly2.getTemp())), MitmapBackend.getMitmap$default(this.mitmapBackend, hourly2.getSmallAsset(), null, 2, null), MitmapBackend.getMitmap$default(this.mitmapBackend, hourly2.getBigAsset(), null, 2, null)));
            }
        }
        return arrayList;
    }

    private final TemperatureState getLatestTemperature() {
        Double d;
        if (this.weatherProvider.getTemperature().getValue() != null) {
            d = Double.valueOf(r0.floatValue());
        } else {
            d = null;
        }
        return new TemperatureState(formattedTemp(d), this.weatherProvider.getTemperature().getUseMinuteScale(), isCelsius());
    }

    private final TodayForecast getTodayForecast() {
        Object obj;
        Double d;
        Double d2;
        Double d3;
        Double d4;
        WatchAsset watchAsset;
        WatchAsset watchAsset2;
        Temp temp;
        Temp temp2;
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimeZone.Companion.getClass();
        TimePeriod day$default = TimePeriod.Companion.day$default(companion, null, TimeZone.UTC, 1, null);
        Iterator<T> it = this.weatherProvider.getDaily().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (day$default.contains(((Daily) obj).getInstant())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Daily daily = (Daily) obj;
        String asWeekDay = asWeekDay(day$default.getStart());
        if (daily != null && (temp2 = daily.getTemp()) != null) {
            d = Double.valueOf(temp2.getMax());
        } else {
            d = null;
        }
        String formattedTemp = formattedTemp(d);
        if (daily != null && (temp = daily.getTemp()) != null) {
            d2 = Double.valueOf(temp.getMin());
        } else {
            d2 = null;
        }
        String formattedTemp2 = formattedTemp(d2);
        if (daily != null) {
            d3 = Double.valueOf(daily.getPop());
        } else {
            d3 = null;
        }
        String rainProbability = rainProbability(d3);
        if (daily != null) {
            d4 = Double.valueOf(daily.getUvi());
        } else {
            d4 = null;
        }
        String uviString = toUviString(d4);
        MitmapBackend mitmapBackend = this.mitmapBackend;
        if (daily != null) {
            watchAsset = daily.getAsset();
        } else {
            watchAsset = null;
        }
        Mitmap mitmap$default = MitmapBackend.getMitmap$default(mitmapBackend, watchAsset, null, 2, null);
        MitmapBackend mitmapBackend2 = this.mitmapBackend;
        if (daily != null) {
            watchAsset2 = daily.getSmallAsset();
        } else {
            watchAsset2 = null;
        }
        return new TodayForecast(asWeekDay, formattedTemp, formattedTemp2, rainProbability, uviString, mitmap$default, MitmapBackend.getMitmap$default(mitmapBackend2, watchAsset2, null, 2, null));
    }

    private final String rainProbability(Double d) {
        if (d == null) {
            return "-";
        }
        return MathKt__MathJVMKt.roundToInt(RangesKt___RangesKt.coerceIn(d.doubleValue(), 0.0d, 1.0d) * 100.0d) + " %";
    }

    private final String toUviString(Double d) {
        if (d == null) {
            return "-";
        }
        return String.valueOf(MathKt__MathJVMKt.roundToInt(d.doubleValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeMeasurement(kotlin.jvm.functions.Function2<? super com.animaconnected.watch.fitness.FitnessProvider.Profile.Temperature, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.provider.weather.WeatherViewModel$changeMeasurement$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.provider.weather.WeatherViewModel$changeMeasurement$1 r0 = (com.animaconnected.watch.provider.weather.WeatherViewModel$changeMeasurement$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.provider.weather.WeatherViewModel$changeMeasurement$1 r0 = new com.animaconnected.watch.provider.weather.WeatherViewModel$changeMeasurement$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L39
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.provider.weather.WeatherViewModel r7 = (com.animaconnected.watch.provider.weather.WeatherViewModel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L71
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.provider.weather.WeatherViewModel r7 = (com.animaconnected.watch.provider.weather.WeatherViewModel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L66
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6.isCelsius()
            if (r8 == 0) goto L59
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Temperature r8 = com.animaconnected.watch.fitness.FitnessProvider.Profile.Temperature.Fahrenheit
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.invoke(r8, r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            r7 = r6
            goto L66
        L59:
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Temperature r8 = com.animaconnected.watch.fitness.FitnessProvider.Profile.Temperature.Celsius
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r8, r0)
            if (r7 != r1) goto L57
            return r1
        L66:
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r7.loadData(r0)
            if (r8 != r1) goto L71
            return r1
        L71:
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.watch.provider.weather.TemperatureState> r8 = r7.privateTemperatureState
            com.animaconnected.watch.provider.weather.TemperatureState r7 = r7.getLatestTemperature()
            r8.setValue(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.WeatherViewModel.changeMeasurement(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CommonFlow<TemperatureState> getTemperatureFlow() {
        return this.temperatureFlow;
    }

    public final boolean getUseMinuteScale() {
        return this.weatherProvider.getTemperature().getUseMinuteScale();
    }

    public final WeatherForecastWatch getWatchData() {
        return new WeatherForecastWatch(getCurrentForecast(), getTodayForecast(), getHourlyForecast(), getDailyForecast());
    }

    public final CommonFlow<WeatherForecastApp> getWeatherFlowApp() {
        return this.weatherFlowApp;
    }

    public final boolean isCelsius() {
        if (this.temperatureUnit.invoke() == FitnessProvider.Profile.Temperature.Celsius) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadData(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.provider.weather.WeatherViewModel$loadData$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.provider.weather.WeatherViewModel$loadData$1 r0 = (com.animaconnected.watch.provider.weather.WeatherViewModel$loadData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.provider.weather.WeatherViewModel$loadData$1 r0 = new com.animaconnected.watch.provider.weather.WeatherViewModel$loadData$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.provider.weather.WeatherViewModel r0 = (com.animaconnected.watch.provider.weather.WeatherViewModel) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L77
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.provider.weather.WeatherViewModel r2 = (com.animaconnected.watch.provider.weather.WeatherViewModel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4f
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.provider.weather.HistoricalWeatherProvider r9 = r8.weatherProvider
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r9.fetchWeather(r0)
            if (r9 != r1) goto L4e
            return r1
        L4e:
            r2 = r8
        L4f:
            com.animaconnected.watch.provider.weather.CurrentForecast r9 = r2.getCurrentForecast()
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.watch.provider.weather.WeatherForecastApp> r4 = r2.privateWeatherForecastApp
            com.animaconnected.watch.provider.weather.WeatherForecastApp r5 = new com.animaconnected.watch.provider.weather.WeatherForecastApp
            java.lang.String r6 = r9.getTemp()
            com.animaconnected.watch.provider.weather.WeatherViewModel$Weather r9 = r9.getType()
            boolean r7 = r2.isCelsius()
            r5.<init>(r6, r9, r7)
            r4.setValue(r5)
            com.animaconnected.watch.provider.weather.HistoricalWeatherProvider r9 = r2.weatherProvider
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r9.fetchTemperatureSuspending(r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            r0 = r2
        L77:
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.watch.provider.weather.TemperatureState> r9 = r0.privateTemperatureState
            com.animaconnected.watch.provider.weather.TemperatureState r0 = r0.getLatestTemperature()
            r9.setValue(r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.WeatherViewModel.loadData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setUseMinuteScale(boolean z) {
        TemperatureState value;
        this.weatherProvider.getTemperature().setUseMinuteScale(z);
        MutableStateFlow<TemperatureState> mutableStateFlow = this.privateTemperatureState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, TemperatureState.copy$default(value, null, z, false, 5, null)));
    }
}
