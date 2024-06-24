package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class EmailAddressGrantee implements Grantee {
    private String emailAddress = null;

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        String str = this.emailAddress;
        if (str == null) {
            if (emailAddressGrantee.emailAddress != null) {
                return false;
            }
        } else if (!str.equals(emailAddressGrantee.emailAddress)) {
            return false;
        }
        return true;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.emailAddress;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return "emailAddress";
    }

    public int hashCode() {
        int hashCode;
        String str = this.emailAddress;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.emailAddress = str;
    }

    public String toString() {
        return this.emailAddress;
    }
}
