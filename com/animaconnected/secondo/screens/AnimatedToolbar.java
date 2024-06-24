package com.animaconnected.secondo.screens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import com.animaconnected.secondo.utils.UIUtility;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class AnimatedToolbar extends Toolbar {
    private Drawable mBackDrawable;
    private final Context mContext;
    private int mCurrentTintedColor;
    private ImageView mHelpAction;
    private TextView mToolbarAction;
    private TextView mToolbarTitle;
    private View touchAreaHelpButton;

    public AnimatedToolbar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        Context context = this.mContext;
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_chevron_left);
        if (drawable != null) {
            this.mBackDrawable = drawable.mutate();
        }
    }

    public TextView enableActionText(boolean z) {
        if (z) {
            TextView textView = (TextView) findViewById(R.id.toolbar_action);
            this.mToolbarAction = textView;
            textView.setVisibility(0);
        } else {
            TextView textView2 = this.mToolbarAction;
            if (textView2 != null) {
                textView2.setVisibility(8);
                this.mToolbarAction = null;
            }
        }
        return this.mToolbarAction;
    }

    public Drawable getBackDrawable() {
        return this.mBackDrawable;
    }

    public void setBackDrawable(Drawable drawable) {
        this.mBackDrawable = drawable;
        UIUtility.setColorIntFilter(drawable, this.mCurrentTintedColor, BlendModeCompat.SRC_ATOP);
    }

    public void setHelpActionDrawable(Drawable drawable) {
        if (this.mHelpAction == null) {
            this.mHelpAction = (ImageView) findViewById(R.id.help_button);
        }
        if (this.touchAreaHelpButton == null) {
            this.touchAreaHelpButton = findViewById(R.id.touch_area_help_button);
        }
        this.touchAreaHelpButton.setVisibility(0);
        UIUtility.setColorIntFilter(drawable, this.mCurrentTintedColor, BlendModeCompat.SRC_ATOP);
        this.mHelpAction.setImageDrawable(drawable);
    }

    public void setTintColor(int r3) {
        this.mCurrentTintedColor = r3;
        if (this.mToolbarTitle == null) {
            this.mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        }
        if (this.mToolbarAction == null) {
            this.mToolbarAction = (TextView) findViewById(R.id.toolbar_action);
        }
        this.mToolbarTitle.setTextColor(r3);
        this.mToolbarAction.setTextColor(r3);
        UIUtility.setColorIntFilter(this.mBackDrawable, r3, BlendModeCompat.SRC_ATOP);
    }

    public AnimatedToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public AnimatedToolbar(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mContext = context;
        init();
    }
}
