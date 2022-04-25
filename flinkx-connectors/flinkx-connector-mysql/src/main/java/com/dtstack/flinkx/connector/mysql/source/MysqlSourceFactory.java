/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flinkx.connector.mysql.source;

import com.dtstack.flinkx.conf.SyncConf;
import com.dtstack.flinkx.connector.jdbc.source.JdbcInputFormatBuilder;
import com.dtstack.flinkx.connector.jdbc.source.JdbcSourceFactory;
import com.dtstack.flinkx.connector.jdbc.util.JdbcUtil;
import com.dtstack.flinkx.connector.mysql.dialect.MysqlDialect;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.apache.commons.lang3.StringUtils;

/**
 * Date: 2021/04/12 Company: www.dtstack.com
 *
 * @author tudou
 */
public class MysqlSourceFactory extends JdbcSourceFactory {

    // 默认是Mysql流式拉取
    private static final int DEFAULT_FETCH_SIZE = Integer.MIN_VALUE;

    public MysqlSourceFactory(SyncConf syncConf, StreamExecutionEnvironment env) {
        super(syncConf, env, new MysqlDialect());
        // 避免result.next阻塞
        if (jdbcConf.isPolling()
                && StringUtils.isEmpty(jdbcConf.getStartLocation())
                && jdbcConf.getFetchSize() == 0) {
            jdbcConf.setFetchSize(1000);
        }
        JdbcUtil.putExtParam(jdbcConf);
    }

    @Override
    protected int getDefaultFetchSize() {
        return DEFAULT_FETCH_SIZE;
    }

    @Override
    protected JdbcInputFormatBuilder getBuilder() {
        return new JdbcInputFormatBuilder(new MysqlInputFormat());
    }
}