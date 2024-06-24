package androidx.compose.foundation.pager;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import com.airbnb.lottie.L;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerState.kt */
/* loaded from: classes.dex */
public final class PagerStateImpl extends PagerState {
    public static final SaverKt$Saver$1 Saver = L.listSaver(new Function2<SaverScope, PagerStateImpl, List<? extends Object>>() { // from class: androidx.compose.foundation.pager.PagerStateImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<? extends Object> invoke(SaverScope saverScope, PagerStateImpl pagerStateImpl) {
            SaverScope listSaver = saverScope;
            PagerStateImpl it = pagerStateImpl;
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt__CollectionsKt.listOf(Integer.valueOf(it.getCurrentPage()), Float.valueOf(it.getCurrentPageOffsetFraction()), Integer.valueOf(it.getPageCount()));
        }
    }, new Function1<List, PagerStateImpl>() { // from class: androidx.compose.foundation.pager.PagerStateImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final PagerStateImpl invoke(List list) {
            final List it = list;
            Intrinsics.checkNotNullParameter(it, "it");
            Object obj = it.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = it.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new PagerStateImpl(intValue, ((Float) obj2).floatValue(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerStateImpl$Companion$Saver$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    Object obj3 = it.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return (Integer) obj3;
                }
            });
        }
    });
    public final ParcelableSnapshotMutableState pageCountState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerStateImpl(int r2, float f, Function0<Integer> updatedPageCount) {
        super(f, r2);
        Intrinsics.checkNotNullParameter(updatedPageCount, "updatedPageCount");
        this.pageCountState = Platform.mutableStateOf$default(updatedPageCount);
    }

    @Override // androidx.compose.foundation.pager.PagerState
    public final int getPageCount() {
        return ((Number) ((Function0) this.pageCountState.getValue()).invoke()).intValue();
    }
}
