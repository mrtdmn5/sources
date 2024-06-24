package kotlin.math;

import aws.smithy.kotlin.runtime.logging.KotlinLoggingAdapter;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MathJVM.kt */
/* loaded from: classes.dex */
public class MathKt__MathJVMKt implements zzdq {
    public static final /* synthetic */ MathKt__MathJVMKt zza = new MathKt__MathJVMKt();

    public static final int getSign(int r0) {
        if (r0 < 0) {
            return -1;
        }
        if (r0 > 0) {
            return 1;
        }
        return 0;
    }

    public static final int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static final long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [aws.smithy.kotlin.runtime.logging.LoggerKt$warn$1] */
    public static final void warn(KotlinLoggingAdapter kotlinLoggingAdapter, final String msg) {
        Intrinsics.checkNotNullParameter(kotlinLoggingAdapter, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        kotlinLoggingAdapter.warn(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.logging.LoggerKt$warn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return msg;
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzox.zza.zza().zzc());
    }

    public static final int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }
}
