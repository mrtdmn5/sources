package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.animaconnected.draganddrop.DragAndDropTargetLayout;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.notification.widget.FillLayout;
import com.animaconnected.watch.device.Capabilities;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BehaviourDragAndDropTargetLayout extends DragAndDropTargetLayout {
    private static final int TYPE_COMPLICATIONS = 0;
    private static final int TYPE_PUSHERS = 1;
    private View mDoubleCrownLine;
    private FrameLayout mDropTargetsDoubleCrownContainerLayout;
    private View mDropTargetsDoubleCrownLayout;
    private boolean mFinishedInflating;
    private final Rect mTmpRect;
    private int mType;

    public BehaviourDragAndDropTargetLayout(Context context) {
        super(context);
        this.mTmpRect = new Rect();
        this.mDropTargetsDoubleCrownContainerLayout = null;
        this.mDropTargetsDoubleCrownLayout = null;
        this.mDoubleCrownLine = null;
        initAttributes(null);
    }

    private void initAttributes(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.BehaviourDragAndDropTargetLayout, 0, 0);
            try {
                this.mType = obtainStyledAttributes.getInteger(0, this.mType);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public TextView createNewNameView(FrameLayout frameLayout) {
        return (TextView) ((FrameLayout) View.inflate(getContext(), com.kronaby.watch.app.R.layout.dropped_marble_name_view, frameLayout)).getChildAt(frameLayout.getChildCount() - 1);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public RelativeLayout getDragAndDropTargetRemoveLayout() {
        if (this.mFinishedInflating) {
            if (this.mDragAndDropTargetRemoveLayout == null) {
                this.mDragAndDropTargetRemoveLayout = (RelativeLayout) findViewById(com.kronaby.watch.app.R.id.draganddrop_source_grid_view_place_holder);
            }
            return this.mDragAndDropTargetRemoveLayout;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getDropTarget(int r2) {
        if (r2 == 0) {
            return findViewById(com.kronaby.watch.app.R.id.drop_container_1);
        }
        if (r2 == 1) {
            return findViewById(com.kronaby.watch.app.R.id.drop_container_2);
        }
        if (r2 == 2) {
            return findViewById(com.kronaby.watch.app.R.id.drop_container_3);
        }
        if (r2 == 3) {
            return findViewById(com.kronaby.watch.app.R.id.drop_container_4);
        }
        return null;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getDropTargetLayer() {
        return findViewById(com.kronaby.watch.app.R.id.drop_target_layer);
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public FrameLayout getDropTargetsContainerLayout() {
        if (this.mFinishedInflating) {
            if (this.mDropTargetsContainerLayout == null) {
                this.mDropTargetsContainerLayout = (FrameLayout) findViewById(com.kronaby.watch.app.R.id.drop_targets_container_layout);
            }
            return this.mDropTargetsContainerLayout;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public FrameLayout getDropTargetsExtraViewContainerLayout() {
        if (this.mFinishedInflating) {
            if (this.mDropTargetsDoubleCrownContainerLayout == null) {
                this.mDropTargetsDoubleCrownContainerLayout = (FrameLayout) findViewById(com.kronaby.watch.app.R.id.drop_targets_double_crown_container_layout);
            }
            return this.mDropTargetsDoubleCrownContainerLayout;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getDropTargetsExtraViewLayout() {
        if (this.mFinishedInflating) {
            if (this.mType == 1) {
                return null;
            }
            if (this.mDropTargetsDoubleCrownLayout == null) {
                Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
                boolean hasOneSubComplication = capabilities.hasOneSubComplication();
                if (capabilities.hasTwoSubComplications()) {
                    this.mDropTargetsDoubleCrownLayout = findViewById(com.kronaby.watch.app.R.id.drop_container_4);
                } else if (hasOneSubComplication) {
                    this.mDropTargetsDoubleCrownLayout = findViewById(com.kronaby.watch.app.R.id.drop_container_3);
                } else {
                    this.mDropTargetsDoubleCrownLayout = findViewById(com.kronaby.watch.app.R.id.drop_container_2);
                }
            }
            return this.mDropTargetsDoubleCrownLayout;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getExtraView() {
        if (this.mFinishedInflating) {
            if (this.mDoubleCrownLine == null) {
                this.mDoubleCrownLine = findViewById(com.kronaby.watch.app.R.id.double_crown_line);
            }
            return this.mDoubleCrownLine;
        }
        throw new RuntimeException("Not finished inflating!");
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public View getOnChildContainerLayoutView(int r5, int r6) {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        View view = null;
        while (it.hasNext()) {
            View next = it.next();
            next.getGlobalVisibleRect(this.mTmpRect);
            if (this.mTmpRect.contains(r5, r6)) {
                view = next;
            }
        }
        return view;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public boolean isDropTargetConnectedTo(int r6) {
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        boolean hasDoubleMainComplication = capabilities.getHasDoubleMainComplication();
        boolean hasSubComplications = capabilities.hasSubComplications();
        boolean hasOneSubComplication = capabilities.hasOneSubComplication();
        boolean hasTwoSubComplications = capabilities.hasTwoSubComplications();
        if (!hasDoubleMainComplication || !ProviderFactory.getDoubleCrownProvider().shouldShowDoubleCrown()) {
            return false;
        }
        if ((hasSubComplications || r6 != 1) && ((!hasOneSubComplication || r6 != 2) && (!hasTwoSubComplications || r6 != 3))) {
            return false;
        }
        return true;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public boolean isDropTargetConnectedToExtraView(int r1) {
        if (r1 == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        FillLayout fillLayout;
        FillLayout fillLayout2;
        FillLayout fillLayout3;
        super.onFinishInflate();
        FillLayout fillLayout4 = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_1);
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        boolean hasSubComplications = capabilities.hasSubComplications();
        boolean hasOneSubComplication = capabilities.hasOneSubComplication();
        boolean hasTwoSubComplications = capabilities.hasTwoSubComplications();
        boolean hasDoubleMainComplication = capabilities.getHasDoubleMainComplication();
        if (this.mType == 0) {
            if (!hasSubComplications && !hasDoubleMainComplication) {
                fillLayout = null;
            } else {
                fillLayout = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_2);
            }
        } else {
            fillLayout = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_2);
        }
        if (this.mType == 0) {
            if (!hasTwoSubComplications && (!hasOneSubComplication || !hasDoubleMainComplication)) {
                fillLayout2 = null;
            } else {
                fillLayout2 = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_3);
            }
        } else {
            fillLayout2 = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_3);
        }
        if (this.mType == 0) {
            if (hasTwoSubComplications && hasDoubleMainComplication) {
                fillLayout3 = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_4);
            } else {
                fillLayout3 = null;
            }
        } else {
            fillLayout3 = (FillLayout) findViewById(com.kronaby.watch.app.R.id.drop_container_4);
        }
        this.mContainerLayoutViews.add(fillLayout4);
        if (fillLayout != null) {
            this.mContainerLayoutViews.add(fillLayout);
        }
        if (fillLayout2 != null) {
            this.mContainerLayoutViews.add(fillLayout2);
        }
        if (fillLayout3 != null) {
            this.mContainerLayoutViews.add(fillLayout3);
        }
        int size = new ArrayList().size();
        FrameLayout[] frameLayoutArr = new FrameLayout[size];
        this.mNameTextViewGroups = frameLayoutArr;
        TextView[] textViewArr = new TextView[size];
        this.mCurrentNameTextViews = textViewArr;
        if (size > 0) {
            frameLayoutArr[0] = null;
            textViewArr[0] = (TextView) ((FrameLayout) View.inflate(getContext(), com.kronaby.watch.app.R.layout.dropped_marble_name_view, this.mNameTextViewGroups[0])).getChildAt(0);
            this.mCurrentNameTextViews[0].setText("");
            if (size > 1) {
                this.mNameTextViewGroups[1] = null;
                this.mCurrentNameTextViews[1] = (TextView) ((FrameLayout) View.inflate(getContext(), com.kronaby.watch.app.R.layout.dropped_marble_name_view, this.mNameTextViewGroups[1])).getChildAt(0);
                this.mCurrentNameTextViews[1].setText("");
            }
            if (size > 2) {
                this.mNameTextViewGroups[2] = null;
                this.mCurrentNameTextViews[2] = (TextView) ((FrameLayout) View.inflate(getContext(), com.kronaby.watch.app.R.layout.dropped_marble_name_view, this.mNameTextViewGroups[2])).getChildAt(0);
                this.mCurrentNameTextViews[2].setText("");
            }
        }
        this.mFinishedInflating = true;
    }

    @Override // com.animaconnected.draganddrop.DragAndDropTargetLayout
    public void resetContainerLayoutViews() {
        Iterator<View> it = this.mContainerLayoutViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Context dragAndDropContext = this.mDragAndDropController.getDragAndDropContext();
            Object obj = ContextCompat.sLock;
            next.setBackgroundColor(ContextCompat.Api23Impl.getColor(dragAndDropContext, com.kronaby.watch.app.R.color.transparent));
        }
    }

    public BehaviourDragAndDropTargetLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpRect = new Rect();
        this.mDropTargetsDoubleCrownContainerLayout = null;
        this.mDropTargetsDoubleCrownLayout = null;
        this.mDoubleCrownLine = null;
        initAttributes(attributeSet);
    }

    public BehaviourDragAndDropTargetLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mTmpRect = new Rect();
        this.mDropTargetsDoubleCrownContainerLayout = null;
        this.mDropTargetsDoubleCrownLayout = null;
        this.mDoubleCrownLine = null;
        initAttributes(attributeSet);
    }
}
