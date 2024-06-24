package com.google.android.gms.maps.model;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class CustomCap extends Cap {
    public final BitmapDescriptor bitmapDescriptor;
    public final float refWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCap(BitmapDescriptor bitmapDescriptor, float f) {
        super(3, bitmapDescriptor, Float.valueOf(f));
        if (bitmapDescriptor != null) {
            if (f > 0.0f) {
                this.bitmapDescriptor = bitmapDescriptor;
                this.refWidth = f;
                return;
            }
            throw new IllegalArgumentException("refWidth must be positive");
        }
        throw new NullPointerException("bitmapDescriptor must not be null");
    }

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        return "[CustomCap: bitmapDescriptor=" + String.valueOf(this.bitmapDescriptor) + " refWidth=" + this.refWidth + "]";
    }
}
