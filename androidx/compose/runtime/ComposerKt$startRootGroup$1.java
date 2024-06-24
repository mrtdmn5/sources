package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposerKt$startRootGroup$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    public static final ComposerKt$startRootGroup$1 INSTANCE = new ComposerKt$startRootGroup$1();

    public ComposerKt$startRootGroup$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        SlotWriter slots = slotWriter;
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        slots.ensureStarted(0);
        return Unit.INSTANCE;
    }
}
