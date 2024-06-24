package androidx.compose.ui.text.input;

import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.input.AndroidTextInputServicePlugin;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;

/* compiled from: PlatformTextInputAdapter.android.kt */
/* loaded from: classes.dex */
public interface PlatformTextInputPlugin<T extends PlatformTextInputAdapter> {
    AndroidTextInputServicePlugin.Adapter createAdapter(AndroidComposeView androidComposeView, PlatformTextInput platformTextInput);
}
