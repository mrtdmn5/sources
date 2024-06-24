package okhttp3;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Cookie.kt */
/* loaded from: classes4.dex */
public final class Cookie {
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: Cookie.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Code restructure failed: missing block: B:34:0x003d, code lost:            if (r0 != ':') goto L33;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int dateCharacterOffset(java.lang.String r4, int r5, int r6, boolean r7) {
            /*
            L0:
                if (r5 >= r6) goto L48
                char r0 = r4.charAt(r5)
                r1 = 32
                r2 = 1
                if (r0 >= r1) goto Lf
                r1 = 9
                if (r0 != r1) goto L3f
            Lf:
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L3f
                r1 = 57
                r3 = 0
                if (r0 > r1) goto L1e
                r1 = 48
                if (r1 > r0) goto L1e
                r1 = r2
                goto L1f
            L1e:
                r1 = r3
            L1f:
                if (r1 != 0) goto L3f
                r1 = 122(0x7a, float:1.71E-43)
                if (r0 > r1) goto L2b
                r1 = 97
                if (r1 > r0) goto L2b
                r1 = r2
                goto L2c
            L2b:
                r1 = r3
            L2c:
                if (r1 != 0) goto L3f
                r1 = 90
                if (r0 > r1) goto L38
                r1 = 65
                if (r1 > r0) goto L38
                r1 = r2
                goto L39
            L38:
                r1 = r3
            L39:
                if (r1 != 0) goto L3f
                r1 = 58
                if (r0 != r1) goto L40
            L3f:
                r3 = r2
            L40:
                r0 = r7 ^ 1
                if (r3 != r0) goto L45
                return r5
            L45:
                int r5 = r5 + 1
                goto L0
            L48:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        public static long parseExpires(int r14, String str) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            int dateCharacterOffset = dateCharacterOffset(str, 0, r14, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int r4 = -1;
            int r5 = -1;
            int r6 = -1;
            int r7 = -1;
            int r8 = -1;
            int r9 = -1;
            while (dateCharacterOffset < r14) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, r14, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (r5 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    r5 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    r8 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    r9 = Integer.parseInt(group3);
                } else if (r6 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    r6 = Integer.parseInt(group4);
                } else {
                    if (r7 == -1) {
                        Pattern pattern = Cookie.MONTH_PATTERN;
                        if (matcher.usePattern(pattern).matches()) {
                            String group5 = matcher.group(1);
                            Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            String lowerCase = group5.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                            String pattern2 = pattern.pattern();
                            Intrinsics.checkNotNullExpressionValue(pattern2, "MONTH_PATTERN.pattern()");
                            r7 = StringsKt__StringsKt.indexOf$default((CharSequence) pattern2, lowerCase, 0, false, 6) / 4;
                        }
                    }
                    if (r4 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                        String group6 = matcher.group(1);
                        Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                        r4 = Integer.parseInt(group6);
                    }
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, r14, false);
            }
            if (70 <= r4 && r4 < 100) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                r4 += 1900;
            }
            if (r4 >= 0 && r4 < 70) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                r4 += 2000;
            }
            if (r4 >= 1601) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (r7 != -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    if (1 <= r6 && r6 < 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        if (r5 >= 0 && r5 < 24) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            if (r8 >= 0 && r8 < 60) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                if (r9 >= 0 && r9 < 60) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                if (z8) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, r4);
                                    gregorianCalendar.set(2, r7 - 1);
                                    gregorianCalendar.set(5, r6);
                                    gregorianCalendar.set(11, r5);
                                    gregorianCalendar.set(12, r8);
                                    gregorianCalendar.set(13, r9);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public final int hashCode() {
        return Boolean.hashCode(this.hostOnly) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.persistent, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.httpOnly, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.secure, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.path, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.domain, Scale$$ExternalSyntheticOutline0.m(this.expiresAt, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.value, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.name, 527, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            long j = this.expiresAt;
            if (j == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String format = DatesKt.STANDARD_DATE_FORMAT.get().format(new Date(j));
                Intrinsics.checkNotNullExpressionValue(format, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(format);
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString()");
        return sb2;
    }
}
