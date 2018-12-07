
package net.solarnetwork.flux.vernemq.webhook.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of VerneMQ hook types.
 * 
 * @author matt
 */
public enum HookType implements HookNames {

  AuthenticateOnRegister(AUTH_ON_REGISTER),

  AuthoriseOnSubscribe(AUTH_ON_SUBSCRIBE);

  /** The name of the HTTP header that is used to transmit the hook type. */
  public static final String HOOK_HEADER = "vernemq-hook";

  private String key;

  private HookType(String key) {
    this.key = key;
  }

  /**
   * Returns the {@code key} value.
   * 
   * @return the key
   */
  @JsonValue
  public String getKey() {
    return key;
  }

  /**
   * Get an enum from a key value.
   * 
   * @param key
   *        the key to get the enum for
   * @return the enum
   * @throws IllegalArgumentException
   *         if {@code key} is not valid
   */
  @JsonCreator
  public static HookType forKey(String key) {
    for (HookType hook : HookType.values()) {
      if (hook.key.equals(key)) {
        return hook;
      }
    }
    throw new IllegalArgumentException("HookType key value not supported: " + key);
  }

  public static String headerFilterValue(HookType type) {
    return HOOK_HEADER + "=" + type.key;
  }
}
