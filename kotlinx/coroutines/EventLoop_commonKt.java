package kotlinx.coroutines;

import aws.smithy.kotlin.runtime.serde.json.LexerState;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public final class EventLoop_commonKt {
    public static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    public static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final void replaceTop(LexerState lexerState, List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        list.add(lexerState);
    }

    public static final Object top(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(list.size() - 1);
    }
}
