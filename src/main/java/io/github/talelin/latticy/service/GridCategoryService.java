package io.github.talelin.latticy.service;

import io.github.talelin.autoconfigure.exception.ForbiddenException;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.GridCategoryDTO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.model.GridCategoryDO;
import io.github.talelin.latticy.mapper.GridCategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class GridCategoryService extends ServiceImpl<GridCategoryMapper, GridCategoryDO> {

    @Value("${sleeve.grid-category-maximum-quantity}")
    private int maximumQuality;

    @Autowired
    private CategoryMapper categoryMapper;

    public void createGridCategory(GridCategoryDTO dto){
        Integer count = this.getBaseMapper().selectCount(null);
        if(count >= maximumQuality){
            throw new ForbiddenException(50001);
        }
        CategoryDO categoryDO = categoryMapper.selectById(dto.getCategoryId());
        if(categoryDO == null){
            throw new NotFoundException(40000);
        }
        GridCategoryDO gridCategoryDO = new GridCategoryDO();
        BeanUtils.copyProperties(dto,gridCategoryDO);
        this.save(gridCategoryDO);
    }

    public void updateGridCategory(GridCategoryDTO dto,Integer id){
        GridCategoryDO gridCategoryDO = this.getById(id);
        if(gridCategoryDO == null){
            throw new NotFoundException(50000);
        }
        BeanUtils.copyProperties(dto,gridCategoryDO);
        this.updateById(gridCategoryDO);
    }

    public void deleteGridCategory(Integer id){
        GridCategoryDO gridCategoryDO = this.getBaseMapper().selectById(id);
        if(gridCategoryDO == null){
            throw new NotFoundException(50000);
        }
        this.getBaseMapper().deleteById(id);
    }

    public GridCategoryDO getGridCategory(Integer id){
        return this.getById(id);
    }
}
