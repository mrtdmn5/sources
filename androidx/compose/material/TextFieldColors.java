package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;

/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public interface TextFieldColors {
    MutableState backgroundColor(Composer composer);

    MutableState cursorColor(boolean z, Composer composer);

    State<Color> indicatorColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r5);

    MutableState labelColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int r5);

    MutableState leadingIconColor(boolean z, boolean z2, Composer composer);

    MutableState placeholderColor(boolean z, Composer composer);

    MutableState textColor(boolean z, Composer composer);

    MutableState trailingIconColor(boolean z, boolean z2, Composer composer);
}
