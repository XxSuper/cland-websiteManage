package com.maiyajf.base.utils.base;

import java.util.*;
import java.util.Map.Entry;

public class MapUtils {

	/** 数值字典排序
	 * @param ary
	 * @return
	 */
	public static String sortFileds(Object[] ary) {
		Arrays.sort(ary, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				String[] temp = { String.valueOf(o1).toLowerCase(), String.valueOf(o2).toLowerCase() };
				Arrays.sort(temp);

				if (String.valueOf(o1).equalsIgnoreCase(temp[0])) {
					return -1;
				} else if (temp[0].equalsIgnoreCase(temp[1])) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		return Arrays.toString(ary);
	}

	/** map 字典排序
	 * @param map
	 * @return
	 */
	public static String sortMapKey(Map<String, String> map) {

		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}

		});

		String str = "";
		for (Entry<String, String> m : list) {
			str += m.getKey() + m.getValue();
		}
		return str;
	}


	/**
	 * map 取值
	 *
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getValueFormMap(Map map,String key) {
		String value = map.get(key) == null ? "" : map.get(key).toString();
		return value;
	}
}
