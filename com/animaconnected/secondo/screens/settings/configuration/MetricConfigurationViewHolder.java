package com.animaconnected.secondo.screens.settings.configuration;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.databinding.ItemConfigurableMetricBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutMetricsConfiguration.kt */
/* loaded from: classes3.dex */
public final class MetricConfigurationViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView tvName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricConfigurationViewHolder(ItemConfigurableMetricBinding binding, final Function1<? super MetricConfigurationViewHolder, Unit> startDrag) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(startDrag, "startDrag");
        TextView tvMetricName = binding.tvMetricName;
        Intrinsics.checkNotNullExpressionValue(tvMetricName, "tvMetricName");
        this.tvName = tvMetricName;
        binding.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.animaconnected.secondo.screens.settings.configuration.MetricConfigurationViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = MetricConfigurationViewHolder._init_$lambda$0(Function1.this, this, view, motionEvent);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Function1 startDrag, MetricConfigurationViewHolder this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(startDrag, "$startDrag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getActionMasked() == 0) {
            startDrag.invoke(this$0);
            return false;
        }
        return false;
    }

    public final TextView getTvName() {
        return this.tvName;
    }
}
