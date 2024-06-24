package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class MenuPopupHelper {
    public View mAnchorView;
    public final Context mContext;
    public int mDropDownGravity;
    public boolean mForceShowIcon;
    public final AnonymousClass1 mInternalOnDismissListener;
    public final MenuBuilder mMenu;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public MenuPopup mPopup;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z) {
        this(R.attr.actionOverflowMenuStyle, 0, context, view, menuBuilder, z);
    }

    public final MenuPopup getPopup() {
        boolean z;
        MenuPopup standardMenuPopup;
        if (this.mPopup == null) {
            Context context = this.mContext;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                standardMenuPopup = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            } else {
                Context context2 = this.mContext;
                MenuBuilder menuBuilder = this.mMenu;
                standardMenuPopup = new StandardMenuPopup(this.mPopupStyleAttr, this.mPopupStyleRes, context2, this.mAnchorView, menuBuilder, this.mOverflowOnly);
            }
            standardMenuPopup.addMenu(this.mMenu);
            standardMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
            standardMenuPopup.setAnchorView(this.mAnchorView);
            standardMenuPopup.setCallback(this.mPresenterCallback);
            standardMenuPopup.setForceShowIcon(this.mForceShowIcon);
            standardMenuPopup.setGravity(this.mDropDownGravity);
            this.mPopup = standardMenuPopup;
        }
        return this.mPopup;
    }

    public final boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null && menuPopup.isShowing()) {
            return true;
        }
        return false;
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void showPopup(int r4, int r5, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            int r6 = this.mDropDownGravity;
            View view = this.mAnchorView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if ((Gravity.getAbsoluteGravity(r6, ViewCompat.Api17Impl.getLayoutDirection(view)) & 7) == 5) {
                r4 -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(r4);
            popup.setVerticalOffset(r5);
            int r62 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.mEpicenterBounds = new Rect(r4 - r62, r5 - r62, r4 + r62, r5 + r62);
        }
        popup.show();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.view.menu.MenuPopupHelper$1] */
    public MenuPopupHelper(int r2, int r3, Context context, View view, MenuBuilder menuBuilder, boolean z) {
        this.mDropDownGravity = 8388611;
        this.mInternalOnDismissListener = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = r2;
        this.mPopupStyleRes = r3;
    }
}
