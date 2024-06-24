package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;

/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    public static final boolean access$getHasEmojiCompat(TextStyle textStyle) {
        EmojiSupportMatch emojiSupportMatch;
        boolean z;
        PlatformParagraphStyle platformParagraphStyle;
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        if (platformTextStyle != null && (platformParagraphStyle = platformTextStyle.paragraphStyle) != null) {
            emojiSupportMatch = new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch);
        } else {
            emojiSupportMatch = null;
        }
        if (emojiSupportMatch != null && emojiSupportMatch.value == 1) {
            z = true;
        } else {
            z = false;
        }
        return true ^ z;
    }
}
