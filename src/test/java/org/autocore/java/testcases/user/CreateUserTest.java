package org.autocore.java.testcases.user;

import org.autocore.java.endpoint.UserEndpoint;
import org.autocore.java.rest.CoreTest;
import org.autocore.java.model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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

    private String username;

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

        this.username = user.getUsername();

        UserEndpoint userEndpoint = new UserEndpoint(httpClient);
        res = userEndpoint.createUser(user);

        userEndpoint.assertValidResponse(res);
    }

    @AfterMethod
    public void cleanUp() {
        UserEndpoint userEndpoint = new UserEndpoint(httpClient);

        res = userEndpoint.deleteUser(username);
        userEndpoint.assertValidResponse(res);
    }
}
