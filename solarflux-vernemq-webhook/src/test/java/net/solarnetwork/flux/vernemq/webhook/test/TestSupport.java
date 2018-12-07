
package net.solarnetwork.flux.vernemq.webhook.test;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

/**
 * Base class for general testing support.
 * 
 * @author matt
 */
public abstract class TestSupport {

  /** A class-level logger. */
  protected final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * Load a class-path relative resource.
   * 
   * @param resourceName
   *        the resource
   * @return the content
   * @throws RuntimeException
   *         if any {@link IOException} occurs
   */
  protected byte[] classResourceAsBytes(String resourceName) {
    try {
      return FileCopyUtils.copyToByteArray(getClass().getResourceAsStream(resourceName));
    } catch (IOException e) {
      throw new RuntimeException("Error loading class " + getClass().getSimpleName() + " resource ["
          + resourceName + "]: " + e.getMessage(), e);
    }
  }

}
