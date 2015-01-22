package es.axh.snap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.OAuth2AuthenticationAccessToken;

/**
 * Spring Data MongoDB repository for the OAuth2AuthenticationAccessToken entity.
 */
public interface OAuth2AccessTokenRepository extends MongoRepository<OAuth2AuthenticationAccessToken, String> {

    public OAuth2AuthenticationAccessToken findByTokenId(String tokenId);

    public OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken);

    public OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId);

    public List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName);

    public List<OAuth2AuthenticationAccessToken> findByClientId(String clientId);
}
