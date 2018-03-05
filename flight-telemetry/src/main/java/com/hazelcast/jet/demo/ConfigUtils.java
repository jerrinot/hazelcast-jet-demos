package com.hazelcast.jet.demo;

import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.jet.config.JetConfig;

public class ConfigUtils {
    public static JetConfig buildConfig() {
        JetConfig config = new JetConfig();
        config.getHazelcastConfig()
                .getMapEventJournalConfig(FlightTelemetry.BUFFER_MAP)
                .setCapacity(100_000)
                .setEnabled(true);

        MaxSizeConfig maxSizeConfig = config.getHazelcastConfig().getMapConfig(FlightTelemetry.BUFFER_MAP).getMaxSizeConfig();
        maxSizeConfig.setSize(1000).setMaxSizePolicy(MaxSizeConfig.MaxSizePolicy.PER_NODE);

        return config;
    }
}
