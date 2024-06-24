package com.animaconnected.watch.provider.quiethours;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.datetime.Instant;

/* compiled from: RefreshTimer.kt */
/* loaded from: classes3.dex */
public final class RefreshTimer {
    private final Function0<Unit> callback;
    private final Job job;
    private final CoroutineScope scope;

    public RefreshTimer(CoroutineScope scope, List<Instant> calendars, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(calendars, "calendars");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.scope = scope;
        this.callback = callback;
        this.job = setupReminder(calendars);
    }

    private final Job setupReminder(List<Instant> list) {
        if (list.isEmpty()) {
            return BuildersKt.launch$default(this.scope, null, null, new RefreshTimer$setupReminder$1(null), 3);
        }
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        List listOf = CollectionsKt__CollectionsKt.listOf(instant);
        List<Instant> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        for (Instant instant2 : list2) {
            if (instant2.compareTo(instant) < 0) {
                int r6 = Duration.$r8$clinit;
                instant2 = instant2.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
            }
            arrayList.add(instant2);
        }
        return BuildersKt.launch$default(this.scope, null, null, new RefreshTimer$setupReminder$2(CollectionsKt___CollectionsKt.windowed$default(CollectionsKt___CollectionsKt.plus((Iterable) CollectionsKt___CollectionsKt.sorted(arrayList), (Collection) listOf), 2, 0, new Function1<List<? extends Instant>, Duration>() { // from class: com.animaconnected.watch.provider.quiethours.RefreshTimer$setupReminder$delays$1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Duration invoke(List<? extends Instant> list3) {
                return new Duration(m1567invoke5sfh64U(list3));
            }

            /* renamed from: invoke-5sfh64U, reason: not valid java name */
            public final long m1567invoke5sfh64U(List<Instant> list3) {
                Intrinsics.checkNotNullParameter(list3, "<name for destructuring parameter 0>");
                return list3.get(1).m1704minus5sfh64U(list3.get(0));
            }
        }, 6), this, null), 3);
    }

    public final void dispose() {
        this.job.cancel(null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }
}
