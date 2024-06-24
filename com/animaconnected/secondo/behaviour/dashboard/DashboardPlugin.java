package com.animaconnected.secondo.behaviour.dashboard;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.DashboardApp;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardPlugin.kt */
/* loaded from: classes3.dex */
public final class DashboardPlugin implements BehaviourPlugin<DashboardApp> {
    public static final int $stable = 8;
    private DashboardApp dashboardApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DashboardApp>() { // from class: com.animaconnected.secondo.behaviour.dashboard.DashboardPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DashboardApp invoke() {
            DashboardApp dashboardApp;
            dashboardApp = DashboardPlugin.this.dashboardApp;
            if (dashboardApp != null) {
                return dashboardApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dashboardApp");
            throw null;
        }
    });
    private final String type = DashboardApp.TYPE;
    private final int nameId = -1;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return null;
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
        this.dashboardApp = new DashboardApp(new Function0<FitnessProvider.Profile.Temperature>() { // from class: com.animaconnected.secondo.behaviour.dashboard.DashboardPlugin$initBehaviour$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FitnessProvider.Profile.Temperature invoke() {
                return ProviderFactory.getWatch().fitness().getProfile().getTemperatureUnit();
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public DashboardApp getBehaviour() {
        return (DashboardApp) this.behaviour$delegate.getValue();
    }
}
