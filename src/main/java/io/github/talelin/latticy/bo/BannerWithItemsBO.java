package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class BannerWithItemsBO {
    private Integer id;

    private String name;

    private  String description;

    private String title;

    private String img;

    List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO,List<BannerItemDO> items){
        BeanUtils.copyProperties(bannerDO,this);
        this.items = items;
    }
}
