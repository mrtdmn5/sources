package androidx.compose.material.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.material.ripple.UnprojectedRipple;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: RippleHostView.android.kt */
/* loaded from: classes.dex */
public final class RippleHostView extends View {
    public static final int[] PressedState = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] RestingState = new int[0];
    public Boolean bounded;
    public Long lastRippleStateChangeTimeMillis;
    public Function0<Unit> onInvalidateRipple;
    public RippleHostView$$ExternalSyntheticLambda0 resetRippleRunnable;
    public UnprojectedRipple ripple;

    private final void setRippleState(boolean z) {
        long j;
        int[] r7;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        long j2 = currentAnimationTimeMillis - j;
        if (!z && j2 < 5) {
            RippleHostView$$ExternalSyntheticLambda0 rippleHostView$$ExternalSyntheticLambda0 = new RippleHostView$$ExternalSyntheticLambda0(this);
            this.resetRippleRunnable = rippleHostView$$ExternalSyntheticLambda0;
            postDelayed(rippleHostView$$ExternalSyntheticLambda0, 50L);
        } else {
            if (z) {
                r7 = PressedState;
            } else {
                r7 = RestingState;
            }
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(r7);
            }
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(currentAnimationTimeMillis);
    }

    public static final void setRippleState$lambda$2(RippleHostView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UnprojectedRipple unprojectedRipple = this$0.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        this$0.resetRippleRunnable = null;
    }

    /* renamed from: addRipple-KOepWvA */
    public final void m223addRippleKOepWvA(PressInteraction$Press interaction, boolean z, long j, int r16, long j2, float f, AndroidRippleIndicationInstance$onInvalidateRipple$1 onInvalidateRipple) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(onInvalidateRipple, "onInvalidateRipple");
        if (this.ripple == null || !Intrinsics.areEqual(Boolean.valueOf(z), this.bounded)) {
            UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z);
            setBackground(unprojectedRipple);
            this.ripple = unprojectedRipple;
            this.bounded = Boolean.valueOf(z);
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        Intrinsics.checkNotNull(unprojectedRipple2);
        this.onInvalidateRipple = onInvalidateRipple;
        m224updateRipplePropertiesbiQXAtU(f, r16, j, j2);
        if (z) {
            long j3 = interaction.pressPosition;
            unprojectedRipple2.setHotspot(Offset.m259getXimpl(j3), Offset.m260getYimpl(j3));
        } else {
            unprojectedRipple2.setHotspot(unprojectedRipple2.getBounds().centerX(), unprojectedRipple2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        RippleHostView$$ExternalSyntheticLambda0 rippleHostView$$ExternalSyntheticLambda0 = this.resetRippleRunnable;
        if (rippleHostView$$ExternalSyntheticLambda0 != null) {
            removeCallbacks(rippleHostView$$ExternalSyntheticLambda0);
            RippleHostView$$ExternalSyntheticLambda0 rippleHostView$$ExternalSyntheticLambda02 = this.resetRippleRunnable;
            Intrinsics.checkNotNull(rippleHostView$$ExternalSyntheticLambda02);
            rippleHostView$$ExternalSyntheticLambda02.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        Function0<Unit> function0 = this.onInvalidateRipple;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* renamed from: updateRippleProperties-biQXAtU */
    public final void m224updateRipplePropertiesbiQXAtU(float f, int r5, long j, long j2) {
        long Color;
        boolean m317equalsimpl0;
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple == null) {
            return;
        }
        Integer num = unprojectedRipple.rippleRadius;
        if (num == null || num.intValue() != r5) {
            unprojectedRipple.rippleRadius = Integer.valueOf(r5);
            UnprojectedRipple.MRadiusHelper.INSTANCE.setRadius(unprojectedRipple, r5);
        }
        if (Build.VERSION.SDK_INT < 28) {
            f *= 2;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        Color = ColorKt.Color(Color.m322getRedimpl(j2), Color.m321getGreenimpl(j2), Color.m319getBlueimpl(j2), f, Color.m320getColorSpaceimpl(j2));
        Color color = unprojectedRipple.rippleColor;
        if (color == null) {
            m317equalsimpl0 = false;
        } else {
            m317equalsimpl0 = Color.m317equalsimpl0(color.value, Color);
        }
        if (!m317equalsimpl0) {
            unprojectedRipple.rippleColor = new Color(Color);
            unprojectedRipple.setColor(ColorStateList.valueOf(ColorKt.m327toArgb8_81llA(Color)));
        }
        Rect rect = new Rect(0, 0, MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(j)), MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(j)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        unprojectedRipple.setBounds(rect);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
    }
}
