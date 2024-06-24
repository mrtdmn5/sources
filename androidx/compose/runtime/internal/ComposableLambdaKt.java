package androidx.compose.runtime.internal;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ComposableLambda.kt */
/* loaded from: classes.dex */
public final class ComposableLambdaKt {
    public static final int bitsForSlot(int r0, int r1) {
        return r0 << (((r1 % 10) * 3) + 1);
    }

    public static final ComposableLambdaImpl composableLambda(Composer composer, int r3, Lambda lambda) {
        ComposableLambdaImpl composableLambdaImpl;
        Intrinsics.checkNotNullParameter(composer, "composer");
        composer.startReplaceableGroup(r3);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            composableLambdaImpl = new ComposableLambdaImpl(r3, true);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            composableLambdaImpl = (ComposableLambdaImpl) rememberedValue;
        }
        composableLambdaImpl.update(lambda);
        composer.endReplaceableGroup();
        return composableLambdaImpl;
    }

    public static final ComposableLambdaImpl composableLambdaInstance(int r1, Lambda block, boolean z) {
        Intrinsics.checkNotNullParameter(block, "block");
        ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(r1, z);
        composableLambdaImpl.update(block);
        return composableLambdaImpl;
    }

    public static final boolean replacableWith(RecomposeScope recomposeScope, RecomposeScope recomposeScope2) {
        boolean z;
        boolean z2;
        if (recomposeScope == null) {
            return true;
        }
        if ((recomposeScope instanceof RecomposeScopeImpl) && (recomposeScope2 instanceof RecomposeScopeImpl)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
            if (recomposeScopeImpl.owner != null) {
                Anchor anchor = recomposeScopeImpl.anchor;
                if (anchor != null && anchor.location != Integer.MIN_VALUE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z = true;
                    if (z || Intrinsics.areEqual(recomposeScope, recomposeScope2) || Intrinsics.areEqual(recomposeScopeImpl.anchor, ((RecomposeScopeImpl) recomposeScope2).anchor)) {
                        return true;
                    }
                }
            }
            z = false;
            return z ? true : true;
        }
        return false;
    }
}
