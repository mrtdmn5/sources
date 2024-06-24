package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public final class TypefaceRequestCache {
    public final ExecutorsKt lock = new ExecutorsKt();
    public final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>();
}
