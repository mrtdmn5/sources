package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.TouchListener;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerView.kt */
/* loaded from: classes3.dex */
public abstract class MarkerView {
    private final float backgroundRadius;
    private RectF bounds;
    private RectF outerBounds;
    private float xPos;
    private float yPos;
    private TouchListener.Event touchEvent = new TouchListener.Event.Idle(null, 1, null);
    private PointF touchPosition = PointF.Companion.getZero();
    private float padding = 8.0f;
    private final float contentPadding = 8.0f;

    public MarkerView() {
        RectF.Companion companion = RectF.Companion;
        this.bounds = companion.getZero();
        this.outerBounds = companion.getZero();
        this.backgroundRadius = 8.0f;
    }

    public abstract void draw();

    public abstract CanvasPaint getBackground();

    public final float getBackgroundRadius() {
        return this.backgroundRadius;
    }

    public final RectF getBounds() {
        return this.bounds;
    }

    public abstract Kanvas getCanvas();

    public final float getContentPadding() {
        return this.contentPadding;
    }

    public final RectF getOuterBounds() {
        return this.outerBounds;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final TouchListener.Event getTouchEvent() {
        return this.touchEvent;
    }

    public final PointF getTouchPosition() {
        return this.touchPosition;
    }

    public final float getXPos() {
        return this.xPos;
    }

    public final float getYPos() {
        return this.yPos;
    }

    public final void setBounds(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.bounds = rectF;
    }

    public final void setOuterBounds(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.outerBounds = rectF;
    }

    public final void setPadding(float f) {
        this.padding = f;
    }

    public final void setTouchEvent(TouchListener.Event event) {
        Intrinsics.checkNotNullParameter(event, "<set-?>");
        this.touchEvent = event;
    }

    public final void setTouchPosition(PointF pointF) {
        this.touchPosition = pointF;
    }

    public final void setXPos(float f) {
        this.xPos = f;
    }

    public final void setYPos(float f) {
        this.yPos = f;
    }
}
