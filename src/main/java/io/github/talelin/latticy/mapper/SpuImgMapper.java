package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SpuImgDO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-05-27
 */
public interface SpuImgMapper extends BaseMapper<SpuImgDO> {

    /**
     * 物理删除spu轮播图
     * @param spuId Integer
     */
    void hardDeleteImgsBySpuId(@Param("spuId") Integer spuId);

}
