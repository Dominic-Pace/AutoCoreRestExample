package org.autocore.javacore.endpoint;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.rest.Request;
import org.autocore.java.rest.uri.CoreEndpoint;
import org.autocore.javacore.model.User;

import java.io.IOException;

/**
 * (C) Copyright 2016 Dominic Pace (https://github.com/Dominic-Pace)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
public class UserEndpoint extends CoreEndpoint {

    public String userEndpoint;

    private CloseableHttpClient httpClient;
    private Request req;
    private Gson gson;

    public UserEndpoint(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        setUserEndpoint();
    }

    /**
     * Method used to Create a User.
     *
     * @param user object of the user.
     * @return Http Response
     */
    public HttpResponse createUser(User user) {
        gson = new Gson();
        req = new Request(httpClient, userEndpoint);

        try {
            HttpEntity stringEntity = new StringEntity(gson.toJson(user));
            return req.postRequest(stringEntity);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not create String Entity for the new "
                    + "user.");
        }
    }

    /**
     * Method used to set the user endpoint value.
     */
    private void setUserEndpoint() {
        this.userEndpoint = restEndpoint + "user";
    }

}
