package com.animaconnected.bluetooth.device.scanner;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.util.BrandId;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrandFilter.kt */
/* loaded from: classes.dex */
public final class BrandFilter {
    private final BrandId brandId;
    private final boolean useLegacyAdvertisement;

    public BrandFilter(BrandId brandId, boolean z) {
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        this.brandId = brandId;
        this.useLegacyAdvertisement = z;
    }

    public static /* synthetic */ BrandFilter copy$default(BrandFilter brandFilter, BrandId brandId, boolean z, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            brandId = brandFilter.brandId;
        }
        if ((r3 & 2) != 0) {
            z = brandFilter.useLegacyAdvertisement;
        }
        return brandFilter.copy(brandId, z);
    }

    public final BrandId component1() {
        return this.brandId;
    }

    public final boolean component2() {
        return this.useLegacyAdvertisement;
    }

    public final BrandFilter copy(BrandId brandId, boolean z) {
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        return new BrandFilter(brandId, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrandFilter)) {
            return false;
        }
        BrandFilter brandFilter = (BrandFilter) obj;
        if (this.brandId == brandFilter.brandId && this.useLegacyAdvertisement == brandFilter.useLegacyAdvertisement) {
            return true;
        }
        return false;
    }

    public final BrandId getBrandId() {
        return this.brandId;
    }

    public final boolean getUseLegacyAdvertisement() {
        return this.useLegacyAdvertisement;
    }

    public int hashCode() {
        return Boolean.hashCode(this.useLegacyAdvertisement) + (this.brandId.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BrandFilter(brandId=");
        sb.append(this.brandId);
        sb.append(", useLegacyAdvertisement=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.useLegacyAdvertisement, ')');
    }
}
