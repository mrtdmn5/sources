package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: LazyLayoutSemantics.kt */
/* loaded from: classes.dex */
public interface LazyLayoutSemanticState {
    Object animateScrollBy(float f, Continuation<? super Unit> continuation);

    CollectionInfo collectionInfo();

    boolean getCanScrollForward();

    float getCurrentPosition();

    Object scrollToItem(int r1, Continuation<? super Unit> continuation);
}
