package androidx.compose.ui.text.platform;

import android.text.style.URLSpan;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.WeakHashMap;

/* compiled from: URLSpanCache.kt */
/* loaded from: classes.dex */
public final class URLSpanCache {
    public final WeakHashMap<UrlAnnotation, URLSpan> spansByAnnotation = new WeakHashMap<>();
}
