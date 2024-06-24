package com.animaconnected.secondo.behaviour.music;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MusicWatchAppPlugin.kt */
/* loaded from: classes3.dex */
public final class MusicWatchAppPlugin implements BehaviourPlugin<MusicWatchAppAndroid> {
    public static final int $stable = 8;
    private MusicWatchAppAndroid musicWatchApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MusicWatchAppAndroid>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MusicWatchAppAndroid invoke() {
            MusicWatchAppAndroid musicWatchAppAndroid;
            musicWatchAppAndroid = MusicWatchAppPlugin.this.musicWatchApp;
            if (musicWatchAppAndroid != null) {
                return musicWatchAppAndroid;
            }
            Intrinsics.throwUninitializedPropertyAccessException("musicWatchApp");
            throw null;
        }
    });
    private final String type = "MusicDisplay";
    private final int nameId = R.string.behaviour_name_music;
    private final int iconResourceId = R.drawable.ic_music;
    private final String iconWatchAsset = "watch/ic_music.png";
    private final String[] requiredPermissions = {"android.permission.ACCESS_NOTIFICATION_POLICY"};

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
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.musicWatchApp = new MusicWatchAppAndroid(new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppPlugin$initBehaviour$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                MusicWatchAppAndroid musicWatchAppAndroid;
                MusicWatchAppPlugin musicWatchAppPlugin = MusicWatchAppPlugin.this;
                Context context2 = context;
                musicWatchAppAndroid = musicWatchAppPlugin.musicWatchApp;
                if (musicWatchAppAndroid != null) {
                    return Boolean.valueOf(!BehaviourPluginKt.showFeatureIssueNotification(musicWatchAppPlugin, context2, musicWatchAppAndroid.getTitle().app()));
                }
                Intrinsics.throwUninitializedPropertyAccessException("musicWatchApp");
                throw null;
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public BaseDetailsFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = MusicFragment.newInstance(slot, getType());
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public MusicWatchAppAndroid getBehaviour() {
        return (MusicWatchAppAndroid) this.behaviour$delegate.getValue();
    }
}
