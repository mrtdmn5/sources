package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;

/* compiled from: Slider.kt */
/* loaded from: classes.dex */
public interface SliderColors {
    MutableState thumbColor(boolean z, Composer composer);

    MutableState tickColor(boolean z, boolean z2, Composer composer);

    MutableState trackColor(boolean z, boolean z2, Composer composer);
}
