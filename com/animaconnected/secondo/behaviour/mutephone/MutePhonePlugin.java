package com.animaconnected.secondo.behaviour.mutephone;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutePhonePlugin.kt */
/* loaded from: classes3.dex */
public final class MutePhonePlugin implements BehaviourPlugin<MutePhone> {
    public static final int $stable = 8;
    private MutePhone mutePhone;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MutePhone>() { // from class: com.animaconnected.secondo.behaviour.mutephone.MutePhonePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MutePhone invoke() {
            MutePhone mutePhone;
            mutePhone = MutePhonePlugin.this.mutePhone;
            if (mutePhone != null) {
                return mutePhone;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mutePhone");
            throw null;
        }
    });
    private final String type = MutePhone.TYPE;
    private final int nameId = R.string.behaviour_name_mute_phone;
    private final int iconResourceId = R.drawable.ic_mute_phone;
    private final String[] requiredPermissions = {"android.permission.ACCESS_NOTIFICATION_POLICY"};

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = MutePhoneFragment.newInstance(slot);
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
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mutePhone = new MutePhone(context);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public MutePhone getBehaviour() {
        return (MutePhone) this.behaviour$delegate.getValue();
    }
}
