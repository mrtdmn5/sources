package com.animaconnected.watch.behaviour.worldtime;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry;
import com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import j$.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.UtcOffset;

/* compiled from: WorldTimeViewModel.kt */
/* loaded from: classes3.dex */
public final class WorldTimeViewModel {
    private final CommonFlow<EditState> editState;
    private final DateFormatter hourMinuteFormatter;
    private MutableStateFlow<EditState> privateEditState;
    private MutableStateFlow<List<TimeZoneListEntry>> privateTimeZones;
    private final CommonFlow<List<State>> timeZones;
    private final WorldTime worldTime;
    private final List<TimeZoneListEntry> worldTimezones;

    /* compiled from: WorldTimeViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class EditState {
        private final boolean isEditing;
        private final boolean isVisible;

        public EditState(boolean z, boolean z2) {
            this.isEditing = z;
            this.isVisible = z2;
        }

        public static /* synthetic */ EditState copy$default(EditState editState, boolean z, boolean z2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                z = editState.isEditing;
            }
            if ((r3 & 2) != 0) {
                z2 = editState.isVisible;
            }
            return editState.copy(z, z2);
        }

        public final boolean component1() {
            return this.isEditing;
        }

        public final boolean component2() {
            return this.isVisible;
        }

        public final EditState copy(boolean z, boolean z2) {
            return new EditState(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EditState)) {
                return false;
            }
            EditState editState = (EditState) obj;
            if (this.isEditing == editState.isEditing && this.isVisible == editState.isVisible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isVisible) + (Boolean.hashCode(this.isEditing) * 31);
        }

        public final boolean isEditing() {
            return this.isEditing;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("EditState(isEditing=");
            sb.append(this.isEditing);
            sb.append(", isVisible=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isVisible, ')');
        }
    }

    /* compiled from: WorldTimeViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private final String city;
        private final String cityKey;
        private final String hourMinute;
        private final String offset;
        private final String zoneId;

        public State(String city, String hourMinute, String offset, String zoneId, String cityKey) {
            Intrinsics.checkNotNullParameter(city, "city");
            Intrinsics.checkNotNullParameter(hourMinute, "hourMinute");
            Intrinsics.checkNotNullParameter(offset, "offset");
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            this.city = city;
            this.hourMinute = hourMinute;
            this.offset = offset;
            this.zoneId = zoneId;
            this.cityKey = cityKey;
        }

        public static /* synthetic */ State copy$default(State state, String str, String str2, String str3, String str4, String str5, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                str = state.city;
            }
            if ((r9 & 2) != 0) {
                str2 = state.hourMinute;
            }
            String str6 = str2;
            if ((r9 & 4) != 0) {
                str3 = state.offset;
            }
            String str7 = str3;
            if ((r9 & 8) != 0) {
                str4 = state.zoneId;
            }
            String str8 = str4;
            if ((r9 & 16) != 0) {
                str5 = state.cityKey;
            }
            return state.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.city;
        }

        public final String component2() {
            return this.hourMinute;
        }

        public final String component3() {
            return this.offset;
        }

        public final String component4() {
            return this.zoneId;
        }

        public final String component5() {
            return this.cityKey;
        }

        public final State copy(String city, String hourMinute, String offset, String zoneId, String cityKey) {
            Intrinsics.checkNotNullParameter(city, "city");
            Intrinsics.checkNotNullParameter(hourMinute, "hourMinute");
            Intrinsics.checkNotNullParameter(offset, "offset");
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            return new State(city, hourMinute, offset, zoneId, cityKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            if (Intrinsics.areEqual(this.city, state.city) && Intrinsics.areEqual(this.hourMinute, state.hourMinute) && Intrinsics.areEqual(this.offset, state.offset) && Intrinsics.areEqual(this.zoneId, state.zoneId) && Intrinsics.areEqual(this.cityKey, state.cityKey)) {
                return true;
            }
            return false;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCityKey() {
            return this.cityKey;
        }

        public final String getHourMinute() {
            return this.hourMinute;
        }

        public final String getOffset() {
            return this.offset;
        }

        public final String getZoneId() {
            return this.zoneId;
        }

        public int hashCode() {
            return this.cityKey.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.zoneId, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.offset, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.hourMinute, this.city.hashCode() * 31, 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("State(city=");
            sb.append(this.city);
            sb.append(", hourMinute=");
            sb.append(this.hourMinute);
            sb.append(", offset=");
            sb.append(this.offset);
            sb.append(", zoneId=");
            sb.append(this.zoneId);
            sb.append(", cityKey=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.cityKey, ')');
        }
    }

    public WorldTimeViewModel(WorldTime worldTime) {
        Intrinsics.checkNotNullParameter(worldTime, "worldTime");
        this.worldTime = worldTime;
        List<TimeZoneListEntry> timeZones = worldTime.getTimeZones();
        this.worldTimezones = timeZones;
        this.hourMinuteFormatter = StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null);
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(timeZones);
        this.privateTimeZones = MutableStateFlow;
        final Flow emitEveryMinute = emitEveryMinute(MutableStateFlow);
        this.timeZones = FlowExtensionsKt.asCommonFlow(new Flow<List<? extends State>>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WorldTimeViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2", f = "WorldTimeViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, WorldTimeViewModel worldTimeViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = worldTimeViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel r2 = r4.this$0
                        java.util.List r5 = com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel.access$toState(r2, r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends WorldTimeViewModel.State>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(new EditState(false, !timeZones.isEmpty()));
        this.privateEditState = MutableStateFlow2;
        this.editState = FlowExtensionsKt.asCommonFlow(MutableStateFlow2);
    }

    private final <T> Flow<T> emitEveryMinute(Flow<? extends T> flow) {
        WorldTimeViewModel$emitEveryMinute$1 worldTimeViewModel$emitEveryMinute$1 = new WorldTimeViewModel$emitEveryMinute$1(null);
        int r0 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        return new ChannelFlowTransformLatest(worldTimeViewModel$emitEveryMinute$1, flow, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<State> toState(List<? extends TimeZoneListEntry> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            State uIState = toUIState((TimeZoneListEntry) it.next());
            if (uIState != null) {
                arrayList.add(uIState);
            }
        }
        return arrayList;
    }

    private final State toUIState(final TimeZoneListEntry timeZoneListEntry) {
        boolean z;
        KeyString keyString;
        String m1690toStringimpl;
        TimeZoneListEntry.PredefinedTimeZoneListEntry predefinedTimeZoneListEntry;
        String str;
        try {
            KeyString translate = WorldTime.Companion.translate(timeZoneListEntry.getIdentifier());
            if (translate.app().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return null;
            }
            TimeZone.Companion companion = TimeZone.Companion;
            String timeZoneId = timeZoneListEntry.getTimeZoneId();
            companion.getClass();
            TimeZone of = TimeZone.Companion.of(timeZoneId);
            TimeZone currentSystemDefault = TimeZone.Companion.currentSystemDefault();
            LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(DateTimeUtilsKt.now(), of);
            LocalDateTime localDateTime2 = TimeZoneKt.toLocalDateTime(DateTimeUtilsKt.now(), currentSystemDefault);
            if (Intrinsics.areEqual(DateTimeUtilsKt.getStartOfDay(TimeZoneKt.toInstant(localDateTime, of), of), DateTimeUtilsKt.getStartOfDay(DateTimeUtilsKt.now(), currentSystemDefault))) {
                keyString = StringsExtensionsKt.getKeyString(Key.timestamp_text_today);
            } else if (localDateTime.value.compareTo((ChronoLocalDateTime<?>) localDateTime2.value) > 0) {
                keyString = StringsExtensionsKt.getKeyString(Key.timestamp_text_tomorrow);
            } else {
                keyString = StringsExtensionsKt.getKeyString(Key.timestamp_text_yesterday);
            }
            KeyString keyString2 = keyString;
            UtcOffset offsetAt = TimeZoneKt.offsetAt(DateTimeUtilsKt.now(), of);
            UtcOffset offsetAt2 = TimeZoneKt.offsetAt(DateTimeUtilsKt.now(), currentSystemDefault);
            int r7 = Duration.$r8$clinit;
            int totalSeconds = offsetAt.zoneOffset.getTotalSeconds();
            DurationUnit durationUnit = DurationUnit.SECONDS;
            long m1686plusLRDsOJo = Duration.m1686plusLRDsOJo(DurationKt.toDuration(totalSeconds, durationUnit), Duration.m1691unaryMinusUwyO8pc(DurationKt.toDuration(offsetAt2.zoneOffset.getTotalSeconds(), durationUnit)));
            if (Duration.m1675equalsimpl0(m1686plusLRDsOJo, 0L)) {
                m1690toStringimpl = "0" + StringsExtensionsKt.getKeyString(Key.time_unit_hour).app();
            } else {
                m1690toStringimpl = Duration.m1690toStringimpl(m1686plusLRDsOJo);
            }
            String app2 = translate.app();
            try {
                String format$default = DateFormatter.format$default(this.hourMinuteFormatter, TimeZoneKt.toInstant(localDateTime, of).toEpochMilliseconds(), of, false, 4, null);
                String str2 = keyString2.app() + ", " + m1690toStringimpl;
                String timeZoneId2 = timeZoneListEntry.getTimeZoneId();
                if (timeZoneListEntry instanceof TimeZoneListEntry.PredefinedTimeZoneListEntry) {
                    predefinedTimeZoneListEntry = (TimeZoneListEntry.PredefinedTimeZoneListEntry) timeZoneListEntry;
                } else {
                    predefinedTimeZoneListEntry = null;
                }
                if (predefinedTimeZoneListEntry == null || (str = predefinedTimeZoneListEntry.getCityKey()) == null) {
                    str = "";
                }
                return new State(app2, format$default, str2, timeZoneId2, str);
            } catch (Exception e) {
                e = e;
                LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$toUIState$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder("invalid timeZone ");
                        sb.append(TimeZoneListEntry.this.getTimeZoneId());
                        sb.append(' ');
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, sb);
                    }
                }, 7, (Object) null);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final CommonFlow<EditState> getEditState() {
        return this.editState;
    }

    public final CommonFlow<List<State>> getTimeZones() {
        return this.timeZones;
    }

    public final boolean isAddEnabled() {
        if (this.privateTimeZones.getValue().size() < 8) {
            return true;
        }
        return false;
    }

    public final boolean removeTimeZone(final String zoneId, final String cityKey) {
        boolean z;
        int r5;
        TimeZoneListEntry.PredefinedTimeZoneListEntry predefinedTimeZoneListEntry;
        String str;
        List<TimeZoneListEntry> value;
        EditState value2;
        EditState editState;
        boolean z2;
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        Intrinsics.checkNotNullParameter(cityKey, "cityKey");
        try {
            ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.worldTime.getTimeZones());
            if (cityKey.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Iterator it = mutableList.iterator();
                r5 = 0;
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((TimeZoneListEntry) it.next()).getTimeZoneId(), zoneId)) {
                        break;
                    }
                    r5++;
                }
                r5 = -1;
            } else {
                Iterator it2 = mutableList.iterator();
                r5 = 0;
                while (it2.hasNext()) {
                    TimeZoneListEntry timeZoneListEntry = (TimeZoneListEntry) it2.next();
                    if (timeZoneListEntry instanceof TimeZoneListEntry.PredefinedTimeZoneListEntry) {
                        predefinedTimeZoneListEntry = (TimeZoneListEntry.PredefinedTimeZoneListEntry) timeZoneListEntry;
                    } else {
                        predefinedTimeZoneListEntry = null;
                    }
                    if (predefinedTimeZoneListEntry != null) {
                        str = predefinedTimeZoneListEntry.getCityKey();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, cityKey)) {
                        break;
                    }
                    r5++;
                }
                r5 = -1;
            }
            if (r5 == -1) {
                LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$removeTimeZone$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "could not find timezone -> zoneId:" + zoneId + " cityKey:" + cityKey;
                    }
                }, 7, (Object) null);
                return false;
            }
            mutableList.remove(r5);
            this.worldTime.setTimeZones(mutableList);
            MutableStateFlow<List<TimeZoneListEntry>> mutableStateFlow = this.privateTimeZones;
            do {
                value = mutableStateFlow.getValue();
                List<TimeZoneListEntry> list = value;
            } while (!mutableStateFlow.compareAndSet(value, mutableList));
            MutableStateFlow<EditState> mutableStateFlow2 = this.privateEditState;
            do {
                value2 = mutableStateFlow2.getValue();
                editState = value2;
                if (!mutableList.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } while (!mutableStateFlow2.compareAndSet(value2, EditState.copy$default(editState, false, z2, 1, null)));
            return true;
        } catch (Exception e) {
            LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$removeTimeZone$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("could not delete timezone -> zoneId:");
                    sb.append(zoneId);
                    sb.append(", cityKey:");
                    sb.append(cityKey);
                    sb.append(", exception:");
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, sb);
                }
            }, 7, (Object) null);
            return false;
        }
    }

    public final void toggleEdit() {
        EditState value;
        MutableStateFlow<EditState> mutableStateFlow = this.privateEditState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, EditState.copy$default(value, !r2.isEditing(), false, 2, null)));
    }

    public static /* synthetic */ void getTimeZones$annotations() {
    }
}
