package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Saver.kt */
/* loaded from: classes.dex */
public final class SaverKt {
    public static final SaverKt$Saver$1 AutoSaver = Saver(new Function2<SaverScope, Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Object obj) {
            SaverScope Saver = saverScope;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return obj;
        }
    }, new Function1<Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it;
        }
    });

    public static final SaverKt$Saver$1 Saver(Function2 save, Function1 restore) {
        Intrinsics.checkNotNullParameter(save, "save");
        Intrinsics.checkNotNullParameter(restore, "restore");
        return new SaverKt$Saver$1(save, restore);
    }
}
