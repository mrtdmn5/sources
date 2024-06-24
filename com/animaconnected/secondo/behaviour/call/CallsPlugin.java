package com.animaconnected.secondo.behaviour.call;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.onboarding.permissions.CallsPermissionFragmentKt;
import com.animaconnected.watch.Slot;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallsPlugin.kt */
/* loaded from: classes3.dex */
public final class CallsPlugin implements BehaviourPlugin<CallsWatchAppAndroid> {
    public static final int $stable = 8;
    private CallsWatchAppAndroid callsWatchAppAndroid;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CallsWatchAppAndroid>() { // from class: com.animaconnected.secondo.behaviour.call.CallsPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CallsWatchAppAndroid invoke() {
            CallsWatchAppAndroid callsWatchAppAndroid;
            callsWatchAppAndroid = CallsPlugin.this.callsWatchAppAndroid;
            if (callsWatchAppAndroid != null) {
                return callsWatchAppAndroid;
            }
            Intrinsics.throwUninitializedPropertyAccessException("callsWatchAppAndroid");
            throw null;
        }
    });
    private final String type = "CallsDisplay";
    private final int nameId = -1;
    private final String[] requiredPermissions = (String[]) CallsPermissionFragmentKt.getCallPermissions().toArray(new String[0]);

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
        this.callsWatchAppAndroid = new CallsWatchAppAndroid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public CallsWatchAppAndroid getBehaviour() {
        return (CallsWatchAppAndroid) this.behaviour$delegate.getValue();
    }
}
