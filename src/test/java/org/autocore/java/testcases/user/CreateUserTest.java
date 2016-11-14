package org.autocore.java.testcases.user;

import org.autocore.java.endpoint.UserEndpoint;
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
public class CreateUserTest extends CoreUserTest {

    @Test(dataProvider = "CoreDataProvider")
    public void createUserTest(User user) {

        this.friendlyName = user.getUsername();

        UserEndpoint userEndpoint = new UserEndpoint(httpClient);
        res = userEndpoint.createUser(user);

        userEndpoint.assertValidResponse(res);
    }

    @AfterMethod
    public void cleanUp() {
        UserEndpoint userEndpoint = new UserEndpoint(httpClient);

        res = userEndpoint.deleteUser(friendlyName);
        userEndpoint.assertValidResponse(res);
    }
}
