package com.animaconnected.secondo.screens.details.watch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DetailWatchPager extends LinearLayout {
    private final View mView;
    private final ViewPager mViewPager;

    public DetailWatchPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.detail_watch_layout_pager, this);
        this.mView = inflate;
        this.mViewPager = (ViewPager) inflate.findViewById(R.id.watch_layout_pager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setupPageIndicator$0(View view, MotionEvent motionEvent) {
        return true;
    }

    private void setupPageIndicator(boolean z) {
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) this.mView.findViewById(R.id.page_indicator);
        circlePageIndicator.setViewPager(this.mViewPager);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.detailPagerColor, typedValue, true);
        Context context = getContext();
        int r3 = typedValue.resourceId;
        Object obj = ContextCompat.sLock;
        circlePageIndicator.setHighlightColor(ContextCompat.Api23Impl.getColor(context, r3));
        circlePageIndicator.setBackgroundStrokeColor(ContextCompat.Api23Impl.getColor(getContext(), typedValue.resourceId));
        circlePageIndicator.setOnTouchListener(new DetailWatchPager$$ExternalSyntheticLambda0());
        if (!z) {
            circlePageIndicator.setVisibility(8);
        }
    }

    public void setAdapter(DetailWatchPagerAdapter detailWatchPagerAdapter) {
        boolean z;
        this.mViewPager.setAdapter(detailWatchPagerAdapter);
        Iterator<BaseDetailWatchPage> it = detailWatchPagerAdapter.getItems().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            } else {
                it.next().updateHands(true);
            }
        }
        if (detailWatchPagerAdapter.getCount() <= 1) {
            z = false;
        }
        setupPageIndicator(z);
    }
}
