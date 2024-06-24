package com.animaconnected.watch.strings;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class StringsKt {
    private static final Lazy strings$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Map<Language, ? extends Map<Key, ? extends String>>>() { // from class: com.animaconnected.watch.strings.StringsKt$strings$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<Language, ? extends Map<Key, ? extends String>> invoke() {
            return MapsKt__MapsKt.mapOf(new Pair(Language.CS, CsKt.getCs()), new Pair(Language.DA, DaKt.getDa()), new Pair(Language.DE, DeKt.getDe()), new Pair(Language.EL, ElKt.getEl()), new Pair(Language.EN, EnKt.getEn()), new Pair(Language.ES, EsKt.getEs()), new Pair(Language.FR, FrKt.getFr()), new Pair(Language.HU, HuKt.getHu()), new Pair(Language.IT, ItKt.getIt()), new Pair(Language.JA, JaKt.getJa()), new Pair(Language.PL, PlKt.getPl()), new Pair(Language.PT, PtKt.getPt()), new Pair(Language.RU, RuKt.getRu()), new Pair(Language.SK, SkKt.getSk()), new Pair(Language.SV, SvKt.getSv()), new Pair(Language.ZH, ZhKt.getZh()));
        }
    });

    public static final Map<Language, Map<Key, String>> getStrings() {
        return (Map) strings$delegate.getValue();
    }
}
