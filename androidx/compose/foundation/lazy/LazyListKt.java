package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorsKt;

/* compiled from: LazyList.kt */
/* loaded from: classes.dex */
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0291 A[LOOP:0: B:74:0x028d->B:76:0x0291, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0364 A[LOOP:1: B:91:0x0361->B:93:0x0364, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0375 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LazyList(final androidx.compose.ui.Modifier r26, final androidx.compose.foundation.lazy.LazyListState r27, final androidx.compose.foundation.layout.PaddingValues r28, final boolean r29, final boolean r30, final androidx.compose.foundation.gestures.FlingBehavior r31, final boolean r32, int r33, androidx.compose.ui.Alignment.Horizontal r34, androidx.compose.foundation.layout.Arrangement.Vertical r35, androidx.compose.ui.Alignment.Vertical r36, androidx.compose.foundation.layout.Arrangement.Horizontal r37, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void ScrollPositionUpdater(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, Composer composer, final int r7) {
        int r0;
        int r1;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-331135862);
        if ((r7 & 14) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r7;
        } else {
            r0 = r7;
        }
        if ((r7 & 112) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            LazyListItemProvider invoke = function0.invoke();
            if (invoke.getItemCount() > 0) {
                SaverKt$Saver$1 saverKt$Saver$1 = LazyListState.Saver;
                Snapshot createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(SnapshotKt.threadSnapshot.get(), null, false);
                try {
                    Snapshot makeCurrent = createTransparentSnapshotWithNoParentReadObserver.makeCurrent();
                    try {
                        int intValue = lazyListState.scrollPosition.index$delegate.getIntValue();
                        createTransparentSnapshotWithNoParentReadObserver.dispose();
                        LazyListScrollPosition lazyListScrollPosition = lazyListState.scrollPosition;
                        lazyListScrollPosition.getClass();
                        int findIndexByKey = ArrayIteratorsKt.findIndexByKey(invoke, lazyListScrollPosition.lastKnownFirstItemKey, intValue);
                        if (intValue != findIndexByKey) {
                            lazyListScrollPosition.index$delegate.setIntValue(findIndexByKey);
                            lazyListScrollPosition.nearestRangeState.update(intValue);
                        }
                    } finally {
                        Snapshot.restoreCurrent(makeCurrent);
                    }
                } catch (Throwable th) {
                    createTransparentSnapshotWithNoParentReadObserver.dispose();
                    throw th;
                }
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r7 | 1);
                    LazyListKt.ScrollPositionUpdater(function0, lazyListState, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
