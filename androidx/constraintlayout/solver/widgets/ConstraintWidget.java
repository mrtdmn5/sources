package androidx.constraintlayout.solver.widgets;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public ChainRun horizontalChainRun;
    public boolean inPlaceholder;
    public final ArrayList<ConstraintAnchor> mAnchors;
    public final ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public final ConstraintAnchor mBottom;
    public final ConstraintAnchor mCenter;
    public final ConstraintAnchor mCenterX;
    public final ConstraintAnchor mCenterY;
    public Object mCompanionWidget;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public int mHorizontalChainStyle;
    public final boolean[] mIsInBarrier;
    public final ConstraintAnchor mLeft;
    public final ConstraintAnchor[] mListAnchors;
    public final DimensionBehaviour[] mListDimensionBehaviors;
    public final ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMinHeight;
    public int mMinWidth;
    public final ConstraintWidget[] mNextChainWidget;
    public ConstraintWidget mParent;
    public final ConstraintAnchor mRight;
    public final ConstraintAnchor mTop;
    public float mVerticalBiasPercent;
    public int mVerticalChainStyle;
    public int mVisibility;
    public final float[] mWeight;
    public int mWidth;
    public int mX;
    public int mY;
    public ChainRun verticalChainRun;
    public boolean measured = false;
    public final HorizontalWidgetRun horizontalRun = new HorizontalWidgetRun(this);
    public final VerticalWidgetRun verticalRun = new VerticalWidgetRun(this);
    public final boolean[] isTerminalWidget = {true, true};
    public final int[] wrapMeasure = {0, 0, 0, 0};
    public int mHorizontalResolution = -1;
    public int mVerticalResolution = -1;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintDefaultHeight = 0;
    public final int[] mResolvedMatchConstraintDefault = new int[2];
    public int mMatchConstraintMinWidth = 0;
    public int mMatchConstraintMaxWidth = 0;
    public float mMatchConstraintPercentWidth = 1.0f;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMaxHeight = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    public int mResolvedDimensionRatioSide = -1;
    public float mResolvedDimensionRatio = 1.0f;
    public final int[] mMaxDimension = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float mCircleConstraintAngle = 0.0f;
    public boolean hasBaseline = false;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] r0 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r0;
            try {
                r0[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] r4 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r4;
            try {
                r4[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mLeft = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mTop = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mRight = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBottom = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mBaseline = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterX = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenterY = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor8;
        this.mListAnchors = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.mAnchors = arrayList;
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r60) {
        /*
            Method dump skipped, instructions count: 1616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0448, code lost:            if (r1[1] == r5) goto L298;     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0325 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x041b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyConstraints(androidx.constraintlayout.solver.LinearSystem r34, boolean r35, boolean r36, boolean r37, boolean r38, androidx.constraintlayout.solver.SolverVariable r39, androidx.constraintlayout.solver.SolverVariable r40, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r41, boolean r42, androidx.constraintlayout.solver.widgets.ConstraintAnchor r43, androidx.constraintlayout.solver.widgets.ConstraintAnchor r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, boolean r53, int r54, int r55, int r56, int r57, float r58, boolean r59) {
        /*
            Method dump skipped, instructions count: 1108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final DimensionBehaviour getDimensionBehaviour(int r3) {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        if (r3 == 0) {
            return dimensionBehaviourArr[0];
        }
        if (r3 == 1) {
            return dimensionBehaviourArr[1];
        }
        return null;
    }

    public final int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public final ConstraintWidget getNextChainMember(int r3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (r3 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (r3 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    public final ConstraintWidget getPreviousChainMember(int r3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (r3 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (r3 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    public final int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
        }
        return this.mX;
    }

    public final int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
        }
        return this.mY;
    }

    public final void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int r4, int r5) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), r4, r5);
    }

    public final boolean isChainHead(int r4) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int r42 = r4 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[r42];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 != null && constraintAnchor4.mTarget != constraintAnchor3 && (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[r42 + 1]).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        return false;
    }

    public final boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mVisibility = 0;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r0 = this.mMaxDimension;
        r0[0] = Integer.MAX_VALUE;
        r0[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable();
        this.mTop.resetSolverVariable();
        this.mRight.resetSolverVariable();
        this.mBottom.resetSolverVariable();
        this.mBaseline.resetSolverVariable();
        this.mCenter.resetSolverVariable();
        this.mCenterX.resetSolverVariable();
        this.mCenterY.resetSolverVariable();
    }

    public final void setHeight(int r2) {
        this.mHeight = r2;
        int r0 = this.mMinHeight;
        if (r2 < r0) {
            this.mHeight = r0;
        }
    }

    public final void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public final void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public final void setWidth(int r2) {
        this.mWidth = r2;
        int r0 = this.mMinWidth;
        if (r2 < r0) {
            this.mWidth = r0;
        }
    }

    public String toString() {
        String str = "";
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("");
        if (this.mDebugName != null) {
            str = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("id: "), this.mDebugName, " ");
        }
        m.append(str);
        m.append("(");
        m.append(this.mX);
        m.append(", ");
        m.append(this.mY);
        m.append(") - (");
        m.append(this.mWidth);
        m.append(" x ");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(m, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int r8;
        int r82;
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        boolean z3 = z & horizontalWidgetRun.resolved;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        boolean z4 = z2 & verticalWidgetRun.resolved;
        int r2 = horizontalWidgetRun.start.value;
        int r3 = verticalWidgetRun.start.value;
        int r0 = horizontalWidgetRun.end.value;
        int r1 = verticalWidgetRun.end.value;
        int r5 = r1 - r3;
        if (r0 - r2 < 0 || r5 < 0 || r2 == Integer.MIN_VALUE || r2 == Integer.MAX_VALUE || r3 == Integer.MIN_VALUE || r3 == Integer.MAX_VALUE || r0 == Integer.MIN_VALUE || r0 == Integer.MAX_VALUE || r1 == Integer.MIN_VALUE || r1 == Integer.MAX_VALUE) {
            r0 = 0;
            r1 = 0;
            r2 = 0;
            r3 = 0;
        }
        int r02 = r0 - r2;
        int r12 = r1 - r3;
        if (z3) {
            this.mX = r2;
        }
        if (z4) {
            this.mY = r3;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        if (z3) {
            if (dimensionBehaviourArr[0] == DimensionBehaviour.FIXED && r02 < (r82 = this.mWidth)) {
                r02 = r82;
            }
            this.mWidth = r02;
            int r83 = this.mMinWidth;
            if (r02 < r83) {
                this.mWidth = r83;
            }
        }
        if (z4) {
            if (dimensionBehaviourArr[1] == DimensionBehaviour.FIXED && r12 < (r8 = this.mHeight)) {
                r12 = r8;
            }
            this.mHeight = r12;
            int r84 = this.mMinHeight;
            if (r12 < r84) {
                this.mHeight = r84;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int r7;
        int r0;
        linearSystem.getClass();
        int objectVariableValue = LinearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = LinearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = LinearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = LinearSystem.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                objectVariableValue = dependencyNode.value;
                objectVariableValue3 = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                objectVariableValue2 = dependencyNode3.value;
                objectVariableValue4 = dependencyNode4.value;
            }
        }
        int r4 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || r4 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
            objectVariableValue4 = 0;
        }
        int r1 = objectVariableValue3 - objectVariableValue;
        int r2 = objectVariableValue4 - objectVariableValue2;
        this.mX = objectVariableValue;
        this.mY = objectVariableValue2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && r1 < (r0 = this.mWidth)) {
            r1 = r0;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && r2 < (r7 = this.mHeight)) {
            r2 = r7;
        }
        this.mWidth = r1;
        this.mHeight = r2;
        int r72 = this.mMinHeight;
        if (r2 < r72) {
            this.mHeight = r72;
        }
        int r73 = this.mMinWidth;
        if (r1 < r73) {
            this.mWidth = r73;
        }
    }
}
