package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerMapper extends BaseMapper<BannerDO> {
    /*
    * @Select("select * from banner")
    * @Insert()
    * @Delete()
    * @Update()
    * */
//    List<BannerDO> getBannerList();

}
