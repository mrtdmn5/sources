package androidx.compose.ui.platform;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import com.google.common.collect.Platform;

/* compiled from: WindowInfo.kt */
/* loaded from: classes.dex */
public final class WindowInfoImpl implements WindowInfo {
    public static final ParcelableSnapshotMutableState GlobalKeyboardModifiers = Platform.mutableStateOf$default(new PointerKeyboardModifiers(0));
    public final ParcelableSnapshotMutableState _isWindowFocused = Platform.mutableStateOf$default(Boolean.FALSE);
}
