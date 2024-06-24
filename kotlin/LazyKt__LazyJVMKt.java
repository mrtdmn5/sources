package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
public class LazyKt__LazyJVMKt {

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LazyThreadSafetyMode.values().length];
            try {
                r0[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final SynchronizedLazyImpl lazy(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode mode, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        int r1 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (r1 == 1) {
            return new SynchronizedLazyImpl(initializer);
        }
        if (r1 == 2) {
            return new SafePublicationLazyImpl(initializer);
        }
        if (r1 == 3) {
            return new UnsafeLazyImpl(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }
}
