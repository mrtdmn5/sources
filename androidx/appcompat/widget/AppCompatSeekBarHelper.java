package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.view.ViewCompat;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public final class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    public boolean mHasTickMarkTint;
    public boolean mHasTickMarkTintMode;
    public Drawable mTickMark;
    public ColorStateList mTickMarkTintList;
    public PorterDuff.Mode mTickMarkTintMode;
    public final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    public final void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                Drawable mutate = drawable.mutate();
                this.mTickMark = mutate;
                if (this.mHasTickMarkTint) {
                    DrawableCompat$Api21Impl.setTintList(mutate, this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(this.mTickMark, this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(this.mView.getDrawableState());
                }
            }
        }
    }

    public final void drawTickMarks(Canvas canvas) {
        int r3;
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            int r2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    r3 = intrinsicWidth / 2;
                } else {
                    r3 = 1;
                }
                if (intrinsicHeight >= 0) {
                    r2 = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-r3, -r2, r3, r2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int r0 = 0; r0 <= max; r0++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public final void loadFromAttributes(AttributeSet attributeSet, int r9) {
        super.loadFromAttributes(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.mView;
        Context context = seekBar.getContext();
        int[] r2 = R$styleable.AppCompatSeekBar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, r2, R.attr.seekBarStyle);
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), r2, attributeSet, obtainStyledAttributes.mWrapped, R.attr.seekBarStyle);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            seekBar.setThumb(drawableIfKnown);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(seekBar);
            DrawableCompat$Api23Impl.setLayoutDirection(drawable, ViewCompat.Api17Impl.getLayoutDirection(seekBar));
            if (drawable.isStateful()) {
                drawable.setState(seekBar.getDrawableState());
            }
            applyTickMarkTint();
        }
        seekBar.invalidate();
        if (obtainStyledAttributes.hasValue(3)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(3, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(2);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }
}
