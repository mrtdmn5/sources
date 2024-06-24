package com.animaconnected.secondo.screens.settings.configuration;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.databinding.ItemConfigurableMetricBinding;
import com.animaconnected.watch.workout.UIWorkoutMetric;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutMetricsConfiguration.kt */
/* loaded from: classes3.dex */
public final class MetricConfigurationAdapter extends RecyclerView.Adapter<MetricConfigurationViewHolder> {
    public static final int $stable = 8;
    private final List<UIWorkoutMetric> items;
    private final Function1<MetricConfigurationViewHolder, Unit> startDrag;

    /* JADX WARN: Multi-variable type inference failed */
    public MetricConfigurationAdapter(List<UIWorkoutMetric> items, Function1<? super MetricConfigurationViewHolder, Unit> startDrag) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(startDrag, "startDrag");
        this.items = items;
        this.startDrag = startDrag;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final List<UIWorkoutMetric> getItems() {
        return this.items;
    }

    public final Function1<MetricConfigurationViewHolder, Unit> getStartDrag() {
        return this.startDrag;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MetricConfigurationViewHolder holder, int r3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTvName().setText(this.items.get(r3).getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MetricConfigurationViewHolder onCreateViewHolder(ViewGroup parent, int r4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemConfigurableMetricBinding inflate = ItemConfigurableMetricBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MetricConfigurationViewHolder(inflate, new Function1<MetricConfigurationViewHolder, Unit>() { // from class: com.animaconnected.secondo.screens.settings.configuration.MetricConfigurationAdapter$onCreateViewHolder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetricConfigurationViewHolder metricConfigurationViewHolder) {
                invoke2(metricConfigurationViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetricConfigurationViewHolder event) {
                Intrinsics.checkNotNullParameter(event, "event");
                MetricConfigurationAdapter.this.getStartDrag().invoke(event);
            }
        });
    }
}
