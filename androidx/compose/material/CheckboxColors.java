package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.state.ToggleableState;

/* compiled from: Checkbox.kt */
/* loaded from: classes.dex */
public interface CheckboxColors {
    State borderColor(boolean z, ToggleableState toggleableState, Composer composer);

    State boxColor(boolean z, ToggleableState toggleableState, Composer composer);

    State checkmarkColor(ToggleableState toggleableState, Composer composer);
}
