package org.autocore.javacore.testcases.user;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.rest.CoreTest;
import org.autocore.javacore.endpoint.UserEndpoint;
import org.autocore.javacore.model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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
public class CreateUserTest extends CoreTest {

    @Test(dataProvider = "CoreDataProvider")
    public void createUserTest(User user) {

        user.setId(28020);
        user.setUsername("dpace");
        user.setPassword("welcome1!");
        user.setFirstName("Dominic");
        user.setLastName("Pace");
        user.setEmail("dpace@nhpace.net");
        user.setPhone("Phone");
        user.setUserStatus(0);

        UserEndpoint userEndpoint = new UserEndpoint(httpClient);
        userEndpoint.createUser(user);
    }

    @AfterMethod
    public void cleanUp() {
        HttpDelete delete = new HttpDelete("http://petstore.swagger.io/v2/user/dpace");

        try {
            HttpResponse response = httpClient.execute(delete);

            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not create String Entity for the new "
                    + "user.");
        }

    }
}
