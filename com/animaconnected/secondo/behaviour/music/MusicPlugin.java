package com.animaconnected.secondo.behaviour.music;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MusicPlugin.kt */
/* loaded from: classes3.dex */
public final class MusicPlugin implements BehaviourPlugin<Music> {
    public static final int $stable = 8;
    private Music music;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Music>() { // from class: com.animaconnected.secondo.behaviour.music.MusicPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Music invoke() {
            Music music;
            music = MusicPlugin.this.music;
            if (music != null) {
                return music;
            }
            Intrinsics.throwUninitializedPropertyAccessException("music");
            throw null;
        }
    });
    private final String type = Music.TYPE;
    private final int nameId = R.string.behaviour_name_music;
    private final int iconResourceId = R.drawable.ic_music;

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
        this.music = new Music(MusicProvider.INSTANCE);
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
    public Music getBehaviour() {
        return (Music) this.behaviour$delegate.getValue();
    }
}
