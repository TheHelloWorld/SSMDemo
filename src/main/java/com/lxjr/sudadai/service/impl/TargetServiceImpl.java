package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.bean.TargetSort;
import com.lxjr.sudadai.dao.TargetDAO;
import com.lxjr.sudadai.dao.TargetTagDAO;
import com.lxjr.sudadai.dao.UserTagDAO;
import com.lxjr.sudadai.entity.Target;
import com.lxjr.sudadai.entity.TargetTag;
import com.lxjr.sudadai.entity.UserTag;
import com.lxjr.sudadai.enums.WeightEnum;
import com.lxjr.sudadai.service.ITargetService;
import com.lxjr.sudadai.utils.MapUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("targetService")
public class TargetServiceImpl implements ITargetService {

	private static final Logger logger = LoggerFactory.getLogger(TargetServiceImpl.class);

	@Resource
	private TargetDAO targetDAO;

	@Resource
	private UserTagDAO userTagDAO;

	@Resource
	private TargetTagDAO targetTagDAO;

	/**
	 * 获得默认展示平台list
	 *
	 * @param source    用户来源
	 * @param sourceUrl 来源url
	 * @return
	 */
	@Override
	public List<Target> queryDefaultTarget(String source, String sourceUrl) {
		List<TargetTag> targetTagList = getTargetTagList();
		return matchingChannel(source, sourceUrl, getTargetList(targetTagList));
	}

	/**
	 * 按用户标签对平台进行排序
	 *
	 * @param userId 用户Id
	 * @return
	 */
	@Override
	public List<Target> queryTargetByUserId(Long userId, String source, String sourceUrl) {
		List<UserTag> userTagList = userTagDAO.queryUserTagsByUserId(userId);
		List<TargetTag> targetTagList = getTargetTagList();
		List<Target> list = getTargetList(targetTagList);

		// 若用户没有标签则直接返回所有平台
		if (userTagList == null || userTagList.isEmpty()) {
			logger.warn("user tag is null");
			return list;
		}

		// 获得权重Map
		Map<Integer, Integer> weightMap = WeightEnum.getValueMap();
		Map<Long, TargetSort> sortMap = new HashMap<>();
		// 初始化排序map
		initSortMap(sortMap, list);

		for (UserTag userTag : userTagList) {
			for (TargetTag targetTag : targetTagList) {
				// 如果用户标签匹配平台标签
				if (userTag.getTagCode().equals(targetTag.getTagCode())) {
					addWeight(sortMap, targetTag.getTargetId(), weightMap.get(userTag.getSelectOrder()));
				}
			}
		}

		// 按权重进行排序
		sortMap = MapUtil.sortMap(sortMap);

		// 返回有序list
		List<Target> returnList = new LinkedList<>();

		for (Map.Entry<Long, TargetSort> entry : sortMap.entrySet()) {
			returnList.add(entry.getValue().getTarget());
		}

		return matchingChannel(source, sourceUrl, returnList);
	}

	/**
	 * 获得所有平台
	 *
	 * @return
	 */
	@Override
	public List<Target> queryAllTarget() {
		return targetDAO.queryAllTarget();
	}

	/**
	 * 根据平台Id获得平台信息
	 *
	 * @param targetId 平台Id
	 * @return
	 */
	@Override
	public Target getTargetById(Long targetId) {
		return targetDAO.queryTargetById(targetId);
	}


	/**
	 * 根据上游渠道确认下游渠道不显示的项
	 *
	 * @param source     上游渠道
	 * @param sourceUrl  url
	 * @param targetList 排序后平台list
	 * @return
	 */
	private List<Target> matchingChannel(String source, String sourceUrl, List<Target> targetList) {

		List<Integer> list = new ArrayList<>();
		if (StringUtils.isBlank(source)) {
			return targetList;
		}
		if (source.contains("beta") || source.contains("beta2") || source.contains("tianshen")) {
			list.add(0);
			list.add(1);
			list.add(6);
			list.add(9);
			list.add(10);
			list.add(11);
			list.add(13);
			list.add(14);
			list.add(15);
			list.add(16);
			list.add(20);
			list.add(22);
			list.add(23);
			list.add(24);
			list.add(25);
			list.add(26);
			list.add(27);
			list.add(28);
		} else if (source.contains("ljq")) {
			list.add(0);
			list.add(1);
			list.add(6);
			list.add(9);
			list.add(11);
			list.add(13);
			list.add(14);
			list.add(15);
			list.add(16);
			list.add(20);
			list.add(22);
			list.add(26);
			list.add(27);
			list.add(28);
		} else if (source.contains("jiean")) {
			if (sourceUrl.contains("dingdangdai")) {
				list.add(0);
				list.add(28);
			} else if (sourceUrl.contains("yirendai")) {
				list.add(13);
			} else if (sourceUrl.contains("wanka")) {
				list.add(16);
			} else if (sourceUrl.contains("jiexin")) {
				list.add(22);
			}

		} else if (source.contains("xiaoxinyong")) {
			list.add(15);
			list.add(16);
			list.add(18);
			list.add(20);
			list.add(22);
			list.add(26);
			list.add(27);
		} else if (source.contains("shandian")) {
			if (sourceUrl.contains("yirendai")) {
				list.add(13);
			} else if (sourceUrl.contains("dingdangdai")) {
				list.add(0);
				list.add(28);
			} else if (sourceUrl.contains("xianhuahua")) {
				list.add(9);
			}
		} else if (source.contains("dingdangdai") || source.contains("wanka")) {
			list.add(2);
			list.add(11);
			list.add(13);
			list.add(22);
			list.add(26);
			list.add(27);
		} else if (source.contains("qzzb")) {
			list.add(0);
			list.add(1);
			list.add(6);
			list.add(10);
			list.add(11);
			list.add(13);
			list.add(14);
			list.add(15);
			list.add(16);
			list.add(20);
			list.add(22);
			list.add(26);
			list.add(27);
			list.add(28);
		} else if (source.contains("hongchuang")) {
			if (sourceUrl.contains("yirendai")) {
				list.add(13);
				list.add(20);
				list.add(22);
				list.add(26);
				list.add(27);
			} else if (sourceUrl.contains("dingdangdai")) {
				list.add(6);
				list.add(20);
				list.add(22);
				list.add(26);
				list.add(27);
			} else {
				list.add(20);
				list.add(22);
				list.add(26);
				list.add(27);
			}
		} else {
			source = "or001";
			list.add(0);
			list.add(1);
			list.add(6);
			list.add(9);
			list.add(10);
			list.add(11);
			list.add(13);
			list.add(14);
			list.add(15);
			list.add(16);
			list.add(20);
			list.add(22);
			list.add(26);
			list.add(27);
			list.add(28);
		}

		List<Target> resultList = new ArrayList<>();
		for (Target target : targetList) {
			int targetId = target.getId().intValue();
			for (Integer id : list) {
				if (id == targetId) {
					resultList.add(target);
					break;
				}
			}

		}
		return resultList;
	}


	/**
	 * 获得所有平台标签
	 *
	 * @return
	 */
	private List<TargetTag> getTargetTagList() {
		return targetTagDAO.queryAllTargetTag();
	}

	/**
	 * 获得完整列表list
	 *
	 * @return
	 */
	private List<Target> getTargetList(List<TargetTag> targetTagList) {
		String hql = "from Target where targetStatus = 1 order by defaultTargetOrder asc";
		// 获得所有可用的平台
		List<Target> list = targetDAO.queryAllTarget();

		if (list == null || list.isEmpty()) {
			throw new RuntimeException("标签为空");
		}

		if (targetTagList == null || targetTagList.isEmpty()) {
			throw new RuntimeException("平台标签为空");
		}

		for (Target target : list) {
			// 当前平台是否有标签标志位
			boolean flag = true;
			for (TargetTag targetTag : targetTagList) {
				if (target.getId().equals(targetTag.getTargetId())) {
					String tags = target.getTags();
					if (tags != null) {
						tags += ";" + targetTag.getTagContext();
					} else {
						tags = targetTag.getTagContext();
					}
					target.setTags(tags);
					flag = false;
				}
			}
			// 如果当前平台没有标签
			if (flag) {
				target.setTags("");
			}
		}
		return list;
	}

	/**
	 * 初始化排序map
	 *
	 * @param map        排序map
	 * @param targetList 可用平台list
	 */
	private void initSortMap(Map<Long, TargetSort> map, List<Target> targetList) {
		for (Target target : targetList) {
			TargetSort targetSort = new TargetSort();
			targetSort.setTarget(target);
			// 初始化所有平台权重为0
			targetSort.setWeight(0);
			map.put(target.getId(), targetSort);
		}
	}

	/**
	 * 计算权重
	 *
	 * @param map      排序map
	 * @param targetId 平台Id
	 * @param weight   权重
	 */
	private void addWeight(Map<Long, TargetSort> map, Long targetId, Integer weight) {
		// 如果当前平台可用
		if (map.containsKey(targetId)) {
			int nowWeight = map.get(targetId).getWeight() + weight;
			map.get(targetId).setWeight(nowWeight);
		}
	}
}
