package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public final class FocusPropertiesImpl$enter$1 extends Lambda implements Function1<FocusDirection, FocusRequester> {
    public static final FocusPropertiesImpl$enter$1 INSTANCE = new FocusPropertiesImpl$enter$1();

    public FocusPropertiesImpl$enter$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FocusRequester invoke(FocusDirection focusDirection) {
        int r1 = focusDirection.value;
        return FocusRequester.Default;
    }
}
