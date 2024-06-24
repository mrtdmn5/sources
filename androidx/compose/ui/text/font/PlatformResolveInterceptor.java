package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public interface PlatformResolveInterceptor {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        static {
            new PlatformResolveInterceptor$Companion$Default$1();
        }
    }

    static {
        Companion companion = Companion.$$INSTANCE;
    }

    default FontWeight interceptFontWeight(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return fontWeight;
    }
}
