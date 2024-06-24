package no.nordicsemi.android.dfu.internal.exception;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes4.dex */
public class RemoteDfuExtendedErrorException extends RemoteDfuException {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public RemoteDfuExtendedErrorException(String str, int r3) {
        super(str, 11);
        this.mError = r3;
    }

    public int getExtendedErrorNumber() {
        return this.mError;
    }

    @Override // no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        sb.append(" (extended error ");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.mError, ")");
    }
}
