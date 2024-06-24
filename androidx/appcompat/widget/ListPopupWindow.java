package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.PopupWindowCompat$Api19Impl;
import androidx.core.widget.PopupWindowCompat$Api23Impl;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final Method sSetClipToWindowEnabledMethod;
    public static final Method sSetEpicenterBoundsMethod;
    public ListAdapter mAdapter;
    public final Context mContext;
    public View mDropDownAnchorView;
    public int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    public int mDropDownVerticalOffset;
    public boolean mDropDownVerticalOffsetSet;
    public Rect mEpicenterBounds;
    public final Handler mHandler;
    public AdapterView.OnItemClickListener mItemClickListener;
    public boolean mModal;
    public PopupDataSetObserver mObserver;
    public boolean mOverlapAnchor;
    public boolean mOverlapAnchorSet;
    public final AppCompatPopupWindow mPopup;
    public final int mDropDownHeight = -2;
    public int mDropDownWidth = -2;
    public final int mDropDownWindowLayoutType = 1002;
    public int mDropDownGravity = 0;
    public final int mListItemExpandMaximum = Integer.MAX_VALUE;
    public final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    public final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    public final PopupScrollListener mScrollListener = new PopupScrollListener();
    public final ListSelectorHider mHideSelector = new ListSelectorHider();
    public final Rect mTempRect = new Rect();

    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        public ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
            if (dropDownListView != null) {
                dropDownListView.setListSelectionHidden(true);
                dropDownListView.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public class PopupDataSetObserver extends DataSetObserver {
        public PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (listPopupWindow.isShowing()) {
                listPopupWindow.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppCompatPopupWindow appCompatPopupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (action == 0 && (appCompatPopupWindow = listPopupWindow.mPopup) != null && appCompatPopupWindow.isShowing() && x >= 0) {
                AppCompatPopupWindow appCompatPopupWindow2 = listPopupWindow.mPopup;
                if (x < appCompatPopupWindow2.getWidth() && y >= 0 && y < appCompatPopupWindow2.getHeight()) {
                    listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
                    return false;
                }
            }
            if (action == 1) {
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        public ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            DropDownListView dropDownListView = listPopupWindow.mDropDownList;
            if (dropDownListView != null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (ViewCompat.Api19Impl.isAttachedToWindow(dropDownListView) && listPopupWindow.mDropDownList.getCount() > listPopupWindow.mDropDownList.getChildCount() && listPopupWindow.mDropDownList.getChildCount() <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    listPopupWindow.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int r6, int r7) {
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, r6, r7);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, r6, r7);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    public DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        appCompatPopupWindow.dismiss();
        appCompatPopupWindow.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public final Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        return this.mDropDownList;
    }

    public final int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        PopupDataSetObserver popupDataSetObserver = this.mObserver;
        if (popupDataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(popupDataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public final void setContentWidth(int r3) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            Rect rect = this.mTempRect;
            background.getPadding(rect);
            this.mDropDownWidth = rect.left + rect.right + r3;
            return;
        }
        this.mDropDownWidth = r3;
    }

    public final void setHorizontalOffset(int r1) {
        this.mDropDownHorizontalOffset = r1;
    }

    public final void setVerticalOffset(int r1) {
        this.mDropDownVerticalOffset = r1;
        this.mDropDownVerticalOffsetSet = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        int r6;
        boolean z;
        int makeMeasureSpec;
        int r5;
        int r0;
        boolean z2;
        DropDownListView dropDownListView;
        int r62;
        int r02;
        DropDownListView dropDownListView2 = this.mDropDownList;
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        Context context = this.mContext;
        if (dropDownListView2 == null) {
            DropDownListView createDropDownListView = createDropDownListView(context, !this.mModal);
            this.mDropDownList = createDropDownListView;
            createDropDownListView.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int r3, long j) {
                    DropDownListView dropDownListView3;
                    if (r3 != -1 && (dropDownListView3 = ListPopupWindow.this.mDropDownList) != null) {
                        dropDownListView3.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            appCompatPopupWindow.setContentView(this.mDropDownList);
        }
        Drawable background = appCompatPopupWindow.getBackground();
        int r4 = 0;
        Rect rect = this.mTempRect;
        if (background != null) {
            background.getPadding(rect);
            int r03 = rect.top;
            r6 = rect.bottom + r03;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -r03;
            }
        } else {
            rect.setEmpty();
            r6 = 0;
        }
        if (appCompatPopupWindow.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int maxAvailableHeight = appCompatPopupWindow.getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, z);
        int r8 = this.mDropDownHeight;
        if (r8 == -1) {
            r0 = maxAvailableHeight + r6;
        } else {
            int r11 = this.mDropDownWidth;
            if (r11 != -2) {
                if (r11 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, maxAvailableHeight + 0);
            if (measureHeightOfChildrenCompat > 0) {
                r5 = this.mDropDownList.getPaddingBottom() + this.mDropDownList.getPaddingTop() + r6 + 0;
            } else {
                r5 = 0;
            }
            r0 = measureHeightOfChildrenCompat + r5;
        }
        if (appCompatPopupWindow.getInputMethodMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        PopupWindowCompat$Api23Impl.setWindowLayoutType(appCompatPopupWindow, this.mDropDownWindowLayoutType);
        if (appCompatPopupWindow.isShowing()) {
            View view = this.mDropDownAnchorView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!ViewCompat.Api19Impl.isAttachedToWindow(view)) {
                return;
            }
            int r52 = this.mDropDownWidth;
            if (r52 == -1) {
                r52 = -1;
            } else if (r52 == -2) {
                r52 = this.mDropDownAnchorView.getWidth();
            }
            if (r8 == -1) {
                if (z2) {
                    r8 = r0;
                } else {
                    r8 = -1;
                }
                if (z2) {
                    if (this.mDropDownWidth == -1) {
                        r02 = -1;
                    } else {
                        r02 = 0;
                    }
                    appCompatPopupWindow.setWidth(r02);
                    appCompatPopupWindow.setHeight(0);
                } else {
                    if (this.mDropDownWidth == -1) {
                        r4 = -1;
                    }
                    appCompatPopupWindow.setWidth(r4);
                    appCompatPopupWindow.setHeight(-1);
                }
            } else if (r8 == -2) {
                r8 = r0;
            }
            appCompatPopupWindow.setOutsideTouchable(true);
            View view2 = this.mDropDownAnchorView;
            int r3 = this.mDropDownHorizontalOffset;
            int r42 = this.mDropDownVerticalOffset;
            if (r52 < 0) {
                r52 = -1;
            }
            if (r8 < 0) {
                r62 = -1;
            } else {
                r62 = r8;
            }
            appCompatPopupWindow.update(view2, r3, r42, r52, r62);
            return;
        }
        int r32 = this.mDropDownWidth;
        if (r32 == -1) {
            r32 = -1;
        } else if (r32 == -2) {
            r32 = this.mDropDownAnchorView.getWidth();
        }
        if (r8 == -1) {
            r8 = -1;
        } else if (r8 == -2) {
            r8 = r0;
        }
        appCompatPopupWindow.setWidth(r32);
        appCompatPopupWindow.setHeight(r8);
        if (Build.VERSION.SDK_INT > 28) {
            appCompatPopupWindow.setIsClippedToScreen(true);
        } else {
            Method method = sSetClipToWindowEnabledMethod;
            if (method != null) {
                try {
                    method.invoke(appCompatPopupWindow, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        }
        appCompatPopupWindow.setOutsideTouchable(true);
        appCompatPopupWindow.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet) {
            PopupWindowCompat$Api23Impl.setOverlapAnchor(appCompatPopupWindow, this.mOverlapAnchor);
        }
        if (Build.VERSION.SDK_INT > 28) {
            appCompatPopupWindow.setEpicenterBounds(this.mEpicenterBounds);
        } else {
            Method method2 = sSetEpicenterBoundsMethod;
            if (method2 != null) {
                try {
                    method2.invoke(appCompatPopupWindow, this.mEpicenterBounds);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        }
        PopupWindowCompat$Api19Impl.showAsDropDown(appCompatPopupWindow, this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if ((!this.mModal || this.mDropDownList.isInTouchMode()) && (dropDownListView = this.mDropDownList) != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int r4) {
            boolean z = true;
            if (r4 == 1) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (listPopupWindow.mPopup.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && listPopupWindow.mPopup.getContentView() != null) {
                    Handler handler = listPopupWindow.mHandler;
                    ResizePopupRunnable resizePopupRunnable = listPopupWindow.mResizePopupRunnable;
                    handler.removeCallbacks(resizePopupRunnable);
                    resizePopupRunnable.run();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int r2, int r3, int r4) {
        }
    }
}
