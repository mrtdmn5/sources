package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ConstraintAnchor {
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;
    public HashSet<ConstraintAnchor> mDependents = null;
    public int mMargin = 0;
    public int mGoneMargin = -1;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r0;
            try {
                r0[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    public final void connect(ConstraintAnchor constraintAnchor, int r3, int r4) {
        if (constraintAnchor == null) {
            reset();
            return;
        }
        this.mTarget = constraintAnchor;
        if (constraintAnchor.mDependents == null) {
            constraintAnchor.mDependents = new HashSet<>();
        }
        this.mTarget.mDependents.add(this);
        if (r3 > 0) {
            this.mMargin = r3;
        } else {
            this.mMargin = 0;
        }
        this.mGoneMargin = r4;
    }

    public final int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.mVisibility == 8) {
            return 0;
        }
        int r0 = this.mGoneMargin;
        if (r0 > -1 && (constraintAnchor = this.mTarget) != null && constraintAnchor.mOwner.mVisibility == 8) {
            return r0;
        }
        return this.mMargin;
    }

    public final boolean hasCenteredDependents() {
        ConstraintAnchor constraintAnchor;
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            ConstraintAnchor next = it.next();
            next.getClass();
            int[] r3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            Type type = next.mType;
            int r32 = r3[type.ordinal()];
            ConstraintWidget constraintWidget = next.mOwner;
            switch (r32) {
                case 1:
                case 6:
                case 7:
                case 8:
                case 9:
                    constraintAnchor = null;
                    break;
                case 2:
                    constraintAnchor = constraintWidget.mRight;
                    break;
                case 3:
                    constraintAnchor = constraintWidget.mLeft;
                    break;
                case 4:
                    constraintAnchor = constraintWidget.mBottom;
                    break;
                case 5:
                    constraintAnchor = constraintWidget.mTop;
                    break;
                default:
                    throw new AssertionError(type.name());
            }
            if (constraintAnchor.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isConnected() {
        if (this.mTarget != null) {
            return true;
        }
        return false;
    }

    public final void reset() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null && (hashSet = constraintAnchor.mDependents) != null) {
            hashSet.remove(this);
        }
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
    }

    public final void resetSolverVariable() {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable.reset();
        }
    }

    public final String toString() {
        return this.mOwner.mDebugName + ":" + this.mType.toString();
    }
}
