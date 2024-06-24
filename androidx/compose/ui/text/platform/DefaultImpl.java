package androidx.compose.ui.text.platform;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmojiCompatStatus.kt */
/* loaded from: classes.dex */
public final class DefaultImpl {
    public State<Boolean> loadState;

    public DefaultImpl() {
        State<Boolean> state;
        if (EmojiCompat.isConfigured()) {
            state = getFontLoadState();
        } else {
            state = null;
        }
        this.loadState = state;
    }

    public final State<Boolean> getFontLoadState() {
        EmojiCompat emojiCompat = EmojiCompat.get();
        Intrinsics.checkNotNullExpressionValue(emojiCompat, "get()");
        if (emojiCompat.getLoadState() == 1) {
            return new ImmutableBool(true);
        }
        final ParcelableSnapshotMutableState mutableStateOf$default = Platform.mutableStateOf$default(Boolean.FALSE);
        emojiCompat.registerInitCallback(new EmojiCompat.InitCallback() { // from class: androidx.compose.ui.text.platform.DefaultImpl$getFontLoadState$initCallback$1
            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public final void onFailed() {
                this.loadState = EmojiCompatStatusKt.Falsey;
            }

            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public final void onInitialized() {
                mutableStateOf$default.setValue(Boolean.TRUE);
                this.loadState = new ImmutableBool(true);
            }
        });
        return mutableStateOf$default;
    }
}
