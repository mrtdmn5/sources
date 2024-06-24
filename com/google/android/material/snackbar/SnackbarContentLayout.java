package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class SnackbarContentLayout extends LinearLayout {
    public Button actionView;
    public int maxInlineActionWidth;
    public TextView messageView;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:            if (updateViewsWithinLayout(1, r0, r0 - r2) != false) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:            r1 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:            if (r1 == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:            super.onMeasure(r8, r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:            if (updateViewsWithinLayout(0, r0, r0) != false) goto L24;     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            r2 = 2131165341(0x7f07009d, float:1.7944896E38)
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2131165340(0x7f07009c, float:1.7944894E38)
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.messageView
            android.text.Layout r3 = r3.getLayout()
            int r3 = r3.getLineCount()
            r4 = 0
            if (r3 <= r1) goto L30
            r3 = r1
            goto L31
        L30:
            r3 = r4
        L31:
            if (r3 == 0) goto L4a
            int r5 = r7.maxInlineActionWidth
            if (r5 <= 0) goto L4a
            android.widget.Button r5 = r7.actionView
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.maxInlineActionWidth
            if (r5 <= r6) goto L4a
            int r2 = r0 - r2
            boolean r0 = r7.updateViewsWithinLayout(r1, r0, r2)
            if (r0 == 0) goto L55
            goto L56
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r2
        L4e:
            boolean r0 = r7.updateViewsWithinLayout(r4, r0, r0)
            if (r0 == 0) goto L55
            goto L56
        L55:
            r1 = r4
        L56:
            if (r1 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int r1) {
        this.maxInlineActionWidth = r1;
    }

    public final boolean updateViewsWithinLayout(int r4, int r5, int r6) {
        boolean z;
        if (r4 != getOrientation()) {
            setOrientation(r4);
            z = true;
        } else {
            z = false;
        }
        if (this.messageView.getPaddingTop() == r5 && this.messageView.getPaddingBottom() == r6) {
            return z;
        }
        TextView textView = this.messageView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api17Impl.isPaddingRelative(textView)) {
            ViewCompat.Api17Impl.setPaddingRelative(textView, ViewCompat.Api17Impl.getPaddingStart(textView), r5, ViewCompat.Api17Impl.getPaddingEnd(textView), r6);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), r5, textView.getPaddingRight(), r6);
        return true;
    }
}
