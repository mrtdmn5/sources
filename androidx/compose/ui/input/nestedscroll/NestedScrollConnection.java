package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;

/* compiled from: NestedScrollModifier.kt */
/* loaded from: classes.dex */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY */
    default Object mo51onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return new Velocity(Velocity.Zero);
    }

    /* renamed from: onPostScroll-DzOQY0M */
    default long mo52onPostScrollDzOQY0M(int r1, long j, long j2) {
        int r12 = Offset.$r8$clinit;
        return Offset.Zero;
    }

    /* renamed from: onPreFling-QWom1Mo */
    default Object mo159onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return new Velocity(Velocity.Zero);
    }

    /* renamed from: onPreScroll-OzD1aCk */
    default long mo53onPreScrollOzD1aCk(int r1, long j) {
        int r12 = Offset.$r8$clinit;
        return Offset.Zero;
    }
}
