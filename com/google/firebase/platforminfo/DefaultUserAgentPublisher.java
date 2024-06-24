package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class DefaultUserAgentPublisher implements UserAgentPublisher {
    public final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
    public final String javaSDKVersionUserAgent;

    public DefaultUserAgentPublisher(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.javaSDKVersionUserAgent = toUserAgent(set);
        this.gamesSDKRegistrar = globalLibraryVersionRegistrar;
    }

    public static String toUserAgent(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion next = it.next();
            sb.append(next.getLibraryName());
            sb.append('/');
            sb.append(next.getVersion());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public final String getUserAgent() {
        Set unmodifiableSet;
        Set unmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.gamesSDKRegistrar;
        synchronized (globalLibraryVersionRegistrar.infos) {
            unmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.infos);
        }
        boolean isEmpty = unmodifiableSet.isEmpty();
        String str = this.javaSDKVersionUserAgent;
        if (isEmpty) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (globalLibraryVersionRegistrar.infos) {
            unmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar.infos);
        }
        sb.append(toUserAgent(unmodifiableSet2));
        return sb.toString();
    }
}
