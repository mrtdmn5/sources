package com.airbnb.lottie.compose;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieComposition;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: LottieClipSpec.kt */
/* loaded from: classes.dex */
public abstract class LottieClipSpec {

    /* compiled from: LottieClipSpec.kt */
    /* loaded from: classes.dex */
    public static final class Frame extends LottieClipSpec {
        public final Integer actualMaxFrame;
        public final Integer max;
        public final boolean maxInclusive;
        public final Integer min;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Frame() {
            /*
                r2 = this;
                r0 = 0
                r1 = 7
                r2.<init>(r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieClipSpec.Frame.<init>():void");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Frame)) {
                return false;
            }
            Frame frame = (Frame) obj;
            if (Intrinsics.areEqual(this.min, frame.min) && Intrinsics.areEqual(this.max, frame.max) && this.maxInclusive == frame.maxInclusive) {
                return true;
            }
            return false;
        }

        @Override // com.airbnb.lottie.compose.LottieClipSpec
        public final float getMaxProgress$lottie_compose_release(LottieComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            if (this.actualMaxFrame == null) {
                return 1.0f;
            }
            return RangesKt___RangesKt.coerceIn(r1.intValue() / composition.endFrame, 0.0f, 1.0f);
        }

        @Override // com.airbnb.lottie.compose.LottieClipSpec
        public final float getMinProgress$lottie_compose_release(LottieComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            if (this.min == null) {
                return 0.0f;
            }
            return RangesKt___RangesKt.coerceIn(r1.intValue() / composition.endFrame, 0.0f, 1.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode;
            int r0 = 0;
            Integer num = this.min;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int r1 = hashCode * 31;
            Integer num2 = this.max;
            if (num2 != null) {
                r0 = num2.hashCode();
            }
            int r12 = (r1 + r0) * 31;
            boolean z = this.maxInclusive;
            int r02 = z;
            if (z != 0) {
                r02 = 1;
            }
            return r12 + r02;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Frame(min=");
            sb.append(this.min);
            sb.append(", max=");
            sb.append(this.max);
            sb.append(", maxInclusive=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.maxInclusive, ')');
        }

        public Frame(Integer num, Integer num2, boolean z) {
            this.min = num;
            this.max = num2;
            this.maxInclusive = z;
            if (num2 == null) {
                num2 = null;
            } else if (!z) {
                num2 = Integer.valueOf(num2.intValue() - 1);
            }
            this.actualMaxFrame = num2;
        }

        public /* synthetic */ Frame(Integer num, Integer num2, int r5) {
            this((r5 & 1) != 0 ? null : num, (r5 & 2) != 0 ? null : num2, (r5 & 4) != 0);
        }
    }

    public abstract float getMaxProgress$lottie_compose_release(LottieComposition lottieComposition);

    public abstract float getMinProgress$lottie_compose_release(LottieComposition lottieComposition);
}
