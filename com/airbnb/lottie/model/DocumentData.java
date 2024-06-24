package com.airbnb.lottie.model;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class DocumentData {
    public float baselineShift;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int r5, float f2, float f3, int r8, int r9, float f4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.size = f;
        this.justification = justification;
        this.tracking = r5;
        this.lineHeight = f2;
        this.baselineShift = f3;
        this.color = r8;
        this.strokeColor = r9;
        this.strokeWidth = f4;
        this.strokeOverFill = z;
    }

    public final int hashCode() {
        int ordinal = ((this.justification.ordinal() + (((int) (TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.fontName, this.text.hashCode() * 31, 31) + this.size)) * 31)) * 31) + this.tracking;
        long floatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((ordinal * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public DocumentData() {
    }
}
