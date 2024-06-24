package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DefaultItemAnimator extends SimpleItemAnimator {
    public static TimeInterpolator sDefaultInterpolator;
    public final ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    public final ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    public final ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    public final ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    public final ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    public final ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class ChangeInfo {
        public final int fromX;
        public final int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public final int toX;
        public final int toY;

        public ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int r3, int r4, int r5, int r6) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
            this.fromX = r3;
            this.fromY = r4;
            this.toX = r5;
            this.toY = r6;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ChangeInfo{oldHolder=");
            sb.append(this.oldHolder);
            sb.append(", newHolder=");
            sb.append(this.newHolder);
            sb.append(", fromX=");
            sb.append(this.fromX);
            sb.append(", fromY=");
            sb.append(this.fromY);
            sb.append(", toX=");
            sb.append(this.toX);
            sb.append(", toY=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.toY, '}');
        }
    }

    /* loaded from: classes.dex */
    public static class MoveInfo {
        public final int fromX;
        public final int fromY;
        public final RecyclerView.ViewHolder holder;
        public final int toX;
        public final int toY;

        public MoveInfo(RecyclerView.ViewHolder viewHolder, int r2, int r3, int r4, int r5) {
            this.holder = viewHolder;
            this.fromX = r2;
            this.fromY = r3;
            this.toX = r4;
            this.toY = r5;
        }
    }

    public static void cancelAll(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((RecyclerView.ViewHolder) arrayList.get(size)).itemView.animate().cancel();
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int r12, int r13, int r14, int r15) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, r12, r13, r14, r15);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        resetAnimation(viewHolder);
        int r3 = (int) ((r14 - r12) - translationX);
        int r4 = (int) ((r15 - r13) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX(-r3);
            viewHolder2.itemView.setTranslationY(-r4);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, r12, r13, r14, r15));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder viewHolder, int r10, int r11, int r12, int r13) {
        View view = viewHolder.itemView;
        int translationX = r10 + ((int) view.getTranslationX());
        int translationY = r11 + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(viewHolder);
        int r102 = r12 - translationX;
        int r112 = r13 - translationY;
        if (r102 == 0 && r112 == 0) {
            dispatchAnimationFinished(viewHolder);
            return false;
        }
        if (r102 != 0) {
            view.setTranslationX(-r102);
        }
        if (r112 != 0) {
            view.setTranslationY(-r112);
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, translationX, translationY, r12, r13));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        if (list.isEmpty() && !super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return false;
        }
        return true;
    }

    public final void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> arrayList = this.mFinishedListeners;
            int size = arrayList.size();
            for (int r2 = 0; r2 < size; r2++) {
                arrayList.get(r2).onAnimationsFinished();
            }
            arrayList.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        ArrayList<MoveInfo> arrayList = this.mPendingMoves;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (arrayList.get(size).holder == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchAnimationFinished(viewHolder);
                arrayList.remove(size);
            }
        }
        endChangeAnimation(viewHolder, this.mPendingChanges);
        if (this.mPendingRemovals.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAnimationFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAnimationFinished(viewHolder);
        }
        ArrayList<ArrayList<ChangeInfo>> arrayList2 = this.mChangesList;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<ChangeInfo> arrayList3 = arrayList2.get(size2);
            endChangeAnimation(viewHolder, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList<ArrayList<MoveInfo>> arrayList4 = this.mMovesList;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<MoveInfo> arrayList5 = arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                }
                if (arrayList5.get(size4).holder == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchAnimationFinished(viewHolder);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.ViewHolder>> arrayList6 = this.mAdditionsList;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList<RecyclerView.ViewHolder> arrayList7 = arrayList6.get(size5);
                if (arrayList7.remove(viewHolder)) {
                    view.setAlpha(1.0f);
                    dispatchAnimationFinished(viewHolder);
                    if (arrayList7.isEmpty()) {
                        arrayList6.remove(size5);
                    }
                }
            } else {
                this.mRemoveAnimations.remove(viewHolder);
                this.mAddAnimations.remove(viewHolder);
                this.mChangeAnimations.remove(viewHolder);
                this.mMoveAnimations.remove(viewHolder);
                dispatchFinishedWhenDone();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        ArrayList<MoveInfo> arrayList = this.mPendingMoves;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = arrayList.get(size);
            View view = moveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchAnimationFinished(moveInfo.holder);
            arrayList.remove(size);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList2 = this.mPendingRemovals;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            dispatchAnimationFinished(arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList3 = this.mPendingAdditions;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = arrayList3.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAnimationFinished(viewHolder);
            arrayList3.remove(size3);
        }
        ArrayList<ChangeInfo> arrayList4 = this.mPendingChanges;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            ChangeInfo changeInfo = arrayList4.get(size4);
            RecyclerView.ViewHolder viewHolder2 = changeInfo.oldHolder;
            if (viewHolder2 != null) {
                endChangeAnimationIfNecessary(changeInfo, viewHolder2);
            }
            RecyclerView.ViewHolder viewHolder3 = changeInfo.newHolder;
            if (viewHolder3 != null) {
                endChangeAnimationIfNecessary(changeInfo, viewHolder3);
            }
        }
        arrayList4.clear();
        if (!isRunning()) {
            return;
        }
        ArrayList<ArrayList<MoveInfo>> arrayList5 = this.mMovesList;
        int size5 = arrayList5.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<MoveInfo> arrayList6 = arrayList5.get(size5);
            int size6 = arrayList6.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    MoveInfo moveInfo2 = arrayList6.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchAnimationFinished(moveInfo2.holder);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.ViewHolder>> arrayList7 = this.mAdditionsList;
        int size7 = arrayList7.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.ViewHolder> arrayList8 = arrayList7.get(size7);
            int size8 = arrayList8.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.ViewHolder viewHolder4 = arrayList8.get(size8);
                    viewHolder4.itemView.setAlpha(1.0f);
                    dispatchAnimationFinished(viewHolder4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
        }
        ArrayList<ArrayList<ChangeInfo>> arrayList9 = this.mChangesList;
        int size9 = arrayList9.size();
        while (true) {
            size9--;
            if (size9 < 0) {
                break;
            }
            ArrayList<ChangeInfo> arrayList10 = arrayList9.get(size9);
            int size10 = arrayList10.size();
            while (true) {
                size10--;
                if (size10 >= 0) {
                    ChangeInfo changeInfo2 = arrayList10.get(size10);
                    RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                    if (viewHolder5 != null) {
                        endChangeAnimationIfNecessary(changeInfo2, viewHolder5);
                    }
                    RecyclerView.ViewHolder viewHolder6 = changeInfo2.newHolder;
                    if (viewHolder6 != null) {
                        endChangeAnimationIfNecessary(changeInfo2, viewHolder6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
        }
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> arrayList11 = this.mFinishedListeners;
        int size11 = arrayList11.size();
        for (int r2 = 0; r2 < size11; r2++) {
            arrayList11.get(r2).onAnimationsFinished();
        }
        arrayList11.clear();
    }

    public final void endChangeAnimation(RecyclerView.ViewHolder viewHolder, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ChangeInfo changeInfo = (ChangeInfo) arrayList.get(size);
                if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                    arrayList.remove(changeInfo);
                }
            } else {
                return;
            }
        }
    }

    public final boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder == viewHolder) {
            changeInfo.oldHolder = null;
        } else {
            return false;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchAnimationFinished(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        long j;
        long j2;
        ArrayList<RecyclerView.ViewHolder> arrayList = this.mPendingRemovals;
        boolean z = !arrayList.isEmpty();
        ArrayList<MoveInfo> arrayList2 = this.mPendingMoves;
        boolean z2 = !arrayList2.isEmpty();
        ArrayList<ChangeInfo> arrayList3 = this.mPendingChanges;
        boolean z3 = !arrayList3.isEmpty();
        ArrayList<RecyclerView.ViewHolder> arrayList4 = this.mPendingAdditions;
        boolean z4 = !arrayList4.isEmpty();
        if (!z && !z2 && !z4 && !z3) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            j = this.mRemoveDuration;
            if (!hasNext) {
                break;
            }
            final RecyclerView.ViewHolder next = it.next();
            final View view = next.itemView;
            final ViewPropertyAnimator animate = view.animate();
            this.mRemoveAnimations.add(next);
            animate.setDuration(j).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    DefaultItemAnimator defaultItemAnimator = this;
                    RecyclerView.ViewHolder viewHolder = next;
                    defaultItemAnimator.dispatchAnimationFinished(viewHolder);
                    defaultItemAnimator.mRemoveAnimations.remove(viewHolder);
                    defaultItemAnimator.dispatchFinishedWhenDone();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    this.getClass();
                }
            }).start();
        }
        arrayList.clear();
        if (z2) {
            final ArrayList<MoveInfo> arrayList5 = new ArrayList<>();
            arrayList5.addAll(arrayList2);
            this.mMovesList.add(arrayList5);
            arrayList2.clear();
            Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList arrayList6 = arrayList5;
                    Iterator it2 = arrayList6.iterator();
                    while (true) {
                        boolean hasNext2 = it2.hasNext();
                        final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        if (hasNext2) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            final RecyclerView.ViewHolder viewHolder = moveInfo.holder;
                            defaultItemAnimator.getClass();
                            final View view2 = viewHolder.itemView;
                            final int r6 = moveInfo.toX - moveInfo.fromX;
                            final int r8 = moveInfo.toY - moveInfo.fromY;
                            if (r6 != 0) {
                                view2.animate().translationX(0.0f);
                            }
                            if (r8 != 0) {
                                view2.animate().translationY(0.0f);
                            }
                            final ViewPropertyAnimator animate2 = view2.animate();
                            defaultItemAnimator.mMoveAnimations.add(viewHolder);
                            animate2.setDuration(defaultItemAnimator.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationCancel(Animator animator) {
                                    int r3 = r6;
                                    View view3 = view2;
                                    if (r3 != 0) {
                                        view3.setTranslationX(0.0f);
                                    }
                                    if (r8 != 0) {
                                        view3.setTranslationY(0.0f);
                                    }
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    animate2.setListener(null);
                                    DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    defaultItemAnimator2.dispatchAnimationFinished(viewHolder2);
                                    defaultItemAnimator2.mMoveAnimations.remove(viewHolder2);
                                    defaultItemAnimator2.dispatchFinishedWhenDone();
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    DefaultItemAnimator.this.getClass();
                                }
                            }).start();
                        } else {
                            arrayList6.clear();
                            defaultItemAnimator.mMovesList.remove(arrayList6);
                            return;
                        }
                    }
                }
            };
            if (z) {
                View view2 = arrayList5.get(0).holder.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimationDelayed(view2, runnable, j);
            } else {
                runnable.run();
            }
        }
        if (z3) {
            final ArrayList<ChangeInfo> arrayList6 = new ArrayList<>();
            arrayList6.addAll(arrayList3);
            this.mChangesList.add(arrayList6);
            arrayList3.clear();
            Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public final void run() {
                    final View view3;
                    ArrayList arrayList7 = arrayList6;
                    Iterator it2 = arrayList7.iterator();
                    while (true) {
                        boolean hasNext2 = it2.hasNext();
                        final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        if (hasNext2) {
                            final ChangeInfo changeInfo = (ChangeInfo) it2.next();
                            defaultItemAnimator.getClass();
                            RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
                            final View view4 = null;
                            if (viewHolder == null) {
                                view3 = null;
                            } else {
                                view3 = viewHolder.itemView;
                            }
                            RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
                            if (viewHolder2 != null) {
                                view4 = viewHolder2.itemView;
                            }
                            ArrayList<RecyclerView.ViewHolder> arrayList8 = defaultItemAnimator.mChangeAnimations;
                            long j3 = defaultItemAnimator.mChangeDuration;
                            if (view3 != null) {
                                final ViewPropertyAnimator duration = view3.animate().setDuration(j3);
                                arrayList8.add(changeInfo.oldHolder);
                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public final void onAnimationEnd(Animator animator) {
                                        duration.setListener(null);
                                        View view5 = view3;
                                        view5.setAlpha(1.0f);
                                        view5.setTranslationX(0.0f);
                                        view5.setTranslationY(0.0f);
                                        ChangeInfo changeInfo2 = changeInfo;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo2.oldHolder;
                                        DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                        defaultItemAnimator2.dispatchAnimationFinished(viewHolder3);
                                        defaultItemAnimator2.mChangeAnimations.remove(changeInfo2.oldHolder);
                                        defaultItemAnimator2.dispatchFinishedWhenDone();
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public final void onAnimationStart(Animator animator) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                        DefaultItemAnimator.this.getClass();
                                    }
                                }).start();
                            }
                            if (view4 != null) {
                                final ViewPropertyAnimator animate2 = view4.animate();
                                arrayList8.add(changeInfo.newHolder);
                                animate2.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public final void onAnimationEnd(Animator animator) {
                                        animate2.setListener(null);
                                        View view5 = view4;
                                        view5.setAlpha(1.0f);
                                        view5.setTranslationX(0.0f);
                                        view5.setTranslationY(0.0f);
                                        ChangeInfo changeInfo2 = changeInfo;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo2.newHolder;
                                        DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                        defaultItemAnimator2.dispatchAnimationFinished(viewHolder3);
                                        defaultItemAnimator2.mChangeAnimations.remove(changeInfo2.newHolder);
                                        defaultItemAnimator2.dispatchFinishedWhenDone();
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public final void onAnimationStart(Animator animator) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.newHolder;
                                        DefaultItemAnimator.this.getClass();
                                    }
                                }).start();
                            }
                        } else {
                            arrayList7.clear();
                            defaultItemAnimator.mChangesList.remove(arrayList7);
                            return;
                        }
                    }
                }
            };
            if (z) {
                View view3 = arrayList6.get(0).oldHolder.itemView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.postOnAnimationDelayed(view3, runnable2, j);
            } else {
                runnable2.run();
            }
        }
        if (z4) {
            final ArrayList<RecyclerView.ViewHolder> arrayList7 = new ArrayList<>();
            arrayList7.addAll(arrayList4);
            this.mAdditionsList.add(arrayList7);
            arrayList4.clear();
            Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList arrayList8 = arrayList7;
                    Iterator it2 = arrayList8.iterator();
                    while (true) {
                        boolean hasNext2 = it2.hasNext();
                        final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        if (hasNext2) {
                            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it2.next();
                            defaultItemAnimator.getClass();
                            final View view4 = viewHolder.itemView;
                            final ViewPropertyAnimator animate2 = view4.animate();
                            defaultItemAnimator.mAddAnimations.add(viewHolder);
                            animate2.alpha(1.0f).setDuration(defaultItemAnimator.mAddDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationCancel(Animator animator) {
                                    view4.setAlpha(1.0f);
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    animate2.setListener(null);
                                    DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    defaultItemAnimator2.dispatchAnimationFinished(viewHolder2);
                                    defaultItemAnimator2.mAddAnimations.remove(viewHolder2);
                                    defaultItemAnimator2.dispatchFinishedWhenDone();
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    defaultItemAnimator.getClass();
                                }
                            }).start();
                        } else {
                            arrayList8.clear();
                            defaultItemAnimator.mAdditionsList.remove(arrayList8);
                            return;
                        }
                    }
                }
            };
            if (!z && !z2 && !z3) {
                runnable3.run();
                return;
            }
            long j3 = 0;
            if (!z) {
                j = 0;
            }
            if (z2) {
                j2 = this.mMoveDuration;
            } else {
                j2 = 0;
            }
            if (z3) {
                j3 = this.mChangeDuration;
            }
            long max = Math.max(j2, j3) + j;
            View view4 = arrayList7.get(0).itemView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postOnAnimationDelayed(view4, runnable3, max);
        }
    }
}
