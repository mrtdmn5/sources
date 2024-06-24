package io.ktor.utils.io.core;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class InsufficientSpaceException extends Exception {
    public InsufficientSpaceException() {
        this("Not enough free space");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InsufficientSpaceException(java.lang.String r3, int r4, int r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Not enough free space to write "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = " of "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = " bytes, available "
            r0.append(r3)
            java.lang.String r3 = " bytes."
            java.lang.String r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0.m(r0, r5, r3)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InsufficientSpaceException.<init>(java.lang.String, int, int):void");
    }
}
