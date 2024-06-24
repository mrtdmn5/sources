package com.animaconnected.secondo.behaviour.stopwatch;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.stopwatch.Stopwatch;
import com.animaconnected.watch.device.Command;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StopwatchPlugin.kt */
/* loaded from: classes3.dex */
public final class StopwatchPlugin implements BehaviourPlugin<Stopwatch> {
    public static final int $stable = 8;
    private Stopwatch stopwatch;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Stopwatch>() { // from class: com.animaconnected.secondo.behaviour.stopwatch.StopwatchPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Stopwatch invoke() {
            Stopwatch stopwatch;
            stopwatch = StopwatchPlugin.this.stopwatch;
            if (stopwatch != null) {
                return stopwatch;
            }
            Intrinsics.throwUninitializedPropertyAccessException(Command.STOPWATCH);
            throw null;
        }
    });
    private final String type = Stopwatch.TYPE;
    private final int nameId = R.string.behaviour_name_stopwatch;
    private final String iconWatchAsset = "watch/ic_stopwatch.png";
    private final int iconResourceId = R.drawable.ic_stopwatch;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return StopwatchFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getIconWatchAsset() {
        return this.iconWatchAsset;
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
        this.stopwatch = new Stopwatch(new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.stopwatch.StopwatchPlugin$initBehaviour$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Watch currentWatch = ProviderFactory.getWatch().getWatchManager().getCurrentWatch();
                return Boolean.valueOf(currentWatch.getCapabilities().getHasStopwatch() || currentWatch.getHasDisplay());
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Stopwatch getBehaviour() {
        return (Stopwatch) this.behaviour$delegate.getValue();
    }
}
