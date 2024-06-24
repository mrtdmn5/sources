package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyDsl.kt */
/* loaded from: classes.dex */
public interface LazyListScope {
    default void item(Object obj, Object obj2, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        throw new IllegalStateException("The method is not implemented".toString());
    }

    default void items(int r1, WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1 workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1, Function1 function1, ComposableLambdaImpl composableLambdaImpl) {
        throw new IllegalStateException("The method is not implemented".toString());
    }
}
