package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class SemanticsModifierKt {
    public static final AtomicInteger lastIdentifier = new AtomicInteger(0);

    public static final Modifier semantics(Modifier modifier, boolean z, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return modifier.then(new AppendedSemanticsElement(z, properties));
    }
}
