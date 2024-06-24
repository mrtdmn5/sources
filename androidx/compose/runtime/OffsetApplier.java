package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public final class OffsetApplier<N> implements Applier<N> {
    public final Applier<N> applier;
    public int nesting;
    public final int offset;

    public OffsetApplier(Applier<N> applier, int r3) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.applier = applier;
        this.offset = r3;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        ComposerKt.composeRuntimeError("Clear is not valid on OffsetApplier".toString());
        throw null;
    }

    @Override // androidx.compose.runtime.Applier
    public final void down(N n) {
        this.nesting++;
        this.applier.down(n);
    }

    @Override // androidx.compose.runtime.Applier
    public final N getCurrent() {
        return this.applier.getCurrent();
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertBottomUp(int r2, N n) {
        int r0;
        if (this.nesting == 0) {
            r0 = this.offset;
        } else {
            r0 = 0;
        }
        this.applier.insertBottomUp(r2 + r0, n);
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertTopDown(int r2, N n) {
        int r0;
        if (this.nesting == 0) {
            r0 = this.offset;
        } else {
            r0 = 0;
        }
        this.applier.insertTopDown(r2 + r0, n);
    }

    @Override // androidx.compose.runtime.Applier
    public final void move(int r2, int r3, int r4) {
        int r0;
        if (this.nesting == 0) {
            r0 = this.offset;
        } else {
            r0 = 0;
        }
        this.applier.move(r2 + r0, r3 + r0, r4);
    }

    @Override // androidx.compose.runtime.Applier
    public final void remove(int r2, int r3) {
        int r0;
        if (this.nesting == 0) {
            r0 = this.offset;
        } else {
            r0 = 0;
        }
        this.applier.remove(r2 + r0, r3);
    }

    @Override // androidx.compose.runtime.Applier
    public final void up() {
        boolean z;
        int r0 = this.nesting;
        if (r0 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.nesting = r0 - 1;
            this.applier.up();
        } else {
            ComposerKt.composeRuntimeError("OffsetApplier up called with no corresponding down".toString());
            throw null;
        }
    }
}
