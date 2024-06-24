package no.nordicsemi.android.dfu.internal.exception;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes4.dex */
public class RemoteDfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public RemoteDfuException(String str, int r2) {
        super(str);
        this.mState = r2;
    }

    public int getErrorNumber() {
        return this.mState;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        sb.append(" (error ");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.mState, ")");
    }
}
