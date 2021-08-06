package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.CouponDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-07-31
 */
@Repository
public interface CouponMapper extends BaseMapper<CouponDO> {

    List<Integer> getCouponsByActivityId(Integer id);

}
