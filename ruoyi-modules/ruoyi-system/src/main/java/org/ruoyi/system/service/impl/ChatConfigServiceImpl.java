package org.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruoyi.common.core.event.ConfigChangeEvent;
import org.ruoyi.common.core.service.ConfigService;
import org.ruoyi.common.core.utils.MapstructUtils;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.common.mybatis.core.page.PageQuery;
import org.ruoyi.common.mybatis.core.page.TableDataInfo;
import org.ruoyi.system.domain.ChatConfig;
import org.ruoyi.system.domain.bo.ChatConfigBo;
import org.ruoyi.system.domain.vo.ChatConfigVo;
import org.ruoyi.system.mapper.ChatConfigMapper;
import org.ruoyi.system.service.IChatConfigService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 对话配置信息
Service业务层处理
 *
 * @author Lion Li
 * @date 2024-04-13
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ChatConfigServiceImpl implements IChatConfigService, ConfigService {

    private final ChatConfigMapper baseMapper;

    private final ApplicationEventPublisher eventPublisher;

    /**
     * 查询对话配置信息

     */
    @Override
    public ChatConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询对话配置信息列表
     */
    @Override
    public TableDataInfo<ChatConfigVo> queryPageList(ChatConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ChatConfig> lqw = buildQueryWrapper(bo);
        Page<ChatConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询对话配置信息列表
     */
    @Override
    public List<ChatConfigVo> queryList(ChatConfigBo bo) {
        LambdaQueryWrapper<ChatConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ChatConfig> buildQueryWrapper(ChatConfigBo bo) {
        LambdaQueryWrapper<ChatConfig> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getCategory()), ChatConfig::getCategory, bo.getCategory());
        lqw.like(StringUtils.isNotBlank(bo.getConfigName()), ChatConfig::getConfigName, bo.getConfigName());
        lqw.eq(StringUtils.isNotBlank(bo.getConfigValue()), ChatConfig::getConfigValue, bo.getConfigValue());
        return lqw;
    }

    /**
     * 新增对话配置信息

     */
    @Override
    public Boolean insertByBo(ChatConfigBo bo) {
        ChatConfig add = MapstructUtils.convert(bo, ChatConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改对话配置信息

     */
    @Override
    public Boolean updateByBo(ChatConfigBo bo) {
        ChatConfig update = MapstructUtils.convert(bo, ChatConfig.class);
        validEntityBeforeSave(update);
        // 更新配置信息(类型区分)
        eventPublisher.publishEvent(new ConfigChangeEvent(this));
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ChatConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除对话配置信息

     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    /**
     * 根据配置类型和配置key获取值
     *
     * @param category
     * @param configKey
     * @return
     */
    @Override
    public String getConfigValue(String category,String configKey) {
        ChatConfigBo bo = new ChatConfigBo();
        bo.setCategory(category);
        bo.setConfigName(configKey);
        LambdaQueryWrapper<ChatConfig> lqw = buildQueryWrapper(bo);
        ChatConfigVo chatConfigVo = baseMapper.selectVoOne(lqw);
        if(chatConfigVo != null){
            return chatConfigVo.getConfigValue();
        }else {
            return "";
        }
    }

    /**
     * 根据配置类型和配置key获取值
     *
     * @param category
     * @return
     */
    @Override
    public List<ChatConfigVo> getSysConfigValue(String category) {
        ChatConfigBo bo = new ChatConfigBo();
        bo.setCategory(category);
        LambdaQueryWrapper<ChatConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

}
