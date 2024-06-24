package com.animaconnected.watch.provider.preferences;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.coroutines.FlowQuery;
import app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrNull$$inlined$map$1;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.sync.ConfigQueries;
import com.animaconnected.watch.sync.DBPreferences;
import io.ktor.util.Base64Kt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: PreferenceProvider.kt */
/* loaded from: classes3.dex */
public final class PreferenceProvider implements Preferences {
    private final ConfigQueries config;
    private Map<String, ? extends List<PreferenceValue>> currentPrefs;
    private final Function0<String> getCurrentIdentifier;
    private final Function0<Unit> onChange;
    private final String prefDefinitionKey;

    /* compiled from: PreferenceProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public PreferenceProvider(ConfigQueries config, Function0<String> getCurrentIdentifier, Function0<Unit> onChange) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(getCurrentIdentifier, "getCurrentIdentifier");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        this.config = config;
        this.getCurrentIdentifier = getCurrentIdentifier;
        this.onChange = onChange;
        this.prefDefinitionKey = "preferenceDefinition";
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:            if (r1 == null) goto L49;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ensurePreferenceValuesInDb(java.util.List<com.animaconnected.watch.provider.preferences.PreferenceValue> r13) {
        /*
            r12 = this;
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L6:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L9f
            java.lang.Object r0 = r13.next()
            com.animaconnected.watch.provider.preferences.PreferenceValue r0 = (com.animaconnected.watch.provider.preferences.PreferenceValue) r0
            com.animaconnected.watch.sync.ConfigQueries r1 = r12.config
            kotlin.jvm.functions.Function0<java.lang.String> r2 = r12.getCurrentIdentifier
            java.lang.Object r2 = r2.invoke()
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r0.getId()
            app.cash.sqldelight.Query r1 = r1.getPreference(r2, r3)
            java.lang.Object r1 = r1.executeAsOneOrNull()
            com.animaconnected.watch.sync.DBPreferences r1 = (com.animaconnected.watch.sync.DBPreferences) r1
            if (r1 != 0) goto L6
            com.animaconnected.watch.provider.preferences.Pref$Companion r1 = com.animaconnected.watch.provider.preferences.Pref.Companion
            int r2 = r0.getId()
            com.animaconnected.watch.provider.preferences.Pref r1 = r1.fromId(r2)
            r2 = 0
            if (r1 == 0) goto L3e
            boolean r1 = r1.getPerWatch()
            goto L3f
        L3e:
            r1 = r2
        L3f:
            if (r1 == 0) goto L53
            r12.setPreference(r0, r2)
            r4 = 0
            r5 = 0
            r6 = 0
            com.animaconnected.watch.provider.preferences.PreferenceProvider$ensurePreferenceValuesInDb$1$1 r7 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$ensurePreferenceValuesInDb$1$1
            r7.<init>()
            r8 = 7
            r9 = 0
            r3 = r12
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)
            goto L6
        L53:
            com.animaconnected.watch.sync.ConfigQueries r1 = r12.config
            int r3 = r0.getId()
            app.cash.sqldelight.Query r1 = r1.getPreferenceGlobal(r3)
            java.lang.Object r1 = r1.executeAsOneOrNull()
            com.animaconnected.watch.sync.DBPreferences r1 = (com.animaconnected.watch.sync.DBPreferences) r1
            if (r1 == 0) goto L7f
            java.lang.String r1 = r1.getValue_()
            if (r1 == 0) goto L7f
            byte[] r1 = io.ktor.util.Base64Kt.decodeBase64Bytes(r1)
            com.animaconnected.watch.provider.preferences.PreferenceValue$Companion r3 = com.animaconnected.watch.provider.preferences.PreferenceValue.Companion
            int r4 = r0.getId()
            com.animaconnected.watch.provider.preferences.PreferenceValue r1 = r3.decodeValueFromMsgpack(r4, r1)
            int[] r1 = r1.getValue()
            if (r1 != 0) goto L83
        L7f:
            int[] r1 = r0.getValue()
        L83:
            com.animaconnected.watch.provider.preferences.PreferenceValue r3 = new com.animaconnected.watch.provider.preferences.PreferenceValue
            int r4 = r0.getId()
            r3.<init>(r4, r1)
            r12.setPreference(r3, r2)
            r6 = 0
            r7 = 0
            r8 = 0
            com.animaconnected.watch.provider.preferences.PreferenceProvider$ensurePreferenceValuesInDb$1$2 r9 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$ensurePreferenceValuesInDb$1$2
            r9.<init>()
            r10 = 7
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
            goto L6
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider.ensurePreferenceValuesInDb(java.util.List):void");
    }

    public final int[] fallbackValue(int r5) {
        Collection<? extends List<PreferenceValue>> values;
        Object obj;
        boolean z;
        Map<String, ? extends List<PreferenceValue>> map = this.currentPrefs;
        if (map == null || (values = map.values()) == null) {
            return null;
        }
        Iterator it = CollectionsKt__IteratorsJVMKt.flatten(values).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((PreferenceValue) obj).getId() == r5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PreferenceValue preferenceValue = (PreferenceValue) obj;
        if (preferenceValue == null) {
            return null;
        }
        return preferenceValue.getValue();
    }

    private final Pref getPref(SessionType sessionType) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 == 4) {
                        return Pref.MetricConfOther;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return Pref.MetricConfBike;
            }
            return Pref.MetricConfWalk;
        }
        return Pref.MetricConfRun;
    }

    private final int[] getPreference(int r3) {
        int[] r0;
        DBPreferences executeAsOneOrNull = this.config.getPreference(this.getCurrentIdentifier.invoke(), r3).executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            String value_ = executeAsOneOrNull.getValue_();
            if (value_ != null) {
                r0 = PreferenceValue.Companion.decodeValueFromMsgpack(r3, Base64Kt.decodeBase64Bytes(value_)).getValue();
            } else {
                r0 = null;
            }
            if (r0 != null) {
                return r0;
            }
        }
        return fallbackValue(r3);
    }

    private final Flow<int[]> getPreferenceFlow(final Pref pref) {
        SafeFlow flow = FlowQuery.toFlow(this.config.getPreference(this.getCurrentIdentifier.invoke(), pref.getId()));
        CoroutineDispatcher context = DispatchersKt.ioDispatcher();
        Intrinsics.checkNotNullParameter(context, "context");
        final FlowQuery$mapToOneOrNull$$inlined$map$1 flowQuery$mapToOneOrNull$$inlined$map$1 = new FlowQuery$mapToOneOrNull$$inlined$map$1(flow, context);
        return new Flow<int[]>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Pref $pref$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ PreferenceProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, PreferenceProvider preferenceProvider, Pref pref) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = preferenceProvider;
                    this.$pref$inlined = pref;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:            if (r6 == null) goto L20;     */
                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L69
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        com.animaconnected.watch.sync.DBPreferences r6 = (com.animaconnected.watch.sync.DBPreferences) r6
                        if (r6 == 0) goto L54
                        java.lang.String r6 = r6.getValue_()
                        if (r6 == 0) goto L54
                        byte[] r6 = io.ktor.util.Base64Kt.decodeBase64Bytes(r6)
                        com.animaconnected.watch.provider.preferences.PreferenceValue$Companion r2 = com.animaconnected.watch.provider.preferences.PreferenceValue.Companion
                        com.animaconnected.watch.provider.preferences.Pref r4 = r5.$pref$inlined
                        int r4 = r4.getId()
                        com.animaconnected.watch.provider.preferences.PreferenceValue r6 = r2.decodeValueFromMsgpack(r4, r6)
                        int[] r6 = r6.getValue()
                        if (r6 != 0) goto L60
                    L54:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider r6 = r5.this$0
                        com.animaconnected.watch.provider.preferences.Pref r2 = r5.$pref$inlined
                        int r2 = r2.getId()
                        int[] r6 = com.animaconnected.watch.provider.preferences.PreferenceProvider.access$fallbackValue(r6, r2)
                    L60:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L69
                        return r1
                    L69:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super int[]> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, pref), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public final PreferenceValue getPreferenceValue(ConfigQueries configQueries, String str, int r3) {
        String value_;
        DBPreferences executeAsOneOrNull = configQueries.getPreference(str, r3).executeAsOneOrNull();
        if (executeAsOneOrNull != null && (value_ = executeAsOneOrNull.getValue_()) != null) {
            return PreferenceValue.Companion.decodeValueFromMsgpack(r3, Base64Kt.decodeBase64Bytes(value_));
        }
        return null;
    }

    public static /* synthetic */ void setPreference$default(PreferenceProvider preferenceProvider, Pref pref, int[] r2, boolean z, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z = true;
        }
        preferenceProvider.setPreference(pref, r2, z);
    }

    public final void setPreferenceValue(ConfigQueries configQueries, String str, PreferenceValue preferenceValue) {
        int r0;
        String concatToString;
        int r7;
        byte[] encodeValueToMsgpack = PreferenceValue.Companion.encodeValueToMsgpack(preferenceValue);
        int[] r1 = Base64Kt.BASE64_INVERSE_ALPHABET;
        Intrinsics.checkNotNullParameter(encodeValueToMsgpack, "<this>");
        int r4 = 3;
        char[] cArr = new char[OpaqueKey$$ExternalSyntheticOutline0.m(encodeValueToMsgpack.length, 8, 6, 3)];
        int r3 = 0;
        int r5 = 0;
        while (true) {
            int r6 = r3 + 3;
            if (r6 > encodeValueToMsgpack.length) {
                break;
            }
            int r32 = (encodeValueToMsgpack[r3 + 2] & 255) | ((encodeValueToMsgpack[r3] & 255) << 16) | ((encodeValueToMsgpack[r3 + 1] & 255) << 8);
            int r72 = 3;
            while (-1 < r72) {
                cArr[r5] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((r32 >> (r72 * 6)) & 63);
                r72--;
                r5++;
            }
            r3 = r6;
        }
        int length = encodeValueToMsgpack.length - r3;
        if (length == 0) {
            concatToString = StringsKt__StringsJVMKt.concatToString(cArr, 0, r5);
        } else {
            if (length == 1) {
                r0 = ((encodeValueToMsgpack[r3] & 255) << 16) | 0;
            } else {
                r0 = ((encodeValueToMsgpack[r3 + 1] & 255) << 8) | ((encodeValueToMsgpack[r3] & 255) << 16);
            }
            int r02 = r0 | 0;
            int r33 = ((3 - length) * 8) / 6;
            if (r33 <= 3) {
                while (true) {
                    r7 = r5 + 1;
                    cArr[r5] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((r02 >> (r4 * 6)) & 63);
                    if (r4 == r33) {
                        break;
                    }
                    r4--;
                    r5 = r7;
                }
                r5 = r7;
            }
            int r03 = 0;
            while (r03 < r33) {
                cArr[r5] = '=';
                r03++;
                r5++;
            }
            concatToString = StringsKt__StringsJVMKt.concatToString(cArr, 0, r5);
        }
        configQueries.setPreference(str, preferenceValue.getId(), concatToString);
    }

    public static /* synthetic */ void setPreferences$default(PreferenceProvider preferenceProvider, byte[] bArr, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        preferenceProvider.setPreferences(bArr, z);
    }

    public final void clearPreferencesForDevice$watch_release(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.config.clearPreferencesForDevice(address);
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<Integer> getBrightnessFlow() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.Brightness);
        return FlowExtensionsKt.asCommonFlow(new Flow<Integer>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L53
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        int[] r5 = (int[]) r5
                        if (r5 == 0) goto L43
                        java.lang.Integer r5 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5)
                        if (r5 == 0) goto L43
                        int r5 = r5.intValue()
                        goto L45
                    L43:
                        r5 = 255(0xff, float:3.57E-43)
                    L45:
                        java.lang.Integer r2 = new java.lang.Integer
                        r2.<init>(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r2, r0)
                        if (r5 != r1) goto L53
                        return r1
                    L53:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getBrightnessFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<ColorTheme> getColorThemeFlow() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.ColorTheme);
        return FlowExtensionsKt.asCommonFlow(new Flow<ColorTheme>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:            if (r5 == null) goto L20;     */
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L55
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        int[] r5 = (int[]) r5
                        if (r5 == 0) goto L4a
                        java.lang.Integer r5 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5)
                        if (r5 == 0) goto L4a
                        int r5 = r5.intValue()
                        com.animaconnected.watch.provider.preferences.ColorTheme$Companion r2 = com.animaconnected.watch.provider.preferences.ColorTheme.Companion
                        com.animaconnected.watch.provider.preferences.ColorTheme r5 = r2.fromId$watch_release(r5)
                        if (r5 != 0) goto L4c
                    L4a:
                        com.animaconnected.watch.provider.preferences.ColorTheme r5 = com.animaconnected.watch.provider.preferences.ColorTheme.Sku
                    L4c:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L55
                        return r1
                    L55:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getColorThemeFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ColorTheme> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final Map<String, List<PreferenceValue>> getCurrentPrefs$watch_release() {
        return this.currentPrefs;
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<List<WorkoutMetrics>> getMetricsForSessionType(SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        final Flow<int[]> preferenceFlow = getPreferenceFlow(getPref(sessionType));
        return FlowExtensionsKt.asCommonFlow(new Flow<List<? extends WorkoutMetrics>>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L60
                    L27:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r10)
                        kotlinx.coroutines.flow.FlowCollector r10 = r8.$this_unsafeFlow
                        int[] r9 = (int[]) r9
                        if (r9 == 0) goto L55
                        java.util.ArrayList r2 = new java.util.ArrayList
                        int r4 = r9.length
                        r2.<init>(r4)
                        int r4 = r9.length
                        r5 = 0
                    L40:
                        if (r5 >= r4) goto L50
                        r6 = r9[r5]
                        com.animaconnected.watch.provider.preferences.WorkoutMetrics$Companion r7 = com.animaconnected.watch.provider.preferences.WorkoutMetrics.Companion
                        java.util.List r6 = r7.toMetric$watch_release(r6)
                        r2.add(r6)
                        int r5 = r5 + 1
                        goto L40
                    L50:
                        java.util.ArrayList r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.flatten(r2)
                        goto L57
                    L55:
                        kotlin.collections.EmptyList r9 = kotlin.collections.EmptyList.INSTANCE
                    L57:
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r9, r0)
                        if (r9 != r1) goto L60
                        return r1
                    L60:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getMetricsForSessionType$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends WorkoutMetrics>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final List<PreferenceValue> getPreferenceValuesForFile(final String filename) {
        List<PreferenceValue> list;
        Intrinsics.checkNotNullParameter(filename, "filename");
        Map<String, ? extends List<PreferenceValue>> map = this.currentPrefs;
        if (map != null) {
            list = map.get(filename);
        } else {
            list = null;
        }
        if (list == null) {
            LogKt.err$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getPreferenceValuesForFile$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Trying to preference definition for file "), filename, " that hasn't been reported by watch");
                }
            }, 7, (Object) null);
            return EmptyList.INSTANCE;
        }
        List<PreferenceValue> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        for (PreferenceValue preferenceValue : list2) {
            int[] preference = getPreference(preferenceValue.getId());
            if (preference != null) {
                int[] value = preferenceValue.getValue();
                ArrayList arrayList2 = new ArrayList(value.length);
                int length = value.length;
                int r6 = 0;
                int r7 = 0;
                while (r6 < length) {
                    int r8 = value[r6];
                    int r9 = r7 + 1;
                    if (r7 < preference.length) {
                        r8 = preference[r7];
                    }
                    arrayList2.add(Integer.valueOf(r8));
                    r6++;
                    r7 = r9;
                }
                preferenceValue = new PreferenceValue(preferenceValue.getId(), CollectionsKt___CollectionsKt.toIntArray(arrayList2));
            }
            arrayList.add(preferenceValue);
        }
        return arrayList;
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public AppId getQuickAction() {
        Integer firstOrNull;
        int[] preference = getPreference(Pref.AssignedQuickAction.getId());
        if (preference != null && (firstOrNull = ArraysKt___ArraysKt.firstOrNull(preference)) != null) {
            AppId fromStatus = AppId.Companion.fromStatus(firstOrNull.intValue());
            if (fromStatus != null) {
                return fromStatus;
            }
        }
        return AppId.Unknown;
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<Boolean> getQuickActionFirstShownFlow() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.QuickActionFirstShown);
        return FlowExtensionsKt.asCommonFlow(new Flow<Boolean>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L54
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        int[] r5 = (int[]) r5
                        r2 = 0
                        if (r5 == 0) goto L47
                        java.lang.Integer r5 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5)
                        if (r5 != 0) goto L40
                        goto L47
                    L40:
                        int r5 = r5.intValue()
                        if (r5 != r3) goto L47
                        r2 = r3
                    L47:
                        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L54
                        return r1
                    L54:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFirstShownFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<AppId> getQuickActionFlow() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.AssignedQuickAction);
        return FlowExtensionsKt.asCommonFlow(new Flow<AppId>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:            if (r5 == null) goto L20;     */
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L55
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        int[] r5 = (int[]) r5
                        if (r5 == 0) goto L4a
                        java.lang.Integer r5 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5)
                        if (r5 == 0) goto L4a
                        int r5 = r5.intValue()
                        com.animaconnected.watch.display.AppId$Companion r2 = com.animaconnected.watch.display.AppId.Companion
                        com.animaconnected.watch.display.AppId r5 = r2.fromStatus(r5)
                        if (r5 != 0) goto L4c
                    L4a:
                        com.animaconnected.watch.display.AppId r5 = com.animaconnected.watch.display.AppId.Unknown
                    L4c:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L55
                        return r1
                    L55:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getQuickActionFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AppId> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<Map<SessionType, GPSPreferences>> getSessionTypeGPSPreferencesFlow() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.GpsPreferences);
        return FlowExtensionsKt.asCommonFlow(new Flow<Map<SessionType, ? extends GPSPreferences>>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r13
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1$2$1
                        r0.<init>(r13)
                    L18:
                        java.lang.Object r13 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto L78
                    L27:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r13)
                        kotlinx.coroutines.flow.FlowCollector r13 = r11.$this_unsafeFlow
                        int[] r12 = (int[]) r12
                        if (r12 == 0) goto L6d
                        java.util.ArrayList r2 = new java.util.ArrayList
                        int r4 = r12.length
                        r2.<init>(r4)
                        int r4 = r12.length
                        r5 = 0
                        r6 = r5
                    L41:
                        if (r5 >= r4) goto L68
                        r7 = r12[r5]
                        int r8 = r6 + 1
                        com.animaconnected.watch.fitness.SessionType$Companion r9 = com.animaconnected.watch.fitness.SessionType.Companion
                        java.lang.Integer r10 = new java.lang.Integer
                        r10.<init>(r6)
                        com.animaconnected.watch.fitness.SessionType r6 = r9.fromId(r10)
                        com.animaconnected.watch.provider.preferences.GPSPreferences$Companion r9 = com.animaconnected.watch.provider.preferences.GPSPreferences.Companion
                        com.animaconnected.watch.provider.preferences.GPSPreferences r7 = r9.fromId$watch_release(r7)
                        if (r7 != 0) goto L5c
                        com.animaconnected.watch.provider.preferences.GPSPreferences r7 = com.animaconnected.watch.provider.preferences.GPSPreferences.Unknown
                    L5c:
                        kotlin.Pair r9 = new kotlin.Pair
                        r9.<init>(r6, r7)
                        r2.add(r9)
                        int r5 = r5 + 1
                        r6 = r8
                        goto L41
                    L68:
                        java.util.Map r12 = kotlin.collections.MapsKt__MapsKt.toMap(r2)
                        goto L6f
                    L6d:
                        kotlin.collections.EmptyMap r12 = kotlin.collections.EmptyMap.INSTANCE
                    L6f:
                        r0.label = r3
                        java.lang.Object r12 = r13.emit(r12, r0)
                        if (r12 != r1) goto L78
                        return r1
                    L78:
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSessionTypeGPSPreferencesFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Map<SessionType, ? extends GPSPreferences>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public CommonFlow<Integer> getSpeedCalibrationCoefficient() {
        final Flow<int[]> preferenceFlow = getPreferenceFlow(Pref.SpeedCoefficient);
        return FlowExtensionsKt.asCommonFlow(new Flow<Integer>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2", f = "PreferenceProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L53
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        int[] r5 = (int[]) r5
                        if (r5 == 0) goto L43
                        java.lang.Integer r5 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r5)
                        if (r5 == 0) goto L43
                        int r5 = r5.intValue()
                        goto L45
                    L43:
                        r5 = 72
                    L45:
                        java.lang.Integer r2 = new java.lang.Integer
                        r2.<init>(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r2, r0)
                        if (r5 != r1) goto L53
                        return r1
                    L53:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider$getSpeedCalibrationCoefficient$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0135 -> B:10:0x013c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initPreferenceDefinition(com.animaconnected.watch.device.files.WatchFileSystem r19, com.animaconnected.watch.device.BasicStorage r20, java.util.List<com.animaconnected.watch.device.files.FileDescriptor> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.preferences.PreferenceProvider.initPreferenceDefinition(com.animaconnected.watch.device.files.WatchFileSystem, com.animaconnected.watch.device.BasicStorage, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v7, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r10v8 */
    public final PreferenceValue merge$watch_release(PreferenceValue current, PreferenceValue preferenceValue) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(preferenceValue, "new");
        if (current.getId() != preferenceValue.getId()) {
            return null;
        }
        if (preferenceValue.getValue().length >= current.getValue().length) {
            return preferenceValue;
        }
        int[] value = preferenceValue.getValue();
        int[] value2 = current.getValue();
        int length = preferenceValue.getValue().length;
        Intrinsics.checkNotNullParameter(value2, "<this>");
        if (length >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length2 = value2.length - length;
            if (length2 < 0) {
                length2 = 0;
            }
            if (length2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                ?? r10 = EmptyList.INSTANCE;
                if (length2 != 0) {
                    int length3 = value2.length;
                    if (length2 >= length3) {
                        int length4 = value2.length;
                        if (length4 != 0) {
                            if (length4 != 1) {
                                r10 = new ArrayList(value2.length);
                                for (int r0 : value2) {
                                    r10.add(Integer.valueOf(r0));
                                }
                            } else {
                                r10 = CollectionsKt__CollectionsKt.listOf(Integer.valueOf(value2[0]));
                            }
                        }
                    } else if (length2 == 1) {
                        r10 = CollectionsKt__CollectionsKt.listOf(Integer.valueOf(value2[length3 - 1]));
                    } else {
                        r10 = new ArrayList(length2);
                        for (int r3 = length3 - length2; r3 < length3; r3++) {
                            r10.add(Integer.valueOf(value2[r3]));
                        }
                    }
                }
                Collection collection = (Collection) r10;
                Intrinsics.checkNotNullParameter(value, "<this>");
                int length5 = value.length;
                int[] copyOf = Arrays.copyOf(value, collection.size() + length5);
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    copyOf[length5] = ((Number) it.next()).intValue();
                    length5++;
                }
                Intrinsics.checkNotNull(copyOf);
                return new PreferenceValue(current.getId(), copyOf);
            }
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", length2, " is less than zero.").toString());
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", length, " is less than zero.").toString());
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public void setBrightness(int r7) {
        setPreference$default(this, Pref.Brightness, new int[]{r7}, false, 4, null);
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public void setColorTheme(ColorTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        setPreference$default(this, Pref.ColorTheme, new int[]{theme.getId$watch_release()}, false, 4, null);
    }

    public final void setCurrentPrefs$watch_release(Map<String, ? extends List<PreferenceValue>> map) {
        this.currentPrefs = map;
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public void setMetricsForSessionType(SessionType sessionType, List<? extends WorkoutMetrics> list) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(list, "list");
        Pref pref = getPref(sessionType);
        List<Integer> int$watch_release = WorkoutMetrics.Companion.toInt$watch_release(list);
        int r0 = 0;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 0, 0, 0});
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        for (Object obj : listOf) {
            int r4 = r0 + 1;
            if (r0 >= 0) {
                int intValue = ((Number) obj).intValue();
                if (int$watch_release.size() > r0) {
                    intValue = int$watch_release.get(r0).intValue();
                }
                arrayList.add(Integer.valueOf(intValue));
                r0 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        setPreference$default(this, pref, Arrays.copyOf(intArray, intArray.length), false, 4, null);
    }

    public final void setPreference(Pref pref, int[] value, boolean z) {
        Intrinsics.checkNotNullParameter(pref, "pref");
        Intrinsics.checkNotNullParameter(value, "value");
        setPreference(new PreferenceValue(pref.getId(), value), z);
    }

    public final void setPreferences(byte[] bytes, boolean z) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Iterator<T> it = PreferenceValue.Companion.decodeFromMsgpack(bytes).iterator();
        while (it.hasNext()) {
            setPreference((PreferenceValue) it.next(), z);
        }
    }

    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public void setQuickAction(AppId appId) {
        Pref pref = Pref.AssignedQuickAction;
        int[] r2 = new int[1];
        if (appId == null) {
            appId = AppId.Unknown;
        }
        r2[0] = appId.getCode();
        setPreference$default(this, pref, r2, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.watch.provider.preferences.Preferences
    public void setSessionTypeGPSPreferences(Map<SessionType, ? extends GPSPreferences> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.keySet().size() != SessionType.getEntries().size()) {
            LogKt.err$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$setSessionTypeGPSPreferences$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "setSessionTypeGPSPreferences(map) doesn't contain all SessionTypes";
                }
            }, 7, (Object) null);
            return;
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(MapsKt___MapsKt.toList(map), new Comparator() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$setSessionTypeGPSPreferences$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return BorderStrokeKt.compareValues(Integer.valueOf(((SessionType) ((Pair) t).first).getId()), Integer.valueOf(((SessionType) ((Pair) t2).first).getId()));
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GPSPreferences) ((Pair) it.next()).second).getId$watch_release()));
        }
        int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        setPreference$default(this, Pref.GpsPreferences, Arrays.copyOf(intArray, intArray.length), false, 4, null);
    }

    private final void setPreference(final PreferenceValue preferenceValue, boolean z) {
        Pref fromId = Pref.Companion.fromId(preferenceValue.getId());
        boolean perWatch = fromId != null ? fromId.getPerWatch() : false;
        final SetBuilder setBuilder = new SetBuilder();
        setBuilder.add(this.getCurrentIdentifier.invoke());
        if (!perWatch) {
            setBuilder.addAll(this.config.getPreferencesIdentifiers().executeAsList());
        }
        MapBuilder<E, ?> mapBuilder = setBuilder.backing;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        if (mapBuilder.size <= 0) {
            Intrinsics.checkNotNull(MapBuilder.Empty, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        if (mapBuilder.size <= 0) {
            setBuilder = SetBuilder.Empty;
        }
        this.config.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.provider.preferences.PreferenceProvider$setPreference$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                ConfigQueries configQueries;
                PreferenceValue preferenceValue2;
                PreferenceValue preferenceValue3;
                ConfigQueries configQueries2;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                Set<String> set = setBuilder;
                PreferenceProvider preferenceProvider = this;
                PreferenceValue preferenceValue4 = preferenceValue;
                for (String str : set) {
                    configQueries = preferenceProvider.config;
                    preferenceValue2 = preferenceProvider.getPreferenceValue(configQueries, str, preferenceValue4.getId());
                    if (preferenceValue2 == null || (preferenceValue3 = preferenceProvider.merge$watch_release(preferenceValue2, preferenceValue4)) == null) {
                        preferenceValue3 = preferenceValue4;
                    }
                    configQueries2 = preferenceProvider.config;
                    preferenceProvider.setPreferenceValue(configQueries2, str, preferenceValue3);
                }
            }
        });
        if (z) {
            this.onChange.invoke();
        }
    }

    public static /* synthetic */ void setPreference$default(PreferenceProvider preferenceProvider, PreferenceValue preferenceValue, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        preferenceProvider.setPreference(preferenceValue, z);
    }
}
