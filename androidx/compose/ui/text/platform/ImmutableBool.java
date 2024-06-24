package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;

/* compiled from: EmojiCompatStatus.kt */
/* loaded from: classes.dex */
public final class ImmutableBool implements State<Boolean> {
    public final boolean value;

    public ImmutableBool(boolean z) {
        this.value = z;
    }

    @Override // androidx.compose.runtime.State
    public final Boolean getValue() {
        return Boolean.valueOf(this.value);
    }
}
