package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontFamily;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public final FontFamilyResolverImpl$createDefaultTypeface$1 createDefaultTypeface;
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    public final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    public final PlatformFontLoader platformFontLoader;
    public final PlatformResolveInterceptor platformResolveInterceptor;
    public final TypefaceRequestCache typefaceRequestCache;

    public FontFamilyResolverImpl(AndroidFontLoader androidFontLoader, AndroidFontResolveInterceptor androidFontResolveInterceptor) {
        TypefaceRequestCache typefaceRequestCache = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.GlobalAsyncTypefaceCache);
        PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter = new PlatformFontFamilyTypefaceAdapter();
        Intrinsics.checkNotNullParameter(typefaceRequestCache, "typefaceRequestCache");
        this.platformFontLoader = androidFontLoader;
        this.platformResolveInterceptor = androidFontResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new FontFamilyResolverImpl$createDefaultTypeface$1(this);
    }

    public final TypefaceResult resolve(final TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        final TypefaceRequestCache typefaceRequestCache = this.typefaceRequestCache;
        Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult> function1 = new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0447  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0449  */
            /* JADX WARN: Removed duplicated region for block: B:208:0x0273  */
            /* JADX WARN: Removed duplicated region for block: B:232:0x03da  */
            /* JADX WARN: Removed duplicated region for block: B:233:0x03e1  */
            /* JADX WARN: Removed duplicated region for block: B:309:0x03c8 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x007a A[SYNTHETIC] */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final androidx.compose.ui.text.font.TypefaceResult invoke(kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceResult, ? extends kotlin.Unit> r19) {
                /*
                    Method dump skipped, instructions count: 1117
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1.invoke(java.lang.Object):java.lang.Object");
            }
        };
        typefaceRequestCache.getClass();
        synchronized (typefaceRequestCache.lock) {
            typefaceResult = typefaceRequestCache.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (!typefaceResult.getCacheable()) {
                    typefaceRequestCache.resultCache.remove(typefaceRequest);
                }
            }
            try {
                typefaceResult = (TypefaceResult) function1.invoke(new Function1<TypefaceResult, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TypefaceResult typefaceResult2) {
                        TypefaceResult finalResult = typefaceResult2;
                        Intrinsics.checkNotNullParameter(finalResult, "finalResult");
                        TypefaceRequestCache typefaceRequestCache2 = TypefaceRequestCache.this;
                        ExecutorsKt executorsKt = typefaceRequestCache2.lock;
                        TypefaceRequest typefaceRequest2 = typefaceRequest;
                        synchronized (executorsKt) {
                            if (finalResult.getCacheable()) {
                                typefaceRequestCache2.resultCache.put(typefaceRequest2, finalResult);
                            } else {
                                typefaceRequestCache2.resultCache.remove(typefaceRequest2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                synchronized (typefaceRequestCache.lock) {
                    if (typefaceRequestCache.resultCache.get(typefaceRequest) == null && typefaceResult.getCacheable()) {
                        typefaceRequestCache.resultCache.put(typefaceRequest, typefaceResult);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
        return typefaceResult;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* renamed from: resolve-DPcqOEQ */
    public final TypefaceResult mo534resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int r10, int r11) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        PlatformResolveInterceptor platformResolveInterceptor = this.platformResolveInterceptor;
        platformResolveInterceptor.getClass();
        int r2 = PlatformResolveInterceptor.$r8$clinit;
        FontWeight interceptFontWeight = platformResolveInterceptor.interceptFontWeight(fontWeight);
        this.platformFontLoader.getCacheKey();
        return resolve(new TypefaceRequest(fontFamily, interceptFontWeight, r10, r11, null));
    }
}
