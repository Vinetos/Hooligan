package com.safexty.hooligan.network.messages.out;

import com.safexty.hooligan.network.messages.HooliganMessage;
import com.safexty.hooligan.network.objects.out.ResearchMembersObject;
import com.safexty.hooligan.network.objects.out.ResearchSynopticObject;
import flex.messaging.messages.RemotingMessage;
import flex.messaging.util.UUIDUtils;

/**
 * File <b>ReseachSynopticMessage</b> located on com.safexty.hooligan.network.messages.out
 * Hooligan is a part of SAFExTY Project.
 * <p>
 *   ____    _    _____ _____      _______   __       :::     ::: ::::::::::: ::::    ::: :::::::::: ::::::::::: ::::::::   ::::::::
 * / ___|  / \  |  ___| ____|_  _|_   _\ \ / /      :+:     :+:     :+:     :+:+:   :+: :+:            :+:    :+:    :+: :+:    :+:
 * \___ \ / _ \ | |_  |  _| \ \/ / | |  \ V /     +:+     +:+     +:+     :+:+:+  +:+ +:+            +:+    +:+    +:+ +:+
 *   ___) / ___ \|  _| | |___ >  <  | |   | |     +#+     +:+     +#+     +#+ +:+ +#+ +#++:++#       +#+    +#+    +:+ +#++:++#++
 * |____/_/   \_\_|   |_____/_/\_\ |_|   |_|     +#+   +#+      +#+     +#+  +#+#+# +#+            +#+    +#+    +#+        +#+
 *                                               #+#+#+#       #+#     #+#   #+#+# #+#            #+#    #+#    #+# #+#    #+#
 *                and                             ::::    ::::::::::: ::::   ::::  ::::::::::    :::    ::::::::::  ::::::::        .fr
 *
 * <p>
 * Copyright (c) 2019 SAFExTY.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * <p>
 *
 * @author Valentin Chassignol (Valentin), {@literal <contact@vinetos.fr>}, https://www.vinetos.fr
 * Created the 04/11/2019 14:18
 * @version 0.0.1
 * @since 0.0.1
 *
 * <p>
 * The synoptic message
 */
public class ResearchMembers extends HooliganMessage<RemotingMessage> {

    private final ResearchMembersObject researchSynopticObject;

    public ResearchMembers(ResearchMembersObject researchSynopticObject) {
        super("recherchePersonnels", "personnelService");
        this.researchSynopticObject = researchSynopticObject;
    }

    @Override
    public RemotingMessage getRawMessage() {
        var msg = new RemotingMessage();
        msg.setOperation(getOperation());
        msg.setDestination(getDestination());
        msg.setMessageId(UUIDUtils.createUUID());
        msg.setBody(new Object[]{researchSynopticObject.createObject()});
        return msg;
    }
}
