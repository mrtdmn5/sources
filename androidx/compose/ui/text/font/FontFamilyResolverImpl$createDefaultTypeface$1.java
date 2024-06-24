package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public final class FontFamilyResolverImpl$createDefaultTypeface$1 extends Lambda implements Function1<TypefaceRequest, Object> {
    public final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(TypefaceRequest typefaceRequest) {
        TypefaceRequest it = typefaceRequest;
        Intrinsics.checkNotNullParameter(it, "it");
        int r4 = it.fontStyle;
        int r5 = it.fontSynthesis;
        Object obj = it.resourceLoaderCacheKey;
        FontWeight fontWeight = it.fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return this.this$0.resolve(new TypefaceRequest(null, fontWeight, r4, r5, obj)).getValue();
    }
}
