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

import advanced.jaxrs.MyApp;
import advanced.jaxrs.MyResource;
import io.netty.channel.Channel;
//import lombok.extern.slf4j.Slf4j;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
//import lombok.extern.slf4j.Slf4j;
import model.TestService;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import resourceImpl.*;
import tut.messenger.resources.MessageResource;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;


/**
 * Netty REST server implementation.
 */

public class RESTServer {

    final static String REST_SERVER_IP = "localhost";
    final static int REST_SERVER_PORT = 9797;
    TestService testService = new TestService(3);

    public static final void start(TestService testService) {

        Set<Object> resourceObjs = new HashSet<Object>();
        resourceObjs.add(new ResourceImpl()); // basic calls - synchronous

        resourceObjs.add(new AsyncResourceImpl()); // asynchronous calls

        //resourceObjs.add(new PoweredByResponseFilter()); // RESPONSE FILTER
        //resourceObjs.add(new LoggingFilter()); // REQUEST FILTER

        //resourceObjs.add(new SecuredResource());
        //resourceObjs.add(new SecurityFilter()); // for authentication

        /*System.setProperty(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, "false");
        System.setProperty(ServerProperties.FEATURE_AUTO_DISCOVERY_DISABLE, "false");
        System.setProperty(ServerProperties.BV_FEATURE_DISABLE, "false");
*/
        /*System.out.println("CommonProperties "+ System.setProperty(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, "false"));
        System.out.println("ServerProperties AUTO "+ System.setProperty(ServerProperties.FEATURE_AUTO_DISCOVERY_DISABLE, "false"));
        System.out.println("ServerProperties BV "+ System.setProperty(ServerProperties.BV_FEATURE_DISABLE, "false"));
*/
        System.out.println("CommonProperties "+ System.getProperty(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE));

        resourceObjs.add(new ListImpl()); // pagination

        resourceObjs.add(new MessageResource()); // messenger tutorial

        resourceObjs.add(new MyResource());

        resourceObjs.add(new ApiListingResource()); //swagger
        resourceObjs.add(new SwaggerSerializers()); //swagger

        resourceObjs.add(new AsyncResourceImpl_2()); // CompletableFuture and asynchronous calls

        resourceObjs.add(new TestResource(testService)); // mockito tested
        resourceObjs.add(new AsyncTestResource(testService)); // Async api mockito testing

        RESTApplication restApplication = new RESTApplication(resourceObjs);

        String serverURI = "http://" + REST_SERVER_IP + "/";
        URI baseUri = UriBuilder.fromUri(serverURI).port(REST_SERVER_PORT).build();
        ResourceConfig resourceConfig = ResourceConfig.forApplication(restApplication);
        resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

                //.property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);


        Channel server = null;
        try {
            server = NettyHttpContainerProvider.createServer(baseUri, resourceConfig, true);
        } catch (Exception e) {
            System.out.println("Error starting Rest Service "+ e);
            server.close();
        }
    }

}
