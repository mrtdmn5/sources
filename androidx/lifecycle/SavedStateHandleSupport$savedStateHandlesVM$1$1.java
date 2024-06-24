package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends Lambda implements Function1<CreationExtras, SavedStateHandlesVM> {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = ;

    @Override // kotlin.jvm.functions.Function1
    public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
        CreationExtras initializer = creationExtras;
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
