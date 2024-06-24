package com.animaconnected.draganddrop;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.animaconnected.draganddrop.utils.LayoutPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DragAndDropTargetLayout extends FrameLayout implements View.OnClickListener {
    private float mAnimationTranslationAmount;
    private Animator.AnimatorListener mAnimatorListener;
    protected final ArrayList<View> mContainerLayoutViews;
    protected TextView[] mCurrentNameTextViews;
    protected DragAndDropController mDragAndDropController;
    protected RelativeLayout mDragAndDropTargetRemoveLayout;
    private final ArrayList<AnimatorSet> mDropTargetAnimators;
    protected FrameLayout mDropTargetsContainerLayout;
    protected FrameLayout[] mNameTextViewGroups;

    public DragAndDropTargetLayout(Context context) {
        this(context, null, 0);
    }

    private TextView displayNameViewText(final TextView textView, final FrameLayout frameLayout, String str) {
        if (textView == null) {
            return createNewNameView(frameLayout);
        }
        if (!textView.getText().equals(str)) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", 0.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(200L);
            ofFloat.start();
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.draganddrop.DragAndDropTargetLayout.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    frameLayout.removeView(textView);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            TextView createNewNameView = createNewNameView(frameLayout);
            createNewNameView.setText(str);
            createNewNameView.setAlpha(0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(createNewNameView, "alpha", 1.0f);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.setStartDelay(200L);
            ofFloat2.setDuration(250L);
            ofFloat2.start();
            return createNewNameView;
        }
        return textView;
    }

    private float getTranslationAmountFromGroup(int r3) {
        float dimension = getResources().getDimension(R.dimen.drag_targets_animation_translation) * this.mAnimationTranslationAmount;
        if (r3 == 0 || isDropTargetConnectedTo(r3)) {
            return dimension * (-1.0f);
        }
        return dimension;
    }

    public void animateInDropTargetView(View view, int r8, int r9, int r10) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            view.setTranslationX(getTranslationAmountFromGroup(r8));
            view.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f);
            ofFloat.setDuration(r9);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
            ofFloat2.setDuration(r10);
            Animator.AnimatorListener animatorListener = this.mAnimatorListener;
            if (animatorListener != null) {
                animatorSet.addListener(animatorListener);
            }
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
            animatorSet.start();
            this.mDropTargetAnimators.add(animatorSet);
        }
    }

    public void animateInDropTargets(int r5, int r6) {
        View dropTargetLayer = getDropTargetLayer();
        if (dropTargetLayer != null) {
            dropTargetLayer.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dropTargetLayer, "alpha", 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setStartDelay(r5);
            ofFloat.setDuration(r6);
            ofFloat.start();
        }
    }

    public void animateOutDropTargetView(View view, int r8, int r9, int r10) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getTranslationAmountFromGroup(r8));
            ofFloat.setDuration(r9);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
            ofFloat2.setDuration(r10);
            Animator.AnimatorListener animatorListener = this.mAnimatorListener;
            if (animatorListener != null) {
                animatorSet.addListener(animatorListener);
            }
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
            animatorSet.start();
            this.mDropTargetAnimators.add(animatorSet);
        }
    }

    public void animateOutDropTargets(int r5) {
        View dropTargetLayer = getDropTargetLayer();
        if (dropTargetLayer != null) {
            if (r5 <= 0) {
                dropTargetLayer.setAlpha(0.0f);
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dropTargetLayer, "alpha", 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(r5);
            ofFloat.start();
        }
    }

    public void cancelDropTargetAnimations() {
        Iterator<AnimatorSet> it = this.mDropTargetAnimators.iterator();
        while (it.hasNext()) {
            AnimatorSet next = it.next();
            if (next.isRunning()) {
                next.cancel();
            }
        }
        this.mDropTargetAnimators.clear();
    }

    /* renamed from: clearContainerLayoutViews, reason: merged with bridge method [inline-methods] */
    public void lambda$destroy$0() {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = (ViewGroup) it.next();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                LayoutPool.getInstance().poolView(viewGroup.getChildAt(childCount));
            }
            viewGroup.removeAllViews();
        }
    }

    public TextView createNewNameView(FrameLayout frameLayout) {
        return null;
    }

    public void destroy(int r5) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.animaconnected.draganddrop.DragAndDropTargetLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DragAndDropTargetLayout.this.lambda$destroy$0();
            }
        }, r5);
    }

    public ArrayList<View> getChildContainerViews() {
        return this.mContainerLayoutViews;
    }

    public abstract RelativeLayout getDragAndDropTargetRemoveLayout();

    public View getDropTarget(int r1) {
        return null;
    }

    public View getDropTargetLayer() {
        return null;
    }

    public abstract FrameLayout getDropTargetsContainerLayout();

    public abstract FrameLayout getDropTargetsExtraViewContainerLayout();

    public abstract View getDropTargetsExtraViewLayout();

    public abstract View getExtraView();

    public int getItemCount() {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            KeyEvent.Callback callback = (View) it.next();
            if (callback instanceof ContainerLayout) {
                r1 += ((ContainerLayout) callback).getNumberOfItems();
            } else {
                throw new RuntimeException("Unexpected type of layout!");
            }
        }
        return r1;
    }

    public abstract View getOnChildContainerLayoutView(int r1, int r2);

    public void init(DragAndDropController dragAndDropController) {
        this.mDragAndDropController = dragAndDropController;
    }

    public boolean isDropTargetConnectedTo(int r1) {
        return false;
    }

    public boolean isDropTargetConnectedToExtraView(int r1) {
        return false;
    }

    public void replaceView(View view, View view2) {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = (ViewGroup) it.next();
            int r2 = 0;
            while (true) {
                if (r2 >= viewGroup.getChildCount()) {
                    break;
                }
                int indexOfChild = viewGroup.indexOfChild(view);
                if (indexOfChild != -1) {
                    viewGroup.removeView(view);
                    LayoutPool.getInstance().poolView(view);
                    viewGroup.addView(view2, indexOfChild);
                    break;
                }
                r2++;
            }
        }
    }

    public abstract void resetContainerLayoutViews();

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorListener = animatorListener;
    }

    public void setAnimatorTranslationAmount(float f) {
        this.mAnimationTranslationAmount = f;
    }

    public void updateNameText(int r4, String str) {
        Resources resources;
        int r0;
        FrameLayout[] frameLayoutArr = this.mNameTextViewGroups;
        if (r4 < frameLayoutArr.length) {
            TextView[] textViewArr = this.mCurrentNameTextViews;
            textViewArr[r4] = displayNameViewText(textViewArr[r4], frameLayoutArr[r4], str);
            if (str.equals(str.toUpperCase())) {
                resources = getResources();
                r0 = R.dimen.marble_text_size_upper_case;
            } else {
                resources = getResources();
                r0 = R.dimen.marble_text_size;
            }
            this.mCurrentNameTextViews[r4].setTextSize(((int) resources.getDimension(r0)) / getResources().getDisplayMetrics().density);
        }
    }

    public void updateNameTexts(String... strArr) {
        if (strArr != null) {
            for (int r0 = 0; r0 < strArr.length; r0++) {
                updateNameText(r0, strArr[r0]);
            }
        }
    }

    public DragAndDropTargetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragAndDropTargetLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mNameTextViewGroups = new FrameLayout[0];
        this.mCurrentNameTextViews = new TextView[0];
        this.mContainerLayoutViews = new ArrayList<>();
        this.mDragAndDropTargetRemoveLayout = null;
        this.mDropTargetsContainerLayout = null;
        this.mDropTargetAnimators = new ArrayList<>();
        setClickable(true);
        setEnabled(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnClickListener(this);
    }

    public void animateOutDropTargets(List<Integer> list, int r7, int r8) {
        boolean z = false;
        for (Integer num : list) {
            animateOutDropTargetView(getDropTarget(num.intValue()), num.intValue(), r7, r8);
            if (isDropTargetConnectedToExtraView(num.intValue())) {
                z = true;
            }
        }
        View extraView = getExtraView();
        if (extraView == null || !z) {
            return;
        }
        animateOutDropTargetView(extraView, 0, r7, r8);
    }

    public void animateInDropTargets(List<Integer> list, int r7, int r8) {
        boolean z = false;
        for (Integer num : list) {
            animateInDropTargetView(getDropTarget(num.intValue()), num.intValue(), r7, r8);
            if (isDropTargetConnectedToExtraView(num.intValue())) {
                z = true;
            }
        }
        View extraView = getExtraView();
        if (extraView == null || !z) {
            return;
        }
        animateInDropTargetView(extraView, 0, r7, r8);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void update() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
