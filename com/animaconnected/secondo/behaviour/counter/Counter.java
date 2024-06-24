package com.animaconnected.secondo.behaviour.counter;

import com.animaconnected.secondo.provider.counter.CounterProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Counter.kt */
/* loaded from: classes3.dex */
public final class Counter implements Pusher {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "Counter";
    private final String type = TYPE;
    private final String analyticsName = "counter";

    /* compiled from: Counter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Counter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ButtonAction.values().length];
            try {
                r0[ButtonAction.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ButtonAction.DoublePress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ButtonAction.TriplePress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[ButtonAction.QuadruplePress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int r3 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r3 != 1) {
            if (r3 != 2) {
                if (r3 != 3) {
                    if (r3 != 4) {
                        return false;
                    }
                    CounterProvider.getInstance().addCount(4);
                    return true;
                }
                CounterProvider.getInstance().addCount(3);
                return true;
            }
            CounterProvider.getInstance().addCount(2);
            return true;
        }
        CounterProvider.getInstance().addCount(1);
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}
