package com.amazonaws.internal.config;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes.dex */
public class HostRegexToRegionMapping {
    private final String hostNameRegex;
    private final String regionName;

    public HostRegexToRegionMapping(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            try {
                Pattern.compile(str);
                if (str2 != null && !str2.isEmpty()) {
                    this.hostNameRegex = str;
                    this.regionName = str2;
                    return;
                }
                throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: regionName must be non-empty");
            } catch (PatternSyntaxException e) {
                throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex is not a valid regex", e);
            }
        }
        throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex must be non-empty");
    }

    public String getHostNameRegex() {
        return this.hostNameRegex;
    }

    public String getRegionName() {
        return this.regionName;
    }
}
