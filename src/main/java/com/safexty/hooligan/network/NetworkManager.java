package com.safexty.hooligan.network;

import com.safexty.hooligan.utils.ConfigLoader;
import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;
import flex.messaging.messages.AcknowledgeMessage;
import flex.messaging.messages.RemotingMessage;

public class NetworkManager {

    public static AcknowledgeMessage request(RemotingMessage remotingMessage) {
        AMFConnection amfConnection = new AMFConnection();
        AcknowledgeMessage message = null;
        try {
            amfConnection.connect(ConfigLoader.getConfig().gatewayUrl);
            message = (AcknowledgeMessage) amfConnection.call("null", remotingMessage);
        } catch (ClientStatusException | ServerStatusException e) {
            e.printStackTrace();
        } finally {
            amfConnection.close();
        }
        return message;
    }

}
