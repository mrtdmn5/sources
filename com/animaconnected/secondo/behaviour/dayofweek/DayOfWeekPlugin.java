package com.animaconnected.secondo.behaviour.dayofweek;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DayOfWeekPlugin.kt */
/* loaded from: classes3.dex */
public final class DayOfWeekPlugin implements BehaviourPlugin<DayOfWeek> {
    public static final int $stable = 8;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DayOfWeek>() { // from class: com.animaconnected.secondo.behaviour.dayofweek.DayOfWeekPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DayOfWeek invoke() {
            DayOfWeek dayOfWeek;
            dayOfWeek = DayOfWeekPlugin.this.dayOfWeek;
            if (dayOfWeek != null) {
                return dayOfWeek;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dayOfWeek");
            throw null;
        }
    });
    private DayOfWeek dayOfWeek;
    private final int iconResourceId;
    private final int nameId;
    private final String type;

    public DayOfWeekPlugin() {
        String TYPE = DayOfWeek.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        this.type = TYPE;
        this.nameId = R.string.behaviour_name_day_of_week;
        this.iconResourceId = R.drawable.ic_day_of_week;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        DayOfWeekFragment newInstance = DayOfWeekFragment.newInstance(slot);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
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
        this.dayOfWeek = new DayOfWeek();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public DayOfWeek getBehaviour() {
        return (DayOfWeek) this.behaviour$delegate.getValue();
    }
}
