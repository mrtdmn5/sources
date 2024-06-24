package no.nordicsemi.android.dfu.internal.exception;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes4.dex */
public class DfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public DfuException(String str, int r2) {
        super(str);
        this.mError = r2;
    }

    public int getErrorNumber() {
        return this.mError;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        sb.append(" (error ");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.mError & (-16385), ")");
    }
}
