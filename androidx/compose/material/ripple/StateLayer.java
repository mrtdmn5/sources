package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.google.android.gms.common.zzu;
import java.util.ArrayList;

/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public final class StateLayer {
    public final boolean bounded;
    public Interaction currentInteraction;
    public final State<RippleAlpha> rippleAlpha;
    public final Animatable<Float, AnimationVector1D> animatedAlpha = zzu.Animatable$default(0.0f);
    public final ArrayList interactions = new ArrayList();

    public StateLayer(MutableState mutableState, boolean z) {
        this.bounded = z;
        this.rippleAlpha = mutableState;
    }
}
