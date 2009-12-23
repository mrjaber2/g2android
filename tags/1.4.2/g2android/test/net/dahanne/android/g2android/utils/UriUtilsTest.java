package net.dahanne.android.g2android.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UriUtilsTest {
	@Test
	public void checkUriIsValidTest() {
		String url = "http://google.com";
		assertTrue(UriUtils.checkUrlIsValid(url));
		url = "https://google.com/test";
		assertTrue(UriUtils.checkUrlIsValid(url));
		url = "http://google.com:453/truc";
		assertTrue(UriUtils.checkUrlIsValid(url));
		url = "https://google.com:66/test";
		assertTrue(UriUtils.checkUrlIsValid(url));
		url = "badurl.net";
		assertFalse(UriUtils.checkUrlIsValid(url));
		url = "toto";
		assertFalse(UriUtils.checkUrlIsValid(url));

	}
}
