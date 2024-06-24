package com.amazonaws.regions;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionUtils {
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    private static List<Region> regions;

    public static Region getRegion(String str) {
        for (Region region : getRegions()) {
            if (region.getName().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region getRegionByEndpoint(String str) {
        String host = getUriByEndpoint(str).getHost();
        for (Region region : getRegions()) {
            Iterator<String> it = region.getServiceEndpoints().values().iterator();
            while (it.hasNext()) {
                if (getUriByEndpoint(it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("No region found with any service for endpoint ", str));
    }

    public static synchronized List<Region> getRegions() {
        List<Region> list;
        synchronized (RegionUtils.class) {
            if (regions == null) {
                init();
            }
            list = regions;
        }
        return list;
    }

    public static synchronized List<Region> getRegionsForService(String str) {
        LinkedList linkedList;
        synchronized (RegionUtils.class) {
            linkedList = new LinkedList();
            for (Region region : getRegions()) {
                if (region.isServiceSupported(str)) {
                    linkedList.add(region);
                }
            }
        }
        return linkedList;
    }

    private static URI getUriByEndpoint(String str) {
        try {
            URI r1 = new URI(str);
            if (r1.getHost() == null) {
                return new URI("http://" + str);
            }
            return r1;
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to parse service endpoint: " + e.getMessage());
        }
    }

    public static synchronized void init() {
        synchronized (RegionUtils.class) {
            if (System.getProperty(SDKGlobalConfiguration.REGIONS_FILE_OVERRIDE_SYSTEM_PROPERTY) != null) {
                try {
                    loadRegionsFromOverrideFile();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("Couldn't find regions override file specified", e);
                }
            }
            if (regions == null) {
                initSDKRegions();
            }
            if (regions == null) {
                throw new RuntimeException("Failed to initialize the regions.");
            }
        }
    }

    private static void initRegions(InputStream inputStream) {
        try {
            regions = new RegionMetadataParser().parseRegionMetadata(inputStream);
        } catch (Exception e) {
            log.warn("Failed to parse regional endpoints", e);
        }
    }

    private static void initSDKRegions() {
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Initializing the regions with default regions");
        }
        regions = RegionDefaults.getRegions();
    }

    private static void loadRegionsFromOverrideFile() throws FileNotFoundException {
        String property = System.getProperty(SDKGlobalConfiguration.REGIONS_FILE_OVERRIDE_SYSTEM_PROPERTY);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        initRegions(new FileInputStream(new File(property)));
    }
}
