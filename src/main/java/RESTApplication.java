/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.core.Application;
import java.util.Set;


/**
 * Application to register the REST resource classes.
 *
 */
public class RESTApplication extends Application {

    private final Set<Object> resource;

    public RESTApplication(final Set<Object> resources) {
        super();
        resource = resources;

        // Swagger bootstrap
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Pravega Controller REST API");
        beanConfig.setDescription("Description");
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9797");
        beanConfig.setBasePath("");
        beanConfig.setResourcePackage("resourceImpl");
        beanConfig.setScan(true);

        // swagger json url: http://localhost:9797/swagger.json
        // since / is the context of
    }

    @Override
    public Set<Object> getSingletons() {
         return resource;
    }
}
