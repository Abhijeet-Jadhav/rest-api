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

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import resourceImpl.AsyncResourceImpl;
import resourceImpl.ResourceImpl;
import resourceImpl.SecuredResource;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;


/**
 * Netty REST server implementation.
 */
@Slf4j
public class RESTServer {

    final static String REST_SERVER_IP = "localhost";
    final static int REST_SERVER_PORT = 9797;
    public static final void start() {

        Set<Object> resourceObjs = new HashSet<Object>();
        resourceObjs.add(new ResourceImpl());
        resourceObjs.add(new AsyncResourceImpl());
        resourceObjs.add(new PoweredByResponseFilter()); // RESPONSE FILTER
        resourceObjs.add(new LoggingFilter()); // REQUEST FILTER

        resourceObjs.add(new SecuredResource());
        resourceObjs.add(new SecurityFilter());

        RESTApplication restApplication = new RESTApplication(resourceObjs);

        String serverURI = "http://" + REST_SERVER_IP + "/";
        URI baseUri = UriBuilder.fromUri(serverURI).port(REST_SERVER_PORT).build();
        ResourceConfig resourceConfig = ResourceConfig.forApplication(restApplication);
        Channel server = null;
        try {
            server = NettyHttpContainerProvider.createServer(baseUri, resourceConfig, true);
        } catch (Exception e) {
            System.out.println("Error starting Rest Service {}"+ e);
            server.close();
        }
    }

}
