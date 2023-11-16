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

package com.openkoda.core.configuration;

import com.openkoda.core.form.FrontendMappingDefinition;
import com.openkoda.form.RegisterUserForm;
import com.openkoda.service.captcha.ValidationLevel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration used by ReCaptcha integration
 */
@Configuration
public class ReCaptchaConfiguration {


    //public key used in recaptcha box
    @Value("${recaptcha.site-key:}")
    public String siteKey;

    //private key used to verify captcha responses
    @Value("${recaptcha.secret-key:}")
    public String secretKey;

    //level of strictness while validating captcha
    @Value("${recaptcha.validation:normal}")
    public ValidationLevel validationLevel;

    @PostConstruct
    public void init() {
        FrontendMappingDefinition.siteKey = siteKey;
        RegisterUserForm.siteKey = siteKey;
    }

}
