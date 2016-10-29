package org.autocore.java.endpoint;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.rest.uri.CoreEndpoint;
import org.autocore.java.model.User;
import org.autocore.java.rest.utils.Request;

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
    public HttpEntity stringEntity;

    private Gson gson;

    public UserEndpoint(CloseableHttpClient httpClient) {
        super(httpClient);
        this.httpClient = httpClient;
        setUserEndpoint();
    }

    public UserEndpoint(CloseableHttpClient httpClient, HttpEntity stringEntity) {
        super(httpClient);
        this.httpClient = httpClient;
        this.stringEntity = stringEntity;
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
            stringEntity = new StringEntity(gson.toJson(user));
            return req.postRequest(stringEntity);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not create String Entity for the new "
                    + "user.");
        }
    }

    /**
     * Method used to Delete a User.
     *
     * @param username of the user to delete.
     * @return Http Response
     */
    public HttpResponse deleteUser(String username) {
        delete = new HttpDelete(userEndpoint + "/" + username);

        try {
            return httpClient.execute(delete);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not delete the user" + username);
        }
    }

    /**
     * Method used to Update a User.
     *
     * @param user object of the user to update.
     * @return Http Response
     */
    public HttpResponse updateUser(User user) {
        put = new HttpPut(userEndpoint + "/" + user.getUsername());

        try {
            stringEntity = new StringEntity(gson.toJson(user));

            return req.putRequest(stringEntity);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not update the user"
                    + user.getUsername());
        }
    }

    /**
     * Method used to set the user endpoint value.
     */
    private void setUserEndpoint() {
        this.userEndpoint = restEndpoint + "user";
    }

}
