package com.systematic.doosystematic.domain.usecases.protocol;

import com.systematic.doosystematic.domain.entities.Protocol;
import com.systematic.doosystematic.utils.EntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteProtocolUseCase {
    private ProtocolDao dao;

    public DeleteProtocolUseCase(ProtocolDao dao) { this.dao = dao; }

    public boolean delete(UUID protocolId) {
        Optional<Protocol> optProtocol = dao.findOne(protocolId);
        if (optProtocol.isEmpty())
            throw new EntityNotFoundException("Protocol not found");
        return dao.delete(optProtocol.get());
    }

}
