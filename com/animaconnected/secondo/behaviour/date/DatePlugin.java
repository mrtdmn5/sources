package com.animaconnected.secondo.behaviour.date;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatePlugin.kt */
/* loaded from: classes3.dex */
public final class DatePlugin implements BehaviourPlugin<Date> {
    public static final int $stable = 8;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Date>() { // from class: com.animaconnected.secondo.behaviour.date.DatePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Date invoke() {
            Date date;
            date = DatePlugin.this.date;
            if (date != null) {
                return date;
            }
            Intrinsics.throwUninitializedPropertyAccessException("date");
            throw null;
        }
    });
    private Date date;
    private final int iconResourceId;
    private final int nameId;
    private final String type;

    public DatePlugin() {
        String TYPE = Date.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        this.type = TYPE;
        this.nameId = R.string.behaviour_name_date;
        this.iconResourceId = R.drawable.ic_date;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        DateFragment newInstance = DateFragment.newInstance(slot);
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
        this.date = new Date();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Date getBehaviour() {
        return (Date) this.behaviour$delegate.getValue();
    }
}
