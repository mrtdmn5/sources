package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListIntervalContent.kt */
/* loaded from: classes.dex */
public final class LazyListIntervalContent extends LazyLayoutIntervalContent<LazyListInterval> implements LazyListScope {
    public final MutableIntervalList<LazyListInterval> intervals;

    public LazyListIntervalContent(Function1<? super LazyListScope, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.intervals = new MutableIntervalList<>();
        content.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final MutableIntervalList getIntervals$1() {
        return this.intervals;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.foundation.lazy.LazyListIntervalContent$item$3, kotlin.jvm.internal.Lambda] */
    @Override // androidx.compose.foundation.lazy.LazyListScope
    public final void item(final Object obj, final Object obj2, final Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        Function1<Integer, Object> function1;
        Intrinsics.checkNotNullParameter(content, "content");
        if (obj != null) {
            function1 = new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Integer num) {
                    num.intValue();
                    return obj;
                }
            };
        } else {
            function1 = null;
        }
        this.intervals.addInterval(1, new LazyListInterval(function1, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Integer num) {
                num.intValue();
                return obj2;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1010194746, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                int r5;
                LazyItemScope $receiver = lazyItemScope;
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                if ((intValue & 14) == 0) {
                    if (composer2.changed($receiver)) {
                        r5 = 4;
                    } else {
                        r5 = 2;
                    }
                    intValue |= r5;
                }
                if ((intValue & 651) == 130 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    content.invoke($receiver, composer2, Integer.valueOf(intValue & 14));
                }
                return Unit.INSTANCE;
            }
        }, true)));
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public final void items(int r2, WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1 workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1, Function1 function1, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(r2, new LazyListInterval(workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1, function1, composableLambdaImpl));
    }
}
