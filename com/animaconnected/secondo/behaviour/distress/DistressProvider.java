package com.animaconnected.secondo.behaviour.distress;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviours;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DistressProvider.kt */
/* loaded from: classes3.dex */
public final class DistressProvider {
    private final Behaviours behaviours;
    private final DistressModel distressModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DistressProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DistressProvider create(Context context, Behaviours behaviours) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(behaviours, "behaviours");
            return new DistressProvider(behaviours, DistressModel.Companion.getInstance(context), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DistressProvider(Behaviours behaviours, DistressModel distressModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(behaviours, distressModel);
    }

    public final void setConfiguredOnSlot(Slot watchSlot) {
        Intrinsics.checkNotNullParameter(watchSlot, "watchSlot");
        this.distressModel.setConfigured(true);
        if (watchSlot != Slot.Unknown && watchSlot != Slot.Display) {
            BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DistressProvider$setConfiguredOnSlot$1(this, watchSlot, null), 3);
        }
    }

    public final void setNotConfigured() {
        this.distressModel.setConfigured(false);
    }

    private DistressProvider(Behaviours behaviours, DistressModel distressModel) {
        this.behaviours = behaviours;
        this.distressModel = distressModel;
    }
}
