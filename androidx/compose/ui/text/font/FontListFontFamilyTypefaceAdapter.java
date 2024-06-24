package androidx.compose.ui.text.font;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapter {
    public static final FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1 DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1();
    public final ContextScope asyncLoadScope;
    public final AsyncTypefaceCache asyncTypefaceCache;

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(emptyCoroutineContext).plus(new SupervisorJobImpl(null)));
    }
}
