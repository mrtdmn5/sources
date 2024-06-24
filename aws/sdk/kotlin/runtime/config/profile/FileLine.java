package aws.sdk.kotlin.runtime.config.profile;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContinuationMerger.kt */
/* loaded from: classes.dex */
public final class FileLine {
    public final String content;
    public final int lineNumber;

    public FileLine(int r2, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.lineNumber = r2;
        this.content = content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileLine)) {
            return false;
        }
        FileLine fileLine = (FileLine) obj;
        if (this.lineNumber == fileLine.lineNumber && Intrinsics.areEqual(this.content, fileLine.content)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.content.hashCode() + (Integer.hashCode(this.lineNumber) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FileLine(lineNumber=");
        sb.append(this.lineNumber);
        sb.append(", content=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.content, ')');
    }
}
