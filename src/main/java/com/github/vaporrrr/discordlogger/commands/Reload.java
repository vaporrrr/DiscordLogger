/*
 * DiscordLogger
 * Copyright 2022 (C) vaporrrr
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.vaporrrr.discordlogger.commands;

import com.github.vaporrrr.discordlogger.DiscordLogger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {
    private final DiscordLogger discordLogger;

    public Reload(DiscordLogger discordLogger) {
        this.discordLogger = discordLogger;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!commandSender.hasPermission("dl.admin.reload") && !commandSender.isOp()) {
            commandSender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use that command.");
            return true;
        }
        discordLogger.reloadConfig();
        discordLogger.reloadLogCommands();
        commandSender.sendMessage("Reloaded.");
        return true;
    }
}
