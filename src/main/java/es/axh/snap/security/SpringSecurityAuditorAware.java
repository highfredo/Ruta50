package es.axh.snap.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import es.axh.snap.config.Constants;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    public String getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentLogin();
        return (userName != null ? userName : Constants.SYSTEM_ACCOUNT);
    }
}
