package com.animaconnected.secondo.behaviour;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;

/* compiled from: BehaviourPlugin.kt */
/* loaded from: classes3.dex */
public interface BehaviourPlugin<K extends Behaviour> {
    Fragment createFragment(Slot slot);

    K getBehaviour();

    default int getConfigurationDescription() {
        return -1;
    }

    default int getIconResourceId() {
        return -1;
    }

    default String getIconWatchAsset() {
        return "";
    }

    int getNameId();

    default RemoteMessageReceiver getRemoteMessageReceiver() {
        return null;
    }

    default String[] getRequiredPermissions() {
        return new String[0];
    }

    String getType();

    void initBehaviour(Context context);

    default boolean isConfigured() {
        return true;
    }

    default boolean isNew() {
        return false;
    }

    default boolean shouldTintIcon() {
        return true;
    }

    default void acceptNewFeature() {
    }
}
