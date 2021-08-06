package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.*;
import io.github.talelin.latticy.dto.BannerItemDTO;
import io.github.talelin.latticy.service.BannerItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Positive;

/**
 * @author generator@TaleLin
 * @since 2021-07-30
 */
@RestController
@RequestMapping("/v1/banner-item")
@Validated
@PermissionModule("BannerItem")
public class BannerItemController {
    @Autowired
    private BannerItemService bannerItemService;

    @PostMapping("")
    @PermissionMeta(value = "新增BannerItem")
    @GroupRequired
    public CreatedVO create(@RequestBody @Validated BannerItemDTO dto) {
        BannerItemDO bannerItemDO = new BannerItemDO();
        BeanUtils.copyProperties(dto,bannerItemDO);
        bannerItemService.save(bannerItemDO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    @PermissionMeta(value = "修改BannerItem")
    @GroupRequired
    public UpdatedVO update(@RequestBody @Validated BannerItemDTO dto,
                            @PathVariable @Positive(message = "{id.positive}") Integer id) {
        bannerItemService.update(dto,id);
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    @PermissionMeta(value = "删除BannerItem")
    @GroupRequired
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        bannerItemService.delete(id);
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    @LoginRequired
    public BannerItemDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        BannerItemDO bannerItem = bannerItemService.getById(id);
        if (bannerItem == null) {
            throw new NotFoundException(20001);
        }
        return bannerItem;
    }


}
