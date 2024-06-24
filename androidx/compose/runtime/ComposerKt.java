package androidx.compose.runtime;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposerKt {
    public static final ComposerKt$removeCurrentGroupInstance$1 removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;
    public static final ComposerKt$skipToGroupEndInstance$1 skipToGroupEndInstance = ComposerKt$skipToGroupEndInstance$1.INSTANCE;
    public static final ComposerKt$endGroupInstance$1 endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;
    public static final ComposerKt$startRootGroup$1 startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;
    public static final ComposerKt$resetSlotsInstance$1 resetSlotsInstance = ComposerKt$resetSlotsInstance$1.INSTANCE;
    public static final OpaqueKey invocation = new OpaqueKey("provider");
    public static final OpaqueKey provider = new OpaqueKey("provider");
    public static final OpaqueKey compositionLocalMap = new OpaqueKey("compositionLocalMap");
    public static final OpaqueKey providerValues = new OpaqueKey("providerValues");
    public static final OpaqueKey providerMaps = new OpaqueKey("providers");
    public static final OpaqueKey reference = new OpaqueKey("reference");

    public static final void access$removeRange(int r1, ArrayList arrayList, int r3) {
        int findLocation = findLocation(r1, arrayList);
        if (findLocation < 0) {
            findLocation = -(findLocation + 1);
        }
        while (findLocation < arrayList.size() && ((Invalidation) arrayList.get(findLocation)).location < r3) {
            arrayList.remove(findLocation);
        }
    }

    public static final void collectNodesFrom$lambda$9$collectFromGroup(SlotReader slotReader, ArrayList arrayList, int r4) {
        if (slotReader.isNode(r4)) {
            arrayList.add(slotReader.node(r4));
            return;
        }
        int r0 = r4 + 1;
        int groupSize = slotReader.groupSize(r4) + r4;
        while (r0 < groupSize) {
            collectNodesFrom$lambda$9$collectFromGroup(slotReader, arrayList, r0);
            r0 += slotReader.groupSize(r0);
        }
    }

    public static final void composeRuntimeError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new ComposeRuntimeError(zzav$$ExternalSyntheticOutline0.m("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", message, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final int findLocation(int r4, List list) {
        int size = list.size() - 1;
        int r1 = 0;
        while (r1 <= size) {
            int r2 = (r1 + size) >>> 1;
            int compare = Intrinsics.compare(((Invalidation) list.get(r2)).location, r4);
            if (compare < 0) {
                r1 = r2 + 1;
            } else if (compare > 0) {
                size = r2 - 1;
            } else {
                return r2;
            }
        }
        return -(r1 + 1);
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(slotWriter, "<this>");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        int dataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.currentGroup));
        int[] r1 = slotWriter.groups;
        int r2 = slotWriter.currentGroup;
        SlotWriter$groupSlots$1 slotWriter$groupSlots$1 = new SlotWriter$groupSlots$1(dataIndex, slotWriter.dataIndex(r1, slotWriter.groupIndexToAddress(slotWriter.groupSize(r2) + r2)), slotWriter);
        while (slotWriter$groupSlots$1.hasNext()) {
            Object next = slotWriter$groupSlots$1.next();
            if (next instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) next);
            }
            if (next instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) next);
            }
            if (next instanceof RecomposeScopeImpl) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                RecomposeScopeOwner recomposeScopeOwner = recomposeScopeImpl.owner;
                if (recomposeScopeOwner != null) {
                    recomposeScopeOwner.recomposeScopeReleased(recomposeScopeImpl);
                }
                recomposeScopeImpl.owner = null;
                recomposeScopeImpl.trackedInstances = null;
                recomposeScopeImpl.trackedDependencies = null;
            }
        }
        slotWriter.removeGroup();
    }

    public static final void runtimeCheck(boolean z) {
        if (z) {
            return;
        }
        composeRuntimeError("Check failed".toString());
        throw null;
    }
}
