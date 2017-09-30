package com.lxjr.sudadai.service.impl;

import com.lxjr.sudadai.dao.TagDAO;
import com.lxjr.sudadai.entity.Tag;
import com.lxjr.sudadai.service.ITagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tagService")
public class TagServiceImpl implements ITagService {

    @Resource
    private TagDAO tagDAO;

    /**
     * 获得所有标签
     * @return
     */
    @Override
    public List<Tag> queryAllTag() {
        return tagDAO.queryAllTag();
    }

    /**
     * 根据标签code获得数量
     * @param tagCode 标签code
     * @return
     */
    @Override
    public Integer getCountByTagCode(String tagCode) {
        return tagDAO.getCountByTagCode(tagCode);
    }

}
