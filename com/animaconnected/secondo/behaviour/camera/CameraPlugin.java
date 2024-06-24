package com.animaconnected.secondo.behaviour.camera;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.Camera;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraPlugin.kt */
/* loaded from: classes3.dex */
public final class CameraPlugin implements BehaviourPlugin<Camera> {
    public static final int $stable = 8;
    private Camera camera;
    private final String sharedPrefName = "camera_plugin";
    private final String keyIsNew = "camera_is_new";
    private final SharedPreferences sharedPreferences = KronabyApplication.Companion.getContext().getSharedPreferences("camera_plugin", 0);
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Camera>() { // from class: com.animaconnected.secondo.behaviour.camera.CameraPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Camera invoke() {
            Camera camera;
            camera = CameraPlugin.this.camera;
            if (camera != null) {
                return camera;
            }
            Intrinsics.throwUninitializedPropertyAccessException("camera");
            throw null;
        }
    });
    private final String type = Camera.TYPE;
    private final int nameId = R.string.behaviour_name_camera;
    private final int iconResourceId = R.drawable.ic_camera;
    private final String iconWatchAsset = "watch/ic_camera.png";

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void acceptNewFeature() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(this.keyIsNew, false);
        edit.apply();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return CameraFragment.Companion.newInstance(slot);
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
        this.camera = new Camera(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean isNew() {
        return this.sharedPreferences.getBoolean(this.keyIsNew, true);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Camera getBehaviour() {
        return (Camera) this.behaviour$delegate.getValue();
    }
}
