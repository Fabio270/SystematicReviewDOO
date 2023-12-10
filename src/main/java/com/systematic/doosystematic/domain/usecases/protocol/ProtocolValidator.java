package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.utils.Notification;
import com.systematic.doosystematic.utils.Validator;

public class ProtocolValidator extends Validator<Protocol> {
    public Notification validate(Protocol protocol) {
        Notification notification = new Notification();

        if (protocol == null) {
            notification.addError("Protocol is null.");
            return notification;
        }

        if (nullOrEmpty(protocol.getDescription())) notification.addError("Description is null or empty.");
        if (nullOrEmpty(protocol.getSearchString())) notification.addError("SearchString is null or empty.");
        if (protocol.getForm().isEmpty()) notification.addError("Form is empty.");
        if (protocol.getExclusionCriteria().isEmpty()) notification.addError("ExclusionCriteria is empty.");
        if (protocol.getInclusionCriteria().isEmpty()) notification.addError("Inclusion criteria is empty.");

        return null;
    }
}
