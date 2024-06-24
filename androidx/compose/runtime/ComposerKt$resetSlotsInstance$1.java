package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposerKt$resetSlotsInstance$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    public static final ComposerKt$resetSlotsInstance$1 INSTANCE = new ComposerKt$resetSlotsInstance$1();

    public ComposerKt$resetSlotsInstance$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        boolean z;
        SlotWriter slotWriter2 = slotWriter;
        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
        if (slotWriter2.insertCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            slotWriter2.recalculateMarks();
            slotWriter2.currentGroup = 0;
            slotWriter2.currentGroupEnd = (slotWriter2.groups.length / 5) - slotWriter2.groupGapLen;
            slotWriter2.currentSlot = 0;
            slotWriter2.currentSlotEnd = 0;
            slotWriter2.nodeCount = 0;
            return Unit.INSTANCE;
        }
        ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
        throw null;
    }
}
