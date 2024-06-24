package com.animaconnected.secondo.behaviour;

import android.content.Context;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import java.util.List;

/* compiled from: BehaviourFactory.kt */
/* loaded from: classes3.dex */
public interface BehaviourFactory {
    List<Behaviour> getAllBehaviours();

    List<BehaviourPlugin<Behaviour>> getAllPlugins(Slot slot, Watch watch);

    Behaviour getBehaviour(String str);

    BehaviourPlugin<Behaviour> getPlugin(String str);

    List<RemoteMessageReceiver> getRemoteMessageReceivers();

    void initBehaviours(Context context);

    boolean isBehaviourTypeEnabled(String str);
}
