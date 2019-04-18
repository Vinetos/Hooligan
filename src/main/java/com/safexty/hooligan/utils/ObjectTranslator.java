package com.safexty.hooligan.utils;

import flex.messaging.io.ArrayCollection;
import flex.messaging.io.amf.ASObject;

import java.util.Map;

import static com.safexty.hooligan.utils.StringUtils.isNumber;

/**
 * File <b>ObjectTranslator</b> located on com.safexty.hooligan.utils
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
 * Created the 18/04/2019 13:20
 * @version 0.0.1
 * @since 0.0.1
 *
 * <p>
 * Convert an object into JSON
 */
public class ObjectTranslator {

    /**
     * Transform an {@link ASObject} into a parsable JSON String
     *
     * @param object The object to parse
     * @return the parsed string
     */
    public static String toJson(ASObject object) {
        StringBuilder buffer = new StringBuilder("{");
        // True is the object has more than one pair in the entrySet
        boolean pairEmitted = false;
        for (Object o : object.entrySet()) {
            if (pairEmitted) // Add , before the next object
                buffer.append(",");

            Map.Entry e = (Map.Entry) o;
            buffer.append('"').append(e.getKey()).append('"').append(':'); // Add "key":

            // Parse the value to follow JSON syntax
            final Object valueObj = e.getValue();
            // The null case
            if (valueObj == null) {
                buffer.append("null");
                pairEmitted = true;
                continue;
            }
            String value = valueObj.toString();
            // It's another object
            if (valueObj instanceof ASObject)
                buffer.append(toJson((ASObject) valueObj));
                // It' an array of objects
            else if (valueObj instanceof ArrayCollection) {
                buffer.append("[");
                boolean pairPermitted2 = false;
                for (Object o2 : (ArrayCollection) valueObj) {
                    if (pairPermitted2)
                        buffer.append(",");
                    buffer.append(toJson((ASObject) o2));
                    pairPermitted2 = true;
                }
                buffer.append("]");
            }
            // It's a common type (number, boolean)
            else if (isNumber(value) || "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value))
                buffer.append(valueObj);
                // Otherwise "value"
            else
                buffer.append('"').append(value).append('"');
            pairEmitted = true;
        }
        buffer.append('}');
        return buffer.toString();
    }

}
