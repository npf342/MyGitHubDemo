package com.kgc.dsj02.Util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class HBaseConfigUtil {
    public static Configuration getHBaseConfiguration(){
        Configuration configuration=HBaseConfiguration.create();
        configuration.addResource(new Path("/etc/hbase/conf/hbase-site.xml"));
        configuration.addResource(new Path("/etc/hadoop/conf/core-site.xml"));
        return configuration;
    }
}
