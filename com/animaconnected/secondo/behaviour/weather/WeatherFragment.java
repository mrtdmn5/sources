package com.animaconnected.secondo.behaviour.weather;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.temperature.Temperature;
import com.animaconnected.secondo.databinding.FragmentWeatherBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: WeatherFragment.kt */
/* loaded from: classes3.dex */
public final class WeatherFragment extends BaseDetailsFragment {
    private View touchAreaToolbarIcon;
    private WeatherViewModel weatherViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WeatherFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDetailsFragment newInstance(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            WeatherFragment weatherFragment = new WeatherFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", Temperature.TYPE);
            weatherFragment.setArguments(bundle);
            return weatherFragment;
        }

        private Companion() {
        }
    }

    /* compiled from: WeatherFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WeatherViewModel.Weather.values().length];
            try {
                r0[WeatherViewModel.Weather.Clear_Sky.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WeatherViewModel.Weather.Clear_Sky_Night.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WeatherViewModel.Weather.Few_Clouds.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WeatherViewModel.Weather.Few_Clouds_Night.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WeatherViewModel.Weather.Scattered_Clouds.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[WeatherViewModel.Weather.Broken_Clouds.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[WeatherViewModel.Weather.Shower_Rain.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[WeatherViewModel.Weather.Rain.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r0[WeatherViewModel.Weather.Thunderstorm.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r0[WeatherViewModel.Weather.Snow.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                r0[WeatherViewModel.Weather.Mist.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                r0[WeatherViewModel.Weather.Unknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable getDrawable(int r3) {
        Resources resources = requireActivity().getResources();
        ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
        return ResourcesCompat.Api21Impl.getDrawable(resources, r3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getWeatherIcon(WeatherViewModel.Weather weather) {
        switch (WhenMappings.$EnumSwitchMapping$0[weather.ordinal()]) {
            case 1:
                return Integer.valueOf(R.drawable.ic_clear_sky);
            case 2:
                return Integer.valueOf(R.drawable.ic_clear_sky_night);
            case 3:
                return Integer.valueOf(R.drawable.ic_few_clouds);
            case 4:
                return Integer.valueOf(R.drawable.ic_few_clouds_night);
            case 5:
                return Integer.valueOf(R.drawable.ic_scattered_clouds);
            case 6:
                return Integer.valueOf(R.drawable.ic_broken_clouds);
            case 7:
                return Integer.valueOf(R.drawable.ic_shower_rain);
            case 8:
                return Integer.valueOf(R.drawable.ic_rain);
            case 9:
                return Integer.valueOf(R.drawable.ic_thunderstorm);
            case 10:
                return Integer.valueOf(R.drawable.ic_snow);
            case 11:
                return Integer.valueOf(R.drawable.ic_mist);
            case 12:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        DetailsFragment detailsFragment;
        View view;
        View view2;
        AnimatedToolbar animatedToolbar;
        View view3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentWeatherBinding inflate = FragmentWeatherBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.weatherViewModel = ProviderFactory.createWeatherViewModel();
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof DetailsFragment) {
            detailsFragment = (DetailsFragment) parentFragment;
        } else {
            detailsFragment = null;
        }
        if (detailsFragment != null) {
            view = detailsFragment.getView();
        } else {
            view = null;
        }
        if (view != null) {
            view2 = view.findViewById(R.id.animated_toolbar);
        } else {
            view2 = null;
        }
        if (view2 instanceof AnimatedToolbar) {
            animatedToolbar = (AnimatedToolbar) view2;
        } else {
            animatedToolbar = null;
        }
        if (view != null) {
            view3 = view.findViewById(R.id.touch_area_help_button);
        } else {
            view3 = null;
        }
        this.touchAreaToolbarIcon = view3;
        WeatherViewModel weatherViewModel = this.weatherViewModel;
        if (weatherViewModel != null) {
            FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new WeatherFragment$onCreateView$1$1(inflate, this, animatedToolbar, null), weatherViewModel.getWeatherFlowApp()), Hashing.getLifecycleScope(this));
            LinearLayout root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WeatherFragment$onStart$1(this, null), 3);
        View view = this.touchAreaToolbarIcon;
        if (view != null) {
            onClick(view, new WeatherFragment$onStart$2(this, null));
        }
    }
}
