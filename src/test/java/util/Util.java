package util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class Util {

	/**
	 * Generates dynamic string of given length.
	 * 
	 * @param length
	 * @return
	 */
	public static String randomAlphanumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * Generates dynamic string of given length.
	 * 
	 * @param length
	 * @return
	 */
	public static String randomAlphabetic(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	/**
	 * Generates dynamic Number of given length.
	 * 
	 * @param length
	 * @return
	 */
	public static String randomNumeric(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * Generates dynamic Email of given length.
	 * 
	 * @param length
	 * @return
	 */
	public static String randomEmail(int length) {
		return RandomStringUtils.randomAlphanumeric(length) + "@gmail.com";
	}

	/**
	 * Check string contains Upper case letter or not
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isTextContainUpperCase(String text) {
		if (StringUtils.isBlank(text)) {
			return false;
		}
		return !text.equals(text.toLowerCase());
	}

	/**
	 * Check string contains Lower case letter or not
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isTextContainLowerCase(String text) {
		if (StringUtils.isBlank(text)) {
			return text.equals(text.toLowerCase());
		}
		return !text.equals(text.toUpperCase());
	}
}
