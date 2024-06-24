package com.animaconnected.watch.fitness.mock;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.PolyLineCompress;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.provider.demo.LocationDemoData;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.Instant;

/* compiled from: SessionMock.kt */
/* loaded from: classes3.dex */
public final class LocationMock {
    private static final LocationEntry malmo;
    public static final LocationMock INSTANCE = new LocationMock();
    private static final Lazy runningRoute$delegate = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends LocationEntry>>() { // from class: com.animaconnected.watch.fitness.mock.LocationMock$runningRoute$2
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends LocationEntry> invoke() {
            Instant.Companion.getClass();
            Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
            List<LocationEntry> decode = PolyLineCompress.INSTANCE.decode(LocationDemoData.encodedRouteMalmo1);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(decode, 10));
            for (LocationEntry locationEntry : decode) {
                arrayList.add(new LocationEntry(HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion), instant.toEpochMilliseconds(), locationEntry.getLong(), locationEntry.getLat(), 100.0f, 21.0d, false, 64, (DefaultConstructorMarker) null));
            }
            return arrayList;
        }
    });

    static {
        String mock = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
        Instant.Companion.getClass();
        malmo = new LocationEntry(mock, new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")).toEpochMilliseconds(), 13.00073d, 55.60587d, 100.0f, 12.0d, false, 64, (DefaultConstructorMarker) null);
    }

    private LocationMock() {
    }

    public final LocationEntry getMalmo() {
        return malmo;
    }

    public final List<LocationEntry> getRunningRoute() {
        return (List) runningRoute$delegate.getValue();
    }
}
