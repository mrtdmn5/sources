package com.animaconnected.secondo.provider.stopwatch;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DurationFormatter {
    public static String millisecondsToString(int r11) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        Object m;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = r11;
        long minutes = timeUnit.toMinutes(j);
        long seconds = timeUnit.toSeconds(j);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        long seconds2 = seconds - timeUnit2.toSeconds(minutes);
        long millis = (j - timeUnit2.toMillis(minutes)) - TimeUnit.SECONDS.toMillis(seconds2);
        if (ProviderFactory.createConfigProvider().getTranslationCompatibleLocale().getLanguage().equalsIgnoreCase(Locale.JAPANESE.getLanguage())) {
            str = InstructionFileId.DOT;
        } else {
            str = ",";
        }
        if (minutes > 9) {
            sb = new StringBuilder("");
        } else {
            sb = new StringBuilder("0");
        }
        sb.append(minutes);
        StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(sb.toString(), ":");
        if (seconds2 > 9) {
            sb2 = new StringBuilder("");
        } else {
            sb2 = new StringBuilder("0");
        }
        sb2.append(seconds2);
        m2.append(sb2.toString());
        StringBuilder m3 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(m2.toString(), str);
        if (millis > 99) {
            m = Long.valueOf(millis / 10);
        } else if (millis > 9) {
            m = Long.valueOf(millis);
        } else {
            m = FileSectionType$$ExternalSyntheticOutline0.m("0", millis);
        }
        m3.append(m);
        return m3.toString();
    }
}
