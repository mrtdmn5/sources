package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.MarginLayoutParamsCompat$Api17Impl;
import androidx.core.view.PointerIconCompat$Api24Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@ViewPager.DecorView
/* loaded from: classes3.dex */
public class TabLayout extends HorizontalScrollView {
    public static final Pools$SynchronizedPool tabPool = new Pools$SynchronizedPool(16);
    public AdapterChangeListener adapterChangeListener;
    public final int contentInsetStart;
    public ViewPagerOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    public TabLayoutOnPageChangeListener pageChangeListener;
    public PagerAdapter pagerAdapter;
    public PagerAdapterObserver pagerAdapterObserver;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    public BaseOnTabSelectedListener selectedListener;
    public final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    public Tab selectedTab;
    public boolean setupViewPagerImplicitly;
    public final SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public final PorterDuff.Mode tabIconTintMode;
    public final int tabIndicatorAnimationDuration;
    public int tabIndicatorAnimationMode;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    public int tabIndicatorHeight;
    public TabIndicatorInterpolator tabIndicatorInterpolator;
    public int tabMaxWidth;
    public final int tabPaddingBottom;
    public final int tabPaddingEnd;
    public final int tabPaddingStart;
    public final int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;
    public Drawable tabSelectedIndicator;
    public int tabSelectedIndicatorColor;
    public final int tabTextAppearance;
    public ColorStateList tabTextColors;
    public final float tabTextMultiLineSize;
    public final float tabTextSize;
    public final Pools$SimplePool tabViewPool;
    public final ArrayList<Tab> tabs;
    public boolean unboundedRipple;
    public ViewPager viewPager;

    /* loaded from: classes3.dex */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        public boolean autoRefresh;

        public AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter, this.autoRefresh);
            }
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* loaded from: classes3.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* loaded from: classes3.dex */
    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* loaded from: classes3.dex */
    public class SlidingTabIndicator extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public ValueAnimator indicatorAnimator;
        public int selectedPosition;
        public float selectionOffset;

        public SlidingTabIndicator(Context context) {
            super(context);
            this.selectedPosition = -1;
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public final void draw(Canvas canvas) {
            int height;
            TabLayout tabLayout = TabLayout.this;
            int height2 = tabLayout.tabSelectedIndicator.getBounds().height();
            if (height2 < 0) {
                height2 = tabLayout.tabSelectedIndicator.getIntrinsicHeight();
            }
            int r2 = tabLayout.tabIndicatorGravity;
            if (r2 != 0) {
                if (r2 != 1) {
                    height = 0;
                    if (r2 != 2) {
                        if (r2 != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (tabLayout.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = tabLayout.tabSelectedIndicator.getBounds();
                tabLayout.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, height2);
                Drawable drawable = tabLayout.tabSelectedIndicator;
                int r0 = tabLayout.tabSelectedIndicatorColor;
                if (r0 != 0) {
                    DrawableCompat$Api21Impl.setTint(drawable, r0);
                } else {
                    DrawableCompat$Api21Impl.setTintList(drawable, null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void jumpIndicatorToSelectedPosition() {
            View childAt = getChildAt(this.selectedPosition);
            TabLayout tabLayout = TabLayout.this;
            TabIndicatorInterpolator tabIndicatorInterpolator = tabLayout.tabIndicatorInterpolator;
            Drawable drawable = tabLayout.tabSelectedIndicator;
            tabIndicatorInterpolator.getClass();
            RectF calculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, childAt);
            drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
            super.onLayout(z, r2, r3, r4, r5);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                updateOrRecreateIndicatorAnimation(this.selectedPosition, -1, false);
            } else {
                jumpIndicatorToSelectedPosition();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                int childCount = getChildCount();
                int r6 = 0;
                for (int r5 = 0; r5 < childCount; r5++) {
                    View childAt = getChildAt(r5);
                    if (childAt.getVisibility() == 0) {
                        r6 = Math.max(r6, childAt.getMeasuredWidth());
                    }
                }
                if (r6 <= 0) {
                    return;
                }
                if (r6 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int r4 = 0; r4 < childCount; r4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(r4).getLayoutParams();
                        if (layoutParams.width != r6 || layoutParams.weight != 0.0f) {
                            layoutParams.width = r6;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    tabLayout.tabGravity = 0;
                    tabLayout.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(r10, r11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r1) {
            super.onRtlPropertiesChanged(r1);
        }

        public final void setSelectedIndicatorHeight(int r5) {
            TabLayout tabLayout = TabLayout.this;
            Rect bounds = tabLayout.tabSelectedIndicator.getBounds();
            tabLayout.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, r5);
            requestLayout();
        }

        public final void tweenIndicatorPosition(View view, View view2, float f) {
            boolean z;
            if (view != null && view.getWidth() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.tabIndicatorInterpolator.updateIndicatorForOffset(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
            } else {
                TabLayout tabLayout2 = TabLayout.this;
                Drawable drawable = tabLayout2.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout2.tabSelectedIndicator.getBounds().bottom);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this);
        }

        public final void updateOrRecreateIndicatorAnimation(final int r4, int r5, boolean z) {
            final View childAt = getChildAt(this.selectedPosition);
            final View childAt2 = getChildAt(r4);
            if (childAt2 == null) {
                jumpIndicatorToSelectedPosition();
                return;
            }
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.indicatorAnimator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration(r5);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(animatorUpdateListener);
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        SlidingTabIndicator.this.selectedPosition = r4;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator) {
                        SlidingTabIndicator.this.selectedPosition = r4;
                    }
                });
                valueAnimator.start();
                return;
            }
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
        }
    }

    /* loaded from: classes3.dex */
    public static class Tab {
        public CharSequence contentDesc;
        public View customView;
        public Drawable icon;
        public TabLayout parent;
        public CharSequence text;
        public TabView view;
        public int position = -1;
        public final int labelVisibilityMode = 1;
        public int id = -1;

        public final void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this, true);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void setText(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public int previousScrollState;
        public int scrollState;
        public final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r6, float f, int r8) {
            boolean z;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int r0 = this.scrollState;
                boolean z2 = false;
                if (r0 == 2 && this.previousScrollState != 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (r0 != 2 || this.previousScrollState != 0) {
                    z2 = true;
                }
                tabLayout.setScrollPosition(r6, f, z, z2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r4) {
            boolean z;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != r4 && r4 < tabLayout.getTabCount()) {
                int r1 = this.scrollState;
                if (r1 != 0 && (r1 != 2 || this.previousScrollState != 0)) {
                    z = false;
                } else {
                    z = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(r4), z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public View badgeAnchorView;
        public BadgeDrawable badgeDrawable;
        public Drawable baseBackgroundDrawable;
        public ImageView customIconView;
        public TextView customTextView;
        public View customView;
        public int defaultMaxLines;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;

        public TabView(Context context) {
            super(context);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            int r5 = TabLayout.this.tabPaddingStart;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api17Impl.setPaddingRelative(this, r5, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.Api24Impl.setPointerIcon(this, PointerIconCompat$Api24Impl.getSystemIcon(getContext(), 1002));
        }

        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = new BadgeDrawable(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int r2 = 0;
            int r5 = 0;
            boolean z = false;
            for (int r3 = 0; r3 < 3; r3++) {
                View view = viewArr[r3];
                if (view != null && view.getVisibility() == 0) {
                    if (z) {
                        r5 = Math.min(r5, view.getTop());
                    } else {
                        r5 = view.getTop();
                    }
                    if (z) {
                        r2 = Math.max(r2, view.getBottom());
                    } else {
                        r2 = view.getBottom();
                    }
                    z = true;
                }
            }
            return r2 - r5;
        }

        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int r2 = 0;
            int r5 = 0;
            boolean z = false;
            for (int r3 = 0; r3 < 3; r3++) {
                View view = viewArr[r3];
                if (view != null && view.getVisibility() == 0) {
                    if (z) {
                        r5 = Math.min(r5, view.getLeft());
                    } else {
                        r5 = view.getLeft();
                    }
                    if (z) {
                        r2 = Math.max(r2, view.getRight());
                    } else {
                        r2 = view.getRight();
                    }
                    z = true;
                }
            }
            return r2 - r5;
        }

        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Object obj;
            Context context;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                StringBuilder sb = new StringBuilder();
                sb.append((Object) contentDescription);
                sb.append(", ");
                BadgeDrawable badgeDrawable2 = this.badgeDrawable;
                if (badgeDrawable2.isVisible()) {
                    boolean hasNumber = badgeDrawable2.hasNumber();
                    BadgeState badgeState = badgeDrawable2.state;
                    if (hasNumber) {
                        if (badgeState.currentState.contentDescriptionQuantityStrings != 0 && (context = badgeDrawable2.contextRef.get()) != null) {
                            int number = badgeDrawable2.getNumber();
                            int r5 = badgeDrawable2.maxBadgeNumber;
                            BadgeState.State state = badgeState.currentState;
                            if (number <= r5) {
                                obj = context.getResources().getQuantityString(state.contentDescriptionQuantityStrings, badgeDrawable2.getNumber(), Integer.valueOf(badgeDrawable2.getNumber()));
                            } else {
                                obj = context.getString(state.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(r5));
                            }
                        }
                    } else {
                        obj = badgeState.currentState.contentDescriptionNumberless;
                    }
                    sb.append(obj);
                    accessibilityNodeInfo.setContentDescription(sb.toString());
                }
                obj = null;
                sb.append(obj);
                accessibilityNodeInfo.setContentDescription(sb.toString());
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.position, 1, isSelected()).mInfo);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.mAction);
            }
            AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;     */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r3 = r2.getTabMaxWidth()
                if (r3 <= 0) goto L1c
                if (r1 == 0) goto L14
                if (r0 <= r3) goto L1c
            L14:
                int r8 = r2.tabMaxWidth
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L1c:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.textView
                if (r0 == 0) goto L9d
                float r0 = r2.tabTextSize
                int r1 = r7.defaultMaxLines
                android.widget.ImageView r3 = r7.iconView
                r4 = 1
                if (r3 == 0) goto L34
                int r3 = r3.getVisibility()
                if (r3 != 0) goto L34
                r1 = r4
                goto L40
            L34:
                android.widget.TextView r3 = r7.textView
                if (r3 == 0) goto L40
                int r3 = r3.getLineCount()
                if (r3 <= r4) goto L40
                float r0 = r2.tabTextMultiLineSize
            L40:
                android.widget.TextView r3 = r7.textView
                float r3 = r3.getTextSize()
                android.widget.TextView r5 = r7.textView
                int r5 = r5.getLineCount()
                android.widget.TextView r6 = r7.textView
                int r6 = androidx.core.widget.TextViewCompat.Api16Impl.getMaxLines(r6)
                int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r3 != 0) goto L5a
                if (r6 < 0) goto L9d
                if (r1 == r6) goto L9d
            L5a:
                int r2 = r2.mode
                r6 = 0
                if (r2 != r4) goto L8e
                if (r3 <= 0) goto L8e
                if (r5 != r4) goto L8e
                android.widget.TextView r2 = r7.textView
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L8d
                float r3 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r3
                int r3 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r3 = r3 - r5
                int r5 = r7.getPaddingRight()
                int r3 = r3 - r5
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L8e
            L8d:
                r4 = r6
            L8e:
                if (r4 == 0) goto L9d
                android.widget.TextView r2 = r7.textView
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.textView
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            L9d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.tab.select();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        public final void tryAttachBadgeToAnchor(View view) {
            boolean z;
            if (this.badgeDrawable != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                BadgeDrawable badgeDrawable = this.badgeDrawable;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.updateBadgeCoordinates(view, null);
                if (badgeDrawable.getCustomBadgeParent() != null) {
                    badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
                } else {
                    view.getOverlay().add(badgeDrawable);
                }
                this.badgeAnchorView = view;
            }
        }

        public final void tryRemoveBadgeFromAnchor() {
            boolean z;
            if (this.badgeDrawable != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.badgeAnchorView;
            if (view != null) {
                BadgeDrawable badgeDrawable = this.badgeDrawable;
                if (badgeDrawable != null) {
                    if (badgeDrawable.getCustomBadgeParent() != null) {
                        badgeDrawable.getCustomBadgeParent().setForeground(null);
                    } else {
                        view.getOverlay().remove(badgeDrawable);
                    }
                }
                this.badgeAnchorView = null;
            }
        }

        public final void tryUpdateBadgeAnchor() {
            boolean z;
            Tab tab;
            Tab tab2;
            if (this.badgeDrawable != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.customView != null) {
                tryRemoveBadgeFromAnchor();
                return;
            }
            ImageView imageView = this.iconView;
            if (imageView != null && (tab2 = this.tab) != null && tab2.icon != null) {
                if (this.badgeAnchorView != imageView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.iconView);
                    return;
                } else {
                    tryUpdateBadgeDrawableBounds(imageView);
                    return;
                }
            }
            TextView textView = this.textView;
            if (textView != null && (tab = this.tab) != null && tab.labelVisibilityMode == 1) {
                if (this.badgeAnchorView != textView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                    return;
                } else {
                    tryUpdateBadgeDrawableBounds(textView);
                    return;
                }
            }
            tryRemoveBadgeFromAnchor();
        }

        public final void tryUpdateBadgeDrawableBounds(View view) {
            boolean z;
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && view == this.badgeAnchorView) {
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.updateBadgeCoordinates(view, null);
            }
        }

        public final void update() {
            View view;
            boolean z;
            Tab tab = this.tab;
            if (tab != null) {
                view = tab.customView;
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.customTextView = textView2;
                if (textView2 != null) {
                    this.defaultMaxLines = TextViewCompat.Api16Impl.getMaxLines(textView2);
                }
                this.customIconView = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            boolean z2 = false;
            if (this.customView == null) {
                if (this.iconView == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.iconView = imageView2;
                    addView(imageView2, 0);
                }
                if (this.textView == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.textView = textView3;
                    addView(textView3);
                    this.defaultMaxLines = TextViewCompat.Api16Impl.getMaxLines(this.textView);
                }
                TextView textView4 = this.textView;
                TabLayout tabLayout = TabLayout.this;
                textView4.setTextAppearance(tabLayout.tabTextAppearance);
                ColorStateList colorStateList = tabLayout.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
                tryUpdateBadgeAnchor();
                final ImageView imageView3 = this.iconView;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view3, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                            View view4 = imageView3;
                            if (view4.getVisibility() == 0) {
                                TabView.this.tryUpdateBadgeDrawableBounds(view4);
                            }
                        }
                    });
                }
                final TextView textView5 = this.textView;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view3, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                            View view4 = textView5;
                            if (view4.getVisibility() == 0) {
                                TabView.this.tryUpdateBadgeDrawableBounds(view4);
                            }
                        }
                    });
                }
            } else {
                TextView textView6 = this.customTextView;
                if (textView6 != null || this.customIconView != null) {
                    updateTextAndIcon(textView6, this.customIconView);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.contentDesc)) {
                setContentDescription(tab.contentDesc);
            }
            if (tab != null) {
                TabLayout tabLayout2 = tab.parent;
                if (tabLayout2 != null) {
                    int selectedTabPosition = tabLayout2.getSelectedTabPosition();
                    if (selectedTabPosition != -1 && selectedTabPosition == tab.position) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.graphics.drawable.RippleDrawable] */
        public final void updateBackgroundDrawable(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int r1 = tabLayout.tabBackgroundResId;
            GradientDrawable gradientDrawable = null;
            if (r1 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, r1);
                this.baseBackgroundDrawable = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (tabLayout.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = tabLayout.tabRippleColorStateList;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{RippleUtils.SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{RippleUtils.getColorForState(colorStateList, RippleUtils.SELECTED_PRESSED_STATE_SET), RippleUtils.getColorForState(colorStateList, RippleUtils.PRESSED_STATE_SET)});
                boolean z = tabLayout.unboundedRipple;
                if (z) {
                    gradientDrawable2 = null;
                }
                if (!z) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(colorStateList2, gradientDrawable2, gradientDrawable);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.setBackground(this, gradientDrawable2);
            tabLayout.invalidate();
        }

        public final void updateTextAndIcon(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int r4;
            Drawable drawable2;
            Tab tab = this.tab;
            CharSequence charSequence2 = null;
            if (tab != null && (drawable2 = tab.icon) != null) {
                drawable = drawable2.mutate();
            } else {
                drawable = null;
            }
            TabLayout tabLayout = TabLayout.this;
            if (drawable != null) {
                DrawableCompat$Api21Impl.setTintList(drawable, tabLayout.tabIconTint);
                PorterDuff.Mode mode = tabLayout.tabIconTintMode;
                if (mode != null) {
                    DrawableCompat$Api21Impl.setTintMode(drawable, mode);
                }
            }
            Tab tab2 = this.tab;
            if (tab2 != null) {
                charSequence = tab2.text;
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    if (this.tab.labelVisibilityMode == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    r4 = (int) ViewUtils.dpToPx(getContext(), 8);
                } else {
                    r4 = 0;
                }
                if (tabLayout.inlineLabel) {
                    if (r4 != MarginLayoutParamsCompat$Api17Impl.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat$Api17Impl.setMarginEnd(marginLayoutParams, r4);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (r4 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = r4;
                    MarginLayoutParamsCompat$Api17Impl.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.tab;
            if (tab3 != null) {
                charSequence2 = tab3.contentDesc;
            }
            if (!z) {
                charSequence = charSequence2;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.tabStyle, 2132083610), attributeSet, R.attr.tabStyle);
        this.tabs = new ArrayList<>();
        this.tabSelectedIndicator = new GradientDrawable();
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools$SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.TabLayout, R.attr.tabStyle, 2132083610, 23);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            materialShapeDrawable.setElevation(ViewCompat.Api21Impl.getElevation(this));
            ViewCompat.Api16Impl.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, obtainStyledAttributes, 5));
        setSelectedTabIndicatorColor(obtainStyledAttributes.getColor(8, 0));
        slidingTabIndicator.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(10, 0));
        setTabIndicatorAnimationMode(obtainStyledAttributes.getInt(7, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(9, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(20, dimensionPixelSize);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(18, dimensionPixelSize);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(17, dimensionPixelSize);
        int resourceId = obtainStyledAttributes.getResourceId(23, 2132083239);
        this.tabTextAppearance = resourceId;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes2, 3);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(24)) {
                this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 24);
            }
            if (obtainStyledAttributes.hasValue(22)) {
                this.tabTextColors = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{obtainStyledAttributes.getColor(22, 0), this.tabTextColors.getDefaultColor()});
            }
            this.tabIconTint = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 3);
            this.tabIconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(4, -1), null);
            this.tabRippleColorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 21);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(6, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(14, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(0, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.mode = obtainStyledAttributes.getInt(15, 1);
            this.tabGravity = obtainStyledAttributes.getInt(2, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(12, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(25, false);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        ArrayList<Tab> arrayList = this.tabs;
        int size = arrayList.size();
        boolean z = false;
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                Tab tab = arrayList.get(r3);
                if (tab != null && tab.icon != null && !TextUtils.isEmpty(tab.text)) {
                    z = true;
                    break;
                }
                r3++;
            } else {
                break;
            }
        }
        if (z && !this.inlineLabel) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        int r1 = this.requestedTabMinWidth;
        if (r1 != -1) {
            return r1;
        }
        int r0 = this.mode;
        if (r0 != 0 && r0 != 2) {
            return 0;
        }
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int r8) {
        boolean z;
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        int childCount = slidingTabIndicator.getChildCount();
        if (r8 < childCount) {
            for (int r3 = 0; r3 < childCount; r3++) {
                View childAt = slidingTabIndicator.getChildAt(r3);
                boolean z2 = true;
                if (r3 == r8) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
                if (r3 != r8) {
                    z2 = false;
                }
                childAt.setActivated(z2);
            }
        }
    }

    @Deprecated
    public final void addOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        ArrayList<BaseOnTabSelectedListener> arrayList = this.selectedListeners;
        if (!arrayList.contains(baseOnTabSelectedListener)) {
            arrayList.add(baseOnTabSelectedListener);
        }
    }

    public final void addTab(Tab tab, boolean z) {
        ArrayList<Tab> arrayList = this.tabs;
        int size = arrayList.size();
        if (tab.parent == this) {
            tab.position = size;
            arrayList.add(size, tab);
            int size2 = arrayList.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                } else {
                    arrayList.get(size).position = size;
                }
            }
            TabView tabView = tab.view;
            tabView.setSelected(false);
            tabView.setActivated(false);
            int r2 = tab.position;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (this.mode == 1 && this.tabGravity == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            this.slidingTabIndicator.addView(tabView, r2, layoutParams);
            if (z) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        addViewInternal(view);
    }

    public final void addViewInternal(View view) {
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            Tab newTab = newTab();
            CharSequence charSequence = tabItem.text;
            if (charSequence != null) {
                newTab.setText(charSequence);
            }
            Drawable drawable = tabItem.icon;
            if (drawable != null) {
                newTab.icon = drawable;
                TabLayout tabLayout = newTab.parent;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    tabLayout.updateTabViews(true);
                }
                TabView tabView = newTab.view;
                if (tabView != null) {
                    tabView.update();
                }
            }
            int r1 = tabItem.customLayout;
            if (r1 != 0) {
                newTab.customView = LayoutInflater.from(newTab.view.getContext()).inflate(r1, (ViewGroup) newTab.view, false);
                TabView tabView2 = newTab.view;
                if (tabView2 != null) {
                    tabView2.update();
                }
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                newTab.contentDesc = tabItem.getContentDescription();
                TabView tabView3 = newTab.view;
                if (tabView3 != null) {
                    tabView3.update();
                }
            }
            addTab(newTab, this.tabs.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void animateToTab(int r8) {
        if (r8 == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isLaidOut(this)) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                int childCount = slidingTabIndicator.getChildCount();
                boolean z = false;
                int r5 = 0;
                while (true) {
                    if (r5 >= childCount) {
                        break;
                    }
                    if (slidingTabIndicator.getChildAt(r5).getWidth() <= 0) {
                        z = true;
                        break;
                    }
                    r5++;
                }
                if (!z) {
                    int scrollX = getScrollX();
                    int calculateScrollXForTab = calculateScrollXForTab(0.0f, r8);
                    if (scrollX != calculateScrollXForTab) {
                        ensureScrollAnimator();
                        this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                        this.scrollAnimator.start();
                    }
                    ValueAnimator valueAnimator = slidingTabIndicator.indicatorAnimator;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        slidingTabIndicator.indicatorAnimator.cancel();
                    }
                    slidingTabIndicator.updateOrRecreateIndicatorAnimation(r8, this.tabIndicatorAnimationDuration, true);
                    return;
                }
            }
        }
        setScrollPosition(r8, 0.0f, true, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:            if (r0 != 2) goto L25;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyModeAndGravity() {
        /*
            r5 = this;
            int r0 = r5.mode
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = r2
            goto L14
        Lb:
            int r0 = r5.contentInsetStart
            int r3 = r5.tabPaddingStart
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r3 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r3 = r5.slidingTabIndicator
            androidx.core.view.ViewCompat.Api17Impl.setPaddingRelative(r3, r0, r2, r2, r2)
            int r0 = r5.mode
            java.lang.String r2 = "TabLayout"
            r4 = 1
            if (r0 == 0) goto L34
            if (r0 == r4) goto L27
            if (r0 == r1) goto L27
            goto L4c
        L27:
            int r0 = r5.tabGravity
            if (r0 != r1) goto L30
            java.lang.String r0 = "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"
            android.util.Log.w(r2, r0)
        L30:
            r3.setGravity(r4)
            goto L4c
        L34:
            int r0 = r5.tabGravity
            if (r0 == 0) goto L41
            if (r0 == r4) goto L3d
            if (r0 == r1) goto L46
            goto L4c
        L3d:
            r3.setGravity(r4)
            goto L4c
        L41:
            java.lang.String r0 = "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead"
            android.util.Log.w(r2, r0)
        L46:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L4c:
            r5.updateTabViews(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.applyModeAndGravity():void");
    }

    public final int calculateScrollXForTab(float f, int r7) {
        SlidingTabIndicator slidingTabIndicator;
        View childAt;
        View view;
        int r0 = this.mode;
        int r1 = 0;
        if ((r0 != 0 && r0 != 2) || (childAt = (slidingTabIndicator = this.slidingTabIndicator).getChildAt(r7)) == null) {
            return 0;
        }
        int r72 = r7 + 1;
        if (r72 < slidingTabIndicator.getChildCount()) {
            view = slidingTabIndicator.getChildAt(r72);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            r1 = view.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int r6 = (int) ((width + r1) * 0.5f * f);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api17Impl.getLayoutDirection(this) == 0) {
            return left + r6;
        }
        return left - r6;
    }

    public final void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.position;
        }
        return -1;
    }

    public final Tab getTabAt(int r2) {
        if (r2 >= 0 && r2 < getTabCount()) {
            return this.tabs.get(r2);
        }
        return null;
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public final Tab newTab() {
        TabView tabView;
        Tab tab = (Tab) tabPool.acquire();
        if (tab == null) {
            tab = new Tab();
        }
        tab.parent = this;
        Pools$SimplePool pools$SimplePool = this.tabViewPool;
        if (pools$SimplePool != null) {
            tabView = (TabView) pools$SimplePool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            tabView.setContentDescription(tab.text);
        } else {
            tabView.setContentDescription(tab.contentDesc);
        }
        tab.view = tabView;
        int r2 = tab.id;
        if (r2 != -1) {
            tabView.setId(r2);
        }
        return tab;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            zzav.setParentAbsoluteElevation(this, (MaterialShapeDrawable) background);
        }
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int r0 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (r0 < slidingTabIndicator.getChildCount()) {
                View childAt = slidingTabIndicator.getChildAt(r0);
                if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).baseBackgroundDrawable) != null) {
                    drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                    tabView.baseBackgroundDrawable.draw(canvas);
                }
                r0++;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), 1, false).mInfo);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (getTabMode() != 0 && getTabMode() != 2) {
            z = false;
        } else {
            z = true;
        }
        if (!z || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:            if (r0 != 2) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:            if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L29;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:            if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L29;     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.requestedTabMaxWidth
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.tabMaxWidth = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.mode
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = r5
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getActionMasked() == 8) {
            if (getTabMode() != 0 && getTabMode() != 2) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void populateFromPagerAdapter() {
        int currentItem;
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        for (int childCount = slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            TabView tabView = (TabView) slidingTabIndicator.getChildAt(childCount);
            slidingTabIndicator.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.tabViewPool.release(tabView);
            }
            requestLayout();
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.parent = null;
            next.view = null;
            next.icon = null;
            next.id = -1;
            next.text = null;
            next.contentDesc = null;
            next.position = -1;
            next.customView = null;
            tabPool.release(next);
        }
        this.selectedTab = null;
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int r1 = 0; r1 < count; r1++) {
                Tab newTab = newTab();
                newTab.setText(this.pagerAdapter.getPageTitle(r1));
                addTab(newTab, false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem), true);
            }
        }
    }

    public final void selectTab(Tab tab, boolean z) {
        int r3;
        Tab tab2 = this.selectedTab;
        ArrayList<BaseOnTabSelectedListener> arrayList = this.selectedListeners;
        if (tab2 == tab) {
            if (tab2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).onTabReselected(tab);
                }
                animateToTab(tab.position);
                return;
            }
            return;
        }
        if (tab != null) {
            r3 = tab.position;
        } else {
            r3 = -1;
        }
        if (z) {
            if ((tab2 == null || tab2.position == -1) && r3 != -1) {
                setScrollPosition(r3, 0.0f, true, true);
            } else {
                animateToTab(r3);
            }
            if (r3 != -1) {
                setSelectedTabView(r3);
            }
        }
        this.selectedTab = tab;
        if (tab2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                arrayList.get(size2).onTabUnselected(tab2);
            }
        }
        if (tab != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                arrayList.get(size3).onTabSelected(tab);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            int r4 = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (r4 < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(r4);
                    if (childAt instanceof TabView) {
                        TabView tabView = (TabView) childAt;
                        tabView.setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
                        TextView textView = tabView.customTextView;
                        if (textView == null && tabView.customIconView == null) {
                            tabView.updateTextAndIcon(tabView.textView, tabView.iconView);
                        } else {
                            tabView.updateTextAndIcon(textView, tabView.customIconView);
                        }
                    }
                    r4++;
                } else {
                    applyModeAndGravity();
                    return;
                }
            }
        }
    }

    public void setInlineLabelResource(int r2) {
        setInlineLabel(getResources().getBoolean(r2));
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public final void setPagerAdapter(PagerAdapter pagerAdapter, boolean z) {
        PagerAdapterObserver pagerAdapterObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (pagerAdapterObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(pagerAdapterObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public final void setScrollPosition(int r5, float f, boolean z, boolean z2) {
        int calculateScrollXForTab;
        int round = Math.round(r5 + f);
        if (round >= 0) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (round < slidingTabIndicator.getChildCount()) {
                if (z2) {
                    ValueAnimator valueAnimator = slidingTabIndicator.indicatorAnimator;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        slidingTabIndicator.indicatorAnimator.cancel();
                    }
                    slidingTabIndicator.selectedPosition = r5;
                    slidingTabIndicator.selectionOffset = f;
                    slidingTabIndicator.tweenIndicatorPosition(slidingTabIndicator.getChildAt(r5), slidingTabIndicator.getChildAt(slidingTabIndicator.selectedPosition + 1), slidingTabIndicator.selectionOffset);
                }
                ValueAnimator valueAnimator2 = this.scrollAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.scrollAnimator.cancel();
                }
                if (r5 < 0) {
                    calculateScrollXForTab = 0;
                } else {
                    calculateScrollXForTab = calculateScrollXForTab(f, r5);
                }
                scrollTo(calculateScrollXForTab, 0);
                if (z) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.tabSelectedIndicator = drawable;
            int r0 = this.tabIndicatorHeight;
            if (r0 == -1) {
                r0 = drawable.getIntrinsicHeight();
            }
            this.slidingTabIndicator.setSelectedIndicatorHeight(r0);
        }
    }

    public void setSelectedTabIndicatorColor(int r1) {
        this.tabSelectedIndicatorColor = r1;
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int r2) {
        if (this.tabIndicatorGravity != r2) {
            this.tabIndicatorGravity = r2;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r2) {
        this.tabIndicatorHeight = r2;
        this.slidingTabIndicator.setSelectedIndicatorHeight(r2);
    }

    public void setTabGravity(int r2) {
        if (this.tabGravity != r2) {
            this.tabGravity = r2;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            ArrayList<Tab> arrayList = this.tabs;
            int size = arrayList.size();
            for (int r1 = 0; r1 < size; r1++) {
                TabView tabView = arrayList.get(r1).view;
                if (tabView != null) {
                    tabView.update();
                }
            }
        }
    }

    public void setTabIconTintResource(int r2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabIndicatorAnimationMode(int r3) {
        this.tabIndicatorAnimationMode = r3;
        if (r3 != 0) {
            if (r3 != 1) {
                if (r3 == 2) {
                    this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
                    return;
                }
                throw new IllegalArgumentException(r3 + " is not a valid TabIndicatorAnimationMode");
            }
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
            return;
        }
        this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        int r2 = SlidingTabIndicator.$r8$clinit;
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        slidingTabIndicator.jumpIndicatorToSelectedPosition();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.postInvalidateOnAnimation(slidingTabIndicator);
    }

    public void setTabMode(int r2) {
        if (r2 != this.mode) {
            this.mode = r2;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            int r4 = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (r4 < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(r4);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int r2 = TabView.$r8$clinit;
                        ((TabView) childAt).updateBackgroundDrawable(context);
                    }
                    r4++;
                } else {
                    return;
                }
            }
        }
    }

    public void setTabRippleColorResource(int r2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            ArrayList<Tab> arrayList = this.tabs;
            int size = arrayList.size();
            for (int r1 = 0; r1 < size; r1++) {
                TabView tabView = arrayList.get(r1).view;
                if (tabView != null) {
                    tabView.update();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            int r4 = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (r4 < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(r4);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int r2 = TabView.$r8$clinit;
                        ((TabView) childAt).updateBackgroundDrawable(context);
                    }
                    r4++;
                } else {
                    return;
                }
            }
        }
    }

    public void setUnboundedRippleResource(int r2) {
        setUnboundedRipple(getResources().getBoolean(r2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public final void updateTabViews(boolean z) {
        int r1 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (r1 < slidingTabIndicator.getChildCount()) {
                View childAt = slidingTabIndicator.getChildAt(r1);
                childAt.setMinimumWidth(getTabMinWidth());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (this.mode == 1 && this.tabGravity == 0) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                } else {
                    layoutParams.width = -2;
                    layoutParams.weight = 0.0f;
                }
                if (z) {
                    childAt.requestLayout();
                }
                r1++;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int r2) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            this.selectedListeners.remove(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public final void setupWithViewPager(ViewPager viewPager, boolean z) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = this.currentVpSelectedListener;
        if (viewPagerOnTabSelectedListener != null) {
            this.selectedListeners.remove(viewPagerOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.pageChangeListener;
            tabLayoutOnPageChangeListener2.scrollState = 0;
            tabLayoutOnPageChangeListener2.previousScrollState = 0;
            viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener2 = new ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener2;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener2);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, true);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            adapterChangeListener2.autoRefresh = true;
            viewPager.addOnAdapterChangeListener(adapterChangeListener2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int r2, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setSelectedTabIndicator(int r2) {
        if (r2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* loaded from: classes3.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(Tab tab) {
            this.viewPager.setCurrentItem(tab.position);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(Tab tab) {
        }
    }
}
