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

package com.github.vaporrrr.discordlogger.listeners;

import com.github.vaporrrr.discordlogger.DiscordLogger;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordReadyEvent;
import github.scarsz.discordsrv.util.DiscordUtil;

public class DiscordSRVListener {
    private final DiscordLogger discordLogger;

    public DiscordSRVListener(DiscordLogger discordLogger) {
        this.discordLogger = discordLogger;
    }

    @Subscribe
    public void discordReadyEvent(DiscordReadyEvent event) {
        discordLogger.getLogger().info("Discord ready!");
        discordLogger.getServer().getPluginManager().registerEvents(new BukkitListener(discordLogger, DiscordUtil.getJda()), discordLogger);
    }
}
