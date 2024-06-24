package androidx.compose.foundation.pager;

import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutPagerKt$$ExternalSyntheticOutline0 {
    public static CompositionScopedCoroutineScopeCanceller m(ContextScope contextScope, ComposerImpl composerImpl) {
        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(contextScope);
        composerImpl.updateValue(compositionScopedCoroutineScopeCanceller);
        return compositionScopedCoroutineScopeCanceller;
    }
}
