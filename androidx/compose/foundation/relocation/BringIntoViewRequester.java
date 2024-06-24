package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public interface BringIntoViewRequester {
    Object bringIntoView(Rect rect, Continuation<? super Unit> continuation);
}
