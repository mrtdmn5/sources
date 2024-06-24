package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public final class PointerIconModifierLocal implements PointerIcon, ModifierLocalProvider<PointerIconModifierLocal>, ModifierLocalConsumer {
    public PointerIcon icon;
    public boolean isHovered;
    public boolean isPaused;
    public final ProvidableModifierLocal<PointerIconModifierLocal> key;
    public Function1<? super PointerIcon, Unit> onSetIcon;
    public boolean overrideDescendants;
    public final ParcelableSnapshotMutableState parentInfo$delegate;
    public final PointerIconModifierLocal value;

    public PointerIconModifierLocal(PointerIcon icon, boolean z, PointerIconKt$pointerHoverIcon$2$onSetIcon$1 pointerIconKt$pointerHoverIcon$2$onSetIcon$1) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.icon = icon;
        this.overrideDescendants = z;
        this.onSetIcon = pointerIconKt$pointerHoverIcon$2$onSetIcon$1;
        this.parentInfo$delegate = Platform.mutableStateOf$default(null);
        this.key = PointerIconKt.ModifierLocalPointerIcon;
        this.value = this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final ProvidableModifierLocal<PointerIconModifierLocal> getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PointerIconModifierLocal getParentInfo() {
        return (PointerIconModifierLocal) this.parentInfo$delegate.getValue();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final PointerIconModifierLocal getValue() {
        return this.value;
    }

    public final boolean hasOverride() {
        boolean z;
        if (this.overrideDescendants) {
            return true;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null && parentInfo.hasOverride()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public final void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        PointerIconModifierLocal parentInfo = getParentInfo();
        this.parentInfo$delegate.setValue((PointerIconModifierLocal) scope.getCurrent(PointerIconKt.ModifierLocalPointerIcon));
        if (parentInfo != null && getParentInfo() == null) {
            if (this.isHovered) {
                parentInfo.reassignIcon();
            }
            this.isHovered = false;
            this.onSetIcon = new Function1<PointerIcon, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconModifierLocal$onModifierLocalsUpdated$1$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PointerIcon pointerIcon) {
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public final void pause() {
        this.isPaused = true;
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
    }

    public final void reassignIcon() {
        this.isPaused = false;
        if (this.isHovered) {
            this.onSetIcon.invoke(this.icon);
            return;
        }
        if (getParentInfo() == null) {
            this.onSetIcon.invoke(null);
            return;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.reassignIcon();
        }
    }
}
