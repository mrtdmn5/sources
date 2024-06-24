package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Saver.kt */
/* loaded from: classes.dex */
public final class SaverKt$Saver$1 implements Saver<Object, Object> {
    public final /* synthetic */ Function1<Object, Object> $restore;
    public final /* synthetic */ Function2<SaverScope, Object, Object> $save;

    /* JADX WARN: Multi-variable type inference failed */
    public SaverKt$Saver$1(Function2<? super SaverScope, Object, Object> function2, Function1<Object, Object> function1) {
        this.$save = function2;
        this.$restore = function1;
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public final Object save(SaverScope saverScope, Object obj) {
        Intrinsics.checkNotNullParameter(saverScope, "<this>");
        return this.$save.invoke(saverScope, obj);
    }
}
