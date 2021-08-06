package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.ThemeSpuDO;
import io.github.talelin.latticy.mapper.ThemeSpuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-07-30
 */
@Service
public class ThemeSpuService extends ServiceImpl<ThemeSpuMapper, ThemeSpuDO> {

    @Autowired
    private  ThemeSpuMapper themeSpuMapper;

    public void deleteThemeSpu(Integer id){
        themeSpuMapper.deleteById(id);
    }
}
