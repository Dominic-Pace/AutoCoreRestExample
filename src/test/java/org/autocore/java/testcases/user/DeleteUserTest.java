package org.autocore.java.testcases.user;

import org.autocore.java.endpoint.UserEndpoint;
import org.autocore.java.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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
public class DeleteUserTest extends CoreUserTest {

    @BeforeTest()
    public void testSetup() {
        userEndpoint = new UserEndpoint(httpClient);

        user = new User();

        userEndpoint.createUser(user);
    }

    @Test
    public void deleteUserTest() {
        UserEndpoint userEndpoint = new UserEndpoint(httpClient);

        res = userEndpoint.deleteUser(friendlyName);

        Assert.assertTrue(res.getStatusLine().getStatusCode() == 200);
    }
}
