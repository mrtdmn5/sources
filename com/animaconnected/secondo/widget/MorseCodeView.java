package com.animaconnected.secondo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.DpUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MorseCodeView.kt */
/* loaded from: classes3.dex */
public final class MorseCodeView extends LinearLayout {
    public static final int $stable = 0;
    private final int drawableHold;
    private final int drawablePress;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public MorseCodeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void addImage(int r4, boolean z) {
        int r5;
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setImageResource(r4);
        if (z) {
            DpUtils dpUtils = DpUtils.INSTANCE;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            r5 = dpUtils.dpToPx(context, 8.0f);
        } else {
            r5 = 0;
        }
        imageView.setPadding(r5, 0, 0, 0);
        addView(imageView);
    }

    public final void setPattern(String pattern) {
        boolean z;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        removeAllViews();
        char[] charArray = pattern.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        int length = charArray.length;
        int r2 = 0;
        int r3 = 0;
        while (r2 < length) {
            char c = charArray[r2];
            int r5 = r3 + 1;
            if (r3 != 0) {
                z = true;
            } else {
                z = false;
            }
            if (c == '.') {
                addImage(this.drawablePress, z);
            } else if (c == '-') {
                addImage(this.drawableHold, z);
            }
            r2++;
            r3 = r5;
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public MorseCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MorseCodeView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MorseCodeView(Context context, AttributeSet attributeSet, int r5) {
        super(context, attributeSet, r5);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MorseCodeView, r5, r5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes.hasValue(1) && obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.hasValue(2)) {
            String string = obtainStyledAttributes.getString(1);
            string = string == null ? "" : string;
            this.drawablePress = obtainStyledAttributes.getResourceId(2, -1);
            this.drawableHold = obtainStyledAttributes.getResourceId(0, -1);
            setPattern(string);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("Missing attribute".toString());
    }
}
