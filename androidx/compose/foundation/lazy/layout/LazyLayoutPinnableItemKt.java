package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutPinnableItem.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPinnableItemKt {
    public static final void LazyLayoutPinnableItem(final Object obj, final int r17, final LazyLayoutPinnedItemList pinnedItemList, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r21) {
        Intrinsics.checkNotNullParameter(pinnedItemList, "pinnedItemList");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-2079116560);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed(pinnedItemList);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (changed || nextSlot == composer$Companion$Empty$1) {
            nextSlot = new LazyLayoutPinnableItem(obj, pinnedItemList);
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        final LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) nextSlot;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = lazyLayoutPinnableItem.index$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyLayoutPinnableItem.parentHandle$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = lazyLayoutPinnableItem._parentPinnableContainer$delegate;
        parcelableSnapshotMutableIntState.setIntValue(r17);
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = PinnableContainerKt.LocalPinnableContainer;
        PinnableContainer pinnableContainer = (PinnableContainer) startRestartGroup.consume(dynamicProvidableCompositionLocal);
        LazyLayoutPinnableItem lazyLayoutPinnableItem2 = null;
        Snapshot createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(SnapshotKt.threadSnapshot.get(), null, false);
        try {
            Snapshot makeCurrent = createTransparentSnapshotWithNoParentReadObserver.makeCurrent();
            try {
                if (pinnableContainer != ((PinnableContainer) parcelableSnapshotMutableState2.getValue())) {
                    parcelableSnapshotMutableState2.setValue(pinnableContainer);
                    if (lazyLayoutPinnableItem.getPinsCount() > 0) {
                        PinnableContainer.PinnedHandle pinnedHandle = (PinnableContainer.PinnedHandle) parcelableSnapshotMutableState.getValue();
                        if (pinnedHandle != null) {
                            pinnedHandle.release();
                        }
                        if (pinnableContainer != null) {
                            lazyLayoutPinnableItem2 = pinnableContainer.pin();
                        }
                        parcelableSnapshotMutableState.setValue(lazyLayoutPinnableItem2);
                    }
                }
                Unit unit = Unit.INSTANCE;
                Snapshot.restoreCurrent(makeCurrent);
                createTransparentSnapshotWithNoParentReadObserver.dispose();
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed2 = startRestartGroup.changed(lazyLayoutPinnableItem);
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (changed2 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            DisposableEffectScope DisposableEffect = disposableEffectScope;
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final LazyLayoutPinnableItem lazyLayoutPinnableItem3 = LazyLayoutPinnableItem.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public final void dispose() {
                                    LazyLayoutPinnableItem lazyLayoutPinnableItem4 = LazyLayoutPinnableItem.this;
                                    int pinsCount = lazyLayoutPinnableItem4.getPinsCount();
                                    for (int r2 = 0; r2 < pinsCount; r2++) {
                                        lazyLayoutPinnableItem4.release();
                                    }
                                }
                            };
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                EffectsKt.DisposableEffect(lazyLayoutPinnableItem, (Function1) nextSlot2, startRestartGroup);
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{dynamicProvidableCompositionLocal.provides(lazyLayoutPinnableItem)}, content, startRestartGroup, ((r21 >> 6) & 112) | 8);
                RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer2, Integer num) {
                            num.intValue();
                            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(obj, r17, pinnedItemList, content, composer2, Strings.updateChangedFlags(r21 | 1));
                            return Unit.INSTANCE;
                        }
                    };
                }
            } catch (Throwable th) {
                Snapshot.restoreCurrent(makeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            createTransparentSnapshotWithNoParentReadObserver.dispose();
            throw th2;
        }
    }
}
