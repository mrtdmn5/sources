package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: PlatformTypefaces.kt */
/* loaded from: classes.dex */
public final class TypefaceCompatApi26$toAndroidString$1 extends Lambda implements Function1<FontVariation$Setting, CharSequence> {
    public final /* synthetic */ Density $density;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypefaceCompatApi26$toAndroidString$1(DensityImpl densityImpl) {
        super(1);
        this.$density = densityImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(FontVariation$Setting fontVariation$Setting) {
        FontVariation$Setting setting = fontVariation$Setting;
        Intrinsics.checkNotNullParameter(setting, "setting");
        return "'" + setting.getAxisName() + "' " + setting.toVariationValue();
    }
}
