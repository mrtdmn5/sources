package com.animaconnected.secondo.behaviour.temperature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import com.animaconnected.secondo.databinding.FragmentDetailsTemperatureBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$$ExternalSyntheticLambda2;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.SlotScalesHelper;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.types.Empty;
import com.animaconnected.watch.provider.weather.TemperatureProvider;
import com.animaconnected.watch.provider.weather.TemperatureState;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: TemperatureFragment.kt */
/* loaded from: classes3.dex */
public final class TemperatureFragment extends BaseDetailsFragment {
    private AnimatedToolbar animatedToolbar;
    private FragmentDetailsTemperatureBinding binding;
    private Drawable checkMark;
    private View touchAreaToolbarIcon;
    private WeatherViewModel weatherViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemperatureFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDetailsFragment newInstance(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            TemperatureFragment temperatureFragment = new TemperatureFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", Temperature.TYPE);
            temperatureFragment.setArguments(bundle);
            return temperatureFragment;
        }

        private Companion() {
        }
    }

    public static final void onCreateView$lambda$3$lambda$1(TemperatureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeatherViewModel weatherViewModel = this$0.weatherViewModel;
        if (weatherViewModel != null) {
            weatherViewModel.setUseMinuteScale(true);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
            throw null;
        }
    }

    public static final void onCreateView$lambda$3$lambda$2(TemperatureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeatherViewModel weatherViewModel = this$0.weatherViewModel;
        if (weatherViewModel != null) {
            weatherViewModel.setUseMinuteScale(false);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
            throw null;
        }
    }

    private final void showBottomOverview() {
        WatchProvider watch = ProviderFactory.getWatch();
        Behaviour behaviour = watch.getBehaviours().getBehaviour(getType());
        if (behaviour == null) {
            behaviour = Empty.INSTANCE;
        }
        for (SlotScalesHelper.SlotScale slotScale : SlotScalesHelper.INSTANCE.getSlotScales(watch.getCapabilities(), behaviour, getSlot())) {
            if (slotScale.getSlot() != Slot.MainComplication && slotScale.getSlot() != Slot.MainComplicationDouble) {
                if (slotScale.getSlot() == Slot.SubComplication1 || slotScale.getSlot() == Slot.SubComplication2) {
                    FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding = this.binding;
                    if (fragmentDetailsTemperatureBinding != null) {
                        LinearLayout overviewSubDialContainer = fragmentDetailsTemperatureBinding.overviewSubDialContainer;
                        Intrinsics.checkNotNullExpressionValue(overviewSubDialContainer, "overviewSubDialContainer");
                        ViewKt.visible(overviewSubDialContainer);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                }
            } else {
                FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding2 = this.binding;
                if (fragmentDetailsTemperatureBinding2 != null) {
                    LinearLayout overviewCrownContainer = fragmentDetailsTemperatureBinding2.overviewCrownContainer;
                    Intrinsics.checkNotNullExpressionValue(overviewCrownContainer, "overviewCrownContainer");
                    ViewKt.visible(overviewCrownContainer);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            }
        }
        FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding3 = this.binding;
        if (fragmentDetailsTemperatureBinding3 != null) {
            if (fragmentDetailsTemperatureBinding3.overviewCrownContainer.getVisibility() == 0) {
                FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding4 = this.binding;
                if (fragmentDetailsTemperatureBinding4 != null) {
                    if (fragmentDetailsTemperatureBinding4.overviewSubDialContainer.getVisibility() == 0) {
                        FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding5 = this.binding;
                        if (fragmentDetailsTemperatureBinding5 != null) {
                            ImageView slotDivider = fragmentDetailsTemperatureBinding5.slotDivider;
                            Intrinsics.checkNotNullExpressionValue(slotDivider, "slotDivider");
                            ViewKt.visible(slotDivider);
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final void updateViews(TemperatureState temperatureState) {
        String string;
        String str;
        FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding = this.binding;
        String str2 = null;
        if (fragmentDetailsTemperatureBinding != null) {
            boolean z = false;
            if (temperatureState.isMinutes()) {
                TextView textView = fragmentDetailsTemperatureBinding.tvMinuteScale;
                Resources resources = getResources();
                ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
                textView.setBackgroundColor(ResourcesCompat.Api23Impl.getColor(resources, R.color.colorSelectedListItemApp, null));
                fragmentDetailsTemperatureBinding.tvMinuteScale.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.checkMark, (Drawable) null);
                fragmentDetailsTemperatureBinding.imageViewMeter.setImageResource(R.drawable.minutes_temperature);
                fragmentDetailsTemperatureBinding.tvPercentScale.setBackgroundColor(0);
                fragmentDetailsTemperatureBinding.tvPercentScale.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                TextView textView2 = fragmentDetailsTemperatureBinding.tvPercentScale;
                Resources resources2 = getResources();
                ThreadLocal<TypedValue> threadLocal2 = ResourcesCompat.sTempTypedValue;
                textView2.setBackgroundColor(ResourcesCompat.Api23Impl.getColor(resources2, R.color.colorSelectedListItemApp, null));
                fragmentDetailsTemperatureBinding.tvPercentScale.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.checkMark, (Drawable) null);
                fragmentDetailsTemperatureBinding.imageViewMeter.setImageResource(R.drawable.percent_temperature);
                fragmentDetailsTemperatureBinding.tvMinuteScale.setBackgroundColor(0);
                fragmentDetailsTemperatureBinding.tvMinuteScale.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (temperatureState.isCelsius()) {
                Drawable drawable = ResourcesCompat.Api21Impl.getDrawable(requireActivity().getResources(), R.drawable.ic_celsius, null);
                if (drawable != null) {
                    DrawableCompat$Api21Impl.setTint(drawable, R.attr.detailIconTint);
                } else {
                    drawable = null;
                }
                AnimatedToolbar animatedToolbar = this.animatedToolbar;
                if (animatedToolbar != null) {
                    animatedToolbar.setHelpActionDrawable(drawable);
                }
                Context context = getContext();
                if (context != null) {
                    string = context.getString(R.string.temperature_celsius);
                }
                string = null;
            } else {
                Drawable drawable2 = ResourcesCompat.Api21Impl.getDrawable(requireActivity().getResources(), R.drawable.ic_fahrenheit, null);
                if (drawable2 != null) {
                    DrawableCompat$Api21Impl.setTint(drawable2, R.attr.detailIconTint);
                } else {
                    drawable2 = null;
                }
                AnimatedToolbar animatedToolbar2 = this.animatedToolbar;
                if (animatedToolbar2 != null) {
                    animatedToolbar2.setHelpActionDrawable(drawable2);
                }
                Context context2 = getContext();
                if (context2 != null) {
                    string = context2.getString(R.string.temperature_fahrenheit);
                }
                string = null;
            }
            if (string != null) {
                str2 = StringsKt__StringsJVMKt.replace$default(string, "°", "");
            }
            ProviderFactory.getWatch().updateRemoteComplication();
            fragmentDetailsTemperatureBinding.imageViewMeterWatchHandContainer.updateHands(true);
            if (temperatureState.getTemperature().length() == 0) {
                z = true;
            }
            if (z) {
                str = ConstraintSet$$ExternalSyntheticOutline0.m("--", str2);
            } else {
                str = temperatureState.getTemperature() + str2;
            }
            fragmentDetailsTemperatureBinding.tvCurrentTemp.setText(getString(R.string.temperature_animation_title, str));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        DetailsFragment detailsFragment;
        View view;
        DetailsFragment detailsFragment2;
        View view2;
        AnimatedToolbar animatedToolbar;
        View view3;
        View view4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.weatherViewModel = ProviderFactory.createWeatherViewModel();
        FragmentDetailsTemperatureBinding inflate = FragmentDetailsTemperatureBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.imageViewMeterWatchHandContainer.setWatchHandModel(new WatchHandsAnimation.WatchHandModel() { // from class: com.animaconnected.secondo.behaviour.temperature.TemperatureFragment$onCreateView$1$1
            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getHoursInDegrees() {
                WeatherViewModel weatherViewModel;
                TemperatureProvider temperature = ProviderFactory.getWeatherProvider().getTemperature();
                weatherViewModel = TemperatureFragment.this.weatherViewModel;
                if (weatherViewModel != null) {
                    Float rotation = temperature.getRotation(weatherViewModel.isCelsius());
                    if (rotation != null) {
                        return rotation.floatValue();
                    }
                    return 0.0f;
                }
                Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
                throw null;
            }

            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getMinutesInDegrees() {
                WeatherViewModel weatherViewModel;
                TemperatureProvider temperature = ProviderFactory.getWeatherProvider().getTemperature();
                weatherViewModel = TemperatureFragment.this.weatherViewModel;
                if (weatherViewModel != null) {
                    Float rotation = temperature.getRotation(weatherViewModel.isCelsius());
                    if (rotation != null) {
                        return rotation.floatValue();
                    }
                    return 0.0f;
                }
                Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
                throw null;
            }
        });
        Resources resources = requireActivity().getResources();
        ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
        Drawable drawable = ResourcesCompat.Api21Impl.getDrawable(resources, R.drawable.ic_check, null);
        if (drawable != null) {
            ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            drawable.setTint(companion.getColor(requireContext, R.attr.detailSelectedIconTint));
        } else {
            drawable = null;
        }
        this.checkMark = drawable;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof DetailsFragment) {
            detailsFragment = (DetailsFragment) parentFragment;
        } else {
            detailsFragment = null;
        }
        if (detailsFragment != null && (view4 = detailsFragment.getView()) != null) {
            view = view4.findViewById(R.id.touch_area_help_button);
        } else {
            view = null;
        }
        this.touchAreaToolbarIcon = view;
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 instanceof DetailsFragment) {
            detailsFragment2 = (DetailsFragment) parentFragment2;
        } else {
            detailsFragment2 = null;
        }
        if (detailsFragment2 != null && (view3 = detailsFragment2.getView()) != null) {
            view2 = view3.findViewById(R.id.animated_toolbar);
        } else {
            view2 = null;
        }
        if (view2 instanceof AnimatedToolbar) {
            animatedToolbar = (AnimatedToolbar) view2;
        } else {
            animatedToolbar = null;
        }
        this.animatedToolbar = animatedToolbar;
        inflate.tvMinuteScale.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.temperature.TemperatureFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                TemperatureFragment.onCreateView$lambda$3$lambda$1(TemperatureFragment.this, view5);
            }
        });
        inflate.tvPercentScale.setOnClickListener(new DebugImagePreview$$ExternalSyntheticLambda2(this, 1));
        this.binding = inflate;
        WeatherViewModel weatherViewModel = this.weatherViewModel;
        if (weatherViewModel != null) {
            FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new TemperatureFragment$onCreateView$2(this, null), weatherViewModel.getTemperatureFlow()), new TemperatureFragment$onCreateView$3(null)), Hashing.getLifecycleScope(this));
            showBottomOverview();
            FragmentDetailsTemperatureBinding fragmentDetailsTemperatureBinding = this.binding;
            if (fragmentDetailsTemperatureBinding != null) {
                LinearLayout root = fragmentDetailsTemperatureBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return root;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new TemperatureFragment$onStart$1(this, null), 3);
        View view = this.touchAreaToolbarIcon;
        if (view != null) {
            onClick(view, new TemperatureFragment$onStart$2(this, null));
        }
    }
}
