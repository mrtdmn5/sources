package androidx.compose.ui.text.input;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.platform.AndroidComposeView$platformTextInputPluginRegistry$1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: PlatformTextInputAdapter.kt */
/* loaded from: classes.dex */
public final class PlatformTextInputPluginRegistryImpl implements PlatformTextInputPluginRegistry {
    public final SnapshotStateMap<PlatformTextInputPlugin<?>, AdapterWithRefCount<?>> adaptersByPlugin = new SnapshotStateMap<>();
    public final Function2<PlatformTextInputPlugin<?>, PlatformTextInput, PlatformTextInputAdapter> factory;
    public PlatformTextInputPlugin<?> focusedPlugin;

    /* compiled from: PlatformTextInputAdapter.kt */
    /* loaded from: classes.dex */
    public final class AdapterInput implements PlatformTextInput {
        public final PlatformTextInputPlugin<?> plugin;
        public final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterInput(PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl) {
            AndroidTextInputServicePlugin androidTextInputServicePlugin = AndroidTextInputServicePlugin.INSTANCE;
            this.this$0 = platformTextInputPluginRegistryImpl;
            this.plugin = androidTextInputServicePlugin;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public final void releaseInputFocus() {
            PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl = this.this$0;
            if (Intrinsics.areEqual(platformTextInputPluginRegistryImpl.focusedPlugin, this.plugin)) {
                platformTextInputPluginRegistryImpl.focusedPlugin = null;
            }
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public final void requestInputFocus() {
            this.this$0.focusedPlugin = this.plugin;
        }
    }

    /* compiled from: PlatformTextInputAdapter.kt */
    /* loaded from: classes.dex */
    public final class AdapterWithRefCount<T extends PlatformTextInputAdapter> {
        public final T adapter;
        public final ParcelableSnapshotMutableIntState refCount$delegate = UStringsKt.mutableIntStateOf(0);

        public AdapterWithRefCount(T t) {
            this.adapter = t;
        }
    }

    public PlatformTextInputPluginRegistryImpl(AndroidComposeView$platformTextInputPluginRegistry$1 androidComposeView$platformTextInputPluginRegistry$1) {
        this.factory = androidComposeView$platformTextInputPluginRegistry$1;
    }
}
