package androidx.compose.foundation.relocation;

import androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2;
import androidx.compose.ui.geometry.Rect;
import kotlin.coroutines.Continuation;

/* compiled from: BringIntoViewResponder.kt */
/* loaded from: classes.dex */
public interface BringIntoViewResponder {
    Object bringChildIntoView(BringIntoViewResponderNode$bringChildIntoView$2.AnonymousClass1.C00111 c00111, Continuation continuation);

    Rect calculateRectForParent(Rect rect);
}
