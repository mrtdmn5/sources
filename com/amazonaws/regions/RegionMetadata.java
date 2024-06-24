package com.amazonaws.regions;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMetadata {
    private final List<Region> regions;

    public RegionMetadata(List<Region> list) {
        if (list != null) {
            this.regions = Collections.unmodifiableList(new ArrayList(list));
            return;
        }
        throw new IllegalArgumentException("regions cannot be null");
    }

    private static String getHost(String str) {
        String host = URI.create(str).getHost();
        if (host == null) {
            return URI.create("http://" + str).getHost();
        }
        return host;
    }

    public Region getRegion(String str) {
        for (Region region : this.regions) {
            if (region.getName().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public Region getRegionByEndpoint(String str) {
        String host = getHost(str);
        for (Region region : this.regions) {
            Iterator<String> it = region.getServiceEndpoints().values().iterator();
            while (it.hasNext()) {
                if (host.equals(getHost(it.next()))) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("No region found with any service for endpoint ", str));
    }

    public List<Region> getRegions() {
        return this.regions;
    }

    public List<Region> getRegionsForService(String str) {
        LinkedList linkedList = new LinkedList();
        for (Region region : this.regions) {
            if (region.isServiceSupported(str)) {
                linkedList.add(region);
            }
        }
        return linkedList;
    }

    public String toString() {
        return this.regions.toString();
    }
}
