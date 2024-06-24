package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ConstraintWidgetContainer extends WidgetContainer {
    public int mPaddingLeft;
    public int mPaddingTop;
    public final BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    public final DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public BasicMeasure.Measurer mMeasurer = null;
    public boolean mIsRtl = false;
    public final LinearSystem mSystem = new LinearSystem();
    public int mHorizontalChainsSize = 0;
    public int mVerticalChainsSize = 0;
    public ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    public int mOptimizationLevel = 263;
    public boolean mWidthMeasuredTooSmall = false;
    public boolean mHeightMeasuredTooSmall = false;

    public final void addChain(ConstraintWidget constraintWidget, int r7) {
        if (r7 == 0) {
            int r72 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (r72 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            ChainHead[] chainHeadArr2 = this.mHorizontalChainsArray;
            int r1 = this.mHorizontalChainsSize;
            chainHeadArr2[r1] = new ChainHead(constraintWidget, 0, this.mIsRtl);
            this.mHorizontalChainsSize = r1 + 1;
            return;
        }
        if (r7 == 1) {
            int r73 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr3 = this.mVerticalChainsArray;
            if (r73 >= chainHeadArr3.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr3, chainHeadArr3.length * 2);
            }
            ChainHead[] chainHeadArr4 = this.mVerticalChainsArray;
            int r12 = this.mVerticalChainsSize;
            chainHeadArr4[r12] = new ChainHead(constraintWidget, 1, this.mIsRtl);
            this.mVerticalChainsSize = r12 + 1;
        }
    }

    public final void addChildrenToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        boolean z3 = false;
        for (int r2 = 0; r2 < size; r2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(r2);
            boolean[] zArr = constraintWidget.mIsInBarrier;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z3 = true;
            }
        }
        if (z3) {
            for (int r3 = 0; r3 < size; r3++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(r3);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int r6 = 0; r6 < barrier.mWidgetsCount; r6++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[r6];
                        int r8 = barrier.mBarrierType;
                        if (r8 != 0 && r8 != 1) {
                            if (r8 == 2 || r8 == 3) {
                                constraintWidget3.mIsInBarrier[1] = true;
                            }
                        } else {
                            constraintWidget3.mIsInBarrier[0] = true;
                        }
                    }
                }
            }
        }
        for (int r32 = 0; r32 < size; r32++) {
            ConstraintWidget constraintWidget4 = this.mChildren.get(r32);
            constraintWidget4.getClass();
            if (!(constraintWidget4 instanceof VirtualLayout) && !(constraintWidget4 instanceof Guideline)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                constraintWidget4.addToSolver(linearSystem);
            }
        }
        for (int r33 = 0; r33 < size; r33++) {
            ConstraintWidget constraintWidget5 = this.mChildren.get(r33);
            if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget5.addToSolver(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                constraintWidget5.mHorizontalResolution = -1;
                constraintWidget5.mVerticalResolution = -1;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr2[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidget5.mListDimensionBehaviors;
                if (dimensionBehaviour4 != dimensionBehaviour5 && dimensionBehaviourArr3[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    ConstraintAnchor constraintAnchor = constraintWidget5.mLeft;
                    int r10 = constraintAnchor.mMargin;
                    int width = getWidth();
                    ConstraintAnchor constraintAnchor2 = constraintWidget5.mRight;
                    int r11 = width - constraintAnchor2.mMargin;
                    constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
                    constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, r10);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, r11);
                    constraintWidget5.mHorizontalResolution = 2;
                    constraintWidget5.mX = r10;
                    int r112 = r11 - r10;
                    constraintWidget5.mWidth = r112;
                    int r7 = constraintWidget5.mMinWidth;
                    if (r112 < r7) {
                        constraintWidget5.mWidth = r7;
                    }
                }
                if (dimensionBehaviourArr2[1] != dimensionBehaviour5 && dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    ConstraintAnchor constraintAnchor3 = constraintWidget5.mTop;
                    int r72 = constraintAnchor3.mMargin;
                    int height = getHeight();
                    ConstraintAnchor constraintAnchor4 = constraintWidget5.mBottom;
                    int r82 = height - constraintAnchor4.mMargin;
                    constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
                    constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
                    linearSystem.addEquality(constraintAnchor3.mSolverVariable, r72);
                    linearSystem.addEquality(constraintAnchor4.mSolverVariable, r82);
                    if (constraintWidget5.mBaselineDistance > 0 || constraintWidget5.mVisibility == 8) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget5.mBaseline;
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor5);
                        constraintAnchor5.mSolverVariable = createObjectVariable;
                        linearSystem.addEquality(createObjectVariable, constraintWidget5.mBaselineDistance + r72);
                    }
                    constraintWidget5.mVerticalResolution = 2;
                    constraintWidget5.mY = r72;
                    int r83 = r82 - r72;
                    constraintWidget5.mHeight = r83;
                    int r62 = constraintWidget5.mMinHeight;
                    if (r83 < r62) {
                        constraintWidget5.mHeight = r62;
                    }
                }
                if (!(constraintWidget5 instanceof VirtualLayout) && !(constraintWidget5 instanceof Guideline)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    constraintWidget5.addToSolver(linearSystem);
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
    }

    public final boolean directMeasureWithOrientation(int r17, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z5 = z & true;
        DependencyGraph dependencyGraph = this.mDependencyGraph;
        ConstraintWidgetContainer constraintWidgetContainer = dependencyGraph.container;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidgetContainer.getDimensionBehaviour(1);
        int x = constraintWidgetContainer.getX();
        int y = constraintWidgetContainer.getY();
        ArrayList<WidgetRun> arrayList = dependencyGraph.mRuns;
        HorizontalWidgetRun horizontalWidgetRun = constraintWidgetContainer.horizontalRun;
        VerticalWidgetRun verticalWidgetRun = constraintWidgetContainer.verticalRun;
        if (z5 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == r17 && !next.supportsWrapComputation()) {
                    z5 = false;
                    break;
                }
            }
            if (r17 == 0) {
                if (z5 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidgetContainer.setWidth(dependencyGraph.computeWrap(constraintWidgetContainer, 0));
                    horizontalWidgetRun.dimension.resolve(constraintWidgetContainer.getWidth());
                }
            } else if (z5 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setHeight(dependencyGraph.computeWrap(constraintWidgetContainer, 1));
                verticalWidgetRun.dimension.resolve(constraintWidgetContainer.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors;
        if (r17 == 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
            if (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                z2 = true;
                z3 = false;
            } else {
                int width = constraintWidgetContainer.getWidth() + x;
                horizontalWidgetRun.end.resolve(width);
                horizontalWidgetRun.dimension.resolve(width - x);
                z2 = true;
                z3 = z2;
            }
        } else {
            z2 = true;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[1];
            if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer.getHeight() + y;
                verticalWidgetRun.end.resolve(height);
                verticalWidgetRun.dimension.resolve(height - y);
                z3 = z2;
            }
            z3 = false;
        }
        dependencyGraph.measureWidgets();
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == r17 && (next2.widget != constraintWidgetContainer || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.orientation == r17 && (z3 || next3.widget != constraintWidgetContainer)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)) {
                    z4 = false;
                    break;
                }
            }
        }
        z4 = z2;
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c8  */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v16 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void layout() {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mChildren.get(r1).updateFromRuns(z, z2);
        }
    }
}
