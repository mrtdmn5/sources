package com.animaconnected.secondo.screens.activity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes3.dex */
public class StepFormatHelper {
    private static final int RECOMMENDED_STEPS_GOAL_FROM = 7000;
    private static final int RECOMMENDED_STEPS_GOAL_TO = 10000;
    private final DecimalFormat mDecimalFormatter;
    private final NumberFormat mNumberFormatter;

    public StepFormatHelper(Locale locale) {
        this.mDecimalFormatter = (DecimalFormat) NumberFormat.getInstance(locale);
        this.mNumberFormatter = NumberFormat.getPercentInstance(locale);
    }

    public String formatNumber(int r4) {
        return this.mDecimalFormatter.format(r4);
    }

    public String formatPercent(float f) {
        return this.mNumberFormatter.format(f);
    }

    public String getHundredPercent() {
        return formatPercent(1.0f);
    }

    public String getRecommendedStepsGoalFromFormatted() {
        return formatNumber(RECOMMENDED_STEPS_GOAL_FROM);
    }

    public String getRecommendedStepsGoalToFormatted() {
        return formatNumber(10000);
    }
}
