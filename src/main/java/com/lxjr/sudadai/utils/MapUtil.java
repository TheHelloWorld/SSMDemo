package com.lxjr.sudadai.utils;

import com.lxjr.sudadai.bean.TargetSort;

import java.util.*;

public class MapUtil {

	/**
	 * 按value降序排列map
	 *
	 * @param map 需排序map
	 * @return
	 */
	public static Map<Long, TargetSort> sortMap(Map<Long, TargetSort> map) {

		// 降序比较器
		Comparator<Map.Entry<Long, TargetSort>> valueComparator = new Comparator<Map.Entry<Long, TargetSort>>() {
			@Override
			public int compare(Map.Entry<Long, TargetSort> o1, Map.Entry<Long, TargetSort> o2) {
				return o2.getValue().getWeight() - o1.getValue().getWeight();
			}
		};
		// map转换成list进行排序
		List<Map.Entry<Long, TargetSort>> list = new ArrayList<>(map.entrySet());
		// 排序
		Collections.sort(list, valueComparator);

		Map<Long, TargetSort> newMap = new LinkedHashMap<>();
		for (int i = 0; i < list.size(); i++) {
			newMap.put(list.get(i).getKey(), list.get(i).getValue());
		}
		return newMap;
	}

}
