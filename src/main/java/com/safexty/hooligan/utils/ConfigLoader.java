package com.safexty.hooligan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.safexty.hooligan.Hooligan;
import com.safexty.hooligan.utils.config.Config;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigLoader {

    private static Config config;

    public static void initialize() {
        var mapper = new ObjectMapper(new YAMLFactory());

        mapper.findAndRegisterModules();
        var file = new File("config.yml");
        try {
            if (!file.exists()) {
                LoggerUtils.warn("No config found ! Creating...");
                Files.copy(Hooligan.class.getResourceAsStream("/config.yml"), file.getAbsoluteFile().toPath());
                LoggerUtils.info("Done !");
            }
            LoggerUtils.info("Loading config...");
            config = mapper.readValue(file, Config.class);
        } catch (IOException e) {
            LoggerUtils.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Config getConfig() {
        return config;
    }

}
