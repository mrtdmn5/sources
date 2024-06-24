package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public class MapView extends FrameLayout {
    public final zzah zza;

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = new zzah(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        setClickable(true);
    }
}
