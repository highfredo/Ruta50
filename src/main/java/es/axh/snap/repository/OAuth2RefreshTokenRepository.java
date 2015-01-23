package es.axh.snap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.axh.snap.domain.security.OAuth2AuthenticationRefreshToken;

/**
 * Spring Data MongoDB repository for the OAuth2AuthenticationRefreshToken entity.
 */
public interface OAuth2RefreshTokenRepository extends MongoRepository<OAuth2AuthenticationRefreshToken, String> {

    public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId);
}
