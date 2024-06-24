package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    public final int mClickableSpanActionId;
    public final AccessibilityNodeInfoCompat mNodeInfoCompat;
    public final int mOriginalClickableSpanId;

    public AccessibilityClickableSpanCompat(int r1, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int r3) {
        this.mOriginalClickableSpanId = r1;
        this.mNodeInfoCompat = accessibilityNodeInfoCompat;
        this.mClickableSpanActionId = r3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.mInfo.performAction(this.mClickableSpanActionId, bundle);
    }
}
