package com.animaconnected.secondo.behaviour.quickaction;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.quickaction.QuickActionApp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickActionPlugin.kt */
/* loaded from: classes3.dex */
public final class QuickActionPlugin implements BehaviourPlugin<QuickActionApp> {
    public static final int $stable = 8;
    private QuickActionApp quickactionApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<QuickActionApp>() { // from class: com.animaconnected.secondo.behaviour.quickaction.QuickActionPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QuickActionApp invoke() {
            QuickActionApp quickActionApp;
            quickActionApp = QuickActionPlugin.this.quickactionApp;
            if (quickActionApp != null) {
                return quickActionApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("quickactionApp");
            throw null;
        }
    });
    private final String type = QuickActionApp.TYPE;
    private final int nameId = -1;
    private final int iconResourceId = -1;

    /* renamed from: createFragment, reason: collision with other method in class */
    public Void m786createFragment(Slot slot) {
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
        this.quickactionApp = new QuickActionApp();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public /* bridge */ /* synthetic */ Fragment createFragment(Slot slot) {
        return (Fragment) m786createFragment(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public QuickActionApp getBehaviour() {
        return (QuickActionApp) this.behaviour$delegate.getValue();
    }
}
