package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ChangeBounds extends Transition {
    public static final AnonymousClass4 BOTTOM_RIGHT_ONLY_PROPERTY;
    public static final AnonymousClass3 BOTTOM_RIGHT_PROPERTY;
    public static final AnonymousClass6 POSITION_PROPERTY;
    public static final AnonymousClass5 TOP_LEFT_ONLY_PROPERTY;
    public static final AnonymousClass2 TOP_LEFT_PROPERTY;
    public static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* loaded from: classes.dex */
    public static class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public final View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.transition.ChangeBounds$2] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.transition.ChangeBounds$3] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.transition.ChangeBounds$4] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.transition.ChangeBounds$5] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.transition.ChangeBounds$6] */
    static {
        new Property<Drawable, PointF>() { // from class: androidx.transition.ChangeBounds.1
            public final Rect mBounds = new Rect();

            @Override // android.util.Property
            public final PointF get(Drawable drawable) {
                drawable.copyBounds(this.mBounds);
                return new PointF(r0.left, r0.top);
            }

            @Override // android.util.Property
            public final void set(Drawable drawable, PointF pointF) {
                Drawable drawable2 = drawable;
                PointF pointF2 = pointF;
                Rect rect = this.mBounds;
                drawable2.copyBounds(rect);
                rect.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
                drawable2.setBounds(rect);
            }
        };
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>() { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            public final /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public final void set(ViewBounds viewBounds, PointF pointF) {
                ViewBounds viewBounds2 = viewBounds;
                PointF pointF2 = pointF;
                viewBounds2.getClass();
                viewBounds2.mLeft = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                viewBounds2.mTop = round;
                int r0 = viewBounds2.mTopLeftCalls + 1;
                viewBounds2.mTopLeftCalls = r0;
                if (r0 == viewBounds2.mBottomRightCalls) {
                    ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, round, viewBounds2.mRight, viewBounds2.mBottom);
                    viewBounds2.mTopLeftCalls = 0;
                    viewBounds2.mBottomRightCalls = 0;
                }
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>() { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            public final /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public final void set(ViewBounds viewBounds, PointF pointF) {
                ViewBounds viewBounds2 = viewBounds;
                PointF pointF2 = pointF;
                viewBounds2.getClass();
                viewBounds2.mRight = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                viewBounds2.mBottom = round;
                int r0 = viewBounds2.mBottomRightCalls + 1;
                viewBounds2.mBottomRightCalls = r0;
                if (viewBounds2.mTopLeftCalls == r0) {
                    ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, viewBounds2.mTop, viewBounds2.mRight, round);
                    viewBounds2.mTopLeftCalls = 0;
                    viewBounds2.mBottomRightCalls = 0;
                }
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>() { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            public final /* bridge */ /* synthetic */ PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public final void set(View view, PointF pointF) {
                View view2 = view;
                PointF pointF2 = pointF;
                ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>() { // from class: androidx.transition.ChangeBounds.5
            @Override // android.util.Property
            public final /* bridge */ /* synthetic */ PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public final void set(View view, PointF pointF) {
                View view2 = view;
                PointF pointF2 = pointF;
                ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>() { // from class: androidx.transition.ChangeBounds.6
            @Override // android.util.Property
            public final /* bridge */ /* synthetic */ PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public final void set(View view, PointF pointF) {
                View view2 = view;
                PointF pointF2 = pointF;
                int round = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                ViewUtils.setLeftTopRightBottom(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
            }
        };
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        View view = transitionValues.view;
        if (ViewCompat.Api19Impl.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            HashMap hashMap = transitionValues.values;
            hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            hashMap.put("android:changeBounds:parent", view.getParent());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int r16;
        ChangeBounds changeBounds;
        ObjectAnimator ofObject;
        if (transitionValues != null && transitionValues2 != null) {
            HashMap hashMap = transitionValues.values;
            HashMap hashMap2 = transitionValues2.values;
            ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                int r7 = rect.left;
                int r8 = rect2.left;
                int r9 = rect.top;
                int r10 = rect2.top;
                int r11 = rect.right;
                int r12 = rect2.right;
                int r6 = rect.bottom;
                int r5 = rect2.bottom;
                int r13 = r11 - r7;
                int r14 = r6 - r9;
                int r15 = r12 - r8;
                int r3 = r5 - r10;
                Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                if ((r13 != 0 && r14 != 0) || (r15 != 0 && r3 != 0)) {
                    if (r7 == r8 && r9 == r10) {
                        r16 = 0;
                    } else {
                        r16 = 1;
                    }
                    if (r11 != r12 || r6 != r5) {
                        r16++;
                    }
                } else {
                    r16 = 0;
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    r16++;
                }
                int r0 = r16;
                if (r0 > 0) {
                    View view = transitionValues2.view;
                    ViewUtils.setLeftTopRightBottom(view, r7, r9, r11, r6);
                    if (r0 == 2) {
                        if (r13 == r15 && r14 == r3) {
                            changeBounds = this;
                            ofObject = ObjectAnimator.ofObject(view, POSITION_PROPERTY, (TypeConverter) null, changeBounds.mPathMotion.getPath(r7, r9, r8, r10));
                        } else {
                            changeBounds = this;
                            ViewBounds viewBounds = new ViewBounds(view);
                            ObjectAnimator ofObject2 = ObjectAnimator.ofObject(viewBounds, TOP_LEFT_PROPERTY, (TypeConverter) null, changeBounds.mPathMotion.getPath(r7, r9, r8, r10));
                            ObjectAnimator ofObject3 = ObjectAnimator.ofObject(viewBounds, BOTTOM_RIGHT_PROPERTY, (TypeConverter) null, changeBounds.mPathMotion.getPath(r11, r6, r12, r5));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ofObject2, ofObject3);
                            animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                                private ViewBounds mViewBounds;

                                {
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            ofObject = animatorSet;
                        }
                    } else {
                        changeBounds = this;
                        if (r7 == r8 && r9 == r10) {
                            ofObject = ObjectAnimator.ofObject(view, BOTTOM_RIGHT_ONLY_PROPERTY, (TypeConverter) null, changeBounds.mPathMotion.getPath(r11, r6, r12, r5));
                        } else {
                            ofObject = ObjectAnimator.ofObject(view, TOP_LEFT_ONLY_PROPERTY, (TypeConverter) null, changeBounds.mPathMotion.getPath(r7, r9, r8, r10));
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                        ViewGroupUtils.suppressLayout(viewGroup4, true);
                        changeBounds.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                            public boolean mCanceled = false;

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public final void onTransitionCancel() {
                                ViewGroupUtils.suppressLayout(viewGroup4, false);
                                this.mCanceled = true;
                            }

                            @Override // androidx.transition.Transition.TransitionListener
                            public final void onTransitionEnd(Transition transition) {
                                if (!this.mCanceled) {
                                    ViewGroupUtils.suppressLayout(viewGroup4, false);
                                }
                                transition.removeListener(this);
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public final void onTransitionPause() {
                                ViewGroupUtils.suppressLayout(viewGroup4, false);
                            }

                            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                            public final void onTransitionResume() {
                                ViewGroupUtils.suppressLayout(viewGroup4, true);
                            }
                        });
                    }
                    return ofObject;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
