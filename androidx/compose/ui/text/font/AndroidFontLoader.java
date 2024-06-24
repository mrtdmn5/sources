package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import com.google.android.gms.measurement.internal.zzdc;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontLoader.android.kt */
/* loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    public final Context context;

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r8, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            java.lang.String r5 = "context"
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            androidx.compose.ui.text.font.Font r8 = r0.L$1
            androidx.compose.ui.text.font.AndroidFontLoader r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L65
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8 instanceof androidx.compose.ui.text.font.AndroidFont
            r2 = 0
            android.content.Context r6 = r7.context
            if (r9 != 0) goto L89
            boolean r9 = r8 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r9 == 0) goto L75
            r9 = r8
            androidx.compose.ui.text.font.ResourceFont r9 = (androidx.compose.ui.text.font.ResourceFont) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            kotlinx.coroutines.scheduling.DefaultIoScheduler r3 = kotlinx.coroutines.Dispatchers.IO
            androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2 r4 = new androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2
            r4.<init>(r9, r6, r2)
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r0)
            if (r9 != r1) goto L64
            return r1
        L64:
            r0 = r7
        L65:
            android.graphics.Typeface r9 = (android.graphics.Typeface) r9
            androidx.compose.ui.text.font.ResourceFont r8 = (androidx.compose.ui.text.font.ResourceFont) r8
            androidx.compose.ui.text.font.FontVariation$Settings r8 = r8.variationSettings
            android.content.Context r0 = r0.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            android.graphics.Typeface r8 = androidx.compose.ui.text.font.PlatformTypefacesKt.setFontVariationSettings(r9, r8, r0)
            return r8
        L75:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown font type: "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8)
            throw r9
        L89:
            androidx.compose.ui.text.font.AndroidFont r8 = (androidx.compose.ui.text.font.AndroidFont) r8
            r8.getClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            r0.label = r4
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public final Typeface loadBlocking(Font font) {
        boolean z;
        boolean z2;
        Object createFailure;
        Typeface typeface;
        boolean z3 = font instanceof AndroidFont;
        Object obj = null;
        Context context = this.context;
        if (!z3) {
            if (!(font instanceof ResourceFont)) {
                return null;
            }
            int mo532getLoadingStrategyPKNRLFQ = font.mo532getLoadingStrategyPKNRLFQ();
            boolean z4 = false;
            if (mo532getLoadingStrategyPKNRLFQ == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                typeface = AndroidFontLoader_androidKt.access$load(context, (ResourceFont) font);
            } else {
                if (mo532getLoadingStrategyPKNRLFQ == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        createFailure = AndroidFontLoader_androidKt.access$load(context, (ResourceFont) font);
                    } catch (Throwable th) {
                        createFailure = ResultKt.createFailure(th);
                    }
                    if (!(createFailure instanceof Result.Failure)) {
                        obj = createFailure;
                    }
                    typeface = (Typeface) obj;
                } else {
                    if (mo532getLoadingStrategyPKNRLFQ == 2) {
                        z4 = true;
                    }
                    if (z4) {
                        throw new UnsupportedOperationException("Unsupported Async font load path");
                    }
                    throw new IllegalArgumentException("Unknown loading type " + ((Object) zzdc.m1642toStringimpl(font.mo532getLoadingStrategyPKNRLFQ())));
                }
            }
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return PlatformTypefacesKt.setFontVariationSettings(typeface, ((ResourceFont) font).variationSettings, context);
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        throw null;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public final void getCacheKey() {
    }
}
