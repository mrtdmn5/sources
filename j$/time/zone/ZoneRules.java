package j$.time.zone;

import com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter;
import j$.time.Clock;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class ZoneRules implements Serializable {
    private final ZoneOffsetTransitionRule[] lastRules;
    private final transient ConcurrentMap lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final TimeZone timeZone;
    private final ZoneOffset[] wallOffsets;
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];
    private static final ZoneOffsetTransition[] NO_TRANSITIONS = new ZoneOffsetTransition[0];

    private ZoneRules(ZoneOffset zoneOffset) {
        this.standardOffsets = r0;
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRules(TimeZone timeZone) {
        this.standardOffsets = r0;
        ZoneOffset[] zoneOffsetArr = {offsetFromMillis(timeZone.getRawOffset())};
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = timeZone;
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        boolean isGap = zoneOffsetTransition.isGap();
        boolean isBefore = localDateTime.isBefore(dateTimeBefore);
        return isGap ? isBefore ? zoneOffsetTransition.getOffsetBefore() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition : zoneOffsetTransition.getOffsetAfter() : !isBefore ? zoneOffsetTransition.getOffsetAfter() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition.getOffsetBefore() : zoneOffsetTransition;
    }

    private ZoneOffsetTransition[] findTransitionArray(int r20) {
        long j;
        long j2;
        Integer valueOf = Integer.valueOf(r20);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = (ZoneOffsetTransition[]) this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        if (this.timeZone == null) {
            ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
            ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
            if (zoneOffsetTransitionRuleArr.length > 0) {
                ZoneOffsetTransitionRule zoneOffsetTransitionRule = zoneOffsetTransitionRuleArr[0];
                throw null;
            }
            if (r20 < 2100) {
                this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
            }
            return zoneOffsetTransitionArr2;
        }
        if (r20 < 1800) {
            return NO_TRANSITIONS;
        }
        long epochSecond = LocalDateTime.of(r20 - 1, 12, 31, 0, 0).toEpochSecond(this.standardOffsets[0]);
        long j3 = 1000;
        int offset = this.timeZone.getOffset(epochSecond * 1000);
        long j4 = 31968000 + epochSecond;
        ZoneOffsetTransition[] zoneOffsetTransitionArr3 = NO_TRANSITIONS;
        while (epochSecond < j4) {
            long j5 = 7776000 + epochSecond;
            long j6 = epochSecond;
            if (offset != this.timeZone.getOffset(j5 * j3)) {
                epochSecond = j6;
                while (j5 - epochSecond > 1) {
                    long j7 = j4;
                    long floorDiv = Math.floorDiv(j5 + epochSecond, 2L);
                    long j8 = j5;
                    if (this.timeZone.getOffset(floorDiv * 1000) == offset) {
                        epochSecond = floorDiv;
                        j5 = j8;
                    } else {
                        j5 = floorDiv;
                    }
                    j3 = 1000;
                    j4 = j7;
                }
                j = j4;
                long j9 = j5;
                j2 = j3;
                if (this.timeZone.getOffset(epochSecond * j2) == offset) {
                    epochSecond = j9;
                }
                ZoneOffset offsetFromMillis = offsetFromMillis(offset);
                int offset2 = this.timeZone.getOffset(epochSecond * j2);
                ZoneOffset offsetFromMillis2 = offsetFromMillis(offset2);
                if (findYear(epochSecond, offsetFromMillis2) == r20) {
                    ZoneOffsetTransition[] zoneOffsetTransitionArr4 = (ZoneOffsetTransition[]) Arrays.copyOf(zoneOffsetTransitionArr3, zoneOffsetTransitionArr3.length + 1);
                    zoneOffsetTransitionArr4[zoneOffsetTransitionArr4.length - 1] = new ZoneOffsetTransition(epochSecond, offsetFromMillis, offsetFromMillis2);
                    offset = offset2;
                    zoneOffsetTransitionArr3 = zoneOffsetTransitionArr4;
                } else {
                    offset = offset2;
                }
            } else {
                j = j4;
                j2 = j3;
                epochSecond = j5;
            }
            j3 = j2;
            j4 = j;
        }
        if (1916 <= r20 && r20 < 2100) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr3);
        }
        return zoneOffsetTransitionArr3;
    }

    private int findYear(long j, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Math.floorDiv(j + zoneOffset.getTotalSeconds(), 86400L)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        Object obj = null;
        int r2 = 0;
        if (this.timeZone != null) {
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
            if (findTransitionArray.length == 0) {
                return offsetFromMillis(this.timeZone.getOffset(localDateTime.toEpochSecond(this.standardOffsets[0]) * 1000));
            }
            int length = findTransitionArray.length;
            while (r2 < length) {
                ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[r2];
                Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                    return findOffsetInfo;
                }
                r2++;
                obj = findOffsetInfo;
            }
            return obj;
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        if (this.lastRules.length > 0) {
            if (localDateTime.isAfter(this.savingsLocalTransitions[r0.length - 1])) {
                ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(localDateTime.getYear());
                int length2 = findTransitionArray2.length;
                while (r2 < length2) {
                    ZoneOffsetTransition zoneOffsetTransition2 = findTransitionArray2[r2];
                    Object findOffsetInfo2 = findOffsetInfo(localDateTime, zoneOffsetTransition2);
                    if ((findOffsetInfo2 instanceof ZoneOffsetTransition) || findOffsetInfo2.equals(zoneOffsetTransition2.getOffsetBefore())) {
                        return findOffsetInfo2;
                    }
                    r2++;
                    obj = findOffsetInfo2;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            Object[] objArr = this.savingsLocalTransitions;
            if (binarySearch < objArr.length - 1) {
                int r22 = binarySearch + 1;
                if (objArr[binarySearch].equals(objArr[r22])) {
                    binarySearch = r22;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.wallOffsets[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
        LocalDateTime localDateTime2 = localDateTimeArr[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int r7 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[r7];
        ZoneOffset zoneOffset2 = zoneOffsetArr[r7 + 1];
        return zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    public static ZoneRules of(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return new ZoneRules(zoneOffset);
    }

    private static ZoneOffset offsetFromMillis(int r0) {
        return ZoneOffset.ofTotalSeconds(r0 / 1000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneRules)) {
            return false;
        }
        ZoneRules zoneRules = (ZoneRules) obj;
        return Objects.equals(this.timeZone, zoneRules.timeZone) && Arrays.equals(this.standardTransitions, zoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, zoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, zoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, zoneRules.wallOffsets) && Arrays.equals(this.lastRules, zoneRules.lastRules);
    }

    public ZoneOffset getOffset(Instant instant) {
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            return offsetFromMillis(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            if (epochSecond > this.savingsInstantTransitions[r7.length - 1]) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, this.wallOffsets[r7.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int r1 = 0; r1 < findTransitionArray.length; r1++) {
                    zoneOffsetTransition = findTransitionArray[r1];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            return offsetFromMillis(timeZone.getRawOffset());
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.standardOffsets[binarySearch + 1];
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    public List getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        return offsetInfo instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) offsetInfo).getValidOffsets() : Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public int hashCode() {
        return ((((Objects.hashCode(this.timeZone) ^ Arrays.hashCode(this.standardTransitions)) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isFixedOffset() {
        TimeZone timeZone = this.timeZone;
        return timeZone != null ? !timeZone.useDaylightTime() && this.timeZone.getDSTSavings() == 0 && previousTransition(Instant.now()) == null : this.savingsInstantTransitions.length == 0;
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.timeZone == null) {
            if (this.savingsInstantTransitions.length == 0) {
                return null;
            }
            long epochSecond = instant.getEpochSecond();
            if (instant.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
                epochSecond++;
            }
            long[] jArr = this.savingsInstantTransitions;
            long j = jArr[jArr.length - 1];
            if (this.lastRules.length > 0 && epochSecond > j) {
                ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
                int findYear = findYear(epochSecond, zoneOffset);
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear);
                for (int length = findTransitionArray.length - 1; length >= 0; length--) {
                    if (epochSecond > findTransitionArray[length].toEpochSecond()) {
                        return findTransitionArray[length];
                    }
                }
                int r4 = findYear - 1;
                if (r4 > findYear(j, zoneOffset)) {
                    ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(r4);
                    return findTransitionArray2[findTransitionArray2.length - 1];
                }
            }
            int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 1;
            }
            if (binarySearch <= 0) {
                return null;
            }
            int r42 = binarySearch - 1;
            long j2 = this.savingsInstantTransitions[r42];
            ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
            return new ZoneOffsetTransition(j2, zoneOffsetArr2[r42], zoneOffsetArr2[binarySearch]);
        }
        long epochSecond2 = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSecond2 < Long.MAX_VALUE) {
            epochSecond2++;
        }
        int findYear2 = findYear(epochSecond2, getOffset(instant));
        ZoneOffsetTransition[] findTransitionArray3 = findTransitionArray(findYear2);
        for (int length2 = findTransitionArray3.length - 1; length2 >= 0; length2--) {
            if (epochSecond2 > findTransitionArray3[length2].toEpochSecond()) {
                return findTransitionArray3[length2];
            }
        }
        if (findYear2 > 1800) {
            ZoneOffsetTransition[] findTransitionArray4 = findTransitionArray(findYear2 - 1);
            for (int length3 = findTransitionArray4.length - 1; length3 >= 0; length3--) {
                if (epochSecond2 > findTransitionArray4[length3].toEpochSecond()) {
                    return findTransitionArray4[length3];
                }
            }
            int offset = this.timeZone.getOffset((epochSecond2 - 1) * 1000);
            long epochDay = LocalDate.of(DebugSettingsPresenter.CRITICAL_BATTERY, 1, 1).toEpochDay() * 86400;
            for (long min = Math.min(epochSecond2 - 31104000, (Clock.systemUTC().millis() / 1000) + 31968000); epochDay <= min; min -= 7776000) {
                int offset2 = this.timeZone.getOffset(min * 1000);
                if (offset != offset2) {
                    int findYear3 = findYear(min, offsetFromMillis(offset2));
                    ZoneOffsetTransition[] findTransitionArray5 = findTransitionArray(findYear3 + 1);
                    for (int length4 = findTransitionArray5.length - 1; length4 >= 0; length4--) {
                        if (epochSecond2 > findTransitionArray5[length4].toEpochSecond()) {
                            return findTransitionArray5[length4];
                        }
                    }
                    ZoneOffsetTransition[] findTransitionArray6 = findTransitionArray(findYear3);
                    return findTransitionArray6[findTransitionArray6.length - 1];
                }
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb;
        if (this.timeZone != null) {
            sb = new StringBuilder();
            sb.append("ZoneRules[timeZone=");
            sb.append(this.timeZone.getID());
        } else {
            sb = new StringBuilder();
            sb.append("ZoneRules[currentStandardOffset=");
            sb.append(this.standardOffsets[r2.length - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
