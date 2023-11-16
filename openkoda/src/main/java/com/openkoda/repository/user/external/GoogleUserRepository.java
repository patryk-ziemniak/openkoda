/*
MIT License

Copyright (c) 2016-2023, Openkoda CDX Sp. z o.o. Sp. K. <openkoda.com>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice
shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR
A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.openkoda.repository.user.external;

import com.openkoda.core.security.HasSecurityRules;
import com.openkoda.model.authentication.GoogleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
/**
 * <p>GoogleUserRepository interface.</p>
 *
 * @author Arkadiusz Drysch (adrysch@stratoflow.com)
 *
 */
public interface GoogleUserRepository extends JpaRepository<GoogleUser, Long>, HasSecurityRules {

    /**
     * <p>findByGoogleId.</p>
     *
     * @param googleId a {@link java.lang.String} object.
     * @return a {@link com.openkoda.model.authentication.GoogleUser} object.
     */
    @PreAuthorize(CHECK_CAN_READ_GOOGLE_USER)
    GoogleUser findByGoogleId(String googleId);
}
