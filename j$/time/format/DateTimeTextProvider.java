package j$.time.format;

import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalField;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DateTimeTextProvider {
    private static final ConcurrentMap CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    private static final Comparator COMPARATOR = new Comparator() { // from class: j$.time.format.DateTimeTextProvider.1
        @Override // java.util.Comparator
        public int compare(Map.Entry entry, Map.Entry entry2) {
            return ((String) entry2.getKey()).length() - ((String) entry.getKey()).length();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class LocaleStore {
        private final Map parsable;
        private final Map valueTextMap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocaleStore(Map map) {
            this.valueTextMap = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    hashMap2.put((String) entry2.getValue(), DateTimeTextProvider.createEntry((String) entry2.getValue(), (Long) entry2.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, DateTimeTextProvider.COMPARATOR);
                hashMap.put((TextStyle) entry.getKey(), arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, DateTimeTextProvider.COMPARATOR);
            this.parsable = hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getText(long j, TextStyle textStyle) {
            Map map = (Map) this.valueTextMap.get(textStyle);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Iterator getTextIterator(TextStyle textStyle) {
            List list = (List) this.parsable.get(textStyle);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry createEntry(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    private Object createStore(TemporalField temporalField, Locale locale) {
        HashMap hashMap = new HashMap();
        int r3 = 0;
        if (temporalField == ChronoField.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            while (r3 < eras.length) {
                if (!eras[r3].isEmpty()) {
                    long j = r3;
                    hashMap2.put(Long.valueOf(j), eras[r3]);
                    hashMap3.put(Long.valueOf(j), firstCodePoint(eras[r3]));
                }
                r3++;
            }
            if (!hashMap2.isEmpty()) {
                hashMap.put(TextStyle.FULL, hashMap2);
                hashMap.put(TextStyle.SHORT, hashMap2);
                hashMap.put(TextStyle.NARROW, hashMap3);
            }
            return new LocaleStore(hashMap);
        }
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            String[] months = dateFormatSymbols2.getMonths();
            for (int r8 = 0; r8 < months.length; r8++) {
                if (!months[r8].isEmpty()) {
                    long j2 = r8 + 1;
                    hashMap4.put(Long.valueOf(j2), months[r8]);
                    hashMap5.put(Long.valueOf(j2), firstCodePoint(months[r8]));
                }
            }
            if (!hashMap4.isEmpty()) {
                hashMap.put(TextStyle.FULL, hashMap4);
                hashMap.put(TextStyle.NARROW, hashMap5);
            }
            HashMap hashMap6 = new HashMap();
            String[] shortMonths = dateFormatSymbols2.getShortMonths();
            while (r3 < shortMonths.length) {
                if (!shortMonths[r3].isEmpty()) {
                    hashMap6.put(Long.valueOf(r3 + 1), shortMonths[r3]);
                }
                r3++;
            }
            if (!hashMap6.isEmpty()) {
                hashMap.put(TextStyle.SHORT, hashMap6);
            }
            return new LocaleStore(hashMap);
        }
        if (temporalField != ChronoField.DAY_OF_WEEK) {
            if (temporalField != ChronoField.AMPM_OF_DAY) {
                return "";
            }
            DateFormatSymbols dateFormatSymbols3 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap7 = new HashMap();
            HashMap hashMap8 = new HashMap();
            String[] amPmStrings = dateFormatSymbols3.getAmPmStrings();
            while (r3 < amPmStrings.length) {
                if (!amPmStrings[r3].isEmpty()) {
                    long j3 = r3;
                    hashMap7.put(Long.valueOf(j3), amPmStrings[r3]);
                    hashMap8.put(Long.valueOf(j3), firstCodePoint(amPmStrings[r3]));
                }
                r3++;
            }
            if (!hashMap7.isEmpty()) {
                hashMap.put(TextStyle.FULL, hashMap7);
                hashMap.put(TextStyle.SHORT, hashMap7);
                hashMap.put(TextStyle.NARROW, hashMap8);
            }
            return new LocaleStore(hashMap);
        }
        DateFormatSymbols dateFormatSymbols4 = DateFormatSymbols.getInstance(locale);
        HashMap hashMap9 = new HashMap();
        String[] weekdays = dateFormatSymbols4.getWeekdays();
        hashMap9.put(1L, weekdays[2]);
        hashMap9.put(2L, weekdays[3]);
        hashMap9.put(3L, weekdays[4]);
        hashMap9.put(4L, weekdays[5]);
        hashMap9.put(5L, weekdays[6]);
        hashMap9.put(6L, weekdays[7]);
        hashMap9.put(7L, weekdays[1]);
        hashMap.put(TextStyle.FULL, hashMap9);
        HashMap hashMap10 = new HashMap();
        hashMap10.put(1L, firstCodePoint(weekdays[2]));
        hashMap10.put(2L, firstCodePoint(weekdays[3]));
        hashMap10.put(3L, firstCodePoint(weekdays[4]));
        hashMap10.put(4L, firstCodePoint(weekdays[5]));
        hashMap10.put(5L, firstCodePoint(weekdays[6]));
        hashMap10.put(6L, firstCodePoint(weekdays[7]));
        hashMap10.put(7L, firstCodePoint(weekdays[1]));
        hashMap.put(TextStyle.NARROW, hashMap10);
        HashMap hashMap11 = new HashMap();
        String[] shortWeekdays = dateFormatSymbols4.getShortWeekdays();
        hashMap11.put(1L, shortWeekdays[2]);
        hashMap11.put(2L, shortWeekdays[3]);
        hashMap11.put(3L, shortWeekdays[4]);
        hashMap11.put(4L, shortWeekdays[5]);
        hashMap11.put(5L, shortWeekdays[6]);
        hashMap11.put(6L, shortWeekdays[7]);
        hashMap11.put(7L, shortWeekdays[1]);
        hashMap.put(TextStyle.SHORT, hashMap11);
        return new LocaleStore(hashMap);
    }

    private Object findStore(TemporalField temporalField, Locale locale) {
        Map.Entry createEntry = createEntry(temporalField, locale);
        ConcurrentMap concurrentMap = CACHE;
        Object obj = concurrentMap.get(createEntry);
        if (obj != null) {
            return obj;
        }
        concurrentMap.putIfAbsent(createEntry, createStore(temporalField, locale));
        return concurrentMap.get(createEntry);
    }

    private static String firstCodePoint(String str) {
        return str.substring(0, Character.charCount(str.codePointAt(0)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateTimeTextProvider getInstance() {
        return new DateTimeTextProvider();
    }

    public String getText(Chronology chronology, TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        if (chronology == IsoChronology.INSTANCE || !(temporalField instanceof ChronoField)) {
            return getText(temporalField, j, textStyle, locale);
        }
        return null;
    }

    public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getText(j, textStyle);
        }
        return null;
    }

    public Iterator getTextIterator(Chronology chronology, TemporalField temporalField, TextStyle textStyle, Locale locale) {
        if (chronology == IsoChronology.INSTANCE || !(temporalField instanceof ChronoField)) {
            return getTextIterator(temporalField, textStyle, locale);
        }
        return null;
    }

    public Iterator getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getTextIterator(textStyle);
        }
        return null;
    }
}
