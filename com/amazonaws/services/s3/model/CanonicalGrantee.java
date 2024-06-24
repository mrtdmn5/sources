package com.amazonaws.services.s3.model;

import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CanonicalGrantee implements Grantee, Serializable {
    private String id = null;
    private String displayName = null;

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.id.equals(((CanonicalGrantee) obj).id);
        }
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.id;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return ConfigurationItem.COLUMN_NAME_ID;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.id = str;
    }
}
