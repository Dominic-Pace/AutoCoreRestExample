package org.autocore.java.model;

import org.autocore.java.commons.utils.StringUtils;

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
public class ModelGenerator {

    protected static User generateRandomUser() {
        return new User(Integer.valueOf(StringUtils.createRandomNumericValue(5)),
                StringUtils.createRandomAlphaNumeric(11),
                StringUtils.createRandomAlphabetic(),
                StringUtils.createRandomAlphabetic(),
                StringUtils.createRandomAlphaNumeric()
                + "@" + StringUtils.createRandomAlphabetic() + ".com",
                StringUtils.createRandomAlphaNumeric(),
                String.valueOf(StringUtils.createRandomNumericValue(10)),
                Integer.valueOf(StringUtils.createRandomNumericValue(1)));
    }
}
