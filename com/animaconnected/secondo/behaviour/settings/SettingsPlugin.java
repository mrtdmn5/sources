package com.animaconnected.secondo.behaviour.settings;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.settings.SettingsApp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsPlugin.kt */
/* loaded from: classes3.dex */
public final class SettingsPlugin implements BehaviourPlugin<SettingsApp> {
    public static final int $stable = 8;
    private SettingsApp settingsApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SettingsApp>() { // from class: com.animaconnected.secondo.behaviour.settings.SettingsPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SettingsApp invoke() {
            SettingsApp settingsApp;
            settingsApp = SettingsPlugin.this.settingsApp;
            if (settingsApp != null) {
                return settingsApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("settingsApp");
            throw null;
        }
    });
    private final String type = SettingsApp.TYPE;
    private final int nameId = -1;
    private final int iconResourceId = -1;

    /* renamed from: createFragment, reason: collision with other method in class */
    public Void m789createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return null;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.settingsApp = new SettingsApp();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public /* bridge */ /* synthetic */ Fragment createFragment(Slot slot) {
        return (Fragment) m789createFragment(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public SettingsApp getBehaviour() {
        return (SettingsApp) this.behaviour$delegate.getValue();
    }
}
