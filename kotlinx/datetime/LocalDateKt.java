package kotlinx.datetime;

/* compiled from: LocalDate.kt */
/* loaded from: classes4.dex */
public final class LocalDateKt {
    public static LocalDateTime atTime$default(LocalDate localDate, int r10, int r11) {
        j$.time.LocalDate localDate2 = localDate.value;
        return new LocalDateTime(localDate2.getYear(), localDate2.getMonthValue(), localDate2.getDayOfMonth(), r10, r11, 0, 0);
    }
}
