/*
 * Copyright (c) 2008-2019, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.spring.security;

import com.hazelcast.config.GroupConfig;
import com.hazelcast.security.Credentials;
import com.hazelcast.security.ICredentialsFactory;
import com.hazelcast.security.UsernamePasswordCredentials;

import java.util.Properties;

public class DummyCredentialsFactory implements ICredentialsFactory {

    private GroupConfig groupConfig;

    @Override
    public void configure(GroupConfig groupConfig, Properties properties) {
        this.groupConfig = groupConfig;
    }

    @Override
    public Credentials newCredentials() {
        return new UsernamePasswordCredentials(groupConfig.getName(), groupConfig.getPassword());
    }

    @Override
    public void destroy() {
    }
}
