package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.compose.ui.geometry.GeometryUtilsKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontRequestWorker;

/* loaded from: classes.dex */
public final class CallbackWithHandler {
    public final GeometryUtilsKt mCallback;
    public final Handler mCallbackHandler;

    /* renamed from: androidx.core.provider.CallbackWithHandler$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ GeometryUtilsKt val$callback;
        public final /* synthetic */ Typeface val$typeface;

        public AnonymousClass1(GeometryUtilsKt geometryUtilsKt, Typeface typeface) {
            this.val$callback = geometryUtilsKt;
            this.val$typeface = typeface;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ResourcesCompat.FontCallback fontCallback = ((TypefaceCompat.ResourcesCallbackAdapter) this.val$callback).mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(this.val$typeface);
            }
        }
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$2 */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ GeometryUtilsKt val$callback;
        public final /* synthetic */ int val$reason;

        public AnonymousClass2(GeometryUtilsKt geometryUtilsKt, int r2) {
            this.val$callback = geometryUtilsKt;
            this.val$reason = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ResourcesCompat.FontCallback fontCallback = ((TypefaceCompat.ResourcesCallbackAdapter) this.val$callback).mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(this.val$reason);
            }
        }
    }

    public CallbackWithHandler(TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter, Handler handler) {
        this.mCallback = resourcesCallbackAdapter;
        this.mCallbackHandler = handler;
    }

    public final void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        boolean z;
        int r0 = typefaceResult.mResult;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        Handler handler = this.mCallbackHandler;
        GeometryUtilsKt geometryUtilsKt = this.mCallback;
        if (z) {
            handler.post(new AnonymousClass1(geometryUtilsKt, typefaceResult.mTypeface));
        } else {
            handler.post(new AnonymousClass2(geometryUtilsKt, r0));
        }
    }
}
