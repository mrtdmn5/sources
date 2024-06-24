package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: CommandCenter.kt */
/* loaded from: classes3.dex */
public final class CommandCenter {
    private final BasicStorage cache;
    private final Map<Integer, String> commandMap;
    private final Set<String> knownMaps;

    public CommandCenter(BasicStorage cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.commandMap = new HashMap();
        this.knownMaps = new HashSet();
        clear$watch_release();
    }

    private final void parseDefinitionMap(final String str, Map<Integer, String> map) {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.CommandCenter$parseDefinitionMap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "definition: " + str;
            }
        }, 7, (Object) null);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            final int intValue = entry.getKey().intValue();
            final String value = entry.getValue();
            LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.CommandCenter$parseDefinitionMap$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return " key: " + intValue + " value: " + value;
                }
            }, 7, (Object) null);
            this.commandMap.put(Integer.valueOf(intValue), value);
        }
        this.knownMaps.add(str);
    }

    public final void clear$watch_release() {
        this.commandMap.clear();
        this.knownMaps.clear();
        this.commandMap.put(0, Definition.MAP_CMD);
    }

    public final int getCommandNumber$watch_release(String str) {
        Object obj;
        if (str == null) {
            return -1;
        }
        Iterator<T> it = this.commandMap.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return -1;
        }
        return ((Number) entry.getKey()).intValue();
    }

    public final boolean hasCapabilities() {
        if (isMapKnown$watch_release(Definition.MAP_CMD) && hasCommand$watch_release(Command.CAPABILITIES)) {
            return true;
        }
        return false;
    }

    public final boolean hasCommand$watch_release(String str) {
        if (getCommandNumber$watch_release(str) != -1) {
            return true;
        }
        return false;
    }

    public final boolean hasCompBtnAndCompDef() {
        if (hasCommand$watch_release(Command.COMP_BTN) && hasCommand$watch_release(Command.COMP_DEF)) {
            return true;
        }
        return false;
    }

    public final boolean hasDisplay() {
        return hasCommand$watch_release(Command.SHOW_VIEW);
    }

    public final boolean hasDoNotDisturb() {
        return hasCommand$watch_release(Command.DND);
    }

    public final boolean hasFastMode() {
        return hasCommand$watch_release(Command.FASTMODE);
    }

    public final boolean hasRecalibrateHand() {
        return hasCommand$watch_release(Command.RECALIBRATE_HAND);
    }

    public final boolean isMapKnown$watch_release(String definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        if (this.knownMaps.contains(definition)) {
            return true;
        }
        String string = this.cache.getString(definition);
        if (string == null) {
            return false;
        }
        try {
            Json.Default r3 = Json.Default;
            r3.getClass();
            parseDefinitionMap(definition, (Map) r3.decodeFromString(new LinkedHashMapSerializer(IntSerializer.INSTANCE, StringSerializer.INSTANCE), string));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void parseDefinitionMapAndCache$watch_release(String definition, Map<Integer, String> pages) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(pages, "pages");
        parseDefinitionMap(definition, pages);
        BasicStorage basicStorage = this.cache;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(definition, r1.encodeToString(new LinkedHashMapSerializer(IntSerializer.INSTANCE, StringSerializer.INSTANCE), pages));
    }

    public String toString() {
        return this.commandMap.toString();
    }

    public final <K> Map<String, K> translate$watch_release(final Map<Integer, ? extends K> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.CommandCenter$translate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "parsed data: " + value;
            }
        }, 7, (Object) null);
        ArrayList arrayList = new ArrayList(value.size());
        for (Map.Entry<Integer, ? extends K> entry : value.entrySet()) {
            arrayList.add(new Pair(String.valueOf(this.commandMap.get(entry.getKey())), entry.getValue()));
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    public final String translate$watch_release(final int r8) {
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.CommandCenter$translate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "parsed data: " + r8;
            }
        }, 7, (Object) null);
        return String.valueOf(this.commandMap.get(Integer.valueOf(r8)));
    }
}
