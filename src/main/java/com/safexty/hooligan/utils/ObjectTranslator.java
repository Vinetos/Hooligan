package com.safexty.hooligan.utils;

import flex.messaging.io.ArrayCollection;
import flex.messaging.io.amf.ASObject;

import java.awt.desktop.SystemSleepEvent;
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
        if (object == null)
            return "";
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
            // It's an array of objects
            if (valueObj instanceof ArrayCollection) {
                buffer.append("[");
                boolean pairPermitted2 = false;
                for (Object o2 : (ArrayCollection) valueObj) {
                    if (pairPermitted2)
                        buffer.append(",");
                    // TODO: 22/03/2020 Code duplication
                    if (o2 == null) {
                        buffer.append("null");
                        pairPermitted2 = true;
                        continue;
                    }
                    String value2 = o2.toString();
                    if (o2 instanceof ASObject)
                        buffer.append(toJson((ASObject) o2));
                    else if (isNumber(value2))
                        if (value2.contains("."))
                            buffer.append(Double.parseDouble(value2));
                        else
                            buffer.append(Long.parseLong(value2));
                    else if ("true".equalsIgnoreCase(value2) || "false".equalsIgnoreCase(value2))
                        buffer.append(o2);
                        // Otherwise "value"
                    else
                        buffer.append('"').append(value2).append('"');
                    pairPermitted2 = true;
                }
                buffer.append("]");
            }
            // It's another object
            else if (valueObj instanceof ASObject)
                buffer.append(toJson((ASObject) valueObj));
                // It's a common type (number, boolean)
            else if (isNumber(value))
                if (value.contains("."))
                    buffer.append(Double.parseDouble(value));
                else
                    buffer.append(Long.parseLong(value));
            else if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value))
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
