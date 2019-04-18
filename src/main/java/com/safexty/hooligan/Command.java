package com.safexty.hooligan;

import java.util.stream.Stream;

/**
 * File <b>Command</b> located on com.safexty.hooligan
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
 * Created the 18/04/2019 17:12
 * @version 0.0.1
 * @since 0.0.1
 *
 * <p>
 * All commands available in the program
 */
public enum Command {

    LOGIN("login", new String[]{"user", "password"}),
    OTHER("", null);

    private final String command;
    private final String[] arguments;

    Command(String command, String[] arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }

    public int getArgumentsCount() {
        return arguments == null ? 0 : arguments.length;
    }

    public static Command getCommandFromString(final String str) {
        return Stream.of(Command.values()).filter(c -> c.getCommand().equalsIgnoreCase(str)).findFirst().orElse(OTHER);
    }

}
