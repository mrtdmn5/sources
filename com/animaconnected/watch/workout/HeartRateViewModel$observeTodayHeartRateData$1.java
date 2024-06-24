package com.animaconnected.watch.workout;

import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.PowerEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.LineChartValue;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.utils.CompressResult;
import com.animaconnected.watch.workout.utils.DataPoint;
import com.animaconnected.watch.workout.utils.HeartrateCompressorKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: HeartRateViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.HeartRateViewModel$observeTodayHeartRateData$1", f = "HeartRateViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HeartRateViewModel$observeTodayHeartRateData$1 extends SuspendLambda implements Function3<List<? extends HeartrateEntry>, List<? extends PowerEntry>, Continuation<? super HeartRateSummary>, Object> {
    final /* synthetic */ TimePeriod $timePeriod;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HeartRateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeartRateViewModel$observeTodayHeartRateData$1(TimePeriod timePeriod, HeartRateViewModel heartRateViewModel, Continuation<? super HeartRateViewModel$observeTodayHeartRateData$1> continuation) {
        super(3, continuation);
        this.$timePeriod = timePeriod;
        this.this$0 = heartRateViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends HeartrateEntry> list, List<? extends PowerEntry> list2, Continuation<? super HeartRateSummary> continuation) {
        return invoke2((List<HeartrateEntry>) list, (List<PowerEntry>) list2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String appString;
        String appString2;
        Known known;
        String appString3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            TimePeriod timePeriod = this.$timePeriod;
            int r1 = Duration.$r8$clinit;
            CompressResult m1572compressForTodayGraphJ7AnP2E = HeartrateCompressorKt.m1572compressForTodayGraphJ7AnP2E(list, list2, timePeriod, DurationKt.toDuration(10, DurationUnit.MINUTES), DurationKt.toDuration(1.5d, DurationUnit.HOURS));
            HeartRateViewModel heartRateViewModel = this.this$0;
            Integer max = m1572compressForTodayGraphJ7AnP2E.getMax();
            if (max == null || (appString = max.toString()) == null) {
                appString = StringsExtensionsKt.getAppString(Key.not_available);
            }
            String str = appString;
            Integer min = m1572compressForTodayGraphJ7AnP2E.getMin();
            if (min == null || (appString2 = min.toString()) == null) {
                appString2 = StringsExtensionsKt.getAppString(Key.not_available);
            }
            String str2 = appString2;
            LineChartValue avg = m1572compressForTodayGraphJ7AnP2E.getAvg();
            if (avg instanceof Known) {
                known = (Known) avg;
            } else {
                known = null;
            }
            if (known == null || (appString3 = new Integer(known.getValue()).toString()) == null) {
                appString3 = StringsExtensionsKt.getAppString(Key.not_available);
            }
            String str3 = appString3;
            List<DataPoint> trim = HeartrateCompressorKt.trim(m1572compressForTodayGraphJ7AnP2E.getData());
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(trim, 10));
            for (DataPoint dataPoint : trim) {
                arrayList.add(new PointEntry(dataPoint.getAvgValue(), DateFormatter.format$default(DateTimeFormattersKt.getHourMinuteFormatter(heartRateViewModel.getStringsBackend$watch_release()), dataPoint.getTimestamp(), null, false, 6, null), DateFormatter.format$default(DateTimeFormattersKt.getHourMinuteFormatter(heartRateViewModel.getStringsBackend$watch_release()), dataPoint.getTimestamp(), null, false, 6, null), false, 8, (DefaultConstructorMarker) null));
            }
            return new HeartRateSummary(str, str2, str3, arrayList, !(m1572compressForTodayGraphJ7AnP2E.getAvg() instanceof Known));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<HeartrateEntry> list, List<PowerEntry> list2, Continuation<? super HeartRateSummary> continuation) {
        HeartRateViewModel$observeTodayHeartRateData$1 heartRateViewModel$observeTodayHeartRateData$1 = new HeartRateViewModel$observeTodayHeartRateData$1(this.$timePeriod, this.this$0, continuation);
        heartRateViewModel$observeTodayHeartRateData$1.L$0 = list;
        heartRateViewModel$observeTodayHeartRateData$1.L$1 = list2;
        return heartRateViewModel$observeTodayHeartRateData$1.invokeSuspend(Unit.INSTANCE);
    }
}
