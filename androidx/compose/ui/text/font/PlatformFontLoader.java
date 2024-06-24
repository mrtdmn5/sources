package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.coroutines.Continuation;

/* compiled from: Font.kt */
/* loaded from: classes.dex */
public interface PlatformFontLoader {
    Object awaitLoad(Font font, Continuation<Object> continuation);

    void getCacheKey();

    Typeface loadBlocking(Font font);
}
