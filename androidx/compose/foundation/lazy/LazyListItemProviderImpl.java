package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListItemProvider.kt */
/* loaded from: classes.dex */
public final class LazyListItemProviderImpl implements LazyListItemProvider {
    public final LazyListIntervalContent intervalContent;
    public final LazyItemScopeImpl itemScope;
    public final LazyLayoutKeyIndexMap keyIndexMap;
    public final LazyListState state;

    public LazyListItemProviderImpl(LazyListState state, LazyListIntervalContent intervalContent, LazyItemScopeImpl itemScope, NearestRangeKeyIndexMap nearestRangeKeyIndexMap) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(intervalContent, "intervalContent");
        Intrinsics.checkNotNullParameter(itemScope, "itemScope");
        this.state = state;
        this.intervalContent = intervalContent;
        this.itemScope = itemScope;
        this.keyIndexMap = nearestRangeKeyIndexMap;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final void Item(final int r8, final Object key, Composer composer, final int r11) {
        Intrinsics.checkNotNullParameter(key, "key");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-462424778);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key, r8, this.state.pinnedItems, ComposableLambdaKt.composableLambda(startRestartGroup, -824725566, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    LazyListItemProviderImpl lazyListItemProviderImpl = LazyListItemProviderImpl.this;
                    MutableIntervalList<LazyListInterval> mutableIntervalList = lazyListItemProviderImpl.intervalContent.intervals;
                    int r1 = r8;
                    IntervalList$Interval<LazyListInterval> intervalList$Interval = mutableIntervalList.get(r1);
                    int r12 = r1 - intervalList$Interval.startIndex;
                    intervalList$Interval.value.item.invoke(lazyListItemProviderImpl.itemScope, Integer.valueOf(r12), composer3, 0);
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((r11 << 3) & 112) | 3592);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r11 | 1);
                    int r0 = r8;
                    Object obj = key;
                    LazyListItemProviderImpl.this.Item(r0, obj, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyListItemProviderImpl)) {
            return false;
        }
        return Intrinsics.areEqual(this.intervalContent, ((LazyListItemProviderImpl) obj).intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final Object getContentType(int r3) {
        IntervalList$Interval<LazyListInterval> intervalList$Interval = this.intervalContent.intervals.get(r3);
        return intervalList$Interval.value.getType().invoke(Integer.valueOf(r3 - intervalList$Interval.startIndex));
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public final void getHeaderIndexes() {
        this.intervalContent.getClass();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.keyIndexMap.getIndex(key);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final int getItemCount() {
        return this.intervalContent.getIntervals$1().size;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public final LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final Object getKey(int r2) {
        Object key = this.keyIndexMap.getKey(r2);
        if (key == null) {
            return this.intervalContent.getKey(r2);
        }
        return key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    public final int hashCode() {
        return this.intervalContent.hashCode();
    }
}
