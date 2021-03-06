/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath" 
 * exception as provided by Sun in the License file that accompanied 
 * this code.
 */
package org.jdesktop.wonderland.common.messages;

import java.io.Serializable;
import org.jdesktop.wonderland.common.ExperimentalAPI;

/**
 * The base type of a message in the Wonderland system. 
 * <p>
 * Every message in the system has a unique identifier.  This identifier is 
 * unique within the context of the session that created it, but may not be 
 * globally unique. For message that need to be unique across clients, the 
 * session id of the originating session should be included in the message.
 * <p>
 * Wonderland messages are by default serialized and sent to clients.  
 * Messages that are very frequent should be hand-packed using the 
 * Externalizable interface.
 * @see java.io.Externalizable
 * @author jkaplan
 */
@ExperimentalAPI
public abstract class Message implements Serializable {
    /**  The id of the message. */
    private MessageID messageID;
     
    /**
     * Create a new message with a new MessageID generated by calling
     * MessageID.generateMessageID();
     */
    protected Message() {
        this (MessageID.generateMessageID());
    }
    
    /**
     * Create a new message with an existing message id.  This can be used
     * when MessageIDs are known in advance (e.g. for response messages) or
     * when a different message ID generation scheme is in use.
     * @param messageID the ID of this message
     */
    protected Message(MessageID messageID) {
        this.messageID = messageID;
    }

    /**
     * Get the ID of a message
     * @return the MessageID
     */
    public MessageID getMessageID() {
        return messageID;
    }
    
    /**
     * Used by message input stream to set the message id
     * @param messageID the id to set
     */
    void setMessageID(MessageID messageID) {
        this.messageID = messageID;
    }
}
