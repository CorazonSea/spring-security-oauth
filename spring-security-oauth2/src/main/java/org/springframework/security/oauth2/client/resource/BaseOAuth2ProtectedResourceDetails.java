package org.springframework.security.oauth2.client.resource;

import java.util.List;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.StringUtils;

/**
 * @author Ryan Heaton
 * @author Dave Syer
 */
public class BaseOAuth2ProtectedResourceDetails implements OAuth2ProtectedResourceDetails {

  private String id;
  private String grantType = "unsupported";
  private String clientId;
  private String accessTokenUri;
  private List<String> scope;
  private String clientSecret;
  private String clientAuthenticationScheme = ClientAuthenticationScheme.http_basic.toString();
  private AuthenticationScheme authorizationScheme = AuthenticationScheme.header;
  private String tokenName = OAuth2AccessToken.BEARER_TYPE_PARAMETER;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getAccessTokenUri() {
    return accessTokenUri;
  }

  public void setAccessTokenUri(String accessTokenUri) {
    this.accessTokenUri = accessTokenUri;
  }

  public boolean isScoped() {
    return scope!=null && !scope.isEmpty();
  }

  public List<String> getScope() {
    return scope;
  }

  public void setScope(List<String> scope) {
    this.scope = scope;
  }

  public boolean isAuthenticationRequired() {
    return StringUtils.hasText(clientId);
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getClientAuthenticationScheme() {
    return clientAuthenticationScheme;
  }

  // TODO: use an enum (share with #setAuthenticationScheme())
  public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
    this.clientAuthenticationScheme = clientAuthenticationScheme;
  }

  public AuthenticationScheme getAuthenticationScheme() {
    return authorizationScheme;
  }

  public void setAuthenticationScheme(AuthenticationScheme authorizationScheme) {
    this.authorizationScheme = authorizationScheme;
  }

  public String getTokenName() {
    return tokenName;
  }

  public void setTokenName(String tokenName) {
    this.tokenName = tokenName;
  }

  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseOAuth2ProtectedResourceDetails)) {
      return false;
    }

    BaseOAuth2ProtectedResourceDetails that = (BaseOAuth2ProtectedResourceDetails) o;
    return !(id != null ? !id.equals(that.id) : that.id != null);

  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

}
