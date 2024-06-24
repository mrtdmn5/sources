package com.animaconnected.watch.device;

import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.display.CommandType;
import com.animaconnected.watch.display.DrawCommand;
import com.animaconnected.watch.display.Parameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinitionParser.kt */
/* loaded from: classes3.dex */
public final class DisplayDefinitionParserKt {
    public static final byte[] toBytes(List<? extends DrawCommand> list, MsgPackCreator msgPacker) {
        Object value;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(msgPacker, "msgPacker");
        List<? extends DrawCommand> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Map<Parameter, Object> parameters = ((DrawCommand) it.next()).parameters();
            ArrayList arrayList2 = new ArrayList(parameters.size());
            for (Map.Entry<Parameter, Object> entry : parameters.entrySet()) {
                Integer valueOf = Integer.valueOf(entry.getKey().getId());
                if (entry.getValue() instanceof CommandType) {
                    Object value2 = entry.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type com.animaconnected.watch.display.CommandType");
                    value = Integer.valueOf(((CommandType) value2).getId());
                } else {
                    value = entry.getValue();
                }
                arrayList2.add(new Pair(valueOf, value));
            }
            arrayList.add(msgPacker.newIntMap(MapsKt__MapsKt.toMap(arrayList2)));
        }
        return msgPacker.newArray(arrayList).toMsgPackBytes();
    }
}
