package com.eze.ai.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;





public final class CommonUtility {

	private CommonUtility() {

	}

	public static boolean chkNull(Object value) {
		if (value == null) {
			return true;
		}
		String strValue = null;
		if (value instanceof Integer) {
			strValue = value.toString();
		} else if (value instanceof Long) {
			strValue = value.toString();
		} else if (value instanceof Double) {
			strValue = value.toString();
		} else if (value instanceof String) {
			strValue = value.toString();
		} else if (value instanceof List) {
			List list = (List) value;
			return (list.isEmpty());
		} else if (value instanceof Map) {
			Map map = (Map) value;
			return (map.isEmpty());
		} else if (value instanceof Set) {
			Set set = (Set) value;
			return (set.isEmpty());
		}
		// strValue will never null in or condition...removed null check
		if (strValue == null || "undefined".equals(strValue.trim()) || "null".equals(strValue.trim())
				|| "-1".equals(strValue.trim()) || StringUtils.isEmpty(strValue.trim())) {
			return true;
		}
		return false;
	}

	public static String incrementDateByNumOfMin(Date date, String formatString, int numOfHour)
			throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		if (date != null && !chkNull(formatString)) {
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(sdf.format(date)));
			} catch (ParseException e) {
			}
			c.add(Calendar.MINUTE, numOfHour); // number of days to deduct
			return sdf.format(c.getTime());
		} else {
			return null;
		}
	}

	public static String decrementDateByNumOfMin(Date date, String formatString, int noOfMin)
			throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		if (date != null && !chkNull(formatString)) {
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(sdf.format(date)));
			} catch (ParseException e) {
			}
			c.add(Calendar.MINUTE, -noOfMin); // number of min to deduct
			return sdf.format(c.getTime());
		} else {
			return null;
		}
	}
}
