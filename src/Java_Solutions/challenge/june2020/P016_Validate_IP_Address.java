/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P016_Validate_IP_Address {
	private static final String INVALID = "Neither";
	private static final String IP_V4 = "IPv4";
	private static final String IP_V6 = "IPv6";
	private static final String HEX_LETTER = "abcdef";

	public static void main(String[] args) {
		P016_Validate_IP_Address solution = new P016_Validate_IP_Address();
		String input = "172.16.254.1";
		String result = solution.validIPAddress(input);
		System.out.println(result); // IPv4

		input = "192.0.0.1";
		result = solution.validIPAddress(input);
		System.out.println(result); // IPv4

		input = "2001:0db8:85a3:0:0:8A2E:0370:7334";
		result = solution.validIPAddress(input);
		System.out.println(result); // IPv6

		input = "256.256.256.256";
		result = solution.validIPAddress(input);
		System.out.println(result); // Neither

		input = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		result = solution.validIPAddress(input);
		System.out.println(result); // IPv6

	}

	public String validIPAddress(String IP) {
		if (IP.contains(".")) {
			return validIPv4Address(IP);
		} else if (IP.contains(":")) {
			return validIPv6Address(IP);
		}
		return INVALID;
	}

	private String validIPv4Address(String IP) {
		if (IP.charAt(IP.length() - 1) == '.') {
			return INVALID;
		}

		String[] split = IP.split("\\.");

		if (split.length != 4) {
			return INVALID;
		}

		for (int i = 0; i < split.length; i++) {
			String item = split[i];

			if (item.length() == 0 || item.length() > 3) {
				return INVALID;
			}

			if (!isDigits(item)) {
				return INVALID;
			}
			if (item.length() > 1 && item.charAt(0) == '0') {
				return INVALID;
			}
			int value = Integer.valueOf(item);
			if (value < 0 || value > 255) {
				return INVALID;
			}
		}
		return IP_V4;
	}

	private String validIPv6Address(String IP) {

		if (IP.charAt(IP.length() - 1) == ':') {
			return INVALID;
		}

		String[] split = IP.split(":");

		if (split.length != 8) {
			return INVALID;
		}
		for (int i = 0; i < split.length; i++) {
			String item = split[i];
			if (item.length() > 4) {
				return INVALID;
			}
			if (!isAlphaNum(item)) {
				return INVALID;
			}
			item = item.toLowerCase();
			item = item.replaceAll("^\\s+", "");
			if (item == "") {
				item = "0";
			}
			for (int j = 0; j < item.length(); j++) {
				char ch = item.charAt(j);
				if (!(Character.isDigit(ch) || HEX_LETTER.indexOf(ch) != -1)) {
					return INVALID;
				}
			}
		}
		return IP_V6;
	}

	private boolean isDigits(String d) {
		if (d == null || d.length() == 0) {
			return false;
		}
		for (int i = 0; i < d.length(); i++) {
			if (!Character.isDigit(d.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isAlphaNum(String d) {
		if (d == null || d.length() == 0) {
			return false;
		}
		for (int i = 0; i < d.length(); i++) {
			if (!(Character.isLetterOrDigit(d.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

}
