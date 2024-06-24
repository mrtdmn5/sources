package com.animaconnected.watch.account.profile;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.account.profile.ProfileState;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.workout.utils.ProfileUtilsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ProfileViewModel.kt */
/* loaded from: classes3.dex */
public final class ProfileViewModel {
    private final DateFormatter dateFormatter;
    private final MutableStateFlow<ProfileState> profileState;
    private final FitnessProvider.Profile provider;

    public ProfileViewModel(FitnessProvider.Profile provider, DateFormatter dateFormatter) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        this.provider = provider;
        this.dateFormatter = dateFormatter;
        this.profileState = StateFlowKt.MutableStateFlow(ProfileState.Loading.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        String str;
        Integer height;
        String str2;
        Integer weight;
        String str3;
        String formatWeight;
        String formatHeight;
        FitnessProvider.Profile profile = this.provider;
        FitnessProvider.Profile.Measurement measurement = profile.getMeasurement();
        Long dateOfBirth = profile.getDateOfBirth();
        if (dateOfBirth != null) {
            String format$default = DateFormatter.format$default(this.dateFormatter, dateOfBirth.longValue(), null, false, 6, null);
            if (format$default != null) {
                str = format$default;
                String access$toReadableString = ProfileViewModelKt.access$toReadableString(profile.getGender());
                height = profile.getHeight();
                if (height != null || (formatHeight = ProfileUtilsKt.formatHeight(height.intValue(), measurement)) == null) {
                    str2 = "-";
                } else {
                    str2 = formatHeight;
                }
                weight = profile.getWeight();
                if (weight != null || (formatWeight = ProfileUtilsKt.formatWeight(weight.intValue(), measurement)) == null) {
                    str3 = "-";
                } else {
                    str3 = formatWeight;
                }
                this.profileState.setValue(new ProfileState.Content(new FitnessConfigState(str, access$toReadableString, str2, str3, ProfileViewModelKt.access$getMeasurementUnit(measurement), ProfileViewModelKt.access$getTemperatureUnit(profile.getTemperatureUnit()))));
            }
        }
        str = "-";
        String access$toReadableString2 = ProfileViewModelKt.access$toReadableString(profile.getGender());
        height = profile.getHeight();
        if (height != null) {
        }
        str2 = "-";
        weight = profile.getWeight();
        if (weight != null) {
        }
        str3 = "-";
        this.profileState.setValue(new ProfileState.Content(new FitnessConfigState(str, access$toReadableString2, str2, str3, ProfileViewModelKt.access$getMeasurementUnit(measurement), ProfileViewModelKt.access$getTemperatureUnit(profile.getTemperatureUnit()))));
    }

    public final Object clearPersonalData(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$clearPersonalData$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object fetchFitnessConfig(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$fetchFitnessConfig$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final CommonFlow<ProfileState> observeState() {
        return FlowExtensionsKt.asCommonFlow(this.profileState);
    }

    public final Object setBedtime(Bedtime bedtime, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setBedtime$2(this, bedtime, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setDateOfBirth(Long l, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setDateOfBirth$2(this, l, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setGender(FitnessProvider.Profile.Gender gender, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setGender$2(this, gender, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setHeight(Integer num, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setHeight$2(this, num, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setMeasurementUnit(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setMeasurementUnit$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setTemperatureUnit(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setTemperatureUnit$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setUnits(FitnessProvider.Profile.Measurement measurement, FitnessProvider.Profile.Temperature temperature, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setUnits$2(this, measurement, temperature, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setWeight(Integer num, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.mainDispatcher(), new ProfileViewModel$setWeight$2(this, num, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
