package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.animaconnected.watch.image.Kolors;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    public boolean mAllowStacking;
    public int mLastWidthSize;
    public boolean mStacked;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastWidthSize = -1;
        int[] r3 = R$styleable.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r3);
        ViewCompat.saveAttributeDataForStyleable(this, context, r3, attributeSet, obtainStyledAttributes, 0);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.mAllowStacking);
        }
    }

    private void setStacked(boolean z) {
        int r0;
        int r2;
        if (this.mStacked != z) {
            if (!z || this.mAllowStacking) {
                this.mStacked = z;
                setOrientation(z ? 1 : 0);
                if (z) {
                    r0 = 8388613;
                } else {
                    r0 = 80;
                }
                setGravity(r0);
                View findViewById = findViewById(R.id.spacer);
                if (findViewById != null) {
                    if (z) {
                        r2 = 8;
                    } else {
                        r2 = 4;
                    }
                    findViewById.setVisibility(r2);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        int r0;
        boolean z;
        int r4;
        int paddingBottom;
        boolean z2;
        int size = View.MeasureSpec.getSize(r8);
        int r2 = 0;
        if (this.mAllowStacking) {
            if (size > this.mLastWidthSize && this.mStacked) {
                setStacked(false);
            }
            this.mLastWidthSize = size;
        }
        if (!this.mStacked && View.MeasureSpec.getMode(r8) == 1073741824) {
            r0 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        } else {
            r0 = r8;
            z = false;
        }
        super.onMeasure(r0, r9);
        if (this.mAllowStacking && !this.mStacked) {
            if ((getMeasuredWidthAndState() & Kolors.black) == 16777216) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(r8, r9);
        }
        int childCount = getChildCount();
        int r1 = 0;
        while (true) {
            r4 = -1;
            if (r1 < childCount) {
                if (getChildAt(r1).getVisibility() == 0) {
                    break;
                } else {
                    r1++;
                }
            } else {
                r1 = -1;
                break;
            }
        }
        if (r1 >= 0) {
            View childAt = getChildAt(r1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            r2 = 0 + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.mStacked) {
                int r12 = r1 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (r12 >= childCount2) {
                        break;
                    }
                    if (getChildAt(r12).getVisibility() == 0) {
                        r4 = r12;
                        break;
                    }
                    r12++;
                }
                if (r4 >= 0) {
                    paddingBottom = getChildAt(r4).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                paddingBottom = getPaddingBottom();
            }
            r2 += paddingBottom;
        }
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api16Impl.getMinimumHeight(this) != r2) {
            setMinimumHeight(r2);
            if (r9 == 0) {
                super.onMeasure(r8, r9);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.mAllowStacking != z) {
            this.mAllowStacking = z;
            if (!z && this.mStacked) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
