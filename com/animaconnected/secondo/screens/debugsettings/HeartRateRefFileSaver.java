package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.bluetooth.heartrate.HeartRateDevice;
import com.animaconnected.bluetooth.heartrate.ReferenceDeviceListener;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.debugging.FileWriter;
import com.animaconnected.watch.fitness.FitnessProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HeartRateRefFileSaver.kt */
/* loaded from: classes3.dex */
public final class HeartRateRefFileSaver implements ReferenceDeviceListener {
    public static final int $stable = 8;
    private final Context context;
    private final FileWriter fileWriter;
    private final FitnessProvider fitnessProvider;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPref;

    public HeartRateRefFileSaver(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        Context context = companion.getContext();
        this.context = context;
        this.scope = companion.getScope();
        SharedPreferences sharedPreferences = context.getSharedPreferences("HeartRateRefFileSaver", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPref = sharedPreferences;
        int r0 = Duration.$r8$clinit;
        this.fileWriter = new FileWriter("db-ref-data", null, 26214400, 4, DurationKt.toDuration(1, DurationUnit.SECONDS), ".csv", 2, null);
    }

    private final void append(String str, String str2, String str3, String str4, List<String> list) {
        this.fileWriter.append(this.context, str + ',' + str2 + ',' + str3 + ',' + str4 + ',' + CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, null, 62) + '\n');
    }

    private final long getStartTs() {
        return this.sharedPref.getLong("startTs", 0L);
    }

    private final void setStartTs(long j) {
        this.sharedPref.edit().putLong("startTs", j).apply();
    }

    public final void clear() {
        this.fileWriter.delete(this.context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final FitnessProvider getFitnessProvider() {
        return this.fitnessProvider;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.animaconnected.bluetooth.heartrate.ReferenceDeviceListener
    public void onData(HeartRateDevice.HRValue data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String valueOf = String.valueOf(data.getTs());
        String valueOf2 = String.valueOf(data.getHeartRate());
        List<Float> rrValues = data.getRrValues();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(rrValues, 10));
        Iterator<T> it = rrValues.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).floatValue()));
        }
        append("Reference device", valueOf, valueOf2, "", arrayList);
    }

    public final void start() {
        append("Source", "Timestamp", "Heart rate", "Confidence", CollectionsKt__CollectionsKt.listOf("IBI values"));
        setStartTs(DateTimeUtilsKt.currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object stop(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver$stop$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver$stop$1 r0 = (com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver$stop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver$stop$1 r0 = new com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver$stop$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc0
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver r2 = (com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L79
        L3e:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver r2 = (com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5b
        L46:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.fitness.FitnessProvider r11 = r10.fitnessProvider
            com.animaconnected.watch.CommonFlow r11 = r11.syncFitness()
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = com.animaconnected.watch.fitness.FitnessProviderKt.suspendUntilDone(r11, r0)
            if (r11 != r1) goto L5a
            return r1
        L5a:
            r2 = r10
        L5b:
            com.animaconnected.watch.fitness.FitnessProvider r11 = r2.fitnessProvider
            com.animaconnected.watch.fitness.TimePeriod r5 = new com.animaconnected.watch.fitness.TimePeriod
            long r6 = r2.getStartTs()
            long r8 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            r5.<init>(r6, r8)
            com.animaconnected.watch.CommonFlow r11 = r11.getHeartrateData(r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r11, r0)
            if (r11 != r1) goto L79
            return r1
        L79:
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto Lb0
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L83:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto Lb0
            java.lang.Object r4 = r11.next()
            com.animaconnected.watch.fitness.HeartrateEntry r4 = (com.animaconnected.watch.fitness.HeartrateEntry) r4
            java.lang.String r5 = "pascal_history"
            long r6 = r4.getTimestamp()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r7 = r4.getHeartrate()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r4 = r4.getConfidence()
            java.lang.String r8 = java.lang.String.valueOf(r4)
            kotlin.collections.EmptyList r9 = kotlin.collections.EmptyList.INSTANCE
            r4 = r2
            r4.append(r5, r6, r7, r8, r9)
            goto L83
        Lb0:
            com.animaconnected.secondo.utils.debugging.FileWriter r11 = r2.fileWriter
            android.content.Context r2 = r2.context
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r11 = r11.saveToFile(r2, r0)
            if (r11 != r1) goto Lc0
            return r1
        Lc0:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver.stop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final File zip() {
        return this.fileWriter.zip(this.context, "hrdata.zip");
    }
}
