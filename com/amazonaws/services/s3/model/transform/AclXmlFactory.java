package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Owner;

/* loaded from: classes.dex */
public class AclXmlFactory {
    public XmlWriter convertToXml(Grantee grantee, XmlWriter xmlWriter) throws AmazonClientException {
        if (grantee instanceof CanonicalGrantee) {
            return convertToXml((CanonicalGrantee) grantee, xmlWriter);
        }
        if (grantee instanceof EmailAddressGrantee) {
            return convertToXml((EmailAddressGrantee) grantee, xmlWriter);
        }
        if (grantee instanceof GroupGrantee) {
            return convertToXml((GroupGrantee) grantee, xmlWriter);
        }
        throw new AmazonClientException("Unknown Grantee type: ".concat(grantee.getClass().getName()));
    }

    public byte[] convertToXmlByteArray(AccessControlList accessControlList) throws AmazonClientException {
        Owner owner = accessControlList.getOwner();
        if (owner != null) {
            XmlWriter xmlWriter = new XmlWriter();
            xmlWriter.start("AccessControlPolicy", "xmlns", Constants.XML_NAMESPACE);
            xmlWriter.start("Owner");
            if (owner.getId() != null) {
                xmlWriter.start("ID").value(owner.getId()).end();
            }
            if (owner.getDisplayName() != null) {
                xmlWriter.start("DisplayName").value(owner.getDisplayName()).end();
            }
            xmlWriter.end();
            xmlWriter.start("AccessControlList");
            for (Grant grant : accessControlList.getGrants()) {
                xmlWriter.start("Grant");
                convertToXml(grant.getGrantee(), xmlWriter);
                xmlWriter.start("Permission").value(grant.getPermission().toString()).end();
                xmlWriter.end();
            }
            xmlWriter.end();
            xmlWriter.end();
            return xmlWriter.getBytes();
        }
        throw new AmazonClientException("Invalid AccessControlList: missing an S3Owner");
    }

    public XmlWriter convertToXml(CanonicalGrantee canonicalGrantee, XmlWriter xmlWriter) {
        xmlWriter.start("Grantee", new String[]{"xmlns:xsi", "xsi:type"}, new String[]{"http://www.w3.org/2001/XMLSchema-instance", "CanonicalUser"});
        xmlWriter.start("ID").value(canonicalGrantee.getIdentifier()).end();
        xmlWriter.end();
        return xmlWriter;
    }

    public XmlWriter convertToXml(EmailAddressGrantee emailAddressGrantee, XmlWriter xmlWriter) {
        xmlWriter.start("Grantee", new String[]{"xmlns:xsi", "xsi:type"}, new String[]{"http://www.w3.org/2001/XMLSchema-instance", "AmazonCustomerByEmail"});
        xmlWriter.start("EmailAddress").value(emailAddressGrantee.getIdentifier()).end();
        xmlWriter.end();
        return xmlWriter;
    }

    public XmlWriter convertToXml(GroupGrantee groupGrantee, XmlWriter xmlWriter) {
        xmlWriter.start("Grantee", new String[]{"xmlns:xsi", "xsi:type"}, new String[]{"http://www.w3.org/2001/XMLSchema-instance", "Group"});
        xmlWriter.start("URI").value(groupGrantee.getIdentifier()).end();
        xmlWriter.end();
        return xmlWriter;
    }
}
