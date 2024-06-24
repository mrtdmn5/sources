package com.animaconnected.secondo.screens.settings.configuration;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.databinding.FragmentWorkoutMetricsConfigurationBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.widget.TopFadeRecyclerView;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.workout.ConfigureMetricViewModel;
import com.animaconnected.watch.workout.UIWorkoutMetric;
import com.google.common.collect.Hashing;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WorkoutMetricsConfiguration.kt */
/* loaded from: classes3.dex */
public final class WorkoutMetricsConfiguration extends BaseFragment {
    public static final String keySessionType = "type";
    private MetricConfigurationAdapter adapter;
    private final ItemTouchHelper itemTouchHelper;
    private final WorkoutMetricsConfiguration$itemTouchHelperCallback$1 itemTouchHelperCallback;
    private final String name;
    private SessionType sessionType;
    private ConfigureMetricViewModel viewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WorkoutMetricsConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutMetricsConfiguration newInstance(SessionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putInt("type", type.getId());
            WorkoutMetricsConfiguration workoutMetricsConfiguration = new WorkoutMetricsConfiguration();
            workoutMetricsConfiguration.setArguments(bundle);
            return workoutMetricsConfiguration;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.animaconnected.secondo.screens.settings.configuration.WorkoutMetricsConfiguration$itemTouchHelperCallback$1, androidx.recyclerview.widget.ItemTouchHelper$Callback] */
    public WorkoutMetricsConfiguration() {
        ?? r0 = new ItemTouchHelper.Callback() { // from class: com.animaconnected.secondo.screens.settings.configuration.WorkoutMetricsConfiguration$itemTouchHelperCallback$1
            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                BuildersKt.launch$default(Hashing.getLifecycleScope(WorkoutMetricsConfiguration.this), null, null, new WorkoutMetricsConfiguration$itemTouchHelperCallback$1$clearView$1(WorkoutMetricsConfiguration.this, null), 3);
                super.clearView(recyclerView, viewHolder);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                MetricConfigurationAdapter metricConfigurationAdapter;
                MetricConfigurationAdapter metricConfigurationAdapter2;
                MetricConfigurationAdapter metricConfigurationAdapter3;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                Intrinsics.checkNotNullParameter(target, "target");
                metricConfigurationAdapter = WorkoutMetricsConfiguration.this.adapter;
                if (metricConfigurationAdapter != null) {
                    UIWorkoutMetric remove = metricConfigurationAdapter.getItems().remove(viewHolder.getBindingAdapterPosition());
                    metricConfigurationAdapter2 = WorkoutMetricsConfiguration.this.adapter;
                    if (metricConfigurationAdapter2 != null) {
                        metricConfigurationAdapter2.getItems().add(target.getBindingAdapterPosition(), remove);
                        metricConfigurationAdapter3 = WorkoutMetricsConfiguration.this.adapter;
                        if (metricConfigurationAdapter3 != null) {
                            metricConfigurationAdapter3.notifyItemMoved(viewHolder.getBindingAdapterPosition(), target.getBindingAdapterPosition());
                            return true;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                throw null;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int r2) {
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            }
        };
        this.itemTouchHelperCallback = r0;
        this.itemTouchHelper = new ItemTouchHelper(r0);
        this.name = "WorkoutMetricsConfiguration";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sessionType = SessionType.Companion.fromId(Integer.valueOf(requireArguments().getInt("type")));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Object runBlocking;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.viewModel = new ConfigureMetricViewModel(ProviderFactory.getWatch().getWatchManager().getPreferences());
        runBlocking = BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WorkoutMetricsConfiguration$onCreateView$1(this, null));
        this.adapter = new MetricConfigurationAdapter((List) runBlocking, new Function1<MetricConfigurationViewHolder, Unit>() { // from class: com.animaconnected.secondo.screens.settings.configuration.WorkoutMetricsConfiguration$onCreateView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetricConfigurationViewHolder metricConfigurationViewHolder) {
                invoke2(metricConfigurationViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetricConfigurationViewHolder it) {
                ItemTouchHelper itemTouchHelper;
                Intrinsics.checkNotNullParameter(it, "it");
                itemTouchHelper = WorkoutMetricsConfiguration.this.itemTouchHelper;
                if (!itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, it)) {
                    Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
                    return;
                }
                if (it.itemView.getParent() != itemTouchHelper.mRecyclerView) {
                    Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
                    return;
                }
                VelocityTracker velocityTracker = itemTouchHelper.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                itemTouchHelper.mVelocityTracker = VelocityTracker.obtain();
                itemTouchHelper.mDy = 0.0f;
                itemTouchHelper.mDx = 0.0f;
                itemTouchHelper.select(it, 2);
            }
        });
        FragmentWorkoutMetricsConfigurationBinding inflate = FragmentWorkoutMetricsConfigurationBinding.inflate(inflater, viewGroup, false);
        TopFadeRecyclerView topFadeRecyclerView = inflate.rvMetricConfigure;
        MetricConfigurationAdapter metricConfigurationAdapter = this.adapter;
        if (metricConfigurationAdapter != null) {
            topFadeRecyclerView.setAdapter(metricConfigurationAdapter);
            this.itemTouchHelper.attachToRecyclerView(inflate.rvMetricConfigure);
            LinearLayout rootView = inflate.rootView;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        throw null;
    }
}
