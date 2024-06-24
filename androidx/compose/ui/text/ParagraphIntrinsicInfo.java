package androidx.compose.ui.text;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraphIntrinsics.kt */
/* loaded from: classes.dex */
public final class ParagraphIntrinsicInfo {
    public final int endIndex;
    public final ParagraphIntrinsics intrinsics;
    public final int startIndex;

    public ParagraphIntrinsicInfo(AndroidParagraphIntrinsics androidParagraphIntrinsics, int r2, int r3) {
        this.intrinsics = androidParagraphIntrinsics;
        this.startIndex = r2;
        this.endIndex = r3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphIntrinsicInfo)) {
            return false;
        }
        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
        if (Intrinsics.areEqual(this.intrinsics, paragraphIntrinsicInfo.intrinsics) && this.startIndex == paragraphIntrinsicInfo.startIndex && this.endIndex == paragraphIntrinsicInfo.endIndex) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.endIndex) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.startIndex, this.intrinsics.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphIntrinsicInfo(intrinsics=");
        sb.append(this.intrinsics);
        sb.append(", startIndex=");
        sb.append(this.startIndex);
        sb.append(", endIndex=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.endIndex, ')');
    }
}
