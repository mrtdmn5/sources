package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.info.ByteArrayBuilder;
import com.animaconnected.info.ByteArrayBuilderKt;
import com.animaconnected.info.ByteArrayReader;
import com.animaconnected.watch.model.alarms.DaysOfWeek;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WatchAlarmProviderKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AlarmParser.kt */
/* loaded from: classes3.dex */
public final class AlarmParserKt {
    private static final short alarmStructVersion = (short) 1;

    public static final List<WatchAlarm> decode(WatchAlarm.Companion companion, final byte[] byteArray) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return (List) ByteArrayBuilderKt.reader(byteArray, new Function1<ByteArrayReader, List<? extends WatchAlarm>>() { // from class: com.animaconnected.watch.behaviour.alarms.AlarmParserKt$decode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<WatchAlarm> invoke(ByteArrayReader reader) {
                short s;
                Intrinsics.checkNotNullParameter(reader, "$this$reader");
                short m723uInt16LEMh2AYeg = reader.m723uInt16LEMh2AYeg();
                short uInt8LE = reader.uInt8LE();
                reader.uInt8LE();
                s = AlarmParserKt.alarmStructVersion;
                EmptyList emptyList = EmptyList.INSTANCE;
                if (m723uInt16LEMh2AYeg != s || byteArray.length != (uInt8LE * 13) + 4) {
                    return emptyList;
                }
                IntRange until = RangesKt___RangesKt.until(0, uInt8LE);
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    long uInt32LE = reader.uInt32LE();
                    long uInt32LE2 = reader.uInt32LE() * 1000;
                    short uInt8LE2 = reader.uInt8LE();
                    short uInt8LE3 = reader.uInt8LE();
                    reader.m723uInt16LEMh2AYeg();
                    short uInt8LE4 = reader.uInt8LE();
                    Set<Integer> days = DaysOfWeek.Companion.fromBitSet(uInt8LE4).getDays();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(days, 10));
                    Iterator<T> it2 = days.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(AlarmDay.Companion.fromInt(((Number) it2.next()).intValue()));
                    }
                    arrayList.add(new WatchAlarm(uInt32LE, uInt8LE2, uInt8LE3, CollectionsKt___CollectionsKt.toSet(arrayList2), ((byte) (((byte) uInt8LE4) & 1)) > 0, false, uInt32LE2));
                }
                return arrayList;
            }
        });
    }

    public static final byte[] encode(WatchAlarm.Companion companion, final List<WatchAlarm> alarms) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(alarms, "alarms");
        return ByteArrayBuilderKt.byteArrayBuilder(new Function1<ByteArrayBuilder, Unit>() { // from class: com.animaconnected.watch.behaviour.alarms.AlarmParserKt$encode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ByteArrayBuilder byteArrayBuilder) {
                invoke2(byteArrayBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ByteArrayBuilder byteArrayBuilder) {
                short s;
                Intrinsics.checkNotNullParameter(byteArrayBuilder, "$this$byteArrayBuilder");
                s = AlarmParserKt.alarmStructVersion;
                byteArrayBuilder.m719uInt16LExj2QHRw(s);
                byteArrayBuilder.uInt8LE(alarms.size());
                byteArrayBuilder.uInt8LE(0);
                for (WatchAlarm watchAlarm : alarms) {
                    byteArrayBuilder.m720uInt32LEWZ4Q5Ns((int) watchAlarm.getId());
                    byteArrayBuilder.m720uInt32LEWZ4Q5Ns((int) (watchAlarm.getLastModified() / 1000));
                    byteArrayBuilder.uInt8LE(watchAlarm.getHour());
                    byteArrayBuilder.uInt8LE(watchAlarm.getMinute());
                    byteArrayBuilder.uInt16LE(0);
                    byteArrayBuilder.m722uInt8LE7apg3OU((byte) (((byte) WatchAlarmProviderKt.toDaysOfWeek(watchAlarm.getDaysEnabled()).toBitSet()) | (watchAlarm.getEnabled() ? (byte) 1 : (byte) 0)));
                }
            }
        });
    }
}
