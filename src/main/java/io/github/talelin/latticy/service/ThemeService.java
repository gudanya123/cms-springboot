package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.ThemeSpuDTO;
import io.github.talelin.latticy.mapper.ThemeSpuMapper;
import io.github.talelin.latticy.model.SimplifySpuDO;
import io.github.talelin.latticy.model.ThemeDO;
import io.github.talelin.latticy.mapper.ThemeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.model.ThemeSpuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-07-30
 */
@Service
public class ThemeService extends ServiceImpl<ThemeMapper, ThemeDO> {

    @Autowired
    private ThemeMapper themeMapper;

    @Autowired
    private ThemeSpuMapper themeSpuMapper;

    public List<SimplifySpuDO> getSpus(Integer id){
        return themeMapper.getSpus(id);
    }


    public void createThemeSpu(ThemeSpuDTO dto){
        ThemeSpuDO themeSpuDO = new ThemeSpuDO();
        themeSpuDO.setThemeId(dto.getThemeId());
        themeSpuDO.setSpuId(dto.getSpuId());
        themeSpuMapper.insert(themeSpuDO);
    }

    public List<SimplifySpuDO> getSimplifySpus(Integer id){
        return themeSpuMapper.getSimplifySpus(id);
    }

}
