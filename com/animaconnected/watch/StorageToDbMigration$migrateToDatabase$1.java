package com.animaconnected.watch;

import android.content.SharedPreferences;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.time.Time;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.types.Empty;
import com.animaconnected.watch.behaviour.types.FindPhone;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.WatchConstantsKt;
import com.animaconnected.watch.storage.WatchDb;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StorageToDbMigration.kt */
@DebugMetadata(c = "com.animaconnected.watch.StorageToDbMigration$migrateToDatabase$1", f = "StorageToDbMigration.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StorageToDbMigration$migrateToDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Capabilities $capabilityCenter;
    final /* synthetic */ WatchDb $db;
    final /* synthetic */ SharedPreferences $oldWatchStore;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: StorageToDbMigration.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Slot> entries$0 = EnumEntriesKt.enumEntries(Slot.values());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageToDbMigration$migrateToDatabase$1(SharedPreferences sharedPreferences, WatchDb watchDb, Capabilities capabilities, Continuation<? super StorageToDbMigration$migrateToDatabase$1> continuation) {
        super(2, continuation);
        this.$oldWatchStore = sharedPreferences;
        this.$db = watchDb;
        this.$capabilityCenter = capabilities;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StorageToDbMigration$migrateToDatabase$1 storageToDbMigration$migrateToDatabase$1 = new StorageToDbMigration$migrateToDatabase$1(this.$oldWatchStore, this.$db, this.$capabilityCenter, continuation);
        storageToDbMigration$migrateToDatabase$1.L$0 = obj;
        return storageToDbMigration$migrateToDatabase$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        CoroutineScope coroutineScope;
        boolean z;
        SharedPreferences sharedPreferences;
        String str3;
        String str4;
        JSONObject jSONObject;
        CharSequence charSequence;
        String str5;
        Time time;
        Ifttt ifttt;
        FindPhone findPhone;
        Iterator it;
        Slot slot;
        String str6;
        boolean z2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            Map<String, ?> all = this.$oldWatchStore.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
            while (true) {
                str = "<get-key>(...)";
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, ?> next = it2.next();
                String key = next.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                if (StringsKt__StringsKt.contains(key, "type_v2", false)) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            SharedPreferences sharedPreferences2 = this.$oldWatchStore;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it3 = linkedHashMap.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry = (Map.Entry) it3.next();
                String str7 = (String) entry.getKey();
                Empty empty = Empty.INSTANCE;
                Iterator it4 = it3;
                if (!StringsKt__StringsJVMKt.equals(sharedPreferences2.getString(str7, empty.getTYPE()), empty.getTYPE())) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
                it3 = it4;
            }
            WatchDb watchDb = this.$db;
            Capabilities capabilities = this.$capabilityCenter;
            Iterator it5 = linkedHashMap2.entrySet().iterator();
            while (true) {
                str2 = "";
                coroutineScope = coroutineScope2;
                if (!it5.hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) it5.next();
                Iterator it6 = EntriesMappings.entries$0.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        slot = it6.next();
                        int id = ((Slot) slot).getId();
                        it = it5;
                        Object key2 = entry2.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                        if (id == Integer.parseInt(StringsKt__StringsJVMKt.replace$default((String) key2, "type_v2", ""))) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            break;
                        }
                        it5 = it;
                    } else {
                        it = it5;
                        slot = 0;
                        break;
                    }
                }
                Slot slot2 = slot;
                if (slot2 != null) {
                    Object value = entry2.getValue();
                    if (value instanceof String) {
                        str6 = (String) value;
                    } else {
                        str6 = null;
                    }
                    if (str6 != null) {
                        watchDb.saveBehaviour(str6, slot2, WatchConstantsKt.groupLayer(slot2, capabilities), WatchConstantsKt.affectedGroupLayers(slot2, capabilities));
                    }
                }
                coroutineScope2 = coroutineScope;
                it5 = it;
            }
            BehaviourFactory behaviourFactory = ProviderFactory.getBehaviourFactory();
            Map<String, ?> all2 = this.$oldWatchStore.getAll();
            Intrinsics.checkNotNullExpressionValue(all2, "getAll(...)");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, ?> entry3 : all2.entrySet()) {
                String key3 = entry3.getKey();
                Intrinsics.checkNotNullExpressionValue(key3, "<get-key>(...)");
                if (StringsKt__StringsKt.contains(key3, Command.SETTINGS, false)) {
                    linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                }
            }
            SharedPreferences sharedPreferences3 = this.$oldWatchStore;
            for (Map.Entry entry4 : linkedHashMap3.entrySet()) {
                try {
                    String string = sharedPreferences3.getString((String) entry4.getKey(), null);
                    if (string == null) {
                        string = str2;
                    }
                    jSONObject = new JSONObject(string);
                    Object key4 = entry4.getKey();
                    Intrinsics.checkNotNullExpressionValue(key4, str);
                    charSequence = (CharSequence) key4;
                    str5 = FindPhone.TYPE;
                    z = true;
                    try {
                    } catch (JSONException e) {
                        e = e;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    z = true;
                }
                if (StringsKt__StringsKt.contains(charSequence, str5, true) && jSONObject.has("soundId")) {
                    Behaviour behaviour = behaviourFactory.getBehaviour(str5);
                    if (behaviour instanceof FindPhone) {
                        findPhone = (FindPhone) behaviour;
                    } else {
                        findPhone = null;
                    }
                    if (findPhone != null) {
                        findPhone.setUserPreferredMusic(Music.Companion.fromId(jSONObject.getInt("soundId")));
                    }
                } else {
                    Object key5 = entry4.getKey();
                    Intrinsics.checkNotNullExpressionValue(key5, str);
                    try {
                    } catch (JSONException e3) {
                        e = e3;
                        z = true;
                        sharedPreferences = sharedPreferences3;
                        str3 = str2;
                        str4 = str;
                        LogKt.debug$default((Object) coroutineScope, "Failed to migrate settings.", (String) null, (Throwable) e, false, 10, (Object) null);
                        str2 = str3;
                        str = str4;
                        sharedPreferences3 = sharedPreferences;
                    }
                    if (StringsKt__StringsKt.contains((CharSequence) key5, Ifttt.TYPE, true) && jSONObject.has("mShouldSendLocation")) {
                        Behaviour behaviour2 = behaviourFactory.getBehaviour(Ifttt.TYPE);
                        if (behaviour2 instanceof Ifttt) {
                            ifttt = (Ifttt) behaviour2;
                        } else {
                            ifttt = null;
                        }
                        if (ifttt != null) {
                            ifttt.setLocationEnabled(jSONObject.getBoolean("mShouldSendLocation"));
                        }
                    } else {
                        Object key6 = entry4.getKey();
                        Intrinsics.checkNotNullExpressionValue(key6, str);
                        CharSequence charSequence2 = (CharSequence) key6;
                        String TYPE = Time.TYPE;
                        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                        if (StringsKt__StringsKt.contains(charSequence2, TYPE, true) && jSONObject.has("timeZoneId") && jSONObject.has("homeTimeZoneId")) {
                            Behaviour behaviour3 = behaviourFactory.getBehaviour(TYPE);
                            if (behaviour3 instanceof Time) {
                                time = (Time) behaviour3;
                            } else {
                                time = null;
                            }
                            if (time != null) {
                                time.setTimezoneId(jSONObject.getString("timeZoneId"));
                                time.setHomeTimezoneId(jSONObject.getString("homeTimeZoneId"));
                            }
                        }
                        sharedPreferences = sharedPreferences3;
                        str3 = str2;
                        str4 = str;
                        str2 = str3;
                        str = str4;
                        sharedPreferences3 = sharedPreferences;
                    }
                }
                sharedPreferences = sharedPreferences3;
                str3 = str2;
                str4 = str;
                str2 = str3;
                str = str4;
                sharedPreferences3 = sharedPreferences;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StorageToDbMigration$migrateToDatabase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
