package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    public boolean mAllowTextWithIcon;
    public boolean mExpandedFormat;
    public ActionMenuItemForwardingListener mForwardingListener;
    public Drawable mIcon;
    public MenuItemImpl mItemData;
    public MenuBuilder.ItemInvoker mItemInvoker;
    public final int mMaxIconSize;
    public final int mMinWidth;
    public PopupCallback mPopupCallback;
    public int mSavedPaddingLeft;
    public CharSequence mTitle;

    /* loaded from: classes.dex */
    public class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public final ShowableListMenu getPopup() {
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu;
            PopupCallback popupCallback = ActionMenuItemView.this.mPopupCallback;
            if (popupCallback == null || (actionButtonSubmenu = ActionMenuPresenter.this.mActionButtonPopup) == null) {
                return null;
            }
            return actionButtonSubmenu.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public final boolean onForwardingStarted() {
            ShowableListMenu popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.mItemInvoker;
            if (itemInvoker == null || !itemInvoker.invokeItem(actionMenuItemView.mItemData) || (popup = getPopup()) == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PopupCallback {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl) {
        int r0;
        this.mItemData = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleCondensed());
        setId(menuItemImpl.mId);
        if (menuItemImpl.isVisible()) {
            r0 = 0;
        } else {
            r0 = 8;
        }
        setVisibility(r0);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public final boolean needsDividerBefore() {
        if (hasText() && this.mItemData.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.mItemInvoker;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.mItemData);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r62;
        int r1;
        boolean hasText = hasText();
        if (hasText && (r1 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(r1, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(r6, r7);
        int mode = View.MeasureSpec.getMode(r6);
        int size = View.MeasureSpec.getSize(r6);
        int measuredWidth = getMeasuredWidth();
        int r4 = this.mMinWidth;
        if (mode == Integer.MIN_VALUE) {
            r62 = Math.min(size, r4);
        } else {
            r62 = r4;
        }
        if (mode != 1073741824 && r4 > 0 && measuredWidth < r62) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r62, 1073741824), r7);
        }
        if (!hasText && this.mIcon != null) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ActionMenuItemForwardingListener actionMenuItemForwardingListener;
        if (this.mItemData.hasSubMenu() && (actionMenuItemForwardingListener = this.mForwardingListener) != null && actionMenuItemForwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                MenuBuilder menuBuilder = menuItemImpl.mMenu;
                menuBuilder.mIsActionItemsStale = true;
                menuBuilder.onItemsChanged(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int r2 = this.mMaxIconSize;
            if (intrinsicWidth > r2) {
                intrinsicHeight = (int) (intrinsicHeight * (r2 / intrinsicWidth));
                intrinsicWidth = r2;
            }
            if (intrinsicHeight > r2) {
                intrinsicWidth = (int) (intrinsicWidth * (r2 / intrinsicHeight));
            } else {
                r2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, r2);
        }
        setCompoundDrawables(drawable, null, null, null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        this.mSavedPaddingLeft = r1;
        super.setPadding(r1, r2, r3, r4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        updateTextButtonVisibility();
    }

    public final boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int r1 = configuration.screenWidthDp;
        int r2 = configuration.screenHeightDp;
        if (r1 < 480 && ((r1 < 640 || r2 < 480) && configuration.orientation != 2)) {
            return false;
        }
        return true;
    }

    public final void updateTextButtonVisibility() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) {
            if ((this.mItemData.mShowAsAction & 4) == 4) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (!this.mAllowTextWithIcon && !this.mExpandedFormat)) {
                z2 = false;
            }
        }
        boolean z4 = z3 & z2;
        CharSequence charSequence3 = null;
        if (z4) {
            charSequence = this.mTitle;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence4 = this.mItemData.mContentDescription;
        if (TextUtils.isEmpty(charSequence4)) {
            if (z4) {
                charSequence2 = null;
            } else {
                charSequence2 = this.mItemData.mTitle;
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(charSequence4);
        }
        CharSequence charSequence5 = this.mItemData.mTooltipText;
        if (TextUtils.isEmpty(charSequence5)) {
            if (!z4) {
                charSequence3 = this.mItemData.mTitle;
            }
            TooltipCompat.setTooltipText(this, charSequence3);
            return;
        }
        TooltipCompat.setTooltipText(this, charSequence5);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int r5) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, 0, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }
}
