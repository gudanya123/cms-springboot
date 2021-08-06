package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.CouponMapper;
import io.github.talelin.latticy.model.ActivityDO;
import io.github.talelin.latticy.mapper.ActivityMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.model.ActivityDetailDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-07-30
 */
@Service
public class ActivityService extends ServiceImpl<ActivityMapper, ActivityDO> implements IService<ActivityDO> {

    @Autowired
    private CouponMapper couponMapper;

    public ActivityDetailDO getDetailById(Integer id) {
        ActivityDO activityDO = this.getById(id);
        if (activityDO == null){
            throw new NotFoundException(90000);
        }
        List<Integer> coupons = couponMapper.getCouponsByActivityId(id);
        ActivityDetailDO activityDetail = new ActivityDetailDO();
        activityDetail.setCouponIds(coupons);
        BeanUtils.copyProperties(activityDO, activityDetail);
        return activityDetail;
    }
}
