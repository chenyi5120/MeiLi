package com.chen.meili.util;

public class Utils {
	/**
	 * 
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public final static int convertToInt(String value, int defaultValue) {

		if (value == null || "".equals(value.trim())) {

			return defaultValue;
		}

		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			try {
				return Double.valueOf(value).intValue();
			} catch (Exception e1) {
				return defaultValue;
			}
		}
	}
}
