package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class AppCompatSpinner extends Spinner {
    public static final int[] ATTRS_ANDROID_SPINNERMODE = {R.attr.spinnerMode};
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public int mDropDownWidth;
    public final AnonymousClass1 mForwardingListener;
    public final SpinnerPopup mPopup;
    public final Context mPopupContext;
    public final boolean mPopupSet;
    public SpinnerAdapter mTempAdapter;
    public final Rect mTempRect;

    /* loaded from: classes.dex */
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        public ListAdapter mListAdapter;
        public AlertDialog mPopup;
        public CharSequence mPrompt;

        public DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void dismiss() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.mPopup = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final boolean isShowing() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int r5) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(r5);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, r5, this.mListAdapter.getItemId(r5));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            this.mListAdapter = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOffset(int r2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int r2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mPrompt = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setVerticalOffset(int r2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int r5, int r6) {
            if (this.mListAdapter == null) {
                return;
            }
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatSpinner.getPopupContext());
            CharSequence charSequence = this.mPrompt;
            AlertController.AlertParams alertParams = builder.P;
            if (charSequence != null) {
                alertParams.mTitle = charSequence;
            }
            ListAdapter listAdapter = this.mListAdapter;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = this;
            alertParams.mCheckedItem = selectedItemPosition;
            alertParams.mIsSingleChoice = true;
            AlertDialog create = builder.create();
            this.mPopup = create;
            AlertController.RecycleListView recycleListView = create.mAlert.mListView;
            recycleListView.setTextDirection(r5);
            recycleListView.setTextAlignment(r6);
            this.mPopup.show();
        }
    }

    /* loaded from: classes.dex */
    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        public final SpinnerAdapter mAdapter;
        public final ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme();
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int r2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(r2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int r2) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(r2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r3) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(r3);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int r1) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int r1, View view, ViewGroup viewGroup) {
            return getDropDownView(r1, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null && spinnerAdapter.hasStableIds()) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int r2) {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(r2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        public ListAdapter mAdapter;
        public CharSequence mHintText;
        public int mOriginalHorizontalOffset;
        public final Rect mVisibleRect;

        public DropdownPopup(Context context, AttributeSet attributeSet, int r5) {
            super(context, attributeSet, r5, 0);
            this.mVisibleRect = new Rect();
            this.mDropDownAnchorView = AppCompatSpinner.this;
            this.mModal = true;
            this.mPopup.setFocusable(true);
            this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int r52, long j) {
                    DropdownPopup dropdownPopup = DropdownPopup.this;
                    AppCompatSpinner.this.setSelection(r52);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, r52, dropdownPopup.mAdapter.getItemId(r52));
                    }
                    dropdownPopup.dismiss();
                }
            };
        }

        public final void computeContentWidth() {
            int r0;
            int r4;
            Drawable background = getBackground();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (background != null) {
                background.getPadding(appCompatSpinner.mTempRect);
                if (ViewUtils.isLayoutRtl(appCompatSpinner)) {
                    r0 = appCompatSpinner.mTempRect.right;
                } else {
                    r0 = -appCompatSpinner.mTempRect.left;
                }
            } else {
                Rect rect = appCompatSpinner.mTempRect;
                rect.right = 0;
                rect.left = 0;
                r0 = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int r5 = appCompatSpinner.mDropDownWidth;
            if (r5 == -2) {
                int compatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int r6 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = appCompatSpinner.mTempRect;
                int r62 = (r6 - rect2.left) - rect2.right;
                if (compatMeasureContentWidth > r62) {
                    compatMeasureContentWidth = r62;
                }
                setContentWidth(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (r5 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(r5);
            }
            if (ViewUtils.isLayoutRtl(appCompatSpinner)) {
                r4 = (((width - paddingRight) - this.mDropDownWidth) - this.mOriginalHorizontalOffset) + r0;
            } else {
                r4 = paddingLeft + this.mOriginalHorizontalOffset + r0;
            }
            this.mDropDownHorizontalOffset = r4;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int r1) {
            this.mOriginalHorizontalOffset = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v2, types: [androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$2, android.view.ViewTreeObserver$OnGlobalLayoutListener] */
        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int r6, int r7) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            computeContentWidth();
            AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
            appCompatPopupWindow.setInputMethodMode(2);
            show();
            DropDownListView dropDownListView = this.mDropDownList;
            dropDownListView.setChoiceMode(1);
            dropDownListView.setTextDirection(r6);
            dropDownListView.setTextAlignment(r7);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            DropDownListView dropDownListView2 = this.mDropDownList;
            if (isShowing() && dropDownListView2 != null) {
                dropDownListView2.setListSelectionHidden(false);
                dropDownListView2.setSelection(selectedItemPosition);
                if (dropDownListView2.getChoiceMode() != 0) {
                    dropDownListView2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing && (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) != 0) {
                final ?? r72 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        boolean z;
                        DropdownPopup dropdownPopup = DropdownPopup.this;
                        AppCompatSpinner appCompatSpinner2 = AppCompatSpinner.this;
                        dropdownPopup.getClass();
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        if (ViewCompat.Api19Impl.isAttachedToWindow(appCompatSpinner2) && appCompatSpinner2.getGlobalVisibleRect(dropdownPopup.mVisibleRect)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            dropdownPopup.dismiss();
                        } else {
                            dropdownPopup.computeContentWidth();
                            dropdownPopup.show();
                        }
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r72);
                appCompatPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(r72);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public boolean mShowDropdown;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mShowDropdown = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            super.writeToParcel(parcel, r2);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes.dex */
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int r1);

        void setHorizontalOriginalOffset(int r1);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int r1);

        void show(int r1, int r2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:            if (r5 == null) goto L23;     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.appcompat.widget.AppCompatSpinner$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            r10.<init>(r11, r12, r13)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.mTempRect = r0
            android.content.Context r0 = r10.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r0, r10)
            int[] r0 = androidx.appcompat.R$styleable.Spinner
            r1 = 0
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r12, r0, r13, r1)
            androidx.appcompat.widget.AppCompatBackgroundHelper r3 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r3.<init>(r10)
            r10.mBackgroundTintHelper = r3
            r3 = 4
            int r3 = r2.getResourceId(r3, r1)
            if (r3 == 0) goto L2e
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            r4.<init>(r11, r3)
            r10.mPopupContext = r4
            goto L30
        L2e:
            r10.mPopupContext = r11
        L30:
            r3 = -1
            r4 = 0
            int[] r5 = androidx.appcompat.widget.AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            android.content.res.TypedArray r5 = r11.obtainStyledAttributes(r12, r5, r13, r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            boolean r6 = r5.hasValue(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r6 == 0) goto L58
            int r3 = r5.getInt(r1, r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            goto L58
        L43:
            r11 = move-exception
            r4 = r5
            goto Lcb
        L47:
            r6 = move-exception
            goto L4f
        L49:
            r11 = move-exception
            goto Lcb
        L4c:
            r5 = move-exception
            r6 = r5
            r5 = r4
        L4f:
            java.lang.String r7 = "AppCompatSpinner"
            java.lang.String r8 = "Could not read android:spinnerMode"
            android.util.Log.i(r7, r8, r6)     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L5b
        L58:
            r5.recycle()
        L5b:
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L93
            if (r3 == r6) goto L62
            goto La0
        L62:
            androidx.appcompat.widget.AppCompatSpinner$DropdownPopup r3 = new androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
            android.content.Context r7 = r10.mPopupContext
            r3.<init>(r7, r12, r13)
            android.content.Context r7 = r10.mPopupContext
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r7, r12, r0, r13)
            android.content.res.TypedArray r7 = r0.mWrapped
            r8 = 3
            r9 = -2
            int r7 = r7.getLayoutDimension(r8, r9)
            r10.mDropDownWidth = r7
            android.graphics.drawable.Drawable r7 = r0.getDrawable(r6)
            r3.setBackgroundDrawable(r7)
            java.lang.String r5 = r2.getString(r5)
            r3.mHintText = r5
            r0.recycle()
            r10.mPopup = r3
            androidx.appcompat.widget.AppCompatSpinner$1 r0 = new androidx.appcompat.widget.AppCompatSpinner$1
            r0.<init>(r10)
            r10.mForwardingListener = r0
            goto La0
        L93:
            androidx.appcompat.widget.AppCompatSpinner$DialogPopup r0 = new androidx.appcompat.widget.AppCompatSpinner$DialogPopup
            r0.<init>()
            r10.mPopup = r0
            java.lang.String r3 = r2.getString(r5)
            r0.mPrompt = r3
        La0:
            java.lang.CharSequence[] r0 = r2.getTextArray(r1)
            if (r0 == 0) goto Lb7
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r11, r3, r0)
            r11 = 2131624269(0x7f0e014d, float:1.8875713E38)
            r1.setDropDownViewResource(r11)
            r10.setAdapter(r1)
        Lb7:
            r2.recycle()
            r10.mPopupSet = r6
            android.widget.SpinnerAdapter r11 = r10.mTempAdapter
            if (r11 == 0) goto Lc5
            r10.setAdapter(r11)
            r10.mTempAdapter = r4
        Lc5:
            androidx.appcompat.widget.AppCompatBackgroundHelper r11 = r10.mBackgroundTintHelper
            r11.loadFromAttributes(r12, r13)
            return
        Lcb:
            if (r4 == 0) goto Ld0
            r4.recycle()
        Ld0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public final int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int r0 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int r3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != r0) {
                view = null;
                r0 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            r3 = Math.max(r3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.mTempRect;
            drawable.getPadding(rect);
            return r3 + rect.left + rect.right;
        }
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getHorizontalOffset();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getVerticalOffset();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        return super.getDropDownWidth();
    }

    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getBackground();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getHintText();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null && spinnerPopup.isShowing()) {
            spinnerPopup.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (this.mPopup != null && View.MeasureSpec.getMode(r3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.mShowDropdown && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                    if (!appCompatSpinner.getInternalPopup().isShowing()) {
                        appCompatSpinner.mPopup.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                    }
                    ViewTreeObserver viewTreeObserver2 = appCompatSpinner.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null && spinnerPopup.isShowing()) {
            z = true;
        } else {
            z = false;
        }
        savedState.mShowDropdown = z;
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AnonymousClass1 anonymousClass1 = this.mForwardingListener;
        if (anonymousClass1 != null && anonymousClass1.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            if (!spinnerPopup.isShowing()) {
                spinnerPopup.show(getTextDirection(), getTextAlignment());
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        super.setBackgroundResource(r2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(r2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r2) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setHorizontalOriginalOffset(r2);
            spinnerPopup.setHorizontalOffset(r2);
        } else {
            super.setDropDownHorizontalOffset(r2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r2) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setVerticalOffset(r2);
        } else {
            super.setDropDownVerticalOffset(r2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r2) {
        if (this.mPopup != null) {
            this.mDropDownWidth = r2;
        } else {
            super.setDropDownWidth(r2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int r2) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            spinnerPopup.setAdapter(new DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }
}
