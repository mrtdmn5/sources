package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.kronaby.watch.app.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    public static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    public Bundle mAppSearchData;
    public boolean mClearingFocus;
    public final ImageView mCloseButton;
    public final ImageView mCollapsedIcon;
    public int mCollapsedImeOptions;
    public final CharSequence mDefaultQueryHint;
    public final View mDropDownAnchor;
    public boolean mExpandedInActionView;
    public final ImageView mGoButton;
    public boolean mIconified;
    public boolean mIconifiedByDefault;
    public int mMaxWidth;
    public View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    public View.OnClickListener mOnSearchClickListener;
    public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    public CharSequence mQueryHint;
    public boolean mQueryRefinement;
    public final AnonymousClass2 mReleaseCursorRunnable;
    public final ImageView mSearchButton;
    public final View mSearchEditFrame;
    public final Drawable mSearchHintIcon;
    public final View mSearchPlate;
    public final SearchAutoComplete mSearchSrcTextView;
    public final Rect mSearchSrcTextViewBounds;
    public final Rect mSearchSrtTextViewBoundsExpanded;
    public SearchableInfo mSearchable;
    public final View mSubmitArea;
    public boolean mSubmitButtonEnabled;
    public final int mSuggestionCommitIconResId;
    public final int mSuggestionRowLayout;
    public CursorAdapter mSuggestionsAdapter;
    public final int[] mTemp;
    public final int[] mTemp2;
    public UpdatableTouchDelegate mTouchDelegate;
    public final AnonymousClass1 mUpdateDrawableStateRunnable;
    public CharSequence mUserQuery;
    public final Intent mVoiceAppSearchIntent;
    public final ImageView mVoiceButton;
    public boolean mVoiceButtonEnabled;
    public final Intent mVoiceWebSearchIntent;

    /* loaded from: classes.dex */
    public interface OnCloseListener {
    }

    /* loaded from: classes.dex */
    public interface OnQueryTextListener {
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionListener {
    }

    /* loaded from: classes.dex */
    public static class PreQAutoCompleteTextViewReflector {
        public final Method mDoAfterTextChanged;
        public final Method mDoBeforeTextChanged;
        public final Method mEnsureImeVisible;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.mDoBeforeTextChanged = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.mDoAfterTextChanged = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.mEnsureImeVisible = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void preApi29Check() {
            if (Build.VERSION.SDK_INT < 29) {
            } else {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public boolean isIconified;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r3) {
            parcel.writeParcelable(this.mSuperState, r3);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }
    }

    /* loaded from: classes.dex */
    public static class UpdatableTouchDelegate extends TouchDelegate {
        public final Rect mActualBounds;
        public boolean mDelegateTargeted;
        public final View mDelegateView;
        public final int mSlop;
        public final Rect mSlopBounds;
        public final Rect mTargetBounds;

        public UpdatableTouchDelegate(SearchAutoComplete searchAutoComplete, Rect rect, Rect rect2) {
            super(rect, searchAutoComplete);
            int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
            this.mSlop = scaledTouchSlop;
            Rect rect3 = new Rect();
            this.mTargetBounds = rect3;
            Rect rect4 = new Rect();
            this.mSlopBounds = rect4;
            Rect rect5 = new Rect();
            this.mActualBounds = rect5;
            rect3.set(rect);
            rect4.set(rect);
            int r6 = -scaledTouchSlop;
            rect4.inset(r6, r6);
            rect5.set(rect2);
            this.mDelegateView = searchAutoComplete;
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action != 1 && action != 2) {
                    if (action == 3) {
                        z2 = this.mDelegateTargeted;
                        this.mDelegateTargeted = false;
                    }
                    z = true;
                    z3 = false;
                } else {
                    z2 = this.mDelegateTargeted;
                    if (z2 && !this.mSlopBounds.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                }
                z3 = z2;
                z = true;
            } else {
                if (this.mTargetBounds.contains(x, y)) {
                    this.mDelegateTargeted = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            Rect rect = this.mActualBounds;
            View view = this.mDelegateView;
            if (z && !rect.contains(x, y)) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                motionEvent.setLocation(x - rect.left, y - rect.top);
            }
            return view.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector;
        if (Build.VERSION.SDK_INT < 29) {
            preQAutoCompleteTextViewReflector = new PreQAutoCompleteTextViewReflector();
        } else {
            preQAutoCompleteTextViewReflector = null;
        }
        PRE_API_29_HIDDEN_METHOD_INVOKER = preQAutoCompleteTextViewReflector;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public final Intent createIntent(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.mAppSearchData;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    public final Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int r10;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mAppSearchData;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            r10 = searchableInfo.getVoiceMaxResults();
        } else {
            r10 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", r10);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void forceSuggestionQuery() {
        int r0 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (r0 >= 29) {
            searchAutoComplete.refreshAutoCompleteResults();
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
        preQAutoCompleteTextViewReflector.getClass();
        PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = preQAutoCompleteTextViewReflector.mDoBeforeTextChanged;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        preQAutoCompleteTextViewReflector.getClass();
        PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method2 = preQAutoCompleteTextViewReflector.mDoAfterTextChanged;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.mQueryHint;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.mSearchable;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.mSearchable.getHintId());
            }
            return this.mDefaultQueryHint;
        }
        return charSequence;
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.mUserQuery = "";
        clearFocus();
        updateViewsVisibility(true);
        searchAutoComplete.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewExpanded() {
        if (this.mExpandedInActionView) {
            return;
        }
        this.mExpandedInActionView = true;
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.mCollapsedImeOptions = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    public final void onCloseClicked() {
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (TextUtils.isEmpty(searchAutoComplete.getText())) {
            if (this.mIconifiedByDefault) {
                clearFocus();
                updateViewsVisibility(true);
                return;
            }
            return;
        }
        searchAutoComplete.setText("");
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public final void onItemClicked(int r7) {
        int r1;
        Uri parse;
        String stringOrNull;
        Cursor cursor = this.mSuggestionsAdapter.mCursor;
        if (cursor != null && cursor.moveToPosition(r7)) {
            Intent intent = null;
            try {
                int r3 = SuggestionsAdapter.$r8$clinit;
                String stringOrNull2 = SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (stringOrNull2 == null) {
                    stringOrNull2 = this.mSearchable.getSuggestIntentAction();
                }
                if (stringOrNull2 == null) {
                    stringOrNull2 = "android.intent.action.SEARCH";
                }
                String stringOrNull3 = SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (stringOrNull3 == null) {
                    stringOrNull3 = this.mSearchable.getSuggestIntentData();
                }
                if (stringOrNull3 != null && (stringOrNull = SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    stringOrNull3 = stringOrNull3 + "/" + Uri.encode(stringOrNull);
                }
                if (stringOrNull3 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(stringOrNull3);
                }
                intent = createIntent(stringOrNull2, parse, SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    r1 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    r1 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + r1 + " returned exception.", e);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e2) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e2);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void onItemSelected(int r3) {
        Editable text = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.mCursor;
        if (cursor != null) {
            if (cursor.moveToPosition(r3)) {
                String convertToString = this.mSuggestionsAdapter.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r6, int r7, int r8, int r9) {
        super.onLayout(z, r6, r7, r8, r9);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            int[] r62 = this.mTemp;
            searchAutoComplete.getLocationInWindow(r62);
            int[] r82 = this.mTemp2;
            getLocationInWindow(r82);
            int r1 = r62[1] - r82[1];
            int r63 = r62[0] - r82[0];
            int width = searchAutoComplete.getWidth() + r63;
            int height = searchAutoComplete.getHeight() + r1;
            Rect rect = this.mSearchSrcTextViewBounds;
            rect.set(r63, r1, width, height);
            int r64 = rect.left;
            int r83 = rect.right;
            int r92 = r9 - r7;
            Rect rect2 = this.mSearchSrtTextViewBoundsExpanded;
            rect2.set(r64, 0, r83, r92);
            UpdatableTouchDelegate updatableTouchDelegate = this.mTouchDelegate;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(searchAutoComplete, rect2, rect);
                this.mTouchDelegate = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
            } else {
                updatableTouchDelegate.mTargetBounds.set(rect2);
                Rect rect3 = updatableTouchDelegate.mSlopBounds;
                rect3.set(rect2);
                int r72 = -updatableTouchDelegate.mSlop;
                rect3.inset(r72, r72);
                updatableTouchDelegate.mActualBounds.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0;
        if (this.mIconified) {
            super.onMeasure(r4, r5);
            return;
        }
        int mode = View.MeasureSpec.getMode(r4);
        int size = View.MeasureSpec.getSize(r4);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (r0 = this.mMaxWidth) > 0) {
                    size = Math.min(r0, size);
                }
            } else {
                size = this.mMaxWidth;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int r02 = this.mMaxWidth;
            size = r02 > 0 ? Math.min(r02, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(r5);
        int size2 = View.MeasureSpec.getSize(r5);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public final void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        updateViewsVisibility(savedState.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = this.mIconified;
        return savedState;
    }

    public final void onSubmitQuery() {
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.mSearchable != null) {
                getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.mUpdateDrawableStateRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int r3, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (!this.mIconified) {
            boolean requestFocus = this.mSearchSrcTextView.requestFocus(r3, rect);
            if (requestFocus) {
                updateViewsVisibility(false);
            }
            return requestFocus;
        }
        return super.requestFocus(r3, rect);
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
            return;
        }
        updateViewsVisibility(false);
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.mOnSearchClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault == z) {
            return;
        }
        this.mIconifiedByDefault = z;
        updateViewsVisibility(z);
        updateQueryHint();
    }

    public void setImeOptions(int r2) {
        this.mSearchSrcTextView.setImeOptions(r2);
    }

    public void setInputType(int r2) {
        this.mSearchSrcTextView.setInputType(r2);
    }

    public void setMaxWidth(int r1) {
        this.mMaxWidth = r1;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean z) {
        int r3;
        this.mQueryRefinement = z;
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) cursorAdapter;
            if (z) {
                r3 = 2;
            } else {
                r3 = 1;
            }
            suggestionsAdapter.mQueryRefinement = r3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:            if (getContext().getPackageManager().resolveActivity(r3, 65536) != null) goto L35;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSearchableInfo(android.app.SearchableInfo r8) {
        /*
            r7 = this;
            r7.mSearchable = r8
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r7.mSearchSrcTextView
            r1 = 1
            r2 = 65536(0x10000, float:9.1835E-41)
            r3 = 0
            if (r8 == 0) goto L68
            int r8 = r8.getSuggestThreshold()
            r0.setThreshold(r8)
            android.app.SearchableInfo r8 = r7.mSearchable
            int r8 = r8.getImeOptions()
            r0.setImeOptions(r8)
            android.app.SearchableInfo r8 = r7.mSearchable
            int r8 = r8.getInputType()
            r4 = r8 & 15
            if (r4 != r1) goto L34
            r4 = -65537(0xfffffffffffeffff, float:NaN)
            r8 = r8 & r4
            android.app.SearchableInfo r4 = r7.mSearchable
            java.lang.String r4 = r4.getSuggestAuthority()
            if (r4 == 0) goto L34
            r8 = r8 | r2
            r4 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 | r4
        L34:
            r0.setInputType(r8)
            androidx.cursoradapter.widget.CursorAdapter r8 = r7.mSuggestionsAdapter
            if (r8 == 0) goto L3e
            r8.changeCursor(r3)
        L3e:
            android.app.SearchableInfo r8 = r7.mSearchable
            java.lang.String r8 = r8.getSuggestAuthority()
            if (r8 == 0) goto L65
            androidx.appcompat.widget.SuggestionsAdapter r8 = new androidx.appcompat.widget.SuggestionsAdapter
            android.content.Context r4 = r7.getContext()
            android.app.SearchableInfo r5 = r7.mSearchable
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r6 = r7.mOutsideDrawablesCache
            r8.<init>(r4, r7, r5, r6)
            r7.mSuggestionsAdapter = r8
            r0.setAdapter(r8)
            androidx.cursoradapter.widget.CursorAdapter r8 = r7.mSuggestionsAdapter
            androidx.appcompat.widget.SuggestionsAdapter r8 = (androidx.appcompat.widget.SuggestionsAdapter) r8
            boolean r4 = r7.mQueryRefinement
            if (r4 == 0) goto L62
            r4 = 2
            goto L63
        L62:
            r4 = r1
        L63:
            r8.mQueryRefinement = r4
        L65:
            r7.updateQueryHint()
        L68:
            android.app.SearchableInfo r8 = r7.mSearchable
            if (r8 == 0) goto L98
            boolean r8 = r8.getVoiceSearchEnabled()
            if (r8 == 0) goto L98
            android.app.SearchableInfo r8 = r7.mSearchable
            boolean r8 = r8.getVoiceSearchLaunchWebSearch()
            if (r8 == 0) goto L7d
            android.content.Intent r3 = r7.mVoiceWebSearchIntent
            goto L87
        L7d:
            android.app.SearchableInfo r8 = r7.mSearchable
            boolean r8 = r8.getVoiceSearchLaunchRecognizer()
            if (r8 == 0) goto L87
            android.content.Intent r3 = r7.mVoiceAppSearchIntent
        L87:
            if (r3 == 0) goto L98
            android.content.Context r8 = r7.getContext()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            android.content.pm.ResolveInfo r8 = r8.resolveActivity(r3, r2)
            if (r8 == 0) goto L98
            goto L99
        L98:
            r1 = 0
        L99:
            r7.mVoiceButtonEnabled = r1
            if (r1 == 0) goto La2
            java.lang.String r8 = "nm"
            r0.setPrivateImeOptions(r8)
        La2:
            boolean r8 = r7.mIconified
            r7.updateViewsVisibility(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(this.mIconified);
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(cursorAdapter);
    }

    public final void updateCloseButton() {
        int[] r0;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int r2 = 0;
        if (!z2 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            z = false;
        }
        if (!z) {
            r2 = 8;
        }
        ImageView imageView = this.mCloseButton;
        imageView.setVisibility(r2);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (z2) {
                r0 = ViewGroup.ENABLED_STATE_SET;
            } else {
                r0 = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(r0);
        }
    }

    public final void updateFocusedState() {
        int[] r0;
        if (this.mSearchSrcTextView.hasFocus()) {
            r0 = ViewGroup.FOCUSED_STATE_SET;
        } else {
            r0 = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(r0);
        }
        Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(r0);
        }
        invalidate();
    }

    public final void updateQueryHint() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z = this.mIconifiedByDefault;
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (z && (drawable = this.mSearchHintIcon) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void updateSubmitArea() {
        boolean z;
        int r1 = 0;
        if ((this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !this.mIconified) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (this.mGoButton.getVisibility() != 0 && this.mVoiceButton.getVisibility() != 0)) {
            r1 = 8;
        }
        this.mSubmitArea.setVisibility(r1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:            if (r2.mVoiceButtonEnabled == false) goto L20;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateSubmitButton(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.mSubmitButtonEnabled
            if (r0 == 0) goto L21
            r1 = 0
            if (r0 != 0) goto Lb
            boolean r0 = r2.mVoiceButtonEnabled
            if (r0 == 0) goto L11
        Lb:
            boolean r0 = r2.mIconified
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = r1
        L12:
            if (r0 == 0) goto L21
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L21
            if (r3 != 0) goto L23
            boolean r3 = r2.mVoiceButtonEnabled
            if (r3 != 0) goto L21
            goto L23
        L21:
            r1 = 8
        L23:
            android.widget.ImageView r3 = r2.mGoButton
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.updateSubmitButton(boolean):void");
    }

    public final void updateViewsVisibility(boolean z) {
        int r2;
        int r6;
        int r22;
        this.mIconified = z;
        int r0 = 0;
        if (z) {
            r2 = 0;
        } else {
            r2 = 8;
        }
        boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(r2);
        updateSubmitButton(z2);
        if (z) {
            r6 = 8;
        } else {
            r6 = 0;
        }
        this.mSearchEditFrame.setVisibility(r6);
        ImageView imageView = this.mCollapsedIcon;
        if (imageView.getDrawable() != null && !this.mIconifiedByDefault) {
            r22 = 0;
        } else {
            r22 = 8;
        }
        imageView.setVisibility(r22);
        updateCloseButton();
        boolean z3 = !z2;
        if (this.mVoiceButtonEnabled && !this.mIconified && z3) {
            this.mGoButton.setVisibility(8);
        } else {
            r0 = 8;
        }
        this.mVoiceButton.setVisibility(r0);
        updateSubmitArea();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.widget.SearchView$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.appcompat.widget.SearchView$2] */
    public SearchView(Context context, AttributeSet attributeSet, int r20) {
        super(context, attributeSet, r20);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mReleaseCursorRunnable = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public final void run() {
                CursorAdapter cursorAdapter = SearchView.this.mSuggestionsAdapter;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.changeCursor(null);
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String flattenToShortString;
                SearchView searchView = SearchView.this;
                ImageView imageView = searchView.mSearchButton;
                SearchAutoComplete searchAutoComplete = searchView.mSearchSrcTextView;
                if (view == imageView) {
                    searchView.updateViewsVisibility(false);
                    searchAutoComplete.requestFocus();
                    searchAutoComplete.setImeVisibility(true);
                    View.OnClickListener onClickListener2 = searchView.mOnSearchClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(searchView);
                        return;
                    }
                    return;
                }
                if (view == searchView.mCloseButton) {
                    searchView.onCloseClicked();
                    return;
                }
                if (view == searchView.mGoButton) {
                    searchView.onSubmitQuery();
                    return;
                }
                if (view == searchView.mVoiceButton) {
                    SearchableInfo searchableInfo = searchView.mSearchable;
                    if (searchableInfo != null) {
                        try {
                            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                                Intent intent = new Intent(searchView.mVoiceWebSearchIntent);
                                ComponentName searchActivity = searchableInfo.getSearchActivity();
                                if (searchActivity == null) {
                                    flattenToShortString = null;
                                } else {
                                    flattenToShortString = searchActivity.flattenToShortString();
                                }
                                intent.putExtra("calling_package", flattenToShortString);
                                searchView.getContext().startActivity(intent);
                                return;
                            }
                            if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                                searchView.getContext().startActivity(searchView.createVoiceAppSearchIntent(searchView.mVoiceAppSearchIntent, searchableInfo));
                                return;
                            }
                            return;
                        } catch (ActivityNotFoundException unused) {
                            Log.w("SearchView", "Could not find voice search activity");
                            return;
                        }
                    }
                    return;
                }
                if (view == searchAutoComplete) {
                    searchView.forceSuggestionQuery();
                }
            }
        };
        View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int r9, KeyEvent keyEvent) {
                boolean z;
                int length;
                SearchView searchView = SearchView.this;
                if (searchView.mSearchable == null) {
                    return false;
                }
                SearchAutoComplete searchAutoComplete = searchView.mSearchSrcTextView;
                if (searchAutoComplete.isPopupShowing() && searchAutoComplete.getListSelection() != -1) {
                    if (searchView.mSearchable == null || searchView.mSuggestionsAdapter == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    if (r9 != 66 && r9 != 84 && r9 != 61) {
                        if (r9 != 21 && r9 != 22) {
                            if (r9 != 19) {
                                return false;
                            }
                            searchAutoComplete.getListSelection();
                            return false;
                        }
                        if (r9 == 21) {
                            length = 0;
                        } else {
                            length = searchAutoComplete.length();
                        }
                        searchAutoComplete.setSelection(length);
                        searchAutoComplete.setListSelection(0);
                        searchAutoComplete.clearListSelection();
                        searchAutoComplete.ensureImeVisible();
                    } else {
                        searchView.onItemClicked(searchAutoComplete.getListSelection());
                    }
                    return true;
                }
                if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || r9 != 66) {
                    return false;
                }
                view.cancelLongPress();
                searchView.getContext().startActivity(searchView.createIntent("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                return true;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int r2, KeyEvent keyEvent) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int r3, long j) {
                SearchView.this.onItemClicked(r3);
            }
        };
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> adapterView, View view, int r3, long j) {
                SearchView.this.onItemSelected(r3);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int r3, int r4, int r5) {
                SearchView searchView = SearchView.this;
                Editable text = searchView.mSearchSrcTextView.getText();
                searchView.mUserQuery = text;
                boolean z = !TextUtils.isEmpty(text);
                searchView.updateSubmitButton(z);
                boolean z2 = !z;
                int r0 = 8;
                if (searchView.mVoiceButtonEnabled && !searchView.mIconified && z2) {
                    searchView.mGoButton.setVisibility(8);
                    r0 = 0;
                }
                searchView.mVoiceButton.setVisibility(r0);
                searchView.updateCloseButton();
                searchView.updateSubmitArea();
                charSequence.toString();
                searchView.getClass();
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
            }
        };
        int[] r2 = R$styleable.SearchView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r2, r20, 0);
        TintTypedArray tintTypedArray = new TintTypedArray(context, obtainStyledAttributes);
        ViewCompat.saveAttributeDataForStyleable(this, context, r2, attributeSet, obtainStyledAttributes, r20);
        LayoutInflater.from(context).inflate(tintTypedArray.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.mSearchPlate = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.mSubmitArea = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.mSearchButton = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.mGoButton = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.mCloseButton = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.mVoiceButton = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = imageView5;
        ViewCompat.Api16Impl.setBackground(findViewById, tintTypedArray.getDrawable(10));
        ViewCompat.Api16Impl.setBackground(findViewById2, tintTypedArray.getDrawable(14));
        imageView.setImageDrawable(tintTypedArray.getDrawable(13));
        imageView2.setImageDrawable(tintTypedArray.getDrawable(7));
        imageView3.setImageDrawable(tintTypedArray.getDrawable(4));
        imageView4.setImageDrawable(tintTypedArray.getDrawable(16));
        imageView5.setImageDrawable(tintTypedArray.getDrawable(13));
        this.mSearchHintIcon = tintTypedArray.getDrawable(12);
        TooltipCompat.setTooltipText(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = tintTypedArray.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = tintTypedArray.getResourceId(5, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(textWatcher);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(onKeyListener);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.mOnQueryTextFocusChangeListener;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                }
            }
        });
        setIconifiedByDefault(tintTypedArray.getBoolean(8, true));
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = tintTypedArray.getText(6);
        this.mQueryHint = tintTypedArray.getText(11);
        int r22 = tintTypedArray.getInt(3, -1);
        if (r22 != -1) {
            setImeOptions(r22);
        }
        int r23 = tintTypedArray.getInt(2, -1);
        if (r23 != -1) {
            setInputType(r23);
        }
        setFocusable(tintTypedArray.getBoolean(0, true));
        tintTypedArray.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.mDropDownAnchor = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int r24, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                    int r32;
                    int r62;
                    SearchView searchView = SearchView.this;
                    View view2 = searchView.mDropDownAnchor;
                    if (view2.getWidth() > 1) {
                        Resources resources = searchView.getContext().getResources();
                        int paddingLeft = searchView.mSearchPlate.getPaddingLeft();
                        Rect rect = new Rect();
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(searchView);
                        if (searchView.mIconifiedByDefault) {
                            r32 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
                        } else {
                            r32 = 0;
                        }
                        SearchAutoComplete searchAutoComplete2 = searchView.mSearchSrcTextView;
                        searchAutoComplete2.getDropDownBackground().getPadding(rect);
                        if (isLayoutRtl) {
                            r62 = -rect.left;
                        } else {
                            r62 = paddingLeft - (rect.left + r32);
                        }
                        searchAutoComplete2.setDropDownHorizontalOffset(r62);
                        searchAutoComplete2.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + r32) - paddingLeft);
                    }
                }
            });
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        public boolean mHasPendingShowSoftInputRequest;
        public final AnonymousClass1 mRunShowSoftInputIfNecessary;
        public SearchView mSearchView;
        public int mThreshold;

        /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appcompat.widget.SearchView$SearchAutoComplete$1] */
        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, 0);
            this.mRunShowSoftInputIfNecessary = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                    if (searchAutoComplete.mHasPendingShowSoftInputRequest) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.mHasPendingShowSoftInputRequest = false;
                    }
                }
            };
            this.mThreshold = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int r1 = configuration.screenWidthDp;
            int r2 = configuration.screenHeightDp;
            if (r1 >= 960 && r2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (r1 < 600) {
                if (r1 < 640 || r2 < 480) {
                    return com.animaconnected.secondo.R.styleable.AppTheme_subComplicationDropZoneNotSelected;
                }
                return 192;
            }
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            if (this.mThreshold > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        public final void ensureImeVisible() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
            preQAutoCompleteTextViewReflector.getClass();
            PreQAutoCompleteTextViewReflector.preApi29Check();
            Method method = preQAutoCompleteTextViewReflector.mEnsureImeVisible;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.mHasPendingShowSoftInputRequest) {
                AnonymousClass1 anonymousClass1 = this.mRunShowSoftInputIfNecessary;
                removeCallbacks(anonymousClass1);
                post(anonymousClass1);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int r2, Rect rect) {
            super.onFocusChanged(z, r2, rect);
            SearchView searchView = this.mSearchView;
            searchView.updateViewsVisibility(searchView.mIconified);
            searchView.post(searchView.mUpdateDrawableStateRunnable);
            if (searchView.mSearchSrcTextView.hasFocus()) {
                searchView.forceSuggestionQuery();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int r3, KeyEvent keyEvent) {
            if (r3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.mSearchView.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(r3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.mSearchView.hasFocus() && getVisibility() == 0) {
                boolean z2 = true;
                this.mHasPendingShowSoftInputRequest = true;
                Context context = getContext();
                PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
                if (context.getResources().getConfiguration().orientation != 2) {
                    z2 = false;
                }
                if (z2) {
                    ensureImeVisible();
                }
            }
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            AnonymousClass1 anonymousClass1 = this.mRunShowSoftInputIfNecessary;
            if (!z) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(anonymousClass1);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.mHasPendingShowSoftInputRequest = false;
                    removeCallbacks(anonymousClass1);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.mHasPendingShowSoftInputRequest = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int r1) {
            super.setThreshold(r1);
            this.mThreshold = r1;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
    }
}
