package com.animaconnected.watch.theme;

import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolors;

/* compiled from: DarkThemeChartColors.kt */
/* loaded from: classes3.dex */
public final class DarkThemeChartColors implements ChartColors {
    private final int labels = Kolors.white60;
    private final int gridLines = Kolors.white5;
    private final int avgLine = Kolors.white50;
    private final int importantText = -1;
    private final int highlight = -7088896;
    private final int highlightVariant = GraphicsKt.darkenColorByPercentage(getHighlight(), 20);
    private final int background = Kolors.pascalChartBackground;
    private final int normal = Kolors.grey;
    private final int normalVariant = GraphicsKt.darkenColorByPercentage(getNormal(), 20);
    private final int sleepChartAwake = getHighlight();
    private final int sleepChartLight = GraphicsKt.darkenColorByPercentage(getHighlight(), 10);
    private final int sleepChartDeep = GraphicsKt.darkenColorByPercentage(getHighlight(), 25);
    private final int Vo2MaxChartSuperior = 1090519039;
    private final int Vo2MaxChartExcellent = Kolors.white20;
    private final int Vo2MaxChartGood = Kolors.white15;
    private final int Vo2MaxChartFair = Kolors.white10;
    private final int Vo2MaxChartPoor = Kolors.white5;
    private final int markerViewBackground = -15395563;

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getAvgLine() {
        return this.avgLine;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getBackground() {
        return this.background;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getGridLines() {
        return this.gridLines;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getHighlight() {
        return this.highlight;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getHighlightVariant() {
        return this.highlightVariant;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getImportantText() {
        return this.importantText;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getLabels() {
        return this.labels;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getMarkerViewBackground() {
        return this.markerViewBackground;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getNormal() {
        return this.normal;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getNormalVariant() {
        return this.normalVariant;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getSleepChartAwake() {
        return this.sleepChartAwake;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getSleepChartDeep() {
        return this.sleepChartDeep;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getSleepChartLight() {
        return this.sleepChartLight;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getVo2MaxChartExcellent() {
        return this.Vo2MaxChartExcellent;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getVo2MaxChartFair() {
        return this.Vo2MaxChartFair;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getVo2MaxChartGood() {
        return this.Vo2MaxChartGood;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getVo2MaxChartPoor() {
        return this.Vo2MaxChartPoor;
    }

    @Override // com.animaconnected.watch.theme.ChartColors
    public int getVo2MaxChartSuperior() {
        return this.Vo2MaxChartSuperior;
    }
}
