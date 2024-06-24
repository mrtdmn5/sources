package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ChainRun extends WidgetRun {
    public int chainStyle;
    public final ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int r6) {
        super(constraintWidget);
        ConstraintWidget constraintWidget2;
        WidgetRun widgetRun;
        boolean z;
        int r5;
        WidgetRun widgetRun2;
        this.widgets = new ArrayList<>();
        this.orientation = r6;
        ConstraintWidget constraintWidget3 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(r6);
        while (true) {
            ConstraintWidget constraintWidget4 = previousChainMember;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            } else {
                previousChainMember = constraintWidget3.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget2;
        int r52 = this.orientation;
        if (r52 == 0) {
            widgetRun = constraintWidget2.horizontalRun;
        } else if (r52 == 1) {
            widgetRun = constraintWidget2.verticalRun;
        } else {
            widgetRun = null;
        }
        ArrayList<WidgetRun> arrayList = this.widgets;
        arrayList.add(widgetRun);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            int r62 = this.orientation;
            if (r62 == 0) {
                widgetRun2 = nextChainMember.horizontalRun;
            } else if (r62 == 1) {
                widgetRun2 = nextChainMember.verticalRun;
            } else {
                widgetRun2 = null;
            }
            arrayList.add(widgetRun2);
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int r0 = this.orientation;
            if (r0 == 0) {
                next.widget.horizontalChainRun = this;
            } else if (r0 == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.mParent).mIsRtl) {
            z = true;
        } else {
            z = false;
        }
        if (z && arrayList.size() > 1) {
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        if (this.orientation == 0) {
            r5 = this.widget.mHorizontalChainStyle;
        } else {
            r5 = this.widget.mVerticalChainStyle;
        }
        this.chainStyle = r5;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ArrayList<WidgetRun> arrayList = this.widgets;
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = arrayList.get(0).widget;
        ConstraintWidget constraintWidget2 = arrayList.get(size - 1).widget;
        int r1 = this.orientation;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (r1 == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = WidgetRun.getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                WidgetRun.addTarget(dependencyNode2, target, margin);
            }
            DependencyNode target2 = WidgetRun.getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                WidgetRun.addTarget(dependencyNode, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = WidgetRun.getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                WidgetRun.addTarget(dependencyNode2, target3, margin3);
            }
            DependencyNode target4 = WidgetRun.getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                WidgetRun.addTarget(dependencyNode, target4, -margin4);
            }
        }
        dependencyNode2.updateDelegate = this;
        dependencyNode.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        int r0 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            if (r0 < arrayList.size()) {
                arrayList.get(r0).applyToWidget();
                r0++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final ConstraintWidget getFirstVisibleWidget() {
        int r0 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            if (r0 < arrayList.size()) {
                ConstraintWidget constraintWidget = arrayList.get(r0).widget;
                if (constraintWidget.mVisibility != 8) {
                    return constraintWidget;
                }
                r0++;
            } else {
                return null;
            }
        }
    }

    public final ConstraintWidget getLastVisibleWidget() {
        ArrayList<WidgetRun> arrayList = this.widgets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = arrayList.get(size).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final long getWrapDimension() {
        ArrayList<WidgetRun> arrayList = this.widgets;
        int size = arrayList.size();
        long j = 0;
        for (int r4 = 0; r4 < size; r4++) {
            j = r5.end.margin + arrayList.get(r4).getWrapDimension() + j + r5.start.margin;
        }
        return j;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        ArrayList<WidgetRun> arrayList = this.widgets;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            if (!arrayList.get(r3).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String str;
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        String concat = "ChainRun ".concat(str);
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            concat = ComposableInvoker$$ExternalSyntheticOutline0.m(ComposableInvoker$$ExternalSyntheticOutline0.m(concat, "<") + next, "> ");
        }
        return concat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a0, code lost:            if (r2 != r3) goto L458;     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01c5, code lost:            r1.resolve(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c2, code lost:            r13 = r13 + 1;        r3 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01c0, code lost:            if (r2 != r3) goto L458;     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x03cf, code lost:            r2 = r2 - r12;     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r27) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.ChainRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }
}
