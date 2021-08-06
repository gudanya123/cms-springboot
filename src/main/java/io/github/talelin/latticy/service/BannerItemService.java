package io.github.talelin.latticy.service;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.BannerItemDTO;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-07-30
 */
@Service
public class BannerItemService extends ServiceImpl<BannerItemMapper, BannerItemDO> {
    public void update(BannerItemDTO dto,Integer id){
        BannerItemDO bannerItemDO = this.getById(id);
        if(bannerItemDO == null){
            throw new NotFoundException(20001);
        }
        BeanUtils.copyProperties(dto,bannerItemDO);
        this.updateById(bannerItemDO);
    }

    public void delete(Integer id){
        BannerItemDO bannerItemDO = this.getById(id);
        if(bannerItemDO == null){
            throw new NotFoundException(20001);
        }
        this.getBaseMapper().deleteById(id);
    }

}
